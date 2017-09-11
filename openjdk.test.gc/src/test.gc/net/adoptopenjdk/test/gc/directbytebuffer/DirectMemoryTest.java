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
package net.adoptopenjdk.test.gc.directbytebuffer;

import java.nio.*;
import junit.framework.*;

/** 
 * Description:
 * The test allocates direct memory ByteBuffers and dereferences them.
 */
public class DirectMemoryTest extends TestCase {
	public static void testDirectMemory() {
		try {
			int ITERATIONS = 90;
			int ALLOC_SIZE = 10000000; // 10Mbytes

			ByteBuffer[] bbStore = new ByteBuffer[ITERATIONS];
			Runtime r = Runtime.getRuntime();

			System.out.println("Total memory is: " + r.totalMemory());
			System.out.println("Initial free memory: " + r.freeMemory());
			int i;
			for (i = 0; i < ITERATIONS; i++) {

				System.out.println("Iteration: " + i + " Total memory is: "
						+ r.totalMemory() + "Initial free memory: "
						+ r.freeMemory());
				bbStore[i] = ByteBuffer.allocateDirect(ALLOC_SIZE);
				// *** dereference to allow GC
				bbStore[i] = null;
			}
			
			assertTrue(i==ITERATIONS);
			
		} catch (Exception e) {
			System.out.println("Caught Exception: \n" + e);
			fail("Exception::"+e);
		}
	}
}
