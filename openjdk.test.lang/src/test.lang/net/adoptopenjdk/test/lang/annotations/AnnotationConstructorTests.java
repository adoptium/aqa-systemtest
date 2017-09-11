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

package net.adoptopenjdk.test.lang.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import junit.framework.*;

/*
 * This class tests (stresses) the internal caching of
 * Java class annotations within the JVM.  
 */
public class AnnotationConstructorTests extends TestCase
{

	static class TestClass1
	{
		@A0 @A5
		public TestClass1(@A0 Integer p1, @A0 @A1 @A2 @A3 String name) {}
		
		public TestClass1(@A1 @A3 @A5 Integer p1) {}
		
		public TestClass1() {}		
		
	}
	
	public AnnotationConstructorTests(String name)
	{
		super(name);		
	}
	
	// Retrieve the annotations for TestClass1(Integer, String)
	public void testConstructor1()
	{
		try
		{
			Constructor<TestClass1> ctor = TestClass1.class.getConstructor
				(new Class[] {Integer.class, String.class});
					
			Annotation[] ctor_annotations = ctor.getDeclaredAnnotations();
			assertTrue( ctor_annotations.length == 2);

			boolean[] annot_count = new boolean[] {false, false};
			for (int i=0; i<2; i++) 
			{
				assertTrue( ctor_annotations[i].annotationType().equals(A0.class)
						|| ctor_annotations[i].annotationType().equals(A5.class));
				
				if (ctor_annotations[i] instanceof A0)
				{
					annot_count[0] = true;
				}
				else if (ctor_annotations[i] instanceof A5)
				{
					annot_count[1] = true;			
				}								
			}
			
			A0 a0 = (A0) ctor.getAnnotation(A0.class);
			assertTrue (ctor.getAnnotation(A0.class).equals(a0));
			A5 a5 = (A5) ctor.getAnnotation(A5.class);
			assertTrue (ctor.getAnnotation(A5.class).equals(a5));
			
			// Make sure both @A0 and @A5 were found
			assertTrue (annot_count[0] && annot_count[1]);
					
			// Verify the annotations associated with the constructor parameters			
			Annotation[][] params = ctor.getParameterAnnotations();
			assertTrue(params.length != 0);	
			// first parameter has 1 annotation
			assertTrue(params[0].length  == 1);
			// second parameter has 4annotations			
			assertTrue(params[1].length  == 4);
			assertTrue(params[0][0] instanceof A0);
			
			annot_count = new boolean[] {false, false, false, false};
			for (int i=0; i<4; i++)
			{		
				if (params[1][i] instanceof A0)
				{
					annot_count[0] = true;
				}
				else if (params[1][i] instanceof A1)
				{
					annot_count[1] = true;
				}
				else if (params[1][i] instanceof A2)
				{
					annot_count[2] = true;
				}
				else if (params[1][i] instanceof A3)
				{
					annot_count[3] = true;
				}
			}				
			assertTrue (annot_count[0] && annot_count[1] &&
					annot_count[2] && annot_count[3]);		                                                            
		}
		catch (NoSuchMethodException e)
		{
			fail("Failed to get TestClass1 constructor (Integer, String): " + e.getMessage());
		}		
	}
	
	// Verify the annotations for constructor TestClass1(Integer)
	public void testConstructor2()
	{
		try
		{
			Constructor<TestClass1> ctor = TestClass1.class.getConstructor
				(new Class[] {Integer.class});
						
			// No annotations should be present on the constructor itself
			Annotation[] ctor_annotations = ctor.getDeclaredAnnotations();
			assertTrue( ctor_annotations.length == 0);			
			ctor_annotations = ctor.getAnnotations();
			assertTrue( ctor_annotations.length == 0);			

			// 3 parameter annotation should be present on the constructor
			Annotation[][] params = ctor.getParameterAnnotations();
			assertTrue(params.length != 0);  // there are parameters
			// first parameter has 3 annotations
			assertTrue(params[0].length  == 3);
		}
		catch (NoSuchMethodException e)
		{
			fail("Failed to get TestClass1 constructor (Integer)");
		}
	}
	
	// Verify the annotations for constructor TestClass1()
	public void testConstructor3()
	{
		try
		{
			Constructor<TestClass1> ctor = TestClass1.class.getConstructor();
						
			// No annotations should be present on the constructor itself
			Annotation[] ctor_annotations = ctor.getDeclaredAnnotations();
			assertTrue( ctor_annotations.length == 0);			
			ctor_annotations = ctor.getAnnotations();
			assertTrue( ctor_annotations.length == 0);			

			// No parameters (and therefore no parameter annotations) should be
			// present on the constructor
			Annotation[][] params = ctor.getParameterAnnotations();
			assertTrue(params.length == 0); // no parameters

		}
		catch (NoSuchMethodException e)
		{
			fail("Failed to get TestClass1 constructor()");
		}
	}	
	
}
