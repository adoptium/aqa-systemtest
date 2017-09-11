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

package net.adoptopenjdk.test.nio2;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static String id = "net.adoptopenjdk.nio2.AllTests";

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.adoptopenjdk.nio2");
		//$JUnit-BEGIN$
		
		// ByteBufferMXBean tests
		suite.addTest(net.adoptopenjdk.test.nio2.mxbean.AllTests.suite());
		
		// FileSystems spi tests
		suite.addTest(net.adoptopenjdk.test.nio2.filesystem.AllTests.suite());
		
		// Socket channel tests
		suite.addTest(net.adoptopenjdk.test.nio2.asyncio.client.AllTests.suite());

		// File channel tests
		suite.addTest(net.adoptopenjdk.test.nio2.asyncio.file.AllTests.suite());
		
		// Path based tests
		suite.addTest(net.adoptopenjdk.test.nio2.path.AllTests.suite());
		
		//$JUnit-END$
		return suite;
	}

}
