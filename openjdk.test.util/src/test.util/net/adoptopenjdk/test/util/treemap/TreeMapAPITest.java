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
 * File:    TreeMapAPITest.java
 * Package: net.adoptopenjdk.test.util.treemap
 */
   
package net.adoptopenjdk.test.util.treemap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Vector;

import junit.framework.TestCase;

/**
 * This tests execises the functions available in the
 * TreeMap API (Java 5)
 */
public class TreeMapAPITest extends TestCase {
	
	public void setUp()
	{
		
	}
	
	/***
	 * Tests creating TreeMaps with the Comparator constructor
	 */
	public void testComparatorConstructor()
	{
		// create a TreeMap with the custom comparator
		TreeMapKeyComparator comparator = new TreeMapKeyComparator();
		TreeMap<TreeMapKey,Object> tree = new TreeMap<TreeMapKey,Object>(comparator);
		
		// populate tree
		TreeMapFactory.populateTreeWithKey(tree, TreeMapFactory.SIZE);
		assertEquals(tree.size(), TreeMapFactory.SIZE);
		
		// check that they're in the correct order now
		checkOrderedTMK(tree);
		
		// change the comparator to order the other way
		comparator.reverse();
		
		// check it's ordered correctly
		checkOrderedTMK(tree);
	}
	
	/***
	 * Tests creating TreeMaps with the Map constructor
	 */
	public void testMapConstructor()
	{
		// create a hashmap
		HashMap<Integer,Object> hashmap1 = new HashMap<Integer,Object>();
		for (int i=(TreeMapFactory.SIZE / 2) - 1; i>=0; i--)
		{
			hashmap1.put(new Integer(i), new Object());
		}
		
		// create a TreeMap from the map
		TreeMap<Integer,Object> tree1 = new TreeMap<Integer,Object>(hashmap1);
		
		assertEquals(tree1.size(), TreeMapFactory.SIZE/2);
		
		checkOrdered(tree1);
		
		/* add some new elements to the HashMap and TreeMap
		 * should now contain all numbers 0..TreeMapFactory.SIZE
		 */
		for (int i=TreeMapFactory.SIZE / 2; i<TreeMapFactory.SIZE; i++)
		{
			hashmap1.put(new Integer(i), new Object());
			tree1.put(new Integer(i), new Object());
		}
		
		// and remove some entries - remove every element mod 5
		for (int i=0; i<TreeMapFactory.SIZE; i=i+5)
		{
			hashmap1.remove(new Integer(i));
			tree1.remove(new Integer(i));
		}
		
		// check the expected values are in the TreeMap
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			Integer tempInteger = new Integer(i);
			// check that the hashmap and tree contain the same
			String message = hashmap1.containsKey(tempInteger) ? 
					"Hashmap contains key " + i + " but TreeMap doesn't": 
					"Hashmap doesn't contain key " + i + " but TreeMap does";
			assertEquals(message, hashmap1.containsKey(tempInteger), tree1.containsKey(tempInteger));
			if (i % 5 == 0)
			{
				assertFalse("Tree doesn't contain key " + i, tree1.containsKey(tempInteger));
			}
			else
			{
				assertTrue("Tree shouldn't contain key " + i, tree1.containsKey(tempInteger));
			}
		}
		
		// and that it's still ordered
		checkOrdered(tree1);
		
		// error checking - put a null in the Map
		hashmap1 = new HashMap<Integer,Object>();
		hashmap1.put(new Integer(0), new Object());
		hashmap1.put(new Integer(2), new Object());
		hashmap1.put(null, new Object());
		hashmap1.put(new Integer(1), new Object());
		try
		{
			tree1 = new TreeMap<Integer,Object>(hashmap1);
			fail("Attempt to create TreeMap with a HashMap containing a null key should throw a NullPointerException");
		} catch (NullPointerException e)
		{
			// correct behaviour
		}
		
		// create a map where the keys don't implement Comparable
		HashMap<Object,Object> hashmap2 = new HashMap<Object,Object>();
		hashmap2.put(new Object(), new Object());
		hashmap2.put(new Object(), new Object());

		try
		{
			new TreeMap<Object,Object>(hashmap2);
			fail("Attempt to create TreeMap with keys that don't implement Comparable should throw ClassCastException");
		} catch (ClassCastException e)
		{
			// correct behaviour
		}
	}
	
	public void testClone()
	{
		// create a TreeMap
		TreeMap<Integer,Object> treemap = new TreeMap<Integer,Object>();
		
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			treemap.put(new Integer(i), new MapObject(i));
		}
		
		// clone it
		@SuppressWarnings("unchecked")
		TreeMap<Integer, Object> treemap_clone = (TreeMap<Integer, Object>)treemap.clone();
		
		// test equal
		assertEquals("Cloned array is not equal to original", treemap, treemap_clone);
		
		// test shallow equality by changing some of the object properties
		for (int i=0; i<TreeMapFactory.SIZE; i=i+10)
		{
			((MapObject)treemap.get(new Integer(i))).value += 10;
		}
		assertEquals("Treemaps should contain the same keys", treemap.keySet(), treemap_clone.keySet());
		assertEquals("TreeMaps not shallowly equal", treemap, treemap_clone);
	}

	public void testComparator()
	{
		// create a TreeMap
		TreeMap<TreeMapKey,Object> tree = TreeMapFactory.getTreeWithKey(TreeMapFactory.SIZE);
		
		// get comparator
		Comparator<?> c = tree.comparator();
		
		// check it's null
		assertNull("comparator() should return null as the tree is using the natural ordering of its keys", c);
		
		// create a tree with an explicit Comparator
		tree = new TreeMap<TreeMapKey,Object>(new TreeMapKeyComparator());
		TreeMapFactory.populateTreeWithKey(tree, TreeMapFactory.SIZE);
		
		// get comparator
		c = tree.comparator();
		
		// check not null
		assertNotNull("comparator() returned null when Comparator has been set", c);
	}
	
	public void testContainsKey()
	{
		// create an empty tree map
		TreeMap<TreeMapKey,Object> tree = new TreeMap<TreeMapKey,Object>();
		// look for a key
		assertFalse("Found a key in an empty tree", tree.containsKey(new TreeMapKey(2)));
		
		// create a list of ints 0..TreeMapFactory.SIZE-1 in random order
		ArrayList<Integer> intList = new ArrayList<Integer>(TreeMapFactory.SIZE);
		
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			intList.add(new Integer(i));
		}
		Collections.shuffle(intList, new Random(173417));
		
		// add keys to tree
		while (intList.size()>0)
		{
			tree.put(new TreeMapKey(((Integer)intList.remove(0)).intValue()), null);
		}
		
		// check that the tree contains all keys from 0 to TreeMapFactory.SIZE-1
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			assertTrue("Tree doesn't contain key " + i, tree.containsKey(new TreeMapKey(i)));
		}
		
		// try null key
		try
		{
			tree.containsKey(null);
			fail("Attempt to call TreeMap.containsKey with null should throw NullPointerException");
		}
		catch (NullPointerException e)
		{
			// expected behaviour
		}
	}
	
	public void testContainsValue()
	{
		TreeMap<Integer,String> tree = new TreeMap<Integer,String>();
		// look for a null value
		assertFalse("Looking for null value in an empty tree", tree.containsValue(null));
		// look for a non-null value
		assertFalse("Looking for non-null value in an empty tree", tree.containsValue(Integer.toString(10)));
		
		// put some values in the tree
		Random random = new Random(23412849);
		Integer k = null;
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			// find a key that isn't in the tree already
			do 
			{
				k = new Integer(random.nextInt());
			} while (tree.containsKey(k));
			// put a String value in the tree

			tree.put(k, Integer.toString(i));
			
		}
		
		// look for each string
		for (int i=0; i<TreeMapFactory.SIZE; i++)
		{
			assertTrue("Tree doesn't contain value " + i, tree.containsValue(Integer.toString(i)));
		}
		
		// look for one that shouldn't be there
		assertFalse("Tree contains value " + TreeMapFactory.SIZE, tree.containsValue(Integer.toString(TreeMapFactory.SIZE)));
		
		// look for a null key
		assertFalse("Looking for null value in tree that doesn't contain one", tree.containsValue(null));
		
		// put a null in the tree
		k = new Integer(random.nextInt());
		tree.put(k, null);
		assertTrue("Looking for null value in tree that contains one", tree.containsValue(null));
	}
	
	public void testEntrySet()
	{
		TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
		
		assertEquals("EntrySet of empty TreeMap isn't empty", tree.entrySet().size(), 0);
		
		// populate tree with random keys
		TreeMapFactory.populateTree(tree,TreeMapFactory.SIZE);
		
		// get the entry set
		Set<?> entrySet = tree.entrySet();
		assertEquals("EntrySet has " + entrySet.size() + " entries, expected: " + TreeMapFactory.SIZE, 
				entrySet.size(), TreeMapFactory.SIZE);
		Iterator<?> entrySetIterator = entrySet.iterator();

		Integer previous = (Integer)(((Map.Entry<?,?>)entrySetIterator.next()).getKey());
		while (entrySetIterator.hasNext())
		{
			Integer current = (Integer)(((Map.Entry<?,?>)entrySetIterator.next()).getKey());
			assertTrue("Key " + previous.toString() + " occurs before key " + current, 
					previous.compareTo(current) <= 0);
			previous = current;
		}
		
		/*
		 * we should be able to remove mappings in both the Iterator and the Set 
		 * and have them reflected in the tree
		 * reset the iterator
		 */
		entrySetIterator = entrySet.iterator();
		boolean toRemove = true;
		Vector<Object> removedKeys = new Vector<Object>();
		Vector<Object> keptEntries = new Vector<Object>();
		
		// remove some entries via Iterator.remove
		while(entrySetIterator.hasNext())
		{	
			Object entry = entrySetIterator.next();
			// alternate between removing via Iterator.remove
			if (toRemove)
			{
				removedKeys.add(((Map.Entry<?,?>)entry).getKey());
				entrySetIterator.remove();
			}
			else
			{
				keptEntries.add(entry);
			}
			toRemove = !toRemove;
		}
		
		// remove some entries via entrySet.remove
		Vector<Object> keptKeys = new Vector<Object>();
		for (int i=0; i<keptEntries.size(); i++)
		{
			Object entry = keptEntries.elementAt(i);
			if (toRemove)
			{
				removedKeys.add(((Map.Entry<?,?>)entry).getKey());
				assertTrue("Set.remove didn't remove entry " + entry, entrySet.remove(entry));
			}
			else
			{
				keptKeys.add(((Map.Entry<?,?>)entry).getKey());
			}
			toRemove = !toRemove;
		}
		
		// check removed entries aren't in tree
		for(int i=0; i<removedKeys.size(); i++)
		{
			Object key = removedKeys.elementAt(i);
			assertFalse("Check " + i + " failed: tree contains key " + key + " which was removed", 
							tree.containsKey(key));
		}
		// check other entires are still in the tree
		assertEquals(keptKeys.size(), tree.size());
		for (int i=0; i<keptKeys.size(); i++)
		{
			Object key = keptKeys.elementAt(i);
			assertTrue("Check " + i + " failed: tree doesn't contain key " + key,
					tree.containsKey(key));
		}
	}
	
	
	public void testFirstKey()
	{
		// create two random treemaps and retrieve their first keys
		TreeMap<Integer,Integer> tree1 = TreeMapFactory.getTree(TreeMapFactory.SIZE/2);
		Comparable<Integer> firstkey1 = (Comparable<Integer>)tree1.firstKey();
		
		TreeMap<Integer,Integer> tree2 = TreeMapFactory.getTree(TreeMapFactory.SIZE/2);
		Comparable<Integer> firstkey2 = (Comparable<Integer>)tree2.firstKey();
		
		// join them together and check the first key is correct
		tree1.putAll(tree2);

		if (firstkey1.compareTo((Integer)firstkey2) <= 0)
		{
			assertEquals(firstkey1, tree1.firstKey());
		}
		else
		{
			assertEquals(firstkey2, tree1.firstKey());
		}
		
		// put the smallest Integer in and see if it's the last key
		tree1.put(new Integer(Integer.MIN_VALUE), null);
		assertEquals(new Integer(Integer.MIN_VALUE), tree1.firstKey());
	}
	
	public void testLastKey()
	{
		// create two random treemaps and retrieve their last keys
		TreeMap<Integer,Integer> tree1 = TreeMapFactory.getTree(TreeMapFactory.SIZE/2);
		Comparable<Integer> lastkey1 = (Comparable<Integer>)tree1.lastKey();
		
		TreeMap<Integer,Integer> tree2 = TreeMapFactory.getTree(TreeMapFactory.SIZE/2);
		Comparable<Integer> lastkey2 = (Comparable<Integer>)tree2.lastKey();
		
		// join them together and check the last key is correct
		tree1.putAll(tree2);
		
		if (lastkey1.compareTo((Integer)lastkey2) >= 0)
		{
			assertEquals(lastkey1, tree1.lastKey());
		}
		else
		{
			assertEquals(lastkey2, tree1.lastKey());
		}
		
		// put the largest Integer in and see if it's the last key
		tree1.put(new Integer(Integer.MAX_VALUE), null);
		assertEquals(new Integer(Integer.MAX_VALUE), tree1.lastKey());
	}

	public void testHeadMap()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getTree(TreeMapFactory.SIZE);
		// should give the same map back minus the last Key
		Map<Integer,Integer> headmap = tree.headMap(tree.lastKey());
		tree.remove(tree.lastKey());
		assertEquals("tree.headmap(tree.lastKey()) is not equal to tree.remove(tree.lastKey())", 
				headmap, tree);
		
		// split map
		headmap = tree.headMap(new Integer(0));
		
		// try inserting a key greater than 0
		try
		{
			headmap.put(new Integer(1), null);
			fail("Inserting key 1 into a head map containing integers under 0, should throw" +
					"an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
		// try inserting 0
		try
		{
			headmap.put(new Integer(0), null);
			fail("Inserting key 0 into a head map containing integers under 0, should throw" +
				"an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
	}
	
	public void testKeySet()
	{
		TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
		
		assertEquals("EntrySet of empty TreeMap isn't empty", tree.keySet().size(), 0);
		
		// populate tree with random keys
		TreeMapFactory.populateTree(tree,TreeMapFactory.SIZE);
		
		// get the entry set
		Set<Integer> keySet = tree.keySet();
		assertEquals("KeySet has " + keySet.size() + " keys, expected: " + TreeMapFactory.SIZE, 
				keySet.size(), TreeMapFactory.SIZE);
		Iterator<Integer> keySetIterator = keySet.iterator();

		Integer previous = (Integer)(keySetIterator.next());
		while (keySetIterator.hasNext())
		{
			Integer current = (Integer)(keySetIterator.next());
			assertTrue("Key " + previous.toString() + " occurs before key " + current, 
					previous.compareTo(current) <= 0);
			previous = current;
		}
		
		/*
		 * we should be able to remove mappings in both the Iterator and the Set 
		 * and have them reflected in the tree
		 * reset the iterator
		 */
		keySetIterator = keySet.iterator();
		boolean toRemove = true;
		Vector<Integer> removedKeys = new Vector<Integer>();
		Vector<Integer> keptEntries = new Vector<Integer>();
		
		// remove some entries via Iterator.remove
		while(keySetIterator.hasNext())
		{	
			Integer key = (Integer)keySetIterator.next();
			// alternate between removing via Iterator.remove
			if (toRemove)
			{
				removedKeys.add(key);
				keySetIterator.remove();
			}
			else
			{
				keptEntries.add(key);
			}
			toRemove = !toRemove;
		}
		
		// remove some entries via entrySet.remove
		Vector<Integer> keptKeys = new Vector<Integer>();
		for (int i=0; i<keptEntries.size(); i++)
		{
			Integer key = (Integer) keptEntries.elementAt(i);
			if (toRemove)
			{
				removedKeys.add(key);
				assertTrue("Set.remove didn't remove entry " + key, keySet.remove(key));
			}
			else
			{
				keptKeys.add(key);
			}
			toRemove = !toRemove;
		}
		
		// check removed entries aren't in tree
		for(int i=0; i<removedKeys.size(); i++)
		{
			Object key = removedKeys.elementAt(i);
			assertFalse("Check " + i + " failed: tree contains key " + key + " which was removed", 
							tree.containsKey(key));
		}
		// check other entires are still in the tree
		assertEquals(keptKeys.size(), tree.size());
		for (int i=0; i<keptKeys.size(); i++)
		{
			Object key = keptKeys.elementAt(i);
			assertTrue("Check " + i + " failed: tree doesn't contain key " + key,
					tree.containsKey(key));
		}
	}
	
	public void testGetPutRemove()
	{
		TreeMap<Integer,Integer> tree1 = TreeMapFactory.getTree(TreeMapFactory.SIZE);
		
		try
		{
			tree1.put(null,null);
			fail("Attempt to put null in tree should throw NullPointerException");
		} catch(NullPointerException e)
		{
			// expected behaviour
		}
		
		TreeMap<Integer,String> tree2 = new TreeMap<Integer,String>();
		// test overwriting the same key
		String[] values = {"zero", "one", "two", "three", "four", 
				"five", "six", "seven", "eight", "nine"};
		int[] keys = {0, 1231, -5423980, 13434, 8537, 18394, -849580, 923842, 93, 234890};
		for (int i=0; i<keys.length; i++)
		{
			for (int j=0; j<values.length; j++)
			{
				tree2.put(new Integer(keys[i]), values[j]);
			}
		}
		for (int i=0; i<keys.length; i++)
		{
			assertEquals("Key " + keys[i] + " is not mapped to expected value", 
					tree2.get(keys[i]), values[values.length-1]);
		}
		
		// create a HashMap with the same mappings
		HashMap<Integer,String> hashmap2 = new HashMap<Integer,String>(tree2);
		
		// make some changes to both
		Iterator<Integer> keysetIterator = tree2.keySet().iterator();
		int frequency = 0;
		while (keysetIterator.hasNext())
		{
			Integer key = keysetIterator.next();
			
			if (frequency % 10 == 0)
			{
				// remove the entry
				hashmap2.remove(key);
				// remove via the iterator otherwise will get a ConcurrentModificationException
				keysetIterator.remove(); 
			}
			else if (frequency % 4 == 1)
			{
				// swap some values around
				if (!keysetIterator.hasNext()) break;
				Integer key2 = keysetIterator.next();
				// do the same swap in the hashmap and tree
				String temp = hashmap2.get(key);
				hashmap2.put(key, hashmap2.get(key2));
				hashmap2.put(key2, temp);
			
				temp = tree2.get(key);
				tree2.put(key, tree2.get(key2));
				tree2.put(key2, temp);
			}
			else if (frequency % 10 == 3)
			{
				// reassociate that key to a different value
				hashmap2.put(key, null);
				tree2.put(key, null);
			}
			frequency++;
		}
		
		// add some extra entries
		Random random = new Random(1438908);
		for (int i=0; i<TreeMapFactory.SIZE/2; i++)
		{
			Integer key = new Integer(random.nextInt());
			hashmap2.put(key, null);
			tree2.put(key, null);
		}
		
		// check the tree's still ordered
		checkOrdered(tree2);
		// check they've the same mappings
		assertEquals("HashMap and TreeMap differ after swappings", hashmap2, tree2);
		
	}
	
	public void testPutAll()
	{
		TreeMap<Integer,Integer> treemap = TreeMapFactory.getTree(TreeMapFactory.SIZE);
		// create a hashmap
		Random random = new Random(7987);
		HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
		int unique = 0;
		while (hashmap.size() <= TreeMapFactory.SIZE)
		{
			Integer key = new Integer(random.nextInt());
			hashmap.put(key, null);
			if (!treemap.containsKey(key))
			{
				unique++;
			}
		}
		// put all entries in the tree
		treemap.putAll(hashmap);
		checkOrdered(treemap);
		// size of tree should be TreeMapFactory.SIZE + unique
		assertEquals(treemap.size(), TreeMapFactory.SIZE + unique);
	}
	
	public void testSubMap()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getTree(TreeMapFactory.SIZE);
		// should give the same map back minus the last Key
		Map<Integer,Integer> submap = tree.subMap(tree.firstKey(), tree.lastKey());
		tree.remove(tree.firstKey());
		tree.remove(tree.lastKey());
		assertEquals("tree.submap(tree.firstKey, tree.lastKey()) is not equal to tree.remove(tree.firstKey());tree.remove(tree.lastKey())", 
				submap, tree);
		
		// split map
		submap = tree.subMap(tree.firstKey(), new Integer(0));
		
		// try inserting a key greater than 0
		try
		{
			submap.put(new Integer(1), null);
			fail("Inserting key 1 into a head map containing integers under 0, should throw" +
					" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
		// try inserting 0
		try
		{
			submap.put(new Integer(0), null);
			fail("Inserting key 0 into a sub map containing integers under 0, should throw" +
				" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
		
		// split the other way
		submap = tree.subMap(new Integer(1), tree.lastKey());
		
		// try inserting a key greater than 0
		try
		{
			submap.put(new Integer(-1), null);
			fail("Inserting key -1 into a head map containing integers over 0, should throw" +
					" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
		// try inserting 0
		try
		{
			submap.put(new Integer(0), null);
			fail("Inserting key 0 into a sub map containing integers over 0, should throw" +
				" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
	}
	
	public void testTailMap()
	{
		TreeMap<Integer,Integer> tree = TreeMapFactory.getTree(TreeMapFactory.SIZE);
		// should give the same map back minus the first Key
		Map<Integer,Integer> tailmap = tree.tailMap(tree.firstKey());
		tree.remove(tree.firstKey());
		assertEquals("tree.tailmap(tree.firstKey()) is not equal to tree.remove(tree.lastKey())", 
				tailmap, tree);
		
		// split map
		tailmap = tree.tailMap(new Integer(1));
		
		// try inserting a key less than 0
		try
		{
			tailmap.put(new Integer(-1), null);
			fail("Inserting key -1 into a tail map containing integers over 0, should throw" +
					" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
		// try inserting 0
		try
		{
			tailmap.put(new Integer(0), null);
			fail("Inserting key 0 into a tail map containing integers over 0, should throw" +
				" an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected behaviour
		}
	}
	
	private void checkOrdered(SortedMap<Integer,?> tree)
	{
		Iterator<Integer> iterator = tree.keySet().iterator();
		if (!iterator.hasNext())
		{
			return;
		}
		
		Integer previous = (Integer)iterator.next();
		while (iterator.hasNext())
		{
			Integer current = (Integer)iterator.next();
			assertTrue("key " + previous + " occurs before key " + current + " in TreeMap", 
					current.compareTo(previous) >= 0);
			previous = current;
		}
	}
	
	private void checkOrderedTMK(SortedMap<TreeMapKey,?> tree)
	{
		Iterator<TreeMapKey> iterator = tree.keySet().iterator();
		if (!iterator.hasNext())
		{
			return;
		}
		
		TreeMapKey previous = (TreeMapKey)iterator.next();
		while (iterator.hasNext())
		{
			TreeMapKey current = (TreeMapKey)iterator.next();
			assertTrue("key " + previous + " occurs before key " + current + " in TreeMap", 
					current.compareTo(previous) >= 0);
			previous = current;
		}
	}
	
	/**
	 * Test object for putting in TreeMaps
	 */
	class MapObject
	{
		public int value;
		
		public MapObject(int value)
		{
			this.value = value;
		}
	}
}
