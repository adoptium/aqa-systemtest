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
 * File:    ReentrantReadWriteLockTest
 * Package: net.adoptopenjdk.test.concurrent.locks
 */

package net.adoptopenjdk.test.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * ReentrantLockTest
 * ======================
 * 
 * Attempts to verify the correct function of the ReentrantReadWriteLock class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of ReentrantReadWriteLock
 * 						-	API calls checked with assertions where possible
 * 						-	multiple threads are able to run testAPI concurrently without interfering with each other
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ReentrantReadWriteLock
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
 * So what is a ReentrantReadWriteLock anyway?
 * ======================
 * - Has a write lock and a read lock
 * - Owning the write lock allows for acquiring the read lock
 * - Owning the read lock does not allow for acquiring the write lock (unless the only thread holding read is the thread trying to acquire write) 
 * - Downgrading from write lock to read lock is possible : write lock -> read lock -> release write -> release read
 * - Fair locking policy is that : write lock is acquired by the single write thread that has been waiting longest OR
 * - reader group if they have been waiting longer than the write thread OR 
 * - Read lock cannot be acquired while the write lock is held by another thread
 * - Write lock has support for Conditions - but the read lock does not
 */

public class ReentrantReadWriteLockTest extends ConcurrentTest
{

	// The maximum number of threads to spawn. Set low for inclusion in a stress workload. Set high if testcase is being run standalone.
	private static int THREADS_TO_SPAWN = 2;
	
	// Timeout for use locally to allow for the lock to be taken / released in the various API calls
	private long waitTimeout = 300000;	// 5 minutes timeout - in a stress environment this could be required and we don't want false positive failures.
	
	// An instance of ReentrantReadWriteLock for testing. Scope limited to this instance of the test.
	private ReentrantReadWriteLock testLock;
			
	// An instance of ReentrantLock for stress testing.
	private static ReentrantReadWriteLock stressLock = new ReentrantReadWriteLock();
	
	/**
	 * tearDown() is needed so that if a test fails part way through e.g. testStress() any held locks can be cleared up.
	 */
	public void tearDown()
	{
		try
		{
			while(stressLock.getReadHoldCount() != 0)
			{
				stressLock.readLock().unlock();
			}
		}
		catch(IllegalMonitorStateException e)
		{
			// can be thrown if I didn't have the lock to start with
		}
	}
	
	/**
	 * Tests of the API. This portion of the test is much more involved than the majority of the other tests in the java.util.concurrent area
	 * and is certainly much more important than the testStress() section as it is very difficult to verify correct behaviour of locking with
	 * random threads randomly grabbing the lock and potentially not releasing it again.
	 * 
	 * For ReentrantReadWriteLock there is a lot to test. I've explained what I'm doing as best as possible but for the most part - even though
	 * there is a lot of code - it should be obvious what is happening.
	 */	
	public void testAPI()
	{
			
		// =================================================================================
		// Constructors
		
		testLock = new ReentrantReadWriteLock();
		assertEquals("1 : default constructor", false, testLock.isFair());
		
		testLock = new ReentrantReadWriteLock(false);
		assertEquals("2 : boolean constructor", false, testLock.isFair());
		testLock = new ReentrantReadWriteLock(true);
		assertEquals("3 : boolean constructor", true, testLock.isFair());

		// =================================================================================		
		// Lock objects
		
		assertEquals("4 : readLock()", testLock.readLock(), testLock.readLock());
		assertEquals("5 : getReadHoldCount()", 0, testLock.getReadHoldCount());
		assertEquals("6 : getReadHoldCount()", 0, testLock.getReadLockCount());
			
		assertEquals("7 : writeLock()", testLock.writeLock(), testLock.writeLock());
		assertEquals("8 : writeLock()", 0, testLock.getWriteHoldCount());
		assertEquals("9 : writeLock()", false, testLock.isWriteLocked());
		assertEquals("10 : writeLock()", false, testLock.isWriteLockedByCurrentThread());
		
		// =================================================================================
		// Basic API checks on the read lock - this is the same sort of behaviour as ReentrantLock
		
		testLock.readLock().lock();
		assertEquals("11 : readLock().lock()", 1, testLock.getReadHoldCount());
		assertEquals("12 : readLock().lock()", 1, testLock.getReadLockCount());
		testLock.readLock().tryLock();
		assertEquals("13 : readLock().tryLock()", 2, testLock.getReadHoldCount());
		assertEquals("14 : readLock().tryLock()", 2, testLock.getReadLockCount());
		testLock.readLock().unlock();
		assertEquals("15 : readLock().unlock()", 1, testLock.getReadHoldCount());
		assertEquals("16 : readLock().unlock()", 1, testLock.getReadLockCount());
		try 
		{
			testLock.readLock().lockInterruptibly();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		assertEquals("17 : readLock().tryLock()", 2, testLock.getReadHoldCount());
		assertEquals("18 : readLock().tryLock()", 2, testLock.getReadLockCount());
		try 
		{
			testLock.readLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		assertEquals("17 : readLock().tryLock()", 3, testLock.getReadHoldCount());
		assertEquals("18 : readLock().tryLock()", 3, testLock.getReadLockCount());
		testLock.readLock().unlock();
		testLock.readLock().unlock();
		testLock.readLock().unlock();
		assertEquals("19 : getReadHoldCount()", 0, testLock.getReadHoldCount());
		assertEquals("20 : getReadHoldCount()", 0, testLock.getReadLockCount());

		// =================================================================================
		// Basic API tests for the write lock
		
		// Starting off - current thread doesn't hold the write lock
		assertEquals("21 : writeLock().isHeldByCurrentThread()", false, testLock.writeLock().isHeldByCurrentThread());
		testLock.writeLock().lock();
		
		// Current thread should now have the writeLock
		assertEquals("22 : writeLock().lock()", true, testLock.writeLock().isHeldByCurrentThread());			// Current thread has the lock ...
		assertEquals("23 : isWriteLocked()", true, testLock.isWriteLocked());									// ... the lock is held by someone ...
		assertEquals("24 : isWriteLockedByCurrentThread()", true, testLock.isWriteLockedByCurrentThread());		// ... the lock is write locked by the current thread ...
		assertEquals("25 : getWriteHoldCount()", 1, testLock.getWriteHoldCount());								// ... the current thread holds the write lock just once
		
		try 
		{
			testLock.writeLock().lockInterruptibly();									// A further API call for acquiring the lock ...
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		assertEquals("26 : lockInterruptibly()", 2, testLock.getWriteHoldCount());		// ... current thread should hold the write lock twice
		
		testLock.writeLock().unlock();													// Test unlocking ...
		testLock.writeLock().unlock();
		assertEquals("27 : writeLock().unlock()", 0, testLock.getWriteHoldCount());		// ... current thread now doesn't hold the write lock
		
		testLock.writeLock().tryLock();													// Test a further possible API call for taking the lock - this one only returns immediately if the lock is held by another thread
		assertEquals("28 : writeLock().tryLock()", 1, testLock.getWriteHoldCount());	// ... but no other thread has the lock so tryLock succeeds and this thread now holds the write lock
		
		try
		{
			testLock.writeLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS);			// Another API call for acquiring the lock - this one is as above but with a maximum wait time
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		assertEquals("28 : writeLock().tryLock()", 2, testLock.getWriteHoldCount());	// ... current thread now holds the write lock twice
		
		testLock.writeLock().unlock();													// Unlock - current thread holds the write lock just once ...
		testLock.readLock().lock();														// ... taking read lock is permitted if you already hold write ...
		assertEquals("29 : readLock().lock()", 1, testLock.getWriteHoldCount());		// ... this thread still holds the write lock once ...
		assertEquals("30 : readLock().lock()", 1, testLock.getReadHoldCount());			// ... but now also has the read lock once ...
		assertEquals("31 : readLock().lock()", 1, testLock.getReadLockCount());			// ... and the read lock is only held once - i.e. by no other threads
		testLock.readLock().unlock();													
		testLock.writeLock().unlock();
		assertEquals("32 : readLock().unlock()", 0, testLock.getReadLockCount());		// Neither the read lock ...
		assertEquals("33 : writeLock().unlock()", 0, testLock.getWriteHoldCount());		// ... nor the write lock are held ...
		testLock.writeLock().lock();													// ... so this thread can acquire the write lock ...
		testLock.readLock().tryLock();													// ... and again can acquire the read lock ...
		assertEquals("34 : readLock().tryLock()", 1, testLock.getWriteHoldCount());
		assertEquals("35 : readLock().tryLock()", 1, testLock.getReadLockCount());
		testLock.readLock().unlock();													// Release both locks again ...
		testLock.writeLock().unlock();
		assertEquals("36 : readLock().unlock()", 0, testLock.getReadLockCount());		// ... and verify that both locks are no longer held ...
		assertEquals("37 : writeLock().unlock()", 0, testLock.getWriteHoldCount());
		testLock.writeLock().tryLock();													// More of the same
		testLock.readLock().tryLock();
		assertEquals("38 : readLock().tryLock()", 1, testLock.getWriteHoldCount());
		assertEquals("39 : readLock().tryLock()", 1, testLock.getReadLockCount());
		testLock.readLock().unlock();
		testLock.writeLock().unlock();
		assertEquals("40 : readLock().unlock()", 0, testLock.getReadLockCount());
		assertEquals("41 : writeLock().unlock()", 0, testLock.getWriteHoldCount());
		
		
		try
		{
			testLock.writeLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS);
			testLock.readLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS);
			assertEquals("42 : readLock().tryLock()", 1, testLock.getWriteHoldCount());
			assertEquals("43 : readLock().tryLock()", 1, testLock.getReadLockCount());
			testLock.readLock().unlock();
			testLock.writeLock().unlock();
			assertEquals("44 : readLock().unlock()", 0, testLock.getReadLockCount());
			assertEquals("45 : writeLock().unlock()", 0, testLock.getWriteHoldCount());
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		try
		{
			testLock.writeLock().lockInterruptibly();
			testLock.readLock().lockInterruptibly();
			assertEquals("46 : readLock().lockInterruptibly()", 1, testLock.getWriteHoldCount());
			assertEquals("47 : readLock().lockInterruptibly()", 1, testLock.getReadLockCount());
			testLock.readLock().unlock();
			testLock.writeLock().unlock();
			assertEquals("48 : readLock().unlock()", 0, testLock.getReadLockCount());
			assertEquals("49 : writeLock().unlock()", 0, testLock.getWriteHoldCount());
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
																								// At this point neither lock is held ...
		testLock.readLock().lock();																// Take the read lock with this thread ...
		assertEquals("50 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... as the read lock is held, the write lock cannot be taken - even by the same thread ...
		testLock.readLock().unlock();															// ... but releasing the read lock ...
		assertEquals("51 : writeLock().tryLock()", true, testLock.writeLock().tryLock());		// ... allows the write lock to be taken.
		
		assertEquals("52 : readLock().tryLock()", true, testLock.readLock().tryLock());			// We can downgrade from write to read - first we acquire the read lock while holding the write lock
		testLock.writeLock().unlock();															// ... then we release the write lock ...
		assertEquals("53 : getReadLockCount()", 1, testLock.getReadLockCount());				// ... we still hold the read lock ...
		assertEquals("54 : getReadHoldCount()", 1, testLock.getReadHoldCount());				// ... we are the only holder of the read lock ...
		assertEquals("55 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... and we are not able to take the write lock (as the read lock is held)
		testLock.readLock().unlock();															
		
		assertEquals("56 : getReadLockCount()", 0, testLock.getReadLockCount());				// Again, none of the locks are held by this point
		assertEquals("57 : getReadLockCount()", 0, testLock.getReadHoldCount());
		assertEquals("58 : getWriteHoldCount()", 0, testLock.getWriteHoldCount());

		/**
		 * More complex tests involving multiple threads
		 * The tests below used to have a timeout period and would abort and fail if the timeout period was exceeded. On some machines the timeout was
		 * being exceeded before the tested condition had chance to become true. For this reason, the timeout logic has been removed and the code
		 * now loops indefinitely until the test condition becomes true. This could lead to the testcase hanging if the condition never becomes true
		 * but the load test harness which runs this test would detect this and collect javacores allowing the failure to be analysed.
		 */
	 	
		// Create a new thread and instruct it to take hold of the read lock
		ReentrantReadWriteLockTestHelperThread reader = new ReentrantReadWriteLockTestHelperThread(testLock, ReentrantReadWriteLockTestHelperThread.TAKE_READ_LOCK);
		Thread readerThread = new Thread(reader);
		readerThread.start();
		
		// Wait for the spawned thread to take the lock - loop until the lock count increases
		while(testLock.getReadLockCount() == 0)
		{
			sleep(1000);
		}
		
		assertEquals("59 : getReadLockCount()", 1, testLock.getReadLockCount()); 				// One thread holds the lock...
		assertEquals("60 : getReadLockCount()", 0, testLock.getReadHoldCount());				// ... but it isn't this current thread ...
		assertEquals("61 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... and so we can't take the write lock ...
		assertEquals("62 : readLock().tryLock()", true, testLock.readLock().tryLock());			// ... but we can still take a read lock.
		
		// Have the spawned thread stop running and give it time to release the lock again
		reader.setRunning(false);
		// Loop until the read lock count changes from 2
		while(testLock.getReadLockCount() == 2)
		{
			sleep(1000);
		}
		
		assertEquals("63 : getReadHoldCount()", 1, testLock.getReadHoldCount());				// By now the spawned thread should have ended and released the read lock ...
		assertEquals("64 : getReadLockCount()", 1, testLock.getReadLockCount());				// ... leaving just the current thread holding a read lock ...
		assertEquals("65 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... but this still prevents a write lock being taken ...
		testLock.readLock().unlock();															
		assertEquals("66 : getReadHoldCount()", 0, testLock.getReadHoldCount());				// Release all locks again
		assertEquals("67 : getReadLockCount()", 0, testLock.getReadLockCount());
		
		// Make things more interesting by spawning 10 threads that will all take the read locks		
		ReentrantReadWriteLockTestHelperThread[] readers = new ReentrantReadWriteLockTestHelperThread[2];
		Thread[] threads = new Thread[THREADS_TO_SPAWN];
		
		for(int i = 0; i < readers.length; i++)
		{
			readers[i] = new ReentrantReadWriteLockTestHelperThread(testLock, ReentrantReadWriteLockTestHelperThread.TAKE_READ_LOCK);
			threads[i] = new Thread(readers[i]);
			threads[i].start();
		}
		
		// Give the spawned threads time to take the lock - loop until the number of read locks held matches the number of threads spawned 
		while(testLock.getReadLockCount() != readers.length)
		{
			sleep(1000);
		}
		
		assertEquals("68 : readLock().tryLock()", true, testLock.readLock().tryLock());					// Have this thread also take a read lock ...
		assertEquals("69 : getReadHoldCount()", 1, testLock.getReadHoldCount());						// ... this thread holds the read lock just once ...
		assertEquals("70 : getReadLockCount()", THREADS_TO_SPAWN + 1, testLock.getReadLockCount());		// ... but there are THREADS_TO_SPAWN + 1 read locks held at the moment in total ...
		testLock.readLock().unlock();															
		assertEquals("71 : getReadHoldCount()", 0, testLock.getReadHoldCount());				// ... this thread no longer holds the lock ...
		assertEquals("72 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... and it cannot take the write lock as read locks are held

		// Have the read lock threads release the lock again
		for(int i = 0; i < readers.length; i++)
		{
			readers[i].setRunning(false);
			readers[i] = null;
		}
		
		// And loop until the locks are releases
		while(testLock.getReadLockCount() != 0)
		{
			sleep(1000);
		}
		
		assertEquals("73 : readLock().tryLock()", true, testLock.readLock().tryLock());			// At this stage there are no locks held so this thread can acquire the read lock ...
		assertEquals("71 : getReadHoldCount()", 1, testLock.getReadHoldCount());				// ... verify ...
		assertEquals("72 : getReadLockCount()", 1, testLock.getReadLockCount());
		assertEquals("73 : writeLock().tryLock()", false, testLock.writeLock().tryLock());		// ... can't get the write lock though as this thread is holding read
		testLock.readLock().unlock();

		// =================================================================================
		// Test the API around Queueing
		
		assertEquals("74 : isWriteLocked()", false, testLock.isWriteLocked());					// Verify initial state - no read locks no write locks
		assertEquals("75 : getReadLockCount()", 0, testLock.getReadLockCount());
		
		testLock.writeLock().lock();															// Take the write lock with this thread ...
		
		readers = new ReentrantReadWriteLockTestHelperThread[2];								// ... create 10 threads that all acquire the read lock ...
		threads = new Thread[THREADS_TO_SPAWN];
		
		for(int i = 0; i < readers.length; i++)
		{
			readers[i] = new ReentrantReadWriteLockTestHelperThread(testLock, ReentrantReadWriteLockTestHelperThread.TAKE_READ_LOCK);
			threads[i] = new Thread(readers[i]);
			threads[i].start();
		}
		
		long loopStartTime = System.currentTimeMillis();
		while(testLock.getQueueLength() != THREADS_TO_SPAWN)
		{
			assertEquals("76 : getReadLockCount()", 0, testLock.getReadLockCount());		// ... but the started threads can't take the read lock while main thread has write lock ...
		}
		
		assertEquals("77 : getQueueLength()", THREADS_TO_SPAWN, testLock.getQueueLength());	// ... they should therefore all be queued ...
		
		testLock.writeLock().unlock();														// ... until this thread releases the write lock ...
													
		while(testLock.getQueueLength() != 0)
		{
			sleep(1000);
		}
		
		assertEquals("78 : getQueueLength()", 0, testLock.getQueueLength());				// ... and now the queue is 0 and the reader threads all have a read lock i.e. 10 read locks held ...
		
		// Make a thread that will attempt to grab the write lock
		ReentrantReadWriteLockTestHelperThread writer = new ReentrantReadWriteLockTestHelperThread(testLock, ReentrantReadWriteLockTestHelperThread.TAKE_WRITE_LOCK);
		Thread writerThread = new Thread(writer);
		writerThread.start();
		
		while(testLock.getQueueLength() == 0)
		{
			sleep(1000);
		}
		
		assertEquals("79 : hasQueuedThread()", true, testLock.hasQueuedThread(writerThread));	// ... of course the started thread can't take a write lock because of the 10 reader threads ...
		
		for(int i = 0; i < readers.length; i++)													// ... but if the reader threads were to stop running ...
		{
			readers[i].setRunning(false);
			readers[i] = null;
		}
		
		while(testLock.getQueueLength() == 1)
		{
			sleep(1000);
		}
		
		assertEquals("80 : isWriteLocked()", true, testLock.isWriteLocked());					// ... the writer thread can acquire the write lock
		assertEquals("81 : isWriteLockedByCurrentThread()", false, testLock.isWriteLockedByCurrentThread());
		
		writer.setRunning(false);																// Have the writer thread release the write lock ...

		while(testLock.isWriteLocked())
		{
			sleep(1000);
		}
		
		testLock.writeLock().lock();															// ... verify by acquiring write lock with this thread
		assertEquals("80 : isWriteLocked()", true, testLock.isWriteLocked());
		assertEquals("81 : isWriteLockedByCurrentThread()", true, testLock.isWriteLockedByCurrentThread());
		testLock.writeLock().unlock();

		// =================================================================================
		// Next, test the API around Conditions
		
		try
		{
			testLock.readLock().newCondition();
			fail();
		}
		catch(UnsupportedOperationException e)
		{
			// Expected as only writeLock supports Conditions
		}
		
		// Start a thread with a Condition
		testLock.writeLock().lock();
		Condition testCondition = testLock.writeLock().newCondition();
		writer = new ReentrantReadWriteLockTestHelperThread(testLock, ReentrantReadWriteLockTestHelperThread.TAKE_WRITE_LOCK, testCondition);
		writerThread = new Thread(writer);
		writerThread.start();
				
		while(testLock.getWaitQueueLength(testCondition) != 1)
		{											
			testLock.writeLock().unlock();			// The writer thread can only enter await() once it holds the write lock ...
			sleep(1000);							// ... so this thread needs to release the write lock first and wait to give the writer thread a chance to acquire it ...
			testLock.writeLock().lock();			// ... but this thread needs the write lock to be able to call lock.getWaitQueueLength() ...
		}
			
		assertEquals("82 : isWriteLocked()", true, testLock.isWriteLocked());									// By this point the write lock should be held ...
		assertEquals("83 : isWriteLockedByCurrentThread()", true, testLock.isWriteLockedByCurrentThread());		// ... by the current thread as the loop above ended with a writeLock().lock() ...
		assertEquals("84 : hasWaiters()", true, testLock.hasWaiters(testCondition));							// ... there should be queued threads ...
		assertEquals("85 : getWaitQueueLength()", 1, testLock.getWaitQueueLength(testCondition));				// ... to be exact just the one queued thread.
		
		testLock.readLock().lock();					// This thread acquires the read lock ...
		testCondition.signal();						// ... signals on the condition that the write lock is now free ...
		testLock.writeLock().unlock();				// ... and releases the write lock (current thread has downgraded from write to read)
		
		loopStartTime = System.currentTimeMillis();
		// NOTE : tryLock() will acquire a second read lock for this thread!
		while(testLock.readLock().tryLock()  && System.currentTimeMillis() - loopStartTime < 10000)		
		{
			testLock.readLock().unlock();			// If this thread is able to take a read lock then the writer thread hasn't yet returned from Conditon.await() ...
			sleep(1000);							// ... as if it had then it would own the write lock and this thread couldn't take a read lock however ...
		}
		
		// ... even though the writer has been signalled to wake up, this thread is still holding a read lock so the write lock cannot be taken anyway
		assertEquals("86 : isWriteLocked()", false, testLock.isWriteLocked());
		assertEquals("87 : isWriteLockedByCurrentThread()", false, testLock.isWriteLockedByCurrentThread());
		
		while(testLock.getReadHoldCount() != 0)
		{
			testLock.readLock().unlock(); 			// Allow the writer thread to return from Condition.await() and it will eventually take the write lock
		}
		
		while(testLock.readLock().tryLock())
		{
			testLock.readLock().unlock();			// Repeat of the loop above but this time the current thread holds no read lock ...
			sleep(1000);						    // ... and therefore as soon as the current thread cannot take a read lock, the writer thread must have the write lock
		}
		
		assertEquals("91 : isWriteLocked()", true, testLock.isWriteLocked());									// Verify that the write lock is held ...
		assertEquals("92 : isWriteLockedByCurrentThread()", false, testLock.isWriteLockedByCurrentThread());	// ... that this thread isn't the holder ...
		assertEquals("93 : writeLock().tryLock()", false, testLock.writeLock().tryLock());						// ... that this thread cannot take a write lock ...
		assertEquals("94 : readLock().tryLock()", false, testLock.readLock().tryLock());						// ... that this thread cannot take a read lock
		
		// Have the writer thread release the write lock again
		writer.setRunning(false);
		
		while(!testLock.readLock().tryLock())		// Loop until this thread can take a read lock again
		{
			sleep(1000);
		}
		
		assertEquals("95 : isWriteLocked()", false, testLock.isWriteLocked());									// Final checks ...
		assertEquals("96 : isWriteLockedByCurrentThread()", false, testLock.isWriteLockedByCurrentThread());
		assertEquals("97 : getQueueLength()", 0, testLock.getQueueLength());
		assertEquals("98 : getReadHoldCount()", 1, testLock.getReadHoldCount());
		assertEquals("99 : getWriteHoldCount()", 0, testLock.getWriteHoldCount());
		testLock.readLock().unlock();
		assertEquals("100 : writeLock().tryLock()", true, testLock.writeLock().tryLock());						// ... and we're done!
	}	
	
	/**
	 * Stress testing of the API by calling selected methods randomly over and over in an attempt to provoke a JIT reaction
	 * 
	 * Queueing and waiting on conditions is not tested as this quickly becomes a headache when you consider that this testcase
	 * is designed to be run under a load test framework with many other threads running in parallel any number of which
	 * could be selected to run this test.
	 * 
	 * There is the possibility that a thread holding the read lock attempts to take a write lock. This attempt blocks until the read lock is released.
	 * As the thread is blocked, it cannot release the read lock and we have a deadlock situation. To resolve this, threads will only ever
	 * attempt to be Readers or Writers. A Reader will never attempt to take the write lock and a writer will never try to take a read lock.
	 */
	public void testStress()
	{
		if(rng.nextInt(100) >= 10)		// 90% of test runs will be readers ...
		{
			readerStress();
		}
		else							// ... the remaining 10% will be writers
		{
			writerStress();
		}
	}
	
	/**
	 * This stress method will only ever attempt to take the read lock. The theory here is :
	 * 
	 * 1) If nobody has the read lock, I'll be able to take it
	 * 2) If I already have the read lock, I can take the read lock multiple times by virtue of the fact that it is a ReentrantLock
	 * 3) If somebody else already has the read lock, I'm going to block waiting for it to be released
	 * 4) If nobody has the read lock but somebody has a write lock, I'm going to block waiting for the write lock to be released
	 * 5) When my runtime is exceeded, I'll release the lock if I have it - multiple times if needed - and then shutdown allowing other threads to continue
	 */
	private void readerStress()
	{
		long startedTime = System.currentTimeMillis();
		
		/** Don't need to worry about launching other threads via the ReentrantReadWriteLockTestHelperThread as this method
		 * is intended to be run in a multithreaded environment where many threads will automatically be taking read and write locks
		 * as they call the API functions defined below.
		 */

		while((System.currentTimeMillis() - startedTime < stressTimeout))
		{
			try
			{
				int nextAction = rng.nextInt(15);
				switch(nextAction)
				{
					case 0 : stressLock.getQueueLength(); break;
					case 1 : stressLock.getReadHoldCount(); break;
					case 2 : stressLock.getReadLockCount(); break;
					case 3 : stressLock.hasQueuedThreads(); break;
					case 4: stressLock.isFair(); break;
					case 5: stressLock.isWriteLocked(); break;
					case 6: stressLock.isWriteLockedByCurrentThread(); break;
					case 7: stressLock.readLock().lock(); break;
					case 8: stressLock.readLock().lockInterruptibly(); break;
					case 9: stressLock.readLock().tryLock(); break;
					case 10: stressLock.readLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS); break;
					case 11: stressLock.readLock().unlock(); break;
					case 12: 
						while(stressLock.getReadHoldCount() != 0)
						{
							stressLock.readLock().unlock();
						}
						break;
					case 13: stressLock.writeLock().getHoldCount(); break;
					case 14: stressLock.writeLock().isHeldByCurrentThread(); break;
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
					
				while(stressLock.getReadHoldCount() != 0)
				{
					stressLock.readLock().unlock();
				}
			}
		}
		
		try
		{
			while(stressLock.getReadHoldCount() != 0)
			{
				stressLock.readLock().unlock();
			}
		}
		catch(IllegalMonitorStateException e)
		{
			// can be thrown if I didn't have the lock to start with
		}
	}
	
	/**
	 * This stress method will only ever attempt to take the write lock. Theory as explained above for readerStress()
	 */
	private void writerStress()
	{
		long startedTime = System.currentTimeMillis();
		
		/** Don't need to worry about launching other threads via the ReentrantReadWriteLockTestHelperThread as this method
		 * is intended to be run in a multithreaded environment where many threads will automatically be taking read and write locks
		 * as they call the API functions defined below.
		 */
				
		while((System.currentTimeMillis() - startedTime < stressTimeout))
		{
			try
			{
				int nextAction = rng.nextInt(14);
				switch(nextAction)
				{
					case 0 : stressLock.getQueueLength(); break;
					case 1 : stressLock.getReadHoldCount(); break;
					case 2 : stressLock.getReadLockCount(); break;
					case 3 : stressLock.getWriteHoldCount(); break;
					case 4 : stressLock.hasQueuedThreads(); break;
					case 5 : stressLock.isFair(); break;
					case 6 : stressLock.isWriteLocked(); break;
					case 7 : stressLock.isWriteLockedByCurrentThread(); break;
					case 8 : stressLock.writeLock().getHoldCount(); break;
					case 9 : stressLock.writeLock().isHeldByCurrentThread(); break;
					case 10: stressLock.writeLock().lock(); break;
					case 11: stressLock.writeLock().tryLock(); break;
					case 12: stressLock.writeLock().tryLock(waitTimeout, TimeUnit.MILLISECONDS); break;
					case 13: 
						while(stressLock.getWriteHoldCount() != 0)
						{
							stressLock.writeLock().unlock(); break;
						}
						break;
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
					
				while(stressLock.getWriteHoldCount() != 0)
				{
					stressLock.writeLock().unlock();
				}
			}
		}
		
		try
		{
			while(stressLock.getWriteHoldCount() != 0)
			{
				stressLock.writeLock().unlock();
			}
		}
		catch(IllegalMonitorStateException e)
		{
			// can be thrown if I didn't have the lock to start with
		}
	}
	
	/**
	 * A little helper class for the above testcase. Has 3 modes of operation :
	 * 
	 * 	1) The basic case is to take a read lock. The helper thread takes the lock, loops until told to stop and then releases the lock again
	 *  2) The other cases both involve a write lock :
	 *  	a) Take a write lock, await a condition being signaled (releases the lock until signalled), loop until told to stop and then release the lock
	 *  	b) Take a write lock, loop until told to stop and then release the lock
	 *  
	 *  This helper class allows for the API around queued threads, read and write lock conflicts and waiting on conditions to be verified
	 */	
	private class ReentrantReadWriteLockTestHelperThread implements Runnable
	{
		// Constants allowing for behaviour of the helper thread to be specified
		public static final int TAKE_READ_LOCK  = 0;
		public static final int TAKE_WRITE_LOCK = 1;
		
		// A lock
		ReentrantReadWriteLock lock;
		// A condition
		Condition condition = null;
		
		// Boolean to control the looping behaviour
		boolean keepRunning = true;
		// Local variable specifying which lock to take
		int lockToTake = 0;
		
		/**
		 * Basic constructor taking a ReentrantReadWriteLock to lock on and an int specifying the type of lock to take
		 * (either TAKE_READ_LOCK or TAKE_WRITE_LOCK)
		 * 
		 * @param lockIn
		 * @param lockToTakeIn
		 */
		public ReentrantReadWriteLockTestHelperThread(ReentrantReadWriteLock lockIn, int lockToTakeIn)
		{
			lock = lockIn;
			lockToTake = lockToTakeIn;
		}
		
		/**
		 * Constructor taking a ReentrantReadWriteLock to lock on, an int specifying the type of lock to take
		 * (either TAKE_READ_LOCK or TAKE_WRITE_LOCK) and a Condition object to wait on.
		 * 
		 * @param lockIn
		 * @param lockToTakeIn
		 * @param conditionIn
		 */
		public ReentrantReadWriteLockTestHelperThread(ReentrantReadWriteLock lockIn, int lockToTakeIn, Condition conditionIn)
		{
			lock = lockIn;
			lockToTake = lockToTakeIn;
			condition = conditionIn;
		}
		
		/**
		 * Allows for controlling (mostly just stopping) the thread looping 
		 */
		public void setRunning(boolean running)
		{
			keepRunning = running;
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
			// Case 1) Take a read lock
			if(lockToTake == TAKE_READ_LOCK)
			{
				lock.readLock().lock();
				while(keepRunning)
				{
					doNothing();				// ... in this case simulate a process reading some data by looping until told to stop
				}
				lock.readLock().unlock();		// Release the lock
			}
			// Case 2) Take a write lock
			else if(lockToTake == TAKE_WRITE_LOCK)
			{
				// Case 2b) Take a write lock and wait on a condition
				if(condition != null)	
				{
					try 
					{
						lock.writeLock().lock();		// Take the lock ...
						condition.await();				// ... releases the lock and waits to be signalled ...
						while(keepRunning)				// ... when signalled, we now have the lock ...
						{	
							doNothing();				// ... simulates doing 'stuff' ...
						}
					}
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					lock.writeLock().unlock();			// ... releases the lock
				}
				// Case 2a) Take a write lock
				else
				{
					lock.writeLock().lock();
					while(keepRunning)
					{
						doNothing();
					}
					lock.writeLock().unlock();
				}
			}
		}
	}
	
}
