package edu.uchicago.cs.ucare.cassandra.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.cassandra.dht.StringToken;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.locator.NetworkTopologyStrategy;
import org.apache.cassandra.locator.TokenMetadata;

public class CalculatePendingRangesRunningTimeChecker {

	public static void main(String[] args) throws InterruptedException, ConfigurationException, UnknownHostException {
		
		// initialization
		int totalTokens = 16;
		int multiplier = 1;
		if (args.length >= 1) {
			totalTokens = Integer.parseInt(args[0]);
		}
		
		
		TokenMetadata metadata = new TokenMetadata();
		
		if(totalTokens > 256){
			multiplier = totalTokens / 256;
			totalTokens = 256;
		}
		
		
		for(int m=0; m<multiplier; m++){
			for(int i=0; i<totalTokens; i++){
				tokenFactory(metadata, String.valueOf(m) + " " + String.valueOf(i), new byte[]{ 10, 0, (byte) (0+m), (byte) (0+i) });
			}
		}
		System.out.println(metadata.toString());
		
		// get current system time before running the expensive function
		long time1 = System.currentTimeMillis();
		
		// call getAddress
		NetworkTopologyStrategy.getAddressRanges2(metadata);
		
		long time2 = System.currentTimeMillis();
		long diff = time2 - time1;
		System.out.println("diff:" + diff);
	}
	
	public static void tokenFactory(TokenMetadata metadata, String token, byte[] bytes) throws UnknownHostException
    {
        Token token1 = new StringToken(token);
        InetAddress add1 = InetAddress.getByAddress(bytes);
        metadata.updateNormalToken(token1, add1);
    }

}