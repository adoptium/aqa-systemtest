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
 * File:    AtomicIntegerFieldUpdaterTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicIntegerFieldUpdaterTest
 * =============================
 * 
 * Attempts to verify the correct function of the AtomicIntegerFieldUpdater class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicIntegerFieldUpdater
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicIntegerFieldUpdater
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

public class AtomicIntegerFieldUpdaterTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	@SuppressWarnings("unchecked")
	private AtomicIntegerFieldUpdater<AtomicTestObject>[] updaters = new AtomicIntegerFieldUpdater[5];
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicTestObject classTestObject = new AtomicTestObject();
	
	/**
	 * Small helper function to get a randomly selected AtomicIntegerFieldUpdater from the pool available to test with
	 * @return
	 */
	private AtomicIntegerFieldUpdater<AtomicTestObject> getRandomUpdater()
	{
		return updaters[rng.nextInt(updaters.length)];
	}
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicIntegerFieldUpdater class.
	 */	
	public void testAPI()
	{
				
		// =================================================================================
		// Create instances of AtomicIntegerFieldUpdater to work with
		
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		}

		// =================================================================================
		// API Testing
		
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
		assertEquals("12 : addAndGet() getAndAdd()", getRandomUpdater().addAndGet(testObject1, Integer.MAX_VALUE), getRandomUpdater().getAndAdd(testObject2, 0) + Integer.MAX_VALUE);
		assertEquals("13 : addAndGet() getAndAdd()", getRandomUpdater().addAndGet(testObject1, -Integer.MAX_VALUE), getRandomUpdater().getAndAdd(testObject2, 0));
		
		assertEquals("14 : decrementAndGet()", 42, getRandomUpdater().decrementAndGet(testObject1));
		assertEquals("15 : get() decrementAndGet()", getRandomUpdater().get(testObject1), getRandomUpdater().decrementAndGet(testObject2));
		assertEquals("16 : getAndDecrement() incrementAndGet()", getRandomUpdater().getAndDecrement(testObject1), getRandomUpdater().incrementAndGet(testObject1));
		assertEquals("17 : decrementAndGet() getAndIncrement()", getRandomUpdater().decrementAndGet(testObject2), getRandomUpdater().getAndIncrement(testObject2));
		
		getRandomUpdater().set(testObject1, Integer.MIN_VALUE);
		assertEquals("18 : set() get()", Integer.MIN_VALUE, getRandomUpdater().get(testObject1));
		assertEquals("19 : decrementAndGet()", Integer.MAX_VALUE, getRandomUpdater().decrementAndGet(testObject1));
		getRandomUpdater().set(testObject1, 42);
		assertEquals("20 : set() get()", 42, getRandomUpdater().get(testObject2));
		
		getRandomUpdater().set(testObject1, Integer.MAX_VALUE);
		assertEquals("21 : set() get()", Integer.MAX_VALUE, getRandomUpdater().get(testObject1));
		assertEquals("22 : incrementAndGet()", Integer.MIN_VALUE, getRandomUpdater().incrementAndGet(testObject1));
		getRandomUpdater().set(testObject1, 42);
		assertEquals("23 : set() get()", 42, getRandomUpdater().get(testObject2));
		
		assertEquals("24 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, 42, -2147483648));
		assertEquals("25 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject1, Integer.MIN_VALUE, 42));
		assertEquals("26 : compareAndSet()", false, getRandomUpdater().compareAndSet(testObject1, 0, 42));
		
		assertEquals("27 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject2, 42, 2147483647));
		assertEquals("28 : compareAndSet()", true, getRandomUpdater().compareAndSet(testObject2, Integer.MAX_VALUE, 42));
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
	 * instance of AtomicInteger. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		// Create some new instances of AtomicIntegerFieldUpdater to work with
		for(int i = 0; i < updaters.length; i++)
		{
			updaters[i] = AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		}
				
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().get(classTestObject);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().hashCode();
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().get(classTestObject);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().set(classTestObject, 0);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().set(classTestObject, 0);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		AtomicIntegerFieldUpdater.newUpdater(AtomicTestObject.class, "volatileInt");
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().weakCompareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndSet(classTestObject, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().set(classTestObject, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().set(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, -0);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndAdd(classTestObject, 0);
		getRandomUpdater().weakCompareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().set(classTestObject, 0);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().lazySet(classTestObject, rng.nextInt());
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().get(classTestObject);
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().set(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MIN_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().compareAndSet(classTestObject, getRandomUpdater().get(classTestObject), rng.nextInt());
		getRandomUpdater().addAndGet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().getAndAdd(classTestObject, rng.nextInt());
		getRandomUpdater().getAndDecrement(classTestObject);
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().hashCode();
		getRandomUpdater().compareAndSet(classTestObject, -47, rng.nextInt());
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().incrementAndGet(classTestObject);
		getRandomUpdater().getAndIncrement(classTestObject);
		getRandomUpdater().hashCode();
		getRandomUpdater().lazySet(classTestObject, Integer.MAX_VALUE);
		getRandomUpdater().hashCode();

	}
}
