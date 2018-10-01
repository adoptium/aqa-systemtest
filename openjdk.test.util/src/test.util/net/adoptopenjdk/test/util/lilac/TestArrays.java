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
/**
 * File:    CalendarTest.java
 * Package: net.adoptopenjdk.test.util.lilac */
   
package net.adoptopenjdk.test.util.lilac;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

import junit.framework.TestCase;

public class TestArrays extends TestCase {

	Object i = "A";
	Object k = "BB";

	public void test() throws Exception{
		
		Vector<Object> vector = new Vector<Object>();
		ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(50000);

		Random myRandom = new Random();
		for (int j = 0; j<50000; j++){
			if (myRandom.nextInt(2) == 0){
				vector.add(i);
				queue.offer(i);
			}
			else{
				vector.add(k);
				queue.offer(k);
			}
		}
		
		assertTrue(Arrays.equals(vector.toArray(), queue.toArray()));
		
	}
	
}
