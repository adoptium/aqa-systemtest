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

/*
 * This java source file contains the DeadLock class, used
 * to create a deadlock using Reentrant Locks
 */
package net.adoptopenjdk.test.jlm.locks;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
import net.adoptopenjdk.test.jlm.resources.Message;

public class DeadLock {
	private final ReentrantLock lockOne = new ReentrantLock();
	private final ReentrantLock lockTwo = new ReentrantLock();
	
	//Define the runnables that will be deadlocked. We need them later so we
	//can release the deadlock.
	private final DeadlockingRunnable runnableOne = new DeadlockingRunnable(lockOne,lockTwo);	
	private final DeadlockingRunnable runnableTwo = new DeadlockingRunnable(lockTwo,lockOne);
	
	// This method spawns two threads and waits for them to get into a dead
	// lock scenario before returning.
	// 
	// You can later release this deadlock with releaseDeadlock().
	public synchronized void initiateDeadlock() {
		(new Thread(runnableOne,"Deadlock Thread 1")).start();
		(new Thread(runnableTwo,"Deadlock Thread 2")).start();
		
		trace("Threads started, waiting for deadlock to establish");
		
		int count = 0;
		
		while(! runnableOne.lockOneAcquiredWaitingForTwo || 
				! runnableTwo.lockOneAcquiredWaitingForTwo || count < 5) {
			count++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				trace("Unexpected interruption");
				e.printStackTrace();
			}
		}
		
		trace("Deadlock established");
	}
	
	// Releases the current deadlock.
	// throws RuntimeException if we haven't established a deadlock yet
	public synchronized void releaseDeadlock() {
		runnableOne.stop();
		runnableTwo.stop();
	}
	
	// Runnable that implements the thread logic for establishing the deadlock.
	// 
	// We will be initializing with two locks. We will get the first and then sit in a loop
	// trying to get the second. The idea is that two threads will be started with
	// opposing pairs of locks (so lock 1 for thread 1 is lock 2 for thread 2 and vice versa).
	// 
	// We are aiming to deadlock trying to acquire the second lock. If we succeed in getting
	// the second lock, we will release it and sleep for a couple of milliseconds and try again.
	// 
	// If we are interrupted we will break out of the run method. Being interrupted
	// is the signal to break the deadlock.
	public static class DeadlockingRunnable implements Runnable {
		private final ReentrantLock myLockOne;
		private final ReentrantLock myLockTwo;
		private volatile boolean lockOneAcquiredWaitingForTwo = false;
		private volatile Thread executingThread;
		
		public DeadlockingRunnable(ReentrantLock one, ReentrantLock two) {
			myLockOne = one;
			myLockTwo = two;
		}
	
		public void run() {
			executingThread = Thread.currentThread();
			try {
			    // Get lock one
				myLockOne.lock();
				
				// Now we're going to sit in a loop trying to get lock 2
				while(true) {
					try {
						lockOneAcquiredWaitingForTwo = true;
						myLockTwo.lockInterruptibly();
						lockOneAcquiredWaitingForTwo = false;
					} 
					catch (InterruptedException e) {
						//We've been interrupted - break out
						trace("Interrupted trying to get second lock");
						break;
					}
					
					trace("Acquired second lock");
					
					//If we get here we've acquired the second lock, we must
					//release it then sleep for a bit to give the other guy a 
					//chance to get his first lock (our second)
					myLockTwo.unlock();
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						trace("Interrupted in sleep");
						break;
					}
				}
			} finally {
				myLockOne.unlock();
			}
		}
		
		// State variable. If the pair of threads are both in this state they must be deadlocked.
		public boolean lockOneAcquiredWaitingForTwo() {
			return lockOneAcquiredWaitingForTwo;
		}
		
		public void stop() {
			if(executingThread == null) {
				throw new RuntimeException("I don't have an executingThread "
						+ "handle, are you sure you've started the deadlock?");
			}
			executingThread.interrupt();
		}
	}
	
	public static void trace(String message) {
		Message.logErr((new Date()) + " - " + Thread.currentThread().getName() + " : " + message);
	}
}
