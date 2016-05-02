package edu.uchicago.cs.ucare.cassandra.gms;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Murmur3Partitioner;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.gms.EndpointState;
import org.apache.cassandra.gms.GossipDigestSyn;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.net.MessageIn;
import org.apache.cassandra.net.MessageOut;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.CassandraDaemon;
import org.apache.cassandra.service.StorageService;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WholeClusterSimulator {

    public static final Set<InetAddress> seeds = new HashSet<InetAddress>();
    public static GossiperStubGroup stubGroup;
    
    public static int numStubs;
    public static final int QUARANTINE_DELAY = 10000;

    public static final AtomicInteger idGen = new AtomicInteger(0);
    
    private static Timer[] timers;
    private static MyGossiperTask[] tasks;
    private static Random random = new Random();
    
    private static Logger logger = LoggerFactory.getLogger(ScaleSimulator.class);
    
    public static Map<InetAddress, ConcurrentLinkedQueue<MessageIn<?>>> msgQueues = new HashMap<InetAddress, ConcurrentLinkedQueue<MessageIn<?>>>();
    public static ScheduledExecutorService resumeProcessors;
    public static Map<InetAddress, AtomicBoolean> isProcessing;
    public static Map<InetAddress, Boolean> isStarted = new HashMap<InetAddress, Boolean>();
    public static Map<InetAddress, Integer> processCount = new HashMap<InetAddress, Integer>();
    
    static
    {
        initLog4j();
        try {
            seeds.add(InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static void initLog4j()
    {
        String config = System.getProperty("log4j.configuration", "log4j-server.properties");
        URL configLocation = null;
        try
        {
            // try loading from a physical location first.
            configLocation = new URL(config);
        }
        catch (MalformedURLException ex)
        {
            // then try loading from the classpath.
            configLocation = CassandraDaemon.class.getClassLoader().getResource(config);
        }

        if (configLocation == null)
            throw new RuntimeException("Couldn't figure out log4j configuration: "+ config);

        // Now convert URL to a filename
        String configFileName = null;
        try
        {
            // first try URL.getFile() which works for opaque URLs (file:foo) and paths without spaces
            configFileName = configLocation.getFile();
//            System.out.println(configFileName);
            File configFile = new File(configFileName);
            // then try alternative approach which works for all hierarchical URLs with or without spaces
            if (!configFile.exists())
                configFileName = new File(configLocation.toURI()).getCanonicalPath();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Couldn't convert log4j configuration location to a valid file", e);
        }

        PropertyConfigurator.configureAndWatch(configFileName, 10000);
        org.apache.log4j.Logger.getLogger(CassandraDaemon.class).info("Logging initialized");
    }

    public static void main(String[] args) throws ConfigurationException, InterruptedException, IOException {
        if (args.length < 3) {
            System.err.println("Please enter execution_time files");
            System.err.println("usage: WholeClusterSimulator <num_node> <num_gossipers> <num_processors>");
            System.exit(1);
        }
        numStubs = Integer.parseInt(args[0]);
        System.out.println("Started! " + numStubs);
        Gossiper.registerStatic(StorageService.instance);
//        Gossiper.registerStatic(LoadBroadcaster.instance);
        DatabaseDescriptor.loadYaml();
        GossiperStubGroupBuilder stubGroupBuilder = new GossiperStubGroupBuilder();
        final List<InetAddress> addressList = new LinkedList<InetAddress>();
        for (int i = 1; i <= numStubs; ++i) {
            int a = (i - 1) / 255;
            int b = (i - 1) % 255 + 1;
            addressList.add(InetAddress.getByName("127.0." + a + "." + b));
        }
        isProcessing = new HashMap<InetAddress, AtomicBoolean>();
        for (InetAddress address : addressList) {
            msgQueues.put(address, new ConcurrentLinkedQueue<MessageIn<?>>());
            isProcessing.put(address, new AtomicBoolean(false));
            isStarted.put(address, false);
            processCount.put(address, 0);
        }
        logger.info("Simulate " + numStubs + " nodes = " + addressList);

        stubGroup = stubGroupBuilder.setClusterId("Test Cluster").setDataCenter("")
                .setNumTokens(32).setSeeds(seeds).setAddressList(addressList)
                .setPartitioner(new Murmur3Partitioner()).build();
        stubGroup.prepareInitialState();

        int numGossiper = Integer.parseInt(args[1]);
        numGossiper = numGossiper == 0 ? 1 : numGossiper;
        timers = new Timer[numGossiper];
        tasks = new MyGossiperTask[numGossiper];
        LinkedList<GossiperStub>[] subStub = new LinkedList[numGossiper];
        for (int i = 0; i < numGossiper; ++i) {
            subStub[i] = new LinkedList<GossiperStub>();
        }
        int ii = 0;
        for (GossiperStub stub : stubGroup) {
            subStub[ii].add(stub);
            ii = (ii + 1) % numGossiper;
        }
        for (int i = 0; i < numGossiper; ++i) {
            timers[i] = new Timer();
            tasks[i] = new MyGossiperTask(subStub[i]);
            timers[i].schedule(tasks[i], 0, 1000);
        }
        int numProcessors = Integer.parseInt(args[2]);
        resumeProcessors = Executors.newScheduledThreadPool(numProcessors);
        Thread msgProber = new Thread(new MessageProber());
        msgProber.start();
        Thread seedThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (InetAddress seed : seeds) {
                    GossiperStub stub = stubGroup.getStub(seed);
                    stub.setupTokenState();
                    stub.updateNormalTokens();
                    stub.setNormalStatusState();
                    stub.setSeverityState(0.0);
                    stub.setLoad(10000);
                    isStarted.put(seed, true);
                }
            }
        });
        seedThread.start();
        
        Thread otherThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                Timer setStatus = new Timer();
                for (InetAddress address : addressList) {
                    isStarted.put(address, true);
                    if (!seeds.contains(addressList)) {
                        final GossiperStub stub = stubGroup.getStub(address);
                        setStatus.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                stub.setupTokenState();
                                stub.setBootStrappingStatusState();
                            }
                        }, 5000);
                        setStatus.schedule(new TimerTask() {
                            @Override
                            public void run() {
                               stub.updateNormalTokens();
                               stub.setupTokenState();
                               stub.setupTokenState();
                               stub.setNormalStatusState();
                               stub.setSeverityState(0.0);
                               stub.setLoad(10000);
                            }
                        }, 10000);
                    }
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        otherThread.start();
        
        Thread infoPrinter = new Thread(new RingInfoPrinter());
        infoPrinter.start();

    }
    
    public static <T> MessageIn<T> convertOutToIn(MessageOut<T> msgOut) {
        MessageIn<T> msgIn = MessageIn.create(msgOut.from, msgOut.payload, msgOut.parameters, msgOut.verb, MessagingService.VERSION_12);
        return msgIn;
    }
    
    public static boolean sendMessage(MessageIn<?> message) {
        InetAddress sender = message.from;
        InetAddress receiver = message.to;
        GossiperStub senderStub = stubGroup.getStub(sender);
        GossiperStub receiverStub = stubGroup.getStub(receiver);
        logger.info("sendMessage: " + message.hashCode() + " to " + receiver
            + " senderTokenToEndpointMap: " + senderStub.getTokenMetadata().tokenToEndpointMap.hashCode());
        return msgQueues.get(receiver).add(message);
    }

    static Random rand = new Random();
    
    public static class MyGossiperTask extends TimerTask {
        
        List<GossiperStub> stubs;
        
        public MyGossiperTask(List<GossiperStub> stubs) {
            this.stubs = stubs;
        }

        @Override
        public void run() {
//            logger.info("Generating gossip syn for " + stubs.size());
            for (GossiperStub performer : stubs) {
                InetAddress performerAddress = performer.getInetAddress();
                if (!isStarted.get(performerAddress)) {
                    continue;
                }
                performer.updateHeartBeat();
                boolean gossipToSeed = false;
                Set<InetAddress> liveEndpoints = performer.getLiveEndpoints();
                Set<InetAddress> seeds = performer.getSeeds();
                if (!liveEndpoints.isEmpty()) {
                    InetAddress liveReceiver = GossiperStub.getRandomAddress(liveEndpoints);
                    gossipToSeed = seeds.contains(liveReceiver);
                    MessageIn<GossipDigestSyn> synMsg = performer.genGossipDigestSyncMsgIn(liveReceiver);
                    if (!WholeClusterSimulator.sendMessage(synMsg)) {
                        logger.error("Cannot add more message to message queue");
                    } else {
//                        logger.debug(performerAddress + " sending sync to " + liveReceiver + " " + synMsg.payload.gDigests);
                    }
                } else {
//                    logger.debug(performerAddress + " does not have live endpoint");
                }
                Map<InetAddress, Long> unreachableEndpoints = performer.getUnreachableEndpoints();
                InetAddress unreachableReceiver = GossiperStub.getRandomAddress(unreachableEndpoints.keySet());
                if (unreachableReceiver != null) {
                    MessageIn<GossipDigestSyn> synMsg = performer.genGossipDigestSyncMsgIn(unreachableReceiver);
                    double prob = ((double) unreachableEndpoints.size()) / (liveEndpoints.size() + 1.0);
                    if (prob > random.nextDouble()) {
                        if (!WholeClusterSimulator.sendMessage(synMsg)) {
                            logger.error("Cannot add more message to message queue");
                        } else {
                        }
                    }
                }
                if (!gossipToSeed || liveEndpoints.size() < seeds.size()) {
                    int size = seeds.size();
                    if (size > 0) {
                        if (size == 1 && seeds.contains(performerAddress)) {

                        } else {
                            if (liveEndpoints.size() == 0) {
                                InetAddress seed = GossiperStub.getRandomAddress(seeds);
                                MessageIn<GossipDigestSyn> synMsg = performer.genGossipDigestSyncMsgIn(seed);
                                if (!WholeClusterSimulator.sendMessage(synMsg)) {
                                    logger.error("Cannot add more message to message queue");
                                } else {
//                                    logger.debug(performerAddress + " sending sync to seed " + seed + " " + synMsg.payload.gDigests);
                                }
                            } else {
                                double probability = seeds.size() / (double)( liveEndpoints.size() + unreachableEndpoints.size() );
                                double randDbl = random.nextDouble();
                                if (randDbl <= probability) {
                                    InetAddress seed = GossiperStub.getRandomAddress(seeds);
                                    MessageIn<GossipDigestSyn> synMsg = performer.genGossipDigestSyncMsgIn(seed);
                                    if (!WholeClusterSimulator.sendMessage(synMsg)) {
                                        logger.error("Cannot add more message to message queue");
                                    } else {
//                                        logger.debug(performerAddress + " sending sync to seed " + seed + " " + synMsg.payload.gDigests);
                                    }
                                }
                            }
                        }
                    }
                }
                performer.doStatusCheck();
            }
        }
        
    }
    
    public static class MessageProcessor implements Runnable {
        
        public static long networkQueuedTime = 0;
        public static int processCount = 0;
        
        MessageIn<?> msg;
        long createdTime;
        
        public MessageProcessor(MessageIn<?> msg) {
            this.msg = msg;
            createdTime = System.currentTimeMillis();
        }

        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
//            logger.info("worker_queued time " + (currentTime - createdTime));
//            logger.info("network_queued time " + (currentTime - msg.createdTime));
            long networkQueuedTime = currentTime - msg.createdTime;
            MessageProcessor.networkQueuedTime += networkQueuedTime;
            MessageProcessor.processCount += 1;
            MessagingService.instance().getVerbHandler(msg.verb).doVerb(msg, "");
        }
        
    }
    
    public static class MessageProber implements Runnable {

        @Override
        public void run() {
            while (true) {
                for (InetAddress address : msgQueues.keySet()) {
                    ConcurrentLinkedQueue<MessageIn<?>> msgQueue = msgQueues.get(address);
                    logger.trace("Checking queue for " + address + " ; " + msgQueue.size() + " " + isProcessing.get(address).get());
                    if (!msgQueue.isEmpty() && isProcessing.get(address).compareAndSet(false, true)) {
                        MessageIn<?> msg = msgQueue.poll();
                        resumeProcessors.execute(new MessageProcessor(msg));
                    } else {
                        logger.trace("There is not a message for " + address + " " + msgQueue.size() + " " + isProcessing.get(address).get());
                    }
                }
            }
        }
        
    }
    
    public static class RingInfoPrinter implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                boolean isStable = true;
                GossiperStub firstBadNode = null;
                int badNumMemberNode = -1;
                int badNumDeadNode = -1;
                for (GossiperStub stub : stubGroup) {
                    int memberNode = stub.getTokenMetadata().endpointWithTokens.size();
                    int deadNode = 0;
                    for (InetAddress address : stub.endpointStateMap.keySet()) {
                        EndpointState state = stub.endpointStateMap.get(address);
                        if (!state.isAlive()) {
                            deadNode++;
                        }
                    }
                    if (memberNode != numStubs || deadNode > 0) {
                        isStable = false;
                        badNumMemberNode = memberNode;
                        badNumDeadNode = deadNode;
                        firstBadNode = stub;
                        break;
                    }
                }
                int flapping = 0;
                for (GossiperStub stub : stubGroup) {
                    flapping += stub.flapping;
                }
                long interval = 0;
                int sentCount = 0;
                interval = sentCount == 0 ? 0 : interval / sentCount;
                long avgNetworkQueuedTime = MessageProcessor.processCount == 0 ? 0 : MessageProcessor.networkQueuedTime / MessageProcessor.processCount;
                if (isStable) {
                    logger.info("stable status yes " + flapping + " ; send lateness " + interval +
                            " ; network lateness " + avgNetworkQueuedTime);
                } else {
                    logger.info("stable status no " + flapping + " " + " ; send lateness " + interval + 
                            " ; network lateness " + avgNetworkQueuedTime);
                }
//                for (InetAddress address : msgQueues.keySet()) {
//                    ConcurrentLinkedQueue<MessageIn<?>> msgQueue = msgQueues.get(address);
//                    int queueSize = msgQueue.size();
//                    if (queueSize > 100) {
//                        logger.info("Backlog of " + address + " " + queueSize);
//                    }
//                }
                boolean enough = true;
                for (InetAddress address : processCount.keySet()) {
                    if (processCount.get(address) < 180) {
                        enough = false;
                    }
                }
                if (enough) {
                    System.exit(0);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        

    }
    
}
