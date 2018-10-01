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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import net.adoptopenjdk.test.modularity.junit.ModTestClassLoader;


/** 
 * Note:
 * For implemenntation of user story 2 and 3, please see
 * TestClassLoading.java
*/

/**
 * User story 1: 
 * ~~~~~~~~~~~~
 * "As a developer, I can use ClassLoader.getSystemResource() or 
 * Class.getResource() api's to read the resource files like security files, 
 * policy files or even class files and verify if the 'URL' supports 'jrt'."

	1.1) Ensure that we can use ClassLoader.getSystemResource() API
         to read a runtime class, and that it returns a URL that starts with jrt:
	1.2) Ensure that we can use ClassLoader.getSystemREsource() API
	 	 to read an application class, and that it returns a URL that 
	 	 does not start with jrt:.
	1.3) Verify that we can use ClassLoader.getSystemResource() API 
		 to look up URL of a resource file in the same module as the test class.
    1.4) Verify that we can use ClassLoader.getSystemResource() API 
		 to look up URL of a resource file in a different module than the test class.
	1.5) Verify that we can load a resource file / properties file 
     	 in the same module as the test class, using Class.getResource() API.
    1.6) Verify that we can load a resource file / properties file 
     	 in a the same module as the test class, using Class.getResourceAsStream() API.
    1.7) Verify that we can load a resource file / properties file 
     	 in a different module than the test class, using Class.getResourceAsStream() API.
	 *
	 */

public class TestClassLoadingUsingResourceFiles {
	
	/*
	 * 1.1) Verifies that URL for a runtime class starts with jrt */
	@Test
	public void testURLForClassInBaseModule () {
		String name = null;		
		URL url = ClassLoader.getSystemResource("java/lang/Class.class");
		assertNotNull("URL for java/lang/Class.class lookup using"
				+ " ClassLoader.getSystemResource() is null", url);
		name = url.toString();
		assertEquals(name, "jrt:/java.base/java/lang/Class.class");		
	}
	
	/*
	 * 1.2) Verifies that URL of a non-runtime class does not start with jrt */
	@Test
	public void testURLForClassInMp () {
		String name = null;		
		URL url = ClassLoader.getSystemResource("adoptopenjdk/test/modularity/hello/Hello.class");
		assertNotNull("URL for adoptopenjdk/test/modularity/hello/Hello.class lookup using "
				+ "ClassLoader.getSystemResource() is null", url);
		name = url.toString();
		if(System.getProperty("test.type").equals("customruntime")) {
			assertTrue(name.equals("jrt:/com.hello/adoptopenjdk/test/modularity/hello/Hello.class"));
		} else {
			assertTrue(!name.startsWith("jrt:"));
		}
	}
	
	/* 1.3) Verify that we can use ClassLoader.getSystemResource() API 
	 * to look up URL of a resource file in the same module as the test class */
	@Test
	public void testURLForPropertiesFileInSameModule() {
		String name = null;		
		URL url = ClassLoader.getSystemResource("adoptopenjdk/test/modularity/test/resource.properties");
		assertNotNull("URL for adoptopenjdk/test/modularity/test/resource.properties lookup using "
				+ "ClassLoader.getSystemResource() is null", url);
		name = url.toString(); 
		if(System.getProperty("test.type").equals("customruntime")) {
			assertTrue(name.equals("jrt:/com.test/adoptopenjdk/test/modularity/test/resource.properties"));
		} else {
			assertTrue(name.startsWith("file:"));
			assertTrue(name.endsWith("adoptopenjdk/test/modularity/test/resource.properties"));
		}
	}
	
	/* 1.4) Verify that we can use ClassLoader.getSystemResource() API 
	 * to look up URL of a resource file in a different module than the test class */
	@Test
	public void testURLForPropertiesFileInDifferentModule() {
		String name = null;		
		URL url = ClassLoader.getSystemResource("adoptopenjdk/test/modularity/exported/resource.properties");
		assertNotNull("URL for adoptopenjdk/test/modularity/exported/resource.properties lookup "
				+ "using ClassLoader.getSystemResource() is null", url);
		name = url.toString(); 
		if(System.getProperty("test.type").equals("customruntime")) {
			assertTrue(name.equals("jrt:/com.discreet/adoptopenjdk/test/modularity/exported/resource.properties"));
		} else {
			assertTrue(name.startsWith("file:"));
			assertTrue(name.endsWith("adoptopenjdk/test/modularity/exported/resource.properties"));
		}
	}
	
	/* 1.5) Verify that we can use Class.getResource() API 
	 * to look up URL of a resource file in the same module as the test class */
	@Test
	public void testURLForPropertiesFileUsingGetResource() {
		String name = null;		
		URL url = this.getClass().getResource("resource.properties");
		assertNotNull("URL resource.properties lookup using "
				+ "Class.getResource() is null", url);
		name = url.toString(); 
		if(System.getProperty("test.type").equals("customruntime")) {
			assertTrue(name.equals("jrt:/com.test/adoptopenjdk/test/modularity/test/resource.properties"));
		} else {
			assertTrue(name.startsWith("file:"));
			assertTrue(name.endsWith("adoptopenjdk/test/modularity/test/resource.properties"));
		}
	}
	
	/*
	 * 1.6) Verifies loading of a resource file in the same module */
	@Test
	public void testPropertiesFileLoadingFromSameModule() throws Exception {
		String name = null;	
		InputStream stream = this.getClass().
				getResourceAsStream("adoptopenjdk/test/modularity/test/resource.properties");
		
		assertNotNull("Null InputStream returned while looking up "
				+ "propertiles file under same module", stream);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String propertyLine = br.readLine();
		
		assertNotNull("Can not read properties file under the "
				+ "same module as test class", propertyLine);
		
		assertTrue(propertyLine.equals("a=1"));
	}
	
	/*
	 * 1.7) Verifies loading of a resource file in a different module */
	@Test
	public void testPropertiesFileLoadingFromDifferentModule() throws Exception {
		String name = null;	
		InputStream stream = this.getClass().getResourceAsStream("adoptopenjdk/test/modularity/exported/resource.properties");
		
		assertNotNull("Null InputStream returned while looking up "
				+ "propertiles file under different module", stream);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String propertyLine = br.readLine();
		
		assertNotNull("Can not read properties file under a "
				+ "different module than the test class", propertyLine);
		
		assertTrue(propertyLine.equals("a=1"));
	}
}
