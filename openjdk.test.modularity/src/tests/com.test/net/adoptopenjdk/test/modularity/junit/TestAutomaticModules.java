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

import adoptopenjdk.test.modularity.hi.*;
import adoptopenjdk.test.modularity.hello.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.*;
import java.lang.Module;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/* 
User story: As a developer I can use a non-modularized third party library with a 
modularized application by converting it into an automatic module  
(To convert the library jar into an automatic module, place it on the module path).

Use case 1:
Place the third party library jars on modulepath and check if public types in 
it can be accessed by an explicit module by adding a readability edge to the 
automatic modules (third party jars).

Use case 2:
Place one of third party library jar on mp, another on cp and check if the public 
types can be accessed by an explicit module by adding a readability edge to the 
automatic module and unnamed module (third party jars).
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestAutomaticModules {
	@Test
	public void testJunitAsAutomaticModule () throws java.lang.ClassNotFoundException {
		String name = null;		
		Class c = Class.forName("org.junit.runner.JUnitCore");
		String modName = c.getModule().getName();
		assertEquals("junit", modName);		
	}
	
	@Test
	public void accessPublicTypeFromExplicitModularJaronMp () throws java.lang.ClassNotFoundException {		
		String name = Hello.name();
		assertEquals("Hello", name);
		Class c = Class.forName("adoptopenjdk.test.modularity.hello.Hello");
		String modName = c.getModule().getName();
		assertEquals("com.hello", modName);	
	}
	
	/*Note: 
	 * We need to run test accessPublicTypeFromAutomaticModuleWithReadabilityDisabled() before 
	 * accessPublicTypeFromAutomaticModuleWithReadabilityEnabled().  
	 * 
	 * We provide read access to common from module com.test in accessPublicTypeFromAutomaticModuleWithReadabilityEnabled(). 
	 * So, if these two tests are *not* executed in the above sequence, the testing without read 
	 * (i.e. accessPublicTypeFromAutomaticModuleWithReadabilityDisabled()) will fail since the expected exeception will not be thrown.
	 * 
	 * The execution sequenceing is established by the use of Junit MethodSorters and ensuring that
	 *  the test without readability edge has a method name that appears earlier in the lexicographic order, 
	 *  than the one with readability edge.
	 */ 
	@Test
	public void accessPublicTypeFromAutomaticModuleWithReadabilityDisabled() throws java.lang.ClassNotFoundException {
		String name = null;
		boolean result = false;
		try {
			name = Hi.name();
		}
		catch(java.lang.IllegalAccessError ex){
			result = true;
		}
		assertTrue("Access to public type from automatic module granted "
				+ "to an explicit module, where there exists no readability "
				+ "edge between the two", result);
	}
}
