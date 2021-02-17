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
 * File:    ForkJoinPoolTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent.jsr166y;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArrayMaximumTask;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArraySummationTask;
import net.adoptopenjdk.test.concurrent.support.jsr166y.WaiterTask;

/**
 * ForkJoinPoolTest
 * ================
 * 
 * Attempts to verify the correct function of the ForkJoinPool class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of ForkJoinPool
 * 						-	API calls checked with assertions where possible
 * 						-   exercise the API using multiple threads and checking for correct concurrent behaviour
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	differs from the testStress() methods seen in other concurrent tests
 * 						-	uses a single shared class instance of ForkJoinPool with a pool size of 10
 * 						-	submits tasks for execution into the pool
 * 						-	submits 20 ArraySummationTask and 20 ArrayMaximumTask tasks into the pool for execution
 * 						-	each instance of the test running simultaneously should introduce competition for the shared thread pool
 */

public class ForkJoinPoolTest extends ConcurrentTest
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
	 * 
	 * Unfortunately this restricts what can be tested e.g. ForkJoinPool.shutdown() cannot be run as this makes the pool unusable to future threads.
	 */

	private static final int DELAY=100;
	private static final int REPS=1000;
	
	private static ForkJoinPool apiPool = new ForkJoinPool(2);
	private static ReentrantReadWriteLock apiPoolLock = new ReentrantReadWriteLock();
	
	private static ForkJoinPool stressPool = new ForkJoinPool(10);	// use a pool size of 10 - used for the testStress test
	
	private static int[] stressIntegers = new int[20000];			// Use a single class instance for this to prevent too much heap usage
	private static int checkedSum = 0;								// Used to keep track of the correct answer that the ArraySummationTasks in testStress should return
	private static int checkedMaximum = 0;							// Used to keep track of the correct answer that that ArrayMaximumTasks in testStress should return
	
	static															// Populate the stressIntegers array - inside a static block as this only needs doing once on class load
	{
		for(int i = 0; i < stressIntegers.length; i++)
		{
			stressIntegers[i] = rng.nextInt(50);
			checkedSum += stressIntegers[i];						// Add to the correct answer
			if(stressIntegers[i] > checkedMaximum)					// Determine if this is the largest number seen so far and save it into the checkedMAximum if this is the case
			{
				checkedMaximum = stressIntegers[i];
			}
		}
	}
	
	/**
	 * tearDown() is needed as if one of the checked assertions fails, the testAPI() method never releases the apiPoolLock write lock
	 * and all other threads running this testcase block forever. More generally, it will be run whenever a testAPI() and testStress() method
	 * ends whether normally or abnormally.
	 */
	public void tearDown()
	{
		try
		{
			apiPoolLock.writeLock().unlock();
		}
		catch(IllegalMonitorStateException imse)
		{
			// Doesn't matter - this just means that we didn't have the lock
		}
	}
	
	/**
	 * Verifies the correct function of the basic API of ForkJoinPool
	 */
	public void testAPI()
	{
	    // First up, we need to take the apiPoolLock
		apiPoolLock.writeLock().lock();
	
	    // Constructors
		assertEquals("1 : getParallelism()", 2, apiPool.getParallelism());
		assertEquals("2 : getUncaughtExceptionHandler()", null, apiPool.getUncaughtExceptionHandler());				// Default exception handler
		assertEquals("3 : getAsyncMode()", false, apiPool.getAsyncMode());											// Default asynchronous mode
		assertEquals("4 : getFactory()", ForkJoinPool.defaultForkJoinWorkerThreadFactory, apiPool.getFactory());
		// assertEquals("5 : getActiveThreadCount()", 0, apiPool.getActiveThreadCount());							// getActiveThreadCount may be inaccurate see https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ForkJoinPool.html#getActiveThreadCount()    
	    // assertEquals("6 : getPoolSize()", firstRun ? 0 : 2, apiPool.getPoolSize());
		assertEquals("7 : getQueuedSubmissionCount()", 0, apiPool.getQueuedSubmissionCount());
		assertEquals("8 : getQueuedTaskCount()", 0, apiPool.getQueuedTaskCount());
	    // assertEquals("9 : getRunningThreadCount()", 0, apiPool.getRunningThreadCount());  this is also 2 (like poolsize) on later runs
							
	    // Basic API tests
		WaiterTask waiter1 = new WaiterTask("Waiter1");	// Create a few tasks to run in the pool - the pool only has 2 threads so one of these will be queued
		WaiterTask waiter2 = new WaiterTask("Waiter2");
		WaiterTask waiter3 = new WaiterTask("Waiter3");
		
		apiPool.submit(waiter1);				        // Submit the first two tasks into the pool to be run asynchronously
		apiPool.submit(waiter2);
		
		// Wait for waiter1 and waiter2 is be active and waiter3 to be queued
		while(!waiter1.isWaiting() || !waiter2.isWaiting())
		{
			sleep(DELAY);
		}
		
		// As the other two tasks are now in the pool and are blocking it, waiter3 is queued
		apiPool.submit(waiter3);
		
		// The following cannot be checked assertions when run in a workload.
		// The API methods describe themselves as returning an 'estimate' of the correct answer. This estimate is correct in single threaded invocations but
		// is very often wrong in multithreaded environments. The methods are called to at least ensure that they don't crash.

		// 11 : getActiveThreadCount()
		apiPool.getActiveThreadCount();
		// 12 : hasQueuedSubmissions()
		apiPool.hasQueuedSubmissions();
		// 13 : getQueuedSubmissionCount()
		apiPool.getQueuedSubmissionCount();
		// 14 : getQueuedTaskCount()
		apiPool.getQueuedTaskCount();
		// 15 : getRunningThreadCount()
		apiPool.getRunningThreadCount();
		// 16 : getPoolSize()
		apiPool.getPoolSize();
		
		waiter1.unblock();			// Calling unblock() allows this task to escape from a blocking loop and hence complete
		waiter1.join();
		
		try
		{
			assertEquals("17 : get()", new Boolean(true), waiter1.get());	// The waiter should have the result 'true' if it really did reach the end of execution
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		catch (ExecutionException e) 
		{
			e.printStackTrace();
		}
		
		while(!waiter3.isWaiting())		    // Now that waiter1 has completed, waiter3 should start running alongside waiter2
		{
			sleep(DELAY);
		}
		
		// 18 : getActiveThreadCount()
		apiPool.getActiveThreadCount();
		// 19 : getQueuedSubmissionCount()
		apiPool.getQueuedSubmissionCount();
		// 20 : getQueuedTaskCount()
		apiPool.getQueuedTaskCount();
		// 21 : getRunningThreadCount()
		apiPool.getRunningThreadCount();
		// 22 : getPoolSize()
		apiPool.getPoolSize();
				
		waiter2.unblock(); 				// Allow the WaiterTasks to end
		waiter3.unblock();

		while(!waiter2.isDone() || !waiter3.isDone())
		{
			sleep(DELAY);
		}
		
	    // Make some new WaiterTasks
		waiter1 = new WaiterTask("waiter1 2ndlife");
		waiter2 = new WaiterTask("waiter2 2ndlife");
		waiter3 = new WaiterTask("waiter3 2ndlife");
	
		waiter2.unblock();								// have waiter2 not do any waiting at all when it is submitted
		
		apiPool.execute(waiter1);						// execute schedules the work asynchronously i.e. non-blocking and starts immediately
		
		while(apiPool.getActiveThreadCount() != 1)		// wait for a thread to become active ..... unsafe: 
		{                                               //  1: ForkJoinPoll.execute() may not use pooled thread (legal to run inline)
			sleep(DELAY);                               //  2: It could report say 2 (an overestimate)
			
			if (waiter1.isWaiting()) {					// The apiPool returns an estimate and at times that estimate is wrong and
				break;									// causes this loop to deadlock so break the loop if the waiter task is waiting.
			}
		}
		
		// 23 : getActiveThreadCount()
		apiPool.getActiveThreadCount();
		// 24 : getQueuedSubmissionCount()
		apiPool.getQueuedSubmissionCount();
		// 25 : getRunningThreadCount()
		apiPool.getRunningThreadCount();
		// 26 : getPoolSize()
		apiPool.getPoolSize();
				
		Boolean waiter2Result = apiPool.invoke(waiter2);												// invoke is a blocking operation and won't return until waiter2 completes

		assertEquals("27 : getRawResult()", waiter2Result, waiter2.getRawResult());						// check the result of waiter2
		
		waiter1.unblock();
		
        // while(apiPool.getActiveThreadCount() != 0 || apiPool.getRunningThreadCount() != 0 )	// wait for all threads to stop ..... unsafe, may never go to zero (overestimate)
		while(apiPool.getActiveThreadCount() != 0  )                                        // In fact Running never went below 1	
		{                                                                                   
			sleep(DELAY);
		}
		
	}

	/**
	 * Basic testing of ForkJoinPool with a pool of threads shared across invocations of this testcase
	 * such that multiple instances of the test can run at the same time and share the same set of tests
	 * 
	 * A single invocation of this method is enough to keep all of the available threads in the pool busy with work.
	 * Multiple parallel invocations should therefore ensure that threads block on each other and thereby verify this 
	 * aspect of the ForkJoinPool class
	 */
	public void testStress()
	{
		ArraySummationTask[] summationTasks = new ArraySummationTask[20];						// Stress test consists of 20 ArraySummationTasks
		ArrayMaximumTask[] maximumTasks = new ArrayMaximumTask[20];								// ... and a further 20 ArrayMaximumTasks
		
		for(int counter = 0; counter < summationTasks.length; counter++)						// Setup the 40 tasks for the pool
		{	
			summationTasks[counter] = new ArraySummationTask(stressIntegers, 0, stressIntegers.length);
			maximumTasks[counter] = new ArrayMaximumTask(stressIntegers, 0, stressIntegers.length);
			
			stressPool.submit(summationTasks[counter]);
			stressPool.submit(maximumTasks[counter]);
		}
		
		boolean tasksComplete = false;								// Keep track of whether the tasks have all completed yet
		while(!tasksComplete)										// ... we loop until the tasks have completed
		{
			tasksComplete = true;
			
			for(int i = 0; i < summationTasks.length; i++)
			{	
				if(!summationTasks[i].isDone())
				{
					tasksComplete = false;							// if any task hasn't yet completed we might as well abort this loop
					break;
				}
				if(!maximumTasks[i].isDone())
				{
					tasksComplete = false;
					break;
				}
			}
		}
		
		for(int i = 0; i < summationTasks.length; i++)				// Check the answers from each of the submitted tasks
		{
			try 
			{
				assertEquals("1 : summation task provided incorrect answer at index " + i, new Integer(checkedSum), summationTasks[i].get());	// Check the summation tasks against the checkedSum
				assertEquals("2 : maximum task provided incorrect answer at index " + i, new Integer(checkedMaximum), maximumTasks[i].get());	// Likewise for the maximum tasks and the checkedMaximum
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			catch (ExecutionException e) 
			{
				e.printStackTrace();
			}

		}
		
		// End of the stress test
	}	
	
	
	public static void main(String [] Args) {

		ForkJoinPoolTest pool = new  ForkJoinPoolTest();

		System.out.printf("Running %d sets of testAPI\n", REPS);
		for (int i=0; i<REPS; ++i) {

			System.out.printf("%d, ", i);
			
			pool.testAPI();
		}

		System.out.printf("Running %d sets of testStress\n",REPS);
		for (int i=0; i<REPS; ++i) {
			pool.testStress();
		}
		
		
	}

}
