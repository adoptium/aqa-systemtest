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
 * File:    AtomicTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent.atomic;

import java.util.Random;

import junit.framework.TestCase;

/**
 * AtomicTest
 * ==========
 * 
 * Defines some common utility functions for use in the testcases for the java.util.concurrent.atomic.* classes.
 */

public class AtomicTest extends TestCase 
{
	
	// A common, unchanging randomSeed to help with problem reproduction and still allow for the use of 'randomness'
	private static long randomSeed = 47L;
	protected static Random rng = new Random();
	
	// A timeout used for the various testStress() functions
	protected static long stressTimeout = 30000;

	/**
	 * Default no arguments constructor
	 */
	public AtomicTest()
	{
		this(randomSeed);
	}
	
	/**
	 * Constructor allowing for the seeding of the random number generator
	 * @param seed
	 */
	@Deprecated
	public AtomicTest(long seed)
	{
		randomSeed = seed;
		rng = new Random(randomSeed);
	}
	
	/**
	 * A simple helper function for sleeping for a given period of time. Aims to keep the code
	 * in the testcases tidier by handling the InterruptedException here.
	 * 
	 * @param duration
	 */
	@Deprecated
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
