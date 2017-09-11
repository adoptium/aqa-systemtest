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
 * File:    ReentrantLockTest
 * Package: net.adoptopenjdk.test.concurrent.locks
 */

package net.adoptopenjdk.test.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

import java.lang.Error;

/**
 * ReentrantLockTest
 * =================
 * 
 * Attempts to verify the correct function of the ReentrantLock class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of ReentrantLock
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ReentrantLock
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

public class ReentrantLockTest extends ConcurrentTest
{
	
	// An instance of ReentrantLock for testing. Scope limited to this instance of the test.
	private ReentrantLock testLock = new ReentrantLock();
		
	// An instance of ReentrantLock for stress testing.
	private static ReentrantLock stressLock = new ReentrantLock();
	
	/**
	 * tearDown() is needed so that if a test fails part way through e.g. testStress() any held locks can be cleared up.
	 */
	public void tearDown()
	{
		try
		{
			while(stressLock.isHeldByCurrentThread())
			{
				stressLock.unlock();
			}
		}
		catch(IllegalMonitorStateException imse)
		{
			// Doesn't matter - just means we didn't hold the lock at the time.
		}
	}
	
	/**
	 * Tests of the API. This portion of the test is much more involved than the majority of the other tests in the java.util.concurrent area
	 * and is certainly much more important than the testStress() section as it is very difficult to verify correct behaviour of locking with
	 * random threads randomly grabbing the lock and potentially not releasing it again.
	 */		
	public void testAPI()
	{
		// =================================================================================
		// Constructors
		
		testLock = new ReentrantLock();
		assertEquals("1 : default constructor", false, testLock.isFair());
		
		testLock = new ReentrantLock(false);
		assertEquals("2 : boolean constructor", false, testLock.isFair());
		testLock = new ReentrantLock(true);
		assertEquals("3 : boolean constructor", true, testLock.isFair());
		
		// =================================================================================
		// Basic API checks using only the current thread and checking that lock counts are incremented
		
		assertEquals("4 : getHoldCount()", 0, testLock.getHoldCount());
		testLock.lock();
		assertEquals("5 : lock()", 1, testLock.getHoldCount());
		testLock.unlock();
		assertEquals("6 : unlock()", 0, testLock.getHoldCount());
		
		try
		{
			testLock.unlock();
			fail("7 : Expected IllegalMonitorStateException not thrown");
		}
		catch(IllegalMonitorStateException imse)
		{
			// Expected
		}
		
		try 
		{
			testLock.lockInterruptibly();
			assertEquals("8 : lockInterruptibly()", 1, testLock.getHoldCount());
		} 
		catch (InterruptedException e) 
		{
			// Not unexpected
		}
		
		testLock.unlock();
		assertEquals("9 : unlock()", 0, testLock.getHoldCount());
		
		assertEquals("10 : isHeldByCurrentThread()", false, testLock.isHeldByCurrentThread());
		assertEquals("11 : hasQueuedThreads()", false, testLock.hasQueuedThreads());
		assertEquals("12 : hasQueuedThread()", false, testLock.hasQueuedThread(Thread.currentThread()));
		testLock.lock();
		assertEquals("13 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		assertEquals("14 : hasQueuedThreads()", false, testLock.hasQueuedThreads());
		assertEquals("15 : hasQueuedThread()", false, testLock.hasQueuedThread(Thread.currentThread()));
		
		// =================================================================================
		// Introducing a second thread into the equation
		
		ReentrantLockTestHelperThread reentrantHelper = new ReentrantLockTestHelperThread(testLock);
		Thread helper = new Thread(reentrantHelper, "ReentrantLockTest-HelperThread1a");
		helper.start();
		
		// First, check that the second thread gets queued behind the first
		while(!testLock.hasQueuedThread(helper))  
		{
			sleep(1000);
		}
		assertEquals("16 : hasQueuedThreads()", true, testLock.hasQueuedThreads());
		assertEquals("17 : hasQueuedThread()", true, testLock.hasQueuedThread(helper));
		assertEquals("18 : isLocked()", true, testLock.isLocked());
		assertEquals("19 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		assertEquals("20 : getHoldCount()", 1, testLock.getHoldCount());
		
		// Now let the other thread take over the lock and repeat
		testLock.unlock();
		
		while(testLock.hasQueuedThread(helper))
		{
			sleep(1000);
		}		
		assertEquals("21 : hasQueuedThreads()", false, testLock.hasQueuedThreads());
		assertEquals("22 : hasQueuedThread()", false, testLock.hasQueuedThread(helper));
		assertEquals("23 : isLocked()", true, testLock.isLocked());
		assertEquals("24 : isHeldByCurrentThread()", false, testLock.isHeldByCurrentThread());
		assertEquals("25 : getHoldCount()", 0, testLock.getHoldCount());
		
		// Finally, have the other thread relinquish control again so that the main thread can lock
		reentrantHelper.doUnlock();
		testLock.lock();
		assertEquals("27 : hasQueuedThreads()", false, testLock.hasQueuedThreads());
		assertEquals("28 : hasQueudThread()", false, testLock.hasQueuedThread(helper));
		assertEquals("29 : isLocked()", true, testLock.isLocked());
		assertEquals("30 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		assertEquals("31 : getHoldCount()", 1, testLock.getHoldCount());
		
		testLock.unlock();
		assertEquals("32 : getHoldCount()", 0, testLock.getHoldCount());

		// =================================================================================
		// Next, test the API around Conditions - this section is very involved
		
		Condition dummyCondition = new ReentrantLock().newCondition();
		try
		{
			testLock.hasWaiters(dummyCondition);
			fail("33 : Expected IllegalArgumentException not thrown");
		}
		catch(IllegalArgumentException e)
		{
			// expected
		}
		
		try
		{
			testLock.getWaitQueueLength(dummyCondition);
			fail("34 : Expected IllegalArgumentException not thrown");
		}
		catch(IllegalArgumentException e)
		{
			// expected
		}
		
		// Make sure the helper thread ends
		try
		{
			helper.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		// First we need some conditions
		Condition condition1 = testLock.newCondition();
		Condition condition2 = testLock.newCondition();
		
		// Then we need a couple of threads that are going to block on these conditions
		// Blocking on condition1
		reentrantHelper = new ReentrantLockTestHelperThread(testLock, condition1);
		helper = new Thread(reentrantHelper, "ReentrantLockTest-HelperThread1b");
		helper.start();
		
		// Blocking on condition2
		ReentrantLockTestHelperThread reentrantHelper2 = new ReentrantLockTestHelperThread(testLock, condition2);
		Thread helper2 = new Thread(reentrantHelper2, "ReentrantLockTest-HelperThread2b");
		helper2.start();
		
		testLock.lock(); // Current thread must hold the lock before calls to hasWaiters
		
		// Give the new threads a chance to do their work
		while(!(testLock.hasWaiters(condition1) && testLock.hasWaiters(condition2)))
		{
			testLock.unlock();	// Release the lock to allow other threads a chance at acquiring it
			sleep(1000);	
			testLock.lock();	// Grab the lock again as we need it for future calls to hasWaiters
		}
		
		assertEquals("35 : hasWaiters()", true, testLock.hasWaiters(condition1));
		assertEquals("36 : hasWaiters()", true, testLock.hasWaiters(condition2));
		assertEquals("37 : getWaitQueueLength()", 1, testLock.getWaitQueueLength(condition1));
		assertEquals("38 : getWaitQueueLength()", 1, testLock.getWaitQueueLength(condition2));
		assertEquals("39 : getWaitQueueLength()", 0, testLock.getWaitQueueLength(testLock.newCondition()));
			
		// Now signal one of the conditions
		condition1.signal();

		// Given that this thread still holds the lock, the thread waiting on condition1 should be attempting to acquire the lock but waiting
		assertEquals("40 : hasWaiters()", false, testLock.hasWaiters(condition1));
		assertEquals("41 : hasWaiters()", true, testLock.hasWaiters(condition2));
		assertEquals("42 : getWaitQueueLength()", 0, testLock.getWaitQueueLength(condition1));
		assertEquals("43 : getWaitQueueLength()", 1, testLock.getWaitQueueLength(condition2));
		assertEquals("44 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
				
		// Stop holding the lock - allows condition1 thread to continue
		testLock.unlock();
		
		// Give condition1 thread a chance to acquire the lock - loop until this thread can't acquire the lock
		while(testLock.tryLock())
		{
			condition1.signal();
			testLock.unlock();		// Release the lock to allow other threads to get in
			sleep(1000);
		}
		
		assertEquals("45 : tryLock()", false, testLock.tryLock());	// This thread can't get the lock as condition1 thread has it
		assertEquals("46 : isHeldByCurrentThread()", false, testLock.isHeldByCurrentThread());
		assertEquals("47 : isLocked()", true, testLock.isLocked());
		
		// Have the condition1 thread stop holding the lock
		reentrantHelper.doUnlock();
		while(!testLock.tryLock())
		{
			sleep(1000);
		}
		assertEquals("48 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		
		// Signal condition2
		condition2.signalAll();
		
		assertEquals("49 : hasWaiters()", false, testLock.hasWaiters(condition1));
		assertEquals("50 : hasWaiters()", false, testLock.hasWaiters(condition2));
		assertEquals("51 : getWaitQueueLength()", 0, testLock.getWaitQueueLength(condition1));
		assertEquals("52 : getWaitQueueLength()", 0, testLock.getWaitQueueLength(condition2));
		assertEquals("53 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		
		// Relinquish control of the lock to condition2 thread
		testLock.unlock();
		
		while(testLock.tryLock())
		{
			condition2.signal();
			testLock.unlock();		// Release the lock to allow other threads to get in
			sleep(1000);
		}
		
		assertEquals("54 : tryLock()", false, testLock.tryLock());	// This thread can't get the lock as condition1 thread has it
		assertEquals("55 : isHeldByCurrentThread()", false, testLock.isHeldByCurrentThread());
		assertEquals("56 : isLocked()", true, testLock.isLocked());
		
		// And finally have condition2 thread release the lock again
		reentrantHelper2.doUnlock();
		
		while(!testLock.tryLock())
		{
			sleep(1000);
		}
		
		assertEquals("57 : tryLock()", true, testLock.tryLock());
		assertEquals("58 : isHeldByCurrentThread()", true, testLock.isHeldByCurrentThread());
		assertEquals("59 : isLocked()", true, testLock.isLocked());
		
		// And if this thread unlocks, the lock should now be free
		testLock.unlock();
		testLock.unlock();
		assertEquals("60 : isLocked()", false, testLock.isLocked());
		
		// Make sure the helper threads ended
		try
		{
			helper.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		try
		{
			helper2.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * testStress() is actually not as important in the case of ReentrantLocks as it is very difficult to ensure that a thread isn't being 
	 * rude and holding the lock for an inordinate amount of time. In practice, the first thread to grab the write lock could well
	 * block all other future threads from doing anything at all until the 30 second timeout is reached. In theory, this isn't always a bad thing as
	 * it does allow us to simulate usage patterns other than absolute fairness amongst all threads.
	 */
	public void testStress()
	{
		long startedTime = System.currentTimeMillis();
		
		// Some data for use in the loop below
		Condition stressCondition = stressLock.newCondition();
		ReentrantLockTestHelperThread helper = new ReentrantLockTestHelperThread(stressLock);
		helper.doUnlock();
		Thread helperThread = new Thread(helper, "ReentrantLockTest-StressHelper");
		
		helperThread.start();
		
		while((System.currentTimeMillis() - startedTime < stressTimeout))
		{
			try
			{
				int nextAction = rng.nextInt(19);
				switch(nextAction)
				{
					case 0 : stressLock.getHoldCount(); break;
					case 1 : stressLock.getQueueLength(); break;
					case 2 : stressLock.getWaitQueueLength(stressCondition); break;
					case 3 : stressLock.hasQueuedThread(Thread.currentThread()); break;
					case 4 : stressLock.hasQueuedThread(helperThread); break;
					case 6 : stressLock.hasQueuedThreads(); break;
					case 7 : stressLock.hasWaiters(stressCondition); break;
					case 8 : stressLock.isFair(); break;
					case 9 : stressLock.isHeldByCurrentThread(); break;
					case 10: stressLock.isLocked(); break;
					case 11: stressLock.lock(); break;
					case 12: stressLock.lockInterruptibly(); break;
					case 13: stressLock.newCondition(); break;
					case 14: stressLock.tryLock(); break;
					case 15: stressLock.tryLock(100, TimeUnit.MILLISECONDS); break;
					case 16: stressLock.unlock(); break;
					case 17: stressCondition.signal(); break;
					case 18: stressCondition.signalAll(); break;
				}
			}
			catch(InterruptedException e)
			{
				// Not really of interest
			}
			catch(IllegalMonitorStateException e)
			{
				// Highly likely to happen if this thread isn't holding the lock yet
			}
			catch(Error e)
			{
				// This can happen if a thread takes more than the maximum number of locks permitted. Catch this, check the number of locks held
				// and then release them. If this isn't the case, rethrow the Error
				if(!e.getMessage().equals("Maximum lock count exceeded"))
					throw e;
					
				while(stressLock.getHoldCount() != 0)
				{
					stressLock.unlock();
				}
			}
		}
		
		try
		{
			while(stressLock.isHeldByCurrentThread())
			{
				stressLock.unlock();
			}
			helperThread.join();
		}
		catch(IllegalMonitorStateException e)
		{
			// can be thrown if I didn't have the lock to start with
		}
		catch(InterruptedException e)
		{
			// if join was interrupted we want to know about it as this probably means a thread hasn't shutdown and therefore leads to an eventual memory leak 
			e.printStackTrace();
		}
	}
	
	
	/**
	 * A little helper class for use with the above testcase.
	 * Has two modes of operation :
	 * 1) If not created with a Condition object, when the Thread is started, acquire the lock, loop until told to stop and then release the lock
	 * 2) If created with a Condition object, when the Thread is started, acquire the lock and then call await() on the Condition. Once signalled
	 *    loop until told to stop and then release the lock again.
	 *    
	 * This helper class allows for the API around queued and waiting threads to be verified.
	 */	
	private class ReentrantLockTestHelperThread implements Runnable
	{
		// A lock
		private ReentrantLock lock;
		// A condition for use with the above lock
		private Condition condition = null;
		// A boolean used to control the 'infinite' loop used to simulate a process holding a look and performing some action for a period of time
		private boolean keepRunning = true;
		
		/**
		 * Default constructor takes in a ReentrantLock object to lock on
		 */
		public ReentrantLockTestHelperThread(ReentrantLock lockIn)
		{
			lock = lockIn;
		}
		
		/**
		 * Constructor taking in both a ReentrantLock object and a Condition object for use with the lock
		 */
		public ReentrantLockTestHelperThread(ReentrantLock lockIn, Condition conditionIn)
		{
			lock = lockIn;
			condition = conditionIn;
		}
		
		/**
		 * Signals that this thread should stop holding the lock and allow another thread to take control instead 
		 */
		public void doUnlock()
		{
			keepRunning = false;	
		}
		
		/**
		 * Simple helper function that does nothing by sleeping for 100ms.
		 */
		private void doNothing()
		{
			try 
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		public void run()
		{
			// We have two modes of operation ...
			// ... 1) Where we are testing a Condition object
			if(condition != null)
			{
				try 
				{
					lock.lock();		// Must own the lock before we can await
					condition.await();	// ... await releases the lock, waits to be signalled and then retakes the lock
					while(keepRunning)
					{
						doNothing();
					}
					lock.unlock();		// As we have the lock, we need to release it
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			// ... 2) Where we are testing locking across two or more threads
			else
			{
				lock.lock();				// Attempt to claim the lock
				while(keepRunning)
				{
					doNothing();
				}
				lock.unlock();				// Release the lock
			}
		}
	}
}
