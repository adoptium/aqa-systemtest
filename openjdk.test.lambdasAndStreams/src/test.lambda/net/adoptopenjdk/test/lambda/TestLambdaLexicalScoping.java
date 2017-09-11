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

package net.adoptopenjdk.test.lambda;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This test case verifies that 'this' references are using methods and data from 
 * the current scope.
 * 
 * In order to attempt to confuse the compiler/JVM, the test has an inner class with
 * methods and fields that have the same name as methods and fields in the enclosing class.   
 */
public class TestLambdaLexicalScoping extends TestCase {
	interface Creator { 
		String get();
	}
	
	// Create field with same name as that used by inner class.
	// Need to make sure the correct field is used.
	private String name = "topLevelClassesName";
	
	private String getTestName() { 
		return name;
	}
	
	public String toString() { 
		return "LambdaTesting";
	}
 
	// Reference to this in a lambda. 
	@Test public void testSimpleThisScope() {
		// Simplest case
		Creator creator = () -> this.toString() + ", " + this.name + ", " + this.getTestName() + ", " + getTestName();
		String result = creator.get();
		assertEquals("LambdaTesting, topLevelClassesName, topLevelClassesName, topLevelClassesName", result);
	}

	static class Inner { 
		private File tmpFile = new File("/tmp/scratch.txt");
		private String name;
		private Creator innerLambda = () -> this.tmpFile.getParentFile().getName() + ":" + this.name;
		
		public Inner(String name) {
			this.name = name;
		}
		
		public String getTestName() { 
			return name;
		}
		
		public String run(String prefix, Creator parameterLambda) {
			// Create a lambda which uses a this reference, which should refer
			// to an instance of the inner class 
			Creator localLambda = () -> this.getTestName();
			
			return prefix
					+ ", " + innerLambda.get()
					+ ", " + localLambda.get()
					+ ", " + parameterLambda.get();
		}
	}
	
	// Testcase for an inner class which uses a this reference. 
	// This makes sure that the correct version of the referenced fields are used.
	@Test public void testInnerClassThisReference() {
		// Create a lambda with a this reference, to pass into inner class.
		// It is executed by the inner class but its 'this' should be referring to 
		// the outer class.
		Creator parameterLambda = () -> "(" + this.name + ")";
		
		String actual = new Inner("abc").run("x", parameterLambda);
		assertEquals("x, tmp:abc, abc, (topLevelClassesName)", actual);
	}
}
