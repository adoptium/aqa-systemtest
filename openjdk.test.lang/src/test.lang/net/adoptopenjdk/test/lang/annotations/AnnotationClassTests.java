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

import junit.framework.*;

/*
 * Class to run in a multi-threaded workload that tests the internal caching of
 * Java class annotations within the JVM.  
 */

public class AnnotationClassTests extends TestCase
{
	@A0 @A1 @A6
	class MyTestClass1
	{
	
	}
	
	@A0
	class MyTestClass2
	{
	
	}
	
	@A0 @A6
	class MyTestClass3
	{
	
	}
	
	@A1
	class MyTestClass4
	{
	
	}
	
	@A0 @A1 @A6 @A3
	class MyTestClass5
	{
	
	}
	
	// 3 class hierarchy
	@A0
	class MyTestClassBase {}
	
	@A1 @A2
	class MyTestClassSub1 extends MyTestClassBase{}

	@A3
	class MyTestClassSub2 extends MyTestClassSub1{}

	
	public void testClass1()
	{		
		// Verify that the AnnotatedElements class contains the correct annotations
		Annotation[] class_annotations = AnnotatedElements.class.getAnnotations();
		assertTrue(class_annotations.length == 1);		
		assertTrue(class_annotations[0] instanceof A6);			
		
		assertTrue(( (A6) class_annotations[0] ).description().equals("This is a java type annotation type"));
		
		// Next verify the annotations associated with the inner classes		
		Annotation[] class_annot1 = MyTestClass1.class.getAnnotations();
		assertTrue(class_annot1.length == 3);		
		// Set the array entries to null to test that modifications to the retrieve array
		// are not visible in subsequent calls to getAnnotations()
		class_annot1[0] = null;
		class_annot1[1] = null;
		class_annot1[2] = null;				
		Annotation[] class_annot2 = MyTestClass1.class.getAnnotations();
		assertTrue(class_annot2.length == 3);	
		
		assertTrue(MyTestClass1.class.getAnnotation(A0.class) != null);
		assertTrue(MyTestClass1.class.getAnnotation(A1.class) != null);
		assertTrue(MyTestClass1.class.getAnnotation(A6.class) != null);
		
		assertTrue(MyTestClass2.class.getAnnotation(A0.class) != null);
		
		assertTrue(MyTestClass3.class.getAnnotation(A0.class) != null);
		assertTrue(MyTestClass3.class.getAnnotation(A6.class) != null);
		
		assertTrue(MyTestClass4.class.getAnnotation(A1.class) != null);		
		
		assertTrue(MyTestClass5.class.getAnnotation(A0.class) != null);
		assertTrue(MyTestClass5.class.getAnnotation(A1.class) != null);
		assertTrue(MyTestClass5.class.getAnnotation(A6.class) != null);
		assertTrue(MyTestClass5.class.getAnnotation(A3.class) != null);
		
		// TestClass1		
		assertTrue(MyTestClass1.class.isAnnotationPresent(A0.class));
		assertTrue(MyTestClass1.class.isAnnotationPresent(A1.class));
		assertTrue(MyTestClass1.class.isAnnotationPresent(A6.class));		
		// TestClass2
		assertTrue(MyTestClass2.class.isAnnotationPresent(A0.class));
		// TestClass3		
		assertTrue(MyTestClass3.class.isAnnotationPresent(A0.class));
		assertTrue(MyTestClass3.class.isAnnotationPresent(A6.class));
		// TestClass4		
		assertTrue(MyTestClass4.class.isAnnotationPresent(A1.class));		
		// TestClass5				
		assertTrue(MyTestClass5.class.isAnnotationPresent(A0.class));
		assertTrue(MyTestClass5.class.isAnnotationPresent(A1.class));
		assertTrue(MyTestClass5.class.isAnnotationPresent(A6.class));
		assertTrue(MyTestClass5.class.isAnnotationPresent(A3.class));			
		// A2 should not exist for TestClass5
		assertTrue(MyTestClass5.class.getAnnotation(A2.class) == null);

		Annotation[] class_annot3 = MyTestClass3.class.getAnnotations();
		assertTrue(class_annot3.length == 2);		
	}	
	
	// This test verifies that we always get back instanceS of @A0, @A1 & @A6
	// for each iteration of a loop
	public void testClass2()
	{
		for (int i=0; i<5; i++)
		{
			A0 prevA0 = (A0) MyTestClass1.class.getAnnotation(A0.class);
			A6 prevA6 = (A6) MyTestClass1.class.getAnnotation(A6.class);		
			A0 annotA0 = (A0) MyTestClass1.class.getAnnotation(A0.class);
			assertTrue (annotA0 != null);
			assertTrue (annotA0.equals(prevA0));
			
			A6 annotA6 = (A6) MyTestClass1.class.getAnnotation(A6.class);
			assertTrue (annotA6 != null);			
			assertTrue (annotA6.equals(prevA6));		
			
			// Make sure all 3 different annotations are returned
			Annotation[] class_annots = MyTestClass1.class.getAnnotations();			
			boolean[] annot_count = new boolean[] {false, false, false};
			for (int j=0; j<3; j++)
			{
				if (class_annots[j] instanceof A0)
				{
					annot_count[0] = true;
				}
				else if (class_annots[j] instanceof A1)
				{
					annot_count[1] = true;
				}
				else if (class_annots[j] instanceof A6)
				{
					annot_count[2] = true;
				}				
			}											
			assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);
			
			// Make sure all 3 different annotations are returned
			// This is the same test as the previous one except getDeclaredAnnotations is called
			// Both getAnnotations and getDeclaredAnnotations should return the same array
			class_annots = MyTestClass1.class.getDeclaredAnnotations();		
			annot_count = new boolean[] {false, false, false};
			for (int j=0; j<3; j++)
			{
				if (class_annots[j] instanceof A0)
				{
					annot_count[0] = true;
				}
				else if (class_annots[j] instanceof A1)
				{
					annot_count[1] = true;
				}
				else if (class_annots[j] instanceof A6)
				{
					annot_count[2] = true;
				}				
			}											
			assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);
						
			assertTrue(MyTestClass1.class.isAnnotationPresent(A0.class));
			assertTrue(MyTestClass1.class.isAnnotationPresent(A6.class));
			assertTrue(MyTestClass1.class.isAnnotationPresent(A1.class));			
			
			prevA0 = annotA0;			
			prevA6 = annotA6;
		}
	}

	
	// Test annotations in a class hierarchy 
	// Note: annotations used in a class hierarchy must be defined with the @Inherited attribute
	public void testClass3()
	{
		// ****************************		
		// Test TestClassSub2 sub class
		
		// Should return entire class hierarchy of annotations: @A0, @A1, @A2, @A3
		Annotation[] class_annots = MyTestClassSub2.class.getAnnotations();
		// Should return just the annotations present in the subclass TestClassSub2: @A3
		Annotation[] class_DecAnnots = MyTestClassSub2.class.getDeclaredAnnotations();
		
		// First, check that all 4 annotations in the hierarchy are present
		assertTrue (class_annots.length == 4);
		boolean[] annot_count = new boolean[] {false, false, false, false};
		
		for (int j=0; j<4; j++)
		{
			if (class_annots[j] instanceof A0)
			{
				annot_count[0] = true;
			}
			else if (class_annots[j] instanceof A1)
			{
				annot_count[1] = true;
			}
			else if (class_annots[j] instanceof A2)
			{
				annot_count[2] = true;
			}
			else if (class_annots[j] instanceof A3)
			{
				annot_count[3] = true;
			}				
			
		}											
		assertTrue(annot_count[0] && annot_count[1] && annot_count[2] && annot_count[3]);
		
		// Next, check that just the single annotation in sub class is present
		assertTrue (class_DecAnnots.length == 1);
		assertTrue(class_DecAnnots[0] instanceof A3);
		
		// ****************************
		// Test TestClassSub1 sub class		
		
		// Should return entire class hierarchy of annotations: @A0, @A1, @A2
		class_annots = MyTestClassSub1.class.getAnnotations();
		// Should return just the annotations present in the subclass TestClassSub1: @A1, @A2
		class_DecAnnots = MyTestClassSub1.class.getDeclaredAnnotations();
		
		// Check that all 3 annotations in the hierarchy are present
		assertTrue (class_annots.length == 3);
		annot_count = new boolean[] {false, false, false};
		
		for (int j=0; j<3; j++)
		{
			if (class_annots[j] instanceof A0)
			{
				annot_count[0] = true;
			}
			else if (class_annots[j] instanceof A1)
			{
				annot_count[1] = true;
			}
			else if (class_annots[j] instanceof A2)
			{
				annot_count[2] = true;
			}			
		}											
		assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);		
		
		// ****************************
		// Test TestClassBase base class		
		
		// Should return annotation: @A0
		class_annots = MyTestClassBase.class.getAnnotations();
		// Should return just the annotations present in this base class: @A0
		class_DecAnnots = MyTestClassBase.class.getDeclaredAnnotations();

		assertTrue (class_annots.length == 1);
		assertTrue (class_DecAnnots.length == 1);	
		assertTrue(class_annots[0] instanceof A0);
		assertTrue(class_DecAnnots[0] instanceof A0);
		assertTrue(MyTestClassBase.class.isAnnotationPresent(A0.class));	
		A0 annotA0 = (A0) MyTestClassBase.class.getAnnotation(A0.class);
		assertTrue (annotA0 != null);
	}
}
