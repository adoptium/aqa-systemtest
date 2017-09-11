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
import java.lang.annotation.Retention;
import java.lang.reflect.Field;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lang.annotations.A5.Priority;


/*
 * This class tests (stresses) the internal caching of
 * Java field annotations within the JVM.  
 */
public class AnnotationFieldTests extends TestCase
{
	public AnnotationFieldTests(String name)
	{
		super(name);		
	}  
	          
	public void testField1() throws NoSuchFieldException
	{		
		Field myField = AnnotatedElements.class.getDeclaredField("field1");

		A0 myAnnotation = myField.getAnnotation(A0.class);
		assertTrue(myAnnotation != null);
		assertTrue(myAnnotation.id() == -1);
		assertTrue(myAnnotation.description().equals("no description exists"));
		
		assertTrue(myField.isAnnotationPresent(A0.class));
		// @A1 should not exist for field1
		assertFalse(myField.isAnnotationPresent(A1.class));
	}
	
	public void testField2() throws NoSuchFieldException
	{		
		Field myField = AnnotatedElements.class.getDeclaredField("field2");

		A0 myAnnotation = myField.getAnnotation(A0.class);			
		assertTrue(myAnnotation != null);				
		assertTrue(myAnnotation.id() == 2);
		assertTrue(myAnnotation.description().equals("This is field2"));			
		
		for (int loop=0; loop<5; loop++)
		{
			// Get all annotations associated with the field "field2"
			// and check that the number of annotations is what we expect it to be
			Annotation[] annotationArray = myField.getDeclaredAnnotations();
			int NumExpectedAnnotations = 0;
			try
			{
				NumExpectedAnnotations = myField.getInt(null);
			}
			catch (Exception e)
			{
				fail("Error!: " + e.getMessage());
			}
			// Make sure the number of annotations is the same as the number in the returned array
			assertTrue( NumExpectedAnnotations == annotationArray.length);
	
			boolean[] annot_count = new boolean[] {false, false};
			for (int i=0; i<NumExpectedAnnotations; i++)
			{
				if (annotationArray[i] instanceof A0)
				{
					A0 a = (A0) annotationArray[i];
					assertTrue(a.id() == 2);
					annot_count[0] = true;
				}
				else if (annotationArray[i] instanceof A1)
				{
					A1 a = (A1) annotationArray[i];
					assertTrue(a.origin().equals("USA"));
					annot_count[1] = true;				
				}
				else
				{
					fail("Error! Unknown annotation instance detected in field2!");				
				}
				// Set the array element to null. This tests that this is a copy of the annotation array
				// held by the JVM (e.g. modifying our copy of the array has no effect on the real array)
				annotationArray[i] = null;
			}
			// Make sure that both @A0 and @A1 were found
			assertTrue(annot_count[0] && annot_count[1]);
		}
					
		// Call getAnnotations() rather than getDeclaredAnnotations()
		// Both methods should return the same array of annotations
		Annotation[] annotationArray = myField.getAnnotations();
		boolean[] annot_count = new boolean[] {false, false};		
		for (int i=0; i<annotationArray.length; i++)
		{
			if (annotationArray[i] instanceof A0)
			{
				A0 a = (A0) annotationArray[i];
				assertTrue(a.id() == 2);
				annot_count[0] = true;
			}
			else if (annotationArray[i] instanceof A1)
			{
				A1 a = (A1) annotationArray[i];
				assertTrue(a.origin().equals("USA"));
				annot_count[1] = true;				
			}
			else
			{
				fail("Error! Unknown annotation instance detected in field2!");				
			}
			// Set the array element to null. This tests that this is a copy of the annotation array
			// held by the JVM (e.g. modifying our copy of the array has no effect on the real array)
			annotationArray[i] = null;
		}

		
	}
	
	public void testField3() throws NoSuchFieldException
	{		
		Field myField = AnnotatedElements.class.getDeclaredField("field3");
		Annotation[] annotationArray = null;
		annotationArray = myField.getDeclaredAnnotations();
		int NumExpectedAnnotations = 0;
		try
		{
			NumExpectedAnnotations = myField.getInt(null);
		}
		catch (Exception e)
		{
			fail("Error in retrieving int value from field3!");
		}
		// Make sure the number of annotations is the same as the number in the returned array
		assertTrue( NumExpectedAnnotations == annotationArray.length);			
		for (int j=0; j<annotationArray.length; j++)
		{
			if (annotationArray[j] instanceof A5)
			{
				A5 a = (A5) annotationArray[j];
				assertTrue(a.priority() == Priority.MEDIUM);					
				assertTrue(a.createdBy().equalsIgnoreCase("Bob Bobson"));					
			}
		}
		Annotation myAnnotation = null;
		myAnnotation = myField.getAnnotation(A0.class);
		assertTrue(myAnnotation != null);
		
		myField.getDeclaredAnnotations();
		
		myAnnotation = myField.getAnnotation(A1.class);
		assertTrue(myAnnotation != null);	
		myAnnotation = myField.getAnnotation(A2.class);
		assertTrue(myAnnotation != null);
		myAnnotation = myField.getAnnotation(A3.class);
		assertTrue(myAnnotation != null);
		
		myField.getDeclaredAnnotations();
		
		myAnnotation = myField.getAnnotation(A4.class);
		assertTrue(myAnnotation != null);		
		myAnnotation = myField.getAnnotation(A5.class);
		assertTrue(myAnnotation != null);
	}	
	

	// Annotations may include other annotations. These other annotations are "meta annotations"
	// because they describe annotations
	public void testMetaAnnotation() throws NoSuchFieldException
	{
		Field myMetaField = AnnotatedElements.class.getDeclaredField("field4");

		// The @A_Meta annotation has an annotation called @MetaAnnotation2
		A_Meta am = myMetaField.getAnnotation(A_Meta.class);
		assertTrue( am.annotationType().isAnnotationPresent(MetaAnnotation2.class));
		assertTrue( am.annotationType().isAnnotationPresent(MetaAnnotation3.class));
		
		Annotation[] annot1 = am.annotationType().getAnnotations();
		// 3 annotations should be present: @MetaAnnotation2,@MetaAnnotation3,@Retention
		assertTrue (annot1.length == 3);
		
		boolean[] annot_count = new boolean[] {false, false, false};		
		for (int i=0; i<annot1.length; i++)
		{
			if (annot1[i] instanceof Retention)
				annot_count[0] = true;
			else if (annot1[i] instanceof MetaAnnotation2)
				annot_count[1] = true;				
			else if (annot1[i] instanceof MetaAnnotation3)
				annot_count[2] = true;				
			else
				fail("Error! Unknown annotation instance detected in field2!");							
		}
		// Make sure all three annotations were found
		assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);		
		
		// @MetaAnnotation2 has an annotation called @MetaAnnotation
		Annotation annot2 = MetaAnnotation2.class.getAnnotation(MetaAnnotation.class);
		assertTrue(annot2 != null);
		assertTrue(annot2 instanceof MetaAnnotation);		
	}
}
