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

package net.adoptopenjdk.test.lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/*
 * A basic test of some of the java.lang.invoke api
 */
public class BasicTest {
	
	static class TestFailedException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		TestFailedException(Throwable cause) {
			super(cause);
		}
		
	}

	// Set up some method handles to be re-used across test instances.
	static MethodHandle mh1;
	static MethodHandle mh2;
	
	static {
		try {
			mh1 = MethodHandles.lookup().findVirtual(Superclass.class, "voidMethod", MethodType.fromMethodDescriptorString("(I)V", null));
			mh2 = MethodHandles.lookup().findVirtual(Superclass.class, "longMethod", MethodType.fromMethodDescriptorString("(JLnet/adoptopenjdk/test/lang/invoke/Superclass;)J", null));
		} catch (IllegalAccessException e) {
			// This is pretty fatal to the test, so throw an unchecked exception and ditch out.
			throw new TestFailedException(e);
		} catch (NoSuchMethodException e) {
			// This is pretty fatal to the test, so throw an unchecked exception and ditch out.
			throw new TestFailedException(e);
		}	
	}

	int intProp = 0;

	int stepSequence = 0;

	public void step() {
		stepSequence++;
		System.out.print("\nStep " + stepSequence);
	}

	public static void check(int ideal, int actual) {
		if (ideal == actual)
			System.out.print(".");
		else
			throw new Error("ERROR: Expected " + ideal + "; found " + actual);
	}

	public static void check(long ideal, long actual) {
		if (ideal == actual)
			System.out.print(".");
		else
			throw new Error("ERROR: Expected " + ideal + "; found " + actual);
	}

	public static void check(String ideal, String actual) {
		// We check for nulls, then we check for equality.
		// We println "." if the two are both null, or if they are both non-null and equal.
		if((ideal == null) || (actual == null)) {
			if(ideal != actual){
				throw new Error("ERROR: Expected " + ideal + " but found " + actual);
			}
		} else if (!ideal.equals(actual)) {
			throw new Error("ERROR: Expected " + ideal + " but found " + actual);
		}
		System.out.print(".");
	}

	public void doTest() throws Throwable {
		System.out.println("Starting doTest");

		MethodHandle mh;
		Implementation1 i1 = new Implementation1(this);
		Implementation2 i2 = new Implementation2(this);
		Implementation3 i3 = new Implementation3(this);

		intProp = 0;
		mh1.invokeExact((Superclass)i1, 123);
		check(10123, intProp);

		step();
		intProp = 0;
		mh1.invokeExact((Superclass)i2, 456); // Optimizer should be able to eliminate checks on this one
		check(20456, intProp);


		step();
		check(456, (long)mh2.invokeExact((Superclass)i1, (long)456, (Superclass)i1));
		step();
		check( -1, (long)mh2.invokeExact((Superclass)i1, (long)456, (Superclass)i2));
		step();
		check(456, (long)mh2.invokeExact((Superclass)i2, (long)456, (Superclass)i1));
		step();
		check( -2, (long)mh2.invokeExact((Superclass)i2, (long)456, (Superclass)i2));

		step();

		mh = MethodHandles.lookup().findVirtual(Interface.class, "interfaceMethod", MethodType.fromMethodDescriptorString("()V", null));
		mh.invokeExact((Interface)i1);
		check(1001, intProp);
		mh.invokeExact((Interface)i3);
		check(1003, intProp);

		step();

		
		mh = MethodHandles.lookup().findSetter(BasicTest.class, "intProp", int.class);
		mh.invokeExact(this, 1);
		check(1, intProp);
		mh.invokeExact(this, 2);
		check(2, intProp);
		
		step();

		mh = MethodHandles.lookup().findGetter(BasicTest.class, "intProp", int.class);
		intProp = 1;
		check(1, (int)mh.invokeExact(this));
		intProp = 2;
		check(2, (int)mh.invokeExact(this));

		step();

		mh = MethodHandles.lookup().findSetter(Implementation1.class, "instanceInt", int.class);
		mh.invokeExact(i1, 1);
		i1.checkInstanceInt(1);
		mh.invokeExact(i1, 2);
		i1.checkInstanceInt(2);

		step();

		mh = MethodHandles.lookup().findGetter(Implementation1.class, "instanceInt", int.class);
		i1.instanceInt = 1;
		check(1, (int)mh.invokeExact(i1));
		i1.instanceInt = 2;
		check(2, (int)mh.invokeExact(i1));

		step();


		// This doesn't currently work with the sun jvm as of b135
		mh = MethodHandles.lookup().findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null));
		mh = mh.asCollector(long[].class, 2);																						   
		check(8, (int)mh.invokeExact(new ArrayTaker(), 2.0f, 4.0d, 123l, 345l));													  


		step();

		// This doesn't currently work with the sun jvm as of b135
		mh = MethodHandles.lookup().findVirtual(ArrayTaker.class, "objects", MethodType.fromMethodDescriptorString("(Ljava/lang/Float;Ljava/lang/Double;[Ljava/lang/Long;)Ljava/lang/Integer;", null));
		mh = mh.asCollector(Long[].class, 2);																																						  
		check(8, (Integer)mh.invokeExact(new ArrayTaker(), Float.valueOf(2.0f), Double.valueOf(4.0d), Long.valueOf(123L), Long.valueOf(345L)));														


		step();


		mh = MethodHandles.lookup().findStatic(ArrayTaker.class, "staticPrimitives", MethodType.fromMethodDescriptorString("(FD[J)Ljava/lang/String;", null));
		mh = mh.asCollector(long[].class, 2);																												 
		check("staticPrimitives(1.0, 4.0, [123, 345])", (String)mh.invokeExact(1.0f, 4.0d, 123L, 345L));													  

		step();


		mh = MethodHandles.lookup().findStatic(ArrayTaker.class, "staticObjects", MethodType.fromMethodDescriptorString("(Ljava/lang/Float;Ljava/lang/Double;[Ljava/lang/Long;)Ljava/lang/Integer;", null));
		mh = mh.asCollector(Long[].class, 2);																																							   
		check(8, (Integer)mh.invokeExact(Float.valueOf(2.0f), Double.valueOf(4.0d), Long.valueOf(123L), Long.valueOf(345L)));																			   

		step();

		mh = MethodHandles.lookup().findConstructor(Constructible.class, MethodType.fromMethodDescriptorString("(I)V", null));
		Constructible c = (Constructible)mh.invokeExact(1234);
		check(1234, c.field);

		step();

		mh = MethodHandles.lookup().bind(i1, "longMethod", MethodType.fromMethodDescriptorString("(JLnet/adoptopenjdk/test/lang/invoke/Superclass;)J", null));
		check(456, (long)mh.invokeExact((long)456, (Superclass)i1));
		check( -1, (long)mh.invokeExact((long)456, (Superclass)i2));

		System.out.println("\nDone goForIt\n");
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("Starting first run");
		BasicTest test = new BasicTest();
		test.doTest();
		System.out.println("Starting second run");
		test.doTest();
		System.out.println("Done main");
	}
	

}

abstract class Superclass {
	public abstract void voidMethod(int argument);
	public abstract long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.Superclass arg2);
}

interface Interface {
	public void interfaceMethod();
}

class Implementation1 extends Superclass implements Interface {

	public int instanceInt;
	BasicTest parent;

	Implementation1(BasicTest parent) {
		this.parent = parent;
	}

	public void voidMethod(int argument) {
		parent.intProp = 10000 + argument;
	}

	public long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.Superclass arg2) {
		if (this == arg2)
			return arg1;
		else
			return -1;
	}

	public void interfaceMethod() {
		parent.intProp = 1001;
	}

	public void checkInstanceInt(int desiredValue) {
		BasicTest.check(desiredValue, instanceInt);
	}
}

class Implementation2 extends Superclass {

	BasicTest parent;

	Implementation2(BasicTest parent) {
		this.parent = parent;
	}

	public void voidMethod(int argument) {
		parent.intProp = 20000 + argument;
	}

	public long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.Superclass arg2) {
		if (this == arg2)
			return -2;
		else
			return arg1;
	}
}

class Implementation3 implements Interface {

	BasicTest parent;

	Implementation3(BasicTest parent) {
		this.parent = parent;
	}

	public void interfaceMethod() {
		parent.intProp = 1003;
	}
}

/**
 * An object with a collection of methods that take an array 
 * as the last parameter 
 */
class ArrayTaker {

	public int primitives(float f, double d, long[] longs) {
		return(int)f + (int)d + longs.length;
	}

	public Integer objects(Float f, Double d, Long[] longs) {
		return(int)f.floatValue() + (int)d.doubleValue() + longs.length;
	}

	public static String staticPrimitives(float f, double d, long[] longs) {
		return "staticPrimitives(" + f + ", " + d + ", " + Arrays.toString(longs) + ")";
	}
	public static Integer staticObjects(Float f, Double d, Long[] longs) {
		return(int)f.floatValue() + (int)d.doubleValue() + longs.length;
	}
}

class Constructible {

	public int field;

	public Constructible(int arg){
		field = arg;
	}

}

