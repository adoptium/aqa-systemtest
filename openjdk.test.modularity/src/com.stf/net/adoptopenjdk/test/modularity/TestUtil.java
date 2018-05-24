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

package net.adoptopenjdk.test.modularity;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;

// This class hosts some utility programs that are commonly used by the modularity tests 
public class TestUtil { 
	public static void main (String [] args) throws Exception {
		StringBuffer output = new StringBuffer();
		Scanner scanner1 = new Scanner(new File(System.getProperty("file1")));
		Scanner scanner2 = new Scanner(new File(System.getProperty("file2")));
		File combinedFile = new File(System.getProperty("final.file")); 

		while(scanner1.hasNextLine()){
			output.append(scanner1.nextLine() + "\n");
		}

		while(scanner2.hasNextLine()){
			output.append(scanner2.nextLine() + "\n");
		}

		PrintWriter pw = new PrintWriter(combinedFile); 
		pw.write(output.toString());
		pw.flush();
		pw.close();
		scanner1.close();
		scanner2.close();
	}
}
