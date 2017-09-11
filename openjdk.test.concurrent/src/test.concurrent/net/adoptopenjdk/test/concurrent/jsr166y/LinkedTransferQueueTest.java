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
 * File:    LinkedTransferQueueTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent.jsr166y;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * LinkedTransferQueueTest
 * =======================
 * 
 * Attempts to verify the correct function of the LinkedTransferQueue class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of LinkedTransferQueue
 * 						-	API calls checked with assertions where possible
 * 						-   exercise the API using multiple threads and checking for correct concurrent behaviour
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared i.e. class instance of LinkedTransferQueue
 * 							NOTE : This shared instance is separate to the instance used in testAPI()
 * 						-	API calls are not checked
 * 						-   Aims to test multiple threads accessing the same instance of the class under test
 * 						-	Attempting to provoke a JIT response through repeated calls of the various API calls
 * 
 * This testcase makes use of class variables i.e. variables declared as 'static'. Usually this is a definite no-no
 * when it comes to tests run under a multithreaded stress testing engine. However, testing of many of the classes
 * in the java.util.concurrent package necessarily involves multiple threads accessing and modifying the same single data source.
 * This testcase was therefore designed to be run multiple times concurrently in such a way that threads do not interfere with
 * each other and cause incorrect results.
 *  
 * This test was written to test JSR166y. 
 */

public class LinkedTransferQueueTest extends ConcurrentTest 
{
	private static LinkedTransferQueue<GenericTestObject> stressQueue = new LinkedTransferQueue<GenericTestObject>();
	
	public void testAPI()
	{
		// Create some test data
		ArrayList<GenericTestObject> testCollection = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 10; i++)
		{
			testCollection.add(makeNewTestObject());
		}
		
		GenericTestObject testObject1 = new GenericTestObject("testObject1", 1, 1, 1, true);
		GenericTestObject testObject2 = new GenericTestObject("testObject2", 2, 2, 2, false);
		GenericTestObject testObject3 = new GenericTestObject("testObject3", 3, 3, 3, true);
		
		// Constructors and initial state
		LinkedTransferQueue<GenericTestObject> localQueue = new LinkedTransferQueue<GenericTestObject>();
		
		assertEquals("1 : size()", 0, localQueue.size());
		assertEquals("2 : peek()", null, localQueue.peek());
		assertEquals("3 : contains()", false, localQueue.contains(null));
		assertEquals("4 : contains()", false, localQueue.contains(testObject1));
		assertEquals("5 : getWaitingConsumerCount()", 0, localQueue.getWaitingConsumerCount());
		assertEquals("6 : hasWaitingConsumer()", false, localQueue.hasWaitingConsumer());
		assertEquals("7 : isEmpty()", true, localQueue.isEmpty());
		assertEquals("8 : poll()", null, localQueue.poll());
		assertEquals("9 : remainingCapacity()", Integer.MAX_VALUE, localQueue.remainingCapacity());
		assertEquals("10 : remove()", false, localQueue.remove(null));
		assertEquals("11 : remove()", false, localQueue.remove(testObject1));
		
		localQueue = new LinkedTransferQueue<GenericTestObject>(testCollection);
		
		assertEquals("12 : size()", testCollection.size(), localQueue.size());
		assertEquals("13 : size()", localQueue.size(), localQueue.size());
		assertEquals("14 : peek()", testCollection.get(0), localQueue.peek());
		assertEquals("15 : contains()", false, localQueue.contains(null));
		assertEquals("16 : contains()", false, localQueue.contains(testObject1));
		assertEquals("17 : contains()", true, localQueue.contains(testCollection.get(2)));
		assertEquals("18 : getWaitingConsumerCount()", 0, localQueue.getWaitingConsumerCount());
		assertEquals("19 : hasWaitingConsumer()", false, localQueue.hasWaitingConsumer());
		assertEquals("20 : isEmpty()", false, localQueue.isEmpty());
		assertEquals("21 : poll()", testCollection.get(0), localQueue.poll());
		assertEquals("22 : remainingCapacity()", Integer.MAX_VALUE, localQueue.remainingCapacity());
		assertEquals("23 : remove()", false, localQueue.remove(null));
		assertEquals("24 : remove()", false, localQueue.remove(testObject1));
		assertEquals("25 : remove()", true, localQueue.remove(testCollection.get(4)));
		
		while(!localQueue.isEmpty())
		{
			assertEquals("26 : peek()/poll()", localQueue.peek(), localQueue.poll());
		}
	
		assertEquals("27 : isEmpty()", true, localQueue.isEmpty());
		assertEquals("28 : size()", 0, localQueue.size());
		
		// Contents, insertions and deletions on a single thread with no consumers
		localQueue.addAll(testCollection);
	
		assertEquals("29 : contains()", false, localQueue.contains(testObject1));
		assertEquals("30 : add()", true, localQueue.add(testObject1));
		assertEquals("31 : contains()", true, localQueue.contains(testObject1));
		assertEquals("32 : add()", true, localQueue.add(testObject1));
		assertEquals("33 : contains()", true, localQueue.contains(testObject1));
		assertEquals("34 : remove()", true, localQueue.remove(testObject1));
		assertEquals("35 : remove()", true, localQueue.remove(testObject1));
		assertEquals("36 : remove()", false, localQueue.remove(testObject1));
		assertEquals("37 : remove()", false, localQueue.remove(testObject2));
		assertEquals("38 : offer()", true, localQueue.offer(testObject3));
		assertEquals("39 : contains()", true, localQueue.contains(testObject3));
		assertEquals("40 : remove()", true, localQueue.remove(testObject3));
		assertEquals("41 : removeAll()", true, localQueue.removeAll(testCollection));
		assertEquals("42 : removeAll()", false, localQueue.removeAll(testCollection));
	
		// Queue is empty again

		// Now introduce some other threads that will add or remove elements to the queue under test 
		LinkedTransferQueueTestHelper testHelper = new LinkedTransferQueueTestHelper(localQueue, false, true, false);
		Thread helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1a");
		
		// This first thread is a producer and so a new element should appear on the queue shortly after the thread is started
		assertEquals("43 : size()", 0, localQueue.size());
		
		helperThread.start();
		while(helperThread.isAlive())		// Wait for the thread to complete
		{
			sleep(1000);
		}
		
		GenericTestObject addedTestObject = testHelper.getChangedObject();
		
		assertEquals("44 : size()", 1, localQueue.size());
		assertEquals("45 : peek()", addedTestObject, localQueue.peek());
		
		// Repeat but this time make the spawned thread be a consumer
		testHelper = new LinkedTransferQueueTestHelper(localQueue, true, false, false);
		helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1b");
		
		// Given that the queue is not empty, the consumer thread should be able to consume an element right away
		helperThread.start();
		while(helperThread.isAlive())	// Again, let the thread complete
		{
			sleep(1000);
		}
	
		// At this point the queue should be empty again
		assertEquals("46 : size()", 0, localQueue.size());
		assertEquals("47 : take()", addedTestObject, testHelper.changedObject);
	
		// Make another consumer. This one can't consume anything as the queue is empty and will therefore block until interrupted or an element becomes available to consume
		testHelper = new LinkedTransferQueueTestHelper(localQueue, true, false, false);
		helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1c");
		
		helperThread.start();
		
		while(!localQueue.hasWaitingConsumer())		// allow the spawned thread time to block 
		{
			sleep(1000);
		}
		
		assertEquals("48 : size()", 0, localQueue.size());
		assertEquals("49 : getWaitingConsumerCount()", 1, localQueue.getWaitingConsumerCount());
		
		localQueue.add(testObject1);		// Add an element to the queue
		
		while(helperThread.isAlive())		// Wait for the spawned thread to complete
		{
			sleep(1000);
		}
		
		assertEquals("50 : size()", 0, localQueue.size());
		assertEquals("51 : getWaitingConsumerCount()", 0, localQueue.getWaitingConsumerCount());
		assertEquals("52 : hasWaitingConsumer()", false, localQueue.hasWaitingConsumer());
		assertEquals("53 : take()", testObject1, testHelper.getChangedObject());		// The consumed object is the one that was added
		
		// Same again but this time the consumer will be interrupted instead of completing normally
		testHelper = new LinkedTransferQueueTestHelper(localQueue, true, false, true);
		helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1d");
		
		helperThread.start();	// Consumer thread started but will block as there is nothing to be consumed
		
		while(!localQueue.hasWaitingConsumer())
		{
			sleep(1000);
		}
		
		while(localQueue.getWaitingConsumerCount() != 0 || helperThread.isAlive())	// The interrupt sometimes falls through a timing hole and isn't detected. Therefore we do this in a loop until the desired effect is acheived
		{
			helperThread.interrupt();		// Interrupt the consumer thread
			try
			{
				helperThread.join(5000);	// join() on the thread to ensure that it now ends and doesn't hang around forever waiting for an object to consume. Timeout incase the helper thread doesn't respond.
			}
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
				
		assertEquals("54 : getWaitingConsumerCount()", 0, localQueue.getWaitingConsumerCount());
		assertEquals("55 : take()", false, helperThread.isAlive());	
		
		// Similar to above but this time rather than have the current thread call add() on the queue it will make use of tryTransfer()
		testHelper = new LinkedTransferQueueTestHelper(localQueue, true, false, false);
		helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1e");
		
		// Don't start the helper thread just yet to allow for tryTransfer to be checked when there is no consumer waiting
		assertEquals("56 : size()", 0, localQueue.size());
		assertEquals("57 : hasWaitingConsumer()", false, localQueue.hasWaitingConsumer());
		assertEquals("58 : tryTransfer()", false, localQueue.tryTransfer(testObject1));
		try
		{
			assertEquals("59 : tryTransfer()", false, localQueue.tryTransfer(testObject2, 1000, TimeUnit.MILLISECONDS));
		}
		catch (InterruptedException e) 
		{
			// not particularly interested in this
		}
		
		// Now start the helper thread and wait for it to become blocking on an element becoming available
		helperThread.start();
		
		while(!localQueue.hasWaitingConsumer())
		{
			sleep(1000);
		}
		
		// Now try the transfer again
		assertEquals("60 : tryTransfer()", true, localQueue.tryTransfer(testObject1));
		assertEquals("61 : tryTransfer()", false, localQueue.tryTransfer(testObject2));
		
		while(helperThread.isAlive())
		{
			sleep(1000);
		}
		
		assertEquals("62 : take()", testObject1, testHelper.getChangedObject());
		
		// And one last time with transfer() rather than tryTransfer()
		testHelper = new LinkedTransferQueueTestHelper(localQueue, true, false, false);
		helperThread = new Thread(testHelper, "LinkedTransferQueueTestHelper-1e");
		
		// Don't start the helper thread just yet to allow for tryTransfer to be checked when there is no consumer waiting
		assertEquals("63 : size()", 0, localQueue.size());
		assertEquals("64 : hasWaitingConsumer()", false, localQueue.hasWaitingConsumer());
		
		// Now start the helper thread and wait for it to become blocking on an element becoming available
		helperThread.start();
		
		while(!localQueue.hasWaitingConsumer())
		{
			sleep(1000);
		}
		
		// Now transfer()
		try 
		{
			localQueue.transfer(testObject3);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		while(helperThread.isAlive())
		{
			sleep(1000);
		}
		
		assertEquals("65 : take()", testObject3, testHelper.getChangedObject());
	}

	public void testStress()
	{
		// To effectively test, setup producer and consumer threads for the stress test. There will be at most 2 additional active threads per invocation of testStress()		
		Thread helperThreadProducer = null;
		Thread helperThreadConsumer = null;
		
		// Create some test data to work with
		ArrayList<GenericTestObject> testCollection = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 3; i++)
		{
			testCollection.add(makeNewTestObject());
		}
		
		GenericTestObject testObject1 = new GenericTestObject("stressTestObject1", 1, 1, 1, true);
		GenericTestObject testObject2 = new GenericTestObject("stressTestObject2", 2, 2, 2, false);
		
		// The below block of code is a randomly generate selection of ~200 API calls to attempt to stress access to a single instance of LinkedTransferQueue under test
		// Once the API calls have been called often enough, this should also cause a JIT response
		// If any of the calls fail due to an InterruptedException, this will be reported as a failure
		try 
		{
			stressQueue.hasWaitingConsumer();
			stressQueue.contains(null);
			stressQueue.remainingCapacity();
			stressQueue.peek();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.remove(testObject1);
			stressQueue.remainingCapacity();
			stressQueue.contains(null);
			stressQueue.poll();
			stressQueue.getWaitingConsumerCount();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.contains(makeNewTestObject());
			Iterator<GenericTestObject> itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.remove(testObject1);
			stressQueue.remainingCapacity();
			stressQueue.remainingCapacity();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.contains(null);
			stressQueue.remainingCapacity();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.poll();
			stressQueue.remove(testObject1);
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.peek();
			stressQueue.offer(testObject1);
			stressQueue.offer(testObject1);
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			stressQueue.isEmpty();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.offer(testObject1);
			stressQueue.contains(makeNewTestObject());
			stressQueue.getWaitingConsumerCount();
			stressQueue.contains(makeNewTestObject());
			stressQueue.remainingCapacity();
			stressQueue.isEmpty();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.peek();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.getWaitingConsumerCount();
			stressQueue.contains(makeNewTestObject());
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.offer(testObject1);
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.poll();
			stressQueue.remainingCapacity();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.contains(null);
			stressQueue.offer(testObject1);
			stressQueue.remove(testObject1);
			stressQueue.contains(makeNewTestObject());
			stressQueue.poll();
			stressQueue.contains(makeNewTestObject());
			stressQueue.getWaitingConsumerCount();
			stressQueue.poll();
			stressQueue.remove(testObject1);
			stressQueue.poll();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			stressQueue.isEmpty();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			stressQueue.offer(testObject1);
			stressQueue.remainingCapacity();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.isEmpty();
			stressQueue.poll();
			stressQueue.contains(null);
			stressQueue.isEmpty();
			stressQueue.isEmpty();
			stressQueue.poll();
			stressQueue.remove(testObject1);
			stressQueue.remainingCapacity();
			stressQueue.hasWaitingConsumer();
			stressQueue.remainingCapacity();
			stressQueue.hasWaitingConsumer();
			stressQueue.peek();
			stressQueue.remove(testObject1);
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.poll();
			stressQueue.hasWaitingConsumer();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.hasWaitingConsumer();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.getWaitingConsumerCount();
			stressQueue.isEmpty();
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			stressQueue.poll();
			stressQueue.contains(null);
			stressQueue.getWaitingConsumerCount();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.peek();
			stressQueue.remainingCapacity();
			stressQueue.poll();
			stressQueue.isEmpty();
			stressQueue.hasWaitingConsumer();
			stressQueue.hasWaitingConsumer();
			stressQueue.contains(makeNewTestObject());
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			stressQueue.remove(testObject1);
			stressQueue.peek();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			stressQueue.peek();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.offer(testObject1);
			stressQueue.offer(testObject1);
			stressQueue.offer(testObject1);
			stressQueue.contains(makeNewTestObject());
			stressQueue.remainingCapacity();
			stressQueue.getWaitingConsumerCount();
			stressQueue.contains(makeNewTestObject());
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.poll();
			stressQueue.getWaitingConsumerCount();
			stressQueue.poll();
			stressQueue.remove(testObject1);
			stressQueue.isEmpty();
			stressQueue.peek();
			stressQueue.poll();
			stressQueue.remove(testObject1);
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.contains(null);
			stressQueue.contains(makeNewTestObject());
			stressQueue.peek();
			stressQueue.contains(null);
			stressQueue.contains(null);
			stressQueue.hasWaitingConsumer();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.hasWaitingConsumer();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.contains(null);
			stressQueue.remove(testObject1);
			stressQueue.remove(testObject1);
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.offer(testObject1);
			stressQueue.remainingCapacity();
			stressQueue.offer(testObject1);
			stressQueue.offer(testObject1);
			stressQueue.contains(makeNewTestObject());
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			stressQueue.contains(null);
			stressQueue.peek();
			stressQueue.isEmpty();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.peek();
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.addAll(testCollection);
			helperThreadConsumer.join();
			stressQueue.contains(null);
			stressQueue.contains(null);
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.contains(makeNewTestObject());
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			stressQueue.offer(testObject1);
			stressQueue.peek();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.peek();
			stressQueue.contains(null);
			stressQueue.offer(testObject1);
			stressQueue.remainingCapacity();
			stressQueue.remainingCapacity();
			stressQueue.contains(makeNewTestObject());
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			stressQueue.remove(testObject1);
			stressQueue.remove(testObject1);
			stressQueue.getWaitingConsumerCount();
			stressQueue.isEmpty();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.add(testObject1);
			helperThreadConsumer.join();
			helperThreadConsumer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, true, false, false), "StressTestHelper-Consumer");
			helperThreadConsumer.start();
			stressQueue.put(testObject2);
			helperThreadConsumer.join();
			stressQueue.remainingCapacity();
			stressQueue.contains(makeNewTestObject());
			stressQueue.hasWaitingConsumer();
			helperThreadProducer = new Thread(new LinkedTransferQueueTestHelper(stressQueue, false, true, false), "StressTestHelper-Producer");
			helperThreadProducer.start();
			stressQueue.take();
			helperThreadProducer.join();
			stressQueue.remainingCapacity();
			stressQueue.remove(testObject1);
			stressQueue.remainingCapacity();
			itr = stressQueue.iterator();
			while(itr.hasNext())
			{
			  stressQueue.contains(itr.next());
			}
			stressQueue.contains(makeNewTestObject());
			stressQueue.hasWaitingConsumer();
			stressQueue.hasWaitingConsumer();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			fail("Unexpected interrupt occurred");
		}
		
		// Prevent the queue from becoming too large and consuming all of the available heap
		while(stressQueue.size() > 100)
		{
			stressQueue.poll();
		}
	}
	
	private class LinkedTransferQueueTestHelper implements Runnable
	{
		private LinkedTransferQueue<GenericTestObject> queue = null;
		private GenericTestObject changedObject = null;
		private boolean wasInterrupted = false;
		
		private boolean isConsumer = false;
		private boolean isProducer = false;
		private boolean expectInterrupt = false;
				
		public LinkedTransferQueueTestHelper(LinkedTransferQueue<GenericTestObject> queueIn, boolean isConsumerIn, boolean isProducerIn, boolean expectInterruptIn)
		{
			queue = queueIn;
			isConsumer = isConsumerIn;
			isProducer = isProducerIn;
			expectInterrupt = expectInterruptIn;
		}
		
		private void doNothing()
		{
			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				// we don't really care if this happens
			}
		}
		
		public GenericTestObject getChangedObject()
		{
			return changedObject;
		}
		
		@SuppressWarnings("unused")
		public synchronized boolean wasInterrupted()
		{
			return wasInterrupted;
		}
		
		public void run()
		{
			if(isProducer)
			{
				doNothing();
				changedObject = makeNewTestObject();
				queue.put(changedObject);
			}
			else if(isConsumer)
			{
				try 
				{
					changedObject = queue.take();
				}
				catch (InterruptedException e) 
				{
					synchronized(this)
					{
						wasInterrupted = true;
					}
					
					if(!expectInterrupt)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}
