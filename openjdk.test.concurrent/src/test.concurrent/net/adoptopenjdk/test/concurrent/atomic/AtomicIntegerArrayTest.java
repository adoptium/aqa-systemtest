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
 * File:    AtomicIntegerArrayTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * AtomicIntegerArrayTest
 * ======================
 * 
 * Attempts to verify the correct function of the AtomicIntegerArrayTest class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicIntegerArrayTest
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicIntegerArrayTest
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

public class AtomicIntegerArrayTest extends ConcurrentTest
{

	// An instance of AtomicIntegerArray specific to this class
	public AtomicIntegerArray localTestIntegerArray = new AtomicIntegerArray(25);
	// An instance of AtomicIntegerArray shared across all running instances of this testcase
	public static AtomicIntegerArray sharedTestIntegerArray = new AtomicIntegerArray(50);
		
	
	/**
	 * Verify the correct behaviour of the API for AtomicIntegerArray. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		
		// =================================================================================
		// Create some data to work with
		
		int[] dataset = new int[25];
			
		for(int i = 0; i < dataset.length; i++)
		{
			dataset[i] = rng.nextInt();
		}
		
		// =================================================================================
		// Constructors	
		
		localTestIntegerArray = new AtomicIntegerArray(dataset.length);
		AtomicIntegerArray secondTestIntegerArray = new AtomicIntegerArray(dataset.length);
		assertEquals("1 : init()", 0, localTestIntegerArray.get(0));
		assertEquals("2 : init()", localTestIntegerArray.get(0), secondTestIntegerArray.get(0));
		assertEquals("3 : init()", localTestIntegerArray.length(), secondTestIntegerArray.length());
		
		localTestIntegerArray = new AtomicIntegerArray(dataset);
		secondTestIntegerArray = new AtomicIntegerArray(dataset);
		assertEquals("4 : init()", dataset.length, localTestIntegerArray.length());
		assertEquals("5 : init()", localTestIntegerArray.length(), secondTestIntegerArray.length());
		
		for(int i = 0; i < localTestIntegerArray.length(); i++)
		{
			assertEquals("6 : init() [" + i + "]", dataset[i], localTestIntegerArray.get(i));
			assertEquals("7 : init() [" + i + "]", localTestIntegerArray.get(i), secondTestIntegerArray.get(i));
		}	
		
		// =================================================================================		
		// Interrogating current value
		// No major operations here - see AtomicIntegerTest for all of the tests carried out on the integers themselves
		
		// Setting a new value
		Integer nextRandom = rng.nextInt();
		Integer nextPosition = rng.nextInt(dataset.length);
		localTestIntegerArray.set(nextPosition, nextRandom);
		assertEquals("8 : set()", nextRandom.intValue(), localTestIntegerArray.get(nextPosition));
		
		// =================================================================================
		// All atomic operations
		
		nextRandom = rng.nextInt();
		localTestIntegerArray = new AtomicIntegerArray(dataset);
		
		// Might as well work through the whole array - this is a stress test after all
		for(int i = 0; i < dataset.length; i++)
		{
			int nextValue = dataset[i];
			
			assertEquals("9 : addAndGet()", nextValue + 4, localTestIntegerArray.addAndGet(i, 4));
			assertEquals("10 : addAndGet()", nextValue - 3, localTestIntegerArray.addAndGet(i, -7));
			assertEquals("11 : addAndGet()", nextValue, localTestIntegerArray.addAndGet(i, 3));
			assertEquals("12 : addAndGet()", nextValue, localTestIntegerArray.addAndGet(i, 0));
			
			assertEquals("13 : getAndAdd()", nextValue, localTestIntegerArray.getAndAdd(i, 10));
			assertEquals("14 : getAndAdd()", nextValue + 10, localTestIntegerArray.getAndAdd(i, -4));
			assertEquals("15 : getAndAdd()", nextValue + 6, localTestIntegerArray.getAndAdd(i, -6));
			assertEquals("16 : getAndAdd() behaved incorrectly", nextValue, localTestIntegerArray.get(i));
			
			assertEquals("17 : getAndSet()", nextValue, localTestIntegerArray.getAndSet(i, 2147483647));
			assertEquals("18 : getAndSet()", 2147483647, localTestIntegerArray.getAndSet(i, -2147483648));
			assertEquals("19 : getAndSet()", -2147483648, localTestIntegerArray.getAndSet(i, nextValue));
			assertEquals("20 : getAndSet() behaved incorrectly", nextValue, localTestIntegerArray.get(i));
			
			assertEquals("21 : compareAndSet()", true, localTestIntegerArray.compareAndSet(i, nextValue, 2147483647));
			assertEquals("22 : compareAndSet()", true, localTestIntegerArray.compareAndSet(i, 2147483647, 0));
			assertEquals("23 : compareAndSet()", false, localTestIntegerArray.compareAndSet(i, 2147483647, -2147483648));
			assertEquals("24 : compareAndSet()", true, localTestIntegerArray.compareAndSet(i, 0, -2147483648));
			assertEquals("25 : compareAndSet()", true, localTestIntegerArray.compareAndSet(i, -2147483648, nextValue));
		
			assertEquals("26 : weakCompareAndSet()", true, localTestIntegerArray.weakCompareAndSet(i, nextValue, 2147483647));
			assertEquals("27 : weakCompareAndSet()", true, localTestIntegerArray.weakCompareAndSet(i, 2147483647, 0));
			assertEquals("28 : weakCompareAndSet()", false, localTestIntegerArray.weakCompareAndSet(i, 2147483647, -2147483648));
			assertEquals("29 : weakCompareAndSet()", true, localTestIntegerArray.weakCompareAndSet(i, 0, -2147483648));
			assertEquals("30 : weakCompareAndSet()", true, localTestIntegerArray.weakCompareAndSet(i, -2147483648, nextValue));
		
			for(int j = 0; j < 20; j = j + 2)
			{
				assertEquals("31 : getAndIncrement()", nextValue + j, localTestIntegerArray.getAndIncrement(i));
				assertEquals("32 : getAndIncrement()", nextValue + j + 2, localTestIntegerArray.incrementAndGet(i));
			}
		
			for(int j = 20; j > 0; j = j - 2)
			{
				assertEquals("33 : getAndDecrement()", nextValue + j, localTestIntegerArray.getAndDecrement(i));
				assertEquals("34 : getAndDecrement()", nextValue + j - 2, localTestIntegerArray.decrementAndGet(i));
			}
		
			int value = 2147483647;
			localTestIntegerArray.set(i, 2147483647);
			for(int j = 0; j < 100; j++)
			{
				assertEquals("35 : getAndIncrement()", value++, localTestIntegerArray.getAndIncrement(i));
				assertEquals("36 : getAndIncrement()", ++value, localTestIntegerArray.incrementAndGet(i));
				assertEquals("37 : getAndIncrement()", value--, localTestIntegerArray.getAndDecrement(i));
				assertEquals("38 : getAndIncrement()", --value, localTestIntegerArray.decrementAndGet(i));
			}
		}
		
		dataset = null;
		localTestIntegerArray = null;
	}	
	
	/**
	 * Makes use of sharedTestIntegerArray to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicIntegerArray. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		int operatingPosition = rng.nextInt(sharedTestIntegerArray.length());
		
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.set(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.toString();
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndIncrement(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndDecrement(operatingPosition);
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.addAndGet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.incrementAndGet(operatingPosition);
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.decrementAndGet(operatingPosition);
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.getAndAdd(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.getAndSet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.lazySet(operatingPosition, rng.nextInt());
		sharedTestIntegerArray.compareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
		sharedTestIntegerArray.weakCompareAndSet(operatingPosition, sharedTestIntegerArray.get(operatingPosition), rng.nextInt());
	}
}
