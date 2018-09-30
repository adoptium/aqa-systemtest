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
 * File:    ConcurrentSkipListMapTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentSkipListMapTest
 * =========================
 * 
 * Attempts to verify the correct function of the ConcurrentSkipListMap class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using a non-shared instance of ConcurrentSkipListMap
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ConcurrentSkipListMap
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

public class ConcurrentSkipListMapTest extends ConcurrentTest
{

	// listmap is not defined as static and there is therefore a new instance created for every thread running and no concurrent access.
	// listmap is our mechanism of verifying correct behaviour of the API
	private ConcurrentSkipListMap<String,Integer> listmap = new ConcurrentSkipListMap<String,Integer>();

	// stressmap is a single shared instance of ConcurrentSkipListMap for the purposes of testing concurrent access to the class under test from multiple threads.
	private static ConcurrentSkipListMap<String,Integer> stressmap = new ConcurrentSkipListMap<String,Integer>();

	/**
	 * Method used to generate a random number between -500 and +500. This is used to guarantee that there all values in the 
	 * listmap are in a known range and therefore that certain numbers are never present in the listmap.
	 * 
	 * @return an integer between -500 and +500
	 */
	private int generateTestNumber()
	{
		return -500 + rng.nextInt(1001);
	}
	
	/**
	 * Verify the correct behaviour of the API for ConcurrentSkipListMap. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// =================================================================================
		// Create some test data to work with

		String testKey = buildString();
		Integer testValue = 600;			// Select test values that are outside of the range of generated numbers
		Integer alternateTestValue = 800;
		
		ConcurrentSkipListMap<String,Integer> testObjects = new ConcurrentSkipListMap<String,Integer>();

		for( int i = 0; i < 50; i++)
		{
			testObjects.put(buildString(), generateTestNumber());
		}

		// =================================================================================
		// Basic API testing

		assertEquals("1 : size()", 0, listmap.size());
		assertEquals("2 : keySet().size()", 0, listmap.keySet().size());
		assertEquals("3 : entrySet().size()", 0, listmap.entrySet().size());
		assertEquals("4 : values().size()", 0, listmap.values().size());

		assertEquals("5 : containsKey()", false, listmap.containsKey(testKey));
		assertEquals("6 : containsValue()", false, listmap.containsValue(testValue));

		try
		{
			listmap.containsKey(null);
			fail("7 : containsKey() : Should have thrown NullPointerException");
		}
		catch(NullPointerException e)
		{
			// expected
		}

		try
		{
			listmap.containsValue(null);
			fail("8 : containsValue() : Should have thrown NullPointerException");
		}
		catch(NullPointerException e)
		{
			// expected
		}

		// =================================================================================
		// Additions and Removals of elements

		assertEquals("9 : put()", null, listmap.put(testKey, testValue));
		assertEquals("10 : containsKey()", true, listmap.containsKey(testKey));
		assertEquals("11 : containsValue()", true, listmap.containsValue(testValue));
		assertEquals("12 : putIfAbsent()", testValue, listmap.putIfAbsent(testKey, testValue));
		assertEquals("13 : remove()", true, listmap.remove(testKey, testValue));
		assertEquals("14 : putIfAbsent()", null, listmap.putIfAbsent(testKey, testValue));

		listmap.putAll(testObjects);
		Iterator<String> itr = testObjects.keySet().iterator();
		while(itr.hasNext())
		{
			String nextKey = itr.next();
			assertEquals("15 : containsKey()", true, listmap.containsKey(nextKey));
			assertEquals("16 : containsValue()", true, listmap.containsValue(listmap.get(nextKey)));
			assertEquals("17 : remove()", listmap.get(nextKey), listmap.remove(nextKey));
		}

		assertEquals("18 : put()", testValue, listmap.put(testKey, testValue));
		assertEquals("19 : replace()", testValue, listmap.replace(testKey, alternateTestValue));
		assertEquals("20 : replace()", alternateTestValue, listmap.replace(testKey, alternateTestValue));
		assertEquals("21 : replace()", alternateTestValue, listmap.replace(testKey, testValue));
		assertEquals("22 : replace()", true, listmap.replace(testKey, testValue, alternateTestValue));
		assertEquals("23 : replace()", alternateTestValue, listmap.replace(testKey, testValue));
		assertEquals("24 : replace()", false, listmap.replace(testKey, alternateTestValue, testValue));
		assertEquals("25 : remove()", testValue, listmap.remove(testKey));

		assertEquals("26 : put()", null, listmap.put(testKey, testValue));
		assertEquals("27 : containsKey()", true, listmap.containsKey(testKey));
		assertEquals("28 : remove()", testValue, listmap.remove(testKey));
		assertEquals("29 : remove()", null, listmap.remove(testKey));
		assertEquals("30 : put()", null, listmap.put(testKey, testValue));
		assertEquals("31 : remove()", false, listmap.remove(testKey, generateTestNumber()));
		assertEquals("32 : remove()", true, listmap.remove(testKey, testValue));

		// =================================================================================
		// Positioning of elements

		listmap.putAll(testObjects); 		// Need some data to pad out the rest of the listmap

		// First working at the 'head' end of the listmap
		String testKey2 = "A";										// To force the key to the front of the listmap
		int testValue2 = 700;
		Map.Entry<String, Integer> testFirstEntry = new AbstractMap.SimpleEntry<String,Integer>(testKey2, testValue2);

		assertEquals("33 : put()", null, listmap.put(testKey2, testValue2));							
		assertEquals("34 : firstKey()", testKey2, listmap.firstKey());
		assertEquals("35 : firstEntry()", testFirstEntry, listmap.firstEntry());
		assertEquals("36 : pollFirstEntry()", testFirstEntry, listmap.pollFirstEntry());
		assertEquals("37 : put()", null, listmap.put(testKey2, testValue2));
		assertEquals("38 : floorKey()", testKey2, listmap.floorKey(testKey2));
		assertEquals("39 : lowerKey()", null, listmap.lowerKey(testKey2));
		assertEquals("40 : lowerEntry()", null, listmap.lowerEntry(testKey2));
		assertEquals("41 : ceilingKey()", listmap.ceilingKey(testKey2), listmap.firstKey());		// looks odd but ceilingKey returns the exact key passed in if it exists in the listmap
		assertEquals("42 : ceilingEntry()", listmap.ceilingEntry(testKey2), listmap.firstEntry());	// i.e. ceilingKey(listmap.firstKey()) == listmap.firstKey()

		// Given that 'A' was the head of listmap, removing 'A' and asking for the ceiling from 'A' should return the new head element
		listmap.remove(testKey2);
		assertEquals("43 : ceilingKey()", listmap.ceilingKey(testKey2), listmap.firstKey());
		assertEquals("44 : ceilingEntry()", listmap.ceilingEntry(testKey2), listmap.firstEntry());

		// Grab the current head...
		String secondKey = listmap.firstKey();
		Entry<String, Integer> secondEntry = listmap.firstEntry();

		// ... insert the element that goes to the head of the listmap making the head element grabbed above become the second element
		listmap.put(testKey2, testValue2);

		// ... this allows for proper checking of lowerKey and higherKey
		assertEquals("45 : lowerKey()", testKey2, listmap.lowerKey(secondKey));
		assertEquals("46 : lowerEntry()", testFirstEntry, listmap.lowerEntry(secondKey));
		assertEquals("47 : higherKey()", secondKey, listmap.higherKey(testKey2));
		assertEquals("48 : higherEntry()", secondEntry, listmap.higherEntry(testKey2));

		// ... and also ceiling/floorKey
		listmap.remove(testKey2);
		assertEquals("49 : ceilingKey()", secondKey, listmap.ceilingKey(testKey2));
		assertEquals("50 : ceilingEntry()", secondEntry, listmap.ceilingEntry(testKey2));

		// Now working at the 'tail' end
		String testKey3 = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";       // To force the key to the back of the listmap
		int testValue3 = 900;
		Map.Entry<String, Integer> testLastEntry = new AbstractMap.SimpleEntry<String,Integer>(testKey3, testValue3);

		assertEquals("51 : put()", null, listmap.put(testKey3, testValue3));							
		assertEquals("52 : lastKey()", testKey3, listmap.lastKey());
		assertEquals("53 : lastEntry()", testLastEntry, listmap.lastEntry());
		assertEquals("54 : pollLastEntry()", testLastEntry, listmap.pollLastEntry());
		assertEquals("55 : put()", null, listmap.put(testKey3, testValue3));
		assertEquals("56 : ceilingKey()", testKey3, listmap.ceilingKey(testKey3));
		assertEquals("57 : higherKey()", null, listmap.higherKey(testKey3));
		assertEquals("58 : higherEntry()", null, listmap.higherEntry(testKey3));
		assertEquals("59 : floorKey()", listmap.floorKey(testKey3), listmap.lastKey());			// As for ceilingKey, floorKey will return the exact key passed in 
		assertEquals("60 : floorEntry()", listmap.floorEntry(testKey3), listmap.lastEntry());	// i.e. floorKey(listmap.lastkey()) == listmap.lastKey()

		// Given that 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz' was the tail of listmap, removing 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz' and asking for the 
		// floor from 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz' should return the new tail element
		listmap.remove(testKey3);
		assertEquals("61 : floorKey()", listmap.floorKey(testKey3), listmap.lastKey());
		assertEquals("62 : floorEntry()", listmap.floorEntry(testKey3), listmap.lastEntry());

		// Grab the current tail...
		String penultimateKey = listmap.lastKey();
		Entry<String, Integer> penultimateEntry = listmap.lastEntry();

		// ... insert the element that goes to the tail of the listmap making the tail element grabbed above become the penultimate element
		listmap.put(testKey3, testValue3);

		// ... this allows for proper checking of lowerKey and higherKey
		assertEquals("63 : lowerKey()", penultimateKey, listmap.lowerKey(testKey3));
		assertEquals("64 : lowerEntry()", penultimateEntry, listmap.lowerEntry(testKey3));
		assertEquals("65 : higherKey()", testKey3, listmap.higherKey(penultimateKey));
		assertEquals("66 : higherEntry()", testLastEntry, listmap.higherEntry(penultimateKey));

		// ... and also ceiling/floorKey
		listmap.remove(testKey3);
		assertEquals("67 : floorKey()", penultimateKey, listmap.floorKey(testKey3));
		assertEquals("68 : floorEntry()", penultimateEntry, listmap.floorEntry(testKey3));	

		// =================================================================================
		// Submaps

		listmap.put(testKey2, testValue);			// Element at the head of the listmap
		listmap.put(testKey3, alternateTestValue);	// Element at the tail of the listmap

		assertEquals("69 : headMap()", 0, listmap.headMap(testKey2).size());
		assertEquals("70 : headMap()", 0, listmap.headMap(testKey2, false).size());
		assertEquals("71 : headMap()", 1, listmap.headMap(testKey2, true).size());
		assertEquals("72 : headMap()", listmap.size() - 1, listmap.headMap(testKey3).size());
		assertEquals("73 : headMap()", listmap.size(), listmap.headMap(testKey3, true).size());

		assertEquals("74 : subMap()", listmap.size() - 1, listmap.subMap(testKey2, testKey3).size());
		assertEquals("75 : subMap()", listmap.size(), listmap.subMap(testKey2, true, testKey3, true).size());
		assertEquals("76 : subMap()", listmap.size() - 1, listmap.subMap(testKey2, false, testKey3, true).size());
		assertEquals("77 : subMap()", listmap.size() - 1, listmap.subMap(testKey2, true, testKey3, false).size());
		assertEquals("78 : subMap()", listmap.size() - 2, listmap.subMap(testKey2, false, testKey3, false).size());

		assertEquals("79 : tailMap()", 1, listmap.tailMap(testKey3).size());
		assertEquals("80 : tailMap()", 1, listmap.tailMap(testKey3, true).size());
		assertEquals("81 : tailMap()", 0, listmap.tailMap(testKey3, false).size());
		assertEquals("82 : tailMap()", listmap.size(), listmap.tailMap(testKey2).size());
		assertEquals("83 : tailMap()", listmap.size(), listmap.tailMap(testKey2, true).size());

		// =================================================================================
		// Clones and iterators

		ConcurrentSkipListMap<String, Integer> localClone = listmap.clone();
		ConcurrentNavigableMap<String, Integer> localSubMap = localClone.subMap(localClone.firstKey(), true, localClone.lastKey(), true);

		Iterator<String> keySetItr 					= localClone.keySet().iterator();
		Iterator<String> navigableKeySetItr 		= localClone.navigableKeySet().iterator();
		Iterator<Entry<String,Integer>> entrySetItr = localClone.entrySet().iterator();
		Iterator<Integer> valuesItr 				= localClone.values().iterator();
		Iterator<String> subMapItr 					= localSubMap.keySet().iterator();

		while(keySetItr.hasNext())
		{
			String nextKey = keySetItr.next();

			assertEquals("84 : iterators", nextKey, navigableKeySetItr.next());
			assertEquals("85 : iterators", nextKey, entrySetItr.next().getKey());
			assertEquals("86 : iterators", localClone.get(nextKey), valuesItr.next());

			if(subMapItr.hasNext())
				assertEquals("87 : iterators", nextKey, subMapItr.next());
		}

		NavigableSet<String> reverseKeySet 					= localClone.descendingKeySet();
		Iterator<String> reverseKeySetItr 					= reverseKeySet.iterator();
		ConcurrentNavigableMap<String, Integer> reverseMap 	= localClone.descendingMap();
		Iterator<String> reverseMapItr						= reverseMap.keySet().iterator();

		while(reverseKeySetItr.hasNext())
		{
			String nextKey = reverseKeySetItr.next();

			assertEquals("88 : iterators", nextKey, reverseMapItr.next());
		}

		assertEquals("89 : descendingMap()", reverseMap.firstKey(), localClone.lastKey());
		assertEquals("90 : descendingMap()", reverseMap.lastKey(), localClone.firstKey());
		assertEquals("91 : descendingMap()", reverseMap.descendingKeySet().last(), localClone.lastKey());
		assertEquals("92 : descendingMap()", reverseMap.descendingKeySet().first(), localClone.firstKey());
		
	}

	/**
	 * Makes use of stressmap to test multiple threads concurrent accessing and updating a single shared
	 * instance of ConcurrentSkipListMap. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{

		// Some data for use below
		String randomKey = buildString();
		Integer randomValue = rng.nextInt();
		ConcurrentSkipListMap<String,Integer> testObjects = new ConcurrentSkipListMap<String,Integer>();
		for(int i = 0; i < rng.nextInt(40); i++)
		{
			testObjects.put(buildString(), generateTestNumber());
		}
		
		listmap.putAll(testObjects);

		// make sure we have some items to work with
		while(stressmap.size() < 100)
		{
			stressmap.put(buildString(), rng.nextInt());
		}

		// make sure we don't gobble all of the memory
		while(stressmap.size() > 200)
		{
			stressmap.remove(stressmap.keySet().iterator().next());
		}

		// =================================================================================
		// Testing starts here

		try
		{
			stressmap.pollLastEntry();
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.put("static", 47);
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.putAll(testObjects);
			stressmap.floorEntry(randomKey);
			stressmap.ceilingEntry(randomKey);
			stressmap.toString();
			Iterator<Integer> itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.equals(stressmap.clone());
			stressmap.isEmpty();
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.containsKey("a");
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.hashCode();
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.equals(stressmap.clone());
			stressmap.put("static", 47);
			stressmap.containsKey(stressmap.firstKey());
			stressmap.remove(randomKey, randomValue);
			stressmap.remove(randomKey);
			stressmap.ceilingEntry(randomKey);
			stressmap.ceilingKey(randomKey);
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			Iterator<String> itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.subMap(randomKey, randomKey);
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.floorEntry(randomKey);
			stressmap.floorEntry(randomKey);
			stressmap.size();
			stressmap.entrySet().containsAll(stressmap.entrySet());
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.put(randomKey, randomValue);
			stressmap.replace(randomKey, randomValue);
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			Integer value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.lowerEntry(randomKey);
			stressmap.tailMap("g");
			stressmap.get(randomKey);
			stressmap.hashCode();
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.get(stressmap.firstKey());
			stressmap.replace(randomKey, randomValue);
			stressmap.pollLastEntry();
			stressmap = stressmap.clone();
			stressmap.replace(randomKey, randomValue);
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.lowerKey(randomKey);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.replace(randomKey, randomValue);
			stressmap.get(stressmap.firstKey());
			stressmap.ceilingEntry(randomKey);
			stressmap.remove(randomKey);
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.putAll(listmap);
			stressmap.containsKey(stressmap.firstKey());
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.containsValue(randomValue);
			stressmap.hashCode();
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.containsKey(randomKey);
			stressmap.floorEntry(randomKey);
			stressmap.get(stressmap.firstKey());
			stressmap = stressmap.clone();
			stressmap.tailMap("g");
			stressmap.containsValue(randomValue);
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			stressmap.floorKey(randomKey);
			stressmap.floorKey(randomKey);
			stressmap.ceilingEntry(randomKey);
			stressmap.subMap(stressmap.firstKey(), rng.nextBoolean(), stressmap.lastKey(), rng.nextBoolean());
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.remove(randomKey);
			stressmap.lowerEntry(randomKey);
			stressmap.pollFirstEntry();
			stressmap.isEmpty();
			stressmap.ceilingKey("a");
			stressmap.put(randomKey, randomValue);
			stressmap.containsKey(stressmap.firstKey());
			stressmap.higherKey(randomKey);
			stressmap.size();
			stressmap.floorEntry(randomKey);
			stressmap.put("static", 47);
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.pollFirstEntry();
			stressmap.firstKey();
			stressmap.pollLastEntry();
			stressmap.get(randomKey);
			stressmap.putAll(testObjects);
			stressmap.tailMap("k", true);
			stressmap.ceilingEntry("a");
			stressmap.tailMap(randomKey);
			stressmap.ceilingEntry("a");
			stressmap.keySet();
			stressmap.get(randomKey);
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.toString();
			stressmap.containsKey("a");
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.tailMap(randomKey);
			stressmap.ceilingKey("a");
			stressmap.toString();
			Iterator<String> itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			stressmap.isEmpty();
			stressmap.toString();
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.get(randomKey);
			stressmap = stressmap.clone();
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.entrySet();
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.equals(stressmap.clone());
			stressmap.get(randomKey);
			stressmap.pollLastEntry();
			stressmap.containsKey("a");
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.ceilingEntry("a");
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.putAll(listmap);
			stressmap.remove(stressmap.firstKey(), stressmap.get(stressmap.firstKey()));
			stressmap.equals(stressmap);
			stressmap.firstKey();
			stressmap.firstKey();
			stressmap.tailMap("g");
			stressmap.tailMap("k", true);
			stressmap = stressmap.clone();
			stressmap.putAll(stressmap.clone());
			stressmap.equals(stressmap);
			stressmap.ceilingEntry("a");
			stressmap.keySet();
			stressmap.floorKey(randomKey);
			stressmap.higherKey(randomKey);
			stressmap.remove(randomKey, randomValue);
			stressmap = stressmap.clone();
			stressmap.putAll(stressmap.clone());
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.pollFirstEntry();
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.floorKey(randomKey);
			stressmap.tailMap("k", true);
			stressmap.hashCode();
			stressmap.remove(stressmap.firstKey(), stressmap.get(stressmap.firstKey()));
			stressmap.pollLastEntry();
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.subMap(randomKey, randomKey);
			stressmap.lowerEntry(randomKey);
			stressmap.replace(randomKey, randomValue);
			stressmap.floorKey(randomKey);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.tailMap("k", true);
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.containsKey(randomKey);
			stressmap.toString();
			stressmap.floorKey(randomKey);
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.put(randomKey, randomValue);
			stressmap.lowerKey(randomKey);
			stressmap.tailMap("g");
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.keySet();
			stressmap.putAll(testObjects);
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			stressmap.equals(stressmap);
			stressmap.toString();
			stressmap.containsValue(randomValue);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.subMap(randomKey, randomKey);
			stressmap.put("zzzzzstatic", -47);
			stressmap.put("static", 47);
			stressmap.tailMap("g");
			stressmap.containsKey(randomKey);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.pollLastEntry();
			stressmap.entrySet();
			stressmap.ceilingEntry("a");
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.remove(randomKey, randomValue);
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.entrySet();
			stressmap.keySet();
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.hashCode();
			stressmap.toString();
			stressmap.tailMap(randomKey);
			stressmap.floorEntry(randomKey);
			stressmap.lowerEntry(randomKey);
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.tailMap(randomKey);
			stressmap.put("static", 47);
			stressmap.remove(randomKey);
			stressmap.pollFirstEntry();
			stressmap.floorKey(randomKey);
			stressmap.tailMap(randomKey);
			stressmap.subMap(randomKey, randomKey);
			stressmap.entrySet();
			stressmap.put(randomKey, randomValue);
			stressmap.put("zzzzzstatic", -47);
			stressmap.equals(stressmap.clone());
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.isEmpty();
			stressmap.toString();
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.put(randomKey, randomValue);
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.put(randomKey, randomValue);
			stressmap.ceilingEntry(randomKey);
			stressmap.ceilingKey(randomKey);
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.remove(stressmap.firstKey(), stressmap.get(stressmap.firstKey()));
			stressmap.floorKey(randomKey);
			stressmap.hashCode();
			stressmap.subMap(stressmap.firstKey(), rng.nextBoolean(), stressmap.lastKey(), rng.nextBoolean());
			stressmap.containsKey(stressmap.firstKey());
			stressmap.toString();
			stressmap.toString();
			stressmap.ceilingKey("a");
			stressmap.get(stressmap.firstKey());
			stressmap.put("zzzzzstatic", -47);
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.keySet();
			stressmap.equals(stressmap.clone());
			stressmap.higherKey(randomKey);
			stressmap.pollLastEntry();
			stressmap.containsKey("a");
			stressmap.hashCode();
			stressmap.floorKey(randomKey);
			stressmap.putAll(listmap);
			stressmap.putAll(testObjects);
			stressmap.tailMap("k", true);
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.keySet();
			stressmap.containsKey("a");
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.get(randomKey);
			stressmap.remove(randomKey);
			stressmap.get(randomKey);
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.containsKey("a");
			stressmap.lowerKey(randomKey);
			stressmap.containsKey(randomKey);
			stressmap.remove(randomKey, randomValue);
			stressmap.ceilingKey(randomKey);
			stressmap.containsKey(stressmap.firstKey());
			stressmap.lastEntry();
			stressmap.pollLastEntry();
			stressmap.firstKey();
			stressmap.ceilingKey("a");
			stressmap.putAll(listmap);
			stressmap.putIfAbsent(buildString(), randomValue);
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.pollLastEntry();
			stressmap.pollLastEntry();
			stressmap.lastEntry();
			stressmap.lastEntry();
			stressmap.keySet();
			stressmap.isEmpty();
			stressmap.containsKey(stressmap.firstKey());
			stressmap.put("static", 47);
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.tailMap(randomKey);
			stressmap.keySet();
			stressmap.containsValue(randomValue);
			stressmap.putIfAbsent(buildString(), randomValue);
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.remove(randomKey);
			stressmap.tailMap("g");
			stressmap.equals(stressmap.clone());
			stressmap.floorEntry(randomKey);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.keySet();
			stressmap.toString();
			stressmap.floorKey(randomKey);
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.floorEntry(randomKey);
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.putAll(listmap);
			stressmap.ceilingKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.size();
			stressmap.containsKey(randomKey);
			stressmap.containsKey(stressmap.firstKey());
			stressmap.lastKey();
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.put(randomKey, randomValue);
			stressmap.lastKey();
			stressmap.size();
			stressmap.ceilingEntry("a");
			stressmap.lowerEntry(randomKey);
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.put("static", 47);
			stressmap.ceilingEntry("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			stressmap.get(randomKey);
			stressmap.tailMap("g");
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.putAll(testObjects);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.remove(stressmap.firstKey(), stressmap.get(stressmap.firstKey()));
			stressmap.lowerKey(randomKey);
			stressmap.putAll(listmap);
			stressmap.pollLastEntry();
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			itr2 = stressmap.navigableKeySet().iterator();
			while(itr2.hasNext())
			{
				stressmap.lowerEntry(itr2.next());
			}
			stressmap.putAll(listmap);
			stressmap.lastKey();
			stressmap.pollLastEntry();
			stressmap = stressmap.clone();
			stressmap.put("zzzzzstatic", -47);
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			stressmap.pollLastEntry();
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.equals(stressmap.clone());
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			stressmap.pollFirstEntry();
			stressmap.putIfAbsent(buildString(), randomValue);
			stressmap.toString();
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.put(randomKey, randomValue);
			stressmap.firstKey();
			stressmap.lastEntry();
			stressmap.remove(stressmap.firstKey(), stressmap.get(stressmap.firstKey()));
			stressmap.tailMap("k", true);
			stressmap.get(stressmap.firstKey());
			stressmap.ceilingKey(randomKey);
			itr3 = stressmap.values().iterator();
			while(itr3.hasNext())
			{
				stressmap.descendingMap().values().contains(itr3.next());
			}
			stressmap.putIfAbsent(randomKey, randomValue);
			stressmap.replace(randomKey, randomValue);
			stressmap.descendingMap().lastKey().equals(stressmap.firstKey());
			stressmap.putAll(testObjects);
			stressmap.floorKey(randomKey);
			stressmap.floorEntry(randomKey);
			stressmap.lastKey();
			stressmap.firstKey();
			stressmap.putAll(stressmap.clone());
			stressmap.descendingKeySet().first().equals(stressmap.lastKey());
			stressmap.keySet();
			stressmap.equals(stressmap.clone());
			stressmap.put("static", 47);
			stressmap.putAll(stressmap.clone());
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			value = stressmap.get(stressmap.firstKey());
			if(value != null)
			{
				stressmap.containsValue(value);
			}
			stressmap.ceilingKey("a");
			stressmap.pollLastEntry();
			stressmap.equals(stressmap.clone());
			stressmap.size();
			stressmap.put(randomKey, randomValue);
			itr = stressmap.keySet().iterator();
			while(itr.hasNext())
			{
				stressmap.higherKey(itr.next());
			}
			stressmap.equals(stressmap);
			stressmap.entrySet();
			stressmap.higherKey(randomKey);
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.entrySet().containsAll(stressmap.entrySet());
			stressmap.putAll(listmap);
			stressmap.isEmpty();
			stressmap.floorKey(randomKey);
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.keySet();
			stressmap.get(stressmap.firstKey());
			stressmap.pollFirstEntry();
			stressmap.higherKey(randomKey);
			stressmap.higherEntry(stressmap.lastEntry().getKey());
			stressmap.lastKey();
			stressmap.firstEntry().getKey().compareTo(stressmap.firstKey());
			stressmap.tailMap(randomKey);
			stressmap.tailMap(randomKey);

		}
		catch(NoSuchElementException e)
		{
			// can be thrown if we call first or last just on an empty map - ignore
		}
	}

}
