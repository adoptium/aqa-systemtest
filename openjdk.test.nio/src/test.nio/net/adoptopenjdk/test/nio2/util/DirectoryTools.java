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

package net.adoptopenjdk.test.nio2.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  A collection of methods to manage the creation and deletion of 
 *   directories using the new API
 */
public class DirectoryTools {
	
	private static Path directoryRoot = Paths.get("temporary");
	
	private static PrintStream logWriter = null;
	
	static {
		// Delete the current contents of the temporary directory
		try {
			deleteDirectory(directoryRoot);
			Files.createDirectories(directoryRoot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path logFile = Paths.get("DirectoryTools.log");
		try {
			OutputStream os = Files.newOutputStream(logFile, 
					StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			logWriter = new PrintStream(os);
			System.out.println("DirectoryTools log available at " + logFile);
		} catch (IOException e) {
			System.err.println("Unable to create log file");
			e.printStackTrace();
		}		
	}
	
	private static void logMessage(String message) {
		if (logWriter != null) {
			logWriter.println(message);
		}
	}

	public static Path createTemporaryDirectory(Path directory) throws FileAlreadyExistsException, IOException{	
		// Create a path under the root
		Path qualifiedPath = directoryRoot.resolve(directory);
		
		// Check that it doesn't already exist
		if (Files.exists(qualifiedPath, LinkOption.NOFOLLOW_LINKS)) {
			throw new FileAlreadyExistsException(qualifiedPath.toString() + " already exists");
		}
		
		// Create the directory structure (creates missing parental directories)
		Files.createDirectories(qualifiedPath);	
		return qualifiedPath;	
	}
	
	// Recursive deleting of a direction using the NIO.2 implementation
	// of the Visitor Pattern.
	public static void deleteDirectory(Path directory) throws IOException {		
		// FileVisitor pattern / NIO.2 implementation of deleting a directory
		// which may contain files. If this doesn't touch all files for some
		// reason, then the attempt to delete the directory on exit will fail.
		
		// If it doesn't exist, return
		if (Files.notExists(directory)) {
			return;
		}
		
		// Keep track of the files we have visited
		final List<Path> visitedFiles = new LinkedList<Path>();

		// Construct the Visitor object		
		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
			@Override
			// Delete the file
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {			
				if (!attributes.isDirectory()) {
					try {
						visitedFiles.add(path);
						Files.delete(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return FileVisitResult.CONTINUE;				
			}

			@Override
			
			// Delete directory on exit (should be empty at this point)
			public FileVisitResult postVisitDirectory(Path path,
					IOException arg1) throws IOException{
				try {
					Files.delete(path);				
				} catch (DirectoryNotEmptyException e) {					
					if(!ReiserSpotter.getIsReiser()){
						try {
						System.err.println("Directory not empty! Attempting to see what files are left:");
							for (Path file: Files.newDirectoryStream(path)) {
							System.err.println("Found file: " + file);
							}
						} catch (IOException ioe) {
						System.err.println("Failed to see what might still be in the directory we couldn't delete");
						ioe.printStackTrace();
						}
					}
				}
				return FileVisitResult.CONTINUE;
			}		
		};
		
		// Walk the directory with the Visitor		
		List<Path> originalFiles = listFiles(directory);
		
		try {
			logMessage("Deleting " + directory);
			Files.walkFileTree(directory, visitor);
		} catch (IOException ioe) {
			if(!ReiserSpotter.getIsReiser()){		
				logMessage("ERROR deleting " + directory);
				List<Path> leftoverFiles = listFiles(directory);
			
				String message = "Error whilst deleting " + directory + ". " + originalFiles.size() + 
						" files originally " + Arrays.toString(originalFiles.toArray()) +
						", visted and deleted " + Arrays.toString(visitedFiles.toArray()) + 
						", and there are " + Arrays.toString(leftoverFiles.toArray()) + " remaining.";
				System.err.println(message);
				logMessage(message);
			
				throw ioe;
			}
		}

		if(!ReiserSpotter.getIsReiser()){
			if (Files.exists(directory)) {
				throw new IOException("I was unable to delete this subtest's directory - " + directory);
			}
		}		
	}
	
	public static List<Path> listFiles(Path directory) throws IOException {	
		final List<Path> files = new LinkedList<Path>();	
		if (Files.notExists(directory)) {
			return files;
		}	
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) {
				files.add(path);
				return FileVisitResult.CONTINUE;
			}
		});	
		return files;	
	}	
}
