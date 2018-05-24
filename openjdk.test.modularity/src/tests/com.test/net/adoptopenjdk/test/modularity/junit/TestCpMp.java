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
import adoptopenjdk.test.modularity.hello.Hello;
import adoptopenjdk.test.modularity.hi.*;

import static org.junit.Assert.*;
import org.junit.Test;

/*
User Story : As a Tester I can run my modularized tests specified on 
modulepath using the non-modularized test harness on the classpath.

Use case 1: Verify if a modularized test works with test harness on classpath

*/

public class TestCpMp {
	@Test
	public void testCpMp () throws java.lang.ClassNotFoundException {
		String name = Hello.name();
		assertEquals("Hello", name);
		Class c = Class.forName("adoptopenjdk.test.modularity.hello.Hello");
		String modName = c.getModule().getName();
		assertEquals("com.hello", modName);
		
		name = Hi.name();
		assertEquals("Hi", name);
		c = Class.forName("adoptopenjdk.test.modularity.hi.Hi");
		modName = c.getModule().getName();
		assertEquals(null, modName);
		
		name = HiCp.name();
		assertEquals("HiCp", name);
		c = Class.forName("adoptopenjdk.test.modularity.hi.HiCp");
		modName = c.getModule().getName();
		assertEquals(null, modName);
	}
}
