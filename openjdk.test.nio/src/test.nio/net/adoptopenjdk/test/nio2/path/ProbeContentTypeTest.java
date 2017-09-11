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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import junit.framework.TestCase;
import net.adoptopenjdk.test.nio2.util.HangNotifier;

/**
 * This test is primarily to check that the relevant content type
 *  parsers can be loaded without error. The MIME types can be
 *  different across OSes, and the JVM isn't required to return
 *  anything at all - null is perfectly acceptable (and probable
 *  on zOS or AIX if the required libraries are not installed).
 *  
 */

public class ProbeContentTypeTest extends TestCase {
	public static void main(String[] args) throws Exception {	
		(new ProbeContentTypeTest()).testProbeContentType();
	}
	
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
	
	public void testProbeContentType() throws Exception {
		System.out.println("Adding files...");
		addHardcodedMimeTypes();
		System.out.println("Done");
		
		System.out.println("Creating files");
		createFiles();
		System.out.println("Done");
		
		System.out.println("Probing file types");
		probeFileTypes();
		System.out.println("Done");
		
		System.out.println(fileToMimeMap);
	}
	
	private static Map<Path, String> fileToMimeMap = new TreeMap<Path, String>(); 
	
	private static Path rootDirectory = Paths.get("mime_files");
	
	private static void probeFileTypes() throws Exception {		
		List<String> missmatches = new LinkedList<String>();		
		for (Path path: fileToMimeMap.keySet()) {
			System.out.print("Checking " + path + " ...\t");
			Path filename = rootDirectory.resolve(path);
			if (Files.notExists(filename)) {
				System.err.println(filename + " doesn't exist, unable to probe file type");
			} else {
				String fileType = Files.probeContentType(filename);
				String expectedFileType = fileToMimeMap.get(path);
				
				// The return value can be legitimately null if it doesn't know what it is
				// So skip the checking if it is, and carry on
				if (fileType != null) {
					if (!expectedFileType.equalsIgnoreCase(fileType)) {
						missmatches.add(path +"'s filetype was '" + fileType +  "' but we expected '" + expectedFileType + "'");
						System.out.println("Fail");
					} else {
						System.out.println("OK");
					}
				} else {
					System.out.println("Unknown");
				}
			}
		}
		
		if (missmatches.size() > 0) {
			for (String message: missmatches) {
				System.out.println(message);
			}
			// Wait until here to fail so that we can list all the failures, 
			//  rather than just the first one.
			fail(Arrays.toString(missmatches.toArray()));
		}		
	}
	
	private static void addHardcodedMimeTypes() {		
		// Everyone should really know what a .txt file is
		fileToMimeMap.put(Paths.get("testfile.txt"), "text/plain");
		
	}
	
	// Left here in case we want to expand this in the future.
	public static void addPropertiesFileOfMimeTypes(Path files) throws IOException {
		Properties filesProperties = new Properties();
		filesProperties.load(Files.newInputStream(files, StandardOpenOption.READ));
		
		for (Object key: filesProperties.keySet()) {
			String filename = (String)key;
			String mimeType = (String)filesProperties.get(key);
			
			filename = filename.replace("*","testfile");
			fileToMimeMap.put(Paths.get(filename), mimeType);		
		}
	}
	
	private static void createFiles() throws IOException {			
		if (Files.notExists(rootDirectory)) {
			Files.createDirectories(rootDirectory);
		}
		
		for (Path path: fileToMimeMap.keySet()) {
			Path filename = rootDirectory.resolve(path);
			System.out.println("Creating " + filename);
			if (Files.notExists(filename)) {
				Files.createFile(filename);
			}
		}		
	}	
}

