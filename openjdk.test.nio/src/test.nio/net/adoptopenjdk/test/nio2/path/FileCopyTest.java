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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Random;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.environment.PlatformFinder;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

public class FileCopyTest extends TestCaseWithTempDirectory{
	public void testFileCopy() throws IOException, StfException{
		Path tempDir = getTemporaryDirectory();
		// Create a file
		Path newFilename1 = Paths.get("filecopy1.txt");
		Path originalFile = tempDir.resolve(newFilename1);
		Files.createFile(originalFile);
		assertTrue("File was not created", Files.exists(originalFile));
		
		// Read the initial set of basic attributes
		BasicFileAttributes attrs = Files.readAttributes(originalFile, BasicFileAttributes.class);
		FileTime refCreationTime = attrs.creationTime();
		FileTime refLastModifiedTime = attrs.lastModifiedTime();
		FileTime refLastAccessTime = attrs.lastAccessTime();

		// Check that it keeps returning the same information
		for (int index = 1; index < 10; index++) {
			// Depending on the implementation, this may have cached the last one, who knows
			BasicFileAttributes comparissonAttrs = Files.readAttributes(originalFile, BasicFileAttributes.class);
			assertEquals("On pass " + index + " the creationTime() return value changed for the reference file",
					refCreationTime, comparissonAttrs.creationTime());
			assertEquals("On pass " + index + " the lastModifiedTime() return value changed for the reference file",
					refLastModifiedTime, comparissonAttrs.lastModifiedTime());
			assertEquals("On pass " + index + " the lastAccessTime() return value changed for the reference file",
					refLastAccessTime, comparissonAttrs.lastAccessTime());
		}
		
		// Wait a short period, then try copying the file without file attributes
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Path newFilename2 = Paths.get("filecopy2.txt");
		Path newFile2 = tempDir.resolve(newFilename2);
		
		assertFalse("Target file already exists", Files.exists(newFile2));
		Files.copy(originalFile, newFile2);
		assertTrue("Copied file does not exist", Files.exists(newFile2));
		
		BasicFileAttributes attrs2 = Files.readAttributes(newFile2, BasicFileAttributes.class);

		// Creation time is a windows only property:
		if (PlatformFinder.isWindows()) {
			// Check that the file has changed it's creation time
			assertNotSame(attrs.creationTime(), attrs2.creationTime());
		}
		
		Files.delete(newFile2);
		assertFalse("Unable to delete copied file", Files.exists(newFile2));

		// Wait a while, then try copying the file with file attributes
		try {
			Random rand = new Random();
			Thread.sleep((long)rand.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Path newFilename3 = Paths.get("filecopy3.txt");
		Path newFile3 = tempDir.resolve(newFilename3);
		
		Files.copy(originalFile,newFile3, StandardCopyOption.COPY_ATTRIBUTES);
		assertTrue("Copied file with attributes does not exist", Files.exists(newFile3));
		
		BasicFileAttributes attrs3 = Files.readAttributes(newFile3, BasicFileAttributes.class);
		
		// It seems the only thing we can be sure of is 
		// that the modification time is the same
		assertEquals("The modification time on the original and copy was not the same",
				refLastModifiedTime, attrs3.lastModifiedTime());
		okForCleanup();
	}
	
	public void FileCopyWithOverwrite() throws IOException, StfException {
		
		String FILE_1_CONTENTS = "filecopy1";
		String FILE_2_CONTENTS = "filecopy2";
		
		Path tempDir = getTemporaryDirectory();
		
		// Create a file
		Path newFilename1 = Paths.get("filecopy1.txt");
		Path newFile1 = tempDir.resolve(newFilename1);
		Files.createFile(newFile1);
		assertTrue("File was not created", Files.exists(newFile1));

		// Create a second file
		Path newFilename2 = Paths.get("filecopy2.txt");
		Path newFile2 = tempDir.resolve(newFilename2);
		Files.createFile(newFile2);
		assertTrue("File was not created", Files.exists(newFile2));
		
		// Write something to file1 and file2 so that we can check the operation succeeded
		PrintStream printStream1 = new PrintStream(Files.newOutputStream(newFile1,StandardOpenOption.WRITE));
		printStream1.println(FILE_1_CONTENTS);
		printStream1.close();

		PrintStream printStream2 = new PrintStream(Files.newOutputStream(newFile2,StandardOpenOption.WRITE));
		printStream2.println(FILE_2_CONTENTS);
		printStream2.close();
		
		Files.copy(newFile1,newFile2, StandardCopyOption.REPLACE_EXISTING);
		
		InputStreamReader input = new InputStreamReader(Files.newInputStream(newFile2, StandardOpenOption.READ));
		BufferedReader bufferedInput = new BufferedReader(input);
		
		String contents = bufferedInput.readLine();
		
		assertEquals("File contents of the overwritten file did not match the source", FILE_1_CONTENTS, contents);
		
		bufferedInput.close();		
		okForCleanup();
	}
	
	public void PrintFileDetails() throws IOException, StfException {
		Path tempDir = getTemporaryDirectory();

		// Create a file
		Path newFilename1 = Paths.get("original.txt");
		Path originalFile = tempDir.resolve(newFilename1);
		Files.createFile(originalFile);
		
		for (int index = 0; index < 10; index++) {
		
			Path newFilename = Paths.get("filecopy" + index + ".txt");
			Path newFile = tempDir.resolve(newFilename);
			
			// Wait a while, then try copying the file with file attributes
			try {
				Random rand = new Random();
				Thread.sleep((long)rand.nextInt(4000) + 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Files.copy(originalFile, newFile, StandardCopyOption.COPY_ATTRIBUTES);
		}
		
		fail("Failing so we get printout");
		okForCleanup();
	}
}

