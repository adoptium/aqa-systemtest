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

package net.adoptopenjdk.test.nio2.asyncio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.test.nio2.util.AssertionFailedException;
import net.adoptopenjdk.test.nio2.util.AsyncTestState;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

/**
 *  Writes the contents of <N> files asynchronously
 *    <N> defaults to 100
 *    
 *  It then reads them all back in in parallel, checking the contents
 */

public class AsynchronousFileChannelBasicMultipleRead extends TestCaseWithTempDirectory {

	private static final int NUMBER_OF_FILES = 2;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testReadWrite() throws IOException, InterruptedException, ExecutionException, TimeoutException, StfException {		
		// Sequentially write a load of files	
		List<FileChannelAsyncTestState> filesWritten = new LinkedList<FileChannelAsyncTestState>();
		
		// We are ok to use assertions in this loop, as we haven't forked into 
		//  many threads	
		for (int fileCounter = 0; fileCounter < NUMBER_OF_FILES; fileCounter++) {
			
			AsynchronousFileChannel fileChannel = null;
			
			try {
				FileChannelAsyncTestState fileChannelAsyncTestState = new FileChannelAsyncTestState();
			
				// Construct Path object of the file to read and write to
				Path filePath = getTemporaryDirectory().resolve(Paths.get("file" +  fileCounter + ".txt"));
				
				assertFalse("File already exists", Files.exists(filePath));
				
				fileChannelAsyncTestState.path = filePath;
				
				// Open Async FileChannel
				fileChannel = AsynchronousFileChannel.open(
						filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				
				assertTrue("File was not created", Files.exists(filePath));
				
				// Create a random string of bytes to write
				byte[] bytes = new byte[random.nextInt(1000) + 1000]; 
				random.nextBytes(bytes);
				ByteBuffer src = ByteBuffer.wrap(bytes); 
				
				assertTrue("File is not empty before writing", fileChannel.size() == 0);

				Future<Integer> future = fileChannel.write(src, 0);
				future.get(getTimeout(), TimeUnit.MILLISECONDS);
				
				assertEquals("Size of the file does not equal the number of bytes written",
						bytes.length, fileChannel.size());
				
				System.out.println("Successfully written " + bytes.length + " to " + fileChannel);
				
				fileChannelAsyncTestState.contents = bytes;				
				filesWritten.add(fileChannelAsyncTestState);
				
			} finally {
				if (fileChannel != null) {
					try {
						fileChannel.close();
					} catch (ClosedChannelException e) {
						// We never got as far as opening it, never mind
					}
				}
			}
			
		}	

		// Asynchronously read them all back in
		for (FileChannelAsyncTestState file: filesWritten) {			
			file.channel = AsynchronousFileChannel.open(file.path, StandardOpenOption.READ);
			assertTrue("File channel was not opened", file.channel.isOpen());
			// Reset completion to false
			file.complete = false;			
		}
		
		System.out.println("Opened all the file channels");
		
		for (FileChannelAsyncTestState file: filesWritten) {			
			file.buffer = ByteBuffer.allocate(2000);
			file.channel.read(file.buffer, 2000, file,
					new CompletionHandler<Integer, FileChannelAsyncTestState>() {
						@Override
						public void completed(Integer result,
								FileChannelAsyncTestState testState) {						
							if (result == -1) {
								// Channel has been closed
								testState.complete = true;
							}
							
							System.out.println("Completed, read " + result + " bytes");
							System.out.println(testState.buffer);						
							
							for (int counter = 0; counter < testState.contents.length; counter++) {
								if (testState.contents[counter] != testState.buffer.get(counter)) {
									testState.failedAssertions.addException(new IOException("Contents differed at position " + counter));
									break;
								}
							}
							
							// Close the file channel							
							// Assert channel is open
							if (!testState.channel.isOpen()) {
								testState.failedAssertions.addException(
										new AssertionFailedException("Channel was not open after completed read"));
							}
							
							// Assert the channel closes without exception
							try {
								testState.channel.close();
							} catch (IOException e) {
								testState.failedAssertions.addException(
										new AssertionFailedException(e));
							}
							
							testState.complete = true;
						}

						@Override
						public void failed(Throwable t,
								FileChannelAsyncTestState testState) {
							
							testState.failedAssertions.addException(new Exception(t));
							
							// Housekeeping
							// Attempt to close the channel, it may or may not be open
							try {
								testState.channel.close();
							} catch (IOException e) {
							}
							
							testState.complete = true;
							
						}
				}
			);			
		}
		
		int numberOfExceptionsThrown = 0;		
		boolean allcomplete = false;
			
		while (!allcomplete) {
			allcomplete = true;
			for (FileChannelAsyncTestState state: filesWritten) {		
				if (!state.complete) {
					allcomplete = false;
					if (state.complete == false && hasTimedOut(state.startedAt)) {
						// Add the exception to note failure, and set as complete
						state.failedAssertions.addException(
								new TimeoutException("Test took longer than the specified timeout ("  +getTimeout()+ ") to complete"));
						state.complete = true;
						
						// Cleanup the channel if it is still open
						try {
							state.channel.close();
						} catch (ClosedChannelException e) {
							// If it's closed, it's closed.
						} catch (Exception e) {
							// We are, however, bothered about exceptions
							state.failedAssertions.addException(e);
						}
					} 
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
			}
		}
		
		for (FileChannelAsyncTestState state: filesWritten) {		
			if (state.failedAssertions.hasExceptions()) {
				numberOfExceptionsThrown += state.failedAssertions.getNumberOfExceptions();
			}
			System.err.println(state.failedAssertions.getExceptionMessages());		
		}
		
		if (numberOfExceptionsThrown > 0) {
			fail(numberOfExceptionsThrown + " exceptions thrown");
		}
			
		// Signify we can delete this directory
		okForCleanup();	
	}
	
	protected boolean hasTimedOut(long startTime) {
		return (System.currentTimeMillis() > startTime + getTimeout());
	}
	
	protected long getTimeout() {
		return 20000;
	}
	
	private class FileChannelAsyncTestState extends AsyncTestState {		
		// Inherits a complete variable and a FailedAssertions object		
		AsynchronousFileChannel channel = null;
		Path path = null;
		byte[] contents = null;
		ByteBuffer buffer = null;	
	}	
}
