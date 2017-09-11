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

/*
 * A class which contains some static methods to test static getters
 * and setters in the java.lang.invoke package. These tests are intended
 * to run as part of a multi-threaded workload, so they are all synchronized.
 * 
 *  Each test method has its own lock object to reduce contention a little
 *  bit.
 */
public class BasicStaticTest {
	
	public static void main(String[] args) {
		try {
			testStaticSetter();
			testStaticGetter();
			testStaticStringGetter();
			testStaticStringSetter();
		} catch (Throwable e) {
			System.out.println("Caught an exception");
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("All tests passed");
		System.exit(0);
	}

	/**
	 * This test method uses synchronization at the method level, to make sure
	 * that it is tested. Hence this is using the class lock for this class.
	 */
	static int staticSettableInt;	
	public static synchronized void testStaticSetter() throws Throwable {		
		staticSettableInt = 0;
		MethodHandle mh = MethodHandles.lookup().findStaticSetter(BasicStaticTest.class, "staticSettableInt", int.class);
		mh.invoke(1);
		check(1, staticSettableInt);
		mh.invokeExact(2);
		check(2, staticSettableInt);
	}
	
	
	
	static int staticGettableInt;
	private static Object staticGettableIntLock = new Object();
	
	public static void testStaticGetter() throws Throwable {
		synchronized(staticGettableIntLock) {
			
			MethodHandle mh = MethodHandles.lookup().findStaticGetter(BasicStaticTest.class, "staticGettableInt", int.class);
			
			staticGettableInt = 1;
			check(1, (int)mh.invoke());
			
			staticGettableInt = 2;
			check(2, (int)mh.invoke());
			
		}
	}
	
	
	
	static String staticGettableString;
	private static Object staticGettableStringLock = new Object();
	
	public static void testStaticStringGetter() throws Throwable {
		synchronized(staticGettableStringLock) {
			
			MethodHandle mh = MethodHandles.lookup().findStaticGetter(BasicStaticTest.class, "staticGettableString", String.class);
			
			staticGettableString = "First";
			check("First", (String)mh.invoke());
			
			staticGettableString = "Second";
			check("Second", (String)mh.invoke());
			
		}
	}
	
	
	
	static String staticSettableString;
	private static Object staticSettableStringLock = new Object();
	
	public static void testStaticStringSetter() throws Throwable {
		synchronized(staticSettableStringLock) {
			
			MethodHandle mh = MethodHandles.lookup().findStaticSetter(BasicStaticTest.class, "staticSettableString", String.class);
			
			staticSettableString = "foo";

			mh.invoke("First");
			check("First", staticSettableString);
			
			mh.invoke("Second");
			check("Second", staticSettableString);
			
		}
	}

	
    public static void check(int ideal, int actual) {
        if (ideal != actual) {
            throw new Error("ERROR: Expected " + ideal + "; found " + actual);
        }
    }


    public static void check(String ideal, String actual) {
		// We check for nulls, then we check for equality.
		if((ideal == null) || (actual == null)) {
			if(ideal != actual){
				throw new Error("ERROR: Expected " + ideal + " but found " + actual);
			}
		} else if (!ideal.equals(actual)) {
			throw new Error("ERROR: Expected " + ideal + " but found " + actual);
		}
    }

    public static void check(MethodType ideal, MethodType actual) {
        if (!ideal.equals(actual)) {
            String idealString = (ideal==null)? "null" : ideal.toString();
            String actualString = (actual==null)? "null" : actual.toString();
            throw new Error("ERROR: Expected " + idealString + "; found " + actualString);
        }
    }



}
