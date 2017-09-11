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

import java.util.*;
import java.lang.invoke.*;
import java.lang.reflect.*;

/*
 * An improved version of BasicTest with a few more methods, testing
 * java.lang.invoke.*
 */
public class BasicTest2 {

    int numExceptions = 0;

    boolean catchExceptionsAndContinue = false;

    public static void main(String[] args) throws Throwable {
        BasicTest2 that = new BasicTest2();
        System.out.println("Starting first run");
        that.runSomeTests(args);
        System.out.println("\nStarting second run");
        that.runSomeTests(args);
        System.out.println("Done main.  " + that.numExceptions + " errors");
        if (that.numExceptions >= 1)
            System.exit(1);
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

    public static void check(MethodType ideal, MethodType actual) {
        if (ideal.equals(actual))
            System.out.print(".");
        else {
            String idealString = (ideal==null)? "null" : ideal.toString();
            String actualString = (actual==null)? "null" : actual.toString();
            throw new Error("ERROR: Expected " + idealString + "; found " + actualString);
        }
    }

    public void runTest(Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.print(method.getName() + " : ");
        if (catchExceptionsAndContinue) {
            try {
                method.invoke(null);
            } catch (InvocationTargetException e) {
                numExceptions++;
                System.out.println("ERROR");
                e.getCause().printStackTrace();
            }
        } else {
            method.invoke(null);
        }
        System.out.println();
    }

    public void runTests(List<Method> methods) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Method method: methods)
            runTest(method);
    }

    public void runTests(String[] testNames) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Method> methods = new LinkedList<Method>();
        for (String name: testNames) {
            if (name.startsWith("test"))
                methods.add(BasicTest2.class.getMethod(name));
            else
                throw new Error("Test name '" + name + "' must begin with 'test'");
        }
        runTests(methods);
    }

    public void runAllTests() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Method> methods = new LinkedList<Method>();
        for (Method method: BasicTest2.class.getMethods())
            if (method.getName().startsWith("test"))
                methods.add(method);
        runTests(methods);
    }

    public void runSomeTests(String[] testNames) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (testNames.length == 0)
            runAllTests();
        else
            runTests(testNames);
    }

    public static void testNothing() {
        check("OK", "OK");
    }

    
    public static void testVoidMethod() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(BasicTest2.Superclass.class, "voidMethod", MethodType.fromMethodDescriptorString("(I)V", null));
        Implementation1 i1 = new Implementation1();
        Implementation2 i2 = new Implementation2();
        i1.intProperty = 0;
        i2.intProperty = 0;
        mh.invokeExact((BasicTest2.Superclass)i1, 123);
        check(10123, i1.intProperty);
        mh.invokeExact((BasicTest2.Superclass)i2, 456); // Optimiser should be able to eliminate checks on this one
        check(20456, i2.intProperty);
        i1.longMethod(1L, null);
    }


    public static void testLongMethod() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(BasicTest2.Superclass.class, "longMethod", MethodType.fromMethodDescriptorString("(JLnet/adoptopenjdk/test/lang/invoke/BasicTest2$Superclass;)J", null));
        Implementation1 i1 = new Implementation1();
        Implementation2 i2 = new Implementation2();
        check(456, (long)mh.invokeExact((BasicTest2.Superclass)i1, (long)456, (BasicTest2.Superclass)i1));
        check( -1, (long)mh.invokeExact((BasicTest2.Superclass)i1, (long)456, (BasicTest2.Superclass)i2));
        check(456, (long)mh.invokeExact((BasicTest2.Superclass)i2, (long)456, (BasicTest2.Superclass)i1));
        check( -2, (long)mh.invokeExact((BasicTest2.Superclass)i2, (long)456, (BasicTest2.Superclass)i2));
    }


    public static void testInterfaceMethod() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(BasicTest2.Interface.class, "interfaceMethod", MethodType.fromMethodDescriptorString("()V", null));
        Implementation1 i1 = new Implementation1();
        Implementation3 i3 = new Implementation3();
        mh.invokeExact((BasicTest2.Interface)i1);
        check(1001, i1.intProperty);
        mh.invokeExact((BasicTest2.Interface)i3);
        check(1003, i3.intProperty);
    }

    public static void testFieldSetter() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findSetter(Implementation1.class, "instanceInt", int.class);
        Implementation1 i1 = new Implementation1();
        mh.invokeExact(i1, 1);
        i1.checkInstanceInt(1);
        mh.invokeExact(i1, 2);
        i1.checkInstanceInt(2);
    }

    public static void testFieldGetter() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findGetter(Implementation1.class, "instanceInt", int.class);
        Implementation1 i1 = new Implementation1();
        i1.instanceInt = 1;
        check(1, (int)mh.invokeExact(i1));
        i1.instanceInt = 2;
        check(2, (int)mh.invokeExact(i1));
    }

    public static void testAsTypeWithWidening() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asType(MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FF[J)J", null));
        check(3, (long)mh.invokeExact(new ArrayTaker(), 1.0f, 2.0f, new long[0]));
    }

    public static void testAsTypeWithUnboxingAndNarrowing() throws Throwable { 
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asType(MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;Ljava/lang/Object;D[J)I", null));
        check(3, (int)mh.invokeExact(new ArrayTaker(), (Object)Float.valueOf(1.0f), 2.0d, new long[0]));
        try {
            check(6, (int)mh.invokeExact(new ArrayTaker(), (Object)Double.valueOf(2.0d), 3.0d, new long[1]));
            check("java.lang.ClassCastException", "no exception");
        } catch (Exception e) {
            check("java.lang.ClassCastException", e.getClass().getName());
        }
    }


    public static void testInvokeExactHandle() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(BasicTest2.Superclass.class, "voidMethod", MethodType.fromMethodDescriptorString("(I)V", null));
        MethodHandle ie = MethodHandles.lookup()
                          .findVirtual(MethodHandle.class, "invokeExact", MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$Superclass;I)V", null));
        Implementation1 i1 = new Implementation1();
        i1.intProperty = 0;
        ie.invokeExact(mh, (BasicTest2.Superclass)i1, 111);
        check(10111, i1.intProperty);
    }



    public static void testInvokeExactHandleWithMismatchedTypes() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(BasicTest2.Superclass.class, "voidMethod", MethodType.fromMethodDescriptorString("(I)V", null));
        MethodHandle ie = MethodHandles.lookup()
                          .findVirtual(MethodHandle.class, "invokeExact", MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;J)V", null));
        Implementation1 i1 = new Implementation1();
        i1.intProperty = 0;
        try {
            ie.invokeExact(mh, (BasicTest2.Superclass)i1, 111);
            check("java.lang.invoke.WrongMethodTypeException", "no exception");
        } catch (Exception e) {
            check("java.lang.invoke.WrongMethodTypeException", e.getClass().getName());
            check(0, i1.intProperty);
        }
    }


    public static void testInvokeExactHandleWithCollectorAndAsType() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asCollector(Class.forName("[J"), 3).asType(MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FFIILjava/lang/Long;)I", null));
        MethodHandle ie = MethodHandles.lookup()
                          .findVirtual(MethodHandle.class, "invokeExact", MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FFIILjava/lang/Long;)I", null));
        check(9, (int)ie.invokeExact(mh, new ArrayTaker(), 2.0f, 4.0f, 123, 234, Long.valueOf(345L)));
    }

    public static void testConstructor() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findConstructor(Constructible.class, MethodType.fromMethodDescriptorString("(I)V", null));
        Constructible c = (Constructible)mh.invokeExact(1234);
        check(1234, c.field);
    }

    public static void testReceiverBoundHandle() throws Throwable {
        Implementation1 i1 = new Implementation1();
        Implementation2 i2 = new Implementation2();
        MethodHandle mh = MethodHandles.lookup()
                          .bind(i1, "longMethod", MethodType.fromMethodDescriptorString("(JLnet/adoptopenjdk/test/lang/invoke/BasicTest2$Superclass;)J", null));
        check(456, (long)mh.invokeExact((long)456, (BasicTest2.Superclass)i1));
        check( -1, (long)mh.invokeExact((long)456, (BasicTest2.Superclass)i2));
    }

    public static void testInvoke() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null));
        long[] longs = { 1L, 2L};
        check(48, (int)mh.invoke(new ArrayTaker(), 12.0f, 34.0f, longs));
    }

    public static void testInvokeHandle() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null));
        MethodHandle ig = MethodHandles.lookup()
                          .findVirtual(MethodHandle.class, "invoke", MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FF[J)I", null));
        long[] longs = { 1L, 2L};
        check(48, (int)ig.invokeExact(mh, new ArrayTaker(), 12.0f, 34.0f, longs));
    }

    public static void testSomething() throws Throwable {
    	//This code is used in several places inside this class. This method uses it on its own, so if we see any issues with the other instances,
    	//we can tell if this code is causing the problem by itself, or if it's the context of the other instances that's causing the problem.
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asCollector(Class.forName("[J"), 3).asType(MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FFIILjava/lang/Long;)I", null));
        check(9, (int)mh.invokeExact(new ArrayTaker(), 2.0f, 4.0f, 123, 234, Long.valueOf(345L)));
    }


    public static void testWrongType() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findSetter(Implementation3.class, "intProperty", int.class);
        Implementation3 i3 = new Implementation3();
        i3.intProperty = 0;
        try {
            mh.invokeExact("This should be an int");
            check("WrongMethodTypeException", "no exception");
        } catch (Exception e) {
            check("java.lang.invoke.WrongMethodTypeException", e.getClass().getName());
            check(0, i3.intProperty);
        }
    }


    public static void testStackTraceThroughInvokeExact() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findStatic(StackTracer.class, "getAStackTrace", MethodType.fromMethodDescriptorString("()Ljava/lang/Exception;", null));
        check("Hello!", ((Exception)mh.invokeExact()).getMessage());
    }

    public static void testFilterReturnI2String() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null));
        MethodHandle filter = MethodHandles.lookup()
                              .findStatic(ArrayTaker.class, "taggedString", MethodType.fromMethodDescriptorString("(I)Ljava/lang/String;", null));
        mh = MethodHandles.filterReturnValue(mh, filter);
        long[] longs = { 1L, 2L, 3L};
        check("<<16>>", (String)mh.invokeExact(new ArrayTaker(), 6.0f, 7.0d, longs));
    }

    public static void testFilterReturnString2I() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findStatic(ArrayTaker.class, "staticPrimitives", MethodType.fromMethodDescriptorString("(FD[J)Ljava/lang/String;", null));
        MethodHandle filter = MethodHandles.lookup()
                              .findVirtual(String.class, "length", MethodType.fromMethodDescriptorString("()I", null));
        mh = MethodHandles.filterReturnValue(mh, filter);
        long[] longs = { 1L, 2L, 3L};
        check(37, (int)mh.invokeExact(8.0f, 9.0d, longs));
    }
    

    public static void testFilterReturnI2V() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitivesToClassWithProperty", MethodType.fromMethodDescriptorString("(FD[JLnet/adoptopenjdk/test/lang/invoke/BasicTest2$ClassWithProperty;)Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ClassWithProperty;", null));
        MethodHandle filter = MethodHandles.lookup()
                              .findVirtual(ClassWithProperty.class, "addTwo", MethodType.fromMethodDescriptorString("()V", null));
        mh = MethodHandles.filterReturnValue(mh, filter);
        
        long[] longs = { 1L, 2L, 3L};
        ClassWithProperty bob = new ClassWithProperty();

        mh.invokeExact(new ArrayTaker(), 6.0f, 7.0d, longs, bob);
        check(18, bob.intProp);
    }
    


    // asCollector tests 

    public static void testCollectorWithPrimitives() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual( ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asCollector(Class.forName("[J"), 2);
        check(8, (int)mh.invokeExact(new ArrayTaker(), 2.0f, 4.0d, 123L, 345L));
    }

    public static void testCollectorWithObjects() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "objects", MethodType.fromMethodDescriptorString("(Ljava/lang/Float;Ljava/lang/Double;[Ljava/lang/Long;)Ljava/lang/Integer;", null))
                          .asCollector(Class.forName("[Ljava.lang.Long;"), 2);
        check(8, (Integer)mh.invokeExact(new ArrayTaker(), Float.valueOf(2.0f), Double.valueOf(4.0d), Long.valueOf(123L), Long.valueOf(345L)));
    }

    public static void testCollectorWithStaticPrimitives() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findStatic(ArrayTaker.class, "staticPrimitives", MethodType.fromMethodDescriptorString("(FD[J)Ljava/lang/String;", null))
                          .asCollector(Class.forName("[J"), 2);
        check("staticPrimitives(1.0, 4.0, [123, 345])", (String)mh.invokeExact(1.0f, 4.0d, 123L, 345L));
    }

    public static void testCollectorWithStaticObjects() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findStatic(ArrayTaker.class, "staticObjects", MethodType.fromMethodDescriptorString("(Ljava/lang/Float;Ljava/lang/Double;[Ljava/lang/Long;)Ljava/lang/Integer;", null))
                          .asCollector(Class.forName("[Ljava.lang.Long;"), 2);
        check(8, (Integer)mh.invokeExact(Float.valueOf(2.0f), Double.valueOf(4.0d), Long.valueOf(123L), Long.valueOf(345L)));
    }

    public static void testCollectorWithAsType() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual(ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asCollector(Class.forName("[J"), 3).asType(MethodType.fromMethodDescriptorString("(Lnet/adoptopenjdk/test/lang/invoke/BasicTest2$ArrayTaker;FDIILjava/lang/Long;)I", null));
        check(9, (int)mh.invokeExact(new ArrayTaker(), 2.0f, 4.0d, 123, 234, Long.valueOf(345L)));
    }

    public static void testCollectorWithDifferentArrayClass() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual( ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FDLjava/lang/Object;)I", null))
                          .asCollector(Class.forName("[J"), 2);
        check(10, (int)mh.invokeExact(new ArrayTaker(), 3.0f, 5.0d, 123L, 345L));
    }

    public static void testCollectorZero() throws Throwable {
        MethodHandle mh = MethodHandles.lookup()
                          .findVirtual( ArrayTaker.class, "primitives", MethodType.fromMethodDescriptorString("(FD[J)I", null))
                          .asCollector(Class.forName("[J"), 0);
        check(6, (int)mh.invokeExact(new ArrayTaker(), 2.0f, 4.0d));
    }

    public static void testVarargsCollector() throws Throwable {
        // From javadoc for asVarargsCollector
        MethodHandle asList = MethodHandles.lookup()
                              .findStatic(Arrays.class, "asList", MethodType.methodType(List.class, Object[].class))
                              .asVarargsCollector(Object[].class);
        check("[]", asList.invoke().toString());
        check("[1]", asList.invoke(1).toString());
        check("[two, too]", asList.invoke("two", "too").toString());
        Object[] argv = { "three", "thee", "tee"};
        check("[three, thee, tee]", asList.invoke(argv).toString());
        List<Object[]> ls = (List<Object[]>) asList.invoke((Object)argv);
        check(1, ls.size());
        check("[three, thee, tee]", Arrays.toString(ls.get(0)));
    }

    public static void testUnVarargsCollector() throws Throwable {
        // From javadoc for asVarargsCollector
        MethodHandle vamh = MethodHandles.lookup()
                            .findStatic(Arrays.class, "asList", MethodType.methodType(List.class, Object[].class))
                            .asVarargsCollector(Object[].class);
        MethodHandle invokeExact = MethodHandles.lookup()
                                   .findVirtual(MethodHandle.class, "invokeExact", vamh.type()); // removes the varargness
        MethodHandle mh = invokeExact.bindTo(vamh);
        check(vamh.type(), mh.type());
        check("[1, 2, 3]", vamh.invoke(1,2,3).toString());
        try {
            mh.invoke(1,2,3);
            check("java.lang.invoke.WrongMethodTypeException", "no exception");
        } catch (Exception e) {
            check("java.lang.invoke.WrongMethodTypeException", e.getClass().getName());
        }
    }
    
    static abstract class Superclass {
    	
    	public int intProperty = 0;
    	
    	public abstract void voidMethod(int argument);
        public abstract long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.BasicTest2.Superclass arg2);
    }
    
    static interface Interface {
        public void interfaceMethod();
    }
    

    static class Implementation1 extends BasicTest2.Superclass implements Interface {

        public int instanceInt;
        
        public void voidMethod(int argument) {
            intProperty = 10000 + argument;
        }

        public long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.BasicTest2.Superclass arg2) {
            if (this == arg2)
                return arg1;
            else
                return -1;
        }
        
        public void interfaceMethod() {
            intProperty = 1001;
        }

        public void checkInstanceInt(int desiredValue) {
            BasicTest2.check(desiredValue, instanceInt);
        }
    }

    static class Implementation2 extends BasicTest2.Superclass {
    	
    	public int instanceInt = 0;
    	
        public void voidMethod(int argument) {
            intProperty = 20000 + argument;
        }

        public long longMethod(long arg1, net.adoptopenjdk.test.lang.invoke.BasicTest2.Superclass arg2) {
            if (this == arg2)
                return -2;
            else
                return arg1;
        }
    }
    
    static class Implementation3 implements Interface {
    	
    	public int intProperty = 0;
    	
        public void interfaceMethod() {
            intProperty = 1003;
        }
        
    }


    static class ArrayTaker {
    	
    	public int intProperty = 0;
    	
        public int primitives(float f, double d, long[] longs) {
            return(int)f + (int)d + longs.length;
        }
        public ClassWithProperty primitivesToClassWithProperty(float f, double d, long[] longs, ClassWithProperty bob) {
        	int result = (int)f + (int)d + longs.length;
            bob.intProp = result;
            return bob;
        }
        public Integer objects(Float f, Double d, Long[] longs) {
            return(int)f.floatValue() + (int)d.doubleValue() + longs.length;
        }
        public int primitives(float f, double d, Object longArray) {
            return primitives(f, d, (long[])longArray);
        }

        public static String staticPrimitives(float f, double d, long[] longs) {
            return "staticPrimitives(" + f + ", " + d + ", " + Arrays.toString(longs) + ")";
        }
        public static Integer staticObjects(Float f, Double d, Long[] longs) {
            return(int)f.floatValue() + (int)d.doubleValue() + longs.length;
        }
        public static String taggedString(int arg) {
            return "<<" + arg + ">>";
        }

        public static int V2I() {
            return 987;
        }
        
        public void I2V(int arg) {
            intProperty = arg;
        }

    }
    
    static class ClassWithProperty {
    	
    	public int intProp = -1;
    	    	
    	public void addTwo() {
    		this.intProp += 2;
    	}
    	
    }

    static class Constructible {

        public int field;

        public Constructible(int arg){
            field = arg;
        }

    }

    static class StackTracer {
        public static Exception getAStackTrace(){ return new Exception("Hello!");}
    }

}



