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

package net.adoptopenjdk.test.modularity.junit;

import adoptopenjdk.test.modularity.helper.pkgOne.*;
import adoptopenjdk.test.modularity.hola.*;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

/*
User story: An automatic module grants implied readability to all automatic modules

Use case 1:
myApp is an explicit module which requires module m1.
Module m1 is an automatic module and contains a public type whose signature is 
of a type from another automatic module m2. m1 should be able to read m2. 
myApp should be able to read m2 as well as an automatic module grants implied readaibilty.

Use case 2:
myApp is an explicit module which requires module m1. 
Module m1 is an automatic module and contains a public type whose 
signature is of a type from Unnamed module m2. 
m1 should be able to read the unnamed module m2.  
However, myApp shouldn't be able to read m2 as there won't be implied-readability. 
In order for myApp to read m2, it can be added via --add-reads option.

Use case 3:
myApp is an automatic module which requires module m1. 
Module m1 is an automatic module and contains a public type whose signature 
is of a type from another automatic module m2. myApp and m1 should be able to read m2.
*/

public class TestImpliedReadability {

	@Test
	public void test1() {
					
		HelperClass hc = new HelperClass();
		Hi h = hc.getHiInstance();
		h.setName("Java");
		assertEquals("Java", h.getName());

	}
	
	@Test
	public void test2() {
		// hamcrest framework offers some more assert api's. 
		// junit jar when converted to explicit module provides 
		// implicit readability to hamcrest jar. Adding this to test it out.
		String text = "Testing Implied Readability";
		assertThat(text, containsString("Read"));
	}
}