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

package net.adoptopenjdk.test.lang.java7.ProjectCoin;

import junit.framework.TestCase;

/*
 * CoinTest
 * ========
 * 
 * This defines some of the custom exceptions used by the individual project coin tests.
 */

public class CoinTest extends TestCase {
	private boolean debug = false;
	
	public void setDebug(boolean b){
		this.debug = b;
	}
	
	static class InitialisingException extends Exception {
		private static final long serialVersionUID = 1L;

		public String toString() {
			return "InitialisingException";
		}
	}
	
	static class BlockException extends Exception {
		private static final long serialVersionUID = 1L;

		public String toString() {
			return "BlockException";
		}
	}
	
	static class ClosingException extends Exception {
		private static final long serialVersionUID = 1L;

		public String toString() {
			return "ClosingException";
		}
	}
	
	static class FirstOne extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	static class SecondOne extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	static class ThirdOne extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	void printMessage(String message) {
		if (debug){
			System.out.print(message);
		}
	}
}
