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

public class TestLayers {
	@Test
	public void testLayers() throws Exception {
		ModuleLayer parentLayer = ModuleLayer.boot();
		
		// Obtain the parent Configuration 
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
		
		/*Explicitly invoke GC to unload class. This, coupled with -Xalwaysclassgc (provided 
		 * at command line) will cause classes to be unloaded, which will trigger 
		 *the trace point events that the test validation depends on.*/
		System.gc();
		Thread.sleep(2000);
		System.gc();
	}
}
