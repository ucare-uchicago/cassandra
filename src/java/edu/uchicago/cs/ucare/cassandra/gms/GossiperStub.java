package edu.uchicago.cs.ucare.cassandra.gms;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.gms.ApplicationState;
import org.apache.cassandra.gms.EndpointState;
import org.apache.cassandra.gms.FailureDetector;
import org.apache.cassandra.gms.GossipDigest;
import org.apache.cassandra.gms.GossipDigestSyn;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.gms.HeartBeatState;
import org.apache.cassandra.gms.IEndpointStateChangeSubscriber;
import org.apache.cassandra.gms.IFailureDetectionEventListener;
import org.apache.cassandra.gms.VersionedValue;
import org.apache.cassandra.gms.VersionedValue.VersionedValueFactory;
import org.apache.cassandra.locator.AbstractReplicationStrategy;
import org.apache.cassandra.locator.DynamicEndpointSnitch;
import org.apache.cassandra.locator.NetworkTopologyStrategy;
import org.apache.cassandra.locator.SimpleSnitch;
import org.apache.cassandra.locator.TokenMetadata;
import org.apache.cassandra.net.MessageIn;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;
import org.cliffc.high_scale_lib.NonBlockingHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uchicago.cs.ucare.scale.InetAddressStub;

public class GossiperStub implements InetAddressStub, IFailureDetectionEventListener {
    
    public static final UUID INITIAL_VERSION = new UUID(4096, 0); // has type nibble set to 1, everything else to zero.
    
    private static final Comparator<InetAddress> inetcomparator = new Comparator<InetAddress>()
    {
        public int compare(InetAddress addr1,  InetAddress addr2)
        {
            return addr1.getHostAddress().compareTo(addr2.getHostAddress());
        }
    };
    private static final Logger logger = LoggerFactory.getLogger(GossiperStub.class);
    
    public static final int RING_DELAY = 30 * 1000; 
    public final static int QUARANTINE_DELAY = RING_DELAY * 2;
    public final static long FatClientTimeout = (long) (RING_DELAY);
    public long aVeryLongTime = 259200 * 1000;
    public final Map<String, Long> syncReceivedTime = new ConcurrentHashMap<String, Long>();
    public final Map<String, Integer> ackNewVersionNormal = new ConcurrentHashMap<String, Integer>();
    public final Map<String, Integer> ackNewVersionBoot = new ConcurrentHashMap<String, Integer>();

    private String clusterId;
    private String dataCenter;
    private InetAddress broadcastAddress;
    private UUID hostId;
    private UUID schema;
    private EndpointState state;
    private ConcurrentMap<InetAddress, EndpointState> endpointStateMap;
    private VersionedValueFactory versionedValueFactory;
    private TokenMetadata tokenMetadata;
	private Collection<Token> tokens;
    private IPartitioner<?> partitioner;
    private String partitionerName;
    private FailureDetector failureDetector;
    private Set<InetAddress> liveEndpoints;
    private Map<InetAddress, Long> unreachableEndpoints;
    private Map<InetAddress, Long> justRemovedEndpoints;
    private Map<InetAddress, Long> expireTimeEndpointMap;
    private Set<InetAddress> seeds;
//    private final ConcurrentMap<InetAddress, Integer> versions = new NonBlockingHashMap<InetAddress, Integer>();
    private List<String> tables;
    private Map<String, AbstractReplicationStrategy> strategies;
    private boolean isRunning;
    
    private boolean hasContactedSeed;
    private int accuDown;
    
    private static final Random random = new Random();

//    static {
//        SimpleSnitch simpleSnitch = new SimpleSnitch();
//        DynamicEndpointSnitch dynamicSnitch = new DynamicEndpointSnitch(simpleSnitch);
//        Map<String, String> strategyOptions = new HashMap<String, String>();
//        strategyOptions.put("datacenter1", replicationFactor);
//        TokenMetadata testStubTokenMetadata = stub.getTokenMetadata();
//        testStubTokenMetadata.addLeavingEndpoint(InetAddress.getByName("127.0.0.2"));
//        NetworkTopologyStrategy strategy = new NetworkTopologyStrategy("table1", testStubTokenMetadata, dynamicSnitch, strategyOptions);
//    }
    
    private static Collection<Token> getRandomToken(IPartitioner<?> partitioner, int numTokens) {
        Set<Token> tokens = new HashSet<Token>(numTokens);
        while (tokens.size() < numTokens)
        {
            Token token = partitioner.getRandomToken();
            tokens.add(token);
        }
        return tokens;
    }
    
    public GossiperStub(InetAddress broadcastAddress, String clusterId, String dataCenter, 
            Set<InetAddress> seeds, IPartitioner<?> partitioner, int numTokens) {
        this(broadcastAddress, clusterId, dataCenter, UUID.randomUUID(), INITIAL_VERSION, 
                seeds, partitioner, getRandomToken(partitioner, numTokens));
    }
    
    public GossiperStub(InetAddress broadcastAddress, String clusterId, String dataCenter, 
            UUID hostId, UUID schema, Set<InetAddress> seeds, 
            IPartitioner<?> partitioner, Collection<Token> tokens) {
        this.clusterId = clusterId;
        this.dataCenter = dataCenter;
        this.broadcastAddress = broadcastAddress;
        this.hostId = hostId;
        this.schema = schema;
        this.partitioner = partitioner;
        partitionerName = partitioner.getClass().getName();
        this.tokens = tokens;
        endpointStateMap = new ConcurrentHashMap<InetAddress, EndpointState>();
        state = null;
        versionedValueFactory = new VersionedValueFactory(partitioner);
        hasContactedSeed = false;
        isRunning = true;
        accuDown = 0;
        tokenMetadata = new TokenMetadata();
        failureDetector = new FailureDetector();
        failureDetector.registerFailureDetectionEventListener(this);
        liveEndpoints = new ConcurrentSkipListSet<InetAddress>(inetcomparator);
        unreachableEndpoints = new ConcurrentHashMap<InetAddress, Long>();
        justRemovedEndpoints = new ConcurrentHashMap<InetAddress, Long>();
        expireTimeEndpointMap = new ConcurrentHashMap<InetAddress, Long>();
        this.seeds = new ConcurrentSkipListSet<InetAddress>(inetcomparator);
        if (seeds != null) {
            this.seeds.addAll(seeds);
        }
        tables = new LinkedList<String>();
        strategies = new HashMap<String, AbstractReplicationStrategy>();
    }
    
    public void prepareInitialState() {
        state.addApplicationState(ApplicationState.NET_VERSION, versionedValueFactory.networkVersion());
        state.addApplicationState(ApplicationState.RPC_ADDRESS, versionedValueFactory.rpcaddress(broadcastAddress));
        state.addApplicationState(ApplicationState.RELEASE_VERSION, versionedValueFactory.releaseVersion());
    }
    
    public void updateNormalTokens() {
        tokenMetadata.updateNormalTokens(tokens, broadcastAddress);
    }
    
    public void maybeInitializeLocalState(int generationNbr) {
        if ( state == null ) {
            HeartBeatState hbState = new HeartBeatState(generationNbr);
            state = new EndpointState(hbState);
            state.markAlive();
            endpointStateMap.put(broadcastAddress, state);
        }
    }
    
    public void setTables(int numTables, int replicationFactor) {
        tables.clear();
        strategies.clear();
        SimpleSnitch simpleSnitch = new SimpleSnitch();
        DynamicEndpointSnitch dynamicSnitch = new DynamicEndpointSnitch(simpleSnitch);
        Map<String, String> strategyOptions = new HashMap<String, String>();
        strategyOptions.put(dataCenter, replicationFactor + "");
        TokenMetadata testStubTokenMetadata = getTokenMetadata();
        for (int i = 0; i < numTables; ++i) {
            String tableName = "KeySpace" + i;
            tables.add(tableName);
            NetworkTopologyStrategy strategy;
            try {
                strategy = new NetworkTopologyStrategy(tableName, 
                        testStubTokenMetadata, dynamicSnitch, strategyOptions);
                strategies.put(tableName, strategy);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
    }
    
    public AbstractReplicationStrategy getStrategy(String tableName) {
        return strategies.get(tableName);
    }
    
    public void setBootStrappingStatusState() {
        state.addApplicationState(ApplicationState.STATUS, versionedValueFactory.bootstrapping(tokens));
    }

    public void setNormalStatusState() {
        state.addApplicationState(ApplicationState.STATUS, versionedValueFactory.normal(tokens));
    }
    
    public void setLeaveStatusState() {
        state.addApplicationState(ApplicationState.STATUS, versionedValueFactory.leaving(tokens));
    }
    
//    public void setLeftStatusState() {
//        state.addApplicationState(ApplicationState.STATUS, versionedValueFactory.left(tokens));
//    }
//    
//    public void setLoadState(double load) {
//        state.addApplicationState(ApplicationState.LOAD, versionedValueFactory.load(load));
//    }
    
    public EndpointState getEndpointState() {
        return endpointStateMap.get(broadcastAddress);
    }

    public ConcurrentMap<InetAddress, EndpointState> getEndpointStateMap() {
        return endpointStateMap;
    }
    
    public TokenMetadata getTokenMetadata() {
        return tokenMetadata;
    }
    
    public void setTokenMetadata(TokenMetadata tokenMetadata) {
        this.tokenMetadata = tokenMetadata;
    }
    
    public void updateHeartBeat() {
        state.getHeartBeatState().updateHeartBeat();
    }
    
    public boolean setEndpointStateIfNewer(InetAddress address, EndpointState epState) {
         if (endpointStateMap.containsKey(address)) {
             EndpointState oldState = endpointStateMap.get(address);
             if (oldState.getHeartBeatState().getHeartBeatVersion() >= epState.getHeartBeatState().getHeartBeatVersion()) {
                 endpointStateMap.put(address, epState);
                 return true;
             }
             return false;
         }
         endpointStateMap.put(address, epState);
         return true;
     }
     
     int getMaxEndpointStateVersion(EndpointState epState) {
         int maxVersion = epState.getHeartBeatState().getHeartBeatVersion();
         for (VersionedValue value : epState.getApplicationStateMap().values())
             maxVersion = Math.max(maxVersion,  value.version);
         return maxVersion;
     }
    
     public void makeRandomGossipDigest(List<GossipDigest> gDigests) {
        EndpointState epState;
        int generation = 0;
        int maxVersion = 0;
 
        // local epstate will be part of endpointStateMap
        List<InetAddress> endpoints = new ArrayList<InetAddress>(endpointStateMap.keySet());
        Collections.shuffle(endpoints, random);
        for (InetAddress endpoint : endpoints)
        {
            epState = endpointStateMap.get(endpoint);
            if (epState != null)
            {
                generation = epState.getHeartBeatState().getGeneration();
                maxVersion = getMaxEndpointStateVersion(epState);
            }
            gDigests.add(new GossipDigest(endpoint, generation, maxVersion));
        }
    }
     
    private static Map<String, byte[]> emptyMap = Collections.<String, byte[]>emptyMap();
    public MessageIn<GossipDigestSyn> genGossipDigestSyncMsgIn() {
        Random random = new Random();
        List<GossipDigest> gossipDigestList = new LinkedList<GossipDigest>();
        EndpointState epState;
        int generation = 0;
        int maxVersion = 0;
        List<InetAddress> endpoints = new ArrayList<InetAddress>(endpointStateMap.keySet());
        Collections.shuffle(endpoints, random);
        for (InetAddress endpoint : endpoints) {
            epState = endpointStateMap.get(endpoint);
            if (epState != null) {
                generation = epState.getHeartBeatState().getGeneration();
                maxVersion = epState.getHeartBeatState().getHeartBeatVersion();
            }
            gossipDigestList.add(new GossipDigest(endpoint, generation, maxVersion));
        }
        GossipDigestSyn digestSynMessage = new GossipDigestSyn(clusterId, partitionerName, 
                gossipDigestList);
        MessageIn<GossipDigestSyn> message = MessageIn.create(broadcastAddress, digestSynMessage, 
                emptyMap, MessagingService.Verb.GOSSIP_DIGEST_SYN, MessagingService.VERSION_12);
        return message;
    }
     
    @Override
    public InetAddress getInetAddress() {
        return broadcastAddress;
    }

    public boolean getHasContactedSeed() {
        return hasContactedSeed;
    }

    public void setHasContactedSeed(boolean hasContactedSeed) {
        this.hasContactedSeed = hasContactedSeed;
    }

    public FailureDetector getFailureDetector() {
        return failureDetector;
    }

    public void setFailureDetector(FailureDetector failureDetector) {
        this.failureDetector = failureDetector;
    }
    
    public Set<InetAddress> getLiveEndpoints() {
        return liveEndpoints;
    }

    public void setLiveEndpoints(Set<InetAddress> liveEndpoints) {
        this.liveEndpoints = liveEndpoints;
    }

    public Map<InetAddress, Long> getUnreachableEndpoints() {
        return unreachableEndpoints;
    }

    public void setUnreachableEndpoints(Map<InetAddress, Long> unreachableEndpoints) {
        this.unreachableEndpoints = unreachableEndpoints;
    }

    public Set<InetAddress> getSeeds() {
        return seeds;
    }

    public void setSeeds(Set<InetAddress> seeds) {
        this.seeds = seeds;
    }
    
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Map<InetAddress, Long> getJustRemovedEndpoints() {
        return justRemovedEndpoints;
    }

    public void setJustRemovedEndpoints(Map<InetAddress, Long> justRemovedEndpoints) {
        this.justRemovedEndpoints = justRemovedEndpoints;
    }
    
    public List<String> getTables() {
        return tables;
    }
    
    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public UUID getHostId() {
        return hostId;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public UUID getSchema() {
        return schema;
    }

    public void setSchema(UUID schema) {
        this.schema = schema;
    }

    public IPartitioner<?> getPartitioner() {
        return partitioner;
    }

    public void setPartitioner(IPartitioner<?> partitioner) {
        this.partitioner = partitioner;
    }
    
//    public Token<?> getToken() {
//        return token;
//    }
//
//    public void setToken(Token<?> token) {
//        this.token = token;
//    }

    public String getPartitionerName() {
        return partitionerName;
    }

    public void setPartitionerName(String partitionerName) {
        this.partitionerName = partitionerName;
    }

    public int getAccuDown() {
        return accuDown;
    }

    @Override
    public String toString() {
        return broadcastAddress.toString();
    }

    @Override
    public void convict(InetAddress endpoint, double phi) {
        EndpointState epState = endpointStateMap.get(endpoint);
        if (epState.isAlive() && !isDeadState(epState)) {
            markDead(endpoint, epState);
        }
    }
    
    public Boolean isDeadState(EndpointState epState) {
        if (epState.getApplicationState(ApplicationState.STATUS) == null)
            return false;
        String value = epState.getApplicationState(ApplicationState.STATUS).value;
        String[] pieces = value.split(VersionedValue.DELIMITER_STR, -1);
        assert (pieces.length > 0);
        String state = pieces[0];
        for (String deadstate : Gossiper.DEAD_STATES) {
            if (state.equals(deadstate))
                return true;
        }
        return false;
    }
    
    public void markAlive(InetAddress addr, EndpointState localState) {
        if (logger.isTraceEnabled())
            logger.trace("marking as alive {}", addr);
        localState.markAlive();
        localState.updateTimestamp(); // prevents doStatusCheck from racing us and evicting if it was down > aVeryLongTime
        liveEndpoints.add(addr);
        unreachableEndpoints.remove(addr);
        expireTimeEndpointMap.remove(addr);
        logger.debug("removing expire time for endpoint : " + addr);
        logger.info("InetAddress {} is now UP", addr);
        StorageService.onAliveStatic(this, addr, localState);
//        for (IEndpointStateChangeSubscriber subscriber : subscribers)
//            subscriber.onAlive(addr, localState);
//        if (logger.isTraceEnabled())
//            logger.trace("Notified " + subscribers);
    }
    
    public void markDead(InetAddress addr, EndpointState localState) {
        if (logger.isTraceEnabled())
            logger.trace("marking as dead {}", addr);
        localState.markDead();
        liveEndpoints.remove(addr);
        unreachableEndpoints.put(addr, System.currentTimeMillis());
        logger.info("InetAddress {} is now dead.", addr);
//      for (IEndpointStateChangeSubscriber subscriber : subscribers)
//            subscriber.onDead(addr, localState);
//        if (logger.isTraceEnabled())
//            logger.trace("Notified " + subscribers);
    }
    
    public void doStatusCheck() {
        long now = System.currentTimeMillis();

        Set<InetAddress> eps = endpointStateMap.keySet();
        for ( InetAddress endpoint : eps ) {
            if ( endpoint.equals(broadcastAddress) )
                continue;

            failureDetector.interpret(endpoint);
            EndpointState epState = endpointStateMap.get(endpoint);
            if ( epState != null ) {
                long duration = now - epState.getUpdateTimestamp();

                // check if this is a fat client. fat clients are removed automatically from
                // gossip after FatClientTimeout.  Do not remove dead states here.
                if (!isDeadState(epState) && !epState.isAlive() && !tokenMetadata.isMember(endpoint) && !justRemovedEndpoints.containsKey(endpoint) && (duration > FatClientTimeout)) {
                    logger.info("FatClient " + endpoint + " has been silent for " + FatClientTimeout + "ms, removing from gossip");
                    removeEndpoint(endpoint); // will put it in justRemovedEndpoints to respect quarantine delay
                    evictFromMembership(endpoint); // can get rid of the state immediately
                }

                // check for dead state removal
                long expireTime = getExpireTimeForEndpoint(endpoint);
                if (!epState.isAlive() && (now > expireTime) && (!tokenMetadata.isMember(endpoint))) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("time is expiring for endpoint : " + endpoint + " (" + expireTime + ")");
                    }
                    evictFromMembership(endpoint);
                }
            }
        }

        if (!justRemovedEndpoints.isEmpty()) {
            for (Entry<InetAddress, Long> entry : justRemovedEndpoints.entrySet()) {
                if ((now - entry.getValue()) > QUARANTINE_DELAY) {
                    if (logger.isDebugEnabled())
                        logger.debug(QUARANTINE_DELAY + " elapsed, " + entry.getKey() + " gossip quarantine over");
                    justRemovedEndpoints.remove(entry.getKey());
                }
            }
        }
    }
    
    public void removeEndpoint(InetAddress endpoint) {
        // do subscribers first so anything in the subscriber that depends on gossiper state won't get confused
//        for (IEndpointStateChangeSubscriber subscriber : subscribers)
//            subscriber.onRemove(endpoint);

        liveEndpoints.remove(endpoint);
        unreachableEndpoints.remove(endpoint);
        // do not remove endpointState until the quarantine expires
        failureDetector.remove(endpoint);
        quarantineEndpoint(endpoint);
        if (logger.isDebugEnabled())
            logger.debug("removing endpoint " + endpoint);
    }
    
    private void quarantineEndpoint(InetAddress endpoint) {
        justRemovedEndpoints.put(endpoint, System.currentTimeMillis());
    }
    
    protected long getExpireTimeForEndpoint(InetAddress endpoint) {
        /* default expireTime is aVeryLongTime */
        long expireTime = computeExpireTime();
        if (expireTimeEndpointMap.containsKey(endpoint)) {
            expireTime = expireTimeEndpointMap.get(endpoint);
        }
        return expireTime;
    }
    
    private void evictFromMembership(InetAddress endpoint) {
        unreachableEndpoints.remove(endpoint);
        endpointStateMap.remove(endpoint);
        expireTimeEndpointMap.remove(endpoint);
        quarantineEndpoint(endpoint);
        if (logger.isDebugEnabled())
            logger.debug("evicting " + endpoint + " from gossip");
    }
    
    public static long computeExpireTime() {
        return System.currentTimeMillis() + Gossiper.aVeryLongTime;
    }

}
