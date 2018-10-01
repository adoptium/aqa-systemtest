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

package net.adoptopenjdk.test.lang.annotations;

import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * This class is the annotation junit test suite which contains the various different
 * Java annotation tests. Launch this class to run all annotation tests.
 * The annotation tests are designed to put stress on annotation API and do not
 * attempt to test performance. The annotations are cached internally by the JVM
 * and these tests will exercise this caching functionality by making many calls
 * (stressing) to the various annotation methods. The annotation tests cover:
 * classes, fields, methods, constructors, enums and packages.
 */
public class AnnotationTests {

	public static Test suite() {	
		TestSuite suite = new TestSuite(AnnotationTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AnnotationFieldTests.class);
		suite.addTestSuite(AnnotationMethodTests.class);
		suite.addTestSuite(AnnotationClassTests.class);
		suite.addTestSuite(AnnotationEnumTests.class);
		suite.addTestSuite(AnnotationConstructorTests.class);		
		suite.addTestSuite(AnnotationPackageTests.class);		
		//$JUnit-END$
		return suite;
	}

}
