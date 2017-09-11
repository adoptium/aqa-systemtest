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

package net.adoptopenjdk.test.nio2.filesystem;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import net.adoptopenjdk.test.nio2.util.HangNotifier;


/**
 * This test checks that
 * 
 *  a) We can load one provider 
 *  b) That we can load all <N> providers that are located in 
 *      the corresponding jar file, where N defaults to 10000
 *
 * The FileSystems API allows a user to create filesystems and have them available
 *  for use by others. With no SDK code backing these interfaces it is not worthwhile
 *  from an SVT perspective to code up a set of classes implementing all the interface 
 *  methods. Instead, the tests focus on the key area of providing the filesystem as a 
 *  service, and checking the mechanism for advertising this (via the relevant files in 
 *  a jar file) works as it should.
 *  
 * To achieve this we create a fixed number of FileSystemProviders (e.g. 1000) and place
 *  their names in the META-INF/services/java.nio.file.spi.FileSystemProvider file, along 
 *  with their implementing classes. Iterating through the installed providers we should
 *  find all these providers and check that each is loaded by way of calling methods on
 *  their classes.
 */

public class FileSystemsTest extends TestCase{
	
	public static final int DEFAULT_NUMBER_OF_PROVIDERS = 1000;

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
	
	// Test that a provider is loaded from the jar file
	public void testFileSystemIsRegistered() throws URISyntaxException {

		// Check that the expected "memory0" FileSystem is available
		boolean foundInitialProvider = false;

		for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
			if (provider.getScheme().equalsIgnoreCase("memory0")) {
				foundInitialProvider = true;
			}
		}

		assertTrue("Unable to find intial provider 'memory0'", foundInitialProvider);


		FileSystem memoryFileSystem = FileSystems.getFileSystem(new URI("memory0:///"));
		assertNotNull("Returned memoryFileSystem for 'memory0:///' was null", memoryFileSystem);

		String filename = "bargh";
		assertNotNull("Returned filename for 'memory0:///"+filename+"' was null", memoryFileSystem.getPath(filename));
		
		assertEquals("MemoryFileSystem did not return the expected string representation",
				"/memory/" + filename, memoryFileSystem.getPath(filename).toString());


	}
	
	// Test that all the providers we think we have are loaded from the jar file
	public void testAllFileSystemsAreRegistered() throws URISyntaxException, NumberFormatException {
		
		// Get command line specified number of providers if applicable
		String commandLineNumber = 
			System.getProperty("net.adoptopenjdk.nio2.filesystem.FileSystemsTest.numberOfProviders", null);
		
		int numberOfMemoryProviders = DEFAULT_NUMBER_OF_PROVIDERS;
		
		if (commandLineNumber != null) {
			numberOfMemoryProviders = Integer.valueOf(commandLineNumber);
		}
		

		Set<String> expectedProviders = new HashSet<String>();
		for (int counter = 0; counter < numberOfMemoryProviders; counter++) {
			expectedProviders.add("memory" + counter);
		}

		// Check that the expected "memory" FileSystem is available
		Set<String> foundProviders = new HashSet<String>();
		for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
			foundProviders.add(provider.getScheme());
		}
		
		expectedProviders.removeAll(foundProviders);
		assertEquals("Unable to match all memory FileSystems in the list of available providers",
				numberOfMemoryProviders, numberOfMemoryProviders - expectedProviders.size());

		for (int counter = 0; counter < numberOfMemoryProviders; counter++) {
		
			FileSystem memoryFileSystem = FileSystems.getFileSystem(new URI("memory" + counter + ":///"));

			String filename = "bargh";

			assertEquals("MemoryFileSystem did not return the expected string representation",
					"/memory/" + filename, memoryFileSystem.getPath(filename).toString());

		}

	}

}
