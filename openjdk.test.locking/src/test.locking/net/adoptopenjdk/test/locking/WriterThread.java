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

package net.adoptopenjdk.test.locking;

import java.util.Queue;

public class WriterThread implements Runnable {
	
	Locker parent;
	
	Queue<Object> dataQueue;
	
	WriterThread(Locker parent, Queue<Object> dataQueue) {
		this.parent = parent;
		this.dataQueue = dataQueue;
	}
	
	public void run() {
		//String name = Thread.currentThread().getName();
		while (parent.running){
			synchronized (parent.lock) {
				Thread.yield();
				int count = dataQueue.size();
				if (count < 4) {
					// We now have less than 3 items on the queue so add a new one
					dataQueue.add(new Object());
					//System.out.println(name + ": Adding an object, size is " + dataQueue.size());
				}
			}			
			Thread.yield();
		}
	}

}

