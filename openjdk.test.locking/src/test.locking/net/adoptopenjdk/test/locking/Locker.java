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

package net.adoptopenjdk.test.locking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Locker test was created to exercise lock contention against String and array objects, 
 * it was added specifically to test the optimization of this type of code by the IBM JIT.
 */
public class Locker {
	
	private int threadLevel;
	
	private int runSeconds;
	
	Object lock;
	
	boolean running = true;
		
	public Locker() {}

	public Locker(int threadLevel, int runTime, Object lock) {
		this.threadLevel = threadLevel;
		this.runSeconds = runTime;
		this.lock = lock;
	}
	
	public static void main(String[] args) {
		Locker.runTest(10, 10, 1);
		Locker.runTest(10, 10, 0);	
	}
	
	public static void runTest(int threadLevel, int runTime, int useString) {
		Object lock;
		if (useString > 0) {
			lock = "a string lock";
		} else {
			lock = "a string lock".toCharArray();
		}
		Locker test = new Locker(threadLevel, runTime, lock);
		test.go();
	}

	/**
	 * Run this test.
	 */
	void go() {
		System.out.println("Starting test with a lock of " + lock.getClass() + "\n\n");
		Queue<Object> dataQueue = new LinkedList<Object>();
		
		for (int i = 0; i < (threadLevel / 4); i++) {
			dataQueue.add(new Object());
		}
		
		Thread[] threads = new Thread[threadLevel];
		
		for (int i = 0; i < threadLevel; i++) {
			Thread rThread = new Thread(new ReaderThread(this, dataQueue), "ReaderThread " + i);
			rThread.start();
			threads[i] = rThread;
			
			i++;
			if (i > threadLevel) {
				break;
			}
			
			Thread wThread = new Thread(new WriterThread(this, dataQueue), "WriterThread " + i);
			wThread.start();
			threads[i] = wThread;
			
		}

		int sleepMillis = runSeconds * 1000;
		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		running = false;
		
		synchronized (lock) {
			lock.notifyAll();
		}
		
		boolean interrupted = false;
		do {
			for (int i = 0; i < threadLevel; i++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					interrupted = true;
					e.printStackTrace();
				}
			}
		} while (interrupted);

		System.out.println("Stopping test\n\n");
		
	}

}
