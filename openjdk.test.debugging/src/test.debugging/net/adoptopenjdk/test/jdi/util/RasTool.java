/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

/* 
 * Description:
 *   This java source file contains the RasTool class, this class
 *   is the base class for the Ras Tools 
 */

package net.adoptopenjdk.test.jdi.util;


public class RasTool{

	protected Runnable task;
	protected String threadName;
	
	public RasTool(Runnable task, String threadName) {
		super();
		this.task = task;
		this.threadName = threadName;
	}
	
	protected void runTask() {
		// Create a thread to deplete memory in the heap memory area  
		startJavaThread(threadName);
	}

	protected void runTaskOnMultipleThreads(int threadCnt) {
		for (int i=0; i < threadCnt; i++) {
			startJavaThread(threadName + " " + i);
		}
	}
	
	protected void startJavaThread(String thdName) {
		System.out.println(" Create A Java Thread - " + thdName);
		Thread thread = new Thread(task);    		
		thread.setName(thdName + " (thread_type=Java)");

		// Start the thread
		System.out.println(" Start Java Thread - " + thdName);
		thread.start();
	}

	protected boolean runTest(String[] args, int testIndex) {
		boolean testStarted = false;
		if (args.length > testIndex) {
			
			if (args[testIndex].compareToIgnoreCase("multi-thd") == 0) {
				int index = testIndex + 1;
				if(args.length - testIndex != 2) {
					System.out.println("ERROR: Incorrect Number Of Arguments Supplied");
					return false;
				}
				
				int threadCnt = 0;
				try {
					
					threadCnt = Integer.parseInt(args[index]);
					
				} catch (NumberFormatException e) {
					
					System.out.println("ERROR: The Number Of Threads Argument Must Be A Positive Integer");
				}
				
				testStarted = true;
				runTaskOnMultipleThreads(threadCnt);
			}
			else {
				System.out.println("ERROR: The testType Argument must be either multi-thd, nested-mem or cactus-mem");
			}
		}
		else {
			testStarted = true;
			runTask();
		}
		
		return testStarted;
	}
	
	protected static void usage(){}; 
}