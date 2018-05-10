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

/*
 * For related test cases implementation, please also see PatchModuleTest.java
 * 
 * Use Cases: 
 * 
 * 1) Verify if we can specify multiple file paths to --patch-module
 * 2) Verify if we can specify different file types 
 * 			(Files - can be new class files, new packages containing 
 * 			classes or resources, existing resource files) to --patch-module
 * */ 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import org.junit.Test;

import adoptopenjdk.test.modularity.hello.*;

public class TestOverrideUsingMultipleFilePaths {
	
	/**
	 * Test case 1: 
	 * Verify if we can specify multiple file paths to --patch-module.
	 * 
	 * From PatchModuleTest.java, we specify two versions of com.hello 
	 * module, while invoking this test.  
	 * 
	 * As a verification criteria, the test checks patching of an 
	 * existing class adoptopenjdk/test/modularity/hello/Hello. It ensures Hello.name() 
	 * returns the value from the overriding implementation of Hello.name() method
	 * found in common-override/com.hello, which is specified as 
	 * one of the two modules in --patch-module 
	 * (i.e, --patch-module com.hello=<common-override/com.hello>; 
	 * 				<common-override/new/com.hello>)
	 * */
	@Test
	public void testOverridingOfExistingClass () {
		/*Expect to see the value returned by the Hello.name() method
		 * of the overriding common-override/com.hello module*/
		String name = Hello.name();
		assertEquals("Override", name);
	}	
	
	/**
	 * Testcase 2.1 - Verify if we can provide new class files 
	 * 
	 * This test attempts to load a new class defined in common-override/new/com.hello
	 * which is absent in common-override/com.hello. 
	 * */
	@Test
	public void testPatchingOfNewClassInExistingPackage () {
		/*Invoke a method from a new class added by the overriding 
		 * common-override-new/com.hello module.*/
		try {
			Class<?> loadedClass = this.getClass().getClassLoader().loadClass("adoptopenjdk.test.modularity.hello.NewClass1");
			Object obj = loadedClass.getConstructor().newInstance();
			
			Method nameMethod = loadedClass.getMethod("name");
			String returnVal = (String)nameMethod.invoke(obj);
			assertTrue(returnVal.equals("OverrideNewClass1"));		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (NoSuchMethodException e) {
			e.printStackTrace();
		}   catch (IllegalAccessException e) {
			e.printStackTrace();
		}  catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testcase 2.2 - Verify if we can provide new packages  
	 * 
	 * This test attempts to load a new class defined in a new package 
	 * in common-override/new/com.hello 
	 * which is absent in common-override/com.hello. 
	 * 
	 * Note: For this test to run, we have added 
	 * the new package via -addExports option in the invocation 
	 * of this test in PatchModuleTest.java, without -AddExports, 
	 * the test will throw an IllegalAccessException for 
	 * attempting to access a package that is not originally
	 * exported by com.hello module. 
	 * */
	@Test
	public void testPatchingOfNewPackage () {
		/*Invoke a method from a new class added by the overriding 
		 * common-override-new/com.hello module.*/
		try {
			Class<?> loadedClass = this.getClass().getClassLoader().loadClass("adoptopenjdk.test.modularity.newpkg.NewClass2");
			Object obj = loadedClass.getConstructor().newInstance();
			
			Method nameMethod = loadedClass.getMethod("name");
			String returnVal = (String)nameMethod.invoke(obj);
			assertTrue(returnVal.equals("OverrideNewClass2"));		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (NoSuchMethodException e) {
			e.printStackTrace();
		}   catch (IllegalAccessException e) {
			e.printStackTrace();
		}  catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
