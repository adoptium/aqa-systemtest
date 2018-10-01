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

package net.adoptopenjdk.test.nio2.path;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.ReiserSpotter;
import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

import java.nio.file.NoSuchFileException;

public class ScannerTest extends TestCaseWithTempDirectory {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		HangNotifier.ping();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	// Two new methods have been added to the Scanner class to take in FileRef arguments
	public void testScanner() throws IOException, StfException {
		
		Path newFilename = Paths.get("scanner.txt");
		Path temporaryDir = getTemporaryDirectory();
		Path newFile = temporaryDir.resolve(newFilename);
		Files.createFile(newFile);
		assertTrue("File was not created", Files.exists(newFile));

		// Write out some information to the file
		//  - A random number of integers.
		OutputStream out = Files.newOutputStream(newFile, StandardOpenOption.WRITE);		
		PrintStream printStream = new PrintStream(out);
		Random rand = new Random();	
		List<Integer> writtenValues = new LinkedList<Integer>();	
		int numberOfTokens = rand.nextInt(100) + 100;

		for (int counter = 0; counter < numberOfTokens; counter++) {			
			int nextValue = rand.nextInt(100000);
			writtenValues.add(nextValue);
			printStream.print(nextValue + " ");		
		}
		
		printStream.close();

		// Read all the values back in using the Scanner's default
		//  space delimited approach
		Scanner scanner = new Scanner(newFile);
		
		for (Integer value: writtenValues) {
			assertEquals(value.intValue(), scanner.nextInt());
		}
		
		scanner.close();

		try{
			okForCleanup();
		}
		catch(NoSuchFileException e){
			if(ReiserSpotter.getIsReiser()){
				try{
					okForCleanup();
				}
				catch(NoSuchFileException e2){
				}
			}else{
				throw e;
			}
		}		
	}	
}
