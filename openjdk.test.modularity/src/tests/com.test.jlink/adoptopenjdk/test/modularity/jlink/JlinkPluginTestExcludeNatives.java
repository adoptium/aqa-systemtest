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

import net.adoptopenjdk.stf.StfException;

public class JlinkPluginTestExcludeNatives
{
	@Test
	public void testNativeExecutebleExists() throws Exception
	{		
       String javaExecFileName = "java";
	   if (System.getProperty("platform").contains("win_x86")) {
	      javaExecFileName = javaExecFileName + ".exe";
	   }
		  
	   assertFalse("--strip-native-command option was used in jlink, "
		  		+ "but native executables still exist in image directory.", 
		  		new File(System.getProperty("image.bindir") + 
		  				System.getProperty("file.separator") + javaExecFileName).exists());
	}
}
