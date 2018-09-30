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
 * File:    ArrayBlockingQueueTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * ArrayBlockingQueueTest
 * ======================
 * 
 * Attempts to verify the correct function of the ArrayBlockingQueueTest class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of ArrayBlockingQueueTest
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ArrayBlockingQueueTest
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

public class ArrayBlockingQueueTest extends ConcurrentTest
{
	// queue is not defined as static and is therefore not accessed concurrently by multiple threads
	// queue is used to verify correct behaviour of the API
	private ArrayBlockingQueue<GenericTestObject> queue = new ArrayBlockingQueue<GenericTestObject>(20);
	
	// stressqueue is defined as static and is accessed concurrently by multiple threads as part of the testStress() function
	private static ArrayBlockingQueue<GenericTestObject> stressqueue = new ArrayBlockingQueue<GenericTestObject>(200);
	
	/**
	 * Verify the correct behaviour of the API for ArrayBlockingQueue. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// =================================================================================
		// Create some test data to work with
		
		GenericTestObject testObject = new GenericTestObject("test", 41, 42, 43, true);
		ArrayList<GenericTestObject> testObjects = new ArrayList<GenericTestObject>();
		
		for(int i = 0; i < 19; i++)
		{
			testObjects.add(makeNewTestObject());
		}
		
		// =================================================================================
		// Basic API tests
		
		assertEquals("1 : size()", 0, queue.size());
		assertEquals("2 : remainingCapacity()", 20, queue.remainingCapacity());
		assertEquals("3 : isEmpty()", true, queue.isEmpty());
		assertEquals("4 : peek()", null, queue.peek());
		assertEquals("5 : pool()", null, queue.poll());
		assertEquals("6 : contains()", false, queue.contains(testObject));
		assertEquals("7 : containsAll()", false, queue.containsAll(testObjects));
		
		// =================================================================================
		// Simple Additions and Removals 
		
		assertEquals("8 : add()", true, queue.add(testObject));
		assertEquals("9 : add()", true, queue.add(testObject));
		assertEquals("10 : size()", 2, queue.size());
		assertEquals("11 : remainingCapacity()", 18, queue.remainingCapacity());
		assertEquals("12 : remove()", testObject, queue.remove());
		assertEquals("13 : remove()", true, queue.remove(testObject));
		
		assertEquals("14 : offer()", true, queue.offer(testObject));
		try
		{
			assertEquals("15 : offer()", true, queue.offer(testObject, MAXWAITTIME, TimeUnit.MILLISECONDS));
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		assertEquals("16 : peek()", testObject, queue.peek());
		assertEquals("17 : poll()", testObject, queue.poll());
		assertEquals("18 : remove()", testObject, queue.remove());
		
		// =================================================================================
		// More Advanced Additions and Removals 
		
		assertEquals("19 : size()", 0, queue.size());
		assertEquals("20 : remainingCapacity()", 20, queue.remainingCapacity());
		assertEquals("21 : isEmpty()", true, queue.isEmpty());
		
		assertEquals("22 : add()", true, queue.add(testObject));
		assertEquals("23 : addAll()", true, queue.addAll(testObjects));
		try
		{
			queue.addAll(testObjects);
			fail("24 : addAll() : should have thrown an IllegalStateException");
		}
		catch(IllegalStateException e)
		{
			// expected as the queue is now full
		}
		
		assertEquals("25 : size()", 20, queue.size());
		assertEquals("26 : remainingCapacity()", 0, queue.remainingCapacity());
		assertEquals("27 : isEmpty()", false, queue.isEmpty());
		
		try
		{
			queue.add(testObject);
			fail("28 : add() : should have thrown an IllegalStateException");
		}
		catch(IllegalStateException e)
		{
			// expected as the queue is still full
		}
		
		assertEquals("29 : offer()", false, queue.offer(testObject));
		try
		{
			assertEquals("30 : offer()", false, queue.offer(testObject, MAXWAITTIME, TimeUnit.MILLISECONDS));
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			assertEquals("31 : take()", testObject, queue.take());
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals("32 : removeAll()", true, queue.removeAll(testObjects));
		assertEquals("33 : size()", 0, queue.size());
		assertEquals("34 : remainingCapacity()", 20, queue.remainingCapacity());
		assertEquals("35 : isEmpty()", true, queue.isEmpty());
		
		// =================================================================================
		// Testing retainAll() and drainTo()
		
		assertEquals("36 : addAll()", true, queue.addAll(testObjects));
		assertEquals("37 : retainAll()", false, queue.retainAll(testObjects));
		assertEquals("38 : containsAll()", true, queue.containsAll(testObjects));
		assertEquals("39 : add()", true, queue.add(testObject));
		assertEquals("40 : retainAll()", true, queue.retainAll(testObjects));
		assertEquals("41 : contains()", false, queue.contains(testObject));
		assertEquals("42 : containsAll()", true, queue.containsAll(testObjects));
		assertEquals("43 : add()", true, queue.add(testObject));
		assertEquals("44 : remainingCapacity()", 0, queue.remainingCapacity());  // i.e. queue is now full
		
		try
		{
			queue.drainTo(queue);
			fail("45 : drainTo() : should have thrown IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected
		}
		
		ArrayBlockingQueue<GenericTestObject> sink = new ArrayBlockingQueue<GenericTestObject>(10);
		
		try
		{
			queue.drainTo(sink);
			fail("46 : drainTo() : draining to a queue with insufficient capacity should throw IllegalStateException (c.f. ArrayBlockingQueue.add(o)");
		}
		catch(IllegalStateException e)
		{
			// expected
		}
	
		// The drain will have aborted part way through but the below should be true
		assertEquals("47 : remainingCapacity()", 0, sink.remainingCapacity());
		
		// The queue is in an inconsistent state however and needs 'reseting'
		queue.clear();
		assertEquals("48 : remainingCapacity()", 20, queue.remainingCapacity());
		
		// Go around again with a sink of sufficient size
		sink = new ArrayBlockingQueue<GenericTestObject>(20);
		
		assertEquals("49 : addAll()", true, queue.addAll(testObjects));
		assertEquals("50 : add()", true, queue.add(testObject));
		assertEquals("51 : remainingCapacity()", 0, queue.remainingCapacity());
		assertEquals("52 : drainTo()", 20, queue.drainTo(sink));
		
		// And in reverse with partial drains
		assertEquals("53 : drainTo()", 6, sink.drainTo(queue, 6));
		assertEquals("54 : remainingCapacity()", 6, sink.remainingCapacity());
		assertEquals("55 : remainingCapacity()", 14, queue.remainingCapacity());
		assertEquals("56 : drainTo()", 2, queue.drainTo(sink, 2));
		assertEquals("57 : remainingCapacity()", 4, sink.remainingCapacity());
		assertEquals("58 : remainingCapacity()", 16, queue.remainingCapacity());
		assertEquals("59 : drainTo()", 16, sink.drainTo(queue));
		assertEquals("60 : remainingCapacity()", 20, sink.remainingCapacity());
		assertEquals("62 : remainingCapacity()", 0, queue.remainingCapacity());
		assertEquals("63 : containsAll()", true, queue.containsAll(testObjects));
		
		// =================================================================================
		// peek and poll
		
		// Get the queue back into a state where we can verify the contents that we are removing
		queue.clear();
		queue.add(testObject);
		queue.add(testObject);
		queue.add(testObject);
		queue.addAll(testObjects.subList(0, 10));
		
		assertEquals("64 : size()", 13, queue.size());
		
		try 
		{
			assertEquals("65 : take()", testObject, queue.take());
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals("66 : size()", 12, queue.size());
		assertEquals("67 : poll()", testObject, queue.poll());
		assertEquals("68 : size()", 11, queue.size());
		assertEquals("69 : peek()", testObject, queue.peek());
		assertEquals("70 : size()", 11, queue.size());
		assertEquals("71 : element()", testObject, queue.element());
		assertEquals("72 : size()", 11, queue.size());
		
		try 
		{
			assertEquals("73 : poll()", testObject, queue.poll(MAXWAITTIME, TimeUnit.MILLISECONDS));
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		assertEquals("74 : size()", 10, queue.size());
		assertEquals("75 : contains()", false, queue.contains(testObject));		
		
		// Cleanup
		queue.clear();
		testObjects.clear();
		sink.clear();	
	}
	
	/**
	 * Makes use of stressqueue to test multiple threads concurrent accessing and updating a single shared
	 * instance of ArrayBlockingQueue. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 * 
	 * Note : Some of the API methods are problematic in a multi-threaded environment especially when they are being
	 * called in a random fashion. For this reason drainTo(), put() and take() are not called.
	 */
	public void testStress()
	{
		// Some data for use below
		GenericTestObject testObject1 = new GenericTestObject("testObject1", 1, 1, 1, true);
		GenericTestObject testObject2 = new GenericTestObject("testObject2", 2, 2, 2, false);
		GenericTestObject testObject3 = new GenericTestObject("testObject3", 3, 3, 3, false);
		
		ArrayList<GenericTestObject> stressTestObjects = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 20; i++)
		{
			stressTestObjects.add(makeNewTestObject("stressObject" + i));
		}
		
		ArrayBlockingQueue<GenericTestObject> sink = new ArrayBlockingQueue<GenericTestObject>(40);
		ArrayBlockingQueue<GenericTestObject> smallSink = new ArrayBlockingQueue<GenericTestObject>(20);
				
		// =================================================================================
		// Testing starts here
		
		try
		{
			stressqueue.addAll(stressTestObjects);
			
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.poll();
			stressqueue.toString();
			stressqueue.add(testObject2);
			stressqueue.remove(testObject1);
			stressqueue.poll();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.containsAll(stressTestObjects);
			stressqueue.addAll(stressTestObjects);
			stressqueue.contains(testObject3);
			stressqueue.poll(MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.toArray();
			stressqueue.toString();
			stressqueue.poll();
			stressqueue.removeAll(sink); 
			stressqueue.removeAll(smallSink);
			stressqueue.addAll(stressTestObjects);
			stressqueue.remove();
			stressqueue.remove(testObject1);
			stressqueue.containsAll(stressTestObjects);
			stressqueue.remove(testObject3);
			stressqueue.contains(testObject2);
			stressqueue.containsAll(stressTestObjects);
			stressqueue.toString();
			stressqueue.peek();
			stressqueue.peek();
			Iterator<GenericTestObject> itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				sink.contains(itr.next());
			}
			stressqueue.peek();
			stressqueue.remove(testObject1);
			stressqueue.poll(MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.contains(testObject2);
			stressqueue.remove(testObject3);
			stressqueue.retainAll(smallSink);
			stressqueue.contains(testObject2);
			stressqueue.addAll(stressTestObjects);
			stressqueue.retainAll(smallSink);
			stressqueue.poll(MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.poll();
			stressqueue.contains(testObject2);
			stressqueue.poll(MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.contains(testObject2);
			stressqueue.clear();
			stressqueue.offer(testObject2, MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.remove(testObject3);
			stressqueue.peek();
			stressqueue.toArray();
			stressqueue.element();
			stressqueue.offer(testObject2, MAXWAITTIME, TimeUnit.MILLISECONDS);
			stressqueue.containsAll(stressTestObjects);
			stressqueue.contains(testObject2);
			stressqueue.add(testObject1);
			stressqueue.element();
			stressqueue.offer(testObject1);
			stressqueue.addAll(stressTestObjects);
			stressqueue.toArray(new GenericTestObject[40]);
			stressqueue.remove(testObject1);
			stressqueue.contains(testObject2);
			stressqueue.remove();
			stressqueue.retainAll(smallSink);
			stressqueue.addAll(stressTestObjects);
			stressqueue.add(testObject2);
			stressqueue.add(testObject2);
			stressqueue.offer(testObject1);
			stressqueue.isEmpty();
			stressqueue.poll();
			stressqueue.add(testObject1);
			stressqueue.peek();
			stressqueue.contains(testObject2);
			stressqueue.remove(testObject3);
			stressqueue.add(testObject2);
			stressqueue.removeAll(sink); 
			stressqueue.removeAll(smallSink);
			stressqueue.toArray();
			stressqueue.element();
			stressqueue.offer(testObject1);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				sink.contains(itr.next());
			}
			stressqueue.retainAll(smallSink);
			stressqueue.remove(testObject1);
			stressqueue.retainAll(smallSink);
			stressqueue.offer(testObject1);
			stressqueue.toString();
			stressqueue.remainingCapacity();
			stressqueue.containsAll(stressTestObjects);
			stressqueue.toArray();
			stressqueue.remove(testObject3);
			stressqueue.remove();
			stressqueue.remainingCapacity();
			stressqueue.toString();
			stressqueue.clear();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.addAll(stressTestObjects);
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.remove(testObject1);
			stressqueue.contains(testObject3);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				sink.contains(itr.next());
			}
			stressqueue.remove();
			stressqueue.add(testObject1);
			stressqueue.element();
			stressqueue.toArray(new GenericTestObject[40]);
			stressqueue.toArray(new GenericTestObject[40]);
			stressqueue.element();
			stressqueue.size();
		}
		catch(IllegalStateException e)
		{
			// Can be thrown by add() and remove() if the queue is full/empty respectively
		} catch (InterruptedException e) 
		{
			// poll() and offer() may be interrupted
		} catch (NoSuchElementException e)
		{
			// can happen if we try to remove an element that doesn't exist
		}
	}
}
