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

package net.adoptopenjdk.test.modularity.junit;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.ModuleLayer;
import java.util.Set;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.lang.module.*;
import java.lang.reflect.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Set;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Use cases: 
 * ~~~~~~~~~
 * Test case (1) 
 * Implement  a class loading Layers stress test where we load a set 
 * of application classes from a few modules in lots of Layers in a multi-threaded 
 * environment. This would be a stress test version of the LayersTest. 
 * 
 * Test case (2) 
 * Implement a test that's similar to Test case (1) above 
 * but use classes from platform modules in jimage (e.g. java.xml).
 * 
 * Test case (3) 
 * (Negative test) Implement a test that's similar to Test case 1 
 * above but use classes from bootstrap modules in jimage (e.g. java.logging).
 * 
 * Test case (4)
 * Create a custom runtime image using jlink and run test case 1, 2, 3 using the image.
 * This test is being driven by CLStressWithLayersCRI.java
 **/

public class TestStressLayers {
	
	private int REPEATATION_PER_THREAD = 10;  

	@Test
	public void testStressLayers() throws Exception {
		int threadCount = Integer.parseInt(System.getProperty("thread.count"));
		ArrayList<Callable<String>> workers = new ArrayList<Callable<String>>(); 
		
		/*Test case 1) 
		 * Run Layers stress test where each thread loads application module classes 
		 * using a non-boot layer*/
		for (int i = 0; i < threadCount; i++) {
			Callable<String> callable = new LayerWorkerThread_With_AppModules();
			workers.add(callable);
		}
		
		stressLayersWith(threadCount, workers, "stress Layers with App Module classes");
		
		/*Test case 2)
		 * Run Layers stress test where we each thread loads a 
		 * class from a platform module using a non-boot Layer.
		 * */
		workers.clear();
		for (int i = 0; i < threadCount; i++) {
			Callable<String> callable = new LayerWorkerThread_With_PlatformModules();
			workers.add(callable);
		}
		stressLayersWith(threadCount, workers, "stress Layers with Platform Module classes");
		
		/*Test case 3)
		 * (Negative test) Load a class from a boot module (java.logging) in a non-boot layer.
		 * This should return a null class loader. This test should be single-threaded. 
		 * */
		workers.clear();
		Callable<String> callable = new LayerWorkerThread_With_PlatformModules();
		workers.add(callable);	
		stressLayersWith(1, workers, "test Layers with Bootstrap Module classes (negative test)");
	}
	
	private void stressLayersWith(int threadCount, ArrayList<Callable<String>> workers, String testName) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		System.out.println("Starting threads to " + testName + " ..");
		List<Future<String>> futures = executor.invokeAll(workers);
		executor.shutdown();
		
		// Check that all workers completed successfully
		// If a worker failed and threw an exception then it will be rethrown in the f.get() call
		for (Future<String> f : futures) {
			String s = f.get();
			assertNotNull(s, "Worker thread did not finish successfully");
		}
		
		System.out.println("All workers completed successfully");
	}

	/*
	 * Worker thread for Layers stress test with app modules
	 * */
	class LayerWorkerThread_With_AppModules implements Callable<String> {		
		@Override
		public String call() throws Exception {
			for (int i = 0 ; i < REPEATATION_PER_THREAD ; i++ ) {
				//Obtain the parent Layer we currently have, which should be the boot layer 
				ModuleLayer parentLayer = ModuleLayer.boot();
				
				//Obtain the parent Configuration 
				Path modulePath = FileSystems.getDefault().getPath(System.getProperty("module.path"));
				ModuleFinder moduleFinder = ModuleFinder.of(modulePath);
	
				ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
	
				Configuration cf1 = parentLayer.configuration()
						.resolve(moduleFinder, ModuleFinder.of(), Set.of("com.hello"));
						
				Configuration cf2 = parentLayer.configuration()
						.resolve(moduleFinder, ModuleFinder.of(), Set.of("com.helper"));
				
				ModuleLayer layer1 = parentLayer.defineModulesWithManyLoaders(cf1, systemClassLoader);
				ModuleLayer layer2 = parentLayer.defineModulesWithManyLoaders(cf2, systemClassLoader);
				
				Class<?> c1 = layer1.findLoader("com.hello").loadClass("adoptopenjdk.test.modularity.hello.Hello");
				String returnValue = (String) c1.getMethod("name").invoke(null);
				assertEquals("Test failed - Expected value: [Hello], but value received: [" + returnValue + "]", returnValue, "Hello");
				
				Class<?> c2 = layer2.findLoader("com.helper").loadClass("adoptopenjdk.test.modularity.helper.pkgOne.HelperClass");
				returnValue = (String) c2.getMethod("name").invoke(null);
				assertEquals("Test failed - Expected value: [Helper], but value received: [" + returnValue + "]", returnValue, "helper");
			}
			
			System.out.println("Thread : " + Thread.currentThread().getName() + " done!");
			return null;
		}
	}
	
	/*
	 * Worker thread for Layers stress test with platform module(java.xml) 
	 * */
	class LayerWorkerThread_With_PlatformModules implements Callable<String> {		
		@Override
		public String call() throws Exception {
			for (int i = 0 ; i < REPEATATION_PER_THREAD ; i++ ) {
				//Obtain the parent Layer we currently have, which should be the boot layer 
				ModuleLayer parentLayer = ModuleLayer.boot();
				
				//Obtain the parent Configuration 
				Path modulePath = FileSystems.getDefault().getPath(System.getProperty("module.path"));
				ModuleFinder moduleFinder = ModuleFinder.of(modulePath);
				ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
	
				Configuration cf1 = parentLayer.configuration()
						.resolve(moduleFinder, ModuleFinder.of(), Set.of("java.xml"));
				
				ModuleLayer layer1 = parentLayer.defineModulesWithManyLoaders(cf1, systemClassLoader);
				Class<?> c1 = layer1.findLoader("java.xml").loadClass("javax.xml.namespace.QName");
				String returnValue = (String) c1.getMethod("getLocalPart​").invoke(c1.newInstance());
			
				assertNull("Access to javax.xml.namespace.QName.getLocalPart​() "
						+ "returned unexpected value", returnValue);
			}
			
			System.out.println("Thread : " + Thread.currentThread().getName() + " done!");
			return null;
		}
	}
	
	/*
	 * Worker thread for Layers test with boot module (negative test) 
	 * */
	class LayerWorkerThread_With_BootModules implements Callable<String> {		
		@Override
		public String call() throws Exception {
			ModuleLayer parentLayer = ModuleLayer.boot();
			
			// Obtain the parent Configuration 
			Path modulePath = FileSystems.getDefault().getPath(System.getProperty("module.path"));
			ModuleFinder moduleFinder = ModuleFinder.of(modulePath);
			ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

			Configuration cf1 = parentLayer.configuration()
					.resolve(moduleFinder, ModuleFinder.of(), Set.of("java.logging"));
			
			ModuleLayer layer1 = parentLayer.defineModulesWithManyLoaders(cf1, systemClassLoader);
			
			ClassLoader cl = layer1.findLoader("java.logging");
			
			assertNull("ClassLoader returned not-null for a bootstrap "
					+ "class being loaded in a non-boot layer", cl);

			System.out.println("Thread : " + Thread.currentThread().getName() + " done!");
			return null;
		}
	}
}
