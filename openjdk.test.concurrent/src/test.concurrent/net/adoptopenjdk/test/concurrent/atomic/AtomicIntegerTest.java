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
 * File:    AtomicIntegerTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * AtomicIntegerTest
 * =================
 *  
 * Attempts to verify the correct function of the AtomicInteger class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicInteger
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicInteger
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

public class AtomicIntegerTest extends ConcurrentTest
{

	// An instance of AtomicInteger specific to this class
	public AtomicInteger localTestInteger = new AtomicInteger();
	// An instance of AtomicInteger shared across all running instances of this testcase
	public static AtomicInteger sharedTestInteger = new AtomicInteger();
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicInteger class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Constructors
		
		localTestInteger = new AtomicInteger();
		AtomicInteger secondTestInteger = new AtomicInteger();
		assertEquals("1 : init()", 0, localTestInteger.get());
		assertEquals("2 : init()", localTestInteger.get(), secondTestInteger.get());
		
		Integer nextRandom = rng.nextInt();
		localTestInteger = new AtomicInteger(nextRandom);
		secondTestInteger = new AtomicInteger(nextRandom);
		assertEquals("3 : init()", nextRandom.intValue(), localTestInteger.get());
		assertEquals("4 : init()", localTestInteger.get(), secondTestInteger.get());
		
		// =================================================================================
		// Interrogating current value
		
		assertEquals("5 : intValue()", nextRandom.intValue(), localTestInteger.intValue());
		assertEquals("6 : intValue()", localTestInteger.intValue(), secondTestInteger.intValue());		
		assertEquals("7 : doubleValue()", nextRandom.doubleValue(), localTestInteger.doubleValue());
		assertEquals("8 : doubleValue()", localTestInteger.doubleValue(), secondTestInteger.doubleValue());
		assertEquals("9 : floatValue()", nextRandom.floatValue(), localTestInteger.floatValue());
		assertEquals("10 : floatValue()", localTestInteger.floatValue(), secondTestInteger.floatValue());
		assertEquals("11 : longValue()", nextRandom.longValue(), localTestInteger.longValue());
		assertEquals("12 : longValue()", localTestInteger.longValue(), secondTestInteger.longValue());
		assertEquals("13 : byteValue()", nextRandom.byteValue(), localTestInteger.byteValue());
		assertEquals("14 : byteValue()", localTestInteger.byteValue(), secondTestInteger.byteValue());
		assertEquals("15 : shortValue()", nextRandom.shortValue(), localTestInteger.shortValue());
		assertEquals("16 : shortValue()", localTestInteger.shortValue(), secondTestInteger.shortValue());
		assertEquals("17 : toString()", nextRandom.toString(), localTestInteger.toString());
		assertEquals("18 : toString()", localTestInteger.toString(), secondTestInteger.toString());
		
		// =================================================================================
		// Setting a new value
		
		nextRandom = rng.nextInt();
		localTestInteger.set(nextRandom);
		assertEquals("19 : set()", nextRandom.intValue(), localTestInteger.get());
		
		// =================================================================================
		// All atomic operations
		nextRandom = rng.nextInt();
		localTestInteger = new AtomicInteger(nextRandom);
		
		assertEquals("19 : addAndGet()", nextRandom + 4, localTestInteger.addAndGet(4));
		assertEquals("20 : addAndGet()", nextRandom - 3, localTestInteger.addAndGet(-7));
		assertEquals("21 : addAndGet()", nextRandom.intValue(), localTestInteger.addAndGet(3));
		assertEquals("22 : addAndGet()", nextRandom.intValue(), localTestInteger.addAndGet(0));
		
		assertEquals("23 : getAndAdd()", nextRandom.intValue(), localTestInteger.getAndAdd(10));
		assertEquals("24 : getAndAdd()", nextRandom + 10, localTestInteger.getAndAdd(-4));
		assertEquals("25 : getAndAdd()", nextRandom + 6, localTestInteger.getAndAdd(-6));
		assertEquals("26 : getAndAdd() behaved incorrectly", nextRandom.intValue(), localTestInteger.get());
		
		assertEquals("27 : getAndSet()", nextRandom.intValue(), localTestInteger.getAndSet(2147483647));
		assertEquals("28 : getAndSet()", 2147483647, localTestInteger.getAndSet(-2147483648));
		assertEquals("29 : getAndSet()", -2147483648, localTestInteger.getAndSet(nextRandom));
		assertEquals("30 : getAndSet() behaved incorrectly", nextRandom.intValue(), localTestInteger.get());
		
		assertEquals("31 : compareAndSet()", true, localTestInteger.compareAndSet(nextRandom.intValue(), 2147483647));
		assertEquals("32 : compareAndSet()", true, localTestInteger.compareAndSet(2147483647, 0));
		assertEquals("33 : compareAndSet()", false, localTestInteger.compareAndSet(2147483647, -2147483648));
		assertEquals("34 : compareAndSet()", true, localTestInteger.compareAndSet(0, -2147483648));
		assertEquals("35 : compareAndSet()", true, localTestInteger.compareAndSet(-2147483648, nextRandom.intValue()));
		
		assertEquals("36 : weakCompareAndSet()", true, localTestInteger.weakCompareAndSet(nextRandom.intValue(), 2147483647));
		assertEquals("37 : weakCompareAndSet()", true, localTestInteger.weakCompareAndSet(2147483647, 0));
		assertEquals("38 : weakCompareAndSet()", false, localTestInteger.weakCompareAndSet(2147483647, -2147483648));
		assertEquals("39 : weakCompareAndSet()", true, localTestInteger.weakCompareAndSet(0, -2147483648));
		assertEquals("40 : weakCompareAndSet()", true, localTestInteger.weakCompareAndSet(-2147483648, nextRandom.intValue()));
		
		for(int i = 0; i < 20; i = i + 2)
		{
			assertEquals("41 : getAndIncrement()", nextRandom + i, localTestInteger.getAndIncrement());
			assertEquals("42 : getAndIncrement()", nextRandom + i + 2, localTestInteger.incrementAndGet());
		}
		
		for(int i = 20; i > 0; i = i - 2)
		{
			assertEquals("43 : getAndDecrement()", nextRandom + i, localTestInteger.getAndDecrement());
			assertEquals("44 : getAndDecrement()", nextRandom + i - 2, localTestInteger.decrementAndGet());
		}
		
		int value = 2147483647;
		localTestInteger = new AtomicInteger(2147483647);
		for(int i = 0; i < 100; i++)
		{
			assertEquals("45 : getAndIncrement()", value++, localTestInteger.getAndIncrement());
			assertEquals("46 : getAndIncrement()", ++value, localTestInteger.incrementAndGet());
			assertEquals("47 : getAndIncrement()", value--, localTestInteger.getAndDecrement());
			assertEquals("48 : getAndIncrement()", --value, localTestInteger.decrementAndGet());
		}
	}	
	
	/**
	 * Makes use of sharedTestInteger to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicInteger. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.floatValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.doubleValue();
		sharedTestInteger.intValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.doubleValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.intValue();
		sharedTestInteger.toString();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.intValue();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.doubleValue();
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.toString();
		sharedTestInteger.longValue();
		sharedTestInteger.byteValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.intValue();
		sharedTestInteger.longValue();
		sharedTestInteger.longValue();
		sharedTestInteger.intValue();
		sharedTestInteger.byteValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.shortValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.toString();
		sharedTestInteger.toString();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.longValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.intValue();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.longValue(); 
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.longValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.toString();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.intValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.byteValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.floatValue();
		sharedTestInteger.intValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.longValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.intValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.byteValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.doubleValue();
		sharedTestInteger.intValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.byteValue();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.toString();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.byteValue();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.byteValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.longValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.intValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.shortValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.intValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.shortValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.intValue();
		sharedTestInteger.intValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.intValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.longValue(); 
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.byteValue();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.longValue(); 
		sharedTestInteger.shortValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.byteValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.toString();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.longValue(); 
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.longValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.byteValue();
		sharedTestInteger.toString();
		sharedTestInteger.floatValue();
		sharedTestInteger.longValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.intValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.shortValue();
		sharedTestInteger.intValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.longValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.shortValue();
		sharedTestInteger.intValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.byteValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.toString();
		sharedTestInteger.intValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.toString();
		sharedTestInteger.intValue();
		sharedTestInteger.byteValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.shortValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.toString();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.intValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.toString();
		sharedTestInteger.doubleValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.longValue();
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.doubleValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.longValue(); 
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.byteValue();
		sharedTestInteger.longValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.toString();
		sharedTestInteger.longValue();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.intValue();
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.lazySet(rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.byteValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.doubleValue();
		sharedTestInteger.shortValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.getAndIncrement();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.intValue();
		sharedTestInteger.decrementAndGet();
		sharedTestInteger.doubleValue();
		sharedTestInteger.toString();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.longValue();
		sharedTestInteger.toString();
		sharedTestInteger.floatValue();
		sharedTestInteger.getAndSet(rng.nextInt());
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.intValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.getAndDecrement();
		sharedTestInteger.toString();
		sharedTestInteger.intValue();
		sharedTestInteger.byteValue();
		sharedTestInteger.longValue(); 
		sharedTestInteger.doubleValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.set(rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.longValue();
		sharedTestInteger.weakCompareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.floatValue();
		sharedTestInteger.toString();
		sharedTestInteger.intValue();
		sharedTestInteger.incrementAndGet();
		sharedTestInteger.longValue(); 
		sharedTestInteger.longValue();
		sharedTestInteger.getAndAdd(rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.floatValue();
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.addAndGet(rng.nextInt());
		sharedTestInteger.compareAndSet(sharedTestInteger.get(), rng.nextInt());
		sharedTestInteger.shortValue();
		sharedTestInteger.shortValue();
	}
}
