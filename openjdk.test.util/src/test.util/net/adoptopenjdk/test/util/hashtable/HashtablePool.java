/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
/**
 * File:    HashtablePool.java
 * Package: net.adoptopenjdk.test.util.hashtable
 */
   
package net.adoptopenjdk.test.util.hashtable;

import java.util.Map;
import java.util.Vector;

/**
 * Despite the name, has been updated to deal with the map interface
 * rather than just Hashtable.
 */
public class HashtablePool implements HashtableFactory {

	private Vector<Map<Object,Object>> pool;
	// needs to be at least 4 to create a serializable hashtable
	public final int POOL_SIZE = 100;
	private int index = 0;
	
	public HashtablePool(HashtableCreator factory)
	{
		pool = new Vector<Map<Object,Object>>(POOL_SIZE);
		for (int i=0; i<POOL_SIZE/4; i++)
		{
			Map<Object,Object> hashtable = factory.getSerializableHashtable();
			pool.add(hashtable);
		}
		for (int i=0; i<POOL_SIZE-(POOL_SIZE/4); i++)
		{
			Map<Object,Object> hashtable = factory.getHashtable();
			pool.add(hashtable);
		}
	}

	public Map<Object,Object> getHashtable() {
		return pool.elementAt(index++ % POOL_SIZE);
	}
	
	public Map<Object,Object> getSerializableHashtable() {
		return pool.elementAt(index++ % (POOL_SIZE/4));
	}
}
