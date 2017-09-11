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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import junit.framework.TestCase;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.environment.PlatformFinder;

/**
 *  Provides a JUnit testcase with a temporary directory to use, which is then cleaned up if we call the 
 *   okForCleanup() method. This uses the NIO2 FileVisitor functionality to easily iterate over the files, 
 *   also a number of Path based operations, including .deleteDirectory() etc.
 */
public abstract class TestCaseWithTempDirectory extends TestCase{

	private Path temporaryDirectory = null;

	protected static int thisInstance;
	
	protected static Random random = null;
		
	static {
		random = new Random();
		thisInstance = 0;
	}
	
	protected TestCaseWithTempDirectory() {
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	protected Path getRootTempDirectory() {
		return temporaryDirectory;
	}

	protected void okForCleanup() throws IOException, StfException {
		// If we are on Windows, it doesn't like deleting directories if there is a possibility
		// that someone else in in them.
		if (PlatformFinder.isWindows()) {
			// Don't delete the directory, it can't handle it
		} else {
			DirectoryTools.deleteDirectory(temporaryDirectory);
		}
	}
	
	protected Path getTemporaryDirectory() throws IOException {		
		int instance;
		synchronized (TestCaseWithTempDirectory.class) {
			instance = thisInstance;
			thisInstance++;
		}
		
	    String tempDir = 
	        String.format("%s_0x%08x-%d", this.getClass().getSimpleName(),
	                System.identityHashCode(TestCaseWithTempDirectory.class),
	                instance);
	    
		temporaryDirectory = DirectoryTools.createTemporaryDirectory(Paths.get(tempDir));		
		return temporaryDirectory;		
	}

	protected void cleanUpTemporaryDirectory(Path dir) throws IOException {
		DirectoryTools.deleteDirectory(dir);		
	}
}
