/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
/**
 * File:    HashtableCreator.java
 * Package: net.adoptopenjdk.test.util.hashtable
 */
   
package net.adoptopenjdk.test.util.hashtable;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Various methods for creating and populating map objects for testing.
 * Despite the name HashtableCreator, this class has been updated to
 * return various implementations of the Map interface.
 */
public class HashtableCreator implements HashtableFactory {

	static int counter=0;
	static final int MAX_HASHTABLE_SIZE = 1000;
	static Random random = new Random();
	// used in constructKey method
	static final int COMPARABLE_TYPES = 4, SERIALIZABLE_TYPES = 6, ALL_TYPES = 7;
	
	
	public Map<Object, Object> getHashtable() 
	{
		return constructHashtable(ALL_TYPES, false);
	}
	
	public Map<Object, Object> getSerializableHashtable()
	{
		return constructHashtable(SERIALIZABLE_TYPES, true);
	}

	/**
	 * Get a map.
	 * @param serializable - if true, the returned map may not be serializable
	 * e.g. it may be a WeakHashMap.
	 */
	private Map<Object,Object> constructHashtable(int type, boolean serializable)
	{
		Map<Object,Object> hashtable = null;
		
		int size = 1 + random.nextInt(MAX_HASHTABLE_SIZE);
		int switchModulus = 5;
		if (serializable) {
			switchModulus = 4;
			// This stops the last option in the switch being taken
		}
		switch (counter++ % switchModulus)
		{
		case 0:
			// create hashtable with default constructor
			hashtable = getEmptyMap();
			populateMap(hashtable, size, type);
			break;
		case 1:
			// create some hashtable with initialCapacity constructor
			hashtable = getEmptyMap(size);
			populateMap(hashtable, size, type);
			break;
		case 2:
			// create hashtable from a HashMap
			Map<Object, Object> m2 = new HashMap<Object, Object>();
			populateMap(m2, size, type);
			hashtable = getCopiedMap(m2);
			break;
		case 3:
			// create hashtable from a TreeMap
			Map<Object,Object> m3 = new TreeMap<Object,Object>();
			populateMapWithConstantType(m3, size);
			hashtable = getCopiedMap(m3);
			break;
		default:
			/*
			 * Create a weak hashmap. These need special treatment so that their
			 *  entries don't get garbage collected mid test.
			 * They are not serializable
			 */
			Map<Object,Object> backingMap = getEmptyMap();
			populateMap(backingMap, size, type);
			hashtable = getWeakHashMap(backingMap);
			break;
		}
		return hashtable;
	}

	private void populateMapWithConstantType(Map<Object, Object> map, int size) {
		Object key, value;
		int type = random.nextInt(5);
		
		while (map.size() < size)
		{
			// get a key
			key = constructKey(COMPARABLE_TYPES, type);
			
			// get a value
			value = constructValue(key);
			
			// add to map
			map.put(key, value);
		}
	}

	/**
	 * Populate a map with different keys and values
	 * 
	 * @param map
	 * @param size
	 */
	private void populateMap(Map<Object, Object> map, int size, int type) 
	{
		Object key, value;
		while (map.size() < size)
		{
			// get a key
			key = constructKey(type, counter++);
			// get a value
			value = constructValue(key);
			// add to map
			map.put(key, value);
		}
	}
	
	private Object constructValue(Object key) {
		Object value;
		
		switch (counter++ % 10)
		{
		case 0:
			value = new Integer(1000);
			break;
		case 1:
			value = new BigDecimal(1248390);
			break;
		case 2:
			value = new String("String value");
			break;
		default:
			// wrap the key as a value
			value = new CustomValue(key);
		}
		
		return value;
	}

	private Object constructKey(int type, int seed) {
		Object key;
		// get a key - type either COMPARABLE_TYPES, SERIALIZABLE_TYPES or ALL_TYPES
		switch (seed % type)
		{
		case 0:
			key = new Integer(random.nextInt());
			break;
		case 1:
			key = new String(Double.toString(random.nextDouble()));
			break;
		case 2:
			key = new CustomComparable(counter);
			break;
		case 3:
			key = new BigDecimal(random.nextDouble());
			break;
		// non-comparable types
		case 4:
			Vector<Object> vkey = new Vector<Object>();
			vkey.add(new Integer(10));
			vkey.add(new String("String in a Vector in a Hashtable"));
			key = vkey;
			break;
		case 5:
			Hashtable<Integer, BigDecimal> hkey  = new Hashtable<Integer, BigDecimal>();
			hkey.put(new Integer(10), new BigDecimal(1000000));
			key = hkey;
			break;
		// non-serializable types
		default:	
			// top level Object
			key = new Object();
			break;
		}
		
		return key;
	}

	/**
	 * Get a new empty map object which may be one of various map implementations. 
	 */
	private static Map<Object,Object> getEmptyMap() {

		switch (counter++ % 4) {
		case 0:
			return new Hashtable<Object,Object>();
		case 1:
			return new HashMap<Object,Object>();
		case 2:
			//return new LinkedHashMap<Object,Object>();
		case 3:
			return new ConcurrentHashMap<Object,Object>();
		default:
			assert false;
		}
		// Should never happen
		return null;

	}
	
	
	/**
	 * Get a new empty map object which may be one of various map implementations.
	 * The initial size of the map will be as specified by the size parameter 
	 */
	private static Map<Object,Object> getEmptyMap(int size) {

		switch (counter++ % 4) {
		case 0:
			return new Hashtable<Object,Object>(size);
		case 1:
			return new HashMap<Object,Object>(size);
		case 2:
			//return new LinkedHashMap<Object,Object>(size);
		case 3:
			return new ConcurrentHashMap<Object,Object>(size);
		default:
			assert false;
		}
		// Should never happen
		return null;

	}

	
	/**
	 * Get a new map object which may be one of various map implementations.
	 * The map will be constructed using a copy constructor e.g.
	 * <code>return new Map(m);</code> 
	 */
	private static Map<Object,Object> getCopiedMap(Map<Object,Object> m) {
		switch (counter++ % 4) {
		case 0:
			return new Hashtable<Object,Object>(m);
		case 1:
			return new HashMap<Object,Object>(m);
		case 2:
			//return new LinkedHashMap<Object,Object>(m);
		case 3:
			return new ConcurrentHashMap<Object,Object>(m);
		default:
			assert false;
		}
		// Should never happen
		return null;

	}


	/** Each entry in this map is a hash map. These are backing maps for WeakhashMaps that are
	 * under test. They need to exist for as long as the WeakhashMap is being tested, and then
	 * they need to be released, so that all the entries can be freed. This is achieved using
	 * a PhantomReference queue.
	 */
	static Map<PhantomReference<WeakHashMap<Object,Object>>,Map<Object,Object>> backingMaps = 
			new HashMap<PhantomReference<WeakHashMap<Object,Object>>,Map<Object,Object>>();
	static ReferenceQueue<WeakHashMap<Object,Object>> backingMapQueue =
			new ReferenceQueue <WeakHashMap<Object,Object>>();
	/*
	 * Start a thread to take objects off the ReferenceQueue and free
	 * the related backing map.
	 */
	static
	{
		Thread backingMapCleanup = new Thread(new Runnable(){
			public void run() {
				while(true) {
					try {
						Reference<?> removedRef = backingMapQueue.remove(5000);
						if (removedRef == null) {
							continue;
						}
						synchronized(backingMaps)
						{
							backingMaps.remove(removedRef);
						}
					} catch (InterruptedException e) {
						continue;
					}
				}
			}
		});
		backingMapCleanup.setDaemon(true);
		backingMapCleanup.setName("HashtableTest backingmap cleanup thread");
		backingMapCleanup.start();
		
	}

	
	private Map<Object,Object> getWeakHashMap(Map<Object,Object> backingMap) {
		/*
		 * Construct a weak hash map by copying the backingMap
		 * The backing map must be kept alive as long as the returned map is
		 * in scope, otherwise the contents will all end up garbage collected.
		 * Track the WeakhashMap using a PhantomReference queue, so that the 
		 * backingmaps can be freed when the WeakHashMap has been GC.
		 */
		WeakHashMap<Object,Object> rv = new WeakHashMap<Object,Object>(backingMap);
		PhantomReference<WeakHashMap<Object,Object>> ref =
				new PhantomReference<WeakHashMap<Object,Object>>(rv, backingMapQueue);
		
		synchronized(backingMaps){
			backingMaps.put(ref, backingMap);
		}
		
		return rv;
	}

}
