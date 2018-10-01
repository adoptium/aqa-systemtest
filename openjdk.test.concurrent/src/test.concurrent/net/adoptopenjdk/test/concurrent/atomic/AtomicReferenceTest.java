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
 * File:    AtomicReferenceTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicReferenceTest
 * ===================
 * 
 * Attempts to verify the correct function of the AtomicReference class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicReference
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicReference
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

public class AtomicReferenceTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	private AtomicReference<AtomicTestObject> testReference = new AtomicReference<AtomicTestObject>();
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicReference<AtomicTestObject> stressReference = new AtomicReference<AtomicTestObject>();
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicReference class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Basic API tests
		
		assertEquals("1 : get()", null, testReference.get());
		testReference.set(testObject1);
		assertEquals("2 : get()", testObject1, testReference.get());
		assertEquals("3 : get()", testObject2, testReference.get());
		
		testObject2.setNonVolatileInt(47);
		testObject2.setVolatileInt(47);
		testObject2.setNonVolatileLong(47);
		testObject2.setVolatileLong(47);
		
		assertEquals("4 : get()", testObject1, testReference.get());
		assertFalse("5 : get()", testObject2 == testReference.get());
		
		assertEquals("6 : compareAndSet()", true, testReference.compareAndSet(testObject1, testObject2));
		assertEquals("7 : compareAndSet()", false, testReference.compareAndSet(testObject1, testObject2));
		assertEquals("8 : get()", testObject2, testReference.get());
		assertEquals("9 : compareAndSet()", true, testReference.compareAndSet(testObject2, null));
		assertEquals("10 : get()", null, testReference.get());
	}
	
	/**
	 * Makes use of stressReference to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicLong. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(new AtomicTestObject());
		stressReference.set(null);
		stressReference.set(new AtomicTestObject());
		stressReference.set(null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.set(testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.set(new AtomicTestObject());
		stressReference.set(null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(testObject1);
		stressReference.weakCompareAndSet(null, null);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.get();
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.getAndSet(testObject1);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.compareAndSet(null, testObject1);
		stressReference.set(testObject2);
		stressReference.get();
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.get();
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.get();
		stressReference.lazySet(new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.set(testObject2);
		stressReference.set(testObject2);
		stressReference.set(testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(null);
		stressReference.set(testObject2);
		stressReference.lazySet(null);
		stressReference.get();
		stressReference.get();
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.getAndSet(testObject1);
		stressReference.getAndSet(null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.lazySet(null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(null);
		stressReference.lazySet(null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.set(testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.lazySet(testObject1);
		stressReference.set(testObject2);
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(null, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(testObject2);
		stressReference.set(testObject2);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.getAndSet(null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.lazySet(null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.get();
		stressReference.compareAndSet(null, testObject1);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.set(testObject2);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.lazySet(null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(testObject2);
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.getAndSet(null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.lazySet(null);
		stressReference.getAndSet(null);
		stressReference.set(null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.lazySet(testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.get();
		stressReference.compareAndSet(null, testObject1);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(testObject1);
		stressReference.getAndSet(testObject1);
		stressReference.set(null);
		stressReference.lazySet(testObject1);
		stressReference.set(testObject2);
		stressReference.weakCompareAndSet(null, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.lazySet(testObject1);
		stressReference.set(testObject2);
		stressReference.get();
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.set(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(testObject2);
		stressReference.weakCompareAndSet(null, null);
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.getAndSet(testObject1);
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.getAndSet(null);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.getAndSet(null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.getAndSet(testObject1);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(null, testObject1);
		stressReference.get();
		stressReference.lazySet(null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.set(null);
		stressReference.get();
		stressReference.getAndSet(null);
		stressReference.get();
		stressReference.getAndSet(testObject1);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.lazySet(null);
		stressReference.getAndSet(null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.set(null);
		stressReference.get();
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(testObject2);
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.set(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.lazySet(testObject1);
		stressReference.getAndSet(testObject1);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.getAndSet(testObject1);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.lazySet(testObject1);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.set(null);
		stressReference.lazySet(testObject1);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.getAndSet(testObject1);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.get();
		stressReference.getAndSet(null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.lazySet(null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.get();
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(new AtomicTestObject());
		stressReference.set(null);
		stressReference.get();
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.set(testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.set(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.lazySet(testObject1);
		stressReference.getAndSet(null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.lazySet(null);
		stressReference.set(null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.getAndSet(testObject1);
		stressReference.getAndSet(null);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.compareAndSet(null, testObject1);
		stressReference.compareAndSet(testObject1, null);
		stressReference.get();
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.getAndSet(null);
		stressReference.lazySet(null);
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(new AtomicTestObject());
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.get();
		stressReference.lazySet(testObject1);
		stressReference.lazySet(null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.getAndSet(null);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(testObject1, null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(null);
		stressReference.set(testObject2);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.set(null);
		stressReference.weakCompareAndSet(null, null);
		stressReference.set(testObject2);
		stressReference.set(null);
		stressReference.get();
		stressReference.getAndSet(testObject1);
		stressReference.compareAndSet(testObject1, null);
		stressReference.set(testObject2);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.compareAndSet(null, testObject1);
		stressReference.compareAndSet(testObject1, null);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.set(new AtomicTestObject());
		stressReference.weakCompareAndSet(testObject2, testObject2);
		stressReference.getAndSet(testObject1);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(null, testObject1);
		stressReference.getAndSet(testObject1);
		stressReference.lazySet(testObject1);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.get();
		stressReference.weakCompareAndSet(null, null);
		stressReference.lazySet(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.weakCompareAndSet(testObject1, testObject2);
		stressReference.set(testObject2);
		stressReference.set(testObject2);
		stressReference.compareAndSet(null, new AtomicTestObject());
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.weakCompareAndSet(null, null);
		stressReference.lazySet(null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.set(new AtomicTestObject());
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.getAndSet(new AtomicTestObject());
		stressReference.lazySet(null);
		stressReference.weakCompareAndSet(testObject2, null);
		stressReference.compareAndSet(testObject1, testObject2);
		stressReference.compareAndSet(testObject1, null);
		stressReference.compareAndSet(null, testObject1);
		stressReference.compareAndSet(testObject1, testObject2);
	}
}
