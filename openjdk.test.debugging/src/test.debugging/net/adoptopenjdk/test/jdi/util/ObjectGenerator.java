/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

/*
 * Description:
 *   This java source file contains the MemoryConsumer class, this class
 *   consumes the Memory until a OutOfMemory Error is thrown 
 */

package net.adoptopenjdk.test.jdi.util;


public class ObjectGenerator extends RasTool{
	
	public ObjectGenerator(Runnable task, String threadName) {
		super(task, threadName);
	}

	public static void main(String[] args) {
		
		// Check the correct number of arguments have been passed
		if (args.length != 0 && args.length != 2 && args.length != 3 && args.length != 4) {
			System.out.println(" Error: Incorrect Number Of Arguements Supplied");
			System.out.println("");
			usage();
		}

		GenerateObjects generatorTask = new GenerateObjects();
		String threadName = "Object Generator";
		
		ObjectGenerator generator = new ObjectGenerator(generatorTask, threadName);
		boolean testStarted = generator.runTest(args, 0);
		
		if(testStarted == false){
			usage();
		}
	}
	
	protected static void usage() {
		System.out.println("");
		System.out.println(" Usage: ");
		System.out.println("   java net.adoptopenjdk.test.jdi.util.ObjectGenerator <testType> <testArgs>");
		System.out.println("");
		System.out.println("   testType - multi-thd");
		System.out.println("   If no value is provided for the testType, memory will be consumed");
		System.out.println("   in the specified memory area on a thread of the specified type");
		System.out.println("");
		System.out.println("   The testArgs to supplied for each testType are below:");
		System.out.println("   multi-thd:");
		System.out.println("      threadCnt  - the number of threads the Consumer will start");
		System.out.println("");
		System.exit(0);
	}
}