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

package adoptopenjdk.test.modularity.jlink;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.*;
import java.util.Properties;

import net.adoptopenjdk.stf.StfException;

public class JlinkPluginTestReleaseInfo
{
	@Test
	public void testReleaseInfo() throws Exception
	{		
		Properties releaseInfo = new Properties();
		releaseInfo.load(new FileInputStream(System.getProperty("release.info.file")));

		boolean releaseInfoAppended = false; 

		Object value = releaseInfo.get("UseYour");
		if (value != null) {
			if (((String)value).equals("Illusion")) {
				releaseInfoAppended = true;
			}
		}

		assertTrue("Release info (key,value) pair was not appended to release file of "
					+ "the runtime image", releaseInfoAppended);
	}
}
