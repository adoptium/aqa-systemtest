/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.hcrAgent.agent;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import java.util.Random;

/*
 * This class sits between a ClassReader and a ClassWriter. The former can read the 
 * bytecodes of an existing class, and the latter can form new bytecodes. The Reader 
 * can tell the Writer how to reproduce the class it is "reading". Our layer in the 
 * middle allows us to change those instructions to the Writer, which (in this case)
 * results in the creation of new method calls at the start of some methods.
 */

public class MyClassVisitor extends ClassVisitor {
	
	// Percentage of methods we want to modify.
	int percentage;
	int threadNumber;
	// Number generator to decide if we want to visit a specific method.
	Random randomNumberGenerator;	

	/**
	 * Constructor.
	 * @param  cv         The ClassVisitor we forward method calls to, 
	 * @param  percentage The average percentage of public methods we want to transform.
	 */
	public MyClassVisitor(ClassVisitor cv, int percentage, long seed, int threadNumber) {
		super(Opcodes.ASM7, cv);
		this.percentage = percentage;
		randomNumberGenerator = new Random(seed);
		this.threadNumber = threadNumber;
	}

	/**
	 * This method is called when the ClassReader tells the ClassWriter that,
	 * in the class it is reading, there is a method here. The returned MethodVisitor
	 * allows the ClassReader to tell the ClassWriter what code should be in there.
	 * We intercept this call to allow us to add some new method calls to this method,
	 * before the ClassReader gets a change to populate it.
	 * @param  access     The accesses (e.g. public, private) of the method we're making. 
	 * @param  name       The name of the method we're making.
	 * @param  desc       The descriptor of the method we're making.
	 * @param  signature  The signature of the method we're making.
	 * @param  exceptions The exceptions thrown by the method we're making.
	 * @return     The MethodVisitor representing the method we're telling the ClassWriter to create.
	 */
	@Override
	public MethodVisitor visitMethod(int access, String name,
		String desc, String signature, String[] exceptions) {
		MethodVisitor mv;
		mv = cv.visitMethod(access, name, desc, signature, exceptions);
		int randomNumber = randomNumberGenerator.nextInt(100) + 1;
		// MyMethodVisitor will add a random method call to the method we're working on if:
		// 1) The MethodVisitor isn't null (null = the ClassVisitor "cv" does not want to visit the method).
		// 2) The method isn't the method "toString", to avoid infinite loops.
		// 3) The method is public. Note: If "access" is odd, the method is public.
		// 4) The odds of us visiting this method is greater than (or equal to) a random number we picked.
		if ( ((mv != null) && !name.equals("toString")) && ((access % 2 == 1) && (randomNumber <= percentage)) ) {
			mv = new MyMethodVisitor(mv, name, randomNumberGenerator.nextInt(), threadNumber);
		}
		return mv;
	}
}
