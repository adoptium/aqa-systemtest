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
package net.adoptopenjdk.test.gc.annotations;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 * The JVM uses Soft references for its internal annotation cache, so if we force the garbage
 * collector to free soft references then the annotation cache should be cleared out. If we then
 * retrieve some annotations these annotations will then repopulate the cache and we should get
 * back a different object reference of the annotation which was retrieved prior to the GC running.
 * To force the GC to clear soft references we need to nearly exhaust the available heap memory.
 * This can easily be done by allocating a lot of hard references within a loop.
 * 
 * The loop will exit when a soft reference becomes null, as this indicates that GC has collected
 * it because the JVM was close to running out of memory.
 * 
 * When the SoftReference.get() method is called, a temporary reference to the real object is created,
 * which makes it hard-reachable, and hence not eligible for GC. To ensure that this doesn't leave
 * a timing hole in which the JVM can really run out of memory, multiple SoftReferences are used. If
 * one of them is hard-reachable, the others should still only be softly-reachable, eligible for GC,
 * and hence provide the desired buffer against OOM errors.
 * 
 * This test is designed to be run in a thread along side the annotation tests as it does
 * nothing much useful on its own.
 */
public class ForceGC extends TestCase {
    private static int referenceCount = 10; // How many soft references to create
    private static int arraySize = 20; // The size in mb of the arrays contained in the soft references

	public ForceGC(String name)	{
		super(name);		
	}  
	
	public void testForceGC() {		
		List<Object> list1 = new LinkedList<Object>();
		List<SoftReference<OneMB[]>> references = new ArrayList<SoftReference<OneMB[]>>();

	    ReferenceQueue<? super Object[]> refQ = new ReferenceQueue<Object>();

		// Allocate 20mb object arrays, wrapped in soft references
		for (int i = 0; i< referenceCount; i++) {
			OneMB[] objects = new OneMB[arraySize];
			for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
				objects[arrayIndex] = new OneMB();
			}

			SoftReference<OneMB[]> ref = new SoftReference<OneMB[]>(objects, refQ);
			references.add(ref);
		}
		
		while (!referencesGone(references)) {				
			// Run the heap OOM so all soft references will be cleared by the GC 
			list1.add(new Object());
		}
		
		// At least one soft reference has been cleared. Make list1 eligible for GC 
		list1 = null;
		
		// Check that the the cleared soft reference was added to the queue.
		while (null == refQ.poll());
	}

	// Loop through all the references in the reference list.
	// If any of the references has become null, then return true.
	public boolean referencesGone(List<SoftReference<OneMB[]>> references) {
		for (SoftReference<OneMB[]> ref : references) {
			if (ref.get() == null) {
				return true;
			}
		}
		return false;
	}
}
