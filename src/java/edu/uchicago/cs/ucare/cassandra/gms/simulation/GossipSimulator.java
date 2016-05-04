package edu.uchicago.cs.ucare.cassandra.gms.simulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.cassandra.dht.Murmur3Partitioner;
import org.apache.cassandra.dht.RandomPartitioner;
import org.apache.cassandra.gms.EndpointState;
import org.apache.cassandra.gms.GossipDigest;
import org.apache.cassandra.gms.SimulatedGossipDigestAck2VerbHandler;
import org.apache.cassandra.gms.SimulatedGossipDigestAckVerbHandler;
import org.apache.cassandra.gms.SimulatedGossipDigestSynVerbHandler;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.MessageIn;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.net.MessagingService.Verb;

import edu.uchicago.cs.ucare.cassandra.gms.RandomTokenGossiperStubGroup;
import edu.uchicago.cs.ucare.cassandra.gms.GossiperStub;
import edu.uchicago.cs.ucare.util.Klogger;

public class GossipSimulator {

    private static RandomTokenGossiperStubGroup gossiperGroup;
    private static Map<InetAddress, LinkedBlockingQueue<MessageIn>> msgQueues;
    
    private static Random random = new Random();
    
    private static boolean simulating = false;
    private static final Map<MessagingService.Verb, IVerbHandler> verbHandlers;
    static {
        verbHandlers = new EnumMap<MessagingService.Verb, IVerbHandler>(MessagingService.Verb.class); 
        verbHandlers.put(Verb.GOSSIP_DIGEST_SYN, new SimulatedGossipDigestSynVerbHandler());
        verbHandlers.put(Verb.GOSSIP_DIGEST_ACK, new SimulatedGossipDigestAckVerbHandler());
        verbHandlers.put(Verb.GOSSIP_DIGEST_ACK2, new SimulatedGossipDigestAck2VerbHandler());
    }
    
    public static final String CLUSTER_NAME = "sck";
    
//    private static long cprTime;
    private static final Map<Integer, Long> memoizedTime = new HashMap<Integer, Long>();

    public static int numNodes;
    public static int ringSize;
    
    public static GroupedGossiperTask[] gossipTasks;

    public static void main(String[] args) throws UnknownHostException {
        if (args.length < 4) {
            System.err.println("usage: GossipSimulator <num_nodes> <num_tables> <cpr_file> <num_gossiper>");
            System.exit(1);
        }
        numNodes = Integer.parseInt(args[0]);
        ringSize = numNodes;
        if (numNodes < 2) {
            System.err.println("The number of nodes must be greater than 1");
            System.exit(1);
        }
        Klogger.scale.info("Checking {} nodes", numNodes);
        simulating = true;
        int numTables = Integer.parseInt(args[1]);
        if (numTables < 0) {
            System.err.println("The number of tables must be greater than 0");
            System.exit(1);
        }
        Klogger.scale.info("Number of tables is {}", numTables);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[2]));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(" ");
                if (entry.length != 2) {
                    System.err.println("Wrong profiling file format");
                    System.exit(3);
                }
                int tmpSize = Integer.parseInt(entry[0]);
                long tmpTime = Long.parseLong(entry[1]);
                memoizedTime.put(tmpSize, tmpTime);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open profiling file, " + args[2]);
            System.exit(2);
        } catch (IOException e) {
            System.err.println("Cannot read profiling file, " + args[2]);
            System.exit(2);
        }
//        Klogger.scale.info("calculatePendingRanges will takes {} ms", cprTime);
        int numGossipSendingWorker = Integer.parseInt(args[3]);
        numGossipSendingWorker = numGossipSendingWorker < 1 ? 1 : numGossipSendingWorker;
        Set<InetAddress> seeds = new HashSet<InetAddress>();
        seeds.add(InetAddress.getByName("127.0.0.1"));
        gossiperGroup = new RandomTokenGossiperStubGroup(CLUSTER_NAME, "datacenter1", numNodes, seeds, new Murmur3Partitioner(), 32);
        gossiperGroup.setTables(numTables, 1);
        msgQueues = new HashMap<InetAddress, LinkedBlockingQueue<MessageIn>>();
        Klogger.scale.info("Starting worker threads");
        List<List<GossiperStub>> subGroup = new ArrayList<List<GossiperStub>>();
        for (int i = 0; i < numGossipSendingWorker; ++i) {
            subGroup.add(new LinkedList<GossiperStub>());
        }
        int x = 0;
        for (GossiperStub stub : gossiperGroup) {
            msgQueues.put(stub.getInetAddress(), new LinkedBlockingQueue<MessageIn>());
            Thread t = new Thread(new GossipWorker(stub.getInetAddress()));
            t.start();
            stub.maybeInitializeLocalState((int) (System.currentTimeMillis() / 1000));
            stub.prepareInitialState();
            stub.setBootStrappingStatusState();
//            stub.updateNormalTokens();
//            stub.setNormalStatusState();
            subGroup.get(x).add(stub);
            x = (x + 1) % numGossipSendingWorker;
        }
        Timer[] gossipSendingWorkers = new Timer[numGossipSendingWorker];
        gossipTasks = new GroupedGossiperTask[numGossipSendingWorker];
        for (int i = 0; i < numGossipSendingWorker; ++i) {
            gossipSendingWorkers[i] = new Timer();
            gossipTasks[i] = new GroupedGossiperTask(subGroup.get(i));
            gossipSendingWorkers[i].schedule(gossipTasks[i], 0, 1000);
        }
        Thread clusterMonitor = new Thread(new ClusterMonitor());
        clusterMonitor.start();
    }
    
    public RandomTokenGossiperStubGroup getGossiperGroup() {
        return gossiperGroup;
    }
    
    public static class GroupedGossiperTask extends TimerTask {
        
        private List<GossiperStub> stubs;
        private long previousRun;
        private long runningInterval;
        private int sendCount;
        
        private static long maxLate = 0;
        
        public GroupedGossiperTask(List<GossiperStub> stubs) {
            this.stubs = stubs;
            previousRun = 0;
        }

        @Override
        public void run() {
            Klogger.scale.debug("Sending gossip");
            long start = System.currentTimeMillis();
            if (previousRun != 0) {
                long interval = start - previousRun;
                runningInterval += interval;
                sendCount++;
                if (interval > maxLate) {
                    maxLate = interval;
                }
            }
            previousRun = start;
            for (GossiperStub performer : stubs) {
                InetAddress performerAddress = performer.getInetAddress();
                performer.updateHeartBeat();
                boolean gossipToSeed = false;
                Set<InetAddress> liveEndpoints = performer.getLiveEndpoints();
                Set<InetAddress> seeds = performer.getSeeds();
                
                List<GossipDigest> gDigests = new ArrayList<GossipDigest>();
                performer.makeRandomGossipDigest(gDigests);

                if (gDigests.size() > 0) {
                    MessageIn synMsg = null;
//                    synMsg = performer.genGossipDigestSyncMsgIn();
                    if (!liveEndpoints.isEmpty()) {
                        InetAddress liveReceiver = getRandomAddress(liveEndpoints);
                        gossipToSeed = seeds.contains(liveReceiver);
                        synMsg = performer.genGossipDigestSyncMsgIn();
                        synMsg.setTo(liveReceiver);
                        if (!msgQueues.get(liveReceiver).add(synMsg)) {
                            Klogger.scale.error("Cannot add more message to message queue of " + liveReceiver);
                        }
                    }
                    Map<InetAddress, Long> unreachableEndpoints = performer.getUnreachableEndpoints();
                    if (!unreachableEndpoints.isEmpty()) {
                        double prob = ((double) unreachableEndpoints.size()) / (liveEndpoints.size() + 1.0);
                        if (prob > random.nextDouble()) {
                            InetAddress unreachableReceiver = getRandomAddress(unreachableEndpoints.keySet());
                            if (unreachableReceiver != null) {
                                synMsg = performer.genGossipDigestSyncMsgIn();
                                synMsg.setTo(unreachableReceiver);
                                if (!msgQueues.get(unreachableReceiver).add(synMsg)) {
                                    Klogger.scale.error("Cannot add more message to message queue of " + unreachableReceiver);
                                }
                            }
                        }
                    }
                    if (!gossipToSeed || liveEndpoints.size() < seeds.size()) {
                        int size = seeds.size();
                        if (size > 0) {
                            if (size == 1 && seeds.contains(performerAddress)) {

                            } else {
                                if (liveEndpoints.size() == 0) {
                                    InetAddress seed = getRandomAddress(seeds);
                                    synMsg = performer.genGossipDigestSyncMsgIn();
                                    synMsg.setTo(seed);
                                    if (!msgQueues.get(seed).add(synMsg)) {
                                        Klogger.scale.error("Cannot add more message to message queue of " + seed);
                                    }
                                } else {
                                    double probability = seeds.size() / (double)( liveEndpoints.size() + unreachableEndpoints.size() );
                                    double randDbl = random.nextDouble();
                                    if (randDbl <= probability) {
                                        InetAddress seed = getRandomAddress(seeds);
                                        synMsg = performer.genGossipDigestSyncMsgIn();
                                        synMsg.setTo(seed);
                                        if (!msgQueues.get(seed).add(synMsg)) {
                                            Klogger.scale.error("Cannot add more message to message queue of " + seed);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    performer.doStatusCheck();
                }
            }
            long gossipingTime = System.currentTimeMillis() - start;
            if (gossipingTime > 1000) {
                Klogger.scale.warn("It took more than 1 s (" + gossipingTime + " ms) to do gossip task");
            }
        }
        
        public double averageInterval() {
            return (double) runningInterval / (double) sendCount;
        }
        
        public static double getMaxLate() {
            return maxLate;
        }
        
    }
    
    public static class GossipWorker implements Runnable {
        
        private final InetAddress address;
        
        public GossipWorker(InetAddress address) {
            this.address = address;
        }

        @Override
        public void run() {
            LinkedBlockingQueue<MessageIn> msgQueue = msgQueues.get(address);
            while (true) {
                try {
                    MessageIn msg = msgQueue.take();
                    verbHandlers.get(msg.verb).doVerb(msg, "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public static InetAddress getRandomAddress(Collection<InetAddress> addressCollection) {
        if (addressCollection.isEmpty()) {
            return null;
        }
        int size = addressCollection.size();
        InetAddress[] addresses = new InetAddress[size];
        addresses = addressCollection.toArray(addresses);
        int randNum = random.nextInt(size);
        return addresses[randNum];
    }
    
    public static void sendMessage(MessageIn msg, InetAddress address) {
        try {
            msgQueues.get(address).put(msg);
        } catch (InterruptedException e) {
            Klogger.scale.warn("Cannot add " + msg + " to " + address);
        }
    }
    
    public static boolean isSimulating() {
        return simulating;
    }
    
    public static GossiperStub getStub(InetAddress address) {
        return gossiperGroup.getStub(address);
    }
    
//    public static long getCprTime() {
//        return cprTime;
//    }
    
    public static long getMemoizedTime(int size) {
        return memoizedTime.get(size);
    }
    
    public static boolean isRingStable() {
        for (GossiperStub stub : gossiperGroup) {
            // 1 token per node so ring members should equal number of nodes
            if(stub.getTokenMetadata().getSize() != ringSize) {
                return false;
            }
            for (EndpointState state : stub.getEndpointStateMap().values()) {
                if (!state.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static class ClusterMonitor implements Runnable {

        @Override
        public void run() {
            while (true) {
                boolean allRingComplete = isRingStable();
                int totalAccuDown = 0;
                for (GossiperStub stub : gossiperGroup) {
                    totalAccuDown += stub.getAccuDown();
                }
//                double sendLateness = 0;
//                for (GroupedGossiperTask gossipTask : gossipTasks) {
//                    sendLateness += gossipTask.averageInterval();
//                }
//                sendLateness /= gossipTasks.length;
                Klogger.scale.info("Ring: stable {} accuDown {}", allRingComplete, totalAccuDown);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
