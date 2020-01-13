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

package net.adoptopenjdk.test.classloading;

import java.io.*;
import java.util.*;

public class ClassHog 
{
	private static int cnt;
	
	int loopCount = 2;
	String parmlist = "dict:class.dict";

	public void run() throws IOException, ClassNotFoundException
	{
		String dictFileName = "class.dict";
		for (int i=0;i<loopCount;i++)
		{
			String classToLoad=null;
			Class<?> c=null;
			
			int indx = parmlist.toLowerCase().indexOf("dict:");
			if (indx != -1) {
				String tmps = parmlist.substring(indx + 5);
				StringTokenizer tk = new StringTokenizer (tmps, " ");
				dictFileName = tk.nextToken(); 
			}

			ClassLoader classLoader = getClass().getClassLoader();
			FileReader dictFileReader = new FileReader(classLoader.getResource("net/adoptopenjdk/test/classloading/" +  dictFileName).getFile());
			int javaVersion = Integer.parseInt(System.getProperty("java.version.number"));
			
			// open the dictionary file
			BufferedReader br = new BufferedReader(dictFileReader);
			// get a line at a time
			while ((classToLoad=br.readLine())!=null)
			{
				try
				{
					// Mauve CORBA related tests have been removed from all Java releases 
					if ( classToLoad.startsWith("org.omg") ) {
						continue; 
					}
					
					if (javaVersion >= 11) {
						// javax.transaction has been removed from Java 11
						if ( classToLoad.startsWith("javax.transaction") ) {
							continue;
						}
					}
					
					if (javaVersion >= 14) {
						// java.security.acl package has been removed from jdk 14
						if ( classToLoad.startsWith("java.security.acl") ) {
							continue;
						}
					}
					// use the class loader to get the Class class that represents the class on the current line
					c = Class.forName (classToLoad);
					cnt++;
					System.out.println("Loaded Class: "+classToLoad);

				}
				catch (ClassNotFoundException cnfe)
				{
					br.close();
					throw new ClassNotFoundException("Failed to find Class: " + classToLoad + cnfe);
				}

				try
				{
					// with that class, get the array of methods within it
					c.getDeclaredMethods();
				}
				catch (SecurityException se)
				{
					br.close();
					throw new SecurityException("Failed to load methods for class. SecurityException Occurred: " + classToLoad + se);
				}

				try
				{
					// with the same class, get an array of fields
					c.getDeclaredFields();
				}
				catch (SecurityException se)
				{
					br.close();
					throw new SecurityException("Failed to load fields for class: " + classToLoad + se);
				}
			}
			br.close();
			System.out.println("Class loader loaded: "+cnt+" classes ");
		}
	}
} 
