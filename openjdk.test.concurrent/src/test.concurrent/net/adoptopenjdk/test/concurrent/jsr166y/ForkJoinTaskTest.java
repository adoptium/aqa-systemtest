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
 * File:    ForkJoinTaskTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent.jsr166y;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArrayDoubler;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArraySummationTask;
import net.adoptopenjdk.test.concurrent.support.jsr166y.WaiterTask;

/**
 * ForkJoinTaskTest
 * ======================
 * 
 * Attempts to verify the correct function of the ForkJoinTask class in a simple test scenario. 
 *
 * 		testAPI()		-	call as many of the API functions as possible using instances of objects based on ForkJoinTask
 * 						-	API calls checked with assertions where possible
 * 						-   exercise the API using multiple threads and checking for correct concurrent behaviour
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	none included as it is difficult to know what a stress test of this API should do.
 * 							e.g. stress a single task and call methods on it from multiple threads - the state of the task under test would quickly become inconsistent
 * 							or	 stress tasks in a thread pool with multiple threads - this is already done in ForkJoinPoolTest
 *
 * This test was written to test JSR166y. 
 */

public class ForkJoinTaskTest extends ConcurrentTest
{
	/*
	 * When creating an instance of ForkJoinPool the API creates worker threads for the pool and runs these as daemon threads.
	 * When a ForkJoinPool is shutdown, these threads do not automatically clean up - they remain until the VM shuts down. The typical
	 * usage scenario for ForkJoinPool as described in the API doc is that a single pool is created for the lifetime of the VM and that
	 * the same pool is reused again and again.
	 * 
	 * In the load tests as they were originally written, an instance of ForkJoinPool was created for each invocation of this testcase
	 * for use in the testAPI() method. This leads to a slow but definite leak of threads and hence a native OOM condition. To work around this,
	 * a single class instance is now instead used. Access to this instance is controlled by way of a ReentrantReadWriteLock effectively ensuring
	 * that only one instance of the test is making use of the apiPool at any given time. 
	 */
	
	private static ForkJoinPool apiPool = new ForkJoinPool(1);
	private static ReentrantReadWriteLock apiPoolLock = new ReentrantReadWriteLock();	
	
	public void tearDown()
	{
		try
		{
			apiPoolLock.writeLock().unlock();
		}
		catch(IllegalMonitorStateException imse)
		{
			// Doesn't matter - just means we didn't hold the lock and everything had probably worked as intended
		}
	}
		
	/**
	 * Verifies the correct function of the basic API of ForkJoinPool
	 */
	public void testAPI()
	{
		apiPoolLock.writeLock().lock();
		
		int[] array = new int[40];
		int[] comparisonArray = new int[40];
		int comparisonSum = 0;		
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = rng.nextInt(100);
			comparisonArray[i] = array[i];
			comparisonSum += array[i];
		}
		
		WaiterTask waiterTask = new WaiterTask();
		ArraySummationTask sumTask = new ArraySummationTask(array, 0, array.length);
				
	    // Start with a basic task
		ArrayDoubler doublerTask = new ArrayDoubler(array, 0, array.length);
		
		assertEquals("1 : getException()", null, doublerTask.getException());				// Task hasn't yet been run so these defaults should be true
		assertEquals("2 : getRawResult()", null, doublerTask.getRawResult());
		assertEquals("3 : getPool()", null, ArrayDoubler.getPool());
		assertEquals("4 : isCancelled()", false, doublerTask.isCancelled());
		assertEquals("5 : isCompletedAbnormally()", false, doublerTask.isCompletedAbnormally());
		assertEquals("6 : isCompletedNormally()", false, doublerTask.isCompletedNormally());
		assertEquals("7 : isDone()", false, doublerTask.isDone());
				
		apiPool.invoke(doublerTask);											// Submit the task into the pool for execution
		
		assertEquals("8 : invoke()", comparisonArray[0] * 2, array[0]);			// invoke blocks until the task completes so the result should be available right away
		assertEquals("9 : getException()", null, doublerTask.getException());	// These values are mostly the same as before as execution wasn't ended abnormally...
		assertEquals("10 : getRawResult()", null, doublerTask.getRawResult());
		assertEquals("11 : isCancelled()", false, doublerTask.isCancelled());
		assertEquals("12 : isCompletedAbnormally()", false, doublerTask.isCompletedAbnormally());
		assertEquals("13 : isCompletedNormally()", true, doublerTask.isCompletedNormally());		// ... but these values should be different as the task actually ran and completed
		assertEquals("14 : isDone()", true, doublerTask.isDone());
		
		array = comparisonArray;												// reset the work array back to a default state
		
		sumTask = new ArraySummationTask(array, 0, array.length);
		
		apiPool.submit(waiterTask);												// Block the queue with a WaiterTask - this task does nothing but sleep until cancelled
		apiPool.submit(sumTask);												// This task can't run because the pool has a capacity of one
		
		assertEquals("15 : isDone()", false, sumTask.isDone());								// sumTask should be blocked behind the waiterTask
		sumTask.complete(-2002);															// force the sumTask to complete with the given result
		assertEquals("16 : isDone()", true, sumTask.isDone());								// ... so the task is done ...
		assertEquals("17 : isCompletedNormally()", true, sumTask.isCompletedNormally());	// ... completed without error ...
		assertEquals("18 : isCompletedAbnormally()", false, sumTask.isCompletedAbnormally());
		assertEquals("19 : getRawResult()", new Integer(-2002), sumTask.getRawResult());	// ... and the result was the value we specified
		
		sumTask = new ArraySummationTask(array, 0, array.length);				// Make another sumTask
		apiPool.submit(sumTask);												// Submit it for execution - again it is blocked behind the waitTask
		
		waiterTask.unblock();													// Unblock the pool again
		
		while(!waiterTask.isDone())
		{
			sleep(1);
		}
		
		assertEquals("20 : isDone()", true, waiterTask.isDone());				// The waiterTask has given up the execution thread so the sumTask should be able to complete now
		
		while(!sumTask.isDone())
		{
			sleep(100);
		}
		
		assertEquals("21 : isCompletedNormally()", true, sumTask.isCompletedNormally());			// sumTask should have finished normally and produced a result.
		assertEquals("22 : getRawResult()", new Integer(comparisonSum), sumTask.getRawResult());

		array = comparisonArray;
		
		// Next, tasks that fork subtasks of their own
		// Again the pool has just one thread so one task will block all others
		
		ForkJoinTaskTester testTask1 = new ForkJoinTaskTester();
		ForkJoinTaskTester testTask2 = new ForkJoinTaskTester();
			
		apiPool.submit(testTask1);
		apiPool.submit(testTask2);
		
		testTask1.doFork();														// Have the executing task fork a subtask
		while(!testTask1.hasForked())
		{
			sleep(50);
		}
		
		assertEquals("23 : getMyQueuedTaskCount()", 1, testTask1.getMyQueuedTaskCount());				// Task 1 has spawned a subtask on a new thread and that thread is blocked as the pool cannot yet execute that subtask
		assertEquals("24 : getMyQueuedTaskCount()", 0, testTask2.getMyQueuedTaskCount());				// Task 2 hasn't spawned anything
		assertEquals("25 : getMySurplusQueuedTaskCount()", 1, testTask1.getMySurplusQueuedTaskCount());	// Task 1 has a spawned thread that cannot be run by the thread pool
		assertEquals("26 : getMySurplusQueuedTaskCount()", 0, testTask2.getMySurplusQueuedTaskCount());	// Task 2 hasn't spawned any threads so again this should be 0
		
		testTask1.doUnfork();	// Have Task 1 unfork itself again - i.e. remove itself from the queued threads to be executed
		
		while(!testTask1.hasUnforked())
		{
			sleep(1);
		}
		
		assertEquals("27 : getMyQueuedTaskCount()", 0, testTask1.getMyQueuedTaskCount());		
		assertEquals("28 : getMyQueuedTaskCount()", 0, testTask2.getMyQueuedTaskCount());		
		assertEquals("29 : getMySurplusQueuedTaskCount()", 0, testTask1.getMySurplusQueuedTaskCount());
		assertEquals("30 : getMySurplusQueuedTaskCount()", 0, testTask2.getMySurplusQueuedTaskCount());
		
		testTask1.stopRunning();
		testTask2.doFork();
		
		while(!testTask2.hasForked())
		{
			sleep(1);
		}
		
		assertEquals("31 : getMyQueuedTaskCount()", 1, testTask2.getMyQueuedTaskCount());		
		assertEquals("32 : getMySurplusQueuedTaskCount()", 1, testTask2.getMySurplusQueuedTaskCount());
		
		testTask2.stopRunning();
		try 
		{
			testTask2.get();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			fail("Unexpected interrupt while attempting to retreive result for testTask2");
		}
		catch (ExecutionException e) 
		{
			e.printStackTrace();
			fail("Unexpected ExecutionException while attempting to retreive result for testTask2");
		}
		
		assertEquals("33 : isCancelled()", false, testTask2.isCancelled());
		assertEquals("34 : isCompletedNormally()", true, testTask2.isCompletedNormally());
		assertEquals("35 : isDone()", true, testTask2.isDone());
		
		testTask1 = new ForkJoinTaskTester();
		testTask2 = new ForkJoinTaskTester();
		
		apiPool.submit(testTask1);
		apiPool.submit(testTask2);

		testTask1.cancel(true);
		
		assertEquals("36 : isCancelled()", true, testTask1.isCancelled());
		assertEquals("37 : isCompletedNormally()", false, testTask1.isCompletedNormally());
		assertEquals("38 : isCompletedAbnormally()", true, testTask1.isCompletedAbnormally());
		assertEquals("39 : isDone()", true, testTask1.isDone());
		
		testTask2.completeExceptionally(new ArithmeticException("Faked Exception"));
		
		assertEquals("40 : isCancelled()", false, testTask2.isCancelled());				// Execution wasn't cancelled - it was forcefully 'completed'
		assertEquals("41 : isCompletedNormally()", false, testTask2.isCompletedNormally());
		assertEquals("42 : isCompletedAbnormally()", true, testTask2.isCompletedAbnormally());
		assertEquals("43 : isDone()", true, testTask2.isDone());
		
		try
		{
			testTask2.join();
			fail("44 : Expected ArithmeticException was not thrown.");
		}
		catch(ArithmeticException ae)
		{
			// Expected
		}
		
		testTask1.stopRunning();
		testTask2.stopRunning();		
	}

	private class ForkJoinTaskTester extends RecursiveAction
	{
		private static final long serialVersionUID = -8981774879748077898L;
		
		private boolean keepRunning = true;
		private boolean shouldFork = false;
		private boolean shouldReset = false;
		private boolean shouldUnfork = false;
		
		private int queuedCount = 0;
		private int surplusCount = 0;
		
		private boolean wasInterrupted = false;
		
		public void doFork()
		{
			shouldFork = true;
		}
		
		@SuppressWarnings("unused")
		public void doReset()
		{
			shouldReset = true;
		}
		
		public void doUnfork()
		{
			shouldUnfork = true;
		}
		
		public boolean hasForked()
		{
			return !shouldFork;
		}
		
		public boolean hasUnforked()
		{
			return !shouldUnfork;
		}
		
		@SuppressWarnings("unused")
		public boolean hasReset()
		{
			return !shouldReset;
		}
		
		public synchronized int getMyQueuedTaskCount()
		{
			return queuedCount;
		}
		
		public synchronized int getMySurplusQueuedTaskCount()
		{
			return surplusCount;
		}
		
		public void stopRunning()
		{
			keepRunning = false;
		}
		
		@SuppressWarnings("unused")
		public boolean getWasInterrupted()
		{
			return wasInterrupted;
		}
		
		protected void compute() 
		{
			while(keepRunning && !wasInterrupted)
			{
				synchronized(this)
				{
					if(shouldFork)
					{
						shouldFork = false;
						this.fork();
					}
					if(shouldUnfork)
					{
						shouldUnfork = false;
						this.tryUnfork();
					}
					if(shouldReset)
					{
						shouldReset = false;
						this.reinitialize();
					}
				
					queuedCount = ForkJoinTask.getQueuedTaskCount();
					surplusCount = ForkJoinTask.getSurplusQueuedTaskCount();
				}
				
				try 
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e) 
				{
					wasInterrupted = true;
				}
			}
		}
		
	}
}
