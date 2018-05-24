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
import java.util.Random;


public class JniTest
{
	static {System.loadLibrary("JniTest");}
	
	native static boolean pass(boolean b); // Expects the same result out as is passed in
	native static boolean turn(boolean b); // Expects the opposite result out as is passed in

	Random rand = new Random(System.currentTimeMillis());
	
	@Test
	public void testBoolean() throws Exception	// Randomly passes or turns the variables both externally and internally then checks if they are the same  
	{
		for(int i=0; i<1000; i++)
		{
			boolean tempValue = rand.nextBoolean();
			if (rand.nextBoolean())
				assertEquals(tempValue, pass(tempValue));
			else
				assertEquals(!tempValue, turn(tempValue));
		}
	}
	
}
