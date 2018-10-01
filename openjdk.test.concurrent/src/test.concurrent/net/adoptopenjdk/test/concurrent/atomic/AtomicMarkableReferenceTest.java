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
 * File:    AtomicMarkableReferenceTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.AtomicTestObject;

/**
 * AtomicMarkableReferenceTest
 * ===========================
 * 
 * Attempts to verify the correct function of the AtomicMarkableReference class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of AtomicMarkableReference
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of AtomicMarkableReference
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

public class AtomicMarkableReferenceTest extends ConcurrentTest 
{
	
	// Variables specific to this instance of the test i.e. isolated from other tests running in parallel
	private AtomicTestObject testObject1 = new AtomicTestObject();
	private AtomicTestObject testObject2 = new AtomicTestObject();
	private AtomicMarkableReference<AtomicTestObject> testReference = new AtomicMarkableReference<AtomicTestObject>(testObject1, false);
	
	// Variables shared across all instances of the test running in parallel 
	private static AtomicTestObject stressObject = new AtomicTestObject();
	private static AtomicMarkableReference<AtomicTestObject> stressReference = new AtomicMarkableReference<AtomicTestObject>(stressObject, false);
	
	/**
	 * Basic tests of the API : Simple function calls to exercise all of the functions listed in the API
	 * specification for the AtomicMarkableReference class.
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
		assertEquals("5 : compareAndSet()",  true,  testReference.compareAndSet(testObject1, testObject2, false, true));
		assertEquals("6 : compareAndSet()",  false, testReference.compareAndSet(testObject1, testObject2, true, false));
		assertEquals("7 : compareAndSet()",  false, testReference.compareAndSet(testObject2, testObject1, false, true));
		assertEquals("8 : compareAndSet()",  false, testReference.compareAndSet(testObject1, testObject2, false, true));
				
		assertEquals("9 : compareAndSet()",  true,  testReference.compareAndSet(testObject2, testObject1, true, false));
		assertEquals("10 : compareAndSet()", true,  testReference.compareAndSet(testObject1, testObject1, false, false));
		assertEquals("11 : compareAndSet()", true,  testReference.compareAndSet(testObject1, testObject2, false, false));
		assertEquals("12 : compareAndSet()", true,  testReference.compareAndSet(testObject2, testObject1, false, true));		
		
		assertEquals("13 : isMarked()", true, testReference.isMarked());
		assertEquals("14 : attemptMark()", false, testReference.attemptMark(testObject2, false));		
		assertEquals("15 : isMarked()", true, testReference.isMarked());
		assertEquals("16 : attemptMark()", true, testReference.attemptMark(testObject1, false));		
		assertEquals("17 : isMarked()", false, testReference.isMarked());
		
		boolean[] marks = new boolean[1];
		AtomicTestObject reference = testReference.get(marks);
		assertEquals("18 : get()", false, marks[0]);
		assertEquals("19 : get()", testObject1, reference);
		testReference.set(testObject2, true);
		reference = testReference.get(marks);
		assertEquals("20 : get()", true, marks[0]);
		assertEquals("21 : get()", testObject2, reference);	
	}
	
	/**
	 * Makes use of stressReference to test multiple threads concurrent accessing and updating a single shared
	 * instance of AtomicMarkableReference. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.attemptMark(null, true);
		stressReference.attemptMark(null, true);
		stressReference.isMarked();
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.attemptMark(null, true);
		stressReference.isMarked();
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(testObject2, true);
		stressReference.isMarked();
		stressReference.isMarked();
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(null, false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(null, false);
		stressReference.isMarked();
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.get(new boolean[5]);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.isMarked();
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.get(new boolean[5]);
		stressReference.isMarked();
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.attemptMark(null, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[5]);
		stressReference.get(new boolean[5]);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.attemptMark(null, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.set(null, false);
		stressReference.get(new boolean[1]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(testObject2, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.set(testObject2, true);
		stressReference.set(testObject2, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.set(null, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[1]);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(null, true);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.get(new boolean[1]);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(new AtomicTestObject(), false);
		stressReference.isMarked();
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.get(new boolean[5]);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.isMarked();
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[1]);
		stressReference.attemptMark(null, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.set(null, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.get(new boolean[1]);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.isMarked();
		stressReference.get(new boolean[5]);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.set(null, true);
		stressReference.set(null, false);
		stressReference.attemptMark(null, true);
		stressReference.set(null, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(null, true);
		stressReference.set(null, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.isMarked();
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(testObject2, true);
		stressReference.set(null, false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.isMarked();
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.get(new boolean[1]);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(null, false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.attemptMark(null, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.get(new boolean[5]);
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.attemptMark(null, true);
		stressReference.get(new boolean[5]);
		stressReference.get(new boolean[1]);
		stressReference.get(new boolean[5]);
		stressReference.set(null, false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.attemptMark(null, true);
		stressReference.get(new boolean[5]);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(null, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(null, true);
		stressReference.isMarked();
		stressReference.set(null, true);
		stressReference.set(null, true);
		stressReference.set(null, true);
		stressReference.set(null, false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.attemptMark(null, true);
		stressReference.isMarked();
		stressReference.set(null, false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.set(null, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.set(testObject2, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.attemptMark(null, true);
		stressReference.set(null, true);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.get(new boolean[1]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.isMarked();
		stressReference.set(null, false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.get(new boolean[5]);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(testObject2, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.get(new boolean[5]);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(null, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.attemptMark(null, true);
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.set(null, true);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.set(testObject2, true);
		stressReference.attemptMark(null, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.set(testObject2, true);
		stressReference.set(null, false);
		stressReference.get(new boolean[1]);
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.isMarked();
		stressReference.get(new boolean[1]);
		stressReference.set(testObject2, true);
		stressReference.set(testObject2, true);
		stressReference.isMarked();
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(testObject2, true);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.isMarked();
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[5]);
		stressReference.set(null, true);
		stressReference.set(testObject2, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(testObject2, true);
		stressReference.get(new boolean[1]);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.set(testObject2, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.attemptMark(null, true);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(null, true);
		stressReference.get(new boolean[5]);
		stressReference.set(null, false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.isMarked();
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(testObject1, null, stressReference.isMarked(), true);
		stressReference.set(null, false);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.isMarked();
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.set(null, false);
		stressReference.set(null, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.get(new boolean[5]);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.isMarked();
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.weakCompareAndSet(testObject1, testObject2, false, true);
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.attemptMark(stressReference.get(new boolean[1]), !stressReference.isMarked());
		stressReference.compareAndSet(null, new AtomicTestObject(), false, true);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.weakCompareAndSet(null, null, true, true);
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.set(new AtomicTestObject(), false);
		stressReference.set(testObject2, true);
		stressReference.weakCompareAndSet(stressReference.getReference(), null, stressReference.isMarked(), false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
		stressReference.compareAndSet(testObject1, null, true, true);
		stressReference.compareAndSet(null, testObject1, stressReference.isMarked(), false);
		stressReference.compareAndSet(stressReference.getReference(), testObject2, false, false);
	}
}
