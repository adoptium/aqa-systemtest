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
 * File:    AtomicBooleanTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * AtomicBooleanTest
 * =================
 * 
 * Attempts to verify the correct function of the AtomicBoolean class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicBoolean
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicBoolean
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

public class AtomicBooleanTest extends ConcurrentTest
{

	// An instance of AtomicBoolean specific to this class
	public AtomicBoolean localTestBoolean = new AtomicBoolean();
	// An instance of AtomicBoolean shared across all running instances of this testcase
	public static AtomicBoolean sharedTestBoolean = new AtomicBoolean();

	/**
	 * Verify the correct behaviour of the API for AtomicBoolean. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		
		// =================================================================================
		// Constructors	
		
		localTestBoolean = new AtomicBoolean();
		AtomicBoolean secondTestBoolean = new AtomicBoolean();
		assertEquals("1 : init()", false, localTestBoolean.get());
		assertEquals("2 : init()", localTestBoolean.get(), secondTestBoolean.get());
	
		Boolean nextRandom = rng.nextBoolean();
		localTestBoolean = new AtomicBoolean(nextRandom);
		secondTestBoolean = new AtomicBoolean(nextRandom);
		assertEquals("3 : init()", nextRandom.booleanValue(), localTestBoolean.get());
		assertEquals("4 : init()", localTestBoolean.get(), secondTestBoolean.get());
		
		// =================================================================================
		// Interrogating current value
		
		assertEquals("5 : toString()", nextRandom.toString(), localTestBoolean.toString());
		assertEquals("6 : toString()", localTestBoolean.toString(), secondTestBoolean.toString());
		
		// =================================================================================
		// Setting a new value
		
		nextRandom = rng.nextBoolean();
		localTestBoolean.set(nextRandom);
		assertEquals("7 : set()", nextRandom.booleanValue(), localTestBoolean.get());
		
		// =================================================================================
		// All atomic operations
		
		nextRandom = rng.nextBoolean();
		localTestBoolean = new AtomicBoolean(nextRandom);
		
		assertEquals("8 : getAndSet()", nextRandom.booleanValue(), localTestBoolean.getAndSet(true));
		assertEquals("9 : getAndSet()", true, localTestBoolean.getAndSet(true));
		assertEquals("10 : getAndSet()", true, localTestBoolean.getAndSet(false));
		assertEquals("11 : getAndSet()", false, localTestBoolean.getAndSet(true));
		assertEquals("12 : getAndSet()", true, localTestBoolean.getAndSet(nextRandom));
		assertEquals("13 : getAndSet()", nextRandom.booleanValue(), localTestBoolean.get());
		
		assertEquals("14 : compareAndSet()", true, localTestBoolean.compareAndSet(nextRandom, true));
		assertEquals("15 : compareAndSet()", false, localTestBoolean.compareAndSet(false, true));
		assertEquals("16 : compareAndSet()", true, localTestBoolean.compareAndSet(true, true));
		assertEquals("17 : compareAndSet()", true, localTestBoolean.compareAndSet(true, false));
		assertEquals("18 : compareAndSet()", false, localTestBoolean.compareAndSet(true, nextRandom));
		assertEquals("19 : compareAndSet()", true, localTestBoolean.compareAndSet(false, nextRandom));
		
		assertEquals("20 : weakCompareAndSet()", true, localTestBoolean.weakCompareAndSet(nextRandom, true));
		assertEquals("21 : weakCompareAndSet()", false, localTestBoolean.weakCompareAndSet(false, true));
		assertEquals("22 : weakCompareAndSet()", true, localTestBoolean.weakCompareAndSet(true, true));
		assertEquals("23 : weakCompareAndSet()", true, localTestBoolean.weakCompareAndSet(true, false));
		assertEquals("24 : weakCompareAndSet()", false, localTestBoolean.weakCompareAndSet(true, nextRandom));
		assertEquals("25 : weakCompareAndSet()", true, localTestBoolean.weakCompareAndSet(false, nextRandom));
	}
	
	/**
	 * Makes use of sharedTestBoolean to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicBoolean. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.toString();
		sharedTestBoolean.toString();
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.toString();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.toString();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.compareAndSet(true, rng.nextBoolean());
		sharedTestBoolean.set(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.get();
		sharedTestBoolean.getAndSet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.get();
		sharedTestBoolean.weakCompareAndSet(false, rng.nextBoolean());
		sharedTestBoolean.toString();
		sharedTestBoolean.lazySet(rng.nextBoolean());
		sharedTestBoolean.lazySet(rng.nextBoolean());
	}
}
