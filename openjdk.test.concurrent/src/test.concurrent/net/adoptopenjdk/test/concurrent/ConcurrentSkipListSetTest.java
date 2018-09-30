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
 * File:    ConcurrentSkipListSetTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentSkipListSet;

import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * ConcurrentSkipListSetTest
 * =========================
 * 
 * Attempts to verify the correct function of the ConcurrentSkipListSet class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using a non-shared instance of ConcurrentSkipListSet
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

public class ConcurrentSkipListSetTest extends ConcurrentTest
{

	// listset is not declared as static and is therefore a unique instance of ConcurrentSkipListSet specific to the current thread
	private ConcurrentSkipListSet<GenericTestObject> listset = new ConcurrentSkipListSet<GenericTestObject>();

	// stresslistset is declared statis and is therefore shared across all threads and is used for the testStress() function
	private static ConcurrentSkipListSet<GenericTestObject> stresslistset = new ConcurrentSkipListSet<GenericTestObject>();

	/**
	 * Verify the correct behaviour of the API for ConcurrentSkipListMap. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// =================================================================================
		// Create some test data to work with

		GenericTestObject testObject = makeNewTestObject();

		ConcurrentSkipListSet<GenericTestObject> testObjects = new ConcurrentSkipListSet<GenericTestObject>();
		for(int i = 0; i < 10; i++)
		{
			testObjects.add(makeNewTestObject());
		}

		// =================================================================================
		// Basic API testing

		assertEquals("1 : isEmpty()", true, listset.isEmpty());
		assertEquals("2 : size()", 0, listset.size());
		assertEquals("3 : contains()", false, listset.contains(testObject));
		assertEquals("4 : add()", true, listset.add(testObject));
		assertEquals("5 : contains()", true, listset.contains(testObject));
		assertEquals("6 : isEmpty()", false, listset.isEmpty());
		assertEquals("7 : size()", 1, listset.size());
		assertEquals("8 : remove()", true, listset.remove(testObject));
		assertEquals("9 : contains()", false, listset.contains(testObject));
		assertEquals("10 : isEmpty()", true, listset.isEmpty());
		assertEquals("11 : size()", 0, listset.size());

		assertEquals("12 : addAll()", true, listset.addAll(testObjects));
		assertEquals("13 : isEmpty()", false, listset.isEmpty());
		assertEquals("14 : size()", 10, listset.size());

		GenericTestObject anotherTestObject = testObjects.first();
		assertEquals("15 : add()", false, listset.add(anotherTestObject));				// This is a set so the object can only be present once
		assertEquals("16 : contains()", true, listset.contains(anotherTestObject));
		assertEquals("17 : removeAll()", true, listset.removeAll(testObjects));
		assertEquals("18 : contains()", false, listset.contains(anotherTestObject));
		assertEquals("19 : remove()", false, listset.remove(anotherTestObject));

		anotherTestObject = testObjects.pollFirst();
		assertEquals("20 : addAll()", true, listset.addAll(testObjects));
		assertEquals("21 : add()", true, listset.add(anotherTestObject));				
		assertEquals("22 : contains()", true, listset.contains(anotherTestObject));
		assertEquals("23 : removeAll()", true, listset.removeAll(testObjects));			// anotherTestObject isn't removed as it isn't in testObjects
		assertEquals("24 : contains()", true, listset.contains(anotherTestObject));
		assertEquals("25 : remove()", true, listset.remove(anotherTestObject));

		testObjects.add(anotherTestObject);

		// =================================================================================
		// Test positional API functions

		// An object that should go to the front/head of the set
		GenericTestObject lowTestObject = makeNewTestObject();
		lowTestObject.setStringData("A");
		lowTestObject.setLongData(System.currentTimeMillis() + rng.nextLong());

		// An object that should go to the back/tail of the set
		GenericTestObject highTestObject = makeNewTestObject();
		highTestObject.setStringData("zzzzzzzzzzzzzzzzzzzzzzzzzzz");
		highTestObject.setLongData(System.currentTimeMillis());	

		// Add some generic objects into the listset
		listset.addAll(testObjects);

		assertEquals("26 : add()", true, listset.add(lowTestObject));
		assertEquals("27 : add()", true, listset.add(highTestObject));
		assertEquals("28 : contains()", true, listset.contains(lowTestObject));
		assertEquals("29 : contains()", true, listset.contains(highTestObject));

		assertEquals("30 : first()", lowTestObject, listset.first());
		assertEquals("31 : pollFirst()", lowTestObject, listset.pollFirst());
		assertEquals("32 : add()", true, listset.add(lowTestObject));
		assertEquals("33 : tailSet()", 12, listset.tailSet(lowTestObject).size());
		assertEquals("34 : tailSet()", 12, listset.tailSet(lowTestObject, true).size());
		assertEquals("35 : tailSet()", 11, listset.tailSet(lowTestObject, false).size());
		assertEquals("36 : headSet()", 0, listset.headSet(lowTestObject).size());
		assertEquals("37 : headSet()", 1, listset.headSet(lowTestObject, true).size());
		assertEquals("38 : headSet()", 0, listset.headSet(lowTestObject, false).size());
		assertEquals("39 : lower()", null, listset.lower(lowTestObject));
		assertEquals("40 : higher()", listset.tailSet(lowTestObject, false).first(), listset.higher(lowTestObject));	// tailSet(head, false).first() gives the 2nd element in the set
		assertEquals("41 : ceiling()", lowTestObject, listset.ceiling(lowTestObject));
		assertEquals("42 : floor()", lowTestObject, listset.floor(lowTestObject));
		assertEquals("43 : remove()", true, listset.remove(lowTestObject));
		assertEquals("44 : ceiling()", listset.first(), listset.ceiling(lowTestObject));
		assertEquals("45 : floor()", null, listset.floor(lowTestObject));
		assertEquals("46 : add()", true, listset.add(lowTestObject));

		assertEquals("47 : last()", highTestObject, listset.last());
		assertEquals("48 : pollLast()", highTestObject, listset.pollLast());
		assertEquals("49 : add()", true, listset.add(highTestObject));
		assertEquals("50 : tailSet()", 1, listset.tailSet(highTestObject).size());
		assertEquals("51 : tailSet()", 1, listset.tailSet(highTestObject, true).size());
		assertEquals("52 : tailSet()", 0, listset.tailSet(highTestObject, false).size());
		assertEquals("53 : headSet()", 11, listset.headSet(highTestObject).size());
		assertEquals("54 : headSet()", 12, listset.headSet(highTestObject, true).size());
		assertEquals("55 : headSet()", 11, listset.headSet(highTestObject, false).size());
		assertEquals("56 : lower()", listset.headSet(highTestObject, false).last(), listset.lower(highTestObject));		// headSet(tail, false).last() gives the penultimate element in the set
		assertEquals("57 : higher()", null, listset.higher(highTestObject));	
		assertEquals("58 : ceiling()", highTestObject, listset.ceiling(highTestObject));
		assertEquals("59 : floor()", highTestObject, listset.floor(highTestObject));
		assertEquals("60 : remove()", true, listset.remove(highTestObject));
		assertEquals("61 : ceiling()", null, listset.ceiling(highTestObject));
		assertEquals("62 : floor()", listset.last(), listset.floor(highTestObject));
		assertEquals("63 : add()", true, listset.add(highTestObject));

		assertEquals("64 : subSet()", 11, listset.subSet(lowTestObject, highTestObject).size());
		assertEquals("65 : subSet()", 12, listset.subSet(lowTestObject, true, highTestObject, true).size());

		try
		{
			listset.subSet(highTestObject, lowTestObject);
			fail("66 : subSet() : should have thrown IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected
		}

		listset.remove(lowTestObject);
		listset.remove(highTestObject);

		// =================================================================================
		// Iterators and clones

		ConcurrentSkipListSet<GenericTestObject> clone = listset.clone();

		Iterator<GenericTestObject> forwardIterator = clone.iterator();
		Iterator<GenericTestObject> backwardIterator = clone.descendingIterator();
		Iterator<GenericTestObject> backwardSetIterator = clone.descendingSet().iterator();
		Iterator<GenericTestObject> doubleBackwardIterator = clone.descendingSet().descendingIterator();

		while(forwardIterator.hasNext())
		{
			assertEquals("67 : iterator()", forwardIterator.next(), doubleBackwardIterator.next());
		}

		while(backwardSetIterator.hasNext())
		{
			assertEquals("68 : iterator()", backwardIterator.next(), backwardSetIterator.next());
		}

		assertEquals("69 : first() / last()", listset.first(), clone.first());
		assertEquals("70 : first() / last()", listset.last(), clone.last());
		assertEquals("71 : first() / last()", listset.first(), clone.descendingSet().last());
		assertEquals("72 : first() / last()", listset.last(), clone.descendingSet().first());

		// =================================================================================
		// Final tidy up to free memory

		listset.clear();
		testObjects.clear();		
	}

	/**
	 * Makes use of stresslistset to test multiple threads concurrent accessing and updating a single shared
	 * instance of ConcurrentSkipListSet. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{		
		// Some data for use below
		GenericTestObject testObject1 = new GenericTestObject("testObject1", 1, 1, 1, true);
		GenericTestObject testObject2 = new GenericTestObject("testObject2", 2, 2, 2, false);
		GenericTestObject testObject3 = new GenericTestObject("testObject3", 3, 3, 3, false);

		ArrayList<GenericTestObject> testObjects = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 20; i++)
		{
			testObjects.add(makeNewTestObject());
		}

		// make sure we have some items to work with
		while(stresslistset.size() < 100)
		{
			stresslistset.add(makeNewTestObject());
		}

		// make sure we don't gobble all of the memory
		while(stresslistset.size() > 200)
		{
			stresslistset.pollFirst();
		}

		// =================================================================================
		// Testing starts here
		
		try
		{
			stresslistset.contains(testObject3);
			Iterator<GenericTestObject> itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.clear();
			stresslistset.clone();
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.tailSet(testObject1, true);
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.addAll(testObjects);
			stresslistset.subSet(testObject2, true, testObject3, true);
			stresslistset.tailSet(testObject1, true);
			stresslistset.lower(testObject3);
			stresslistset.headSet(testObject3);
			stresslistset.ceiling(testObject2);
			stresslistset.floor(testObject1);
			stresslistset.isEmpty();
			stresslistset.floor(testObject1);
			stresslistset.tailSet(testObject1);
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.tailSet(testObject3, false);
			stresslistset.lower(testObject3);
			stresslistset.higher(testObject2);
			stresslistset.size();
			stresslistset.higher(testObject2);
			stresslistset.headSet(testObject1);
			stresslistset.contains(testObject1);
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.lower(testObject2);
			stresslistset.floor(testObject1);
			stresslistset.floor(testObject1);
			stresslistset.removeAll(testObjects);
			stresslistset.contains(testObject1);
			stresslistset.lower(testObject2);
			stresslistset.toArray();
			stresslistset.headSet(testObject3, true);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.tailSet(testObject3, false);
			stresslistset.headSet(testObject3);
			stresslistset.higher(testObject3);
			stresslistset.retainAll(testObjects);
			stresslistset.add(testObject2);
			stresslistset.retainAll(testObjects);
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.higher(testObject2);
			stresslistset.tailSet(testObject3, true);
			stresslistset.retainAll(testObjects);
			stresslistset.headSet(testObject3, true);
			stresslistset.ceiling(testObject3);
			stresslistset.remove(testObject2);
			stresslistset.tailSet(testObject3);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.size();
			stresslistset.clear();
			stresslistset.remove(testObject2);
			stresslistset.size();
			stresslistset.isEmpty();
			stresslistset.remove(testObject2);
			stresslistset.isEmpty();
			stresslistset.ceiling(testObject3);
			stresslistset.headSet(testObject3);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.headSet(testObject3, true);
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.contains(testObject1);
			stresslistset.higher(testObject2);
			stresslistset.toString();
			stresslistset.remove(testObject1);
			stresslistset.remove(testObject2);
			stresslistset.contains(testObject1);
			stresslistset.toArray();
			stresslistset.isEmpty();
			stresslistset.tailSet(testObject1);
			stresslistset.lower(testObject3);
			stresslistset.add(testObject2);
			stresslistset.pollLast();
			stresslistset.tailSet(testObject1, false);
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.floor(testObject1);
			stresslistset.clear();
			stresslistset.tailSet(testObject3, true);
			stresslistset.addAll(testObjects);
			stresslistset.tailSet(testObject3, true);
			stresslistset.higher(testObject2);
			stresslistset.first();
			stresslistset.headSet(testObject1, true);
			stresslistset.add(testObject2);
			stresslistset.tailSet(testObject3, true);
			stresslistset.tailSet(testObject1, true);
			stresslistset.retainAll(testObjects);
			stresslistset.tailSet(testObject1, false);
			stresslistset.add(testObject2);
			stresslistset.headSet(testObject3, true);
			stresslistset.headSet(testObject3);
			stresslistset.clear();
			stresslistset.clone();
			stresslistset.add(testObject1);
			stresslistset.first();
			stresslistset.remove(testObject2);
			stresslistset.ceiling(testObject3);
			stresslistset.isEmpty();
			stresslistset.floor(testObject3);
			Iterator<GenericTestObject> itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.lower(testObject2);
			stresslistset.ceiling(testObject2);
			stresslistset.lower(testObject2);
			stresslistset.contains(testObject3);
			stresslistset.floor(testObject3);
			stresslistset.lower(testObject2);
			stresslistset.tailSet(testObject3);
			stresslistset.contains(testObject3);
			stresslistset.headSet(testObject3);
			stresslistset.first();
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.tailSet(testObject1);
			stresslistset.containsAll(testObjects);
			stresslistset.higher(testObject2);
			stresslistset.higher(testObject3);
			stresslistset.headSet(testObject1);
			stresslistset.headSet(testObject1, true);
			stresslistset.isEmpty();
			stresslistset.headSet(testObject3, true);
			stresslistset.contains(testObject3);
			stresslistset.subSet(testObject2, true, testObject3, true);
			stresslistset.headSet(testObject1);
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.addAll(testObjects);
			stresslistset.containsAll(testObjects);
			stresslistset.headSet(testObject3, true);
			stresslistset.clone();
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.headSet(testObject3);
			stresslistset.tailSet(testObject1);
			stresslistset.toString();
			stresslistset.tailSet(testObject3, false);
			stresslistset.add(testObject1);
			stresslistset.tailSet(testObject3, true);
			stresslistset.tailSet(testObject1);
			stresslistset.retainAll(testObjects);
			stresslistset.headSet(testObject3);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.contains(testObject1);
			stresslistset.contains(testObject3);
			stresslistset.clear();
			stresslistset.tailSet(testObject3);
			stresslistset.tailSet(testObject3, false);
			stresslistset.pollLast();
			stresslistset.clear();
			stresslistset.higher(testObject2);
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.floor(testObject3);
			stresslistset.headSet(testObject3, true);
			stresslistset.pollFirst();
			stresslistset.removeAll(testObjects);
			stresslistset.addAll(testObjects);
			stresslistset.last();
			stresslistset.ceiling(testObject3);
			stresslistset.pollFirst();
			stresslistset.tailSet(testObject1);
			stresslistset.tailSet(testObject3, true);
			stresslistset.toArray();
			stresslistset.headSet(testObject3);
			stresslistset.headSet(testObject3);
			stresslistset.tailSet(testObject3, false);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.add(testObject2);
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.tailSet(testObject3, false);
			stresslistset.higher(testObject3);
			stresslistset.headSet(testObject3);
			stresslistset.tailSet(testObject1, true);
			stresslistset.addAll(testObjects);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.removeAll(testObjects);
			stresslistset.lower(testObject2);
			stresslistset.contains(testObject1);
			stresslistset.containsAll(testObjects);
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.floor(testObject1);
			stresslistset.last();
			stresslistset.contains(testObject3);
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.tailSet(testObject3, false);
			stresslistset.size();
			stresslistset.ceiling(testObject2);
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.remove(testObject2);
			stresslistset.higher(testObject3);
			stresslistset.tailSet(testObject3, false);
			stresslistset.containsAll(testObjects);
			stresslistset.clear();
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.contains(testObject3);
			stresslistset.toArray();
			stresslistset.addAll(testObjects);
			stresslistset.lower(testObject3);
			stresslistset.tailSet(testObject3, false);
			stresslistset.isEmpty();
			stresslistset.floor(testObject3);
			stresslistset.add(testObject2);
			stresslistset.isEmpty();
			stresslistset.tailSet(testObject1);
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.remove(testObject1);
			stresslistset.containsAll(testObjects);
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.add(testObject2);
			stresslistset.removeAll(testObjects);
			stresslistset.retainAll(testObjects);
			stresslistset.tailSet(testObject1, true);
			stresslistset.headSet(testObject1, true);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.toArray();
			stresslistset.toString();
			stresslistset.subSet(testObject2, true, testObject3, true);
			stresslistset.clone();
			stresslistset.tailSet(testObject1, true);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.lower(testObject2);
			stresslistset.ceiling(testObject2);
			stresslistset.toArray();
			stresslistset.subSet(testObject1, true, testObject2, true);
			stresslistset.tailSet(testObject3, true);
			stresslistset.clear();
			stresslistset.containsAll(testObjects);
			stresslistset.tailSet(testObject1, true);
			stresslistset.tailSet(testObject3);
			stresslistset.subSet(testObject2, true, testObject3, true);
			stresslistset.floor(testObject1);
			stresslistset.headSet(testObject3, true);
			stresslistset.floor(testObject1);
			stresslistset.addAll(testObjects);
			stresslistset.floor(testObject3);
			stresslistset.tailSet(testObject1);
			stresslistset.isEmpty();
			stresslistset.clear();
			stresslistset.subSet(testObject2, false, testObject3, true);
			stresslistset.pollLast();
			stresslistset.pollFirst();
			stresslistset.pollFirst();
			stresslistset.tailSet(testObject1, true);
			stresslistset.tailSet(testObject1);
			stresslistset.lower(testObject3);
			stresslistset.ceiling(testObject2);
			stresslistset.contains(testObject3);
			stresslistset.ceiling(testObject3);
			stresslistset.add(testObject2);
			stresslistset.pollFirst();
			stresslistset.clone();
			stresslistset.addAll(testObjects);
			stresslistset.toArray();
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.toString();
			stresslistset.higher(testObject2);
			stresslistset.floor(testObject1);
			stresslistset.tailSet(testObject3, false);
			stresslistset.retainAll(testObjects);
			stresslistset.tailSet(testObject1, true);
			stresslistset.tailSet(testObject1, true);
			stresslistset.subSet(testObject2, true, testObject3, true);
			stresslistset.retainAll(testObjects);
			itr2 = stresslistset.iterator();
			while(itr2.hasNext())
			{
				stresslistset.lower(itr2.next());
			}
			stresslistset.containsAll(testObjects);
			stresslistset.clone();
			stresslistset.tailSet(testObject1, false);
			stresslistset.higher(testObject2);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.headSet(testObject3, true);
			stresslistset.headSet(testObject1);
			stresslistset.headSet(testObject1, true);
			stresslistset.tailSet(testObject1);
			stresslistset.tailSet(testObject1, false);
			stresslistset.add(testObject2);
			stresslistset.removeAll(testObjects);
			stresslistset.removeAll(testObjects);
			stresslistset.higher(testObject2);
			stresslistset.size();
			stresslistset.tailSet(testObject3, false);
			stresslistset.higher(testObject2);
			stresslistset.contains(testObject1);
			stresslistset.remove(testObject2);
			stresslistset.headSet(testObject3);
			stresslistset.pollFirst();
			stresslistset.addAll(testObjects);
			stresslistset.headSet(testObject3);
			stresslistset.ceiling(testObject2);
			stresslistset.headSet(testObject3, true);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.last();
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.remove(testObject2);
			stresslistset.last();
			stresslistset.tailSet(testObject1);
			stresslistset.tailSet(testObject1);
			stresslistset.add(testObject1);
			stresslistset.floor(testObject3);
			stresslistset.lower(testObject3);
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.tailSet(testObject1);
			stresslistset.add(testObject1);
			stresslistset.higher(testObject2);
			stresslistset.floor(testObject1);
			stresslistset.headSet(testObject3, true);
			stresslistset.remove(testObject1);
			stresslistset.tailSet(testObject1, false);
			stresslistset.isEmpty();
			stresslistset.toString();
			stresslistset.clear();
			stresslistset.isEmpty();
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.size();
			stresslistset.remove(testObject1);
			stresslistset.ceiling(testObject3);
			stresslistset.headSet(testObject3, true);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.isEmpty();
			stresslistset.floor(testObject1);
			stresslistset.addAll(testObjects);
			stresslistset.clone();
			stresslistset.contains(testObject3);
			stresslistset.containsAll(testObjects);
			stresslistset.tailSet(testObject3);
			stresslistset.tailSet(testObject3, false);
			stresslistset.headSet(testObject1, true);
			stresslistset.headSet(testObject3);
			stresslistset.ceiling(testObject2);
			stresslistset.headSet(testObject3, true);
			stresslistset.tailSet(testObject1, true);
			stresslistset.remove(testObject1);
			stresslistset.removeAll(testObjects);
			stresslistset.addAll(testObjects);
			stresslistset.removeAll(testObjects);
			stresslistset.retainAll(testObjects);
			stresslistset.addAll(testObjects);
			stresslistset.tailSet(testObject1, true);
			stresslistset.tailSet(testObject1);
			stresslistset.isEmpty();
			stresslistset.higher(testObject3);
			stresslistset.higher(testObject2);
			stresslistset.contains(testObject3);
			stresslistset.retainAll(testObjects);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.first();
			stresslistset.isEmpty();
			stresslistset.retainAll(testObjects);
			stresslistset.tailSet(testObject1);
			stresslistset.pollFirst();
			stresslistset.tailSet(testObject3, false);
			stresslistset.headSet(testObject3);
			stresslistset.floor(testObject3);
			stresslistset.pollLast();
			stresslistset.tailSet(testObject3, true);
			stresslistset.remove(testObject1);
			stresslistset.headSet(testObject3, true);
			stresslistset.headSet(testObject3);
			stresslistset.higher(testObject3);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.toArray();
			stresslistset.higher(testObject2);
			stresslistset.floor(testObject1);
			stresslistset.remove(testObject2);
			stresslistset.containsAll(testObjects);
			stresslistset.ceiling(testObject2);
			stresslistset.add(testObject1);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.contains(testObject3);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.tailSet(testObject3, true);
			stresslistset.remove(testObject2);
			stresslistset.clear();
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
			stresslistset.subSet(testObject1, false, testObject2, true);
			stresslistset.remove(testObject2);
			stresslistset.add(testObject1);
			stresslistset.higher(testObject2);
			stresslistset.floor(testObject3);
			stresslistset.lower(testObject2);
			stresslistset.headSet(testObject3, true);
			stresslistset.headSet(testObject3, true);
			stresslistset.toString();
			stresslistset.subSet(testObject2, testObject3);
			stresslistset.tailSet(testObject1, true);
			stresslistset.lower(testObject2);
			stresslistset.subSet(testObject1, testObject2);
			stresslistset.addAll(testObjects);
			stresslistset.containsAll(testObjects);
			stresslistset.higher(testObject2);
			stresslistset.tailSet(testObject3);
			stresslistset.tailSet(testObject1, false);
			itr1 = stresslistset.descendingIterator();
			while(itr1.hasNext())
			{
				stresslistset.floor(itr1.next());
			}
		}
		catch(NoSuchElementException e)
		{
			// Can be thrown if the call stresslistset.last() when the stresslistset is empty
		}
	}

}
