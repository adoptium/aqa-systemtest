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
 * This java source file contains the DeepLock class used
 * to enter a Reentrant Lock multiple times.
 */
package net.adoptopenjdk.test.jlm.locks;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import net.adoptopenjdk.test.jlm.resources.Message;

public class DeepLock {
	private int depth;
	
	// Define the lock to be locked deeply
	private final ReentrantLock lock = new ReentrantLock();
	
	public DeepLock(int depth) {
		this.depth = depth;
	}
	
	/**
	 * This method spawns two threads and waits for them to get into a dead
	 * lock scenario before returning.
	 * 
	 * You can later release this deadlock with releaseLocks().
	 */
	public synchronized void initiateDeeplock() {
		for (int i=0; i < depth; i++) {
			// Get lock one
			lock.lock();
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e1) {
				trace("Interrupted in sleep");
				break;
			}
		}

		// Check we are deeply locked
		int cnt = lock.getHoldCount();
		if (cnt != depth)
			throw new RuntimeException("The deep lock excepted depth (" + depth + ") "
					+ "did NOT match the actual depth (" + cnt +")");

		trace("Deep Lock established (depth = " + depth + ")");
	}
	
	/**
	 * Releases the current deadlock.
	 * 
	 * @throws RuntimeException if we haven't established a deadlock yet
	 **/
	public synchronized void releaseLocks() {
		int cnt = lock.getHoldCount();
		
		for (int i=0; i < cnt; i++) {
		    lock.unlock();
		}
		
		if (cnt != depth) {
			throw new RuntimeException("The deep lock excepted depth "
					+ "(" + depth + ") did NOT match the actual depth (" + cnt +")");
	    }
	}
	
	public static void trace(String message) {
		Message.logErr((new Date()) + " - " + Thread.currentThread().getName() + " : " + message);
	}
}
