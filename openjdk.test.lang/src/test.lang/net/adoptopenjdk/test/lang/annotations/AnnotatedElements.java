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

/*
 * This class defines static fields and methods with various annotations against them.
 * These annotation are used by the various annotation junit test classes 
 */
@A6
public class AnnotatedElements
{
// Fields
	
	@A0
	static int field1 = 1;
	
	@A0 (id = 2, description = "This is field2")
	@A1  (origin = "USA", inStock = true, description = "This is field2")
	static int field2 = 2;
	
	@A0 (id = 3, description = "This is field1")
	@A1 (origin = "USA", inStock = true, description = "This is field3")
	@A2	(contents ={"a0","a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15","a16",
					"a17","a18","a19","a20","a21","a22","a23","a24","a25","a26","a27","a28","a29","a30"} )
	@A3
	@A4
	@A5
	static int field3 = 6;
	
	@A_Meta
	static String field4 = "blank";
	
	
// Methods

	static void method1(){}
	
	@A0
	@A1
	@A2
	@A3
	static void method2(){}
	
	void method3(){}
	
	void method4(@A0 int p1, int p2, @A1 String p3, @A4 boolean p4,
			@A0 float p5, @A3 @A1 AnnotatedElements p6) {}

	@A0 (id = 7, description = "This is method5")
	@A1
	@A2	(contents ={"a0","a1","a2","a3","a4"})
	void method5(@A0 int p1, int p2, String p3, @A4 @A0 (id = 200, description = "This is p4")
			boolean p4) {}
	

}
