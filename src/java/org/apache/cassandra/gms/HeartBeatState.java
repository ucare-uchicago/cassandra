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

import java.io.*;
import java.net.InetAddress;

import org.apache.cassandra.db.TypeSizes;
import org.apache.cassandra.io.IVersionedSerializer;

/**
 * HeartBeat State associated with any given endpoint.
 */
public class HeartBeatState
{
    public static final IVersionedSerializer<HeartBeatState> serializer = new HeartBeatStateSerializer();

    private int generation;
    private int version;
    
    public HeartBeatState(int gen)
    {
        this(gen, 0);
    }

    public HeartBeatState(int gen, int ver)
    {
        generation = gen;
        version = ver;
    }

    public int getGeneration()
    {
        return generation;
    }

    public void updateHeartBeat()
    {
        version = VersionGenerator.getNextVersion();
    }

    public void updateHeartBeat(InetAddress address)
    {
        version = VersionGenerator.getNextVersion(address);
    }
    public int getHeartBeatVersion()
    {
        return version;
    }

    public void forceNewerGenerationUnsafe()
    {
        generation += 1;
    }

    public String toString()
    {
        return String.format("HeartBeat: generation = %d, version = %d", generation, version);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + generation;
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeartBeatState other = (HeartBeatState) obj;
		if (generation != other.generation)
			return false;
		if (version != other.version)
			return false;
		return true;
	}
	
	public HeartBeatState copy() {
	    return new HeartBeatState(generation, version);
	}
}

class HeartBeatStateSerializer implements IVersionedSerializer<HeartBeatState>
{
    public void serialize(HeartBeatState hbState, DataOutput dos, int version) throws IOException
    {
        dos.writeInt(hbState.getGeneration());
        dos.writeInt(hbState.getHeartBeatVersion());
    }

    public HeartBeatState deserialize(DataInput dis, int version) throws IOException
    {
        return new HeartBeatState(dis.readInt(), dis.readInt());
    }

    public long serializedSize(HeartBeatState state, int version)
    {
        return TypeSizes.NATIVE.sizeof(state.getGeneration()) + TypeSizes.NATIVE.sizeof(state.getHeartBeatVersion());
    }
}
