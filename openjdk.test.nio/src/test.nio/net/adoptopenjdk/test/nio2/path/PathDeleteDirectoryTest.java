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

package net.adoptopenjdk.test.nio2.path;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.ReiserSpotter;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

public class PathDeleteDirectoryTest extends TestCaseWithTempDirectory {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		HangNotifier.ping();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	public void testDeleteDirectory() throws IOException, StfException {	
		Path temp = getTemporaryDirectory();
		Path newDirectory = temp.resolve("newdir");
		
		// Use both exists/notExists
		assertTrue("Directory already exists", Files.notExists(newDirectory));
		assertFalse("Directory already exists", Files.exists(newDirectory));
		
		// Create dir
		FileAttribute<?>[] attrs = {};
		Files.createDirectory(newDirectory);
		assertFalse("Directory was not created", Files.notExists(newDirectory));
		assertTrue("Directory was not created", Files.exists(newDirectory));
		
		// Create files in directory.
		Path newFile = newDirectory.resolve("file1");
		assertTrue("File already exists", Files.notExists(newFile));
		Files.createFile(newFile, attrs);
		assertTrue("File was not created", Files.exists(newFile));
		
		// Attempt to delete directory, and fail as it's not empty
		try {
			Files.delete(newDirectory);
			assertTrue("Directory should not have been able to be deleted", Files.exists(newDirectory));
		} catch (DirectoryNotEmptyException e) {
			// Good
		}

		try {
			Files.deleteIfExists(newDirectory);
			assertTrue("Directory should not have been able to be deleted", Files.exists(newDirectory));
		} catch (DirectoryNotEmptyException e) {
			// Good
		}

		Files.delete(newFile);
		assertTrue("File wasn't deleted", Files.notExists(newFile));
		// Should do nothing
		Files.deleteIfExists(newFile);
	
		try{
			okForCleanup();
		}
		catch(NoSuchFileException e){
			if(ReiserSpotter.getIsReiser()){
				try{
					okForCleanup();
				}
				catch(NoSuchFileException e2){
				}
			}else{
				throw e;
			}
		}		
	}	
}
