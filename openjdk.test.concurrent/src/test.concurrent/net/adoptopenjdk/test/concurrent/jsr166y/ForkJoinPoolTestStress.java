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
 * File:    ForkJoinPoolTestStress
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent.jsr166y;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArrayMaximumTask;
import net.adoptopenjdk.test.concurrent.support.jsr166y.ArraySummationTask;

/**
 * ForkJoinPoolTestStress
 * ======================
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
 *
 * This test was written to test JSR166y. 
 */

public class ForkJoinPoolTestStress extends ConcurrentTest
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

	@SuppressWarnings("unused")
	private static final int DELAY=100;
	private static final int REPS=1000;
	
	@SuppressWarnings("unused")
	private static ForkJoinPool apiPool = new ForkJoinPool(2);

	
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

		ForkJoinPoolTestStress pool = new  ForkJoinPoolTestStress();

		System.out.printf("Running %d sets of testStress\n",REPS);
		for (int i=0; i<REPS; ++i) {
			System.out.printf("%d, ", i);
			pool.testStress();
		}
		
		
	}

}
