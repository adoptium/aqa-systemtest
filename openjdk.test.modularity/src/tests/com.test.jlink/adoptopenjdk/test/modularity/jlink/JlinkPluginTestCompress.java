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

package adoptopenjdk.test.modularity.jlink;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

import adoptopenjdk.test.modularity.hello.*;

public class JlinkPluginTestCompress
{
	@Test
	public void testCompress() throws Exception
	{		
		File modBefore = new File(System.getProperty("modpath.before"));
		File modAfter = new File(System.getProperty("modpath.after"));
		
		assertNotNull(modBefore);
		assertNotNull(modAfter);
		
		double sizeBefore = modBefore.length();
		double sizeAfter = modAfter.length();
		
		System.out.println("Modules Size before : " + (sizeBefore / 1024) + " KB");
		System.out.println("Modules Size after  : " + (sizeAfter / 1024)  + " KB");
		
		assertTrue (sizeBefore > sizeAfter);
	}
	
}
