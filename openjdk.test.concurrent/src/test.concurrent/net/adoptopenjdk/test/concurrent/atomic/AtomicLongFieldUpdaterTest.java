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
 * File:    AtomicLongFieldUpdaterTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicLongFieldUpdaterTest
 * ==========================
 * 
 * Attempts to verify the correct function of the AtomicLongFieldUpdater class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicLongFieldUpdater
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicLongFieldUpdater
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

public class AtomicLongFieldUpdaterTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	@SuppressWarnings("unchecked")
	private AtomicLongFieldUpdater<AtomicTestObject>[] updaters = new AtomicLongFieldUpdater[5];
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicTestObject classTestObject = new AtomicTestObject();
	
	/**
	 * Small helper function to get a randomly selected AtomicLongFieldUpdater from the pool available to test with
	 * @return
	 */
	private AtomicLongFieldUpdater<AtomicTestObject> getRandomUpdater()
	{
		return updaters[rng.nextInt(updaters.length)];
	}
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicLongFieldUpdater class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Create instances of AtomicLongFieldUpdater to work with
		
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		}

		// =================================================================================
		// Constructors
		
		assertEquals("1 : get()", 42, getRandomUpdater().get(testObject1));
		assertEquals("2 : get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject2));
		assertEquals("3 : get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject1));
		assertEquals("4 : get()", getRandomUpdater().get(testObject2), getRandomUpdater().get(testObject2));
		
		assertEquals("5 : addAndGet()", 43, getRandomUpdater().addAndGet(testObject1, 1));
		assertEquals("6 : get() addAndGet()", getRandomUpdater().get(testObject1), getRandomUpdater().addAndGet(testObject2, 1));
		assertEquals("7 : addAndGet()", 0, getRandomUpdater().addAndGet(testObject1, -43));
		assertEquals("8 : addAndGet() get()", 43, getRandomUpdater().addAndGet(testObject1, getRandomUpdater().get(testObject2)));
		assertEquals("9 : getAndAdd()", 43, getRandomUpdater().getAndAdd(testObject2, 43));
		assertEquals("10 : addAndGet()", 43, getRandomUpdater().addAndGet(testObject2, -43));
		assertEquals("11 : getAndAdd() addAndGet()", getRandomUpdater().getAndAdd(testObject2, 0), getRandomUpdater().addAndGet(testObject2, 0));
		assertEquals("12 : addAndGet() getAndAdd()", getRandomUpdater().addAndGet(testObject1, Long.MAX_VALUE), getRandomUpdater().getAndAdd(testObject2, 0) + Long.MAX_VALUE);
		assertEquals("13 : addAndGet() getAndAdd()", getRandomUpdater().addAndGet(testObject1, -Long.MAX_VALUE), getRandomUpdater().getAndAdd(testObject2, 0));
		
		assertEquals("14 : decrementAndGet()", 42, getRandomUpdater().decrementAndGet(testObject1));
		assertEquals("15 : get() decrementAndGet()", getRandomUpdater().get(testObject1), getRandomUpdater().decrementAndGet(testObject2));
		assertEquals("16 : getAndDecrement() incrementAndGet()", getRandomUpdater().getAndDecrement(testObject1), getRandomUpdater().incrementAndGet(testObject1));
		assertEquals("17 : decrementAndGet() getAndIncrement()", getRandomUpdater().decrementAndGet(testObject2), getRandomUpdater().getAndIncrement(testObject2));
		
		getRandomUpdater().set(testObject1, Long.MIN_VALUE);
		assertEquals("18 : set() get()", Long.MIN_VALUE, getRandomUpdater().get(testObject1));
		assertEquals("19 : decrementAndGet()", Long.MAX_VALUE, getRandomUpdater().decrementAndGet(testObject1));
		getRandomUpdater().set(testObject1, 42);
		assertEquals("20 : set() get()", 42, getRandomUpdater().get(testObject2));
		
		getRandomUpdater().set(testObject1, Long.MAX_VALUE);
		assertEquals("21 : set() get()", Long.MAX_VALUE, getRandomUpdater().get(testObject1));
		assertEquals("22 : incrementAndGet()", Long.MIN_VALUE, getRandomUpdater().incrementAndGet(testObject1));
		getRandomUpdater().set(testObject1, 42);
		assertEquals("23 : set() get()", 42, getRandomUpdater().get(testObject2));
		
		assertEquals("24 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, 42, Long.MAX_VALUE));
		assertEquals("25 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, Long.MAX_VALUE, 42));
		assertEquals("26 : compareAndSet()", false, getRandomUpdater().compareAndSet(testObject1, 0, 42));
		
		assertEquals("27 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject2, 42, Long.MIN_VALUE));
		assertEquals("28 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject2, Long.MIN_VALUE, 42));
		assertEquals("29 : compareAndSet()", false, getRandomUpdater().compareAndSet(testObject2, 0, 42));

		assertEquals("30 : get() get()", getRandomUpdater().get(testObject1) == 42, getRandomUpdater().get(testObject2) == 42);
		assertEquals("31 : compareAndSet() get() incrementAndGet()", true, getRandomUpdater().compareAndSet(testObject1, getRandomUpdater().get(testObject1), getRandomUpdater().incrementAndGet(testObject2)));
		assertEquals("32 : get() get()", getRandomUpdater().get(testObject1), getRandomUpdater().get(testObject2));
		assertEquals("33 : getAndDecrement() incrementAndGet()", getRandomUpdater().getAndDecrement(testObject1), getRandomUpdater().incrementAndGet(testObject1));
		assertEquals("34 : andAndGet() get() addAndGet() get()", getRandomUpdater().addAndGet(testObject1, getRandomUpdater().get(testObject1)), getRandomUpdater().addAndGet(testObject2, getRandomUpdater().get(testObject2)));
		assertEquals("35 : compareAndSet() get()", true, getRandomUpdater().compareAndSet(testObject1, getRandomUpdater().get(testObject1), 42));
		assertEquals("36 : compareAndSet() get()", true, getRandomUpdater().compareAndSet(testObject2, getRandomUpdater().get(testObject2), 42));
	}
	
	/**
	 * Makes use of classTestObject and getRandomUpdater() to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicLong. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{		
		// Create some new instances of AtomicIntegerFieldUpdater to work with
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		}
				
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().get(classTestObject);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().hashCode();
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().get(classTestObject);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().set(classTestObject, 0);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, 0);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		AtomicLongFieldUpdater.newUpdater(AtomicTestObject.class, "volatileLong");
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().set(classTestObject, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, rng.nextLong());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().set(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MIN_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextLong());
		getRandomUpdater().addAndGet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextLong());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextLong());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Long.MAX_VALUE);
		getRandomUpdater().hashCode();
	}
}
