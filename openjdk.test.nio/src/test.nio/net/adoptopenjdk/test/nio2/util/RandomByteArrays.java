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

package net.adoptopenjdk.test.nio2.util;

import java.util.HashMap;
import java.util.Random;

import junit.framework.TestCase;

/**
 * A class to pre-populate a map of string to return of various sizes, to avoid tests
 *  having to wait on the random.nextBytes function returning suitable random strings.
 */

public class RandomByteArrays extends TestCase {

	public static String id = "net.adoptopenjdk.nio2.util.RandomMessages";

	// 24 Will create a string up to 8Mb in size, which should be plenty
	// 16 Will create up to 32kb, which is relatively small in enterprise terms
	private static final int MAX_LENGTH = 16;
	public static final int MAX = 1<<MAX_LENGTH;
	
	static {
		byteArrayMap = new HashMap<Integer, byte[]>();
		random = new Random(System.currentTimeMillis());
		generateNewRandomByteArrays();
		randomByteLengths = new int[MAX_LENGTH+1];
	}
		
	// Test method to see how long it takes to generate a set of random data,
	// and how large that dataset is.
	public static void main(String[] args) {
		generateNewRandomByteArrays();
		long totalSize = 0;
		for(Integer i: byteArrayMap.keySet()) {
			totalSize = totalSize + byteArrayMap.get(i).length;
		}		
	}
	
	public void testRandomByteArrays() { 		
		byte[] bytes; 
		for (int i=0; i<MAX_LENGTH; i++) {
			bytes = getRandomByteArray(1<<i);
			assertEquals(1<<i, bytes.length);
			
			if (i>2) {
				bytes = getRandomByteArray((1<<i) -1);
				assertEquals(1<<i, bytes.length);
			}
			if (i < MAX_LENGTH-1) {
				bytes = getRandomByteArray((1<<i) +1);
				assertEquals(1<<(i+1), bytes.length);
			}
		}
		
		bytes = getRandomByteArray((1<<(MAX_LENGTH-1))+1);
		assertEquals(1<<(MAX_LENGTH-1), bytes.length);		
	}
	
	public static synchronized void generateNewRandomByteArrays() {
		for (int length=0; length<MAX_LENGTH; length++) {
			byte[] bytes = new byte[1<<length];
			random.nextBytes(bytes);
			byteArrayMap.put(length,bytes);
		}
	}
	
	private static int access_counter = 0;
	
	public static synchronized byte[] getRandomByteArray(Integer length) {
		if (access_counter++ > regenerateAfter) {
			generateNewRandomByteArrays();
			access_counter = 0;
		}

		int index = getNextHighestPowerOfTwo(length);
		byte[] array;
		if (index >= MAX_LENGTH) {
			index = MAX_LENGTH -1;
		}
		array = byteArrayMap.get(index);
		randomByteLengths[index]++;

		return array;
	}
		
	// Use some logarithms to work out the power of two of this number,
	//  and return the next highest number.
	private static int getNextHighestPowerOfTwo(int number) {
		return (int)Math.ceil(Math.log(number)/Math.log(2));
	}
		 
	// The method returns a random string of the randomly created strings generated
	public static synchronized byte[] getRandomByteArray() {
		return getRandomByteArray(1<<(random.nextInt(MAX_LENGTH) + 1));
	}
	
	// Used to randomise the string returned
	private static Random random;

	// Used to make sure that we don't keep sending the same strings all the time
	private static long regenerateAfter = 100;
	
	// Our collection
	private static HashMap<Integer, byte[]> byteArrayMap;
	
	private static int[] randomByteLengths;
}
