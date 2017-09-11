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
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileAttribute;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

/**
 * Checks that the WatchService can monitor a directory for CREATE, MODIFY and
 * DELETE events, and that these events are seen within a reasonable length of
 * time.
 * 
 * Implementation may be different per platform, and not all filesystems may
 * support this natively, and may fall back on polling. To accomodate this, we
 * give each event a fixed time to appear, currently set at 120 seconds.
 * 
 */
public class DirectoryWatcherTest extends TestCaseWithTempDirectory {

	private static final long TIMEOUT = 30000;
	private static final long POLL_TIMEOUT_SECONDS = 120;

	protected static int instance;

	static {
		instance = 0;
		System.out.println("DirectoryWatcherTest using a .poll() timeout of " + POLL_TIMEOUT_SECONDS + " seconds");
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

	public DirectoryWatcherTest() {
		synchronized (DirectoryWatcherTest.class) {
			thisInstance = instance++;
		}
	}

	public void testMultipleEntries() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = FileSystems.getDefault().newWatchService();
		try {
			// Check for CREATE
			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

			Path newFilename = Paths.get("ENTRY_CREATE.txt");
			Path newFile = tempDirectory.resolve(newFilename);
			Files.createFile(newFile);
			assertTrue("File was not created", Files.exists(newFile));

			WatchKey key = null;
			
			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got something by
			// then we assume failure
			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			boolean eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_CREATE events delivered for one file creation", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_CREATE");
				}

			}

			// Reset the key, to allow for future events
			key.reset();

			HangNotifier.ping();

			// Check for MODIFY
			// We need to pause so that the implementation on AIX and zOS
			// notices the modification time
			// has changed, which only work to the second apparently.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}

			// Modify file
			OutputStream out = Files.newOutputStream(newFile, StandardOpenOption.WRITE);
			out.write("A".getBytes());
			out.close();

			key = null;

			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got something by
			// then we assume failure

			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_MODIFY events delivered for one file modification", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_MODIFY");
				}
			}

			// Reset the key, to allow for future events
			key.reset();
			HangNotifier.ping();

			// Check for DELETE#
			// Once the WatchService has noticed the file has been modified, it
			// knows the file is there, so
			// no further wait is required before deleting it.

			Files.delete(newFile);

			key = null;

			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got
			// something by
			// then we assume failure

			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_DELETE events delivered for one file deletion", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_DELETE");
				}

			}
			// Reset the key, to allow for future events
			key.reset();
		} finally {
			watchService.close();
		}
		okForCleanup();
	}

	public void testEntryCreate() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = FileSystems.getDefault().newWatchService();
		try {
			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			Path newFilename = Paths.get("ENTRY_CREATE.txt");
			Path newFile = tempDirectory.resolve(newFilename);
			Files.createFile(newFile);
			assertTrue("File was not created", Files.exists(newFile));

			WatchKey key = null;

			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got something by
			// then we assume failure
			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			boolean eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_CREATE events delivered for one file creation", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_CREATE");
				}
			}

			// Reset the key, to allow for future events
			key.reset();

		} finally {
			watchService.close();
		}
		okForCleanup();
	}

	public void testMultipleEntryCreate() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = FileSystems.getDefault().newWatchService();
		try {
			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			WatchKey key = null;
			for (int iteration = 0; iteration < 10; iteration++) {
				HangNotifier.ping();
				Path newFilename = Paths.get("ENTRY_CREATE" + iteration + ".txt");
				Path newFile = tempDirectory.resolve(newFilename);
				Files.createFile(newFile);
				assertTrue("File was not created", Files.exists(newFile));

				key = null;

				// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got something by
				// then we assume failure

				key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);
				assertNotNull("Polling WatchService object returned null", key);
				
				boolean eventFound = false;

				// Check for exactly one event
				for (WatchEvent<?> event : key.pollEvents()) {
					if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						// Assert exactly one event
						assertFalse("Duplicate ENTRY_CREATE events delivered for one file creation", eventFound);
						// Assert filename is correct
						assertEquals(newFilename, (Path) event.context());
						eventFound = true;
					} else {
						fail(event.kind() + " event retured, expected ENTRY_CREATE");
					}
				}

				// Reset the key, to allow for future events
				if (key != null) {
					key.reset();
				}
			}
		} finally {
			watchService.close();
		}
		okForCleanup();
	}

	public void testEntryModify() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = FileSystems.getDefault().newWatchService();
		try {
			Path newFilename = Paths.get("ENTRY_MODIFY.txt");
			Path newFile = tempDirectory.resolve(newFilename);
			Files.createFile(newFile);
			assertTrue("File was not created", Files.exists(newFile));

			// We need to pause so that the implementation on AIX and zOS
			// notices the modification time
			// has changed, which only work to the second apparently.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}

			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

			// Modify file
			OutputStream out = Files.newOutputStream(newFile, StandardOpenOption.WRITE);
			out.write("A".getBytes());
			out.close();

			WatchKey key = null;

			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got
			// something by
			// then we assume failure

			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			boolean eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_MODIFY events delivered for one file modification", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_MODIFY");
				}
			}

			// Reset the key, to allow for future events
			key.reset();
		} finally {
			watchService.close();
		}
		okForCleanup();
	}

	public void testEntryDelete() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = FileSystems.getDefault().newWatchService();
		try {
			// Create the file before registering the WatchService, so that
			// we don't need to pause before deleting the file
			Path newFilename = Paths.get("ENTRY_DELETE.txt");
			Path newFile = tempDirectory.resolve(newFilename);
			Files.createFile(newFile);
			assertTrue("File was not created", Files.exists(newFile));

			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);

			Files.delete(newFile);

			WatchKey key = null;
			// We will give it POLL_TIMEOUT_SECONDS seconds, if it hasn't got
			// something by
			// then we assume failure

			key = watchService.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

			assertNotNull("Polling WatchService object returned null", key);

			boolean eventFound = false;

			// Check for exactly one event
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)) {
					// Assert exactly one event
					assertFalse("Duplicate ENTRY_DELETE events delivered for one file deletion", eventFound);
					// Assert filename is correct
					assertEquals(newFilename, (Path) event.context());
					eventFound = true;
				} else {
					fail(event.kind() + " event retured, expected ENTRY_DELETE");
				}
			}
			// Reset the key, to allow for future events
			key.reset();
		} finally {
			watchService.close();
		}
		okForCleanup();
	}

    // Test that we can have many watchers (10) watching the same directory, and
	// they all get notified
	public void testMultipleWatchers() throws IOException, InterruptedException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		List<WatchService> watchServices = new LinkedList<WatchService>();
		try {
			int MAX_WATCHERS = 10;
			// Create the watch services
			for (int counter = 0; counter < MAX_WATCHERS; counter++) {
				watchServices.add(FileSystems.getDefault().newWatchService());
			}

			// Attach them all to this test directory
			for (WatchService watcher : watchServices) {
				tempDirectory.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			}

			// Create a file in the directory
			Path newFilename = Paths.get("touchedFile.txt");
			Path newFile = tempDirectory.resolve(newFilename);
			Files.createFile(newFile);

			int detectedFiles = 0;

			// Timeout set for POLL_TIMEOUT_SECONDS seconds, which should be
			// plenty to get all of the
			// notifications. Any outstanding after that
			for (WatchService watcher : watchServices) {

				WatchKey key = null;
				key = watcher.poll(POLL_TIMEOUT_SECONDS, TimeUnit.SECONDS);

				if (key != null) {
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
							// In the case of ENTRY_CREATE (among others), the
							// context is a path to the file
							if (event.context() instanceof Path) {
								Path file = (Path) event.context();
								if (file.equals(newFilename)) {
									// All is well
									detectedFiles++;
								} else {
									fail("The WatchEvent points to a file that we didn't create: " + file);
								}
							} else {
								fail("The event.context() for the ENTRY_CREATE kind was not a PATH object: "
										+ event.context());
							}
						}
					}
					key.reset();
				}

			}

			assertEquals("Checking number of file notified vs number of active watchers: ", watchServices.size(),
					detectedFiles);
		} finally {
			for (WatchService watcher : watchServices) {
				watcher.close();
			}
		}
		okForCleanup();
	}

	private static int file_counter = 0;
	private static Object file_counter_lock = new Object();

	public List<Path> createFiles(Path directory, int number) throws IOException {
		if (directory == null) {
			throw new NullPointerException("Path passed to createFiles cannot be null");
		}

		FileAttribute<?>[] attrs = {};

		System.out.println("Creating " + number + " files in " + directory);

		Files.createDirectories(directory, attrs);

		assertTrue("Directory was not created", Files.exists(directory));

		List<Path> files = new LinkedList<Path>();

		for (int counter = 0; counter < number; counter++) {

			Path newFile;
			synchronized (file_counter_lock) {
				newFile = directory.resolve("file" + file_counter++ + ".txt");
			}
			Files.createFile(newFile, attrs);
			assertTrue("File was not created", Files.exists(newFile));
			files.add(newFile);

		}
		return files;
	}

	// Test that a single watcher will get all notifications when many files are
	// created
	public void testDirectoryWatcher() throws IOException, StfException {
		Path tempDirectory = getTemporaryDirectory();
		WatchService watchService = null;

		// Obtain watch service for the default file system and register
		// an interest in knowing when files are created
		watchService = FileSystems.getDefault().newWatchService();
		try {
			tempDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			// Hard-coded values of how many files to touch
			int numberOfIterationsRemaining = 10;
			int numberOfFiles = 5;
			int totalFiles = numberOfFiles * numberOfIterationsRemaining;
			long startTime = System.currentTimeMillis();

			// Our variables containing information as to whether we are going
			// to pass
			// or fail
			int filesFound = 0;
			boolean discardedEvents = false;

			LOOP: while (true) {
				WatchKey key;
				
				// Spread out the creating of files, interspersing them with polls.
				if (numberOfIterationsRemaining > 0) {
					createFiles(tempDirectory, numberOfFiles);
					numberOfIterationsRemaining--;
				}

				// Try taking a key off the service, if available (null if not)
				key = watchService.poll();
				if (key != null) {
					// Retrieve each event
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
							// New file found
							filesFound++;
						} else if (event.kind().equals(StandardWatchEventKinds.OVERFLOW)) {
							// Overflow occurred.
							// This is sort of a warning, but expected if we
							// (the JVM?) can't process
							// the events fast enough
							discardedEvents = true;
						}
					}

					// Important to reset the key
					key.reset();
				}

				long duration = System.currentTimeMillis() - startTime;

				// Check if we have received everything we intended to
				// if so, we can break the loop
				if (numberOfIterationsRemaining == 0) {
					if (filesFound == totalFiles) {
						break LOOP;
					}
					if (discardedEvents == true) {
						break LOOP;
					}
				}

				// Check to see if we have been doing this for too long
				// if so, then break the loop
				if (duration > TIMEOUT) {
					fail("Timeout exceeded: " + filesFound + " files found in " + duration + "ms");
					break LOOP;
				}
			}

			System.out.println("Summary: totalfile - " + totalFiles + " , files found " + filesFound);

			if (discardedEvents == false && (totalFiles != filesFound)) {
				fail("No events were knowingly discarded, but the total number of files found does not equal the number created");
			}

			if (discardedEvents == true) {
				System.out.println("Warning, events were discarded.");
			}
		} finally {
			watchService.close();
		}
		okForCleanup();
	}
}

