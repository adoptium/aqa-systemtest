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

package net.adoptopenjdk.test.classloading.deadlock;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DeadlockTest
 * ============
 * 
 * This testcase verifies the correct behaviour of the ClassLoader.registerAsParallelCapable() API function added into SDK 7.0. 
 * The API call allows a ClassLoader to flag itself as being capable of parallel delegation which causes the VM to use a 
 * different locking mechanism for the selected ClassLoader. This feature aims to eliminate a long standing Java bug where 
 * classloaders that delegate to one another can create a situation where ClassLoader A takes a lock to load Class 1 and 
 * delegates the loading of Class 2 to ClassLoader B while class B is loading Class 3 itself holding a lock and attempting 
 * to delegate the loading of Class 4 to ClassLoader A. Under the old locking scheme this results in deadlock. With 
 * registerAsParallelCapable() the deadlock should be avoided.
 * 
 * In order for this test to work, the classes to be loaded should not be present on the classpath. They must instead be located 
 * using a URLClassLoader and the locations of the test classes should be passed in as arguments. The deadlock does not occur if 
 * the test classes are on the classpath.
 * 
 */

public class DeadlockTest
{

	private MyClassLoader1 myCL1 = null;
	private MyClassLoader2 myCL2 = null;
	
	private URL firstURL = null;	// Should point to the location of the classes in net.adoptopenjdk.test.classloading.deadlock.package1
	private URL secondURL = null;	// Should point to the location of the classes in net.adoptopenjdk.test.classloading.deadlock.package2
	
	public DeadlockTest(URL firstURLIn, URL secondURLIn)
	{
		firstURL = firstURLIn;
		secondURL = secondURLIn;
	}
	
	public DeadlockTest() {
	}
	
	public void runTest() throws MalformedURLException, ClassNotFoundException, InterruptedException {
		String[] testArgs = new String[]{"openjdk.test.classloading/bin_notonclasspath/url1/", "openjdk.test.classloading/bin_notonclasspath/url2/"};
		new DeadlockTest();
		DeadlockTest.main(testArgs);
	}
	
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InterruptedException
	{
		if(args.length != 2)
		{
			System.err.println("DeadlockTest requires two string arguments to run correctly. Invoked with " + args.length + " arguments");
			throw new IllegalStateException();
		}
		else
		{
			URL firstURL = null;
			URL secondURL = null;
			
			try 
			{
				/* 
				 * Create a URL which points to the location of the classes within 
				 * net.adoptopenjdk.classloading.deadlock.package1 & package2 using the System 
				 * property java.classloading.dir (which is defined in ClassloadingLoadTest.java)
				 */
				firstURL = new URL("file://" + System.getProperty("java.classloading.dir") + System.getProperty("file.separator") + args[0]);
				secondURL = new URL("file://" + System.getProperty("java.classloading.dir") + System.getProperty("file.separator") + args[1]);
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
				throw e;
			}
			
			if(firstURL != null && secondURL != null)
			{					
				DeadlockTest test = new DeadlockTest(firstURL, secondURL);	// Load up and start the test
				test.testDeadlock();
			}		
			else
			{
				System.err.println("Not running DeadlockTest as URLs were null.");
			}
		}
	}
	
	public void testDeadlock() throws ClassNotFoundException, InterruptedException
	{
		// Try resolving the class without using a URLClassLoader
		try {
			Class.forName("net.adoptopenjdk.test.classloading.deadlock.package1.CL1_A");
			// If this call succeeds then we should fail as the whole point of this test 
			// is that these classes are NOT on the classpath
		    throw new java.lang.RuntimeException("Class net.adoptopenjdk.test.classloading.deadlock.package1.CL1_A was FOUND which means that the test configuration is invalid");
		}
		catch (ClassNotFoundException e) {
			// This is what we want to happen.
		}
		

		myCL1 = new MyClassLoader1(new URL[] { firstURL } );		// This classloader loads CL1_A and CL1_D classes
		myCL2 = new MyClassLoader2(new URL[] { secondURL } );		// This classloader loads CL2_B and CL2_C classes
		
		// DeadlockHelperRunnable will take the second classloader and attempt to load CL2_C
		DeadlockHelperRunnable deadlockHelper = new DeadlockHelperRunnable(myCL2);
		Thread deadlockThread = new Thread(deadlockHelper, "ClassLoaderDeadlock-HelperThread");
		deadlockThread.start();

		try
		{
			myCL1.loadClass("net.adoptopenjdk.test.classloading.deadlock.package1.CL1_A");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			// As this test is running in a load test framework we don't want threads to hang around after the test completes so we join()
			deadlockThread.join();			
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			throw e;
		}
		
	}

	private class DeadlockHelperRunnable implements Runnable
	{
		private MyClassLoader2 myCL2 = null;
		
		public DeadlockHelperRunnable(MyClassLoader2 myCL2In)
		{
			myCL2 = myCL2In;
		}

		public void run()
		{
			try 
			{
				myCL2.loadClass("net.adoptopenjdk.test.classloading.deadlock.package2.CL2_C");
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
				System.err.println("Class net.adoptopenjdk.test.classloading.deadlock.package2.CL2_C could not be found");
			}
		}
	}

}
