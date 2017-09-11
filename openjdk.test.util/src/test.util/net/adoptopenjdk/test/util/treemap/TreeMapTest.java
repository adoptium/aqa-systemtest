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
/**
 * File:    TreeMapTest.java
 * Package: net.adoptopenjdk.test.util.treemap
 */
   
package net.adoptopenjdk.test.util.treemap;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import junit.framework.TestCase;

/*
 * More stressful testing of TreeMap class
 * Performs tests on local TreeMap objects and static ones
 */

public class TreeMapTest extends TestCase {
	
	public void testLocalTreeMap()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getTree();
		stressMapChecked(tree);
		checkOrdered(tree);
	}
	
	public void testGlobalSynchronizedMap()
	{
		SortedMap<Integer,Integer> tree = TreeMapFactory.getGlobalSynchronizedMap();
		stressMapUnChecked(tree);
		synchronized(tree)
		{
			checkOrdered(tree);
		}
	}
	
	public void testGlobalSynchronizedMapChecked()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getStaticTreeMap();
		// lock on the tree
		synchronized(tree)
		{
			stressMapChecked(tree);
			checkOrdered(tree);
		}
	}
	
	public void testGlobalTreeMap()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getStaticTreeMap();
		
		synchronized(tree)
		{
			stressMapUnChecked(tree);
			checkOrdered(tree);
		}
	}
	
	/*
	 * Perform some stressful operations on the SortedMap
	 * Doesn't handle synchronization
	 */
	public void stressMapChecked(SortedMap<Integer,Integer> map)
	{
		// get the keys, remove every odd element, and re-add it
		Set<Integer> keyset = map.keySet();
		Object[] keys = keyset.toArray();
		// remove every odd element
		for (int i=1; i<keys.length; i=i+2)
		{
			map.remove(keys[i]);
		}
		assertEquals((keys.length+1)/2, map.size());
		
		// re-add every odd element
		for (int i=0; i<keys.length; i++)
		{
			map.put((Integer)keys[i], null);
		}
		// just check that we have the same number of keys
		assertEquals(map.size(), keys.length);
	}
	
	/*
	 * Perform some stressful operations on the SortedMap
	 * without checking anything
	 * Handles synchronization
	 */
	public void stressMapUnChecked(SortedMap<Integer,Integer> map)
	{
		// get the keys, remove every odd element and re-add it
		Object[] keys;
		synchronized(map)
		{
			keys = map.keySet().toArray();
		}
		// remove every odd element
		for (int i=1; i<keys.length; i=i+2)
		{
			map.remove(keys[i]);
		}
		
		// re-add every odd element
		for (int i=0; i<keys.length; i++)
		{
			map.put((Integer)keys[i], null);
		}
	}
	
	// Doesn't handle synchronization
	private void checkOrdered(SortedMap<Integer,Integer> tree)
	{
		Iterator<Integer> iterator = tree.keySet().iterator();
		if (!iterator.hasNext())
		{
			return;
		}
		Comparable<Integer> previous = (Comparable<Integer>)iterator.next();
		while (iterator.hasNext())
		{
			Comparable<Integer> current = (Comparable<Integer>)iterator.next();
			assertTrue("key " + previous + " occurs before key " + current + " in TreeMap", 
					current.compareTo((Integer)previous) >= 0);
			previous = current;
		}
	}
}
