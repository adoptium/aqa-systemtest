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
import java.lang.invoke.WrongMethodTypeException;
import java.io.Serializable;

/*
 * Testing of the various aspects of the the MethodHandle.asType() method,
 * both explicitly and as exposed by various APIs.
 */
public class AsTypeTest {
	
	static boolean print = false; // Turns the printLn method into a no-op
	
	boolean explicit = false;	
	boolean passed = true;
	
	public AsTypeTest(int explicit) {
		if (explicit == 1) {
			this.explicit = true;
		} else {
			this.explicit = false;
		}
	}

	public AsTypeTest(String explicit) {
		if (explicit.equals("1")) {
			this.explicit = true;
		} else {
			this.explicit = false;
		}
	}


	public static void main(String args[]) throws Throwable {
		System.out.println("testing asType");
		
		testAll();

	}

	public static void testAll() throws Throwable {
		
		boolean passed = true;
		System.out.println("Testing implicit casting");
		AsTypeTest testObject = new AsTypeTest(0);
		testObject.testVoid();
		testObject.testReference();
		testObject.testByte();
		testObject.testBoolean();
		testObject.testShort();
		testObject.testChar();
		testObject.testInt();
		testObject.testLong();
		testObject.testFloat();
		testObject.testDouble();
		if (!testObject.passed) {
			passed = false;
		}
		
		System.out.println("Testing explicit casting");
		
		AsTypeTest testObject2 = new AsTypeTest(1);
		testObject2.testVoid();
		testObject2.testReference();
		testObject2.testByte();
		testObject2.testBoolean();
		testObject2.testShort();
		testObject2.testChar();
		testObject2.testInt();
		testObject2.testLong();
		testObject2.testFloat();
		testObject2.testDouble();

		if (!testObject.passed) {
			passed = false;
		}

				
		if(passed) {
			System.out.println("ALL TESTS PASSED");		
		} else {
			System.out.println("THERE WERE TEST FAILURES");
			System.exit(1);
		}
		 
	}

	

	static boolean floatsEqual(float a, float b) {
		Float f1 = new Float(a);
		Float f2 = new Float(b);
	
		if (f1.isNaN()) {
			return f2.isNaN();
		}
		if (f2.isNaN()) {
			return false;
		}
		return a == b;
	}
	
	static boolean floatsEqual(double a, double b) {
		Double d1 = new Double(a);
		Double d2 = new Double(b);
	
		if (d1.isNaN()) {
			return d2.isNaN();
		}
		if (d2.isNaN()) {
			return false;
		}
		return a == b;
	}
	
	static void println(String s) {
		if (print) {
			System.out.println(s);
		}
	}
	
	static boolean castToBoolean(boolean v) {
		return v;
	}
	
	static boolean castToBoolean(byte v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(short v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(char v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(int v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(long v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(float v) {
		return (((byte)v) & 1) != 0;
	}
	
	static boolean castToBoolean(double v) {
		return (((byte)v) & 1) != 0;
	}

	static int intFromBoolean(boolean v) {
		return (int)(v ? 1 : 0);
	}
	
	static long longFromBoolean(boolean v) {
		return (long)(v ? 1 : 0);
	}
	
	static float floatFromBoolean(boolean v) {
		return (float)(v ? 1 : 0);
	}
	
	static double doubleFromBoolean(boolean v) {
		return (double)(v ? 1 : 0);
	}
	
	static byte byteFromBoolean(boolean v) {
		return (byte)(v ? 1 : 0);
	}
	
	static short shortFromBoolean(boolean v) {
		return (short)(v ? 1 : 0);
	}
	
	static char charFromBoolean(boolean v) {
		return (char)(v ? 1 : 0);
	}
	
	public MethodHandle cast(MethodHandle mh, MethodType mt) throws Throwable {
		println("calling " + mh.type() + " as " + mt);
		if (explicit) {
			return MethodHandles.explicitCastArguments(mh, mt);
		} else {
			return mh.asType(mt);
		}
	}
	
	public void test() {
	}
	
	public byte test(byte v) {
		println("byte = " + v);
		return v;
	}
	
	public boolean test(boolean v) {
		println("boolean = " + v);
		return v;
	}
	
	public short test(short v) {
		println("short = " + v);
		return v;
	}
	
	public char test(char v) {
		println("char = " + (int)v);
		return v;
	}
	
	public int test(int v) {
		println("int = " + v);
		return v;
	}
	
	public float test(float v) {
		println("float = " + v);
		return v;
	}
	
	public double test(double v) {
		println("double = " + v);
		return v;
	}
	
	public long test(long v) {
		println("long = " + v);
		return v;
	}
	
	public Object test(Object v) {
		println("Object = " + v);
		return v;
	}
	
	public Object test(Number v) {
		println("Number = " + v);
		return v;
	}
	
	public Object test(String v) {
		println("String = " + v);
		return v;
	}
	
	public Object test(Serializable v) {
		println("Serializable = " + v);
		return v;
	}
	
	public String testString(String v) {
		println("String = " + v);
		return v;
	}
	
	
	public void exceptionDuringCast(MethodHandle mh, MethodType mt, Throwable t) {
		System.out.println("Casting " + mh.type() + " to " + mt + " -> " + t);
		passed = false;
		t.printStackTrace();
	}
	
	public void exceptionDuringInvoke(MethodHandle mh, MethodType mt, Throwable t) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> " + t);
		passed = false;
		t.printStackTrace();
	}
	
	public void expectedExceptionDuringCast(MethodHandle mh, MethodType mt, Throwable t) {
		println("Casting " + mh.type() + " to " + mt + " -> got expected exception " + t);
	}
	
	public void expectedExceptionDuringInvoke(MethodHandle mh, MethodType mt, Throwable t) {
		println("Invoking " + mh.type() + " as " + mt + " -> got expected exception " + t);
	}
	
	public void noNPEDuringInvoke(MethodHandle mh, MethodType mt) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> did not throw NPE");
		passed = false;
	}
	
	public void noClassCastDuringInvoke(MethodHandle mh, MethodType mt) {
		noClassCastDuringInvoke(mh, mt, "");
	}
	
	private void noClassCastDuringInvoke(MethodHandle mh, MethodType mt, String messageSuffix) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> did not throw ClassCastException" + messageSuffix);
		passed = false;
	}
	
	public void noExceptionDuringCast(MethodHandle mh, MethodType mt) {
		System.out.println("Casting " + mh.type() + " to " + mt + " -> did not throw WrongMethodypeException");
		passed = false;
	}
	
	public void compare(MethodHandle mh, MethodType mt, boolean expected, boolean result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, byte expected, byte result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, char expected, char result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + (int)expected + " got " + (int)result);
			passed = false;
		}
	}

	public void compare(MethodHandle mh, MethodType mt, short expected, short result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, int expected, int result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, long expected, long result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, float expected, float result) {
		if (!floatsEqual(expected, result)) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, double expected, double result) {
		if (!floatsEqual(expected, result)) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}
	
	public void compare(MethodHandle mh, MethodType mt, Object expected, Object result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			passed = false;
		}
	}

	public void testVoid() throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
	
		System.out.println("\ttesting void");
	
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (int)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)0, (int)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (long)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)0, (long)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (float)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)0, (float)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (double)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)0, (double)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (byte)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)0, (byte)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (boolean)false);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, false, (boolean)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (char)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)0, (char)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (short)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)0, (short)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact(this, (Object)null);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)c.invokeExact(this));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public void testReference() throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
	
		System.out.println("\ttesting reference");
	
		// Unboxing NULL should give 0 for explicit casting, otherwise it throws an NPE 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				int result = (int)c.invokeExact(this, (Object) null);
				if (explicit) {					
					compare(s, mt, 0, result);
				} else {
					noNPEDuringInvoke(s, mt);
				}
			} catch (NullPointerException t) {
				if (explicit) {
					// This should return zero, not throw a NPE
					throw t;
				}
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// Widening a reference cast 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object expected = "argle";
				Object result = (Object)c.invokeExact(this, (String) expected);
				compare(s, mt, expected, result);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// Narrowing a reference cast 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object result = (Object)c.invokeExact(this, (Object) new Object());
				noClassCastDuringInvoke(s, mt, " The result was an Object with the toString value: " + result.toString());
			} catch (ClassCastException t) {
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// Narrowing a reference cast of null 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)c.invokeExact(this, (Object) null));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// Casting to an implemented interface 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/io/Serializable;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, "argle", (Object)c.invokeExact(this, (String) "argle"));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// Casting to an unimplemented interface 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/io/Serializable;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object o = new Object();
				compare(s, mt, o, (Object)c.invokeExact(this, (Object) o));
				if (!explicit) {
					noClassCastDuringInvoke(s, mt);
				}
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Unboxing NULL should give 0 for explicit casting, it should throw an NPE otherwise
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				int result = (int)c.invokeExact(this, (Object) null);
				if (explicit) {
					compare(s, mt, 0, result);
				} else {
					noNPEDuringInvoke(s, mt);
				}
			} catch (NullPointerException t) {
				if (explicit) {
					// Explicit casting should give a 0 argument, not an NPE
					throw t;
				}
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Widening a reference cast 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "testString", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/String;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object expected = "argle";
				Object result = (Object)c.invokeExact(this, (String) expected);
				compare(s, mt, expected, result);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Narrowing a reference cast 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/lang/String;", null);
		try {
			c = cast(s, mt);
			try {
				String result = (String)c.invokeExact(this, new Object());
				noClassCastDuringInvoke(s, mt, " The result was a String with the value: " + result);
			} catch (ClassCastException t) {
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Narrowing a reference cast of null 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/lang/String;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)(String)c.invokeExact(this, (Object) null));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Casting to an implemented interface 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/String;)Ljava/io/Serializable;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, "argle", (String)(Serializable)c.invokeExact(this, (String) "argle"));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	
		// return - Casting to an unimplemented interface 
	
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Ljava/io/Serializable;", null);
		try {
			c = cast(s, mt);
			try {
				Object o = new Object();
				compare(s, mt, o, (Object)(Serializable)c.invokeExact(this, (Object) o));
				if (!explicit) {
					noClassCastDuringInvoke(s, mt);
				}
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}
	
	public void testBoolean() throws Throwable {
		System.out.println("\ttesting boolean");
		testConvertBoolean(false);
		testConvertBoolean(true);
	}
	
	public void testByte() throws Throwable {
		System.out.println("\ttesting byte");
		testConvertByte((byte)0);
		testConvertByte((byte)1);
		testConvertByte((byte)-1);
		testConvertByte(Byte.MIN_VALUE);
		testConvertByte(Byte.MAX_VALUE);
	}
	
	public void testShort() throws Throwable {
		System.out.println("\ttesting short");
		testConvertShort((short)0);
		testConvertShort((short)1);
		testConvertShort((short)-1);
		testConvertShort(Byte.MIN_VALUE);
		testConvertShort(Byte.MAX_VALUE);
		testConvertShort(Short.MIN_VALUE);
		testConvertShort(Short.MAX_VALUE);
	}
	
	public void testChar() throws Throwable {
		System.out.println("\ttesting char");
		testConvertChar((char)0);
		testConvertChar((char)1);
		testConvertChar((char)Byte.MAX_VALUE);
		testConvertChar((char)Short.MAX_VALUE);
		testConvertChar(Character.MAX_VALUE);
	}

	public void testInt() throws Throwable {
		System.out.println("\ttesting int");
		testConvertInt(0);
		testConvertInt(1);
		testConvertInt(-1);
		testConvertInt(Byte.MIN_VALUE);
		testConvertInt(Byte.MAX_VALUE);
		testConvertInt(Short.MIN_VALUE);
		testConvertInt(Short.MAX_VALUE);
		testConvertInt(Character.MAX_VALUE);
		testConvertInt(Integer.MIN_VALUE);
		testConvertInt(Integer.MAX_VALUE);
	}

	public void testLong() throws Throwable {
		System.out.println("\ttesting long");
		testConvertLong(0);
		testConvertLong(1);
		testConvertLong(-1);
		testConvertLong(Byte.MIN_VALUE);
		testConvertLong(Byte.MAX_VALUE);
		testConvertLong(Short.MIN_VALUE);
		testConvertLong(Short.MAX_VALUE);
		testConvertLong(Character.MAX_VALUE);
		testConvertLong(Integer.MIN_VALUE);
		testConvertLong(Integer.MAX_VALUE);
		testConvertLong(Long.MIN_VALUE);
		testConvertLong(Long.MAX_VALUE);
	}

	public void testFloat() throws Throwable {
		System.out.println("\ttesting float");
		testConvertFloat((float)0);
		testConvertFloat((float)1);
		testConvertFloat((float)-1);
		testConvertFloat((float)Byte.MIN_VALUE);
		testConvertFloat((float)Byte.MAX_VALUE);
		testConvertFloat((float)Short.MIN_VALUE);
		testConvertFloat((float)Short.MAX_VALUE);
		testConvertFloat((float)Character.MAX_VALUE);
		testConvertFloat((float)Integer.MIN_VALUE);
		testConvertFloat((float)Integer.MAX_VALUE);
		testConvertFloat((float)Long.MIN_VALUE);
		testConvertFloat((float)Long.MAX_VALUE);
		testConvertFloat(Float.MIN_VALUE);
		testConvertFloat(Float.MAX_VALUE);
		testConvertFloat(Float.NaN);
		testConvertFloat(Float.NEGATIVE_INFINITY);
		testConvertFloat(Float.POSITIVE_INFINITY);
	}

	public void testDouble() throws Throwable {
		System.out.println("\ttesting double");
		testConvertDouble((double)0);
		testConvertDouble((double)1);
		testConvertDouble((double)-1);
		testConvertDouble((double)Byte.MIN_VALUE);
		testConvertDouble((double)Byte.MAX_VALUE);
		testConvertDouble((double)Short.MIN_VALUE);
		testConvertDouble((double)Short.MAX_VALUE);
		testConvertDouble((double)Character.MAX_VALUE);
		testConvertDouble((double)Integer.MIN_VALUE);
		testConvertDouble((double)Integer.MAX_VALUE);
		testConvertDouble((double)Long.MIN_VALUE);
		testConvertDouble((double)Long.MAX_VALUE);
		testConvertDouble(Double.MIN_VALUE);
		testConvertDouble(Double.MAX_VALUE);
		testConvertDouble(Double.NaN);
		testConvertDouble(Double.NEGATIVE_INFINITY);
		testConvertDouble(Double.POSITIVE_INFINITY);
	}

	
	
	public void testConvertBoolean(boolean v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Boolean(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, intFromBoolean(v), (int)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, intFromBoolean(v), (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, intFromBoolean(v), (int)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, intFromBoolean(v), (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, longFromBoolean(v), (long)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, longFromBoolean(v), (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, longFromBoolean(v), (long)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, longFromBoolean(v), (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, floatFromBoolean(v), (float)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, floatFromBoolean(v), (float)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, floatFromBoolean(v), (float)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, floatFromBoolean(v), (float)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)D", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)D", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact(this, (boolean)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, charFromBoolean(v), (char)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, charFromBoolean(v), (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, charFromBoolean(v), (char)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, charFromBoolean(v), (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, shortFromBoolean(v), (short)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, shortFromBoolean(v), (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, shortFromBoolean(v), (short)c.invokeExact(this, (boolean)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, shortFromBoolean(v), (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Z)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (boolean)v, ((Boolean) (Object)c.invokeExact(this, (boolean)v)).booleanValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	
	public void testConvertByte(byte v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Byte(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (byte)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (byte)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (byte)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (byte)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;B)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, ((Byte) (Object)c.invokeExact(this, (byte)v)).byteValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, ((Byte) (Object)c.invokeExact(this, (byte)v)).byteValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public void testConvertShort(short v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Short(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (short)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;S)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, ((Short) (Object)c.invokeExact(this, (short)v)).shortValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, ((Short) (Object)c.invokeExact(this, (short)v)).shortValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}


	public void testConvertChar(char v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Character(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (char)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;C)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Character) (Object)c.invokeExact(this, (char)v)).charValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public void testConvertFloat(float v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Float(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			if (explicit) {
				exceptionDuringInvoke(s, mt, t);
			} else {
				expectedExceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (float)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;F)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, ((Float) (Object)c.invokeExact(this, (float)v)).floatValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, ((Float) (Object)c.invokeExact(this, (float)v)).floatValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public void testConvertDouble(double v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Double(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (float)v, (float)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (float)v, (float)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (double)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			if (explicit) {
				exceptionDuringInvoke(s, mt, t);
			} else {
				expectedExceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (double)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;D)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, ((Double) (Object)c.invokeExact(this, (double)v)).doubleValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, ((Double) (Object)c.invokeExact(this, (double)v)).doubleValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public void testConvertInt(int v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Integer(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			if (explicit) {
				exceptionDuringInvoke(s, mt, t);
			} else {
				expectedExceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (int)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;I)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Integer) (Object)c.invokeExact(this, (int)v)).intValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Integer) (Object)c.invokeExact(this, (int)v)).intValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}
	
	public void testConvertLong(long v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Long(v);

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact(this, (Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			if (explicit) {
				exceptionDuringInvoke(s, mt, t);
			} else {
				expectedExceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}				
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact(this, (long)v));
				} catch (Throwable t) {
					exceptionDuringInvoke(s, mt, t);
				}
			} else {
				noExceptionDuringCast(s, mt);
			}
		} catch (WrongMethodTypeException t) {
			wrongMethodType(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact(this, (Object)o));
			} catch (ClassCastException t) {
				if (explicit) {
					exceptionDuringInvoke(s, mt, t);
				} else {
					expectedExceptionDuringInvoke(s, mt, t);
				}
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing 

		mt = MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/AsTypeTest;J)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, ((Long) (Object)c.invokeExact(this, (long)v)).longValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, ((Long) (Object)c.invokeExact(this, (long)v)).longValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findVirtual(AsTypeTest.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	
	
	public void wrongMethodType(MethodHandle mh, MethodType mt, Throwable t) {
		if (explicit) {
			exceptionDuringCast(mh, mt, t);
		} else {
			expectedExceptionDuringCast(mh, mt, t);
		}
	}


}