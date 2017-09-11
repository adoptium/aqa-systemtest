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

import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import net.adoptopenjdk.test.nio2.asyncio.RunFuture;
import net.adoptopenjdk.test.nio2.util.AssertionFailedException;
import net.adoptopenjdk.test.nio2.util.AsyncTestState;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.RandomByteArrays;
import net.adoptopenjdk.test.nio2.util.ReiserSpotter;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

/**
 *  Tests that we can, in the most simple case, open a file 
 *   asynchronously for writing
 */
public class AsynchronousFileChannelTest extends TestCaseWithTempDirectory {

	// To remove the chance of two AsynchronousFileChannelTests being executed in tandem.
	private static final AtomicBoolean otherTestInstances = new AtomicBoolean(false); 
	private static final Object otherTestInstancesLock = new Object();
	
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
	
	@SuppressWarnings("resource")
	public void testAsynchronousFileChannel() throws Exception {
		
		//Multiple instances of this test running concurrently can cause trouble, so abort if needed.
		synchronized(otherTestInstancesLock){
			if(otherTestInstances.get()){
				return;
			}
			otherTestInstances.set(true);
		}
		
		// Construct Path object of the file to read and write to
		Path file = Paths.get(getTemporaryDirectory() + "/CREATE.txt");
		
		assertFalse("File already exists", Files.exists(file));
		
		// Open Async FileChannel
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
				file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		assertTrue("AsynchronousFileChannel was not open", fileChannel.isOpen());
		
		byte[] bytes = RandomByteArrays.getRandomByteArray(RandomByteArrays.MAX);
		
		// Write to the file Asynchronously (and keep trying until the task finishes, one way or another).
		boolean futureWriteSuccessBool = false;
		while(!futureWriteSuccessBool){
			Future<Integer> futureWrite = fileChannel.write(ByteBuffer.wrap(bytes), 0);
			try{
				RunFuture.get(futureWrite);
				futureWriteSuccessBool = true;
			}catch(TimeoutException e){
				futureWrite.cancel(true);
				// Open Async FileChannel
				fileChannel = AsynchronousFileChannel.open(
						file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				
				assertTrue("AsynchronousFileChannel was not open", fileChannel.isOpen());
				
				bytes = RandomByteArrays.getRandomByteArray(RandomByteArrays.MAX);
			}
		}
			
		assertTrue("File was not created", Files.exists(file));
		
		// Close this AsynchronousFileChannel
		fileChannel.close();		
		assertTrue("AsynchronousFileChannel was not closed", !fileChannel.isOpen());
		
		// Read the file in via another method
		BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.READ));
		
		byte[] readBytes = new byte[bytes.length];
		inputStream.read(readBytes);
		inputStream.close();
		
		// Check they were the same
		assertTrue("Bytes read in via BufferedInputStream were not equal to those asked to be written", Arrays.equals(bytes, readBytes));
		
		// Read the bytes in asynchronously
		ByteBuffer readBuffer = ByteBuffer.allocate(bytes.length);
		
		
		// Open Async FileChannel for reading
		AsynchronousFileChannel readingFileChannel = AsynchronousFileChannel.open(
				file, StandardOpenOption.READ);
		
		// Read in as many bytes as we reckon we should have written
		Future<Integer> futureRead = readingFileChannel.read(readBuffer, 0);
		
		
		boolean writeAsyncFutureReadSuccessBool = false;
		while(!writeAsyncFutureReadSuccessBool){
			try{
				RunFuture.get(futureRead);
				writeAsyncFutureReadSuccessBool = true;
			}catch(TimeoutException e){
				futureRead.cancel(true);
				// Open Async FileChannel for reading
				readingFileChannel = AsynchronousFileChannel.open(
						file, StandardOpenOption.READ);
				
				// Read in as many bytes as we reckon we should have written
				futureRead = readingFileChannel.read(readBuffer, 0);
			}
		}
		
		
		
		
		// Assert we have read in all the bytes
		assertEquals("All bytes were not read into the incoming ByteBuffer",bytes.length, readBuffer.position());

		// Check they were the same
		assertTrue("Bytes read in via Future.get() were not equal to those asked to be written", Arrays.equals(bytes, readBytes));
		
		
		readBuffer.clear();
		
		AsyncTestState testState = new AsyncTestState();
		testState.incomingBuffer = readBuffer;
		
		// Read in as many bytes as we reckon we should have written
		readingFileChannel.read(readBuffer, 0, testState, new CompletionHandler<Integer, AsyncTestState>() {

			@Override
			public void completed(Integer result, AsyncTestState testState) {
				// Check that the read bytes = the size of the buffer
				if (result != testState.incomingBuffer.capacity()) {
					testState.failedAssertions.addException(
							new AssertionFailedException("Async read bytes- " + result + 
									" was not equal to the expected input size- " + testState.incomingBuffer.capacity()));
				}
				testState.complete = true;
			}

			@Override
			public void failed(Throwable exc, AsyncTestState testState) {
				testState.failedAssertions.addException(new AssertionFailedException(exc));
				testState.complete = true;
			}
			
		});
		
		while (!testState.complete) {
			try {
				Thread.sleep(1);
			} catch (Exception e){
				
			}
		}
		
		// Assert we have read in all the bytes
		assertEquals("All bytes were not read into the incoming ByteBuffer",bytes.length, readBuffer.position());

		// Check they were the same
		assertTrue("Bytes read in via CompletionHandler() were not equal to those asked to be written", Arrays.equals(bytes, readBytes));
		
		// Close this AsynchronousFileChannel
		readingFileChannel.close();		
		assertTrue("AsynchronousFileChannel was not closed", !readingFileChannel.isOpen());
		
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
		
		synchronized(otherTestInstancesLock){
			otherTestInstances.set(false);
		}
	}
	
	
	protected long getTimeout() {
		// Changed from 5*60*1000 to avoid timeout exceptions in stress.
		return 5*60*2000;
	}
	
}
