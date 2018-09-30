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

import java.lang.reflect.*;
import java.lang.module.*;
import static org.junit.Assert.*;
import org.junit.Test;
import sun.misc.*;
import sun.reflect.*;
import java.net.URL;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

 /* 
 * User story:
 * As a customer I can migrate my Java application using encapsulated JDK internal 
 * APIs to Java 9 by using the work around option provided (--add-exports)
 *  
 * Use case1: Invocation of critical internal APIs (sun.misc.{Signal,SignalHandler, Unsafe}, 
 * sun.reflect.Reflection, ReflectionFactory) from a non-modularized application should work 
 * without any explicit exports.

 * Use case2: Invocation of critical internal APIs (sun.misc.{Signal,SignalHandler, Unsafe}, 
 * sun.reflect.Reflection, ReflectionFactory) from a modularized application as an exploded 
 * directory should work  when it requires the jdk.unsupported module.

 * Use case3: Invocation of critical internal APIs (sun.misc.{Signal,SignalHandler, Unsafe}, 
 * sun.reflect.Reflection, ReflectionFactory) from a modularized application in a modular jar 
 * should work  when it requires the jdk.unsupported module.

 * Use case4: Invocation of critical internal APIs (sun.misc.{Signal,SignalHandler, Unsafe}, 
 * sun.reflect.Reflection, ReflectionFactory) from a an automatic module should work  
 * without reading the jdk.unsupported module.
 */

public class TestJDKInternalAPIs{
	@Test
	public void testExportedCriticalAPIs() {
		String[] criticalAPIs = {"sun.misc.Unsafe", "sun.misc.Signal", 
				"sun.misc.SignalHandler", "sun.reflect.Reflection", "sun.reflect.ReflectionFactory"};
		for (String name : criticalAPIs) {
			try {
				Module mod = Class.forName(name).getModule();
				String modName = mod.getName();
			    assertEquals("jdk.unsupported", modName); 
				
				boolean pass = false;
				if (name.equals("sun.misc.Unsafe")) {
					try {
						sun.misc.Unsafe unsafe = Unsafe.getUnsafe();
						fail("Using Unsafe failed to throw exception!");
					} catch (SecurityException e) {
						pass = true;
					}
					assertTrue("Received the expected exception while accessing sun.misc.Unsafe", pass);
					
				} else if (name.equals("sun.misc.Signal")) {
					Signal signal = new Signal("TERM");
				
				} else if (name.equals("sun.misc.SignalHandler")) {
					SignalHandler handler = new SignalHandler();
					handler.handle(new Signal("INT"));
					
				} else if (name.equals("sun.reflect.Reflection")) {
					Class<?> c = Reflection.getCallerClass(3);
					
				} else if (name.equals("sun.reflect.ReflectionFactory")) {
					ReflectionFactory factory = ReflectionFactory.getReflectionFactory();
					
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		}
	}		
}

class SignalHandler implements sun.misc.SignalHandler {
	@Override
	public void handle(Signal arg0) {
		
	}
}
