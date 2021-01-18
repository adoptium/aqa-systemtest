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

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/*
 * This class inserts new byte codes into an existing Java class.
 * An ASM ClassReader can take Java byte codes and call the relevant
 * methods in a ClassWriter to build a copy of that class. We can intercept
 * these calls and insert our own code instead (or as well).
 */
public class MyMethodVisitor extends MethodVisitor {
	private String methodNameLocal;
	private int randomNumber;
	private int threadNumber;
	/**
	 * The constructor for this class.
	 * @param mv           The MethodVisitor representing the method we're modifying. Receives all method calls we don't override. 
	 * @param methodName   The name of the method we're modifying
	 * @param randomNumber Used to select which method call we're adding to this method.
	 * @param threadNumber Used to generate thread-specific log messages, as many of these may be running at once.
	 */
	public MyMethodVisitor(MethodVisitor mv, String methodName, int randomNumber, int threadNumber) {
		super(Opcodes.ASM7, mv);
		methodNameLocal = methodName;
		this.randomNumber = randomNumber;
		this.threadNumber = threadNumber;
	}

	/**
	 * This method is called when we're telling the ClassWriter to start a new method.
	 * We pass this call on, and then add our code before the ClassReader can tell the 
	 * MethodVisitor to construct the code present in the old version of this method.
	 */
	@Override
	public void visitCode() {
		mv.visitCode();
		randomMethodCall();
	}

	/**
	 * This method takes the size of the operand stack associated with the method 
	 * represented by "mv"and increments it by 2.
	 * That change ensures we have the necessary space for our new variables.
	 * @param x The size of mv's method's execution frame's operand stack.
	 * @param y The size of mv's method's local variable array.
	 */
	@Override
	public void visitMaxs(int x, int y) {
		mv.visitMaxs(x+2,y);
	}

	/**
	 * This method writes new bytecodes that do setup for, 
	 * and call, a random method in one of Java's core classes.
	 * If you want to add more methods, please remember to:
	 * a) Pick a class that is central to Java, so we know String can access it.
	 * b) Increase the visitMaxs "+" to reflect the number of 
	 * 	operands on the stack at any one time.
	 * and c) Clean up after, by popping all values off of the stack.
	 */
	private void randomMethodCall(){
		randomNumber = randomNumber % 4;
		//0: Calling static method System.currentTimeMillis()J;
		//1: Calling static method Integer.compare(II)I;
		//2: Calling method Object.hashCode()I;
		//3: Calling static method Thread.activeCount()I;
		switch (randomNumber) {
			case 0 : mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
				 mv.visitInsn(Opcodes.POP2);
				 announceChangeMade("System.currentTimeMillis()J");
				 break;
			case 1 : mv.visitInsn(Opcodes.ICONST_0);
				 mv.visitInsn(Opcodes.ICONST_1);
				 mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "compare", "(II)I", false);
				 mv.visitInsn(Opcodes.POP);
				 announceChangeMade("Integer.compare(II)I");
				 break;
			case 2 : mv.visitTypeInsn(Opcodes.NEW, "java/lang/Object");
				 mv.visitInsn(Opcodes.DUP);
				 mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
				 mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "hashCode", "()I", false);
				 mv.visitInsn(Opcodes.POP);
				 announceChangeMade("Object.hashCode()I");
				 break;
			case 3 : mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Thread", "activeCount", "()I", false);
				 mv.visitInsn(Opcodes.POP);
				 announceChangeMade("Thread.activeCount()I");
				 break;
		}
	}

	public void announceChangeMade(String callAdded){
		AgentLogger.printThis("Thread " + threadNumber + "'s MethodVisitor successfully added a " + callAdded + " call to the start of the String." + methodNameLocal + " method.",2);
	}
}

