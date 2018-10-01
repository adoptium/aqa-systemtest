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
 * File:    AtomicLongArrayTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * AtomicLongArrayTest
 * ===================
 * 
 * Attempts to verify the correct function of the AtomicLongArray class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicLongArray
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicLongArray
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

public class AtomicLongArrayTest extends ConcurrentTest
{

	// An instance of AtomicLongArray specific to this class
	public AtomicLongArray localTestLongArray = new AtomicLongArray(25);
	
	// An instance of AtomicLongArray shared across all running instances of this testcase
	public static AtomicLongArray sharedTestLongArray = new AtomicLongArray(50);
		
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicLongArray class.
	 */	
	public void testAPI()
	{
		
		// =================================================================================
		// A collection of data to work with
		
		long[] dataset = new long[25];
			
		for(int i = 0; i < dataset.length; i++)
		{
			dataset[i] = rng.nextLong();
		}
		
		// =================================================================================
		// Constructors	
		
		localTestLongArray = new AtomicLongArray(dataset.length);
		AtomicLongArray secondTestLongArray = new AtomicLongArray(dataset.length);
		assertEquals("1 : init()", 0, localTestLongArray.get(0));
		assertEquals("2 : init()", localTestLongArray.get(0), secondTestLongArray.get(0));
		assertEquals("3 : init()", localTestLongArray.length(), secondTestLongArray.length());
		
		localTestLongArray = new AtomicLongArray(dataset);
		secondTestLongArray = new AtomicLongArray(dataset);
		assertEquals("4 : init()", dataset.length, localTestLongArray.length());
		assertEquals("5 : init()", localTestLongArray.length(), secondTestLongArray.length());
		
		for(int i = 0; i < localTestLongArray.length(); i++)
		{
			assertEquals("6 : init()[" + i + "]", dataset[i], localTestLongArray.get(i));
			assertEquals("7 : init()[" + i + "]", localTestLongArray.get(i), secondTestLongArray.get(i));
		}	
		
		// =================================================================================
		// Interrogating current value
		// No major operations here - see AtomicLongTest for all of the tests carried out on the integers themselves
		
		// Setting a new value
		Long nextRandom = rng.nextLong();
		Integer nextPosition = rng.nextInt(dataset.length);
		localTestLongArray.set(nextPosition, nextRandom);
		assertEquals("8 : set()", nextRandom.longValue(), localTestLongArray.get(nextPosition));
		
		// =================================================================================
		// All atomic operations
		nextRandom = rng.nextLong();
		localTestLongArray = new AtomicLongArray(dataset);
		
		// Might as well work through the whole array - this is a stress test after all
		for(int i = 0; i < dataset.length; i++)
		{
			Long nextValue = dataset[i];
			
			assertEquals("9 : addAndGet()", nextValue + 4, localTestLongArray.addAndGet(i, 4));
			assertEquals("10 : addAndGet()", nextValue - 3, localTestLongArray.addAndGet(i, -7));
			assertEquals("11 : addAndGet()", nextValue.longValue(), localTestLongArray.addAndGet(i, 3));
			assertEquals("12 : addAndGet()", nextValue.longValue(), localTestLongArray.addAndGet(i, 0));
		
			assertEquals("13 : getAndAdd()", nextValue.longValue(), localTestLongArray.getAndAdd(i, 10));
			assertEquals("14 : getAndAdd()", nextValue + 10, localTestLongArray.getAndAdd(i, -4));
			assertEquals("15 : getAndAdd()", nextValue + 6, localTestLongArray.getAndAdd(i, -6));
			assertEquals("16 : getAndAdd()", nextValue.longValue(), localTestLongArray.get(i));
			
			assertEquals("17 : getAndSet()", nextValue.longValue(), localTestLongArray.getAndSet(i, Long.MAX_VALUE));
			assertEquals("18 : getAndSet()", Long.MAX_VALUE, localTestLongArray.getAndSet(i, Long.MIN_VALUE));
			assertEquals("19 : getAndSet()", Long.MIN_VALUE, localTestLongArray.getAndSet(i, nextValue));
			assertEquals("20 : getAndSet()", nextValue.longValue(), localTestLongArray.get(i));
			
			assertEquals("21 : compareAndSet()", true, localTestLongArray.compareAndSet(i, nextValue, Long.MAX_VALUE));
			assertEquals("22 : compareAndSet()", true, localTestLongArray.compareAndSet(i, Long.MAX_VALUE, 0));
			assertEquals("23 : compareAndSet()", false, localTestLongArray.compareAndSet(i, Long.MAX_VALUE, -9223372036854775808L));
			assertEquals("24 : compareAndSet()", true, localTestLongArray.compareAndSet(i, 0, -9223372036854775808L));
			assertEquals("25 : compareAndSet()", true, localTestLongArray.compareAndSet(i, -9223372036854775808L, nextValue));
		
			assertEquals("26 : weakCompareAndSet()", true, localTestLongArray.weakCompareAndSet(i, nextValue, Long.MAX_VALUE));
			assertEquals("27 : weakCompareAndSet()", true, localTestLongArray.weakCompareAndSet(i, Long.MAX_VALUE, 0));
			assertEquals("28 : weakCompareAndSet()", false, localTestLongArray.weakCompareAndSet(i, Long.MAX_VALUE, Long.MIN_VALUE));
			assertEquals("29 : weakCompareAndSet()", true, localTestLongArray.weakCompareAndSet(i, 0, Long.MIN_VALUE));
			assertEquals("30 : weakCompareAndSet()", true, localTestLongArray.weakCompareAndSet(i, Long.MIN_VALUE, nextValue));
		
			for(int j = 0; j < 20; j = j + 2)
			{
				assertEquals("31 : getAndIncrement()", nextValue + j, localTestLongArray.getAndIncrement(i));
				assertEquals("32 : getAndIncrement()", nextValue + j + 2, localTestLongArray.incrementAndGet(i));
			}
		
			for(int j = 20; j > 0; j = j - 2)
			{
				assertEquals("33 : getAndDecrement()", nextValue + j, localTestLongArray.getAndDecrement(i));
				assertEquals("34 : getAndDecrement()", nextValue + j - 2, localTestLongArray.decrementAndGet(i));
			}
		
			long value = Long.MAX_VALUE;
			localTestLongArray.set(i, Long.MAX_VALUE);
			for(int j = 0; j < 100; j++)
			{
				assertEquals("35 : getAndIncrement()", value++, localTestLongArray.getAndIncrement(i));
				assertEquals("36 : getAndIncrement()", ++value, localTestLongArray.incrementAndGet(i));
				assertEquals("37 : getAndIncrement()", value--, localTestLongArray.getAndDecrement(i));
				assertEquals("38 : getAndIncrement()", --value, localTestLongArray.decrementAndGet(i));
			}
		}
	}	
	
	/**
	 * Makes use of sharedTestLongArray to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicLongArray. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		int operatingPosition = rng.nextInt(sharedTestLongArray.length());
		
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.toString();
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.toString();
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.toString();
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.toString();
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.set(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.toString();
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndIncrement(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndDecrement(operatingPosition);
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.addAndGet(operatingPosition, rng.nextLong());
		sharedTestLongArray.incrementAndGet(operatingPosition);
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.decrementAndGet(operatingPosition);
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.getAndAdd(operatingPosition, rng.nextLong());
		sharedTestLongArray.getAndSet(operatingPosition, rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.lazySet(operatingPosition, rng.nextLong());
		sharedTestLongArray.compareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());
		sharedTestLongArray.weakCompareAndSet(operatingPosition, sharedTestLongArray.get(operatingPosition), rng.nextLong());

	}
}
