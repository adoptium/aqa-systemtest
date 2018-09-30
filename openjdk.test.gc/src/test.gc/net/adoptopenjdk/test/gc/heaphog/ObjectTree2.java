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
import java.util.Random;

/** 
* Description:
*   Modification of ObjectTree, designed to fill the heap but leave a specified
*   space, rather than fill a specified space. Should allow the heap to be quickly
*   filled to allow testing of large heaps. 
*/
public class ObjectTree2 {

	/** The minimum amount of free space on the heap that should be left */
	public static final int minFreeSpaceMB = 512;

	/** The maximum percentage of the heap that will be filled */
	public static final int minFreePercent = 20;

	public static final int MAXIMUM_OBJECT_SIZE = 1000*1024;
	
	public static final int MINIMUM_OBJECT_SIZE = 200*1024;
	
	private static long totalWorkingSpace = -1;
	
	private static int replaceSize = 0;
	
	private static final LinkedList<BigObject> objectList = new LinkedList<BigObject>();
	
	private static Random random = new Random();
	
	private static boolean firstRun = true;
	
	private static boolean doingSetup = false;

	public static void runTest() {
		// A single thread does setup. While this is happening
		// all other threads become no-ops, to avoid bottle necks.
		boolean doSetup = false;		
		synchronized (ObjectTree2.class){
			if (firstRun) {
				firstRun = false;
				doSetup = true;
				doingSetup = true;
			}
		}
		
		if (doSetup) {
			setup();
			doingSetup = false;
		}
		
		if (doingSetup) {
			return;
		}
			
		verifyAnElement();
		
		findAndReplaceObjects();
	}

	// Aim to replace 0.1% of the heap each time
	private static void findAndReplaceObjects() {
		Random r = new Random();		
		BigObject element;
		int replaced = 0;
	
		while (replaced < replaceSize) {
			synchronized(objectList) {
				int size = objectList.size();
				if (size == 0) {
					return;
				}
				element = (BigObject)objectList.remove(r.nextInt(size));
			}
			
			int size = element.size();
			element = null;
			
			BigObject newObject = new BigObject(size);
			
			newObject.verify();
			
			synchronized(objectList)
			{
				objectList.add(newObject);
			}
			replaced = replaced + size;
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

	// Work out how much space should be used by this test, and how
	// much should be left free. The greater of minFreeSpaceMB and
	// minFreePercent will be left free.
	// For example, if the heap size
	// is 1GB, minFree is 512MB and minPercent is 20% then 512 will be
	// left free, rather than 20% which would be 200mb.
	// If the heap size 10GB, then 20% (i.e. 2GB) would be left free
	// rather than 512MB
	private static void setFreeSpace() {
		// get the size of the heap
		long heapMaxSize = Runtime.getRuntime().maxMemory();		
		long workingSpace = heapMaxSize - (minFreeSpaceMB * 1024 * 1024);
		
		if (workingSpace < 0) {
			throw new RuntimeException("Requested freeSpace: " + minFreeSpaceMB
					+ "MB is more than the available heap: " + heapMaxSize + " bytes."
					+ " Re-run on a machine with more available java heap");
		}
		
		long workingSpace2 = (heapMaxSize * (100 - minFreePercent)) / 100;
		if (workingSpace2 < workingSpace) {
			workingSpace = workingSpace2;
		}
		totalWorkingSpace = workingSpace;
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
			for(int i=0;i!=data.length;i++)
			{
				if(data[i] != value)
				{
					throw new RuntimeException("Data inconsistent. Element " + i + " of BigObject " + this + " should have been " + value + " but was  "  + data[i]);
				}
			}
		}
		
		public int size() {
			return data.length;
		}
	}
	
	public static void main(String args[]) {
		for(int i=0;i!=1000000;i++) {
			if (i % 100 == 0) {
				System.out.print("...");
			}
			if (i % 1000 == 0) {
				System.out.print("\n");
			}
			runTest();
		}
	}

	// Work out how much space we have to play in and fill most of this
	// up front to give us a kick start. 
	public static void setup() {
		setFreeSpace();				
		System.out.println("Going to fill " + totalWorkingSpace + " bytes of the heap");
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		System.out.println("going to leave " + (heapMaxSize - totalWorkingSpace) + " free");
		long createdSize = totalWorkingSpace;
		
		while (createdSize > 0) {	
			int newSize = MINIMUM_OBJECT_SIZE + random.nextInt(MAXIMUM_OBJECT_SIZE - MINIMUM_OBJECT_SIZE);
			BigObject object = new BigObject(newSize);
			
			object.verify();
			
			synchronized(objectList) {
				objectList.add(object);
			}						    
			createdSize = createdSize - newSize;		    
		}
		
		replaceSize = (int)(totalWorkingSpace / 1000);
		System.out.println("Each iteration will replace approx " + replaceSize + " bytes of the heap");	
	}
}
