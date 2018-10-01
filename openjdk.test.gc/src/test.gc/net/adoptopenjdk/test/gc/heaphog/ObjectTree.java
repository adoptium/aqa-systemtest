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
package net.adoptopenjdk.test.gc.heaphog;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**  
 * Description:
 * Test creates a large object tree and fill up the memory over time.
 */
public class ObjectTree {

	public static final int MAXIMUM_OBJECT_SIZE = 300*1024;
	
	public static final int MINIMUM_OBJECT_SIZE = 200*1024;
	
	private static int totalWorkingSpace = -1;
	
	private static int totalCreatedSpace = 0;
	
	private static final List<BigObject> objectList = new LinkedList<BigObject>();
	
	private static Random random = new Random(); 
	
	public static void runTest(final int workingSpaceSize) {
		setTotalWorkingSpaceIfNecessary(workingSpaceSize);
		
		verifyAnElement();
		
		int newAllocSize = getNewAllocSize();
		
		if(newAllocSize > 0) {
			BigObject object = new BigObject(newAllocSize);	
			object.verify();
			
			synchronized(objectList) {
				objectList.add(object);
			}
		}
		else {
			findAndReplaceSomething();
		}
	}

	private static void findAndReplaceSomething() {
		Random r = new Random();
		BigObject element;
		
		synchronized(objectList) {
			element = (BigObject)objectList.remove(r.nextInt(objectList.size()));
		}
		
		int size = element.size();
		element = null;
		
		BigObject newObject = new BigObject(size);
		
		newObject.verify();
		
		synchronized(objectList) {
			objectList.add(newObject);
		}
	}

	private static void verifyAnElement() {
		Random r = new Random();
		BigObject element = null;
		
		synchronized(objectList) {
			if(objectList.size() != 0) {
				element = (BigObject)objectList.get(r.nextInt(objectList.size()));
			}
		}
		
		if(element != null) {
			element.verify();
		}
	}

	private synchronized static void setTotalWorkingSpaceIfNecessary(final int workingSpaceSize) {
		if(totalWorkingSpace == -1) {
			totalWorkingSpace = workingSpaceSize;
		}
	}
	
	// Returns Size in bytes that a thread should allocate and add to the list
	private synchronized static int getNewAllocSize() {
		if(totalCreatedSpace < totalWorkingSpace) {
			int newSize = MINIMUM_OBJECT_SIZE + random.nextInt(MAXIMUM_OBJECT_SIZE - MINIMUM_OBJECT_SIZE);
			
			// get the size of the heap
			long heapMaxSize = Runtime.getRuntime().maxMemory();
			
			// Get current size of heap in bytes
		    long heapSize = Runtime.getRuntime().totalMemory();

		    // Get amount of free memory within the heap in bytes. This size will increase
		    // after garbage collection and decrease as new objects are created.
		    long heapFreeSize = Runtime.getRuntime().freeMemory();
		    
		    // work out if there's enough space to create this object
		    // otherwise we'll go out of memory
		    long availableHeap = heapFreeSize + (heapMaxSize - heapSize);
		    if (availableHeap < newSize+25000000) { // Adding 25M as a buffer to prevent OOMs
		    	return 0;
		    }
		    
		    totalCreatedSpace += newSize;
			return newSize;
		}
		else {
			return 0;
		}
	}
	
	private static class BigObject {
		private byte[] data;	
		private byte value;
		
		public BigObject(int size) {
			data = new byte[size];
			
			Random random = new Random();
			
			byte[] randomByteData = new byte[1];
			random.nextBytes(randomByteData);
			value = randomByteData[0];
			
			for(int i=0;i!=size;i++)
			{
				data[i] = value;
			}
		}
		
		public void verify() {
			for(int i=0;i!=data.length;i++) {
				if(data[i] != value) {
					throw new RuntimeException("Data inconsistent. Element " + i + " of BigObject " + this + " should have been " + value + " but was  "  + data[i]);
				}
			}
		}
		
		public int size() {
			return data.length;
		}
	}
	
	public static void main(String args[]) {
		int size = new Integer(args[0]);
		for(int i=0;i!=1000000;i++) {
			if (i % 100 == 0) {
				System.out.print("...");
			}
			runTest(size);
		}
	}
}
