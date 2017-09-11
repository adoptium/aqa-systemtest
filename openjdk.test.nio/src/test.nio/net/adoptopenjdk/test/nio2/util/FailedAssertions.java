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

package net.adoptopenjdk.test.nio2.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *  A collection, with convenience methods, to store information
 *  about assertions that have failed when we are running in a 
 *  multi-threaded manner.
 */
public class FailedAssertions {
	
	List<Exception> exceptions = null;
	
	public FailedAssertions() {
		exceptions = new LinkedList<Exception>();
	}
	
	public synchronized int getNumberOfExceptions() {
		return exceptions.size();
	}
	
	public synchronized void addException(Exception e) {
		exceptions.add(e);
	}
	
	public synchronized boolean hasExceptions() {
		return (exceptions.size() > 0);
	}
	
	public synchronized String getExceptionMessages() {	
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		
		if (hasExceptions()) {
			printWriter.println("Failed Assertion Exceptions:");
			for (Exception e: exceptions) {
				e.printStackTrace(printWriter);
				printWriter.println("---");
			}
		} else {
			printWriter.println("No Failed Assertion Exceptions logged");
		}
		
		return stringWriter.toString();	
	}
}
