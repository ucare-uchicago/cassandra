package edu.uchicago.cs.ucare.cassandra.gms.profiling;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.cassandra.dht.Murmur3Partitioner;
import org.apache.cassandra.dht.RandomPartitioner;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.locator.DynamicEndpointSnitch;
import org.apache.cassandra.locator.NetworkTopologyStrategy;
import org.apache.cassandra.locator.SimpleSnitch;
import org.apache.cassandra.locator.TokenMetadata;

import edu.uchicago.cs.ucare.cassandra.gms.GossiperStub;
import edu.uchicago.cs.ucare.cassandra.gms.RandomTokenGossiperStubGroup;

public class CalculatePendingRangesProfiler {

    public static void main(String[] args) throws UnknownHostException, ConfigurationException {
        if (args.length == 0) {
            System.err.println("Please specify number of nodes start and end");
            System.exit(1);
        }
        int start = Integer.parseInt(args[0]);
        if (start < 2) {
            System.err.println("The number of start must be greater than 1");
            System.exit(1);
        }
        int end = Integer.parseInt(args[1]);
        if (end < start) {
            System.err.println("The number of end must be greater than start");
            System.exit(1);
        }
        String replicationFactor = "1";
        int repeat = 2;
        for (int i = start; i <= end; ++i) {
            RandomTokenGossiperStubGroup gossiperGroup = new RandomTokenGossiperStubGroup("cluster1", "datacenter1", i, null, new Murmur3Partitioner(), 32);
            TokenMetadata masterTokenMetadata = new TokenMetadata();
            for (GossiperStub stub : gossiperGroup) {
                masterTokenMetadata.updateNormalTokens(stub.getTokens(), stub.getInetAddress());
            }
            for (GossiperStub stub : gossiperGroup) {
                stub.setTokenMetadata(masterTokenMetadata.cloneOnlyTokenMap());
            }
            GossiperStub stub = gossiperGroup.getStub(InetAddress.getByName("127.0.0.1"));
            SimpleSnitch simpleSnitch = new SimpleSnitch();
            DynamicEndpointSnitch dynamicSnitch = new DynamicEndpointSnitch(simpleSnitch);
            Map<String, String> strategyOptions = new HashMap<String, String>();
            strategyOptions.put("datacenter1", replicationFactor);
            TokenMetadata testStubTokenMetadata = stub.getTokenMetadata();
            testStubTokenMetadata.addLeavingEndpoint(InetAddress.getByName("127.0.0.2"));
            NetworkTopologyStrategy strategy = new NetworkTopologyStrategy("table1", testStubTokenMetadata, dynamicSnitch, strategyOptions);
            long avg = 0;
            for (int j = 0; j < repeat; ++j) {
                long elapse = System.currentTimeMillis();
                strategy.getAddressRanges();
                elapse = System.currentTimeMillis() - elapse;
                if (j != 0) {
                    avg += elapse;
                }
            }
            avg = avg / (repeat - 1);
            System.out.println(i + " " + avg);
        }
        System.exit(0);
    }

}
