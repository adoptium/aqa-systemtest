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

package net.adoptopenjdk.test.streams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Test;

import net.adoptopenjdk.test.streams.support.GenerateRandomText;
import net.adoptopenjdk.test.streams.support.Line;

/**
 * JUnit testcases designed to test the paralleStream() operation within the java.util.stream 
 * package. Java 8 streams are designed to take data structures such as ArrayLists and 
 * conduct operations, such as filter(), on the data. This does not change the original
 * data structure. The parallelStream() operation conducts these operations in parallel on 
 * multiple CPU's if possible. 
 */
public class TestParallelStreamOperations {
	private int MAX_NUM_CONCURRENT_TESTS = 2;
	
	// Track how many tests are currently running. Used to prevent too many running in a test.
	private static AtomicInteger currentNumTests = new AtomicInteger();

	private interface LimitedTest {
		void run() throws Exception;
	}
	
	// All the below testcases contain code with the same object written three ways-
	// Pre-Java8, with parallelStream() and stream(). All parallel and stream results 
	// are compared to the Pre-Java8 code and must match in order to pass. Where applicable 
	// the parallelStream() operations are confirmed to be running on multiple CPU's.
	// 
	// Testcase using random text where the number of lines with less than 100 characters 
	// are counted.
	@Test
	public void testShortLines() throws Exception {
		runTest(() -> {
			//  Set up data set
			ArrayList<Line> randomText = new GenerateRandomText().getBigDataSet();
			
			// Pre-Java8 code to compare parallel streams result to
			int numShortLines = 0;
			for (Line currentLine : randomText) {
				if (currentLine.nChars() < 100) {
					numShortLines++;
				}
			}
			
			// Parallel streams code 	
			long testPSChars = randomText.parallelStream()
					.map(Line::nChars)
					.filter(l -> l<100)
					.count();
	
			// Streams code as another comparison
			long testSChars = randomText.stream()
					.map(Line::nChars)
					.filter(l -> l<100)
					.count();
			
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(numShortLines, testPSChars);
			assertEquals(numShortLines, testSChars);
		});
	}
	
	// Testcase using the random dataset where the number of words with more than 3
	// but less than seven letters within a word are counted.
	@Test
	public void testRanMediumWords() throws Exception {
		runTest(() -> {
			//  Set up data set
			ArrayList<Line> ranGenLines = new GenerateRandomText().getRandomLines(100000);
	
			//  Pre-Java 8 code to compare parallel streams result to
			int numMediumWords = 0;
			for (Line currentLine : ranGenLines) {
				if (currentLine.getWords().toString().length() > 3
						&& currentLine.getWords().toString().length() < 7) {
					numMediumWords++;
				}
			}
	
			//  Parallel streams code 
			long testPSWords = ranGenLines.parallelStream()
					.map(Line::getWords)
					.filter(w -> w.toString().length() > 3)
					.filter(w -> w.toString().length() < 7)
					.count();
	
			//  Streams code as another comparison
			long testSWords = ranGenLines.stream()
					.map(Line::getWords)
					.filter(w -> w.toString().length() > 3)
					.filter(w -> w.toString().length() < 7)
					.count();
	
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(numMediumWords, testPSWords);
			assertEquals(numMediumWords, testSWords);
		});
	}
	
	// Testcase using some random text and counting the number of lines that contain the letter "e".
	@Test
	public void testLetterNos() throws Exception {
		runTest(() -> {
			// Set up data set
			ArrayList<Line> randomText = new GenerateRandomText().getBigDataSet();
			
			// Pre-Java8 code to compare parallel streams result to
			int totalEs = 0;
			for (Line currentLine : randomText) {
				totalEs += currentLine.noOfLetter("e");	
			}
			
			// Parallel streams code 
			int testPSLetterNos = randomText.parallelStream()
					.mapToInt(l -> l.noOfLetter("e"))
					.reduce(0, Integer::sum);
			
			// Streams code as another comparison
			int testSLetterNos = randomText.stream()
					.mapToInt(l -> l.noOfLetter("e"))
					.reduce(0, Integer::sum);
			
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(totalEs, testPSLetterNos);
			assertEquals(totalEs, testSLetterNos);
		});
	}
	
	// Testcase using some random text and counting how many words equal to "to".
	@Test
	public void testAnyWord() throws Exception {
		runTest(() -> {
			// Set up data set
			ArrayList<Line> randomText = new GenerateRandomText().getBigDataSet();
			
			// Pre-Java8 code to compare parallel streams result to
			int countOfTo = 0;
			for (Line currentLine : randomText) {
				for (String word : currentLine.getWords()) {
					if (word.equals("to")) {
						countOfTo++;
					}
				}
			}
			
			// Parallel streams code
			long testPSFwordTo = randomText.parallelStream()
					.flatMap(l -> l.getWords().parallelStream())
					.filter(w -> w.equals("to"))
					.count();
			
			// Streams code as another comparison
			long testSFwordTo = randomText.stream()
					.flatMap(l -> l.getWords().stream())
					.filter(w -> w.equals("to"))
					.count();
			
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(countOfTo, testPSFwordTo);
			assertEquals(countOfTo, testSFwordTo);
		});
	}
	
	// Testcase using the random dataset that collects all the words containing
	// the letter "a"
	@Test
	public void testRanContainLetter() throws Exception {
		runTest(() -> {
			// Set up data
			ArrayList<Line> ranGenLines = new GenerateRandomText().getRandomLines(100000);
			
			// Pre-Java8 code to compare parallel streams result to
			ArrayList<String> containsA = new ArrayList<String>();
			for (Line currentLine : ranGenLines) {
				for (String currentWord : currentLine.getWords()) {
					if (currentWord.contains("a")) {
						containsA.add(currentWord);
					}
				}
			}
			Collections.sort(containsA);
			
			// Parallel streams code 
			List<Object> testPSContainsA = ranGenLines.parallelStream()
					.flatMap(l -> l.getWords().parallelStream())
					.filter(l -> l.contains("a"))
					.sorted()
					.collect(Collectors.toList());
			
			// Streams code as another comparison
			List<Object> testSContainsA = ranGenLines.stream()
					.flatMap(l -> l.getWords().stream())
					.filter(l -> l.contains("a"))
					.sorted()
					.collect(Collectors.toList());
			
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(containsA, testPSContainsA);
			assertEquals(containsA, testSContainsA);
		});
	}
	
	// The most complex testcase of the set that finds the most common word in a large body of random 
	// text. The parallel streams portion of the test is conducted in a separate fork join
	// pool with a thread for each CPU. 
	@Test
	public void testCommonWord() throws Exception {
		runTest(() -> {
			// Set up data set
			ArrayList<Line> randomText = new GenerateRandomText().getBigDataSet();
				
			// Pre-Java8 code to compare parallel streams result to
			// A HashMap is created and populated with each word as a key with the value increasing 
			// each time the word is seen. 
			HashMap<String, Long> wordMap = new HashMap<String, Long>();
			
			for (Line currentLine : randomText) {	 				
				 for (String currentWord : currentLine.getWords()) {
					String word = currentWord.toLowerCase();
	
					if (wordMap.containsKey(word)) {
						Long currentCount = wordMap.get(word);
						wordMap.put(word, currentCount+1);
					} else {
						wordMap.put(word, 1L);
					}
				}
			}
			
			// Find the highest value and it's corresponding key
			Long highestCount = 0L;
			String highestKey = null;
			
			for (Map.Entry<String, Long> entry : wordMap.entrySet() ) {
				Long value = entry.getValue();
				String keyName = entry.getKey();
				
				if (value > highestCount) {
					highestCount = value;
					highestKey = keyName;
				}
			}
			wordMap = null;
						
			// Parallel streams code that checks it runs on more than one thread
			
			// In order to assess that the parallel streams code is executing on multiple CPU's
			// in a multi-threaded environment, a separate forkJoinPool is created with the 
			// number of threads equal to the number of CPU's. 
			Set<String> threadNames1 = Collections.synchronizedSet(new HashSet<String>());
			int numCores = Runtime.getRuntime().availableProcessors();
			ForkJoinPool forkJoinPool2 = new ForkJoinPool(numCores);
			
			// The parallel stream operation of the random dataset is submitted to the forkJoinPool.
			// The words in each line are flatMapped into a new parallel stream, which then groups the 
			// words into a collection and counts how many instances of each word there are. Finally 
			// the highest value and it's key are returned revealing the most commonly used word.  
			Optional<Entry<String, Long>> testCommonWordsPS = forkJoinPool2.submit(
					() -> randomText.parallelStream()
						.peek(i -> threadNames1.add(Thread.currentThread().getName()))
						.flatMap(l -> l.getWords().parallelStream())
						.collect(Collectors.groupingBy(e -> e.toLowerCase(), Collectors.counting())).entrySet()
						.parallelStream()
						.max(Comparator.comparing(Entry::getValue))).get();	
					
			String highestKeyPS = (String) testCommonWordsPS.get().getKey();
			Long highestValuePS = testCommonWordsPS.get().getValue();
			
			// Streams code as another comparison
			//
			// The streams code is similar to the parallel streams code but broken down into two parts without
			// the forkJoinPool. Firstly the words and their values are collected and secondly the highest value
			// and its key are returned.
			Map<Object, Long> testCountWordsS = randomText.stream()
					.flatMap(l -> l.getWords().stream())
					.collect(Collectors.groupingBy(e -> e.toLowerCase(), Collectors.counting()));
	
			Optional<Entry<Object, Long>> testCommonWordsS = testCountWordsS.entrySet()
					.stream()
					.max(Comparator.comparing(Entry::getValue));
			
			String highestKeyS = (String) testCommonWordsS.get().getKey();
			Long highestValueS = testCommonWordsS.get().getValue();
	
			// Assert statements to check that the parallel streams result matches the pre-Java8 result and the 
			// streams result
			assertEquals(highestKey, highestKeyPS);
			assertEquals(highestCount, highestValuePS);
			assertEquals(highestKey, highestKeyS);
			assertEquals(highestCount, highestValueS);		
		});
	}		 
	
	private void runTest(LimitedTest testCase) throws Exception {
		// If there are ready more tests running than the limit then don't 
		// start any more, and return after a few seconds. 
		int numRunning = currentNumTests.incrementAndGet();
		if (numRunning > MAX_NUM_CONCURRENT_TESTS) {
			// Too many running 
			currentNumTests.decrementAndGet();
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + ": Too many parallel streams tests running. Skipping. (" + numRunning + " running including this thread)");

		} else {
			// Run the test case
			try {
				testCase.run();
			} finally {
				currentNumTests.decrementAndGet();
			}
		}
	}
}
