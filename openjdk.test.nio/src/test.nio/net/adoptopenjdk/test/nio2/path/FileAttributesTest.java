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

package net.adoptopenjdk.test.nio2.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.environment.PlatformFinder; 
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

public class FileAttributesTest extends TestCaseWithTempDirectory {
	public void testFileAttributes() throws IOException, StfException{	
		for (int counter = 0; counter < 1000; counter++) {		
			Path file = getTemporaryDirectory().resolve("file" + counter + ".txt");
			assertFalse(file.toAbsolutePath() + " already exists", Files.exists(file));
			
			long lowerCreationTime = System.currentTimeMillis();
			
			Files.newOutputStream(file, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
			
			IOException thrown = null;
			try {
				Files.newOutputStream(file, StandardOpenOption.CREATE_NEW);
			} catch (IOException ioe) {
				thrown = ioe;
			}
			
			assertNotNull("CREATE_NEW did not throw an exception when the file already existed", thrown);
			assertTrue("CREATE_NEW did not throw a FileAlreadyExistsException when the file already existed",
					thrown instanceof java.nio.file.FileAlreadyExistsException);
			
			BasicFileAttributes bfAttr = Files.readAttributes(file, BasicFileAttributes.class);
			
			if (PlatformFinder.isWindows()) {
				// Creation time is not available on unix file systems
				assertNotNull("Creation Time of the file returned null, value expected on Windows",
						bfAttr.creationTime());
				
				long creationTime = bfAttr.creationTime().toMillis();

				long upperCreationTime = System.currentTimeMillis();

				boolean createdWithinBounds = false;
				if (creationTime <= upperCreationTime && creationTime >= lowerCreationTime) {
					createdWithinBounds = true;
				} else {
					System.out.println(file.toAbsolutePath());
					if (creationTime < lowerCreationTime) {
						System.err.println("Creation time was lower than the lower bound");
						System.err.println(" by " + ((float)(lowerCreationTime - creationTime))/1000 + "s");
						System.err.println("Created at:     " + creationTime);
						System.err.println("which is before " + lowerCreationTime);
					}

					if (creationTime > upperCreationTime) {
						System.err.println("Creation time was larger than the upper bound");
						System.err.println(" by " + ((float)(creationTime - upperCreationTime))/1000 + "s");
						System.err.println("Created at:     " + creationTime);
						System.err.println("which is after  " + upperCreationTime);
					}

				}
		
				assertTrue("File did not return a timestamp consistent with when it was created. Actual " + creationTime +
						" expected between " + lowerCreationTime + " & " + upperCreationTime,
						createdWithinBounds);
			}
			
			// These should be available on all systems
			assertNotNull("Last Access Time of the file returned null", bfAttr.lastAccessTime());
			assertNotNull("Last Modified Time of the file returned null", bfAttr.lastModifiedTime());
					
			Files.delete(file);
			assertFalse(Files.exists(file));
		}
		
		// If we have made it this far, we must be done
		okForCleanup();
	}
}
