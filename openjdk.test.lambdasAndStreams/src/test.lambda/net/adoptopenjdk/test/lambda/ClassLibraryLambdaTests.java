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

package net.adoptopenjdk.test.lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Spliterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Stream;
import junit.framework.TestCase;

/**
 *  A class for testing the changes made to the Java Class
 *  Library to support Lambdas. These tests are not intended
 *  to be comprehensive, but rather to test the new functionality
 *  in a way that is (a) atomic and (b) risky for the JIT. 
 */
public class ClassLibraryLambdaTests extends TestCase {
	// Prevents concurrent execution problems in testLoggerLambdaMethods().
	// Each time the method is run the code uses this integer to create a unique logger name.
    private static AtomicInteger testRunNumber = new AtomicInteger(0); 
	
	// A basic interface to permit Lambda testing.
	public interface LamInt1 {
		// A blank method used to implement any Lambda.
		//
		// z - an input integer for any purpose.
		// Returns an integer signifying anything.
		int method1(int z);
	}
	
	// An interface to implement a method reference.
	public interface LamInt2<T> {
		// A method to implement a "Collector" method reference.
		//  
		// list - The list to be sorted.
		// c	- The Comparator used to compare any two elements, and return
		//		  a numerical value which states which value should be higher
		//	      in the list than the other.
		abstract void sort(List<T> list, Comparator<? super T> c);
	}
	
	// A class to store log messages in array, and to return that array.
	public class HandlerPlus extends Handler {
		ArrayList<String> messages = new ArrayList<String>();
		
		// A method to store the contents of a message logged using 
		// an associated Logger object.
        //	  
		// logRecord  - An object which stores a string message,
		//			  	along with metadata about that message.
		public void publish(LogRecord logRecord) {
			messages.add(logRecord.getMessage());
		}
		
		// Blank method to enable compilation.
		public void close() {
		}
		
		// Blank method to enable compilation.
		public void flush() {
		}
		
		// For retrieving all messages published so far.
		// Returns a list of LogRecord messages in String format.
		public ArrayList<String> getAllMessages() {
			return messages;
		}
	}
	
	// A String wrapper which enables the user to modify
	// a string when he isn't able to replace it, something
	// which a normal String does not seem to allow.
	public class StringHolder {
		private String s;
		public StringHolder(String q) {
			s = q;
		}
		public void concat(String g) {
			s += g;
		}
		public String getString() {
			return s;
		}
	}

	private Random randomNumbers = new Random();
	
	public static void main(String[] args) throws IOException {
		ClassLibraryLambdaTests x = new ClassLibraryLambdaTests();
		x.runEverything();
	}
	
	// This method simplifies debugging by allowing the test 
	//  to be run without junit runner.
	private void runEverything() throws IOException {
		testLambdasInCollections();
		testMiscLambdaCLChanges();
		testLoggerLambdaMethods();
		testStreamsinFileClass();
	}
	
	// Testing the streams-based methods in the File class.
	public void testStreamsinFileClass() throws IOException {
		// Files.list, lines, and find.
		final File classFile = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		final Path lamFilesDir = Paths.get(classFile.getAbsolutePath(), "net/adoptopenjdk/test/lambda/LamFiles");
		Stream<Path> filesList = Files.list(lamFilesDir);

		Iterator<Path> filesResults = filesList.iterator();
		String[] idealResults = {"a.txt","b.txt","c.txt","fold1"};
		
		runTestAgainstStreamIterator(filesResults, idealResults);
		
		filesList.close();
		
		Stream<String> fileStrings = Files.lines(Paths.get(lamFilesDir.toFile().getAbsolutePath(), "a.txt"), Charset.defaultCharset());
		assertTrue("", fileStrings.anyMatch((String s) -> s.equals("hijklmn")));
		fileStrings.close();
		
		Stream<String> fileStrings2 = Files.lines(Paths.get(lamFilesDir.toFile().getAbsolutePath(), "b.txt"), Charset.defaultCharset());
		assertFalse("", fileStrings2.anyMatch((String s) -> s.equals("x")));
		fileStrings2.close();
		
		Stream<Path> filesList2 = Files.find(lamFilesDir,2,(Path p, BasicFileAttributes b) -> !b.isDirectory());
		Iterator<Path> filesResults2 = filesList2.iterator();
		String[] idealResults2 = {"a.txt","b.txt","c.txt","fold1" + File.separator + "1.txt"};
		runTestAgainstStreamIterator(filesResults2, idealResults2);
		
		filesList2.close();
	}
	
	// Testing lambda-related functionality in a variety of Map and Collection implementations.
	public void testLambdasInCollections() {		
		// Setting up the ArrayList.
		ArrayList<StringHolder> stringArrayList = new ArrayList<StringHolder>();
		ArrayList<StringHolder> originalStringArrayList = new ArrayList<StringHolder>();
		ArrayList<StringHolder> stringArrayListForCollections = new ArrayList<StringHolder>();
		ArrayList<StringHolder> originalStringArrayListForCollections = new ArrayList<StringHolder>();
		Vector<StringHolder> stringVector = new Vector<StringHolder>();	
		Vector<StringHolder> originalStringVector = new Vector<StringHolder>();	
		CopyOnWriteArrayList<StringHolder> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<StringHolder>();
		CopyOnWriteArrayList<StringHolder> originalStringCopyOnWriteArrayList = new CopyOnWriteArrayList<StringHolder>();
		HashMap<Integer,StringHolder> stringHashMap = new HashMap<Integer,StringHolder>();
		HashMap<Integer,StringHolder> originalStringHashMap = new HashMap<Integer,StringHolder>();
		Hashtable<Integer,StringHolder> stringHashtable = new Hashtable<Integer,StringHolder>();
		Hashtable<Integer,StringHolder> originalStringHashtable = new Hashtable<Integer,StringHolder>();
		
		String manyCharacters = "abcdefghijklmnopqrstuvwxyz1234567890 !$%^&*() {}][=-_+#';:~/.,";
		int atCounter = 0;
		for(int x = 0;x < 100;x++) {
			String tempString = new String("");
			int randomInt = randomNumbers.nextInt(5) + 1;
			for(int y = 0;y<randomInt;y++) {
				tempString += (manyCharacters.charAt(randomNumbers.nextInt(manyCharacters.length())));
			}
			if ((x%3) == 0) {
				tempString += ("@");
				atCounter++;
			}
			stringArrayList.add(new StringHolder(tempString));
			originalStringArrayList.add(new StringHolder(tempString));
			stringArrayListForCollections.add(new StringHolder(tempString));
			originalStringArrayListForCollections.add(new StringHolder(tempString));
			stringVector.add(new StringHolder(tempString));
			originalStringVector.add(new StringHolder(tempString));
			stringCopyOnWriteArrayList.add(new StringHolder(tempString));
			originalStringCopyOnWriteArrayList.add(new StringHolder(tempString));
			stringHashMap.put(new Integer(x), new StringHolder(tempString));
			originalStringHashMap.put(new Integer(x), new StringHolder(tempString));
			stringHashtable.put(new Integer(x), new StringHolder(tempString));
			originalStringHashtable.put(new Integer(x), new StringHolder(tempString));			
		}
		
		//forEach testing starts here.		
		runForEach(stringArrayList, originalStringArrayList);
		runForEach(stringVector, originalStringVector);
		runForEach(stringCopyOnWriteArrayList, originalStringCopyOnWriteArrayList);
		
		runForEachMap(stringHashMap, originalStringHashMap);
		runForEachMap(stringHashtable, originalStringHashtable);
		
		// removeIf testing starts here	
		runRemoveif (stringArrayList, atCounter);
		runRemoveif (originalStringArrayList, atCounter);
		runRemoveif (stringVector, atCounter);
		runRemoveif (originalStringVector, atCounter);
		runRemoveif (stringCopyOnWriteArrayList, atCounter);
		runRemoveif (originalStringCopyOnWriteArrayList, atCounter);
		
		// replaceAll testing starts here	
		runReplaceAll(stringArrayList, originalStringArrayList);
		runReplaceAll(stringVector, originalStringVector);
		runReplaceAll(stringCopyOnWriteArrayList, originalStringCopyOnWriteArrayList);
		runReplaceAllMap(stringHashMap, originalStringHashMap);
		runReplaceAllMap(stringHashtable, originalStringHashtable);
		
		// A little catch-up for the originals.	
		originalStringArrayList.forEach((StringHolder t)->t.concat("success"));
		originalStringArrayList.replaceAll((StringHolder t)->{t.concat("@JJ17r");return new StringHolder(t.getString() + "@417b");});
		originalStringVector.forEach((StringHolder t)->t.concat("success"));
		originalStringVector.replaceAll((StringHolder t)->{t.concat("@JJ17r");return new StringHolder(t.getString() + "@417b");});
		originalStringCopyOnWriteArrayList.forEach((StringHolder t)->t.concat("success"));
		originalStringCopyOnWriteArrayList.replaceAll((StringHolder t)->{t.concat("@JJ17r");return new StringHolder(t.getString() + "@417b");});
		
		// Sort testing starts here
		runSort(stringArrayList, originalStringArrayList);
		runSort(stringVector, originalStringVector);
		runSort(stringCopyOnWriteArrayList, originalStringCopyOnWriteArrayList);
		
		// Sort for Collections
		LamInt2<StringHolder> collectionsSort = Collections::sort;
		
		collectionsSort.sort(stringArrayListForCollections,(StringHolder t, StringHolder r)->t.getString().compareTo(r.getString()));
		
		boolean allSorted = false;
		boolean changed = false;
		int x = 0;
		if (originalStringArrayListForCollections.size() > 1) {
			while (!allSorted) {
				// Check arraylist from start to finish, comparing two at a time.
				if (originalStringArrayListForCollections.get(x).getString().compareTo(originalStringArrayListForCollections.get(x+1).getString()) > 0) {
					StringHolder temp123 = originalStringArrayListForCollections.get(x);
					originalStringArrayListForCollections.set(x,originalStringArrayListForCollections.get(x+1));
					originalStringArrayListForCollections.set(x+1,temp123);
					changed = true;
				}
				
				x++;
				
				if (x == (originalStringArrayListForCollections.size() - 1)) {
					x = 0;
					if (!changed) allSorted = true;
					changed = false;
				}
			}
		}
		
		x = 0;
		while (x < originalStringArrayListForCollections.size()) {
			assertTrue(originalStringArrayListForCollections.get(x).getString().compareTo(stringArrayListForCollections.get(x).getString()) == 0);
			x++;
		}
		
		//Spliterator testing.
		splitSpliterator(stringArrayList);
		splitSpliterator(stringVector);
		splitSpliterator(stringCopyOnWriteArrayList);
	}
	
	// Testing the lambda-messages methods in the CL Logger class.
	public void testLoggerLambdaMethods() {
		// Setup
		ArrayList<String> originals = new ArrayList<String>();
		HandlerPlus handlerPlus = new HandlerPlus();
		handlerPlus.setLevel(Level.WARNING);
		String uniqueLoggerName = "ignore" + testRunNumber.incrementAndGet();
		Logger lambdaCLTestsLogger = Logger.getLogger(uniqueLoggerName);
		lambdaCLTestsLogger.setUseParentHandlers(false);
		
		// Adding the handler aka message storage object.
		lambdaCLTestsLogger.addHandler(handlerPlus);
		
		lambdaCLTestsLogger.setLevel(Level.WARNING);
		
		// Adding four elements to logger, only two of which should be stored.
		lambdaCLTestsLogger.warning(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning1");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning1");
		lambdaCLTestsLogger.info(() -> "abcdefghijkl" + "mnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,info2");
		lambdaCLTestsLogger.finest(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest3");
		lambdaCLTestsLogger.warning(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning4");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning4");
		
		// Adding another four elements, only three of which should be stored.
		handlerPlus.setLevel(Level.INFO);
		lambdaCLTestsLogger.setLevel(Level.INFO);
		
		lambdaCLTestsLogger.warning(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning5");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning5");
		lambdaCLTestsLogger.info(() -> "abcdefghijkl" + "mnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,info6");
		originals.add("abcdefghijkl" + "mnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,info6");
		lambdaCLTestsLogger.finest(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest7");
		lambdaCLTestsLogger.warning(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning8");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning8");
		
		handlerPlus.setLevel(Level.ALL);
		lambdaCLTestsLogger.setLevel(Level.ALL);
		
		// Adding a final four elements, which should all be stored.
		lambdaCLTestsLogger.finest(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest9");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest9");
		lambdaCLTestsLogger.info(() -> "abcdefghijkl" + "mnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,info10");
		originals.add("abcdefghijkl" + "mnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,info10");
		lambdaCLTestsLogger.warning(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning11");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,warning11");
		lambdaCLTestsLogger.finest(() -> "abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest12");
		originals.add("abcdefghijklmnopqrstuvwxyz1" + "234567890 !$%^&*() {}][=-_+#';:~/.,finest12");
		
		// Verifying that only the correct messages were stored.
		ArrayList<String> loggerLogs = handlerPlus.getAllMessages();
		
		for(int p = 0; p<9; p++) {
			if (!loggerLogs.get(p).equals(originals.get(p))) {
				loggerLogs.forEach((String l) -> System.out.println(l));
				System.out.println("and then originals.");
				originals.forEach((String l) -> System.out.println(l));
			}
			assertTrue("The wrong messages were stored in the log. Expected " + originals.get(p) + " but found " + loggerLogs.get(p) + " at position " + p, loggerLogs.get(p).equals(originals.get(p)));
		}
	}
	
	// Covering a selection of tests for the Lambda-related class-library changes which are:
	// 		a) too small to warrant their own method,
	//		b) too different from each other to be grouped under a meaningful heading, and
	//		c) implemented in such a way as to increase the odds of inducing JIT collapse.
	public void testMiscLambdaCLChanges() {
		// Testing the "with Initial" method in the CL ThreadLocal class.
		ThreadLocal<Integer> oneThreadLocal = ThreadLocal.withInitial(() -> 59);
		int x = oneThreadLocal.get();

		assertTrue("withInitial method failed to produce the expected numerical value. Expected 59 but received " + x, x == 59);
		
		StringReader reader = new StringReader("stuff\nstuff\nmorestuff");
		BufferedReader bReader = new BufferedReader(reader);
		
		assertTrue(bReader.lines().allMatch((String s) -> s.contains("stuff") && !s.contains("\n")));
	}
	
	// Streams iterator testing.
	void runTestAgainstStreamIterator(Iterator<Path> i, String[] s) {
		ArrayList<String> allOptions = new ArrayList<String>();
		
		for(String q: s) {
			allOptions.add(File.separator + "LamFiles" + File.separator + q);
		}
		
		int x = 0; // Counting the number of loops. Must not exceed four.
		while (i.hasNext()) {
			assertFalse("Size of the stream is wrong. Expected 4 but was 5 or more.", x > 3);
			
			String actualPath = i.next().toString();
			boolean hasFound = false;
			for(int y = 0; (y < allOptions.size()) && (!hasFound); y++) {
				if (actualPath.endsWith(allOptions.get(y))) {
					hasFound = true;
					allOptions.remove(y);
				}
			}
			assertTrue("File was found that isn't supposed to exist. File name: " + actualPath,hasFound);
			x++;
		}
	}
	
	// Every element containing the "@" symbol is removed from "a".
	// a  		 -  Collection of StringHolders.
	// atCounter -  The number of elements with "@" in them.
	void runRemoveif (Collection<StringHolder> a, int atCounter) {
		int startingSize = a.size();
		a.removeIf((StringHolder t) -> t.getString().contains("@"));
		assertTrue("removeIf removed " + (startingSize - a.size()) + " array elements, but was supposed to remove " + atCounter, (startingSize - a.size()) == atCounter);
		
		Iterator<StringHolder> it1 = a.iterator();
		while (it1.hasNext()) {
			StringHolder i = it1.next();
			assertFalse("removeIf has removed the wrong elements. Some of the elements intended for removal remain in the ArrayList.",i.getString().contains("@"));
		}
	}
	
	// Every element has the word "success" added to its internal String.
	// Input: Collection "a" and "b" are Collections of StringHolders.
	//	 	  Both must be identical, but separate.
	// 		  "a" is modified, but "b" is not.
	void runForEach(List<StringHolder> a, List<StringHolder> b) {
		a.forEach((StringHolder t)->t.concat("success"));
		int x = 0;
		while (x<b.size()) {
			assertTrue("Expected \"" + b.get(x).getString() + "success\" but found \"" + a.get(x).getString(),a.get(x).getString().equals(b.get(x).getString() + "success"));
			x++;
		}
	}
	
	// Using spliterators to edit the contents of a Collection (ArrayList, List, Vector, etc).
	// Split the spliterator in half, using different increments of progress before
	// changing all remaining. Return total number of @minor elements for verification.
	// arg Spliterator.
	void splitSpliterator(List<StringHolder> thisList) {
		Spliterator<StringHolder> s = thisList.spliterator();
	
		Spliterator<StringHolder> p = s.trySplit();
		int x = randomNumbers.nextInt(new Long(s.estimateSize()).intValue()) + 1; //the number of elements with @minor added in the array subsection referenced by Spliterator s.
		int k = randomNumbers.nextInt(new Long(p.estimateSize()).intValue()) + 1; //the number of elements with @minor added in the array subsection referenced by Spliterator p.
		
		if (x == k) { 
			k--;
		}
		
		// Iterate over the spliterators, adding different 
		for(int z = 0 ; z < x ; z++) {
			s.tryAdvance((StringHolder y) -> y.concat("@minor1"));
		}
		
		for(int z = 0 ; z < k ; z++) {
			p.tryAdvance((StringHolder y) -> y.concat("@minor2"));
		}
				
		s.forEachRemaining((StringHolder y) -> y.concat("@major1"));
		p.forEachRemaining((StringHolder y) -> y.concat("@major2"));
		
		// And now, we verify the results.
		for(int z = 0 ; z < thisList.size() ; z++) {
			int y = 0; //counting how many of the minor/major strings are in each entry. There should only be one of each.
			if (thisList.get(z).getString().contains("@major1")) y++;
			if (thisList.get(z).getString().contains("@major2")) y++;
			if (thisList.get(z).getString().contains("@minor1")) {
				y++;
				x--;
			}
			if (thisList.get(z).getString().contains("@minor2")) {
				y++;
				k--;
			}
			assertTrue("The spliterator has accessed some elements multiple times.",y == 1);			
		}
		assertTrue("The original spliterator modified the wrong number of elements using .tryAdvance",x == 0);	
		assertTrue("The duplicate spliterator modified the wrong number of elements using .tryAdvance",k == 0);	
	}
	
	// Same as runForEach, except this one takes Map implementors.
	void runForEachMap(Map<Integer, StringHolder> a, Map<Integer, StringHolder> b) {
		a.forEach((Integer f, StringHolder t)->t.concat("success"));
		int x = 0;
		while (x<b.size()) {
			assertTrue("Expected \"" + b.get(new Integer(x)).getString() + "success\" but found \"" + a.get(new Integer(x)).getString(),a.get(new Integer(x)).getString().equals(b.get(new Integer(x)).getString() + "success"));
			x++;
		}
	}
	
	// Every element has the "@JJ17r@417b" added to its internal String.
	// Input: Collection "a" and "b" are Collections of StringHolders.
	//		  Both must be identical, but separate.
	//		  "a" is modified, but "b" is not.
	void runReplaceAll(List<StringHolder> a, List<StringHolder> b) {
		a.replaceAll((StringHolder t)->{t.concat("@JJ17r");return new StringHolder(t.getString() + "@417b");});
		int x = 0;
		while (x<b.size()) {
			assertTrue("Expected \"" + b.get(x).getString() + "success@JJ17r@417b\" but found \"" + a.get(x).getString(),a.get(x).getString().equals(b.get(x).getString() + "success@JJ17r@417b"));
			x++;
		}
	}
	
	// Same as above, except for maps
	void runReplaceAllMap(Map<Integer,StringHolder> a, Map<Integer,StringHolder> b) {
		a.replaceAll((Integer f, StringHolder t)->{t.concat("@JJ17r");return new StringHolder(t.getString() + "@417b");});
		int x = 0;
		while (x<b.size()) {
			assertTrue("Expected \"" + b.get(x).getString() + "success@JJ17r@417b\" but found \"" + a.get(x).getString(),a.get(x).getString().equals(b.get(x).getString() + "success@JJ17r@417b"));
			x++;
		}
	}
	
	// Both Lists are sorted using different means, and then compared.
	// Input: Collection "a" and "b" are Collections of StringHolders.
	//		  Both must be identical, but seperate.
	//		  Both are modified.
	void runSort(List<StringHolder> a, List<StringHolder> b) {
		a.sort((StringHolder t, StringHolder r)->t.getString().compareTo(r.getString()));
		
		boolean allSorted = false;
		boolean changed = false;
		int x = 0;
		if (b.size() > 1) {
			while (!allSorted) {
				// check arraylist from start to finish, comparing two at a time.
				if (b.get(x).getString().compareTo(b.get(x+1).getString()) > 0) {
					StringHolder temp123 = b.get(x);
					b.set(x,b.get(x+1));
					b.set(x+1,temp123);
					changed = true;
				}
				x++;
				if (x == (b.size() - 1)) {
					x = 0;
					if (!changed) allSorted = true;
					changed = false;
				}
			}
		}
		
		x = 0;
		while (x < b.size()) {
			assertTrue(b.get(x).getString().compareTo(a.get(x).getString()) == 0);
			x++;
		}
	}
}
