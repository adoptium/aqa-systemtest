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

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestOverrideUsingUnexportedPublicType {
	
	@Test
	public void testPatchingOfNewClassInExistingPackage () throws Exception {
		
		/*Invoke a method from a new class added by the overriding 
		 * common-override-new/com.hello module.
		 * Since this class is not exported by the original (overridden) 
		 * com.hello module, it should throw java.lang.IllegalAccessException*/
		Class<?> loadedClass = this.getClass().getClassLoader().loadClass("adoptopenjdk.test.modularity.newpkg.NewClass2");
		Object obj = loadedClass.getConstructor().newInstance();
		
		Method nameMethod = loadedClass.getMethod("name");
		String returnVal = (String)nameMethod.invoke(obj);
		assertTrue(returnVal.equals("OverrideNewClass2"));		
		
	}
}
