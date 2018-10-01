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

import java.lang.annotation.Annotation;

import junit.framework.TestCase;

/*
 * This class tests (stresses) the internal caching of
 * Java package annotations within the JVM.  
 */
public class AnnotationPackageTests extends TestCase
{

	public AnnotationPackageTests(String name)
	{
		super(name);		
	}  
	
	public void testPackage1()
	{
		Package myPackage = AnnotationPackageTests.class.getPackage();
		
		Annotation[] annot_array1 = myPackage.getDeclaredAnnotations();

		// Make sure the number of annotations is the same as the number in the returned array
		assertTrue( annot_array1.length == 4);
		boolean[] annot_count = new boolean[] {false, false, false, false};			
		for (int j=0; j<annot_array1.length; j++)
		{
			if (annot_array1[j] instanceof A0)
			{
				A0 a = (A0) annot_array1[j];
				assertTrue(a.id() == 100);					
				assertTrue(a.description().equalsIgnoreCase("James Bond"));
				annot_count[0] = true;
			}
			else if (annot_array1[j] instanceof A1)
			{
				A1 a = (A1) annot_array1[j];
				assertTrue(a.origin().equalsIgnoreCase("Canada"));					
				assertTrue(a.description().equalsIgnoreCase("no description exists"));
				annot_count[1] = true;					
			}
			else if (annot_array1[j] instanceof A3)
			{
				A3 a = (A3) annot_array1[j];
				assertTrue(a.id() == -1);
				annot_count[2] = true;					
			}
			else if (annot_array1[j] instanceof A5)
			{
				A5 a = (A5) annot_array1[j];
				assertTrue(a.lastChanged().equalsIgnoreCase("21/10/2010"));
				annot_count[3] = true;					
			}					
		}
		// Make sure all annotations were found
		assertTrue (annot_count[0] && annot_count[1] && annot_count[2] && annot_count[3]);
					
		assertTrue(myPackage.getAnnotation(A0.class) != null);
		assertTrue(myPackage.getAnnotation(A1.class) != null);
		assertTrue(myPackage.getAnnotation(A3.class) != null);
		assertTrue(myPackage.getAnnotation(A5.class) != null);			
		
		assertTrue(myPackage.isAnnotationPresent(A0.class));
		assertTrue(myPackage.isAnnotationPresent(A1.class));
		assertTrue(myPackage.isAnnotationPresent(A3.class));
		assertTrue(myPackage.isAnnotationPresent(A5.class));			
				
	}

}
