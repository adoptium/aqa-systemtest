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
 * File:    CopyOnWriteArrayListTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * CopyOnWriteArrayListTest
 * ========================
 * 
 * Attempts to verify the correct function of the CopyOnWriteArrayList class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of CopyOnWriteArrayList
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of CopyOnWriteArrayList
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

public class CopyOnWriteArrayListTest extends ConcurrentTest
{

	// arraylist is for the generic api tests
	private CopyOnWriteArrayList<GenericTestObject> arraylist = new CopyOnWriteArrayList<GenericTestObject>();

	// stresslist is specifically for testStress
	private static CopyOnWriteArrayList<GenericTestObject> stresslist = new CopyOnWriteArrayList<GenericTestObject>();	

	/**
	 * Verify the correct behaviour of the API for ArrayBlockingQueue. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// =================================================================================
		// Create some test data to work with

		GenericTestObject testobject1 = new GenericTestObject("test1", 31, 32, 33, true);
		GenericTestObject testobject2 = new GenericTestObject("test2", 41, 42, 43, false);

		ArrayList<GenericTestObject> testObjects = new ArrayList<GenericTestObject>();

		for(int i = 0; i < 20; i++)
		{
			testObjects.add(makeNewTestObject());
		}

		// =================================================================================
		// Basic API tests

		assertEquals("1 : contains()", false, arraylist.contains(testobject1));
		assertEquals("2 : isEmpty()", true, arraylist.isEmpty());
		assertEquals("3 : size()", 0, arraylist.size());
		assertEquals("4 : add()", true, arraylist.add(testobject1));
		assertEquals("5 : contains()", true, arraylist.contains(testobject1));
		assertEquals("6 : isEmpty()", false, arraylist.isEmpty());
		assertEquals("7 : size()", 1, arraylist.size());

		assertEquals("8 : remove()", true, arraylist.remove(testobject1));
		assertEquals("9 : contains()", false, arraylist.contains(testobject1));
		assertEquals("10 : isEmpty()", true, arraylist.isEmpty());
		assertEquals("11 : size()", 0, arraylist.size());

		assertEquals("12 : add()", true, arraylist.add(testobject1));
		assertEquals("13 : add()", true, arraylist.add(testobject2));
		assertEquals("14 : size()", 2, arraylist.size());
		assertEquals("15 : get()", testobject1, arraylist.get(0));
		assertEquals("16 : get()", testobject2, arraylist.get(1));
		assertEquals("17 : remove()", testobject1, arraylist.remove(0));
		assertEquals("18 : remove()", testobject2, arraylist.remove(0));
		assertEquals("19 : isEmpty()", true, arraylist.isEmpty());
		assertEquals("20 : size()", 0, arraylist.size());

		assertEquals("21 : addAll()", true, arraylist.addAll(testObjects));
		assertEquals("22 : containsAll()", true, arraylist.containsAll(testObjects));
		assertEquals("23 : retainAll()", false, arraylist.retainAll(testObjects));
		assertEquals("24 : add()", true, arraylist.add(testobject1));
		assertEquals("25 : contains()", true, arraylist.contains(testobject1));
		assertEquals("26 : retainAll()", true, arraylist.retainAll(testObjects));
		assertEquals("27 : contains()", false, arraylist.contains(testobject1));

		arraylist.clear();

		assertEquals("28 : containsAll()", false, arraylist.containsAll(testObjects));
		assertEquals("29 : isEmpty()", true, arraylist.isEmpty());
		assertEquals("30 : add()", true, arraylist.add(testobject1));
		assertEquals("31 : indexOf()", 0, arraylist.indexOf(testobject1));
		assertEquals("32 : addAll()", true, arraylist.addAll(0, testObjects));
		assertEquals("33 : indexOf()", 20, arraylist.indexOf(testobject1));

		assertEquals("34 : removeAll()", true, arraylist.removeAll(testObjects));
		assertEquals("35 : removeAll()", false, arraylist.removeAll(testObjects));
		assertEquals("36 : size()", 1, arraylist.size());
		assertEquals("37 : contains()", true, arraylist.contains(testobject1));
		assertEquals("38 : get()", testobject1, arraylist.get(0));

		assertEquals("39 : addAllAbsent()", 20, arraylist.addAllAbsent(testObjects));
		assertEquals("40 : remove()", arraylist.get(4), arraylist.remove(4));
		assertEquals("41 : remove()", arraylist.get(4), arraylist.remove(4));
		assertEquals("42 : remove()", arraylist.get(4), arraylist.remove(4));
		assertEquals("43 : size()", 18, arraylist.size());
		assertEquals("44 : addAllAbsent()", 3, arraylist.addAllAbsent(testObjects));
		assertEquals("45 : size()", 21, arraylist.size());
		assertEquals("46 : addAllAbsent()", 0, arraylist.addAllAbsent(testObjects));
		assertEquals("47 : size()", 21, arraylist.size());

		Iterator<GenericTestObject> itr = arraylist.iterator();
		while(itr.hasNext())
		{
			assertEquals("48 : contains()", true, arraylist.contains(itr.next()));
		}

		int position1 = 3;
		int position2 = 15;

		// Deals with an object that is in the array list
		arraylist.add(position1, testobject2);												// First occurrence
		arraylist.add(position2, testobject2);												// Second occurrence
		assertEquals("49 : indexOf()", position1, arraylist.indexOf(testobject2));											
		assertEquals("50 : indexOf()", position1, arraylist.indexOf(testobject2, 0));
		assertEquals("51 : indexOf()", position1, arraylist.indexOf(testobject2, position1));
		assertEquals("52 : indexOf()", position2, arraylist.indexOf(testobject2, position1 + 1));
		assertEquals("53 : indexOf()", -1, arraylist.indexOf(testobject2, 22));
		assertEquals("54 : lastIndexOf()", position2, arraylist.lastIndexOf(testobject2));
		assertEquals("55 : lastIndexOf()", position2, arraylist.lastIndexOf(testobject2, 22));
		assertEquals("56 : lastIndexOf()", position2, arraylist.lastIndexOf(testobject2, position2 + 1));
		assertEquals("57 : lastIndexOf()", position1, arraylist.lastIndexOf(testobject2, position2 - 1));
		assertEquals("58 : lastIndexOf()", -1, arraylist.lastIndexOf(testobject2, 0));

		// Cleanup
		arraylist.remove(testobject2);
		arraylist.remove(testobject2);

		// Deals with an object that isn't in the array list
		GenericTestObject dudObject = makeNewTestObject("dud");
		assertEquals("59 : indexOf()", -1, arraylist.indexOf(dudObject));
		assertEquals("60 : indexOf()", -1, arraylist.indexOf(dudObject, 0));
		assertEquals("61 : indexOf()", -1, arraylist.indexOf(dudObject, 4));
		assertEquals("62 : indexOf()", -1, arraylist.indexOf(dudObject, 20));
		assertEquals("63 : lastIndexOf()", -1, arraylist.lastIndexOf(dudObject));
		assertEquals("64 : lastIndexOf()", -1, arraylist.lastIndexOf(dudObject, 20));
		assertEquals("65 : lastIndexOf()", -1, arraylist.lastIndexOf(dudObject, 4));
		assertEquals("66 : lastIndexOf()", -1, arraylist.lastIndexOf(dudObject, 0));

		arraylist.remove(testobject1);

		// Taking an iterator over a CopyOnWriteArray creates an Iterator with a snapshot
		// of the array as it appeared when the snapshot was taken. Any additions or removals are not reflected
		// in the iterator		

		Iterator<GenericTestObject> itr1 = arraylist.iterator();			// Take a snapshot iterator...
		arraylist.add(testobject1);												// ... add an object to arraylist
		assertEquals("67 : contains()", true, arraylist.contains(testobject1));

		boolean matchFound = false;
		while(itr1.hasNext() && !matchFound)								// ... step through the iterator looking for the object ...
		{																	// ... even though it *IS* in arraylist the iterator should *NOT* be able to 'see' it
			GenericTestObject nextObject = itr1.next();
			if(nextObject.equals(testobject1))
				matchFound = true;
		}

		assertEquals("68 : iterator()", false, matchFound);

		Iterator<GenericTestObject> itr2 = arraylist.iterator();			// Take a snapshot iterator...

		arraylist.remove(testobject1);											// ... remove the object from arraylist ...
		assertEquals("69 : contains()", false, arraylist.contains(testobject1));

		matchFound = false;
		while(itr2.hasNext() && !matchFound)								// ... step through the iterator looking for the object ...
		{																	// ... even though it isn't in arraylist the iterator should be able to 'see' it
			GenericTestObject nextObject = itr2.next();
			if(nextObject.equals(testobject1))
				matchFound = true;
		}

		assertEquals("70 : iterator()", true, matchFound);

	}

	/**
	 * Makes use of stresslist to test multiple threads concurrent accessing and updating a single shared
	 * instance of CopyOnWriteArrayList. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		// Some data for use in the loop below
		GenericTestObject testObject1 = new GenericTestObject("testObject1", 1, 1, 1, true);
		GenericTestObject testObject2 = new GenericTestObject("testObject2", 2, 2, 2, false);
		GenericTestObject testObject3 = new GenericTestObject("testObject3", 3, 3, 3, false);

		ArrayList<GenericTestObject> stressTestObjects = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 10; i++)
		{
			stressTestObjects.add(makeNewTestObject("stressObject" + i));
		}

		// make sure we have some items to work with
		while(stresslist.size() < 400)
		{
			stresslist.add(makeNewTestObject());
		}

		// make sure we don't gobble all of the memory
		while(stresslist.size() > 600)
		{
			stresslist.remove(0);
		}

		// =================================================================================
		// Testing starts here
		
		try
		{
			stresslist.get(0);
			ListIterator<GenericTestObject> itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			ListIterator<GenericTestObject> itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.indexOf(testObject1, 0);
			stresslist.addAllAbsent(stressTestObjects);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.indexOf(testObject1, 20);
			stresslist.removeAll(stressTestObjects);
			stresslist.remove(0);
			stresslist.containsAll(stressTestObjects);
			stresslist.indexOf(testObject1);
			stresslist.indexOf(testObject3);
			stresslist.remove(testObject1);
			stresslist.indexOf(testObject3, 0);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.removeAll(stressTestObjects);
			stresslist.addAllAbsent(stressTestObjects);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.indexOf(testObject1);
			stresslist.toString();
			stresslist.containsAll(stressTestObjects);
			stresslist.toString();
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.add(10, testObject2);
			stresslist.indexOf(testObject3, 60);
			Iterator<GenericTestObject> itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.contains(testObject1);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.indexOf(testObject1, 20);
			stresslist.contains(testObject1);
			stresslist.remove(0);
			stresslist.indexOf(testObject3);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.add(10, testObject2);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.addAll(20, stressTestObjects);
			stresslist.get(0);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.containsAll(stressTestObjects);
			stresslist.contains(testObject1);
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.indexOf(testObject3);
			stresslist.set(0, testObject1);
			stresslist.equals(stresslist);
			stresslist.remove(testObject1);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.indexOf(testObject3, 60);
			stresslist.addAll(20, stressTestObjects);
			stresslist.set(0, testObject1);
			stresslist.indexOf(testObject1, 20);
			stresslist.add(10, testObject2);
			stresslist.remove(0);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 0);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.add(testObject1);
			stresslist.toString();
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.removeAll(stressTestObjects);
			stresslist.add(10, testObject2);
			stresslist.containsAll(stressTestObjects);
			stresslist.lastIndexOf(testObject3);
			stresslist.toArray();
			stresslist.containsAll(stressTestObjects);
			stresslist.set(0, testObject1);
			stresslist.indexOf(testObject3, 60);
			stresslist.contains(testObject1);
			stresslist.lastIndexOf(testObject3, 0);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.addAll(stressTestObjects);
			stresslist.size();
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.indexOf(testObject3, 0);
			stresslist.indexOf(testObject1, 20);
			stresslist.toString();
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.addAll(stressTestObjects);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.addAllAbsent(stressTestObjects);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.containsAll(stressTestObjects);
			stresslist.addAll(20, stressTestObjects);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.contains(testObject1);
			stresslist.equals(stresslist);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.contains(testObject1);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.set(0, testObject1);
			stresslist.remove(testObject3);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.set(0, testObject1);
			stresslist.indexOf(testObject1);
			stresslist.addAll(stressTestObjects);
			stresslist.lastIndexOf(testObject3, 0);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.containsAll(stressTestObjects);
			stresslist.remove(0);
			stresslist.indexOf(testObject1, 0);
			stresslist.lastIndexOf(testObject1);
			stresslist.indexOf(testObject1, 0);
			stresslist.get(0);
			stresslist.size();
			stresslist.indexOf(testObject1);
			stresslist.indexOf(testObject3);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.indexOf(testObject3, 0);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.contains(testObject1);
			stresslist.lastIndexOf(testObject1);
			stresslist.indexOf(testObject1, 20);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.toArray();
			stresslist.removeAll(stressTestObjects);
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 0);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.toArray();
			stresslist.lastIndexOf(testObject3, 0);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.containsAll(stressTestObjects);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.toString();
			stresslist.indexOf(testObject1);
			stresslist.addIfAbsent(testObject2);
			stresslist.addIfAbsent(testObject2);
			stresslist.get(0);
			stresslist.size();
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.lastIndexOf(testObject3, 22);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.addAll(stressTestObjects);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.addIfAbsent(testObject2);
			stresslist.contains(testObject3);
			stresslist.lastIndexOf(testObject3);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.add(testObject1);
			stresslist.remove(testObject1);
			stresslist.get(0);
			stresslist.remove(testObject3);
			stresslist.indexOf(testObject1);
			stresslist.toArray();
			stresslist.addAll(stressTestObjects);
			stresslist.toArray();
			stresslist.size();
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.containsAll(stressTestObjects);
			stresslist.set(0, testObject1);
			stresslist.indexOf(testObject1, 20);
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.contains(testObject3);
			stresslist.indexOf(testObject1);
			stresslist.remove(testObject1);
			stresslist.addAll(stressTestObjects);
			stresslist.remove(testObject3);
			stresslist.indexOf(testObject3, 0);
			stresslist.add(10, testObject2);
			stresslist.indexOf(testObject3);
			stresslist.toArray();
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.indexOf(testObject1, 0);
			stresslist.addIfAbsent(testObject2);
			stresslist.indexOf(testObject3, 0);
			stresslist.contains(testObject1);
			stresslist.indexOf(testObject1);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.addAll(stressTestObjects);
			stresslist.containsAll(stressTestObjects);
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.size();
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.add(10, testObject2);
			stresslist.addAll(20, stressTestObjects);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.add(10, testObject2);
			stresslist.containsAll(stressTestObjects);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.toString();
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.addAll(stressTestObjects);
			stresslist.add(10, testObject2);
			stresslist.contains(testObject3);
			stresslist.lastIndexOf(testObject1);
			stresslist.addAll(20, stressTestObjects);
			stresslist.set(0, testObject1);
			stresslist.remove(0);
			stresslist.addAll(stressTestObjects);
			stresslist.contains(testObject3);
			stresslist.indexOf(testObject1, 0);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.add(10, testObject2);
			stresslist.indexOf(testObject3);
			stresslist.addIfAbsent(testObject2);
			stresslist.lastIndexOf(testObject1);
			stresslist.remove(0);
			stresslist.removeAll(stressTestObjects);
			stresslist.indexOf(testObject1, 20);
			stresslist.remove(testObject3);
			stresslist.indexOf(testObject1);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.addAll(stressTestObjects);
			stresslist.contains(testObject3);
			stresslist.size();
			stresslist.set(0, testObject1);
			stresslist.toArray();
			stresslist.indexOf(testObject1, 0);
			stresslist.toString();
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.remove(testObject1);
			stresslist.indexOf(testObject1);
			stresslist.addAll(20, stressTestObjects);
			stresslist.indexOf(testObject1, 20);
			stresslist.remove(0);
			stresslist.set(0, testObject1);
			stresslist.add(testObject1);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.contains(testObject3);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.add(testObject1);
			stresslist.indexOf(testObject1, 0);
			stresslist.indexOf(testObject1, 20);
			stresslist.containsAll(stressTestObjects);
			stresslist.add(10, testObject2);
			stresslist.containsAll(stressTestObjects);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.set(0, testObject1);
			stresslist.indexOf(testObject3);
			stresslist.addIfAbsent(testObject2);
			stresslist.addAll(20, stressTestObjects);
			stresslist.add(testObject1);
			stresslist.contains(testObject3);
			stresslist.contains(testObject3);
			stresslist.contains(testObject3);
			stresslist.add(10, testObject2);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.lastIndexOf(testObject1);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.addAll(stressTestObjects);
			stresslist.toArray();
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.equals(stresslist);
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.equals(stresslist);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.indexOf(testObject1);
			stresslist.indexOf(testObject1, 20);
			stresslist.indexOf(testObject3, 60);
			stresslist.get(0);
			stresslist.contains(testObject1);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.remove(testObject1);
			stresslist.addIfAbsent(testObject2);
			stresslist.removeAll(stressTestObjects);
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.add(testObject1);
			stresslist.get(0);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.lastIndexOf(testObject1);
			stresslist.contains(testObject3);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.set(0, testObject1);
			stresslist.lastIndexOf(testObject3);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.lastIndexOf(testObject3, 22);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.add(testObject1);
			stresslist.contains(testObject1);
			stresslist.addIfAbsent(testObject2);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.contains(testObject3);
			stresslist.indexOf(testObject3, 60);
			stresslist.add(testObject1);
			while(stresslist.contains(testObject2))
			{
				stresslist.remove(testObject2);
			}
			stresslist.addAll(stressTestObjects);
			stresslist.containsAll(stressTestObjects);
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.toArray();
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.addAll(stressTestObjects);
			stresslist.equals(stresslist);
			stresslist.indexOf(testObject3);
			stresslist.size();
			stresslist.size();
			stresslist.lastIndexOf(testObject3);
			stresslist.toArray(new GenericTestObject[10]);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.indexOf(testObject1, 0);
			stresslist.lastIndexOf(testObject1);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.indexOf(testObject3);
			stresslist.indexOf(testObject3, 60);
			stresslist.add(10, testObject2);
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.size();
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.addIfAbsent(testObject2);
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.get(0);
			stresslist.removeAll(stressTestObjects);
			stresslist.addIfAbsent(testObject2);
			stresslist.indexOf(testObject3, 60);
			stresslist.lastIndexOf(testObject1, 30);
			stresslist.contains(testObject1);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.size();
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.lastIndexOf(testObject3);
			stresslist.indexOf(testObject1, 0);
			stresslist.indexOf(testObject1, 20);
			stresslist.toString();
			stresslist.lastIndexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.lastIndexOf(testObject3);
			stresslist.indexOf(testObject3, 0);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.set(0, testObject1);
			stresslist.addAll(20, stressTestObjects);
			stresslist.lastIndexOf(testObject1, 30);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.addAll(20, stressTestObjects);
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.indexOf(testObject3);
			itr2 = stresslist.listIterator();
			while(itr2.hasNext())
			{
				itr2.next();
				stresslist.set(0, testObject2);
			}
			stresslist.set(0, testObject1);
			stresslist.size();
			stresslist.indexOf(testObject3, 0);
			stresslist.addAll(stressTestObjects);
			stresslist.addAllAbsent(stressTestObjects);
			stresslist.indexOf(testObject1, 20);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.lastIndexOf(testObject3);
			stresslist.indexOf(testObject3);
			stresslist.indexOf(testObject1, 0);
			stresslist.toArray(new GenericTestObject[10]);
			stresslist.size();
			stresslist.containsAll(stressTestObjects);
			itr = stresslist.iterator();
			while(itr.hasNext())
			{
				stresslist.contains(itr.next());
			}
			stresslist.lastIndexOf(testObject3, 22);
			stresslist.lastIndexOf(testObject1, 0);
			stresslist.remove(testObject1);
			stresslist.toString();
			stresslist.remove(testObject3);
			stresslist.contains(testObject3);
			stresslist.indexOf(testObject3, 0);
			stresslist.remove(testObject1);
			itr3 = stresslist.listIterator(0);
			while(itr3.hasNext())
			{
				itr3.next();
				stresslist.contains(testObject2);
			}
			stresslist.indexOf(testObject3, 60);
			stresslist.addAll(stressTestObjects);
			stresslist.containsAll(stressTestObjects);
			if(stresslist.get(0).equals(testObject1))
			{
				stresslist.set(0, testObject2);
			}
			stresslist.addIfAbsent(testObject2);
		}
		catch(NoSuchElementException e)
		{
			// Can be thrown if we call stresslist.iterator().next() right after a call to clear() was made
		}
	}
}
