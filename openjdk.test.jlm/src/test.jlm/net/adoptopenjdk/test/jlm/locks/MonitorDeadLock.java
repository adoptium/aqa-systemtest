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
 * Description:
 *   This java source file contains the MonitorDeadLock class, used
 *   to create a deadlock using synchronize blocks.
 */
package net.adoptopenjdk.test.jlm.locks;

import java.util.Date;

import net.adoptopenjdk.test.jlm.resources.Message;

public class MonitorDeadLock {
	private final Object objOne = new Object();
	
	private final Object objTwo = new Object();
	
	// Define the threads that will be deadlocked. We need them later so we
	// can release the deadlock.
	private final DeadlockingThread threadOne = new DeadlockingThread(objOne,objTwo, "Monitor Deadlock Thread 1");
	
	private final DeadlockingThread threadTwo = new DeadlockingThread(objTwo,objOne, "Monitor Deadlock Thread 2");
	
	/**
	 * This method starts the  two threads and waits for them to get into a dead
	 * lock scenario before returning.
	 * 
	 * You can later release this deadlock with releaseDeadlock().
	 */
	public synchronized void initiateDeadlock() {
		threadOne.start();
		threadTwo.start();
		trace("Threads started, waiting for deadlock to establish");
		
		int count = 0;
		
		while(! threadOne.monitorOneAcquiredWaitingForTwo || 
				! threadTwo.monitorOneAcquiredWaitingForTwo || count < 5) {
			count++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				trace("Unexpected interruption");
				e.printStackTrace();
			}
		}
		
		trace("Monitor Deadlock established");
	}
	
	
	/** Runnable that implements the thread logic for establishing the deadlock.
	 * 
	 * We will be initializing with two locks, get the first and then sit in a loop
	 * trying to get the second. The idea is that two threads will be started with
	 * opposing pairs of locks (lock 1 for thread 1 is lock 2 for thread 2 and vice versa).
	 * 
	 * We are aiming to deadlock trying to acquire the second lock. If we succeed in getting
	 * the second lock, we will release it and sleep for a couple of milliseconds and try 
	 * again.
	 * 
	 * If we are interrupted we will break out of the run method. Being interrupted
	 * is the signal to break the deadlock.
	 */
	public static class DeadlockingThread extends Thread {
		private final Object myObjectOne;
		private final Object myObjectTwo;
		private volatile boolean monitorOneAcquiredWaitingForTwo = false;
				
		public DeadlockingThread(Object one, Object two, String name) {
			super(name);
			myObjectOne = one;
			myObjectTwo = two;
			this.setDaemon(true);
		}

		public void run() {
		    //	Get synchronize object 1
			synchronized (myObjectOne) {
				// Now we're going to sit in a loop trying to get synchronize object 2
				while(true) {
					monitorOneAcquiredWaitingForTwo = true;
					synchronized (myObjectTwo) {
						monitorOneAcquiredWaitingForTwo = false;
						
						//If we get here we've acquired the second monitor, we must
		    			//release it then sleep for a bit to give the other guy a 
			    		//chance to get his first monitor (our second)
						trace("Acquired second monitor");
					}
						
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						trace("Interrupted in sleep");
						break;
					}
				}
			}	
		}
		
		// State variable. If the pair of threads are both in this state they must be
		// deadlocked.
		public boolean monitorOneAcquiredWaitingForTwo() {
			return monitorOneAcquiredWaitingForTwo;
		}
	}
	
	public static void trace(String message) {
		Message.logErr((new Date()) + " - " + Thread.currentThread().getName() + " : " + message);
	}
}
