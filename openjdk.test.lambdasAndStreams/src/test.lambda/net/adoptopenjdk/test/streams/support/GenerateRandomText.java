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

package net.adoptopenjdk.test.streams.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates random text for the TestParallelStreamOperations test class.
 */
public class GenerateRandomText {
	
	//  All tests reference the same data set, greatly increasing the number of tests that can
	//  be run concurrently.
	private static ArrayList<Line> bigDataSet = new ArrayList<Line>();
	private static ArrayList<Line> randomLinesArray = new ArrayList<Line>();
	
	public static void main(String[] args) throws IOException {
		GenerateRandomText zp = new GenerateRandomText();
		zp.getBigDataSet();
		zp.getRandomLines(1000);
	}

	// Generate random lines of text to simulate a large body of text.
	public ArrayList<Line> getBigDataSet() throws IOException {
		synchronized (bigDataSet) {
			if (bigDataSet.isEmpty()) {
				long seed = -9049829296011L;
				createRandomText(130000, seed, bigDataSet);
			}

			return bigDataSet;
		}
	}

	// The genRandomLines method generates line objects with 2-10 characters and 5-17 words.
	public ArrayList<Line> getRandomLines(int numLines) throws IOException {
		synchronized (randomLinesArray) {
			if (randomLinesArray.isEmpty()) {
				long seed = 34454354444L;
				createRandomText(numLines, seed, randomLinesArray);
			}

			return randomLinesArray;
		}
	}

	private void createRandomText(int numLines, long seed, ArrayList<Line> lines) {
		Random randomGenerator = new Random(seed);
		
		// Randomly choose the number of words per line (5-17)
		for (int lineNo = 0; lineNo < numLines; lineNo++) {
			StringBuilder builder = new StringBuilder();
			int wordsPerLine = randomGenerator.nextInt(12) + 5;

			// Randomly choose the number of characters per word (2-10)
			for (int words = 0; words < wordsPerLine; words++) {
				int charartersPerWord = randomGenerator.nextInt(8) + 2;

				// Choose a random character a-z and append to the word 
				for (int characters = 0; characters < charartersPerWord; characters++) {
					char c = (char) (randomGenerator.nextInt(26) + 'a');
					builder.append(c);
				}
				
				builder.append(" ");
			}
			
			// Create a line object for each line and add the random lines to an ArrayList
			String randomWord = builder.toString();
			Line randomLine = new Line(randomWord);
			lines.add(randomLine);
		}
	}
}
