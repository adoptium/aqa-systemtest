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

import java.util.ArrayList;

/**
 * Line class is designed to be used by the TestParallelStreamOperation JUnit
 * testcases for Java 8 testing.
 */

public class Line {
	private String line;

	public Line(String theLine) {
		line = theLine.trim();
	}

	public int nChars() {
		return line.length();
	}

	public String toString() {
		return line;
	}

	public int noOfLetter(String letter) {
		String allOf = line.replaceAll("[^" + letter + "]", "");
		int count = allOf.length();
		return count;
	}

	public boolean isLetter(String letter) {
		String letterExists = line.replaceAll("[^" + letter + "]", "");
		int count = letterExists.length();
		if (count >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	// Returning all the words on a line without punctuation as an ArrayList
	public ArrayList<String> getWords() {
		String attributes = line.substring(0);
		String[] preWords = attributes.split("[ :;-]");

		ArrayList<String> words = new ArrayList<String>();
		for (String currentWord : preWords) {
			String cleanWord = currentWord.replaceAll("[.,\"?!]", "");

			if (!cleanWord.isEmpty()) {
				words.add(cleanWord);
			}
		}
		
		return words;
	}
}
