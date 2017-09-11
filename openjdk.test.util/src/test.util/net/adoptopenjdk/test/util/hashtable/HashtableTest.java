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
 * File:    HashtableTest.java
 * Package: net.adoptopenjdk.test.util.hashtable
 */
   
package net.adoptopenjdk.test.util.hashtable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import junit.framework.TestCase;

/**
 * Junit test for Hashtable class
 * - Uses both local and long-running pool objects
 * - Exercises specific Hashtable API functions
 * - Tests serialization of Hashtables and their keys and values
 * - Stress tests adding and removing elements
 */
public class HashtableTest extends TestCase {
	static HashtableFactory pool;
	static HashtableCreator factory;
	static Random random = new Random(38912048);

	static
	{
		factory = new HashtableCreator();
		pool = new HashtablePool(factory);
	}
	
	public void testLocalHashtableAPI()
	{
		Map<Object,Object> table = factory.getHashtable();
		doAPITest(table);
	}
	
	public void testPoolHashtableAPI()
	{
		Map<Object,Object> table = pool.getHashtable();
		synchronized (table)
		{
			doAPITest(table);
		}
	}
	
	/**
	 * Exercise API functions on the hashtable argument
	 * @param table
	 */
	private void doAPITest(Map<Object,Object> table) {
		int size = table.size();
		Object key, value;
		
		Map<Object,Object> clone = cloneMap(table);
		
		// retrieve values using values()
		Collection<Object> values = table.values();
		
		// retrieve keys using keySet()
		Set<Object> keySet = table.keySet();		
		Object[] keySetArray = keySet.toArray();
		
		int step = 1 + random.nextInt(5);
		
		for (int i=0; i<keySetArray.length; i=i+step)
		{
			key = keySetArray[i];
			// retrieve value
			value = table.get(key);
			
			// assert value is in the table
			assertTrue(table.containsValue(value));
			/*
			 * assertTrue(table.contains(value)); // Removed as not supported by the Map interface, and identical to containsValue
			 * if value is a wrapped key then check it's equal 
			 * to the key 
			 */
			if (value instanceof CustomValue)
			{
				assertEquals(key, ((CustomValue)value).key);
			}
			
			// count how many occurrences of this value there are
			int occurrences = numberOccurrences(values, value);
			
			// find the Map.Entry
			Set<Map.Entry<Object, Object>> entrySet =  table.entrySet();
			Iterator<Map.Entry<Object, Object>> entrySetIterator = entrySet.iterator();
			Map.Entry<Object,Object> entry = null;
			do
			{
				entry = entrySetIterator.next();
			} while (!entry.getKey().equals(key));
			
			// remove from table in different ways
			switch (i % 3)
			{
			case 0:
				table.remove(key);
				break;
			case 1:
				keySet.remove(key);
				break;
			default:
				
				entrySet.remove(entry);
			}
			
			// assert key is no longer in the table
			assertFalse(table.containsKey(key));
			// assert key is no longer in the keyset
			assertFalse(keySet.contains(key));
			// assert key is no longer in the entrySet
			assertFalse(entrySet.contains(entry));
			
			// assert that there's one fewer of this value in the hashtable
			assertEquals(occurrences, numberOccurrences(values, value) + 1);
			
			// re-insert key
			table.put(key, value);
			
			// assert key is in the table
			assertTrue(table.containsKey(key));
			// assert key is in the keyset
			assertTrue(keySet.contains(key));
			// assert EntrySet is same size
			assertEquals(size, entrySet.size());
		}
		
		// test hashtable is the same size
		assertEquals(size, table.size());
		
		// test keySet is expected size
		assertEquals(size, keySet.size());
		
		// retrieve keys using keys()
		Iterator<?> keys = table.keySet().iterator();
		
		// remove a subset of elements from the table. store in a map
		int counter = table.size() / 4;
		Map<Object,Object> map = new HashMap<Object, Object>();
		while (keys.hasNext() && counter-- >= 0)
		{
			key = keys.next();
			value = table.get(key);
			map.put(key, value);
			keys.remove(); // removes the most recent retrieved element
		}
		// re-add the elements using putAll
		table.putAll(map);
		
		// test equal to copy
		assertEquals(clone, table);
		
		// clear the copy
		clone.clear();
		
		// assert size of clone is zero
		assertEquals(0, clone.size());
		
		// assert size of original is the same
		assertEquals(size, table.size());
	}

	private int numberOccurrences(Collection<Object> values, Object value) {
		Iterator<Object> it = values.iterator();
		int count = 0;
		while (it.hasNext())
		{
			Object next = it.next();
			if (next.equals(value))
			{
				count++;
			}
		}
		return count;
	}
	
	public void testLocalHashtableSerializable()
	{
		Map<Object,Object> table = factory.getSerializableHashtable();
		doSerializationTest(table);
	}
	
	public void testPoolHashtableSerializable()
	{
		Map<Object,Object> table = pool.getSerializableHashtable();
		synchronized (table)
		{
			doSerializationTest(table);
		}
	}
	
	private void doSerializationTest(Map<Object,Object> table) {
		byte[] bytes = null;
		Object in = null;

		// write out object
		try {
			bytes = writeOutObject(table);
		} catch (NotSerializableException e) {
			fail("Expected object " + table + " to be serializable");
		}
		
		// read object back in
		in = bytesToObject(bytes);
		
		// compare object
		assertEquals("Comparison failed for test " + table,
				table, in);
	}

	private Object bytesToObject(byte[] ref) {
		Object toReturn = null;
		ByteArrayInputStream bais = new ByteArrayInputStream(ref);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(bais);
			try {
				toReturn = ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
			bais.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	private byte[] writeOutObject(Object object) throws NotSerializableException
	{
		byte[] toReturn = null;
		// create an ObjectOutputStream
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream ();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream (byteOutputStream);
		} catch (IOException e) {
			fail("IOException creating ObjectOutputStream " + object);
			e.printStackTrace();
		}
		try
		{
			// write object
			oos.writeObject(object);
		} catch (NotSerializableException e) {
			throw e;
		} catch (IOException e) {
			fail("IOException writing out object " + object);
			e.printStackTrace();
		}
		
		toReturn = byteOutputStream.toByteArray();
		
		try
		{
			byteOutputStream.close();
			
		} catch (IOException e) {
			fail("IOException closing object stream " + object);
			e.printStackTrace();
		}
		
		return toReturn;
	}

	public void testLocalHashtableStress()
	{
		Map<Object,Object> table = factory.getHashtable();
		doStressTest(table);
	}

	public void testPoolHashtableStress()
	{
		Map<Object,Object> table = pool.getHashtable();
		synchronized (table)
		{
			doStressTest(table);
		}
	}
	
	private void doStressTest(Map<Object,Object> table) {
		Set<Map.Entry<Object,Object>> entrySet = (Set<Map.Entry<Object,Object>>)table.entrySet();
		
		Object[] entrySetArray = entrySet.toArray();
		int size = table.size();
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		
		// remove every other element
		for (int i=0; i<entrySetArray.length; i=i+2)
		{
			@SuppressWarnings("unchecked")
			Map.Entry<Object,Object> entry = (Map.Entry<Object,Object>) entrySetArray[i];
			map.put(entry.getKey(), entry.getValue());
			table.remove(entry.getKey());
		}
		// assert the table is half the size
		assertEquals(size / 2, table.size());
		
		// re-add the removed elements
		Iterator<Map.Entry<Object,Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext())
		{
			Map.Entry<?,?> entry = iterator.next();
			table.put(entry.getKey(), entry.getValue());
		}
		
		assertEquals(size, table.size());
		// check the contents
		Iterator<Object> keyIterator = table.keySet().iterator();
		while (keyIterator.hasNext())
		{
			// if value is a wrapped key then check it's equal to the key 
			Object key = keyIterator.next();
			Object value = table.get(key);
			if (value instanceof CustomValue)
			{
				assertEquals(key, ((CustomValue)value).key);
			}
		}
	}

	/**
	 * Not all implementations of Map support the clone interface, so clone
	 * where possible, or do our own version of clone. 
	 */
	@SuppressWarnings("unchecked")
	Map<Object,Object> cloneMap(Map<Object,Object> toClone) {

		if (toClone instanceof Hashtable) {
			return (Map<Object, Object>)((Hashtable<?, ?>)toClone).clone();
		}
		if (toClone instanceof HashMap) {
			return (Map<Object,Object>)((HashMap<Object,Object>)toClone).clone();
		}
 		if (toClone instanceof LinkedHashMap) {
			return (Map<Object,Object>)((LinkedHashMap<Object,Object>)toClone).clone();
		}
		
		Map<Object,Object> cloned = null;
		if (toClone instanceof WeakHashMap) {
			cloned = new WeakHashMap<Object,Object>();
		} else if (toClone instanceof ConcurrentHashMap){
			cloned = new ConcurrentHashMap<Object,Object>();
		} else {
			throw new RuntimeException("Unexpected subclass of Map");
		}
		
		Set<Object> keys = toClone.keySet();
		for (Object key: keys) {
			cloned.put(key, toClone.get(key));
		}
		return cloned;
		
	}
}
