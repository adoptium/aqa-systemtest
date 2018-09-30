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

package net.adoptopenjdk.test.lang.invoke;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.WrongMethodTypeException;

/*
 * Tests the ability to transform argument types for a method handle
 * using MethodHandles.explicitCastArguments. All methods are static.
 *
 */
public class StaticAsTypeTestExplicit {
	

	static boolean explicit = true;
	static boolean print = false;

	public static void main(String args[]) throws Throwable {
		
		System.out.println("testing asType");
		
		boolean passed = testAll();

		if (passed) {
			System.out.println("ALL TESTS PASSED");
			System.exit(0);
		}
		System.out.println("THERE WERE TEST FAILURES");
		System.exit(1);
	}

	public static boolean testAll() throws Throwable {
		
		boolean passed = true;
		try {
			testVoid();
			testBoolean();
			testByte();
			testShort();
			testChar();
			testInt();
			testLong();
			testFloat();
			testDouble();
			testReference();
		} catch (TestFailedException e) {
			passed = false;
		}
		
		return passed;
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
		if (print) System.out.println(s);
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

	public static MethodHandle cast(MethodHandle mh, MethodType mt) throws Throwable {
		println("calling " + mh.type() + " as " + mt);
		if (explicit) {
			return MethodHandles.explicitCastArguments(mh, mt);
		} else {
			return mh.asType(mt);
		}
	}

	public static void test() {
	}

	public static byte test(byte v) {
		println("byte = " + v);
		return v;
	}

	public static boolean test(boolean v) {
		println("boolean = " + v);
		return v;
	}

	public static short test(short v) {
		println("short = " + v);
		return v;
	}

	public static char test(char v) {
		println("char = " + (int)v);
		return v;
	}

	public static int test(int v) {
		println("int = " + v);
		return v;
	}

	public static float test(float v) {
		println("float = " + v);
		return v;
	}

	public static double test(double v) {
		println("double = " + v);
		return v;
	}

	public static long test(long v) {
		println("long = " + v);
		return v;
	}

	public static Object test(Object v) {
		println("Object = " + v);
		return v;
	}

	public static Object test(Number v) {
		println("Number = " + v);
		return v;
	}

	public static Object test(String v) {
		println("String = " + v);
		return v;
	}

	public static Object test(Serializable v) {
		println("Serializable = " + v);
		return v;
	}

	public static String testString(String v) {
		println("String = " + v);
		return v;
	}

	public static void wrongMethodType(MethodHandle mh, MethodType mt, Throwable t) {
		if (explicit) {
			exceptionDuringCast(mh, mt, t);
		} else {
			expectedExceptionDuringCast(mh, mt, t);
		}
	}

	public static void exceptionDuringCast(MethodHandle mh, MethodType mt, Throwable t) {
		System.out.println("Casting " + mh.type() + " to " + mt + " -> " + t);
		t.printStackTrace();
		throw new TestFailedException();
	}

	public static void exceptionDuringInvoke(MethodHandle mh, MethodType mt, Throwable t) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> " + t);
		t.printStackTrace();
		throw new TestFailedException();
	}

	public static void expectedExceptionDuringCast(MethodHandle mh, MethodType mt, Throwable t) {
		println("Casting " + mh.type() + " to " + mt + " -> got expected exception " + t);
	}

	public static void expectedExceptionDuringInvoke(MethodHandle mh, MethodType mt, Throwable t) {
		println("Invoking " + mh.type() + " as " + mt + " -> got expected exception " + t);
	}

	public static void noNPEDuringInvoke(MethodHandle mh, MethodType mt) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> did not throw NPE");
		throw new TestFailedException();
	}

	public static void noClassCastDuringInvoke(MethodHandle mh, MethodType mt) {
		noClassCastDuringInvoke(mh, mt, "");
	}
	
	private static void noClassCastDuringInvoke(MethodHandle mh, MethodType mt, String messageSuffix) {
		System.out.println("Invoking " + mh.type() + " as " + mt + " -> did not throw ClassCastException." + messageSuffix);
		throw new TestFailedException();
	}
	
	public static void noExceptionDuringCast(MethodHandle mh, MethodType mt) {
		System.out.println("Casting " + mh.type() + " to " + mt + " -> did not throw WrongMethodypeException");
		throw new TestFailedException();
	}

	public static void compare(MethodHandle mh, MethodType mt, boolean expected, boolean result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, byte expected, byte result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, char expected, char result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + (int)expected + " got " + (int)result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, short expected, short result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, int expected, int result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, long expected, long result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, float expected, float result) {
		if (!floatsEqual(expected, result)) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, double expected, double result) {
		if (!floatsEqual(expected, result)) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void compare(MethodHandle mh, MethodType mt, Object expected, Object result) {
		if (expected != result) {
			System.out.println("Invoking " + mh.type() + " as " + mt + " -> expected " + expected + " got " + result);
			throw new TestFailedException();
		}
	}

	public static void testVoid() throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;

		System.out.println("\ttesting void");

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((int)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)0, (int)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((long)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)0, (long)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((float)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)0, (float)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((double)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)0, (double)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((byte)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)0, (byte)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((boolean)false);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, false, (boolean)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((char)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)0, (char)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((short)0);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)0, (short)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null);
		try {
			c = cast(s, mt);
			try {
				c.invokeExact((Object)null);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("()V", null));
		mt = MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)c.invokeExact());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testReference() throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;

		System.out.println("\ttesting reference");

		// Unboxing NULL should give 0 for explicit casting, otherwise it should throw an NPE

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				int result = (int)c.invokeExact((Object) null);
				if (explicit) {					
					compare(s, mt, 0, result);
				} else {
					noNPEDuringInvoke(s, mt);
				}
			} catch (NullPointerException t) {
				if (explicit) {
					// This should return zero, not throw an NPE
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object expected = "argle";
				Object result = (Object)c.invokeExact((String) expected);
				compare(s, mt, expected, result);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Narrowing a reference cast

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object result = (Object)c.invokeExact((Object) new Object());
				noClassCastDuringInvoke(s, mt, " The result was an Object whose toString value is: " + result.toString());
			} catch (ClassCastException t) {
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Narrowing a reference cast of null

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)c.invokeExact((Object) null));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Casting to an implemented interface

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/io/Serializable;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, "argle", (Object)c.invokeExact((String) "argle"));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Casting to an unimplemented interface

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/io/Serializable;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object o = new Object();
				compare(s, mt, o, (Object)c.invokeExact((Object) o));
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

		// return - Unboxing NULL should give 0 for explicit casting, or throw an NPE otherwise*/

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				int result = (int)c.invokeExact((Object) null);
				if (explicit) {
					compare(s, mt, 0, " The result was an int whose value is: " + result);
				} else {
					noNPEDuringInvoke(s, mt);
				}
			} catch (NullPointerException t) {
				if (explicit) {
					// Explicit casting should give a 0 argument, not a NPE
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "testString", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/String;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null);
		try {
			c = cast(s, mt);
			try {
				Object expected = "argle";
				Object result = (Object)c.invokeExact((String) expected);
				compare(s, mt, expected, result);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// return - Narrowing a reference cast

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/String;", null);
		try {
			c = cast(s, mt);
			try {
				String result = (String)c.invokeExact(new Object());
				noClassCastDuringInvoke(s, mt, result);
			} catch (ClassCastException t) {
				expectedExceptionDuringInvoke(s, mt, t);
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// return - Narrowing a reference cast of null

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/String;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, null, (Object)(String)c.invokeExact((Object) null));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// return - Casting to an implemented interface

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/io/Serializable;", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, "argle", (String)(Serializable)c.invokeExact((String) "argle"));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// return - Casting to an unimplemented interface

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/io/Serializable;", null);
		try {
			c = cast(s, mt);
			try {
				Object o = new Object();
				compare(s, mt, o, (Object)(Serializable)c.invokeExact((Object) o));
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

	public static void testBoolean() throws Throwable {
		System.out.println("\ttesting boolean");
		testConvertBoolean(false);
		testConvertBoolean(true);
	}

	public static void testByte() throws Throwable {
		System.out.println("\ttesting byte");
		testConvertByte((byte)0);
		testConvertByte((byte)1);
		testConvertByte((byte)-1);
		testConvertByte(Byte.MIN_VALUE);
		testConvertByte(Byte.MAX_VALUE);
	}

	public static void testShort() throws Throwable {
		System.out.println("\ttesting short");
		testConvertShort((short)0);
		testConvertShort((short)1);
		testConvertShort((short)-1);
		testConvertShort(Byte.MIN_VALUE);
		testConvertShort(Byte.MAX_VALUE);
		testConvertShort(Short.MIN_VALUE);
		testConvertShort(Short.MAX_VALUE);
	}

	public static void testChar() throws Throwable {
		System.out.println("\ttesting char");
		testConvertChar((char)0);
		testConvertChar((char)1);
		testConvertChar((char)Byte.MAX_VALUE);
		testConvertChar((char)Short.MAX_VALUE);
		testConvertChar(Character.MAX_VALUE);
	}

	public static void testInt() throws Throwable {
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

	public static void testLong() throws Throwable {
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

	public static void testFloat() throws Throwable {
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

	public static void testDouble() throws Throwable {
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

	public static void testConvertInt(int v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Integer(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(I)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(I)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(I)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((int)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(I)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((int)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((int)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(I)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((int)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((int)v));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(I)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((int)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((int)v));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(I)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((int)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(I)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((int)v));
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

		mt = MethodType.fromMethodDescriptorString("(I)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Integer) (Object)c.invokeExact((int)v)).intValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Integer) (Object)c.invokeExact((int)v)).intValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertLong(long v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Long(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(J)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((long)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((long)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(J)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(J)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((long)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(J)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((long)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((long)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(J)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((long)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((long)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(J)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((long)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((long)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(J)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((long)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(J)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((long)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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

		mt = MethodType.fromMethodDescriptorString("(J)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, ((Long) (Object)c.invokeExact((long)v)).longValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, ((Long) (Object)c.invokeExact((long)v)).longValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertByte(byte v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Byte(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(B)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(B)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(B)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(B)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(B)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((byte)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((byte)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(B)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((byte)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((byte)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(B)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(B)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((byte)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing

		mt = MethodType.fromMethodDescriptorString("(B)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, ((Byte) (Object)c.invokeExact((byte)v)).byteValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, ((Byte) (Object)c.invokeExact((byte)v)).byteValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertChar(char v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Character(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(C)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(C)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(C)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(C)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(C)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((char)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((char)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(C)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((char)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((char)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((char)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(C)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((char)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(C)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((char)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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

		mt = MethodType.fromMethodDescriptorString("(C)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, ((Character) (Object)c.invokeExact((char)v)).charValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertBoolean(boolean v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Boolean(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(Z)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, intFromBoolean(v), (int)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, intFromBoolean(v), (int)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, intFromBoolean(v), (int)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, intFromBoolean(v), (int)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(Z)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, longFromBoolean(v), (long)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, longFromBoolean(v), (long)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, longFromBoolean(v), (long)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, longFromBoolean(v), (long)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(Z)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, floatFromBoolean(v), (float)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, floatFromBoolean(v), (float)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, floatFromBoolean(v), (float)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, floatFromBoolean(v), (float)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(Z)D", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)D", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, doubleFromBoolean(v), (double)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(Z)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, byteFromBoolean(v), (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact((boolean)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, v, (boolean)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(Z)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, charFromBoolean(v), (char)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, charFromBoolean(v), (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, charFromBoolean(v), (char)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, charFromBoolean(v), (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(Z)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, shortFromBoolean(v), (short)c.invokeExact((boolean)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, shortFromBoolean(v), (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(Z)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, shortFromBoolean(v), (short)c.invokeExact((boolean)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, shortFromBoolean(v), (short)c.invokeExact((Object)o));
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

		mt = MethodType.fromMethodDescriptorString("(Z)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (boolean)v, ((Boolean) (Object)c.invokeExact((boolean)v)).booleanValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertShort(short v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Short(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(S)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(S)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(S)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(S)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(S)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((short)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((short)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(S)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((short)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((short)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(S)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((short)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((short)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(S)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((short)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		// Test boxing

		mt = MethodType.fromMethodDescriptorString("(S)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, ((Short) (Object)c.invokeExact((short)v)).shortValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, ((Short) (Object)c.invokeExact((short)v)).shortValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertFloat(float v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Float(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(F)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(F)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(F)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((float)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(F)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(F)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(F)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((float)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(F)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((float)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		mt = MethodType.fromMethodDescriptorString("(F)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, ((Float) (Object)c.invokeExact((float)v)).floatValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, ((Float) (Object)c.invokeExact((float)v)).floatValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

	public static void testConvertDouble(double v) throws Throwable {
		MethodHandle s;
		MethodHandle c;
		MethodType mt;
		Object o = new Double(v);

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(I)I", null));
		mt = MethodType.fromMethodDescriptorString("(D)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)I", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (int)v, (int)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (int)v, (int)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(J)J", null));
		mt = MethodType.fromMethodDescriptorString("(D)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)J", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (long)v, (long)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)J", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (long)v, (long)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(F)F", null));
		mt = MethodType.fromMethodDescriptorString("(D)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (float)v, (float)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)F", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (float)v, (float)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)F", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (float)v, (float)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((double)v));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, (double)c.invokeExact((Object)o));
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(B)B", null));
		mt = MethodType.fromMethodDescriptorString("(D)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)B", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (byte)v, (byte)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)B", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (byte)v, (byte)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Z)Z", null));
		mt = MethodType.fromMethodDescriptorString("(D)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)Z", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Z", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, castToBoolean(v), (boolean)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(C)C", null));
		mt = MethodType.fromMethodDescriptorString("(D)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)C", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (char)v, (char)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)C", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (char)v, (char)c.invokeExact((Object)o));
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

		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(S)S", null));
		mt = MethodType.fromMethodDescriptorString("(D)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((double)v));
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
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(D)D", null));
		mt = MethodType.fromMethodDescriptorString("(D)S", null);
		try {
			c = cast(s, mt);
			if (explicit) {
				try {
					compare(s, mt, (short)v, (short)c.invokeExact((double)v));
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
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		mt = MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)S", null);
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (short)v, (short)c.invokeExact((Object)o));
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

		mt = MethodType.fromMethodDescriptorString("(D)Ljava/lang/Object;", null);
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, ((Double) (Object)c.invokeExact((double)v)).doubleValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/Number;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			try {
				compare(s, mt, (double)v, ((Double) (Object)c.invokeExact((double)v)).doubleValue());
			} catch (Throwable t) {
				exceptionDuringInvoke(s, mt, t);
			}
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
		s = MethodHandles.lookup().findStatic(StaticAsTypeTestExplicit.class, "test", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)Ljava/lang/Object;", null));
		try {
			c = cast(s, mt);
			noExceptionDuringCast(s, mt);
		} catch (WrongMethodTypeException t) {
			expectedExceptionDuringCast(s, mt, t);
		} catch (Throwable t) {
			exceptionDuringCast(s, mt, t);
		}
	}

}

/**
 * Added to this class to allow continued use of static methods
 * in a multi threaded workload env.
 *
 */
class TestFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
}
