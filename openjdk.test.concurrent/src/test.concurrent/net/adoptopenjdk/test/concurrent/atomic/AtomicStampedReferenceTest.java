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
 * File:    AtomicStampedReferenceTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicStampedReferenceTest
 * ==========================
 * 
 * Attempts to verify the correct function of the AtomicStampedReference class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicStampedReference
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicStampedReference
 * 							NOTE : This shared instance is separate to the instance used in testAPI()
 * 						-	API calls are not checked
 * 						-	Attempting to provoke a JIT response through repeated calls of the various API calls
 * 
 * This testcase makes use of class variables i.e. variables declared as 'static'. Usually this is a definite no-no
 * when it comes to tests run under a multithreaded stress testing engine. However, testing of many of the classes
 * in the java.util.concurrent package necessarily involves multiple threads accessing and modifying the same single data source.
 * This testcase was therefore designed to be run multiple times concurrently in such a way that threads do not interfere with
 * each other and cause incorrect results.
 * 
 */

public class AtomicStampedReferenceTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	private AtomicStampedReference<AtomicTestObject> testReference = new AtomicStampedReference<AtomicTestObject>(testObject1, 0);
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicTestObject stressObject = new AtomicTestObject();
	private static AtomicStampedReference<AtomicTestObject> stressReference = new AtomicStampedReference<AtomicTestObject>(stressObject, 0);
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicStampedReference class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Basic API tests
		
		assertEquals("1 : get()", testObject1, testReference.getReference());
		assertEquals("2 : get()", testObject2, testReference.getReference());
		
		testObject2.setNonVolatileInt(47);
		testObject2.setVolatileInt(47);
		testObject2.setNonVolatileLong(47);
		testObject2.setVolatileLong(47);
		
		assertEquals("3 : get()", testObject1, testReference.getReference());
		assertFalse("4 : get()", testObject2 == testReference.getReference());
		
		// Various combinations of in/correct object in/correct mark and matching/failing to match what is already set 
		assertEquals("5 : compareAndSet()",  true,  testReference.compareAndSet(testObject1, testObject2, 0, 1));
		assertEquals("6 : compareAndSet()",  false, testReference.compareAndSet(testObject1, testObject2, 1, 0));
		assertEquals("7 : compareAndSet()",  false, testReference.compareAndSet(testObject2, testObject1, 0, 1));
		assertEquals("8 : compareAndSet()",  false, testReference.compareAndSet(testObject1, testObject2, 0, 1));
				
		assertEquals("9 : compareAndSet()",  true,  testReference.compareAndSet(testObject2, testObject1, 1, 0));
		assertEquals("10 : compareAndSet()", true,  testReference.compareAndSet(testObject1, testObject1, 0, 0));
		assertEquals("11 : compareAndSet()", true,  testReference.compareAndSet(testObject1, testObject2, 0, 0));
		assertEquals("12 : compareAndSet()", true,  testReference.compareAndSet(testObject2, testObject1, 0, 1));		
		
		assertEquals("13 : getStamp()", 1, testReference.getStamp());
		assertEquals("14 : attemptStamp()", true, testReference.attemptStamp(testObject1, Integer.MAX_VALUE));
		assertEquals("15 : getStamp()", Integer.MAX_VALUE, testReference.getStamp());
		assertEquals("16 : compareAndSet() getStamp()", true, testReference.compareAndSet(testObject1, testObject1, Integer.MAX_VALUE, testReference.getStamp() + 1));
		assertEquals("17 : getStamp()", Integer.MIN_VALUE, testReference.getStamp());
		
		int[] stampHolder = new int[1];
		AtomicTestObject referenceObject = testReference.get(stampHolder);
		assertEquals("18 : get()", testReference.getStamp(), stampHolder[0]);
		assertEquals("19 : get()", testReference.getReference(), referenceObject);
	}
	
	/**
	 * Makes use of stressReference to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicStampedReference. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.attemptStamp(null, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.getStamp();
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.getStamp();
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(testObject2, 1);
		stressReference.getStamp();
		stressReference.getStamp();
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(null, 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(null, 0);
		stressReference.getStamp();
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.get(new int[5]);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.getStamp();
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.get(new int[5]);
		stressReference.getStamp();
		stressReference.get(new int[1]);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(testObject2, 1);
		stressReference.get(new int[5]);
		stressReference.get(new int[5]);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.set(null, 0);
		stressReference.get(new int[1]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(testObject2, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.set(testObject2, 1);
		stressReference.set(testObject2, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.set(null, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(testObject2, 1);
		stressReference.get(new int[1]);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(null, 1);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.get(new int[1]);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.getStamp();
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.get(new int[5]);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.getStamp();
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.set(testObject2, 1);
		stressReference.get(new int[1]);
		stressReference.attemptStamp(null, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.set(null, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.get(new int[1]);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.getStamp();
		stressReference.get(new int[5]);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.set(null, 1);
		stressReference.set(null, 0);
		stressReference.attemptStamp(null, 1);
		stressReference.set(null, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(null, 1);
		stressReference.set(null, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.getStamp();
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(testObject2, 1);
		stressReference.set(null, 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.getStamp();
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.get(new int[1]);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(null, 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.attemptStamp(null, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.get(new int[5]);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.get(new int[5]);
		stressReference.get(new int[1]);
		stressReference.get(new int[5]);
		stressReference.set(null, 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(testObject2, 1);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.attemptStamp(null, 1);
		stressReference.get(new int[5]);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.getStamp();
		stressReference.set(null, 1);
		stressReference.set(null, 1);
		stressReference.set(null, 1);
		stressReference.set(null, 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.getStamp();
		stressReference.set(null, 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.set(null, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.set(testObject2, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.attemptStamp(null, 1);
		stressReference.set(null, 1);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.get(new int[1]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.getStamp();
		stressReference.set(null, 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.get(new int[5]);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(testObject2, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.get(new int[5]);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.attemptStamp(null, 1);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.set(null, 1);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.set(testObject2, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.set(testObject2, 1);
		stressReference.set(null, 0);
		stressReference.get(new int[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.getStamp();
		stressReference.get(new int[1]);
		stressReference.set(testObject2, 1);
		stressReference.set(testObject2, 1);
		stressReference.getStamp();
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(testObject2, 1);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.getStamp();
		stressReference.set(testObject2, 1);
		stressReference.get(new int[5]);
		stressReference.set(null, 1);
		stressReference.set(testObject2, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(testObject2, 1);
		stressReference.get(new int[1]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.set(testObject2, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.attemptStamp(null, 1);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(null, 1);
		stressReference.get(new int[5]);
		stressReference.set(null, 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.getStamp();
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.getStamp(), 1);
		stressReference.set(null, 0);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.getStamp();
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.set(null, 0);
		stressReference.set(null, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.get(new int[5]);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.getStamp();
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.weakCompareAndSet(testObject1, testObject2, 0, 1);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.attemptStamp(stressReference.get(new int[1]), stressReference.getStamp() + Integer.MAX_VALUE);
		stressReference.compareAndSet(null, new AtomicTestObject(), 0, 1);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.weakCompareAndSet(null, null, 1, 1);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.set(new AtomicTestObject(), 0);
		stressReference.set(testObject2, 1);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.getStamp(), 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
		stressReference.compareAndSet(testObject1, null, 1, 1);
		stressReference.compareAndSet(null, testObject1, stressReference.getStamp(), 0);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, 0, 0);
	}
}
