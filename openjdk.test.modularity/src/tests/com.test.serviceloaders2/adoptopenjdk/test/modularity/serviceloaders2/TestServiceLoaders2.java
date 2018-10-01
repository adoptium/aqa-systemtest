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

package adoptopenjdk.test.modularity.serviceloaders2;
import adoptopenjdk.test.modularity.display.*;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Module;
import java.util.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.module.ModuleDescriptor;

/*
User Story : 

1) As a developer I can enable my application to make use of different service implementations/providers 
   using the same  service interface APIs

2) As a developer, I can use the service interface in my application module to resolve to the correct 
   service provider when there are multiple service provider jars  specified on the module path 
   (service provider jars should be converted to automatic modules when specified on the modulepath)

3) As a developer, I can use the service interface in my application module to resolve to the 
   correct service provider when there are multiple service provider jars  specified on the module 
   path (provider1 - as exploded modules, provider2 - as modular jar, provider3 - regular jar 
   with META_INF/services on modulepath) and classpath (provider 4 - regular jar with META_INF/services)

 Note: This test is same as TestServiceLoader.java, but programatically adds readability edge to 
 displayService and uses the service instead of adding through module-info.java.
*/

public class TestServiceLoaders2 {
	@Test
	public void testServiceLoader () throws java.lang.ClassNotFoundException {
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 1 ; i <= 4; i++) {
			list.add("DisplayServiceImpl" + i);
		}
		
		Module module1 = Class.forName(this.getClass().getName()).getModule();
		Module module2 = Class.forName("adoptopenjdk.test.modularity.display.Display").getModule();
		String modName1 = module1.getName();
		String modName2 = module2.getName();
		
		assertEquals(modName1, "com.test.serviceloaders2");
		assertEquals(modName2, "displayService");
		
		// Add readability edge if com.test.serviceloaders2 module is not an automatic module 
		// since automatic modules can read other modules
		ModuleDescriptor md = module1.getDescriptor();
		if (!(md.isAutomatic())) {			
			// Add readability edge from Module1 to Module2
			module1.addReads(module2);	
		}
			
		// Assert if module1 can read module2 after adding readability edge
		assertTrue(module1.canRead(module2));
		
		System.out.println("Added readability edge via addReads() API from " + module1.getName() + " to " + module2.getName());
	
		// Add uses from module1 to Display service
		module1.addUses(Class.forName("adoptopenjdk.test.modularity.display.Display"));
		
		// Assert if module1 can use the Display service
		assertTrue(module1.canUse(Class.forName("adoptopenjdk.test.modularity.display.Display")));
		
		System.out.println("Added uses edge via addUses() API from " + module1.getName() + " to " + module2.getName());
		
		ServiceLoader<Display> sl = ServiceLoader.load(Display.class);
        Iterator<Display> iter = sl.iterator();
        
         if (!iter.hasNext()) {
             throw new RuntimeException("No service providers found!");
		}
     
		Display provider = null;	
		
		for(Display h : sl) {
			provider = h;
			if (h.display().equals("DisplayServiceImpl1")) {
				Module m = Class.forName(h.getClass().getName()).getModule();
				assertEquals("displayServiceImpl1",m.getName());
					
				ModuleDescriptor desc = m.getDescriptor();
				// Verify if DisplayServiceImpl1 module is not an automatic module
				assertFalse(desc.isAutomatic());					
					
			} else if (h.display().equals("DisplayServiceImpl2")) {
				Module m = Class.forName(h.getClass().getName()).getModule();
				assertEquals("displayServiceImpl2",m.getName());
					
				ModuleDescriptor desc = m.getDescriptor();
				// Verify if DisplayServiceImpl2 module is not an automatic module
				assertFalse(desc.isAutomatic());
				
			} else if (h.display().equals("DisplayServiceImpl3")) {
				Module m = Class.forName(h.getClass().getName()).getModule();
				assertEquals("displayServiceImpl3",m.getName());
					
				ModuleDescriptor desc = m.getDescriptor();
				// Verify if DisplayServiceImpl3 module is  an automatic module
				assertTrue(desc.isAutomatic());		
					
			} else if (h.display().equals("DisplayServiceImpl4")) {
				Module m = Class.forName(h.getClass().getName()).getModule();
				assertNull(m.getName());
					
				ModuleDescriptor desc = m.getDescriptor();
				// Verify if DisplayServiceImpl4 module is  an unnamed module
				assertNull(desc);
			}				
		}
			
		// Verify if all the service providers are loaded
		ArrayList<String> actual = new ArrayList<String>();
		for(Display h : sl){
			provider = h;
			String name = provider.display();
			actual.add(name);
			System.out.println(name);				
		}			
			
		for(String str : list) {
			assertTrue(actual.contains(str));
		}
	}
}
