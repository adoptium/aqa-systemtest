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
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import net.adoptopenjdk.test.nio2.util.DirectoryTools;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.ReiserSpotter;

public class WalkFileTreeTest extends TestCase {
	private static List<Path> files = null;
	private static final Path WALKFILETREE_FILE_DIR = Paths.get("walkfiletree_files");
	private static final Path WALKFILETREE_EMPTY_DIR = Paths.get("walkfiletree_empty_files");
	private static final int NUMBER_OF_FILES = 10;
	
	// Create all of these files upfront so that we try not to hammer the file system too much.	
	// We have kept up the frequent use of the walkFileTree by putting a call in the setUp()
	// method, which means we are constantly walking this directory each time the test is run. 
	static {	
		try {
			
			if (Files.exists(WALKFILETREE_FILE_DIR)) { 
				DirectoryTools.deleteDirectory(WALKFILETREE_FILE_DIR);
			}
			
			files = staticCreateFiles(WALKFILETREE_FILE_DIR, NUMBER_OF_FILES);
			
			if (Files.exists(WALKFILETREE_EMPTY_DIR)) { 
				DirectoryTools.deleteDirectory(WALKFILETREE_EMPTY_DIR);
			}
			
			Files.createDirectories(WALKFILETREE_EMPTY_DIR);
			
		} catch (IOException e) {
			// Print the exception, so we can diagnose the problem.
			e.printStackTrace();
		}	
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		// Check that we created the right number of files
		assertEquals("All the files that should have been pre-created for this test are not available",
				NUMBER_OF_FILES, files.size());
		
		// Check that we can list the right number of files
		List<Path> filesFound = DirectoryTools.listFiles(WALKFILETREE_FILE_DIR);
		if(!ReiserSpotter.getIsReiser()){
			assertEquals("The number of files counted in the target files directory was incorrect. Found: " + Arrays.toString(filesFound.toArray()),
				NUMBER_OF_FILES, DirectoryTools.listFiles(WALKFILETREE_FILE_DIR).size());
		}
		HangNotifier.ping();		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	public void testWalkFileTreeMultiple() throws IOException {		
		final int ITERATIONS = 1000;
		Path newDirectory = WALKFILETREE_FILE_DIR;	
		for (int counter=0; counter< ITERATIONS; counter++) {		
			HangNotifier.ping();	
			final List<Path> visitorFiles = new LinkedList<Path>();		
			// Check that we keep returning the same set of files!
			Files.walkFileTree(newDirectory, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
					if (path.toString().endsWith(".txt")) {
						visitorFiles.add(path);
					}
					return FileVisitResult.CONTINUE;
				}
			});

			if(!ReiserSpotter.getIsReiser()){
				assertEquals("Wrong number of files walked on iteration " + counter, NUMBER_OF_FILES, visitorFiles.size());
			}		
		}	
	}
	
	// Check that walking an empty directory (as returned by getTemporaryDirectory(),)
	//  returns no files.
	public void testWalkFileTreeEmpty() throws IOException {
		Path newDirectory = WALKFILETREE_EMPTY_DIR;	
		final List<Path> visitorFiles = new LinkedList<Path>();
		
		// Have a look in an empty directory, should find nothing
		Files.walkFileTree(newDirectory, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
				visitorFiles.add(path);
				return FileVisitResult.CONTINUE;
			}
		});	
		assertEquals("FileVistor found some files in an empty directory", 0, visitorFiles.size());	
	}

	// Create the specific number of files in the specified directory.
	// Checks that the right number have been created using the FileVisitor  
	public static List<Path> staticCreateFiles(Path directory, int number) throws IOException {	
		if (directory == null) {
			throw new NullPointerException("Path passed to createFiles cannot be null");
		}
		
		FileAttribute<?>[] attrs = {};		
		Files.createDirectories(directory, attrs);
		assertTrue("Directory was not created", Files.exists(directory));	
		List<Path> files = new LinkedList<Path>();
		
		for (int counter = 0 ; counter < number ; counter++) {
			Path newFile = directory.resolve("file" + counter + ".txt");
			Files.createFile(newFile, attrs);
			assertTrue("File was not created", Files.exists(newFile));
			files.add(newFile);		
		}
		
		assertEquals("The number of files generated was not equal to the requested number", number, files.size());
		
		// Check via another means
		final List<Path> visitorFiles = new LinkedList<Path>();
		
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
				if (path.toString().endsWith(".txt")) {
					visitorFiles.add(path);
				}
				return FileVisitResult.CONTINUE;
			}
		});
		
		assertEquals("WalkFileTreeTest.staticCreateFiles() - The number of files created was not equal to the number seen using the FileVisitor. " +
				"FileVisitor found " + Arrays.toString(visitorFiles.toArray()) + " & we created " + Arrays.toString(files.toArray()) ,
				number, visitorFiles.size());
		
		return files;	
	}	
}
