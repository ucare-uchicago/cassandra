/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.gms;

import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.MessageIn;
import org.apache.cassandra.net.MessagingService;

import edu.uchicago.cs.ucare.cassandra.gms.GossiperStub;
import edu.uchicago.cs.ucare.cassandra.gms.WholeClusterSimulator;

public class SimulatedGossipDigestAckVerbHandler implements IVerbHandler<GossipDigestAck>
{
    private static final Logger logger = LoggerFactory.getLogger(SimulatedGossipDigestAckVerbHandler.class);
    private static final Map<String, byte[]> emptyMap = Collections.<String, byte[]>emptyMap();
    
    @SuppressWarnings("unchecked")
    public void doVerb(MessageIn<GossipDigestAck> message, String id)
    {
        long receiveTime = System.currentTimeMillis();
        InetAddress from = message.from;
        InetAddress to = message.to;

        GossipDigestAck gDigestAckMessage = message.payload;
        List<GossipDigest> gDigestList = gDigestAckMessage.getGossipDigestList();
        Map<InetAddress, EndpointState> epStateMap = gDigestAckMessage.getEndpointStateMap();
        
        GossiperStub receiverStub = WholeClusterSimulator.stubGroup.getStub(to);
        GossiperStub senderStub = WholeClusterSimulator.stubGroup.getStub(from);

        if ( epStateMap.size() > 0 ) {
            /* Notify the Failure Detector */
//            Gossiper.instance.notifyFailureDetector(epStateMap);
//            Gossiper.instance.applyStateLocally(epStateMap);
            Gossiper.notifyFailureDetectorStatic(receiverStub, receiverStub.getEndpointStateMap(), 
                    epStateMap, receiverStub.getFailureDetector());
            Gossiper.applyStateLocallyStatic(receiverStub, epStateMap);
        }

        Gossiper.instance.checkSeedContact(from);

        /* Get the state required to send to this gossipee - construct GossipDigestAck2Message */
        Map<InetAddress, EndpointState> deltaEpStateMap = new HashMap<InetAddress, EndpointState>();
        for( GossipDigest gDigest : gDigestList ) {
            InetAddress addr = gDigest.getEndpoint();
            EndpointState localEpStatePtr = Gossiper.getStateForVersionBiggerThanStatic(receiverStub.getEndpointStateMap(),
                    addr, gDigest.getMaxVersion());
            if ( localEpStatePtr != null )
                deltaEpStateMap.put(addr, localEpStatePtr.copy());
        }

        Map<InetAddress, EndpointState> localEpStateMap = receiverStub.getEndpointStateMap();
        for (InetAddress sendingAddress : deltaEpStateMap.keySet()) {
            deltaEpStateMap.get(sendingAddress).setHopNum(localEpStateMap.get(sendingAddress).hopNum);
        }
        MessageIn<GossipDigestAck2> gDigestAck2Message = 
                MessageIn.create(to,  new GossipDigestAck2(deltaEpStateMap, message.payload.syncId, message.payload.msgId), 
                        emptyMap, MessagingService.Verb.GOSSIP_DIGEST_ACK2, MessagingService.VERSION_12);
        gDigestAck2Message.setTo(from);
        gDigestAck2Message.createdTime = System.currentTimeMillis();
        WholeClusterSimulator.sendMessage(gDigestAck2Message);
//        WholeClusterSimulator.msgQueues.get(from).add(gDigestAck2Message);
//        WholeClusterSimulator.msgQueue.add(gDigestAck2Message);
        WholeClusterSimulator.isProcessing.get(to).set(false);

        long doneTime = System.currentTimeMillis();
        logIt(receiverStub, message, receiveTime, doneTime);
    }

    private Set<Map.Entry<Token, InetAddress>> prevMap = new HashSet<Map.Entry<Token, InetAddress>>();

    private void logIt(GossiperStub receiverStub, MessageIn message, long receiveTime, long doneTime){
      int tokenToEndpointMapHash = receiverStub.getTokenMetadata().tokenToEndpointMap.hashCode();
      Set<Map.Entry<Token, InetAddress>> currMap = receiverStub.getTokenMetadata().tokenToEndpointMap.entrySet();

      String logMsg = "receivedMessage: " + message.hashCode() + " from " + message.from
          + " recTime: " + receiveTime + " doneTime: " + doneTime + " elapsedTime: " + (doneTime-receiveTime)
          + " STATE_BEGIN: tokenToEndpointMap: " + tokenToEndpointMapHash;
      if (!currMap.equals(prevMap)){
        logMsg += " STATE_END tokenMetadata: " + receiverStub.getTokenMetadata().tokenToEndpointMap.entrySet().toString();
        prevMap = new HashSet<Map.Entry<Token, InetAddress>>(currMap);
      }
      logger.info(logMsg);
    }
}
