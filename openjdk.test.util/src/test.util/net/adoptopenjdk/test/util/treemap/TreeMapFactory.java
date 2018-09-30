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
 * File:    TreeMapFactory.java
 * Package: net.adoptopenjdk.test.util.treemap
 */
   
package net.adoptopenjdk.test.util.treemap;

import java.util.Collections;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Helper class to create TreeMap objects and return long running TreeMap objects
 */
public class TreeMapFactory {
	
	public static final int SIZE = 1000;
	private static final long seed = 123456789;
	private static Random randomGenerator;
	private static Vector<SortedMap<Integer,Integer>> sortedMapPool;
	private static Vector<TreeMap<Integer,Integer>> treeMapPool;
	private static final int sortedMapPoolSize = 20;
	private static final int treeMapPoolSize = 20;
	private static int sortedMapPoolIndex = 0;
	private static int treeMapPoolIndex = 0;
	
	// static initializer
	static
	{
		// create a Random object with a seed
		randomGenerator = new Random(seed);
		
		treeMapPool = new Vector<TreeMap<Integer,Integer>>(treeMapPoolSize);
		for (int i=0; i<treeMapPoolSize; i++)
		{
			treeMapPool.add(getTree(SIZE));
		}
		
		// create some treemaps synchronized using Collections.synchronizedSortedMap
		sortedMapPool = new Vector<SortedMap<Integer,Integer>>(sortedMapPoolSize);
		for (int i=0; i<sortedMapPoolSize; i++)
		{
			SortedMap<Integer,Integer> tree = Collections.synchronizedSortedMap(new TreeMap<Integer,Integer>());
			populateTree(tree, SIZE);
			sortedMapPool.add(tree);
		}
	}

	public static TreeMap<Integer,Integer> getTree()
	{
		return getTree(SIZE);
	}
	
	public static TreeMap<Integer,Integer> getTree(int size)
	{
		return getRandomTree(size);
	}
	
	public static TreeMap<Integer,Integer> getRandomTree(int size)
	{
		TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
		populateTree(tree, size);
		return tree;
	}

	public static TreeMap<TreeMapKey,Object> getTreeWithKey(int size) {
		TreeMap<TreeMapKey,Object> tree = new TreeMap<TreeMapKey,Object>();
		populateTreeWithKey(tree, size);
		return tree;
	}

	public static void populateTree(SortedMap<Integer,Integer> tree, int size) {
		while (tree.size() < size)
		{
			tree.put(new Integer(randomGenerator.nextInt()), new Integer(tree.size()));
		}
	}
	
	public static void populateTreeWithKey(TreeMap<TreeMapKey,Object> tree, int size) {
		while (tree.size() < size)
		{
			tree.put(new TreeMapKey(randomGenerator.nextInt()), new Object());
		}
	}

	// returns a SortedMap object from the pool - not synchronized
	public static SortedMap<Integer,Integer> getGlobalSynchronizedMap() {
		SortedMap<Integer,Integer> map = (SortedMap<Integer,Integer>)sortedMapPool.elementAt(sortedMapPoolIndex);
		sortedMapPoolIndex=(sortedMapPoolIndex+1)%sortedMapPool.size();
		return map;
	}
	
	// returns a TreeMap from the pool - not synchronized
	public static TreeMap<Integer,Integer> getStaticTreeMap() {
		TreeMap<Integer,Integer> map = (TreeMap<Integer,Integer>)treeMapPool.elementAt(treeMapPoolIndex);
		treeMapPoolIndex=(treeMapPoolIndex)%treeMapPool.size();
		return map;
	}
	

}
