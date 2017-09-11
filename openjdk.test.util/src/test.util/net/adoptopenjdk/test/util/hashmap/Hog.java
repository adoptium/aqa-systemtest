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
/**
 * File:    Hog.java
 * Package: net.adoptopenjdk.test.util.hashmap
 */
   
package net.adoptopenjdk.test.util.hashmap;

import java.util.*;

public class Hog {
	private static int cnt;

	private class Hoglet {

		private Map<Integer,Hog.Hoglet> hmap = new HashMap<Integer,Hog.Hoglet>();

		public Hoglet (int depth) {
			cnt++;
			for (int n=0;n<depth;n++) {
				hmap.put(new Integer(n), new Hog.Hoglet(depth-1));
			}
		}
	}

	public void run () {
		int initDepth = 1;
		int indx = 5; // Maybe create a random number?
		
		try {
			for (int i=0; i<indx; i++) {
				long free1 = Runtime.getRuntime().freeMemory();
				new Hog.Hoglet(initDepth);
				long free2 = Runtime.getRuntime().freeMemory();
				System.out.print("Created Hogs : "+ cnt);
				System.out.println("Free memory dropped by : " + (free1-free2));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
} 
