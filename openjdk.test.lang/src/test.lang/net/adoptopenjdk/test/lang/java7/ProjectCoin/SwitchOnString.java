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

package net.adoptopenjdk.test.lang.java7.ProjectCoin;

/*
 * SwitchOnString
 * ==============
 * 
 * Switching on Strings is now legal in Java70. We have an array of strings that we pass in one by one, and 
 * verify that we fall into the correct switch statement for that string.
 */

public class SwitchOnString extends CoinTest {
	public SwitchOnString() {
		setDebug(false);//If true, debug output will get printed out to System.out, and probably fail the test!
	}
	
	private void doSwitchOnString(String inputString) {
		boolean failedToMatch = false;
		switch (inputString) {
		case "123abc":
			assertEquals("Comparison #1 Failed!",inputString,"123abc");
			break;
		case "AAA111AAA":
			assertEquals("Comparison #2 Failed!",inputString,"AAA111AAA");
			break;
		case "!£$%^&*()-=_+[]{};'#:@~<>?,./\\":
			assertEquals("Comparison #3 Failed!",inputString,"!£$%^&*()-=_+[]{};'#:@~<>?,./\\");
			break;
		case "firstline\nsecondline":
			assertEquals("Comparison #4 Failed!",inputString,"firstline\nsecondline");
			break;
		case "":
			assertEquals("Comparison #5 Failed!",inputString,"");
			break;
		default :
			failedToMatch = true;
			break;
		}
		if(inputString == "ThisOneIsNotMatched"){
			assertTrue("Comparison #7 Failed!",failedToMatch);
		}
	}
	
	public void testSwitchOnString() {
		String[] strings = {"123abc","AAA111AAA","!£$%^&*()-=_+[]{};'#:@~<>?,./\\}","firstline\nsecondline","","ThisOneIsNotMatched"};
		for(String s : strings) {
			doSwitchOnString(s);
		}
	}
	
	public static void main(String[] args){
		(new SwitchOnString()).testSwitchOnString();
	}

}
