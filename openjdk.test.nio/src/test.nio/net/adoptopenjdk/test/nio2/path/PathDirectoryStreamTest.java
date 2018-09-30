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
import java.nio.file.DirectoryStream;
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

public class PathDirectoryStreamTest extends TestCase {
	private static List<Path> files = null;
	private static final Path DIRECTORY_STREAM_FILE_DIR = Paths.get("directory_stream_files");
	private static final int NUMBER_OF_FILES = 10;
	
	//  Create all of these files up front so that we try not to hammer the file system too much.
	//  We have kept up the frequent use of the walkFileTree by putting a call in the setUp()
	//  method, which means we are constantly walking this directory each time the test is run. 
	static {	
		try {		
			if (Files.exists(DIRECTORY_STREAM_FILE_DIR)) { 
				DirectoryTools.deleteDirectory(DIRECTORY_STREAM_FILE_DIR);
			}
			
			files = staticCreateFiles(DIRECTORY_STREAM_FILE_DIR, NUMBER_OF_FILES);
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
		List<Path> filesFound = DirectoryTools.listFiles(DIRECTORY_STREAM_FILE_DIR);

		if(!ReiserSpotter.getIsReiser()){
			assertEquals("The number of files counted in the target files directory was incorrect. Found: " + Arrays.toString(filesFound.toArray()),
					NUMBER_OF_FILES, DirectoryTools.listFiles(DIRECTORY_STREAM_FILE_DIR).size());
		}
		HangNotifier.ping();	
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}

	// Check that we can receive a directory stream that contains the 
	//  entire contents with the no arg method call
	public void testDirectoryStreamAllItems() throws IOException {	
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;	
		List<String> dirGlob = new LinkedList<String>();	
		DirectoryStream<Path> directoryContents = Files.newDirectoryStream(newDirectory);
		
		try {
			for (Path path: directoryContents) {
				// Just check we aren't getting hidden files
				if (path.toString().endsWith("txt")) {
					dirGlob.add(path.toString());
				}
			}
		} finally {
			directoryContents.close();
		}
		
		if(!ReiserSpotter.getIsReiser()){
			assertEquals("Checking for correct number of files return (no filter) found " + Arrays.toString(dirGlob.toArray()) +
					" actual total list is " + Arrays.toString(files.toArray()),
					NUMBER_OF_FILES, dirGlob.size());
		}	
	}

	// Check that we can receive the same number of elements from the  
	//  "*" glob pattern and the no arg method
	public void testDirectoryStreamNoGlobMatchesGlobAll() throws IOException {		
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;	
		DirectoryStream<Path> directoryContentsGlobAll = Files.newDirectoryStream(newDirectory,"*");	
		DirectoryStream<Path> directoryContentsNoGlob = Files.newDirectoryStream(newDirectory);	
	
		List<String> dirGlob = new LinkedList<String>();
		for(Path path: directoryContentsGlobAll) {
			dirGlob.add(path.toString());
		}

		List<String> dirNoGlob = new LinkedList<String>();
		for(Path path: directoryContentsNoGlob) {
			dirNoGlob.add(path.toString());
		}
		
		directoryContentsGlobAll.close();
		directoryContentsNoGlob.close();
		
		// Improved the error message to be more useful, and list all those entries found.
		if(!ReiserSpotter.getIsReiser()){
			if (!Arrays.equals(dirGlob.toArray(), dirNoGlob.toArray())) {
				fail("newDirectoryStream(*) and () did not return the same results: " + 
						Arrays.toString(dirGlob.toArray()) + " & " + Arrays.toString(dirNoGlob.toArray()));
			}
		}	
	}

	// Check that we can receive a directory stream that contains the 
	// entire contents with the all encompassing "*" glob
	public void testDirectoryStreamGlobAllItems() throws IOException {	
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;	
		List<String> dirGlob = new LinkedList<String>();	
		DirectoryStream<Path> directoryContents = Files.newDirectoryStream(newDirectory, "*");
		
		try {
			for (Path path: directoryContents) {
				// Just check we aren't getting hidden files
				if (path.toString().endsWith("txt")) {
					dirGlob.add(path.toString());
				}
			}
		} finally {
			directoryContents.close();
		}

		if(!ReiserSpotter.getIsReiser()){
			assertEquals("Checking for correct number of files return (globbed all) found " + Arrays.toString(dirGlob.toArray()) + 
					" actual total list is " + Arrays.toString(files.toArray()), NUMBER_OF_FILES, dirGlob.size());
		}		
	}

	// Check that we can receive a directory stream that contains the 
	//  a selected subset of the files with a glob
	public void testDirectoryStreamGlobSomeItems() throws IOException {		
		final int EXPECTED_NUMBER_OF_FILES = 1;
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;		
		List<String> dirGlob = new LinkedList<String>();		
		DirectoryStream<Path> directoryContents = Files.newDirectoryStream(newDirectory, "*1.txt");
		
		try {
			for (Path path: directoryContents) {
				dirGlob.add(path.toString());
			}
		} finally {
			directoryContents.close();
		}
		
		if(!ReiserSpotter.getIsReiser()){
			assertEquals("Checking for correct number of files return (globbed on ends in '1') found " + Arrays.toString(dirGlob.toArray()) +
					" actual total list is (from which we expect a subset)" + Arrays.toString(files.toArray()), 
					EXPECTED_NUMBER_OF_FILES, dirGlob.size());
		}		
	}
	
	// Check that we can receive a directory stream that contains the 
	//  entire contents with a unrestricted filter
	public void testDirectoryStreamFilterAllItems() throws IOException {		
		final int EXPECTED_NUMBER_OF_FILES = 10;
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;		
		List<String> dirGlob = new LinkedList<String>();		
		DirectoryStream<Path> directoryContents = Files.newDirectoryStream(newDirectory, new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				return true;
			}		
		});
		
		try {
			for (Path path: directoryContents) {
				dirGlob.add(path.toString());
			}
		} finally {
			directoryContents.close();
		}
		
		if(!ReiserSpotter.getIsReiser()){
			assertEquals("Checking for correct number of files return (filtered on all)  found " + Arrays.toString(dirGlob.toArray()) +
					" actual total list is " + Arrays.toString(files.toArray()), 
					EXPECTED_NUMBER_OF_FILES, dirGlob.size());
		}		
	}
	
	// Check that we can receive a directory stream that contains the 
	// selected subset with a filter
	public void testDirectoryStreamFilterSomeItems() throws IOException {		
		final int EXPECTED_NUMBER_OF_FILES = 1;
		Path newDirectory = DIRECTORY_STREAM_FILE_DIR;
		List<String> dirGlob = new LinkedList<String>();	
		DirectoryStream<Path> directoryContents = Files.newDirectoryStream(newDirectory, new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				if (entry.toString().endsWith("1.txt")) {
					return true;
				}
				return false;
			}		
		});
		
		try {
			for (Path path: directoryContents) {
				dirGlob.add(path.toString());
			}
		} finally {
			directoryContents.close();
		}
		
		if(!ReiserSpotter.getIsReiser()){
			assertEquals("Checking for correct number of files return (filtered on ends in '1')  found " + Arrays.toString(dirGlob.toArray()) +
					" actual total list is (from which we expect a subset)" + Arrays.toString(files.toArray()), 
					EXPECTED_NUMBER_OF_FILES, dirGlob.size());
		}
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

		if(!ReiserSpotter.getIsReiser()){
			assertEquals("The number of files generated was not equal to the requested number", number, files.size());
		}
		
		// Check via another means
		final List<Path> visitorFiles = new LinkedList<Path>();
		
		if(!ReiserSpotter.getIsReiser()){	
			Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
					if (path.toString().endsWith(".txt")) {
						visitorFiles.add(path);
					}
					return FileVisitResult.CONTINUE;
				}
			});
			
			assertEquals("DirectoryTools.createFiles() - The number of files created was not equal to the number seen using the FileVisitor. " +
					"FileVisitor found " + Arrays.toString(visitorFiles.toArray()) + " & we created " + Arrays.toString(files.toArray()) ,
					number, visitorFiles.size());
		}
		return files;	
	}	
}
