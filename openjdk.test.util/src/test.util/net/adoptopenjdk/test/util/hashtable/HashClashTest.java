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
 * File:    HashClashTest.java
 * Package: net.adoptopenjdk.test.util.hashtable
 */
   
package net.adoptopenjdk.test.util.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

/**
 *  Description:
 *  Fills a hashtable with aprox 10k string key/value pairs, where the key strings
 *  have been designed to cause clashes in the default hashing algorithm. The JVM should
 *  switch to an alternate hashing algorithm when too many clashes occur. The number of
 *  clashes after which the switch occurs is controlled by a parameter
 *  (currently not tested/modified), but is around 500 clashes, so this test should force
 *  the switch to occur. For more details, see the javadoc for HashMap. 
 *  @see java.util.HashMap
 */
public class HashClashTest extends TestCase {

	static String[] clashData = new String[1];
	
	/**
	 * Load the data to cause clashes in the hash table. This is approx
	 * 300k.
	 */
	static {
		String defaultConfigurationFile = "java_payload_strings.txt";
		InputStream resourceInputStream = HashClashTest.class.getResourceAsStream(defaultConfigurationFile);
		if (resourceInputStream == null) {
			System.err.println("Failed to load clashData for HashClashTest from file " + defaultConfigurationFile);
			clashData = null;
		} else {
			BufferedReader br = new BufferedReader(new InputStreamReader(resourceInputStream));
			String line = null;
			ArrayList<String> lines = new ArrayList<String>();
			try {
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
	
			} catch (IOException e) {
				clashData = null;
				System.err.println("Failed to load clashData for HashClashTest: " + e.getMessage());
				e.printStackTrace(System.err);
			} finally {
				try {
					br.close();
				} catch (IOException e) {
		
				}
			}
			
			clashData = lines.toArray(clashData);
		}
				
	}

	public void testClashes() {

		if (clashData == null) {
			// loading the clash data failed so the test is borked
			Assert.fail("HashClashTest failed as clash data was not loaded");
			return;
		}
		
		Map<String, String> m = new HashMap<String, String>();
		List<String> l = new LinkedList<String>();
		for (String line : clashData) {
			m.put(line, line);
			l.add(0, line);
		}

		Iterator<String> iter = l.iterator();
		while (iter.hasNext()) {
			String msg = iter.next();
			if (!m.containsKey(msg)) {
				Assert.fail("Hashmap doesn't contain expected key " + msg);
				return;
			}
		}
	}

}
