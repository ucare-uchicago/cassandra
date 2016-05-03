package edu.uchicago.cs.ucare.cassandra.gms;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.cassandra.dht.IPartitioner;

import edu.uchicago.cs.ucare.scale.InetAddressStubGroup;

public class RandomTokenGossiperStubGroup implements InetAddressStubGroup<GossiperStub> {
    
    private Map<InetAddress, GossiperStub> stubs;
    private String clusterId;
    private IPartitioner<?> partitioner;
    private GossiperStub decommissionNode;

    public RandomTokenGossiperStubGroup(String clusterId, String dataCenter, int numNodes,
            Set<InetAddress> seeds, IPartitioner<?> partitioner, int numTokens)
            throws UnknownHostException {
        this.clusterId = clusterId;
        this.partitioner = partitioner;
        stubs = new HashMap<InetAddress, GossiperStub>();
        for (int i = 0; i < numNodes; ++i) {
            int a = i / 255;
            int b = i % 255;
            InetAddress address = InetAddress.getByName("127.0." + a + "." + (b + 1));
            stubs.put(address, new GossiperStub(address, clusterId, dataCenter, 
                    seeds, partitioner, numTokens));
            if (i == (numNodes - 1)) {
                decommissionNode = stubs.get(address);
            }
        }
    }
    
    public void prepareInitialState() {
        for (InetAddress address : stubs.keySet()) {
            GossiperStub stub = stubs.get(address);
            stub.prepareInitialState();
        }
    }

    @Override
    public Collection<GossiperStub> getAllStubs() {
        return stubs.values();
    }

    @Override
    public Collection<InetAddress> getAllInetAddress() {
        return stubs.keySet();
    }
    
    @Override
    public GossiperStub getStub(InetAddress address) {
        return stubs.get(address);
    }

    @Override
    public Iterator<GossiperStub> iterator() {
        return stubs.values().iterator();
    }
    
    public boolean contains(InetAddress address) {
        return stubs.containsKey(address);
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public IPartitioner<?> getPartitioner() {
        return partitioner;
    }

    public void setPartitioner(IPartitioner<?> partitioner) {
        this.partitioner = partitioner;
    }

    @Override
    public int size() {
       return stubs.size();
    }
    
    public GossiperStub getDecommissionNode() {
        return decommissionNode;
    }

    public void setTables(int numTables, int replicationFactor) {
        for (GossiperStub stub : stubs.values()) {
            stub.setTables(numTables, replicationFactor);
        }
    }

}
