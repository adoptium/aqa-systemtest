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
 *   This java source file contains the DepleteMemory class, this class
 *   contains the logic to consume Memory until a OutOfMemory Exception is thrown 
 */

package net.adoptopenjdk.test.jdi.util;

import java.util.LinkedList;
import java.lang.*;

public class GenerateObjects implements Runnable {
	
	public void run() {
		generateObjects();
	}
	
	public void generateObjects()
	{
		// consume memory until an OutOfMemory is produced
		System.out.println("   Create Linked List To Own All Other Linked Lists");
		LinkedList<LinkedList> listOfLists = new LinkedList<LinkedList>();
		System.out.println("   Linked List Created");

		int objListCnt = 0;
		
		System.out.println("   **************************************************");
		System.out.println("   Create Object Linked List Created");
		LinkedList<Object> listOfObjects = new LinkedList<Object>();
		System.out.println("   Object Linked List Created");
		
		System.out.println("");
			
		System.out.println("   Add 1000 Objects To The List...");
		System.out.print("   ");
		for(int i=1; i <=1000; i++) {
			System.out.print(".");	
			
			if (i % 50 == 0) {
				System.out.println("");
				System.out.print("   ");
			}
				
			listOfObjects.add(new Object());
		}

		System.out.println("");
			
		System.out.println("   Objects Added");
			
		System.out.println("");
		System.out.println("   " + objListCnt + " Object Lists Created And Filled");
		System.out.println("   Add Object Link List To Inital Link List");
		listOfLists.add(listOfObjects);
		System.out.println("   Object Link List Added");
		System.out.println("");
		System.out.println("   **************************************************");
		System.out.println("");
		System.out.println("");
		
	}
}