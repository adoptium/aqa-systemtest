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

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.lang.instrument.IllegalClassFormatException;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.ClassVisitor;

/*
 * This class allows us to take an existing class' byte code and pass it through our modifier code.
 * Said code adds random method calls to random public methods in String, to test the durability of
 * the retransformation mechanism.
 */
public class StringTransformer implements ClassFileTransformer {
	// The seed for MyClassVisitor's random number generator.
	long seed;
	// The percentage of methods (on average) that we want to modify in the String class.
	int percentage;
	// The number of the thread we're in, for more useful log messages.
	int threadNumber;

	/**
	 * Constructor method.
	 * @param seed         The seed for MyClassVisitor's random number generator.
	 * @param percentage   The percentage of methods (on average) that we want to modify in the String class.
	 * @param threadNumber The number of the thread we're in, for more useful log messages.
	 */
	public StringTransformer(long seed, int percentage, int threadNumber) {
		this.seed = seed;
		this.percentage = percentage;
		this.threadNumber = threadNumber;
	}

	/**
	 * This method is called by the JVM when it wants to transform/re-transform a class.
	 * @param loader	          The ClassLoader associated with the class we're transforming.
	 * @param className	          The name of the class we're transforming.
	 * @param classBeingRedefined The class type of the class we're transforming.
	 * @param protectionDomain    The protectionDomain of the class we're transforming.
	 * @param classfileBuffer     The Java bytecodes of the class we're transforming.
	 */
	@Override
	public byte[] transform(ClassLoader loader,
				String className,
				Class<?> classBeingRedefined,
				ProtectionDomain protectionDomain,
				byte[] classfileBuffer) throws IllegalClassFormatException {
		byte[] newClassFileBuffer = classfileBuffer;
		try {
			if ((className != null) && className.equals("java/lang/String")) {
				AgentLogger.printThis("Thread " + threadNumber + "'s transformer is now transforming String.",2);
				//Step 1: Make a Reader.
				ClassReader cr = new ClassReader(newClassFileBuffer);
				//Step 2: Make a ClassWriter.
				ClassWriter cw = new ClassWriter(0);
				//Step 3: Make a MyClassVisitor.
				ClassVisitor mcv = new MyClassVisitor(cw,percentage,seed,threadNumber);
			 	//Step 4: Accept. This causes the Reader to parse the String bytes, pass it through our custom filter, and pass the result to ClassWriter;
				cr.accept(mcv, 0);
				AgentLogger.printThis("Thread " + threadNumber + "'s transformer has finished transforming a copy of the String byte codes, and will now output the new byte codes.",2);
				//Step 5: newClassFileBuffer = ClassWriter.toByteArray.
				newClassFileBuffer = cw.toByteArray();
				AgentLogger.printThis("StringTransformer has returned the modified byte codes, and will now return them to the JVM to replace the existing byte codes for String.",2);
			}
		} catch (Exception e) { 
			AgentLogger.printThis("Exception seen while transforming String.",0);
			AgentLogger.logError(new Error(e));
		}
		return newClassFileBuffer;
	}
}
