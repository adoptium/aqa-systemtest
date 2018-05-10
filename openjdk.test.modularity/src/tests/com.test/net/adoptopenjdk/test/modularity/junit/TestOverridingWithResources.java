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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Module;
import java.net.URL;
import org.junit.Test;

/*
 * This class drives test cases of the overriding tests using --patch-module: 
 * 		"Verify if Class.getResource(), Class.getResourceAsStream(), Classloader.getResource(), 
 * 		ClassLoader.getResourceAsStream, Module.getResourceAsStream work on 
 * 		resources specified on --patch-module"
 * */

public class TestOverridingWithResources {
	
	/*
	 * Verifies loading of a resource file in an overridden
	 * module using CLass.getResource()
	 * */
	
	@Test
	public void testPatchedResourceLoading_Using_Class_getResource () {

		String name = null;		
		URL url = this.getClass().getResource("com.discreet/adoptopenjdk/test/modularity/exported/resource.properties");
		
		assertNotNull("URL resource.properties lookup using "
				+ "Class.getResource() is null", url);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String propertyLine = br.readLine();
			
			assertNotNull("Can not read properties file under a "
					+ "different module than the test class", propertyLine);
			
			assertTrue(propertyLine.equals("a=2"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/*
	 * Verifies loading of a resource file in an overridden
	 * module using CLass.getResourceAsStream()
	 * */
	
	@Test
	public void testPatchedResourceLoading_Using_Class_getResourceAsStream() {
		String name = null;	
		InputStream stream = this.getClass().getResourceAsStream("com.discreet/adoptopenjdk/test/modularity/exported/resource.properties");
		
		assertNotNull("Null InputStream returned while looking up "
				+ "propertiles file under different module", stream);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			String propertyLine = br.readLine();
			
			assertNotNull("Can not read properties file under a "
					+ "different module than the test class", propertyLine);
			
			assertTrue(propertyLine.equals("a=2"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	/*
	 * Verifies loading of a resource file in an overridden
	 * module using CLassLoader.getResource()
	 * */
	
	@Test
	public void testPatchedResourceLoading_Using_ClassLoader_getResource () {

		String name = null;		
		URL url = ClassLoader.getSystemResource("com.discreet/adoptopenjdk/test/modularity/exported/resource.properties");
		
		assertNotNull("URL resource.properties lookup using "
				+ "Class.getResource() is null", url);
		
		name = url.toString(); 
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String propertyLine = br.readLine();
			
			assertNotNull("Can not read properties file under a "
					+ "different module than the test class", propertyLine);
			
			assertTrue(propertyLine.equals("a=2"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	/*
	 * Verifies loading of a resource file in an overridden
	 * module using CLassLoader.getResourceAsStream()
	 * */
	
	@Test
	public void testPatchedResourceLoading_Using_ClassLoader_getSystemResourceAsStream () {
		String name = null;	
		InputStream stream = ClassLoader.getSystemResourceAsStream("com.discreet/adoptopenjdk/test/modularity/exported/resource.properties");
		
		assertNotNull("Null InputStream returned while looking up "
				+ "propertiles file under different module", stream);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			String propertyLine = br.readLine();
			
			assertNotNull("Can not read properties file under a "
					+ "different module than the test class", propertyLine);
			
			assertTrue(propertyLine.equals("a=2"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	/*
	 * Verifies loading of a resource file in an overridden
	 * module using Module.getResourceAsStream()
	 * */
	
	@Test
	public void testPatchedResourceLoading_Using_Module_getSystemResourceAsStream () {
		String name = null;	
		
		try {
			InputStream stream = this.getClass().getModule().getResourceAsStream("com.discreet/adoptopenjdk/test/modularity/exported/resource.properties");
			
			assertNotNull("Null InputStream returned while looking up "
				+ "propertiles file under different module", stream);
		
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(stream));
				String propertyLine = br.readLine();
				
				assertNotNull("Can not read properties file under a "
						+ "different module than the test class", propertyLine);
				
				assertTrue(propertyLine.equals("a=2"));
			} catch (IOException e) {
				e.printStackTrace();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
