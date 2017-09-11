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
 * File:    ConcurrentHashMapTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.NoSuchElementException;

/**
 * ConcurrentHashMapTest
 * ======================
 * 
 * Attempts to verify the correct function of the ConcurrentHashMap class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of ConcurrentHashMap
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ConcurrentHashMap
 * 							NOTE : This shared instance is separate to the instance used in testAPI()
 * 						-	API calls are not checked
 * 						-	Attempting to provoke a JIT response through repeated calls of the various API calls
 * 
 * This testcase makes use of class variables i.e. variables declared as 'static'. Usually this is a definite no-no
 * when it comes to tests run under a multithreaded stress testing engine. However, testing of many of the classes
 * in the java.util.concurrent package necessarily involves multiple threads accessing and modifying the same single data source.
 * This testcase was therefore designed to be run multiple times concurrently in such a way that threads do not interfere with
 * each other and cause incorrect results.
 */

public class ConcurrentHashMapTest extends ConcurrentTest
{
	// hashmap is not defined as static and is therefore not accessed concurrently by multiple threads
	// hashmap is instead used as a method of verifying the correct behaviour of the API
	private ConcurrentHashMap<String,Integer> hashmap = new ConcurrentHashMap<String,Integer>();

	// stressmap is defined as static and is therefore accessed concurrently by multiple threads
	private static ConcurrentHashMap<String,Integer> stressmap = new ConcurrentHashMap<String,Integer>();	

	/**
	 * Verify the correct behaviour of the API for ConcurrentSkipListMap. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// =================================================================================
		// Create some test data to work with

		String testKey = buildString();
		String randomKey = "";
		Integer randomValue = rng.nextInt(50);
		Integer testValue = 50 + rng.nextInt(Integer.MAX_VALUE - 50);
		Integer alternateTestValue = rng.nextInt();

		// Make sure that the test values not the same.
		while(testValue.equals(alternateTestValue))
		{
			alternateTestValue = rng.nextInt();
		}
		
		ConcurrentHashMap<String,Integer> testObjects = new ConcurrentHashMap<String,Integer>();

		for( int i = 0; i < 50; i++)
		{
			String key = buildString();
			testObjects.put(key, i);

			// Select a key from all of those added to the hashmap for later use
			if(i == randomValue)
			{
				randomKey = key;
			}
		}

		hashmap.putAll(testObjects);

		// =================================================================================
		// Basic API testing

		assertEquals("1 : size()", false, hashmap.size() == 0);
		assertEquals("2 : isEmpty()", false, hashmap.isEmpty());

		hashmap.clear(); 
		assertEquals("3 : size()", 0, hashmap.size());
		assertEquals("4 : isEmpty()", true, hashmap.isEmpty());

		assertEquals("5 : put()", null, hashmap.put(testKey, testValue));
		assertEquals("6 : size()", 1, hashmap.size());
		assertEquals("7 : isEmpty()", false, hashmap.isEmpty());
		assertEquals("8 : contains()", true, hashmap.contains(testValue));
		assertEquals("9 : containsKey()", true, hashmap.containsKey(testKey));
		assertEquals("10 : containsValue()", true, hashmap.containsValue(testValue));

		assertEquals("11 : put()", testValue, hashmap.put(testKey, alternateTestValue));
		assertEquals("12 : size()", 1, hashmap.size());
		assertEquals("13 : isEmpty()", false, hashmap.isEmpty());
		assertEquals("14 : contains() [testValue=" + testValue + ",alternateTestValue=" + alternateTestValue + "]", false, hashmap.contains(testValue));
		assertEquals("15 : containsKey()", true, hashmap.containsKey(testKey));
		assertEquals("16 : containsValue()", false, hashmap.containsValue(testValue));
		assertEquals("17 : contains()", true, hashmap.contains(alternateTestValue));
		assertEquals("18 : containsKey()", true, hashmap.containsKey(testKey));
		assertEquals("19 : containsValue()", true, hashmap.containsValue(alternateTestValue));

		hashmap.clear();
		assertEquals("20 : size()", 0, hashmap.size());
		assertEquals("21 : isEmpty()", true, hashmap.isEmpty());

		hashmap.putAll(testObjects);
		assertEquals("22 : size()", hashmap.size(), testObjects.size());

		// =================================================================================
		// Now some more involved checks of the contents of the hash map

		// Iterating over the elements and checking that each is present in the hashmap
		Enumeration<Integer> elements = testObjects.elements();
		while(elements.hasMoreElements())
		{
			Integer nextValue = elements.nextElement();
			assertEquals("23 : containsValue()", true, hashmap.containsValue(nextValue));
			assertEquals("24 : contains()", true, hashmap.contains(nextValue));
		}

		assertEquals("25 : containsKey()", true, hashmap.containsKey(randomKey));
		assertEquals("26 : get()", randomValue, hashmap.get(randomKey));
		assertEquals("27 : containsValue()", true, hashmap.containsValue(randomValue));
		assertEquals("28 : contains()", true, hashmap.contains(randomValue));

		// Iterating over all of the elements from testObjects and checking they are all present in the hashmap
		elements = testObjects.elements();
		while(elements.hasMoreElements())
		{
			Integer nextValue = elements.nextElement();
			assertEquals("29 : containsValue()", true, hashmap.containsValue(nextValue));
			assertEquals("30 : contains()", true, hashmap.contains(nextValue));
		}

		// Iterating over all of the values in testObjects and checking that they are all present in the hashmap
		Collection<Integer> values = testObjects.values();
		Iterator<Integer> itr = values.iterator();
		while(itr.hasNext())
		{
			Integer nextValue = itr.next();
			assertEquals("31 : containsValue()", true, hashmap.containsValue(nextValue));
			assertEquals("32 : contains()", true, hashmap.contains(nextValue));
		}

		// Iterating over all of the keys in testObjects and checking that they are all present in the hashmap
		Enumeration<String> keys = testObjects.keys();
		while(keys.hasMoreElements())
		{
			String nextKey = keys.nextElement();
			assertEquals("33 : containsKey()", true, hashmap.containsKey(nextKey));
		}

		// Iterating over all of the entries in testObjects and checking that they are all in the hashmap
		Set<Entry<String, Integer>> entries = testObjects.entrySet();
		Iterator<Entry<String, Integer>> itr2 = entries.iterator();
		while(itr2.hasNext())
		{
			Entry<String, Integer> nextEntry = itr2.next();
			assertEquals("34 : containsKey()", true, hashmap.containsKey(nextEntry.getKey()));
			assertEquals("35 : containsValue()", true, hashmap.containsValue(nextEntry.getValue()));
		}

		// Iterating over all the keys in the keySet of testObjects and checking that they are all in the hashmap
		Set<String> keySet = testObjects.keySet();
		Iterator<String> itr3 = keySet.iterator();
		while(itr3.hasNext())
		{
			String nextKey = itr3.next();
			assertEquals("36 : containsKey()", true, hashmap.containsKey(nextKey));
			assertEquals("37 : contains()", true, hashmap.contains(hashmap.get(nextKey)));
		}

		// =================================================================================
		// Next, operations that change the contents of the hashmap under test

		// Add elements into the hashmap attempting to add each element twice ...
		// ... however, as this is a hashmap each element can appear only once ...
		ConcurrentHashMap<String,Integer> moreTestObjects = new ConcurrentHashMap<String,Integer>();

		for( int i = 0; i < 10; i++)
		{
			String key = buildString();
			testObjects.put(key, rng.nextInt());
		}

		hashmap.putAll(moreTestObjects);
		hashmap.putAll(moreTestObjects);

		// ... remove each of the elements that were added ...
		Iterator<String> itr5 = moreTestObjects.keySet().iterator();
		while(itr5.hasNext())
		{
			String nextKey = itr5.next();
			hashmap.remove(nextKey);
		}

		// ... check that the elements have really been removed and were not added twice
		Iterator<String> itr6 = moreTestObjects.keySet().iterator();
		while(itr6.hasNext())
		{
			String nextKey = itr6.next();
			assertEquals("38 : containsKey()", true, hashmap.containsKey(nextKey));
		}

		// Verifying the behaviour of putIfAbsent
		hashmap.remove(testKey);
		assertEquals("39 : putIfAbsent()", null, hashmap.putIfAbsent(testKey, testValue));					// key isn't present so set it
		assertEquals("40 : putIfAbsent()", testValue, hashmap.putIfAbsent(testKey, alternateTestValue));	// key is present so don't change it
		assertEquals("41 : get()", testValue, hashmap.get(testKey));										// verify that key wasn't changed
		hashmap.remove(testKey);

		// =================================================================================
		// Removes and Replaces only where the value stored at a given key matches
		// with the value specified in the API call.

		// The while loop below has the effect of removing every other key contained in localHashmap
		Iterator<String> itr7 = hashmap.keySet().iterator();
		while(itr7.hasNext())
		{
			String nextKey = itr7.next();
			Integer nextValue = hashmap.get(nextKey);

			if(nextValue.intValue() % 2 == 0)
			{	
				assertEquals("42 : remove()", true, hashmap.remove(nextKey, nextValue));				// remove the element
				assertEquals("43 : containsKey()", false, hashmap.containsKey(nextKey));
			}
			else
			{
				assertEquals("44 : remove()", false, hashmap.remove(nextKey, -1));						// won't remove the element as the value doesn't match
				assertEquals("45 : containsValue()", true, hashmap.containsValue(nextValue));			// ... and hence the value is still present
			}
		}

		// At this point the hashmap contains only half of the keys in testObjects
		// The while loop below is testing replace() where the key exists and doesn't exist.
		// Where the key existed, it is removed after testing in effect removing any remaining elements added to the hashmap during this thread's execution of testAPI (prevents excess memory usage)
		Iterator<String> itr8 = testObjects.keySet().iterator();
		while(itr8.hasNext())
		{
			String nextKey = itr8.next();
			Integer nextValue = testObjects.get(nextKey);
			Integer nextValue2 = nextValue * nextValue;

			if(hashmap.containsKey(nextKey))
			{
				assertEquals("46 : get()", nextValue, hashmap.get(nextKey));							// Unchanged so should still be the same

				hashmap.replace(nextKey, nextValue2);													// Replace with square of value

				assertEquals("47 : replace()", nextValue2, hashmap.get(nextKey));						// Check that the value changed
				assertEquals("48 : replace()", nextValue2.intValue(), hashmap.get(nextKey).intValue());	// Check that it changed to the correct value

				hashmap.replace(nextKey, nextValue, nextValue);											// Try to change the value with an incorrect old value...
				assertEquals("49 : replace()", nextValue2, hashmap.get(nextKey));						// ... verify that nothing changed


				hashmap.replace(nextKey, nextValue2, nextValue);										// Try to change the value with the correct old value...				
				assertEquals("50 : replace()", nextValue, hashmap.get(nextKey));						// ... verify that something changed
				assertEquals("51 : replace()", nextValue.intValue(), hashmap.get(nextKey).intValue());	// ... verify that the change was correct

				hashmap.remove(nextKey);																// Tidy up after ourselves
			}
			else
			{
				assertEquals("52 : replace()", null, hashmap.replace(nextKey, nextValue2));				// Shouldn't do anything as nextKey isn't in the map
				assertEquals("53 : replace()", false, hashmap.containsKey(nextKey));
			}
		}
	}

	/**
	 * Makes use of stressmap to test multiple threads concurrent accessing and updating a single shared
	 * instance of ConcurrentHashMap. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{	
		// Some data for use below
		String randomKey = buildString();
		Integer randomValue = rng.nextInt();
		ConcurrentHashMap<String,Integer> testObjects = new ConcurrentHashMap<String,Integer>();
		for(int i = 0; i < rng.nextInt(40); i++)
		{
			testObjects.put(buildString(), rng.nextInt());
		}

		// make sure we have some items to work with and if not make some
		while(stressmap.size() < 300)
		{
			stressmap.put(buildString(), rng.nextInt());
		}

		// make sure we don't use up too much memory
		while(stressmap.size() > 500)
		{
			stressmap.remove(stressmap.keys().nextElement());
		}

		// =================================================================================
		// Testing starts here

		try
		{
			stressmap.containsKey(randomKey);
			Enumeration<String> keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.put(randomKey, randomValue);
			Iterator<Entry<String,Integer>> itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.contains(randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			Enumeration<Integer> elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.get(randomKey);
			stressmap.remove(randomKey, randomValue);
			stressmap.equals(testObjects);
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.putAll(testObjects);
			stressmap.put(randomKey, randomValue);
			stressmap.remove(randomKey);
			stressmap.toString();
			stressmap.toString();
			stressmap.put(randomKey, randomValue);
			stressmap.get(randomKey);
			stressmap.isEmpty();
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			Iterator<String> itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.equals(testObjects);
			stressmap.remove(randomKey, randomValue);
			stressmap.get(randomKey);
			stressmap.putAll(testObjects);
			stressmap.containsKey(randomKey);
			stressmap.equals(testObjects);
			stressmap.isEmpty();
			stressmap.put(randomKey, 0);
			stressmap.remove(randomKey, randomValue);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.toString();
			stressmap.remove(randomKey, randomValue);
			stressmap.isEmpty();
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.remove(randomKey, randomValue);
			stressmap.putAll(testObjects);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.remove(randomKey, randomValue);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.equals(stressmap);
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.get(randomKey);
			stressmap.isEmpty();
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.putAll(testObjects);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.toString();
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.contains(randomValue);
			stressmap.containsKey(randomKey);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.equals(stressmap);
			stressmap.contains(randomValue);
			stressmap.equals(testObjects);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.containsKey(randomKey);
			stressmap.remove(randomKey, randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.contains(randomValue);
			stressmap.containsKey(randomKey);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.isEmpty();
			stressmap.contains(randomValue);
			stressmap.containsValue(randomValue);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.remove(randomKey);
			stressmap.equals(stressmap);
			stressmap.size();
			stressmap.remove(randomKey, randomValue);
			stressmap.remove(randomKey);
			stressmap.isEmpty();
			stressmap.put(randomKey, 0);
			stressmap.equals(testObjects);
			stressmap.remove(randomKey);
			stressmap.put(randomKey, 0);
			stressmap.put(randomKey, 0);
			stressmap.remove(randomKey, randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.get(testObjects.keySet().iterator().next());
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.put(randomKey, randomValue);
			stressmap.contains(randomValue);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.contains(randomValue);
			stressmap.equals(testObjects);
			stressmap.containsValue(randomValue);
			stressmap.putAll(testObjects);
			stressmap.remove(randomKey, randomValue);
			stressmap.containsKey(randomKey);
			stressmap.put(randomKey, randomValue);
			stressmap.replace(randomKey, 0);
			Iterator<Integer> itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.put(randomKey, randomValue);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.size();
			stressmap.replace(randomKey, 0, randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.contains(randomValue);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.containsKey(randomKey);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.replace(randomKey, 0);
			stressmap.putAll(testObjects);
			stressmap.remove(randomKey, randomValue);
			stressmap.put(randomKey, 0);
			stressmap.isEmpty();
			stressmap.put(randomKey, 0);
			stressmap.containsKey(randomKey);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.equals(stressmap);
			stressmap.replace(randomKey, 0);
			stressmap.put(randomKey, randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.contains(randomValue);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.contains(randomValue);
			stressmap.containsValue(randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.isEmpty();
			stressmap.equals(stressmap);
			stressmap.putIfAbsent(randomKey, randomValue);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.containsValue(randomValue);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.remove(randomKey, randomValue);
			stressmap.put(randomKey, 0);
			stressmap.equals(testObjects);
			stressmap.containsValue(randomValue);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.remove(randomKey);
			stressmap.equals(stressmap);
			stressmap.put(randomKey, 0);
			stressmap.containsKey(randomKey);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.size();
			stressmap.contains(randomValue);
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.size();
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.remove(randomKey);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.putAll(testObjects);
			stressmap.isEmpty();
			stressmap.toString();
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.contains(randomValue);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.toString();
			stressmap.remove(randomKey);
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.putAll(testObjects);
			stressmap.equals(stressmap);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.remove(randomKey, randomValue);
			stressmap.replace(randomKey, 0, randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.put(randomKey, 0);
			stressmap.replace(randomKey, 0);
			stressmap.size();
			stressmap.containsValue(randomValue);
			stressmap.equals(stressmap);
			stressmap.toString();
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.contains(randomValue);
			stressmap.get(randomKey);
			stressmap.put(randomKey, 0);
			stressmap.isEmpty();
			stressmap.replace(randomKey, 0);
			stressmap.contains(randomValue);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.contains(randomValue);
			stressmap.get(randomKey);
			stressmap.get(randomKey);
			stressmap.replace(randomKey, 0);
			stressmap.remove(randomKey, randomValue);
			stressmap.put(randomKey, randomValue);
			stressmap.size();
			stressmap.isEmpty();
			stressmap.putAll(testObjects);
			stressmap.remove(randomKey);
			stressmap.putAll(testObjects);
			stressmap.putIfAbsent(randomKey, randomValue);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.replace(randomKey, 0);
			stressmap.replace(randomKey, 0);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.put(randomKey, randomValue);
			stressmap.containsValue(randomValue);
			stressmap.equals(testObjects);
			stressmap.toString();
			stressmap.put(randomKey, 0);
			stressmap.get(testObjects.keySet().iterator().next());
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.toString();
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.toString();
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.remove(randomKey, randomValue);
			stressmap.equals(stressmap);
			stressmap.containsKey(randomKey);
			stressmap.put(randomKey, 0);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.containsValue(randomValue);
			stressmap.replace(randomKey, 0);
			stressmap.put(randomKey, randomValue);
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.remove(randomKey, randomValue);
			stressmap.put(randomKey, randomValue);
			stressmap.putAll(testObjects);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.put(randomKey, 0);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.get(randomKey);
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.size();
			stressmap.put(randomKey, randomValue);
			stressmap.put(randomKey, 0);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.put(randomKey, 0);
			stressmap.containsValue(randomValue);
			stressmap.contains(randomValue);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.remove(randomKey);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.put(randomKey, randomValue);
			stressmap.putAll(testObjects);
			stressmap.putAll(testObjects);
			stressmap.contains(randomValue);
			stressmap.equals(stressmap);
			stressmap.containsValue(randomValue);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.equals(stressmap);
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.contains(randomValue);
			stressmap.put(randomKey, 0);
			stressmap.containsValue(randomValue);
			stressmap.equals(stressmap);
			stressmap.equals(testObjects);
			stressmap.remove(randomKey);
			stressmap.equals(stressmap);
			stressmap.equals(testObjects);
			stressmap.put(randomKey, 0);
			stressmap.put(randomKey, randomValue);
			stressmap.putAll(testObjects);
			stressmap.contains(randomValue);
			stressmap.remove(randomKey);
			stressmap.get(testObjects.keySet().iterator().next());
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.remove(randomKey);
			stressmap.get(randomKey);
			stressmap.containsKey(randomKey);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.contains(randomValue);
			stressmap.equals(testObjects);
			stressmap.toString();
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.put(randomKey, 0);
			stressmap.size();
			stressmap.put(randomKey, 0);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.toString();
			stressmap.put(randomKey, 0);
			stressmap.put(randomKey, randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.containsValue(randomValue);
			stressmap.putAll(testObjects);
			stressmap.put(randomKey, 0);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.isEmpty();
			stressmap.remove(randomKey);
			stressmap.replace(randomKey, 0);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.toString();
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.equals(stressmap);
			stressmap.containsValue(randomValue);
			stressmap.put(randomKey, 0);
			stressmap.replace(randomKey, 0);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.get(randomKey);
			stressmap.equals(stressmap);
			stressmap.putAll(testObjects);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.size();
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.remove(randomKey, randomValue);
			stressmap.equals(testObjects);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.putAll(testObjects);
			stressmap.containsKey(randomKey);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.remove(randomKey);
			stressmap.remove(randomKey, randomValue);
			stressmap.put(randomKey, 0);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.remove(randomKey, randomValue);
			stressmap.replace(randomKey, 0);
			stressmap.get(testObjects.keySet().iterator().next());
			stressmap.toString();
			stressmap.remove(randomKey);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.equals(testObjects);
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.get(randomKey);
			stressmap.put(randomKey, 0);
			stressmap.equals(testObjects);
			stressmap.isEmpty();
			stressmap.replace(randomKey, 0);
			stressmap.get(randomKey);
			stressmap.put(randomKey, randomValue);
			stressmap.containsValue(randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.get(randomKey);
			stressmap.isEmpty();
			stressmap.putAll(testObjects);
			stressmap.put(randomKey, 0);
			stressmap.contains(randomValue);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.equals(testObjects);
			stressmap.put(randomKey, 0);
			stressmap.replace(randomKey, 0);
			stressmap.replace(randomKey, 0, randomValue);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.replace(randomKey, 0);
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.size();
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.containsKey(randomKey);
			stressmap.equals(stressmap);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.size();
			itr = stressmap.entrySet().iterator();
			while(itr.hasNext())
			{
				Entry<String,Integer> nextEntry = itr.next();
				stressmap.replace(nextEntry.getKey(), nextEntry.getValue() - 1);
			}
			stressmap.put(randomKey, 0);
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.isEmpty();
			itr2 = stressmap.keySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.containsKey(itr2.next());
			}
			stressmap.size();
			stressmap.contains(randomValue);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.equals(testObjects);
			stressmap.containsValue(randomValue);
			stressmap.replace(randomKey, 0);
			stressmap.equals(testObjects);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.contains(randomValue);
			stressmap.size();
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.containsValue(itr3.next());
			}
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.put(randomKey, randomValue);
			stressmap.remove(randomKey, randomValue);
			stressmap.size();
			keys = stressmap.keys();
			while(keys.hasMoreElements())
			{
				String key = keys.nextElement();
				if(key != null)
				{
					stressmap.replace(key, randomValue, randomValue);
				}
			}
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.put(randomKey, 0);
			elements = stressmap.elements();
			while(elements.hasMoreElements())
			{
				stressmap.contains(elements.nextElement());
			}
			stressmap.replace(randomKey, 0, randomValue);
			stressmap.containsValue(randomValue);
			stressmap.contains(randomValue);
			stressmap.contains(randomValue);
			stressmap.remove(randomKey, randomValue);
			stressmap.contains(randomValue);
			stressmap.containsKey(randomKey);
			stressmap.get(randomKey);
			stressmap.remove(randomKey);
			stressmap.put(randomKey, randomValue);
			stressmap.get(randomKey);
			stressmap.equals(testObjects);
			stressmap.put(randomKey, 0);
			stressmap.remove(randomKey);
			stressmap.get(randomKey);
			stressmap.size();
			stressmap.replace(randomKey, 0);
			stressmap.replace(randomKey, 0, randomValue);
		}
		catch(NoSuchElementException e)
		{
			// Can be thrown in normal running of the test
		}
	}
}
