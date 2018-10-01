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
 * File:    CopyOnWriteArraySetTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * CopyOnWriteArraySetTest
 * =======================
 * 
 * Attempts to verify the correct function of the CopyOnWriteArrayList class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of CopyOnWriteArraySet
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of CopyOnWriteArraySet
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

public class CopyOnWriteArraySetTest extends ConcurrentTest
{

	// arrayset is for the generic api tests
	private CopyOnWriteArraySet<GenericTestObject> arrayset = new CopyOnWriteArraySet<GenericTestObject>();

	// stressset is specifically for testStress
	private static CopyOnWriteArraySet<GenericTestObject> stressset = new CopyOnWriteArraySet<GenericTestObject>();	

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

		assertEquals("1 : size()", 0, arrayset.size());
		assertEquals("2 : isEmpty()", true, arrayset.isEmpty());
		assertEquals("3 : contains()", false, arrayset.contains(testobject1));

		assertEquals("4 : add()", true, arrayset.add(testobject1));
		assertEquals("5 : add()", false, arrayset.add(testobject1));

		assertEquals("6 : size()", 1, arrayset.size());
		assertEquals("7 : isEmpty()", false, arrayset.isEmpty());
		assertEquals("8 : contains()", true, arrayset.contains(testobject1));

		assertEquals("9 : add()", true, arrayset.add(testobject2));

		assertEquals("10 : size()", 2, arrayset.size());
		assertEquals("11 : isEmpty()", false, arrayset.isEmpty());
		assertEquals("12 : contains()", true, arrayset.contains(testobject1));

		arrayset.clear();

		assertEquals("13 : size()", 0, arrayset.size());
		assertEquals("14 : isEmpty()", true, arrayset.isEmpty());
		assertEquals("15 : contains()", false, arrayset.contains(testobject1));

		assertEquals("16 : add()", true, arrayset.add(testobject1));
		assertEquals("17 : size()", 1, arrayset.size());
		assertEquals("18 : remove()", true, arrayset.remove(testobject1));
		assertEquals("19 : size()", 0, arrayset.size());
		assertEquals("20 : isEmpty()", true, arrayset.isEmpty());
		assertEquals("21 : contains()", false, arrayset.contains(testobject1));

		assertEquals("22 : addAll()", true, arrayset.addAll(testObjects));
		assertEquals("23 : containsAll()", true, arrayset.containsAll(testObjects));

		int i = 0;

		Iterator<GenericTestObject> itr = arrayset.iterator();
		while(itr.hasNext())
		{
			assertEquals("24 : contains()", true, arrayset.contains(itr.next()));

			if(i++ == 3)
				arrayset.remove(itr.next());	// remove an element from the set
		}

		assertEquals("25 : containsAll()", false, arrayset.containsAll(testObjects));
		assertEquals("26 : addAll()", true, arrayset.addAll(testObjects));
		assertEquals("27 : addAll()", false, arrayset.addAll(testObjects));

		assertEquals("28 : add()", true, arrayset.add(testobject1));
		assertEquals("29 : size()", 21, arrayset.size());
		assertEquals("30 : retainAll()", true, arrayset.retainAll(testObjects));
		assertEquals("31 : size()", 20, arrayset.size());
		assertEquals("32 : retainAll()", false, arrayset.retainAll(testObjects));
		assertEquals("33 : size()", 20, arrayset.size());

		// Taking an iterator over a CopyOnWriteArray creates an Iterator with a snapshot
		// of the array as it appeared when the snapshot was taken. Any additions or removals are not reflected
		// in the iterator
		GenericTestObject object = makeNewTestObject();						

		Iterator<GenericTestObject> itr1 = arrayset.iterator();				// Take a snapshot iterator...
		arrayset.add(object);												// ... add an object to arraylist
		assertEquals("34 : contains()", true, arrayset.contains(object));

		boolean matchFound = false;
		while(itr1.hasNext() && !matchFound)								// ... step through the iterator looking for the object ...
		{																	// ... even though it *IS* in arraylist the iterator should *NOT* be able to 'see' it
			GenericTestObject nextObject = itr1.next();
			if(nextObject.equals(object))
				matchFound = true;
		}

		assertEquals("35 : iterator()", false, matchFound);

		Iterator<GenericTestObject> itr2 = arrayset.iterator();				// Take a snapshot iterator...

		arrayset.remove(object);											// ... remove the object from arraylist ...
		assertEquals("36 : contains()", false, arrayset.contains(object));

		matchFound = false;
		while(itr2.hasNext() && !matchFound)								// ... step through the iterator looking for the object ...
		{																	// ... even though it isn't in arraylist the iterator should be able to 'see' it
			GenericTestObject nextObject = itr2.next();
			if(nextObject.equals(object))
				matchFound = true;
		}

		assertEquals("37 : iterator()", true, matchFound);
	}

	/**
	 * Makes use of stressset to test multiple threads concurrently accessing and updating a single shared
	 * instance of CopyOnWriteArraySet. Makes repeated API calls. The API calls
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
		for(int i = 0; i < 20; i++)
		{
			stressTestObjects.add(makeNewTestObject("stressObject" + i));
		}

		// make sure we have some items to work with
		while(stressset.size() < 100)
		{
			stressset.add(makeNewTestObject());
		}

		// make sure we don't gobble all of the memory
		while(stressset.size() > 200)
		{
			stressset.remove(stressset.iterator().next());
		}

		// =================================================================================
		// Testing starts here
		
		stressset.toArray();
		Iterator<GenericTestObject> itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.retainAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.toArray(new GenericTestObject[10]);
		stressset.toArray(new GenericTestObject[10]);
		stressset.addAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.equals(stressset);
		stressset.remove(testObject1);
		stressset.clear();
		stressset.addAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.equals(stressset);
		stressset.contains(testObject1);
		stressset.remove(testObject2);
		stressset.containsAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.size();
		stressset.remove(testObject1);
		stressset.equals(stressset);
		stressset.retainAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.isEmpty();
		stressset.addAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.toArray();
		stressset.remove(testObject2);
		stressset.isEmpty();
		stressset.toArray(new GenericTestObject[10]);
		stressset.toArray(new GenericTestObject[10]);
		stressset.removeAll(stressTestObjects);
		stressset.retainAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.remove(testObject1);
		stressset.toArray();
		stressset.equals(stressset);
		stressset.remove(testObject2);
		stressset.equals(stressset);
		stressset.remove(testObject2);
		stressset.clear();
		stressset.contains(testObject3);
		stressset.size();
		stressset.contains(testObject1);
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject2);
		stressset.addAll(stressTestObjects);
		stressset.size();
		stressset.addAll(stressTestObjects);
		stressset.isEmpty();
		stressset.clear();
		stressset.containsAll(stressTestObjects);
		stressset.contains(testObject1);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.retainAll(stressTestObjects);
		stressset.isEmpty();
		stressset.contains(testObject3);
		stressset.equals(stressset);
		stressset.isEmpty();
		stressset.contains(testObject1);
		stressset.equals(stressset);
		stressset.removeAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.toArray();
		stressset.add(testObject1);
		stressset.contains(testObject3);
		stressset.remove(testObject1);
		stressset.retainAll(stressTestObjects);
		stressset.isEmpty();
		stressset.equals(stressset);
		stressset.retainAll(stressTestObjects);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.toArray(new GenericTestObject[10]);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.containsAll(stressTestObjects);
		stressset.isEmpty();
		stressset.toArray();
		stressset.toArray();
		stressset.contains(testObject3);
		stressset.clear();
		stressset.toArray();
		stressset.isEmpty();
		stressset.contains(testObject3);
		stressset.addAll(stressTestObjects);
		stressset.size();
		stressset.toArray(new GenericTestObject[10]);
		stressset.toString();
		stressset.equals(stressset);
		stressset.containsAll(stressTestObjects);
		stressset.clear();
		stressset.add(testObject1);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.toString();
		stressset.contains(testObject3);
		stressset.isEmpty();
		stressset.removeAll(stressTestObjects);
		stressset.clear();
		stressset.contains(testObject1);
		stressset.toArray(new GenericTestObject[10]);
		stressset.containsAll(stressTestObjects);
		stressset.equals(stressset);
		stressset.removeAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.toString();
		stressset.toArray(new GenericTestObject[10]);
		stressset.retainAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.size();
		stressset.retainAll(stressTestObjects);
		stressset.toArray();
		stressset.retainAll(stressTestObjects);
		stressset.contains(testObject3);
		stressset.retainAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.retainAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.isEmpty();
		stressset.isEmpty();
		stressset.equals(stressset);
		stressset.size();
		stressset.add(testObject1);
		stressset.contains(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.size();
		stressset.containsAll(stressTestObjects);
		stressset.clear();
		stressset.contains(testObject1);
		stressset.contains(testObject1);
		stressset.toArray();
		stressset.toString();
		stressset.removeAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.toString();
		stressset.remove(testObject2);
		stressset.remove(testObject1);
		stressset.isEmpty();
		stressset.contains(testObject3);
		stressset.size();
		stressset.add(testObject1);
		stressset.contains(testObject1);
		stressset.toArray();
		stressset.addAll(stressTestObjects);
		stressset.size();
		stressset.size();
		stressset.equals(stressset);
		stressset.containsAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.remove(testObject1);
		stressset.remove(testObject1);
		stressset.size();
		stressset.contains(testObject1);
		stressset.remove(testObject2);
		stressset.add(testObject1);
		stressset.retainAll(stressTestObjects);
		stressset.retainAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.toArray();
		stressset.retainAll(stressTestObjects);
		stressset.contains(testObject3);
		stressset.retainAll(stressTestObjects);
		stressset.retainAll(stressTestObjects);
		stressset.clear();
		stressset.removeAll(stressTestObjects);
		stressset.contains(testObject3);
		stressset.size();
		stressset.toArray();
		stressset.isEmpty();
		stressset.contains(testObject3);
		stressset.addAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.containsAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.clear();
		stressset.equals(stressset);
		stressset.contains(testObject1);
		stressset.isEmpty();
		stressset.toArray();
		stressset.contains(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.contains(testObject3);
		stressset.remove(testObject2);
		stressset.isEmpty();
		stressset.removeAll(stressTestObjects);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.retainAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.retainAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.contains(testObject1);
		stressset.contains(testObject1);
		stressset.toString();
		stressset.clear();
		stressset.removeAll(stressTestObjects);
		stressset.retainAll(stressTestObjects);
		stressset.toString();
		stressset.clear();
		stressset.add(testObject1);
		stressset.contains(testObject3);
		stressset.add(testObject1);
		stressset.remove(testObject1);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.containsAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.toString();
		stressset.contains(testObject3);
		stressset.isEmpty();
		stressset.equals(stressset);
		stressset.size();
		stressset.add(testObject1);
		stressset.size();
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject2);
		stressset.addAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.contains(testObject1);
		stressset.addAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.addAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.toArray(new GenericTestObject[10]);
		stressset.size();
		stressset.removeAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.clear();
		stressset.retainAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.isEmpty();
		stressset.addAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.toArray();
		stressset.addAll(stressTestObjects);
		stressset.toString();
		stressset.toArray(new GenericTestObject[10]);
		stressset.toArray();
		stressset.remove(testObject2);
		stressset.clear();
		stressset.remove(testObject2);
		stressset.contains(testObject1);
		stressset.toString();
		stressset.toArray();
		stressset.removeAll(stressTestObjects);
		stressset.toArray();
		stressset.remove(testObject2);
		stressset.retainAll(stressTestObjects);
		stressset.clear();
		stressset.removeAll(stressTestObjects);
		stressset.add(testObject1);
		stressset.isEmpty();
		stressset.remove(testObject1);
		stressset.addAll(stressTestObjects);
		stressset.equals(stressset);
		stressset.remove(testObject2);
		stressset.equals(stressset);
		stressset.toArray(new GenericTestObject[10]);
		stressset.size();
		stressset.size();
		stressset.toArray();
		stressset.isEmpty();
		stressset.remove(testObject1);
		stressset.remove(testObject2);
		stressset.contains(testObject3);
		stressset.equals(stressset);
		stressset.contains(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.toArray();
		stressset.containsAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.clear();
		stressset.containsAll(stressTestObjects);
		stressset.equals(stressset);
		stressset.containsAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.size();
		stressset.remove(testObject1);
		stressset.remove(testObject2);
		stressset.add(testObject1);
		stressset.retainAll(stressTestObjects);
		stressset.size();
		stressset.add(testObject1);
		stressset.toArray();
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.remove(testObject1);
		stressset.isEmpty();
		stressset.toString();
		stressset.clear();
		stressset.toArray(new GenericTestObject[10]);
		stressset.clear();
		stressset.equals(stressset);
		stressset.clear();
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject1);
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject2);
		stressset.remove(testObject1);
		stressset.toArray(new GenericTestObject[10]);
		stressset.retainAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.clear();
		stressset.equals(stressset);
		stressset.removeAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.containsAll(stressTestObjects);
		stressset.toArray();
		stressset.isEmpty();
		stressset.clear();
		stressset.add(testObject1);
		stressset.remove(testObject2);
		stressset.toArray();
		stressset.contains(testObject1);
		stressset.remove(testObject1);
		stressset.remove(testObject1);
		stressset.toString();
		stressset.remove(testObject2);
		stressset.size();
		stressset.clear();
		stressset.contains(testObject1);
		stressset.isEmpty();
		stressset.equals(stressset);
		stressset.removeAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.remove(testObject2);
		stressset.remove(testObject1);
		stressset.removeAll(stressTestObjects);
		stressset.remove(testObject2);
		stressset.toString();
		stressset.removeAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.remove(testObject1);
		stressset.retainAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject2);
		stressset.add(testObject1);
		stressset.add(testObject1);
		stressset.toArray();
		stressset.toArray(new GenericTestObject[10]);
		stressset.clear();
		stressset.toArray(new GenericTestObject[10]);
		stressset.containsAll(stressTestObjects);
		stressset.contains(testObject1);
		stressset.isEmpty();
		stressset.isEmpty();
		stressset.toString();
		stressset.toArray(new GenericTestObject[10]);
		stressset.addAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.addAll(stressTestObjects);
		stressset.removeAll(stressTestObjects);
		stressset.equals(stressset);
		stressset.toArray(new GenericTestObject[10]);
		stressset.remove(testObject1);
		stressset.add(testObject1);
		stressset.contains(testObject1);
		stressset.removeAll(stressTestObjects);
		itr = stressset.iterator();
		while(itr.hasNext())
		{
			stressset.add(itr.next());
		}
		stressset.toString();
		stressset.contains(testObject3);
		stressset.toArray();
		stressset.contains(testObject1);
		stressset.addAll(stressTestObjects);
		stressset.size();
		stressset.add(testObject1);
		stressset.isEmpty();
		stressset.containsAll(stressTestObjects);
		stressset.toArray(new GenericTestObject[10]);
		stressset.add(testObject1);
		stressset.remove(testObject1);
		stressset.containsAll(stressTestObjects);
		stressset.size();
		stressset.equals(stressset);
		stressset.retainAll(stressTestObjects);
		stressset.clear();
		stressset.clear();
		stressset.toArray(new GenericTestObject[10]);
	}

}
