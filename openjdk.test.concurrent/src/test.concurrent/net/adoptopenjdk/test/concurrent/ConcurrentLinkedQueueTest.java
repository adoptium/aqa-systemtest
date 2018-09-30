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
 * File:    ConcurrentLinkedQueueTest
 * Package: net.adoptopenjdk.test.concurrent.atomic
 */

package net.adoptopenjdk.test.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.adoptopenjdk.test.concurrent.support.GenericTestObject;

/**
 * ConcurrentLinkedQueueTest
 * =========================
 * 
 * Attempts to verify the correct function of the ConcurrentLinkedQueue class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using a non-shared instance of of ConcurrentLinkedQueue
 * 						-	API calls checked with assertions where possible - there are a number that can't be chekced though as listed below
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared class instance of ConcurrentHashMap
 * 							NOTE : This shared instance is separate to the instance used in testAPI()
 * 						-	API calls are not checked
 * 						-	Attempting to provoke a JIT response through repeated calls of the various API calls
 * 
 * This testcase makes use of class variables i.e. variables declared as 'static'. Usually this is a definite no-no
 * when it comes to tests run under a multithreaded stress testing engine. However, testing of many of the classes
 * in the java.util.concurrent package necessarily involves multiple threads accessing and modifying the same single data source.
 * This testcase was therefore designed to be run multiple times concurrently in such a way that threads do not interfere with
 * each other and cause incorrect results. Unfortunately this also means that some parts of the API could not be validated e.g.
 * clear(), drainTo() and similar methods which drastically modify the whole of the data source under test. Where an API call could
 * not be verified, it is at least run as part of the testStress() method wherever possible.
 */

public class ConcurrentLinkedQueueTest extends ConcurrentTest
{

	// queue is *not* defined as static. This is because we need to check that queue.poll() returns the correct 
	// value for the head element and we can't guarantee this if the queue is shared across multiple threads
	private ConcurrentLinkedQueue<GenericTestObject> queue = new ConcurrentLinkedQueue<GenericTestObject>();

	// stressqueue is our method of testing concurrent access to a single instance of ConcurrentLinkedQueue
	private static ConcurrentLinkedQueue<GenericTestObject> stressqueue = new ConcurrentLinkedQueue<GenericTestObject>();

	/**
	 * Verify the correct behaviour of the API for ConcurrentLinkedQueue. Attempts to cover as much of the API
	 * as is possible and to verify the correct function by way of checked assertions. 
	 */
	public void testAPI()
	{
		// Some generic objects for use in the API calls
		GenericTestObject object = makeNewTestObject();
		GenericTestObject object2 =  makeNewTestObject();
		GenericTestObject object3 =  makeNewTestObject();
		ArrayList<GenericTestObject> allObjects = new ArrayList<GenericTestObject>();
		allObjects.add(object);
		allObjects.add(object2);
		allObjects.add(object3);

		// =================================================================================
		// Basic API calls on an empty, locally scoped queue i.e. not shared across threads
		assertEquals("1 : isEmpty()", true, queue.isEmpty());
		assertEquals("2 : size()", 0, queue.size());
		assertEquals("3 : peek()", null, queue.peek());
		assertEquals("4 : poll()", null, queue.poll());
		assertEquals("5 : remove()", false, queue.remove(object));
		assertEquals("6 : removeAll()", false, queue.removeAll(allObjects));
		assertEquals("7 : retainAll()", false, queue.retainAll(allObjects));

		try
		{
			queue.element();			
			fail("8 : element() : Should have thrown NoSuchElementException");
		}
		catch(NoSuchElementException e)
		{
			// expected
		}

		try
		{
			queue.remove();
			fail("9 : remove() : Should have thrown NoSuchElementException");
		}
		catch(NoSuchElementException e)
		{
			// expected
		}

		try
		{
			queue.addAll(null);
			fail("10 : addAll() : Should have thrown a NullPointerException");
		}
		catch(NullPointerException e)
		{
			// expected
		}

		try
		{
			queue.addAll(queue);
			fail("11 : addAll() : Should have thrown an IllegalArgumentException");
		}
		catch(IllegalArgumentException e)
		{
			// expected
		}

		// =================================================================================
		// Adding elements into the queue and verifying contents

		assertEquals("10 : contains()", false, queue.contains(object));
		assertEquals("11 : add()", true, queue.add(object));
		assertEquals("12 : contains()", true, queue.contains(object));
		assertEquals("13 : remove()", true, queue.remove(object));
		assertEquals("14 : remove()", false, queue.remove(object));
		assertEquals("15 : contains()", false, queue.contains(object));
		assertEquals("16 : offer()", true, queue.offer(object));
		assertEquals("17 : offer()", true, queue.offer(object));
		assertEquals("18 : contains()", true, queue.contains(object));
		assertEquals("19 : remove()", true, queue.remove(object));
		assertEquals("20 : contains()", true, queue.contains(object));
		assertEquals("21 : remove()", true, queue.remove(object));
		assertEquals("22 : contains()", false, queue.contains(object));
		assertEquals("23 : add()", true, queue.add(object));
		assertEquals("24 : add()", true, queue.add(object2));
		assertEquals("25 : addAll()", true, queue.addAll(allObjects));
		assertEquals("26 : containsAll()", true, queue.containsAll(allObjects));
		assertEquals("27 : removeAll()", true, queue.removeAll(allObjects));
		assertEquals("28 : containsAll()", false, queue.containsAll(allObjects));

		// =================================================================================
		// More API calls and sequences of actions

		assertEquals("29 : addAll()", true, queue.addAll(allObjects));
		assertEquals("30 : peek()", object, queue.peek());
		assertEquals("31 : poll()", queue.peek(), queue.poll());
		assertEquals("32 : poll()", object2, queue.poll());
		assertEquals("33 : containsAll()", false, queue.containsAll(allObjects));
		assertEquals("34 : element()", object3, queue.element());
		assertEquals("35 : element()", queue.peek(), queue.element());
		assertEquals("36 : poll()", object3, queue.poll());
		assertEquals("37 : poll()", null, queue.poll());
		assertEquals("38 : size()", 0, queue.size());
		assertEquals("39 : toString()", "[]", queue.toString());
		assertEquals("40 : toArray()", new Object[0].length, queue.toArray().length);
		assertEquals("41 : toArray()", new String[10].length, queue.toArray(new String[10]).length);

		ArrayList<GenericTestObject> objects = new ArrayList<GenericTestObject>();
		for(int i = 0; i < 10; i++)
		{
			queue.add(object);
			objects.add(object);
		}

		assertEquals("42 : contains()", true, queue.contains(object));
		assertEquals("43 : containsAll()", true, queue.containsAll(objects));
		assertEquals("44 : remove()", true, queue.remove(object));
		assertEquals("45 : contains()", true, queue.contains(object));
		assertEquals("46 : containsAll()", true, queue.containsAll(objects));
		assertEquals("47 : add()", true, queue.add(object2));
		assertEquals("48 : removeAll()", true, queue.removeAll(objects));
		assertEquals("49 : contains()", false, queue.contains(object));
		assertEquals("50 : containsAll()", false, queue.containsAll(objects));
		assertEquals("51 : contains()", true, queue.contains(object2));
		assertEquals("52 : addAll()", true, queue.addAll(objects));
		int previousSize = queue.size();
		assertEquals("53 : retainAll()", false, queue.retainAll(allObjects));
		assertEquals("54 : size()", previousSize, queue.size());
		assertEquals("55 : retainAll()", true, queue.retainAll(objects));
		assertEquals("56 : size()", previousSize - 1, queue.size());
		assertEquals("57 : contains()", false, queue.contains(object2));


		// Tidy up after ourselves
		while(queue.size() != 0)
		{
			queue.poll();
		}

	}

	/**
	 * Makes use of stressqueue to test multiple threads concurrent accessing and updating a single shared
	 * instance of ConcurrentLinkedQueue. Makes repeated API calls. The API calls
	 * are not checked for correct behaviour as this would be difficult in a multithreaded environment. Instead this
	 * method is aiming to call various API methods as much as possible in an effort to trigger a JIT response.
	 */
	public void testStress()
	{

		ArrayList<GenericTestObject> items = new ArrayList<GenericTestObject>();

		// make sure we have some items to work with
		while(stressqueue.size() < 100)
		{
			stressqueue.offer(makeNewTestObject());
		}

		// make sure we don't gobble all of the memory
		while(stressqueue.size() > 200)
		{
			stressqueue.poll();
		}

		// =================================================================================
		// Testing starts here
		
		try
		{
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.retainAll(items);
			stressqueue.remove(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.offer(makeNewTestObject());
			Iterator<GenericTestObject> itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.add(makeNewTestObject());
			items.clear();
			stressqueue.isEmpty();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.poll();
			stressqueue.offer(makeNewTestObject());
			stressqueue.offer(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.toArray(new GenericTestObject[10]);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.add(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.size();
			stressqueue.add(makeNewTestObject());
			stressqueue.poll();
			items.clear();
			stressqueue.containsAll(items);
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.element();
			stressqueue.retainAll(items);
			stressqueue.peek();
			items.clear();
			stressqueue.removeAll(items);
			stressqueue.containsAll(items);
			stressqueue.peek();
			items.clear();
			stressqueue.size();
			stressqueue.remove(makeNewTestObject());
			stressqueue.containsAll(items);
			stressqueue.containsAll(items);
			stressqueue.peek();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.remove();
			stressqueue.element();
			stressqueue.offer(makeNewTestObject());
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.remove();
			stressqueue.element();
			stressqueue.size();
			stressqueue.isEmpty();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.removeAll(items);
			stressqueue.retainAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.removeAll(items);
			stressqueue.size();
			items.clear();
			stressqueue.size();
			stressqueue.isEmpty();
			stressqueue.toArray();
			stressqueue.removeAll(items);
			items.clear();
			stressqueue.toArray();
			stressqueue.containsAll(items);
			items.clear();
			stressqueue.add(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.toString();
			stressqueue.remove();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.removeAll(items);
			stressqueue.offer(makeNewTestObject());
			items.clear();
			stressqueue.offer(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.toArray(new GenericTestObject[10]);
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.remove(makeNewTestObject());
			stressqueue.element();
			stressqueue.removeAll(items);
			stressqueue.peek();
			stressqueue.containsAll(items);
			stressqueue.toArray();
			stressqueue.remove(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.isEmpty();
			stressqueue.toString();
			stressqueue.retainAll(items);
			items.clear();
			stressqueue.peek();
			stressqueue.toArray();
			stressqueue.toString();
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.toArray();
			stressqueue.offer(makeNewTestObject());
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.remove(makeNewTestObject());
			stressqueue.size();
			stressqueue.add(makeNewTestObject());
			stressqueue.removeAll(items);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.toString();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.toArray(new GenericTestObject[10]);
			items.clear();
			stressqueue.removeAll(items);
			items.clear();
			stressqueue.element();
			stressqueue.remove();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.retainAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.add(makeNewTestObject());
			stressqueue.size();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.toArray();
			stressqueue.poll();
			stressqueue.toArray();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			items.clear();
			stressqueue.containsAll(items);
			stressqueue.toString();
			stressqueue.poll();
			items.clear();
			stressqueue.removeAll(items);
			stressqueue.toString();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.size();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.retainAll(items);
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.remove(makeNewTestObject());
			stressqueue.remove(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.remove(makeNewTestObject());
			stressqueue.retainAll(items);
			stressqueue.offer(makeNewTestObject());
			stressqueue.offer(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.peek();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.add(makeNewTestObject());
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.element();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.poll();
			stressqueue.toString();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.poll();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.remove();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.peek();
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.poll();
			stressqueue.peek();
			stressqueue.peek();
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.offer(makeNewTestObject());
			stressqueue.size();
			stressqueue.peek();
			stressqueue.peek();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.remove(makeNewTestObject());
			stressqueue.size();
			stressqueue.add(makeNewTestObject());
			stressqueue.containsAll(items);
			stressqueue.containsAll(items);
			stressqueue.isEmpty();
			stressqueue.removeAll(items);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.remove(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.retainAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.offer(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.toString();
			stressqueue.size();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.remove(makeNewTestObject());
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.isEmpty();
			stressqueue.retainAll(items);
			stressqueue.peek();
			stressqueue.peek();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.element();
			stressqueue.poll();
			stressqueue.peek();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			items.clear();
			stressqueue.removeAll(items);
			stressqueue.removeAll(items);
			stressqueue.peek();
			stressqueue.poll();
			stressqueue.retainAll(items);
			stressqueue.toString();
			stressqueue.toArray();
			stressqueue.poll();
			stressqueue.containsAll(items);
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.remove(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.removeAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.containsAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.toArray();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			items.clear();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.size();
			stressqueue.size();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.offer(makeNewTestObject());
			stressqueue.toArray();
			stressqueue.isEmpty();
			stressqueue.toString();
			stressqueue.remove();
			stressqueue.removeAll(items);
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.toString();
			stressqueue.containsAll(items);
			stressqueue.size();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.toString();
			stressqueue.toArray(new GenericTestObject[10]);
			stressqueue.poll();
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.peek();
			stressqueue.toString();
			stressqueue.element();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.poll();
			stressqueue.offer(makeNewTestObject());
			stressqueue.offer(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.size();
			stressqueue.poll();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.containsAll(items);
			stressqueue.peek();
			stressqueue.size();
			stressqueue.size();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.removeAll(items);
			stressqueue.toArray();
			items.clear();
			stressqueue.toArray();
			stressqueue.element();
			stressqueue.toArray();
			stressqueue.containsAll(items);
			stressqueue.removeAll(items);
			stressqueue.element();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.retainAll(items);
			stressqueue.retainAll(items);
			stressqueue.retainAll(items);
			stressqueue.removeAll(items);
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.isEmpty();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.peek();
			stressqueue.remove(makeNewTestObject());
			stressqueue.size();
			items.clear();
			stressqueue.poll();
			stressqueue.isEmpty();
			stressqueue.size();
			stressqueue.add(makeNewTestObject());
			stressqueue.peek();
			stressqueue.poll();
			stressqueue.offer(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.toArray();
			stressqueue.poll();
			items.clear();
			stressqueue.poll();
			stressqueue.remove(makeNewTestObject());
			stressqueue.retainAll(items);
			items.clear();
			stressqueue.toString();
			stressqueue.toArray();
			stressqueue.removeAll(items);
			items.clear();
			stressqueue.add(makeNewTestObject());
			stressqueue.isEmpty();
			items.clear();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			items.clear();
			stressqueue.toArray();
			stressqueue.size();
			stressqueue.toString();
			stressqueue.remove(makeNewTestObject());
			stressqueue.remove();
			items.clear();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.peek();
			stressqueue.isEmpty();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.toArray();
			stressqueue.poll();
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.remove(makeNewTestObject());
			stressqueue.size();
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.removeAll(items);
			stressqueue.retainAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.isEmpty();
			stressqueue.add(makeNewTestObject());
			stressqueue.remove();
			stressqueue.retainAll(items);
			stressqueue.isEmpty();
			stressqueue.offer(makeNewTestObject());
			stressqueue.offer(makeNewTestObject());
			stressqueue.element();
			stressqueue.removeAll(items);
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.peek();
			stressqueue.remove();
			stressqueue.retainAll(items);
			items.clear();
			stressqueue.size();
			stressqueue.remove(makeNewTestObject());
			stressqueue.containsAll(items);
			stressqueue.size();
			stressqueue.toString();
			stressqueue.retainAll(items);
			stressqueue.poll();
			stressqueue.poll();
			stressqueue.containsAll(items);
			stressqueue.offer(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.contains(items.get(0));
			stressqueue.size();
			stressqueue.size();
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.peek();
			stressqueue.remove(makeNewTestObject());
			stressqueue.retainAll(items);
			stressqueue.containsAll(items);
			items.clear();
			stressqueue.add(makeNewTestObject());
			stressqueue.size();
			stressqueue.toString();
			stressqueue.add(makeNewTestObject());
			itr = stressqueue.iterator();
			while(itr.hasNext())
			{
				stressqueue.contains(itr.next());
			}
			stressqueue.peek();
			if(items.size() > 0)
				items.remove(0);
			stressqueue.containsAll(items);
			stressqueue.peek();
			stressqueue.add(makeNewTestObject());
			stressqueue.remove(makeNewTestObject());
			items.add(makeNewTestObject());
			stressqueue.addAll(items);
			stressqueue.size();
			stressqueue.retainAll(items);
			items.clear();
			stressqueue.remove(makeNewTestObject());
			stressqueue.size();
			stressqueue.offer(makeNewTestObject());
			stressqueue.retainAll(items);
			stressqueue.size();
		}
		catch(NoSuchElementException e)
		{
			// expected if stressqueue was empty when we tried to remove()
		}
	}
}
