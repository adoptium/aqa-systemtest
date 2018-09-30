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
import junit.framework.AssertionFailedError;

/** 
 * For implementation of user story 1, please see TestClassLoadingUsingResourceFiles.java
 * FOr implementation of user story 4, please see CLTestImage.java 
*/

/**
 * User story 2: 
 * ~~~~~~~~~~~~ 
 * "As a user, I can use ClassLoader.getSystemResourceAsStream() on a 
 * class file (from classpath) or java.lang.Module#getResourceAsStream on 
 * a class file (from modules) to analyze the class byte code to check if any 
 * forbidden api's are used. The same can be extended to check what happens 
 * when a class file from unexported package is given etc."

	2.1) Given a module where one package is exported via module-info.java
		 module descriptor, and another packge is not exported, verify that 
		 an attempt to access a class in the un-exported package produces 
		 a java.lang.IllegalAccessException.  
	
	2.2) Verify that private and protected methods of an exported package
	     can not be accessed.

 * User story 3: 
 * ~~~~~~~~~~~~
 * "As a developer, I can locate and load the required classes or resources 
 * from both platform and application modules using the application class 
 * loader or custom class loader"
 
	3.1) Verify we can do a lookup using jrt:/ style URL for a class and read its bytes.
	3.2) Verifies dynamic loading of a class from an application module using 
     	 the application class loader.
	3.3) Verifies dynamic loading of a class from a platform module(java.base) 
     	 using the application class loader.
	3.4) Verifies dynamic loading of a class from a platform module using 
         the platform class loader.
	3.5) Verifies dynamic loading of a class from an application module 
    	 using a custom class loader.
	  
  * User story 5:
  * ~~~~~~~~~~~~
  * "As a developer, I can locate and load the required classes on the -Xbootclasspath 
  * by using -Xbootclasspath/a in my application
  * 
  */

public class TestClassLoading {
	
	/*
	 * 2.1) Given a module where one package is exported via module-info.java
	 * module descriptor, and another package is not exported, verify that 
	 * an attempt to access a public API of a class in the un-exported 
	 * package produces a java.lang.IllegalAccessException */
	@Test
	public void testAccessToUnexportedPackage() throws Exception {
		/* From module com.discreet, load a class that 
		 * belongs to a package that is exported.
		 */
		ModTestClassLoader customLoder = new ModTestClassLoader();
		Class<?> loadedClass = customLoder.loadClass("adoptopenjdk.test.modularity.exported.ExportedClass");
		Object obj = loadedClass.newInstance();
        Method method = loadedClass.getMethod("getPublic");
        
        assertNotNull("Failed to access exported "
        		+ "public method from module com.exported", method);
        
        String returnValue = (String)method.invoke(obj);
		assertTrue(returnValue.equals("public"));
		
		/* From module com.discreet, attempt to load a class
		 * that belongs to a package that is not exported. 
		 */
		boolean pass = false; 
		try {
			loadedClass = customLoder.loadClass("adoptopenjdk.test.modularity.hidden.Secret");
			method = loadedClass.getMethod("tell");
			returnValue = (String)method.invoke(obj);
		} catch (java.lang.IllegalAccessException e) {
			pass = true; 	
		}
		assertTrue("Unexported class accessed successfully!", pass);
	}
	
	/*
	 * 2.2) Verify that private and protected methods of an exported package
	 * an not be accessed */
	@Test
	public void testAccessPrivateProtectedAPI() throws Exception {
		ModTestClassLoader customLoder = new ModTestClassLoader();
		Class<?> loadedClass = customLoder.loadClass("adoptopenjdk.test.modularity.exported.ExportedClass");
		Object obj = loadedClass.getConstructor().newInstance();
		
		/*From module com.discreet, load an exported class and attempt to
		 * invoke its private and protected methods.
		 */
		
		boolean canNotAccessProtected = false;
		boolean canNotAccessPrivate = false;
		
		try {
			Method method = loadedClass.getMethod("getProtected");
			method.invoke(obj);
		} catch (java.lang.NoSuchMethodException e) {
			canNotAccessProtected = true; 	
		}
		
		try {
			Method method = loadedClass.getMethod("getPrivate");
			method.invoke(obj);
		} catch (java.lang.NoSuchMethodException e) {
			canNotAccessPrivate = true; 	
		}
		
		assertTrue("Illegal Access given to protected method!", canNotAccessProtected);
		assertTrue("Illegal Access given to private method!", canNotAccessPrivate);
	}
	
	/*
	 * 3.1) Verifies we can read bytes of a runtime class using jrt URL lookup */
	@Test
	public void readClassBytes() throws Exception {
		FileSystem fs = FileSystems.getFileSystem(URI.create("jrt:/"));
		Path path = fs.getPath("/modules/java.base", "java/lang/Object.class");
		byte[]	jlo	= Files.readAllBytes(path);
	
		assertNotNull("Can not read bytes of class java/lang/Object.class", jlo);
		assertTrue("Empty byte array returned for java/lang/Object.class", jlo.length != 0);
	}
	
	/*
	 * 3.2) Verifies dynamic loading of a class from an application 
	 * module using application class loader */
	@Test
	public void testClassLoadingFromApplicationModule() throws Exception {
		Class<?> loadedClass = this.getClass().getClassLoader().loadClass("adoptopenjdk.test.modularity.hola.Hi");
		Object obj = loadedClass.getConstructor().newInstance();
		
		Method setName = loadedClass.getMethod("setName", new Class[]{String.class});
		setName.invoke(obj, "John");
		Method getName = loadedClass.getMethod("getName");
		String returnValue = (String)getName.invoke(obj);
		assertTrue(returnValue.equals("John"));		
	}
	
	/*
	 * 3.3) Verifies dynamic loading of a class from a platform module (java.base)
	 * using application class loader */
	@Test
	public void testPlatformClassLoadingUsingApplicationClassLoader() throws Exception {
		Class<?> loadedClass = this.getClass().getClassLoader().loadClass("java.lang.String");
		Constructor<?> constructor = loadedClass.getConstructor(new Class[]{String.class});
		Object obj = constructor.newInstance(new Object[] {"abc"});
		Method method = loadedClass.getMethod("length");
		int returnValue = (int)method.invoke(obj);
		assertEquals(3, returnValue);			
	}

	/*
	 * 3.4) Verifies dynamic loading of a class from a platform module 
	 * using platform class loader */
	@Test
	public void testPlatformClassLoadingUsingSystemClassLoader() throws Exception {
		Class<?> loadedClass = ClassLoader.getPlatformClassLoader().loadClass("java.lang.String");
		Constructor<?> constructor = loadedClass.getConstructor(new Class[]{String.class});
		Object obj = constructor.newInstance(new Object[] {"abc"});
		Method method = loadedClass.getMethod("length");
		int returnValue = (int)method.invoke(obj);
		assertEquals(3, returnValue);		
	}
	
	/*
	 * 3.5) Verifies dynamic loading of a class from an application module 
	 * using custom class loader */
	@Test
	public void testClassLoadingUsingCustomLoader() throws Exception {
		ModTestClassLoader customLoder = new ModTestClassLoader();
		Class<?> loadedClass = customLoder.loadClass("adoptopenjdk.test.modularity.hello.Hello");
        Object obj = loadedClass.getConstructor().newInstance();
        Method method = loadedClass.getMethod("name");
        String returnValue = (String)method.invoke(obj);
		assertTrue(returnValue.equals("Hello"));	
	}
	
	/*
	 * 5) Verify that as a developer, I can locate and load the required classes on the 
	 * -Xbootclasspath by using -Xbootclasspath/a in my application. 
	 * In the test below, module 'com.hi' is not made part of modulepath, but instead 
	 * provided using -Xbootclasspath/a jvm option. Loading a class from com.hi module
	 * thus meets our testing condition.*/
	@Test
	public void testCLUsingClassAppendedViaXBootClassPath() throws Exception {
		ModTestClassLoader customLoder = new ModTestClassLoader();
		Class<?> loadedClass = customLoder.loadClass("adoptopenjdk.test.modularity.hi.Hi");
        Object obj = loadedClass.getConstructor().newInstance();
        Method method = loadedClass.getMethod("name");
        String returnValue = (String)method.invoke(obj);
		assertTrue(returnValue.equals("Hi"));	
	}
}
