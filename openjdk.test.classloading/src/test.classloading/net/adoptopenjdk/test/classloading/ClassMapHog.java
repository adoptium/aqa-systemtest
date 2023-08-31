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
import java.lang.reflect.*;

/**
 * This testcase is the same as ClassHog but it stores all the Class/Field/Method objects that
 * the classloader provides into a hierarchically arranged HashMap tree.
 * ie
 * hmap = "java" : map-a
 *        "javax": map-b etc
 * map-a = "lang" : map-c
 *         "io" : map-d
 * etc till you get to a HashMap entry that represents an actual Class/Interface.
 * then the HashMap contains a Map of Field objects, and or a map of Class types used by each
 * method as parameters.
 * ie
 * the Map entry for "System" would contain :
 * "err" : Field object for PrintStream
 * "println" : map-x
 *
 * map-x contains :
 *
 * "param#1" : Class object for class String
 * etc etc etc
 *
 * This allows us to populate quite a large nested HashMap of real objects, from a simply derived 
 * source. It loads both the ClassLoader, the GC (as it has to GC Class types) and the HashMap 
 * implementation (and the GC of all the objects put into the HashMaps!).
 *         
 */
public class ClassMapHog 
{
	private long objCount=0;
	private static int ccnt;
	private static int mcnt;
	private boolean serialize=false;

	private HashMap<Object, HashMap<Object, Object>> hmap = new HashMap<Object, HashMap<Object, Object>>();
	
	int loopCount = 2;
	String parmlist = "dict:class.dict";

	@SuppressWarnings("unchecked") // to get around us not knowing how to do type checks on a file
	public void run () throws IOException, ClassNotFoundException
	{
		String dictFileName = "class.dict";

		// do we want to use serialization ?
		serialize = (parmlist.toLowerCase().indexOf("serialize") != -1) ? true : false;

			for (int i=0;i<loopCount;i++)
			{
				// Clear the top level Map to orphan the Map objects from previous iterations of the test loop.
				// We don't want to run out of memory and do want the garbage collector to get some exercise!
				hmap.clear();

				String classToLoad = null;
				Class<?> c=null;
				Map<Object, Object> cmapentry=null;

				//locate the dictionary
				int indx = parmlist.toLowerCase().indexOf("dict:");
				if (indx != -1) {
					String tmps = parmlist.substring(indx + 5);
					StringTokenizer tk = new StringTokenizer (tmps, " ");
					dictFileName = tk.nextToken(); 
				}
				
				ClassLoader classLoader = getClass().getClassLoader();
				FileReader dictFileReader = new FileReader(classLoader.getResource("net/adoptopenjdk/test/classloading/" + dictFileName).getFile());
				int javaVersion = Integer.parseInt(System.getProperty("java.version.number"));

				// open the dictionary
				BufferedReader br = new BufferedReader (dictFileReader);

				// read a class line at a time
				while ((classToLoad=br.readLine())!=null)
				{
					try
					{
						// Mauve CORBA related tests have been removed from all Java releases 
						if (classToLoad.startsWith("org.omg") ) {
							continue; 
						}
						if (javaVersion >= 11) {
							// javax.transaction and CORBA has been removed from Java 11
							if (classToLoad.startsWith("javax.transaction") ) {
								continue;
							}
						}
						
						if (javaVersion >= 14) {
							// java.security.acl package has been removed from jdk 14
							if (classToLoad.startsWith("java.security.acl") ) {
								continue;
							}
						}
						
						if (javaVersion >= 17) {
							// The RMI Activation mechanism has been deprecated from jdk 17
							if (classToLoad.startsWith("java.rmi.activation") ) {
								continue;
							}
						}

						if (javaVersion >= 21) {
							// The java.lang.Compiler class has been removed from jdk 21
							if (classToLoad.startsWith("java.lang.Compiler") ) {
								continue;
							}
						}
						// get the class loader to load the current class
						// Class is the class that represents a classes 'blueprint'
						c = Class.forName (classToLoad);
						// put the Class object into the current map
						cmapentry = addClass (classToLoad, c);
						ccnt++;
						System.out.println("Loaded Class: "+classToLoad);
					}
					catch (ClassNotFoundException cnfe)
					{
						br.close();
						throw new ClassNotFoundException("Failed to load Class: " + classToLoad + cnfe);
					}

					try
					{
						// get an array of the methods in current class
						Method[] methods = c.getDeclaredMethods ();
						for (int m=0;m<methods.length;m++)
						{
							// for each method create a 'method' map
							Map<Object, Object> mmap = new HashMap<Object, Object>();
							Class<?>[] paramtypes = methods[m].getParameterTypes();
							for (int a=0;a<paramtypes.length;a++)
							{
								// add each parameter type to the current method map
								mmap.put("param#"+a,mapClass(paramtypes[a]));
							}
							mcnt++;
							// add the current method map to the current class map
							cmapentry.put (methods[m].getName(), mmap);
						}
					}
					catch (SecurityException se)
					{
						br.close();
						throw new SecurityException("Failed to load methods for class: " + classToLoad + se);
					}

					try
					{
						Field [] fields = c.getDeclaredFields ();
						for (int f=0;f<fields.length;f++)
						{
							cmapentry.put (fields[f].toString(), mapClass(fields[f].getClass()));
							mcnt++;
						}
					}
					catch (java.lang.SecurityException se)
					{
						br.close();
						throw new SecurityException("Failed to load fields for class: " + classToLoad + se);
					}
				}
				//dump(hmap,"");

				
				if (serialize)
				{
					// write them out ...
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("test.out")));
					oos.writeObject (hmap);
					oos.flush();
					oos.close();
					// and ...
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("test.out")));
					
					hmap=(HashMap<Object, HashMap<Object, Object>>) ois.readObject();
					ois.close();
				}
				br.close();
			}
			System.out.println("Class loader loaded: " + ccnt + " classes. Mapped: " + mcnt + " classes/methods/fields");
	}

	private Object mapClass (Class<?> c)
	{
		String cname = c.getName();
		Object o=null;
		if (cname.equals("boolean")) o = new Boolean (false);
		else if (cname.equals("byte")) o = new Byte ((byte)0);
		else if (cname.equals("char")) o = new Character ((char)0);
		else if (cname.equals("short")) o = new Short ((short)0);
		else if (cname.equals("int")) o = new Integer ((int)0);
		else if (cname.equals("long")) o = new Long (0L);
		else if (cname.equals("float")) o = new Float (0.0);
		else if (cname.equals("double")) o = new Double (0.0);
		else o = c;

		return o;
	}

	public Map<Object, Object> addClass (String name, Class<?> c)
	{
		String s;
		StringTokenizer st = new StringTokenizer (name, ".");
		// map starts off as the top level map ("java","javax" etc)
		HashMap<Object, HashMap<Object, Object>> map = hmap;
		HashMap<Object, Object> returnMap = null;
		while (st.hasMoreTokens())
		{
			// tokenize the classname ie  ("java","lang","String")
			s = st.nextToken ();
			// do we have a node for the current token?
			HashMap<Object, Object> m = (HashMap<Object, Object>) map.get(s);
			if (m == null)
			{
				HashMap<Object, Object> newMap = new HashMap<Object, Object>();
				map.put(s,newMap);
				returnMap = newMap;
			}
			else
			{
				returnMap = m;
			}
		}
		return returnMap;
	}

	/**
	 * dump - utility function written to prove that everything really was stored where we thought it was
	 */
	@SuppressWarnings("unchecked")
	void dump (Map<Object, Object> m, String prefix)
	{
		Object key=null;
		Iterator<?> i = m.keySet().iterator();
		while (i.hasNext())
		{
			key = i.next();
			Map<Object, Object> entry = (Map<Object, Object>) m.get(key);
			if (entry instanceof Map) {
				dump((Map<Object, Object>)entry,prefix+"."+key.toString());
			} else
				System.out.println(prefix.toString()+":"+entry.toString());
		}
	}
	
	
	long checkMap(Map<Object, Object> m)
	{
		objCount = 0;
		traverse(m);
		return objCount;
	}

	// a recursive method that counts the number of map entries
	@SuppressWarnings("unchecked")
	private void traverse (Map<Object, Object> m)
	{
		Object key=null;
		Iterator<?> i = m.keySet().iterator();
		while (i.hasNext())
		{
			key = i.next();
			Object entry = m.get(key);
			if (entry instanceof Map)
				traverse((Map<Object, Object>)entry);
			else
				objCount++;
		}
	}
}
