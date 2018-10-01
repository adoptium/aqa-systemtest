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
import junit.framework.*;

/*
 * This class tests (stresses) the internal caching of
 * Java enum annotations within the JVM.  
 */
public class AnnotationEnumTests extends TestCase
{
	@A7
	enum Malts {PALE, PILSNER, CHOCOLATE, WHEAT, MUNICH, CRYSTAL, BROWN, CARAMALT};
	
	@A0 @A7
	enum Hops {CASCADE, GOLDINGS, NORTHDOWN, FUGGLES, FIRST_GOLD, CHALLENGER, TARGET }
	
	public AnnotationEnumTests(String name)
	{
		super(name);		
	}
	
	public void testEnum1()
	{
		A7 a7 = (A7) Malts.class.getAnnotation(A7.class);
		assertTrue(a7 != null);
		assertTrue(a7.id() == 99);
		assertTrue (Malts.class.getAnnotation(A7.class).equals(a7));		
		Annotation[] malt_array = Malts.class.getAnnotations();
		assertTrue (malt_array[0].equals(a7));
		assertTrue(Malts.class.isAnnotationPresent(A7.class));	
		Annotation[] malt_array2 = Malts.class.getDeclaredAnnotations();
		assertTrue(malt_array2[0].equals(malt_array[0]));
		
		assertTrue(Hops.class.isAnnotationPresent(A7.class));
		assertTrue(Hops.class.isAnnotationPresent(A0.class));
		assertFalse(Hops.class.isAnnotationPresent(A1.class));
		Annotation[] hops_array = Hops.class.getAnnotations();
		assertTrue (hops_array.length == 2);
		
		boolean[] annot_count = new boolean[] {false, false};
		for (int j=0; j<2; j++)
		{
			if (hops_array[j] instanceof A0)
			{
				annot_count[0] = true;
			}
			else if (hops_array[j] instanceof A7)
			{
				annot_count[1] = true;
			}
		}											
		assertTrue(annot_count[0] && annot_count[1]);
		
		hops_array = Hops.class.getDeclaredAnnotations();
		assertTrue (hops_array.length == 2);
		annot_count = new boolean[] {false, false};
		for (int j=0; j<2; j++)
		{
			if (hops_array[j] instanceof A0)
			{
				assertTrue (hops_array[j].equals(Hops.class.getAnnotation(A0.class)));					
				annot_count[0] = true;
			}
			else if (hops_array[j] instanceof A7)
			{
				assertTrue (hops_array[j].equals(Hops.class.getAnnotation(A7.class)));					
				annot_count[1] = true;
			}
		}											
		assertTrue(annot_count[0] && annot_count[1]);
	}

}

