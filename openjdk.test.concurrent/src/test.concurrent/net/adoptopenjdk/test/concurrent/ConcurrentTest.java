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
/**
 * File:    ConcurrentTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent;

import java.util.Random;

import java.util.concurrent.atomic.AtomicLong;

import junit.framework.TestCase;
import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * ConcurrentTest
 * ======================
 * 
 * Defines some common utility functions for use in the testcases for the java.util.concurrent.* classes.
 */

public class ConcurrentTest extends TestCase
{

	// A common, unchanging randomSeed to help with problem reproduction and still allow for the use of 'randomness'
	private static long randomSeed = 47L;
	protected static Random rng = new Random();

	// MAXWAITTIME used for some API calls to prevent them from blocking forever
	protected static int MAXWAITTIME = 500;
	// A timeout used for the various testStress() functions
	protected static long stressTimeout = 30000;
	
	// The number of times the buildString method has been called,
	// to avoid returning duplicate strings.
	private static AtomicLong buildStringCount = new AtomicLong(0);
	
	/**
	 * Default no arguments constructor
	 */
	public ConcurrentTest()
	{
		this(randomSeed);
	}
	
	/**
	 * Constructor allowing for the random number generator used by concurrent tests to be seeded
	 */
	public ConcurrentTest(long seed)
	{
		randomSeed = seed;
		rng = new Random(randomSeed);
	}
	
	/**
	 * Creates an instance of GenericTestObject
	 */
	public GenericTestObject makeNewTestObject()
	{
		return makeNewTestObject(null);
	}
	
	/**
	 * Creates an instance of GenericTestObject with <i>namePrefix</i> prepended to the string
	 * argument of the created GenericTestObject.
	 */
	public GenericTestObject makeNewTestObject(String namePrefix)
	{
		return new GenericTestObject(namePrefix + buildString(), rng.nextInt(), rng.nextDouble(), rng.nextLong(), rng.nextBoolean());
	}
	
	/**
	 * Generates a random string of up to 47 ASCII characters followed by the current value of System.nanoTime()
	 * in an attempt to generate a unique string each time the method is called. 
	 * 
	 * Returns - a randomly generated sequence of characters, plus the number of
	 * times this method has been called, to avoid duplicate strings.
	 */
	public static String buildString()
	{
		String returnString = "";
		int loopThisManyTimes = rng.nextInt(47) + 1;
		
		for(int i = 0; i < loopThisManyTimes; i++)
		{
			String nextChar = "" + (char)(rng.nextInt(27) + 65);	 // ASCII characters
			if(rng.nextBoolean())
			{
				nextChar.toLowerCase();
			}
			returnString += nextChar;
		}
		
		return returnString + buildStringCount.incrementAndGet();
	}
	
	/**
	 * A simple helper function for sleeping for a given period of time. Aims to keep the code
	 * in the testcases tidier by handling the InterruptedException here.
	 */
	public void sleep(long duration)
	{
		try
		{
			Thread.sleep(duration);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
