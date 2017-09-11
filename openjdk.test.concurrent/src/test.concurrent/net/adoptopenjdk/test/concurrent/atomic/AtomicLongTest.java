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
 * File:    AtomicLongTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * AtomicLongTest
 * ==============
 * 
 * Attempts to verify the correct function of the AtomicLong class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicLong
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicLong
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

public class AtomicLongTest extends ConcurrentTest
{

	// An instance of AtomicLong specific to this class
	public AtomicLong localTestLong = new AtomicLong();
	// An instance of AtomicLong shared across all running instances of this testcase
	public static AtomicLong sharedTestLong = new AtomicLong();
		
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicLong class.
	 */	
	public void testAPI()
	{
		// =================================================================================
		// Constructors
		
		localTestLong = new AtomicLong();
		AtomicLong secondTestLong = new AtomicLong();
		assertEquals("1 : init()", 0, localTestLong.get());
		assertEquals("2 : init()", localTestLong.get(), secondTestLong.get());
		
		Long nextRandom = rng.nextLong();
		localTestLong = new AtomicLong(nextRandom);
		secondTestLong = new AtomicLong(nextRandom);
		assertEquals("3 : init()", nextRandom.longValue(), localTestLong.get());
		assertEquals("4 : init()", localTestLong.get(), secondTestLong.get());
		
		// =================================================================================
		// Interrogating current value
		
		assertEquals("5 : intValue()", nextRandom.intValue(), localTestLong.intValue());
		assertEquals("6 : intValue()", localTestLong.intValue(), secondTestLong.intValue());
		assertEquals("7 : doubleValue()", nextRandom.doubleValue(), localTestLong.doubleValue());
		assertEquals("8 : doubleValue()", localTestLong.doubleValue(), secondTestLong.doubleValue());
		assertEquals("9 : floatValue()", nextRandom.floatValue(), localTestLong.floatValue());
		assertEquals("10 : floatValue()", localTestLong.floatValue(), secondTestLong.floatValue());		
		assertEquals("11 : longValue()", nextRandom.longValue(), localTestLong.longValue());
		assertEquals("12 : longValue()", localTestLong.longValue(), secondTestLong.longValue());		
		assertEquals("13 : byteValue()", nextRandom.byteValue(), localTestLong.byteValue());
		assertEquals("14 : byteValue()", localTestLong.byteValue(), secondTestLong.byteValue());		
		assertEquals("15 : shortValue()", nextRandom.shortValue(), localTestLong.shortValue());
		assertEquals("16 : shortValue()", localTestLong.shortValue(), secondTestLong.shortValue());		
		assertEquals("17 : toString()", nextRandom.toString(), localTestLong.toString());
		assertEquals("18 : toString()", localTestLong.toString(), secondTestLong.toString());

		// =================================================================================
		// Setting a new value
		nextRandom = rng.nextLong();
		localTestLong.set(nextRandom);
		assertEquals("19 : set()", nextRandom.longValue(), localTestLong.get());
		
		// =================================================================================		
		// All atomic operations
		nextRandom = rng.nextLong();
		localTestLong = new AtomicLong(nextRandom);
		
		assertEquals("20 : addAndGet()", nextRandom + 4, localTestLong.addAndGet(4));
		assertEquals("21 : addAndGet()", nextRandom - 3, localTestLong.addAndGet(-7));
		assertEquals("22 : addAndGet()", nextRandom.longValue(), localTestLong.addAndGet(3));
		assertEquals("23 : addAndGet()", nextRandom.longValue(), localTestLong.addAndGet(0));
		
		assertEquals("24 : getAndAdd()", nextRandom.longValue(), localTestLong.getAndAdd(10));
		assertEquals("25 : getAndAdd()", nextRandom + 10, localTestLong.getAndAdd(-4));
		assertEquals("26 : getAndAdd()", nextRandom + 6, localTestLong.getAndAdd(-6));
		assertEquals("27 : getAndAdd() behaved incorrectly", nextRandom.longValue(), localTestLong.get());
		
		assertEquals("28 : getAndSet()", nextRandom.longValue(), localTestLong.getAndSet(Long.MAX_VALUE));
		assertEquals("29 : getAndSet()", Long.MAX_VALUE, localTestLong.getAndSet(Long.MIN_VALUE));
		assertEquals("30 : getAndSet()", Long.MIN_VALUE, localTestLong.getAndSet(nextRandom));
		assertEquals("31 : getAndSet() behaved incorrectly", nextRandom.longValue(), localTestLong.get());
		
		assertEquals("32 : compareAndSet()", true, localTestLong.compareAndSet(nextRandom.longValue(), Long.MAX_VALUE));
		assertEquals("33 : compareAndSet()", true, localTestLong.compareAndSet(Long.MAX_VALUE, 0));
		assertEquals("34 : compareAndSet()", false, localTestLong.compareAndSet(Long.MAX_VALUE, Long.MIN_VALUE));
		assertEquals("35 : compareAndSet()", true, localTestLong.compareAndSet(0, Long.MIN_VALUE));
		assertEquals("36 : compareAndSet()", true, localTestLong.compareAndSet(Long.MIN_VALUE, nextRandom.longValue()));
		
		assertEquals("37 : weakCompareAndSet()", true, localTestLong.weakCompareAndSet(nextRandom.longValue(), Long.MAX_VALUE));
		assertEquals("38 : weakCompareAndSet()", true, localTestLong.weakCompareAndSet(Long.MAX_VALUE, 0));
		assertEquals("39 : weakCompareAndSet()", false, localTestLong.weakCompareAndSet(Long.MAX_VALUE, Long.MIN_VALUE));
		assertEquals("40 : weakCompareAndSet()", true, localTestLong.weakCompareAndSet(0, Long.MIN_VALUE));
		assertEquals("41 : weakCompareAndSet()", true, localTestLong.weakCompareAndSet(Long.MIN_VALUE, nextRandom.longValue()));
		
		for(int i = 0; i < 20; i = i + 2)
		{
			assertEquals("42 : getAndIncrement()", nextRandom + i, localTestLong.getAndIncrement());
			assertEquals("43 : getAndIncrement()", nextRandom + i + 2, localTestLong.incrementAndGet());
		}
		
		for(int i = 20; i > 0; i = i - 2)
		{
			assertEquals("44 : getAndDecrement()", nextRandom + i, localTestLong.getAndDecrement());
			assertEquals("45 : getAndDecrement()", nextRandom + i - 2, localTestLong.decrementAndGet());
		}
		
		long value = Long.MAX_VALUE;
		localTestLong = new AtomicLong(Long.MAX_VALUE);
		for(int i = 0; i < 100; i++)
		{
			assertEquals("46 : getAndIncrement()", value++, localTestLong.getAndIncrement());
			assertEquals("47 : getAndIncrement()", ++value, localTestLong.incrementAndGet());
			assertEquals("48 : getAndIncrement()", value--, localTestLong.getAndDecrement());
			assertEquals("49 : getAndIncrement()", --value, localTestLong.decrementAndGet());
		}
	}	
	
	/**
	 * Makes use of sharedTestLong to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicLong. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.floatValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.decrementAndGet();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.doubleValue();
		sharedTestLong.intValue();
		sharedTestLong.shortValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.decrementAndGet();
		sharedTestLong.doubleValue();
		sharedTestLong.shortValue();
		sharedTestLong.intValue();
		sharedTestLong.toString();
		sharedTestLong.decrementAndGet();
		sharedTestLong.intValue();
		sharedTestLong.decrementAndGet();
		sharedTestLong.doubleValue();
		sharedTestLong.doubleValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.toString();
		sharedTestLong.longValue();
		sharedTestLong.byteValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.intValue();
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.intValue();
		sharedTestLong.byteValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.shortValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndDecrement();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.toString();
		sharedTestLong.toString();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.intValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndDecrement();
		sharedTestLong.longValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.toString();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.intValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.longValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.byteValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.floatValue();
		sharedTestLong.intValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.intValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.byteValue();
		sharedTestLong.shortValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.doubleValue();
		sharedTestLong.intValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.byteValue();
		sharedTestLong.getAndIncrement();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.toString();
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.byteValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.byteValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.doubleValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.intValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.shortValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.intValue();
		sharedTestLong.shortValue();
		sharedTestLong.floatValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndIncrement();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.shortValue();
		sharedTestLong.floatValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.shortValue();
		sharedTestLong.shortValue();
		sharedTestLong.getAndIncrement();
		sharedTestLong.intValue();
		sharedTestLong.intValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.intValue();
		sharedTestLong.shortValue();
		sharedTestLong.getAndIncrement();
		sharedTestLong.longValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.byteValue();
		sharedTestLong.getAndIncrement();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.getAndIncrement();
		sharedTestLong.longValue();
		sharedTestLong.shortValue();
		sharedTestLong.longValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.getAndIncrement();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.byteValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.decrementAndGet();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.toString();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.longValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndIncrement();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.decrementAndGet();
		sharedTestLong.longValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.byteValue();
		sharedTestLong.toString();
		sharedTestLong.floatValue();
		sharedTestLong.longValue();
		sharedTestLong.floatValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.intValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.shortValue();
		sharedTestLong.intValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.longValue();
		sharedTestLong.shortValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.getAndDecrement();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.shortValue();
		sharedTestLong.intValue();
		sharedTestLong.floatValue();
		sharedTestLong.longValue();
		sharedTestLong.byteValue();
		sharedTestLong.shortValue();
		sharedTestLong.longValue();
		sharedTestLong.toString();
		sharedTestLong.intValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.toString();
		sharedTestLong.intValue();
		sharedTestLong.byteValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.floatValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.shortValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.toString();
		sharedTestLong.getAndIncrement();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.intValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.decrementAndGet();
		sharedTestLong.toString();
		sharedTestLong.doubleValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.longValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.doubleValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.incrementAndGet();
		sharedTestLong.getAndIncrement();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.byteValue();
		sharedTestLong.longValue();
		sharedTestLong.floatValue();
		sharedTestLong.toString();
		sharedTestLong.longValue();
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.shortValue();
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndDecrement();
		sharedTestLong.intValue();
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.lazySet(rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.byteValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.doubleValue();
		sharedTestLong.shortValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.decrementAndGet();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.getAndIncrement();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.incrementAndGet();
		sharedTestLong.incrementAndGet();
		sharedTestLong.intValue();
		sharedTestLong.decrementAndGet();
		sharedTestLong.doubleValue();
		sharedTestLong.toString();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.longValue();
		sharedTestLong.toString();
		sharedTestLong.floatValue();
		sharedTestLong.getAndSet(rng.nextLong());
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.intValue();
		sharedTestLong.longValue();
		sharedTestLong.getAndDecrement();
		sharedTestLong.toString();
		sharedTestLong.intValue();
		sharedTestLong.byteValue();
		sharedTestLong.longValue();
		sharedTestLong.doubleValue();
		sharedTestLong.floatValue();
		sharedTestLong.set(rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.longValue();
		sharedTestLong.weakCompareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.floatValue();
		sharedTestLong.toString();
		sharedTestLong.intValue();
		sharedTestLong.incrementAndGet();
		sharedTestLong.longValue();
		sharedTestLong.longValue();
		sharedTestLong.getAndAdd(rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.floatValue();
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.addAndGet(rng.nextLong());
		sharedTestLong.compareAndSet(sharedTestLong.get(), rng.nextLong());
		sharedTestLong.shortValue();
		sharedTestLong.shortValue();
	}
}
