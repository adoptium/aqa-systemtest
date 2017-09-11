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
 * File:    AtomicReferenceFieldUpdaterTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicReferenceFieldUpdaterTest
 * ===============================
 * 
 * Attempts to verify the correct function of the AtomicLongFieldUpdater class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicReferenceFieldUpdater
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicReferenceFieldUpdater
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

public class AtomicReferenceFieldUpdaterTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	@SuppressWarnings("unchecked")
	private AtomicReferenceFieldUpdater<AtomicTestObject, String>[] updaters = new AtomicReferenceFieldUpdater[5];
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicTestObject classTestObject = new AtomicTestObject();
	
	/**
	 * Small helper function to get a randomly selected AtomicReferenceFieldUpdater from the pool available to test with
	 * @return
	 */
	private AtomicReferenceFieldUpdater<AtomicTestObject, String> getRandomUpdater()
	{
		return updaters[rng.nextInt(updaters.length)];
	}
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicReferenceFieldUpdater class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Create instances of AtomicReferenceFieldUpdater to work with
		
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		}
		
		// =================================================================================
		// Basic API tests 
		
		assertEquals("1 : get()", "the answer", getRandomUpdater().get(testObject1));
		assertEquals("2 : get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject2));
		assertEquals("3 : get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject1));
		assertEquals("4 : get()", getRandomUpdater().get(testObject2), getRandomUpdater().get(testObject2));
		
		assertEquals("5 : getAndSet()", "the answer", getRandomUpdater().getAndSet(testObject1, "the question"));
		assertEquals("6 : get()", "the question", getRandomUpdater().get(testObject1));
		assertEquals("7 : getAndSet()", "the question", getRandomUpdater().getAndSet(testObject1, "the answer"));
		
		assertEquals("8 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, "the answer", "the question"));
		assertEquals("9 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject2, "the answer", "the question"));
		assertEquals("10: get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject2));
		assertEquals("11: compareAndSet()", false, getRandomUpdater().compareAndSet(testObject1, "the answer", "the question"));
		assertEquals("12: compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, "the question", "the answer"));		
	}
	
	/**
	 * Makes use of classTestObject and getRandomUpdater() to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicReference. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		// Create some new instances of AtomicIntegerFieldUpdater to work with
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		}
				
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().get(classTestObject);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().getAndSet(classTestObject, getRandomUpdater().get(classTestObject));
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().getAndSet(classTestObject, null);
		getRandomUpdater().lazySet(classTestObject, null);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		AtomicReferenceFieldUpdater.newUpdater(AtomicTestObject.class, String.class, "volatileString");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().set(classTestObject, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, "the answer", "not the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().set(classTestObject, "not the answer");
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().getAndSet(classTestObject, "the answer");
		getRandomUpdater().lazySet(classTestObject, "the answer");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), null);
		getRandomUpdater().compareAndSet(classTestObject, "not the answer", null);
		getRandomUpdater().compareAndSet(classTestObject, null, "the answer");
	}
}
