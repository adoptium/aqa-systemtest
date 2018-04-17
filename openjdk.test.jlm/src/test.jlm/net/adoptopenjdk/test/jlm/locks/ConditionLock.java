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
 * This java source file contains the ConditionLock class, used
 * to enter a Reentrant Lock and wait on the condition, signal the
 * the condition is reached and release the lock. 
 */
package net.adoptopenjdk.test.jlm.locks;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import net.adoptopenjdk.test.jlm.resources.Message;

import java.util.concurrent.locks.Condition;

public class ConditionLock {
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
		
	private final WaitRunnable runnable = new WaitRunnable(lock, condition);
	
	// This method spawns a thread to wait for the signal. 
	// A second thread is need to send the signal.
	public synchronized void initiateWait() {
		(new Thread(runnable,"Condition Lock Thread")).start();
				
		trace("Thread started...");
		
		int count = 0;
		
		while(! runnable.lockAcquired || count < 5) {
			count++;
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				trace("Unexpected interruption");
				e.printStackTrace();
			}
		}
		trace("Started thread is waiting");
	}
	
	// Sends the signal to stop the thread waiting
	public synchronized void sendSignal() {
        lock.lock();
		trace("Lock obtained, sending signal");
		condition.signal();
	}
	
	public synchronized void releaseLock() {
		trace("Releasing lock");
		lock.unlock();
	}
	
	// Runnable that implements the thread logic for establishing the condition wait.
	public static class WaitRunnable implements Runnable {
		private final Lock myLock;
		private final Condition myCondition;
		private volatile boolean lockAcquired = false;

		public WaitRunnable(Lock lock, Condition condition) {
			myLock = lock;
			myCondition = condition;
		}
		
		public void run() {
			try {
				myLock.lock();
				lockAcquired = true;
				trace("Lock obtained, awaiting signal");
				myCondition.await();
				trace("Signal received");
			} catch (InterruptedException e) {
				trace("Unexpected Interrupted received while awaiting signal");		   
			} finally {
				myLock.unlock();
			}
		}
	}
	
	public static void trace(String message) {
		Message.logErr((new Date()) + " - " + Thread.currentThread().getName() + " : " + message);
	}
}
