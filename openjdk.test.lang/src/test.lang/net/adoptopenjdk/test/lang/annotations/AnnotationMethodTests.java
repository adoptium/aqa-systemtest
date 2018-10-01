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
import java.lang.reflect.Method;
import junit.framework.TestCase;


/*
 * This class tests (stresses) the internal caching of
 * Java method annotations within the JVM.  
 */
public class AnnotationMethodTests extends TestCase
{
	
	public AnnotationMethodTests(String name)
	{
		super(name);		
	}  
	
	public void testMethod1() throws NoSuchFieldException
	{	
		Method[] myMethods = AnnotatedElements.class.getDeclaredMethods();
		for (int i = 0; i < myMethods.length; i++)
		{
			Annotation[] annotationArray = myMethods[i].getDeclaredAnnotations();			
			if (annotationArray.length > 0)
			{
				/* Retrieve another copy of the annotation array and make sure it has the
				 * same number of elements as previously.
				 */
				assertTrue( annotationArray.length == myMethods[i].getDeclaredAnnotations().length );				
			}
			
			/* Get a list of the method parameters and check the annotations associated
			 * with them
			 */
			Annotation[][] params = myMethods[i].getParameterAnnotations();
			if (myMethods[i].getName().equalsIgnoreCase("method4"))
			{
				// There should be 6 parameters (with and without annotations) for
				// method 4
				assertTrue(params.length == 6);
				
				// Make sure each parameter has the correct annotations
				assertTrue(params[0].length  == 1);
				assertTrue(params[0][0] instanceof A0);
				assertTrue(params[2][0] instanceof A1);
				assertTrue(params[3][0] instanceof A4);
				assertTrue(params[4][0] instanceof A0);
				assertTrue(params[5].length  == 2);					
				
				// We cannot assume the order of the returned annotations when 2 or
				// more are returned for a parameter
				boolean[] annot_count = new boolean[] {false, false};
				for (int j=0; j<2; j++)
				{
					if (params[5][j] instanceof A1)
					{
						annot_count[0] = true;
					}
					else if (params[5][j] instanceof A3)
					{
						annot_count[1] = true;
					}
				}											
				assertTrue(annot_count[0] && annot_count[1]);		
			}
			else if (myMethods[i].getName().equalsIgnoreCase("method5"))
			{
				assertTrue(params[0].length  == 1);
				assertTrue(params[0][0] instanceof A0);
				
				assertTrue(params[3].length  == 2);
				boolean[] annot_count = new boolean[] {false, false};
				for (int j=0; j<2; j++)
				{
					if (params[3][j] instanceof A0)
					{
						annot_count[0] = true;
					}
					else if (params[3][j] instanceof A4)
					{
						annot_count[1] = true;
					}
				}											
				assertTrue(annot_count[0] && annot_count[1]);							
			}
			else
			{
				// All other methods should have 0 parameters
				assertTrue(params.length == 0);
			}				
		}
	}
	
	public void testMethod2() throws NoSuchFieldException
	{
		Method[] myMethods = AnnotatedElements.class.getDeclaredMethods();
		for (int i = 0; i < myMethods.length; i++)
		{
			Annotation[] annotationArray = myMethods[i].getAnnotations();
			Annotation[] annotationDecArray = myMethods[i].getDeclaredAnnotations();					
			
			// If the current method has annotations
			if (annotationArray.length > 0)
			{				
				if (myMethods[i].getName().equals("method2"))
				{
					boolean[] annot_count = new boolean[] {false, false, false, false};
					for (int j=0; j<4; j++)
					{
						if (annotationArray[j] instanceof A0)
						{
							assertTrue(annotationDecArray[j] instanceof A0);
							annot_count[0] = true;
						}
						else if (annotationArray[j] instanceof A1)
						{
							assertTrue(annotationDecArray[j] instanceof A1);
							annot_count[1] = true;
						}
						else if (annotationArray[j] instanceof A2)
						{
							assertTrue(annotationDecArray[j] instanceof A2);							
							annot_count[2] = true;
						}
						else if (annotationArray[j] instanceof A3)
						{
							assertTrue(annotationDecArray[j] instanceof A3);							
							annot_count[3] = true;
						}						
					}											
					assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);
					
					assertTrue(myMethods[i].isAnnotationPresent(A0.class));
					assertTrue(myMethods[i].isAnnotationPresent(A1.class));
					assertTrue(myMethods[i].isAnnotationPresent(A2.class));
					assertTrue(myMethods[i].isAnnotationPresent(A3.class));					
					
					
				}
				else if (myMethods[i].getName().equals("method5"))
				{
					boolean[] annot_count = new boolean[] {false, false, false};
					for (int j=0; j<3; j++)
					{
						if (annotationArray[j] instanceof A0)
						{
							assertTrue(annotationDecArray[j] instanceof A0);
							A0 myAnnotation = (A0) annotationArray[j];							
							assertTrue(myAnnotation.id() == 7);
							assertTrue(myAnnotation.description().equals("This is method5"));																					
							annot_count[0] = true;
						}
						else if (annotationArray[j] instanceof A1)
						{
							assertTrue(annotationDecArray[j] instanceof A1);							
							annot_count[1] = true;
						}
						else if (annotationArray[j] instanceof A2)
						{
							assertTrue(annotationDecArray[j] instanceof A2);							
							annot_count[2] = true;
						}				
					}											
					assertTrue(annot_count[0] && annot_count[1] && annot_count[2]);
					
					assertTrue(myMethods[i].isAnnotationPresent(A0.class));
					assertTrue(myMethods[i].isAnnotationPresent(A1.class));
					assertTrue(myMethods[i].isAnnotationPresent(A2.class));
					
				}
			}
		}
	}	
}

