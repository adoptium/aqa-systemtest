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
 * File:    AtomicReferenceArrayTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicReferenceArrayTest
 * ========================
 * 
 * Attempts to verify the correct function of the AtomicReferenceArray class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicReferenceArray
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicReferenceArray
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

public class AtomicReferenceArrayTest extends ConcurrentTest 
{

	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject[] testObjects;
	private AtomicReferenceArray<AtomicTestObject> testReference;

	// Variables shared across all instances of the test running in parallel
	private static AtomicTestObject[] stressTestObjects = new AtomicTestObject[100];
	private static AtomicReferenceArray<AtomicTestObject> stressReference = new AtomicReferenceArray<AtomicTestObject>(100);

	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicReferenceArray class.
	 */	
	public void testAPI()
	{
		testObjects = new AtomicTestObject[10];
		testReference = new AtomicReferenceArray<AtomicTestObject>(1);

		for(int i = 0; i < 10; i++)
		{
			testObjects[i] = new AtomicTestObject();
			testObjects[i].setNonVolatileInt(i);
			testObjects[i].setVolatileInt(i);
			testObjects[i].setNonVolatileLong(i);
			testObjects[i].setVolatileLong(i);
		}

		assertEquals("1 : length()", 1, testReference.length());
		testReference = new AtomicReferenceArray<AtomicTestObject>(3);
		assertEquals("2 : length()", 3, testReference.length());
		assertEquals("3 : get()", null, testReference.get(0));
		assertEquals("4 : get()", null, testReference.get(testReference.length() - 1));

		testReference = new AtomicReferenceArray<AtomicTestObject>(testObjects);
		assertEquals("5 : length()", testObjects.length, testReference.length());
		for(int i = 0; i < testObjects.length; i++)
		{
			assertEquals("6-" + i + " : get()", testObjects[i], testReference.get(i));
		}

		testReference.set(0, new AtomicTestObject());
		assertEquals("7 : set()", new AtomicTestObject(), testReference.get(0));
		assertEquals("8 : getAndSet()", new AtomicTestObject(), testReference.getAndSet(0, testObjects[0]));
		assertEquals("9 : get()", testObjects[0], testReference.get(0));

		assertEquals("10 : compareAndSet()", false, testReference.compareAndSet(0, testObjects[1], testObjects[1]));
		assertEquals("11 : compareAndSet()", true, testReference.compareAndSet(0, testObjects[0], testObjects[2]));
		assertEquals("12 : get()", testObjects[2], testReference.get(0));
		assertEquals("13 : compareAndSet()", true, testReference.compareAndSet(0, testObjects[2], testObjects[0]));
	}

	/**
	 * Makes use of stressReference to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicReferenceArray. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		int nextIndex1 = rng.nextInt(stressReference.length());
		int nextIndex2 = rng.nextInt(stressReference.length());
		
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, null);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.get(nextIndex2);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.set(nextIndex2, null);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.lazySet(nextIndex1, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.get(nextIndex2);
		stressReference.lazySet(nextIndex1, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.length();
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.get(nextIndex2);
		stressReference.length();
		stressReference.lazySet(nextIndex1, null);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.length();
		stressReference.set(nextIndex2, null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.length();
		stressReference.length();
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.length();
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.set(nextIndex2, null);
		stressReference.get(nextIndex2);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.length();
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.getAndSet(nextIndex2, null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.length();
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.length();
		stressReference.length();
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.set(nextIndex2, null);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.length();
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.length();
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, null);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.length();
		stressReference.getAndSet(nextIndex2, null);
		stressReference.get(nextIndex2);
		stressReference.length();
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.get(nextIndex2);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.get(nextIndex2);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.set(nextIndex2, null);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.set(nextIndex2, null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.length();
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, null);
		stressReference.lazySet(nextIndex1, null);
		stressReference.get(nextIndex2);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.set(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.get(nextIndex2);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.set(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.get(nextIndex2);
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.length();
		stressReference.set(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.getAndSet(nextIndex2, stressTestObjects[nextIndex2]);
		stressReference.length();
		stressReference.getAndSet(nextIndex2, stressReference.get(nextIndex1));
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.set(nextIndex2, null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), stressTestObjects[nextIndex2]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.weakCompareAndSet(nextIndex1, stressReference.get(nextIndex1), stressReference.get(nextIndex2));
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.weakCompareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.lazySet(nextIndex1, null);
		stressReference.lazySet(nextIndex1, stressTestObjects[nextIndex1]);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
		stressReference.get(nextIndex2);
		stressReference.compareAndSet(nextIndex1, stressReference.get(nextIndex1), null);
		stressReference.compareAndSet(nextIndex1, null, stressTestObjects[nextIndex1]);
	}
}
