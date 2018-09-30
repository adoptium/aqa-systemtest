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

package net.adoptopenjdk.test.nio2.mxbean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.lang.management.BufferPoolMXBean;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;
import net.adoptopenjdk.test.nio2.util.HangNotifier;

/**
 * Testing the ByteBufferMXBean, and its ability to retrieve usage statistics. 
 * 
 * This testcase checks that both the mapped and direct byte-buffers are
 * in the list returned by the MXBean object. The test then goes on to generate
 * a random number of each buffer type (up to 100), and checks that the 
 * number the MXBean is aware of is greater than the number we created.
 * 
 * File Requirements: 
 * 		This testcase uses 'mappedFile.txt' to read and map into memory
 * 
 * Other Requirements:
 * 		This tests requires a Java 7 JDK, with JSR203 (NIO.2)
 */

public class ByteBufferMXBeanTest extends TestCase {
	
	private static final Path MAPPED_FILE_DIR = Paths.get("mapped_file");
	private static final Path SMALL_MAPPED_FILE = MAPPED_FILE_DIR.resolve("smallMappedFile.txt");
	private static final Path MEDIUM_MAPPED_FILE = MAPPED_FILE_DIR.resolve("mediumMappedFile.txt");
	private static final Path LARGE_MAPPED_FILE = MAPPED_FILE_DIR.resolve("largeMappedFile.txt");

	private static byte[] SMALL_MAPPED_FILE_CONTENTS = new byte[1024];
	private static byte[] MEDIUM_MAPPED_FILE_CONTENTS = new byte[4096];
	private static byte[] LARGE_MAPPED_FILE_CONTENTS = new byte[10000];
	
	private final int SMALL_MAPPED_FILE_MAX = 20;
	private final int MEDIUM_MAPPED_FILE_MAX = 10;
	private final int LARGE_MAPPED_FILE_MAX = 1;
	
	private final int BYTEBUFFER_SIZE = 100;
	
	private static Random random;
	
	static {
		random = new Random();
		
		// Create some files to map. This means we can have whatever size we want, without
		//  having to check them into the repository
		random.nextBytes(SMALL_MAPPED_FILE_CONTENTS);
		random.nextBytes(MEDIUM_MAPPED_FILE_CONTENTS);
		random.nextBytes(LARGE_MAPPED_FILE_CONTENTS);
		
		try {
			Files.createDirectories(MAPPED_FILE_DIR);
			
			OutputStream os = Files.newOutputStream(SMALL_MAPPED_FILE, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			os.write(SMALL_MAPPED_FILE_CONTENTS);
			os.close();

			os = Files.newOutputStream(MEDIUM_MAPPED_FILE, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			os.write(MEDIUM_MAPPED_FILE_CONTENTS);
			os.close();
			
			os = Files.newOutputStream(LARGE_MAPPED_FILE, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			os.write(LARGE_MAPPED_FILE_CONTENTS);
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			// Any future tests will fail the setUp() if something has gone badly wrong
		}
		
	}
	
	// Check that the files are available
	protected void setUp() throws Exception {
		assertTrue(Files.size(SMALL_MAPPED_FILE) > 0);
		assertTrue(Files.size(MEDIUM_MAPPED_FILE) > 0);
		assertTrue(Files.size(LARGE_MAPPED_FILE) > 0);
		super.setUp();
		HangNotifier.ping();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	// Create x DirectByteBuffers and y MappedByteBuffers and
	// check that the BufferPoolMXBean will return at least this
	// many of each. 
	public void testByteBufferMXBean() throws IOException {
		
		List<BufferPoolMXBean> byteBufferPools = 
			ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
		
		assertTrue(byteBufferPools.size() >= 2);

		BufferPoolMXBean directBean = null;
		BufferPoolMXBean mappedBean = null;
		
		for (BufferPoolMXBean bean: byteBufferPools) {
			if (bean.getName().equals("direct")) {
				directBean = bean;
			}

			if (bean.getName().equals("mapped")) {
				mappedBean = bean;
			}
		}
		
		assertNotNull("Returned DirectByteBuffer bean was null", directBean);
		assertNotNull("Returned Mapped ByteBuffer bean was null", mappedBean);
		
		// Test that there it notices when there is at least x DirectByteBuffers and
		//  y MappedBuffers
			
		// Test that it notices that there is at least x DirectByteBuffers
		
		// Note that we can't check for absolute numbers, we don't know what is 
		//  a) being used by the JVM
		//  b) being used by other threads
		
		int buffersToGenerate = random.nextInt(100) + 1;
		List<ByteBuffer> byteBufferList = new ArrayList<ByteBuffer>();
		Set<MappedFiles> mappedFiles = new HashSet<MappedFiles>();

		for (int counter = 0; counter < buffersToGenerate; counter++) {
			byteBufferList.add(ByteBuffer.allocateDirect(BYTEBUFFER_SIZE));
		}
		
		long directByteBuffers = directBean.getCount();
		long directByteBufferCapacity = directBean.getTotalCapacity();
		
		assertTrue("The number of DirectByteBuffers ("+directByteBuffers+") was less than than the number we are holding open ("+buffersToGenerate+")",
				directByteBuffers >= buffersToGenerate);
		assertTrue("The capcity of the DirectByteBuffers ("+directByteBufferCapacity+") was less than than the capacity of those we are holding open ("
				+(BYTEBUFFER_SIZE * buffersToGenerate)+")",
				directByteBufferCapacity >= (BYTEBUFFER_SIZE * buffersToGenerate));
		

		int total = 0;
		for (@SuppressWarnings("unused") ByteBuffer b: byteBufferList) {
			total++;
		}
		System.out.println("Success: " + total + " ByteBuffers created, MXBean reported " + directByteBuffers);
		
		
		// make them eligible for GC
		byteBufferList = null;
		
		// Test that it notices that there is at least y MappedByteBuffers
		byteBufferList = new ArrayList<ByteBuffer>();
		int smallBuffersToGenerate = random.nextInt(SMALL_MAPPED_FILE_MAX);
		int mediumBuffersToGenerate = random.nextInt(MEDIUM_MAPPED_FILE_MAX);
		int largeBuffersToGenerate = random.nextInt(LARGE_MAPPED_FILE_MAX);
		
		buffersToGenerate = smallBuffersToGenerate + mediumBuffersToGenerate + largeBuffersToGenerate;
		
		for (int counter = 0; counter < buffersToGenerate; counter++) {
			
			try {
				
				Path filetype = SMALL_MAPPED_FILE;
				if (counter > smallBuffersToGenerate) {
					filetype = MEDIUM_MAPPED_FILE;
				}
				if (counter > smallBuffersToGenerate + mediumBuffersToGenerate) {
					filetype = LARGE_MAPPED_FILE;
				}
					
				// RandomAccessFile's can be mapped
				RandomAccessFile fileToBeMapped = new RandomAccessFile(filetype.toFile(), "r");
				FileChannel mappedFileChannel = fileToBeMapped.getChannel();
				
				// Attempt to map the entire file [.size()] into memory
				MappedByteBuffer mappedBuffer = 
								mappedFileChannel.map(
									FileChannel.MapMode.READ_ONLY,
									0,
									mappedFileChannel.size());
				
				MappedFiles mf = new MappedFiles();
				mf.randomAccessFile = fileToBeMapped;
				mf.fileChannel = mappedFileChannel;
				mf.byteBuffer = mappedBuffer;
				
				// If we've got here, we have a mapped file.
				mappedFiles.add(mf);
				fileToBeMapped.close();
				
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
				fail();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				fail();
			}
			
		}
		
		long mappedBuffers = mappedBean.getCount();
		
		assertTrue("The number of mapped ByteBuffers ("+mappedBuffers+") is less than the number we are holding open ("+mappedFiles.size()+")",
				mappedBean.getCount() >= mappedFiles.size());
		
		// make them eligible for GC
		byteBufferList = null;
		
		// Close all the file channels
		for (MappedFiles mf: mappedFiles) {
			mf.randomAccessFile.close();
			mf.fileChannel.close();
		}
		
		mappedFiles = null;
		
	}
	
	
	// Convenience class for grouping the mapped file objects together,
	//  so they can be closed later
	class MappedFiles {
		RandomAccessFile randomAccessFile = null;
		FileChannel fileChannel = null;
		ByteBuffer byteBuffer = null;
	}
	
	// Sanity check the output from the beans's methods
	public void testByteBufferMXBeanMethods() {
		List<BufferPoolMXBean> byteBufferPools = 
			ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
		
		for (int counter = 0; counter < 10; counter++) {
		
			for (BufferPoolMXBean bean: byteBufferPools) {
				
				// Name should not be blank or null
				assertNotNull ("MXBean name is null", bean.getName());
				assertFalse ("MXBean name is blank", bean.getName().equalsIgnoreCase(""));
				// Total capacity should not be negative
				assertTrue (bean.getName() + "'s total capacity was not greater than zero", bean.getTotalCapacity() >= 0);
				// Likewise memoryUsed
				assertTrue (bean.getName() + "'s memory used was not greater than zero", bean.getMemoryUsed() >= 0);
				
				assertTrue (bean.getName() + "'s object name is null or blank", 
						bean.getObjectName() != null &&	bean.getObjectName().toString() != "");
			}
		}
	}

	// Check that we can use the getPlatformMXBeans method to return all the of
	//  MXBeans that we can get via other convenience methods too.
	// I believe the spec doesn't say the has to return any elements in the list,
	//  but we do, as the other convenience methods don't return null.
	// This should probably be retrofitted to the RAS test
	public void testGetPlatformMXBeans() {
		
		// BufferPoolMXBean
		List<BufferPoolMXBean> byteBufferPools = 
			ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
		
		assertTrue("No BufferPoolMXBeans returned", byteBufferPools.size() > 0);
		
		// ThreadMXBean
		List<ThreadMXBean> threadMXBeans = 
			ManagementFactory.getPlatformMXBeans(ThreadMXBean.class);
		
		assertTrue("No ThreadMXBeans returned", threadMXBeans.size() > 0);
		
		// ClassLoadingMXBean
		List<ClassLoadingMXBean> classloadingMXBeans = 
			ManagementFactory.getPlatformMXBeans(ClassLoadingMXBean.class);
		
		assertTrue("No ClassLoadingMXBeans returned", classloadingMXBeans.size() > 0);
		
		// GarbageCollectorMXBean
		List<GarbageCollectorMXBean> gcMXBeans = 
			ManagementFactory.getPlatformMXBeans(GarbageCollectorMXBean.class);
		
		assertTrue("No GarbageCollectorMXBeans returned", gcMXBeans.size() > 0);
		
		// MemoryManagerMXBean
		List<MemoryManagerMXBean> memoryManagerBeans = 
			ManagementFactory.getPlatformMXBeans(MemoryManagerMXBean.class);
		
		assertTrue("No MemoryManagerMXBeans returned", memoryManagerBeans.size() > 0);

		// MemoryPoolMXBean
		List<MemoryPoolMXBean> memoryPoolBeans = 
			ManagementFactory.getPlatformMXBeans(MemoryPoolMXBean.class);
		
		assertTrue("No MemoryPoolMXBeans returned", memoryPoolBeans.size() > 0);
		
		// RuntimeMXBean
		List<RuntimeMXBean> runtimeBeans = 
			ManagementFactory.getPlatformMXBeans(RuntimeMXBean.class);
		
		assertTrue("No RuntimeMXBeans returned", runtimeBeans.size() > 0);
		
	}

}
