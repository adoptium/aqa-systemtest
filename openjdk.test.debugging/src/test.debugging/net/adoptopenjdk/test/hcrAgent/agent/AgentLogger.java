/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/
package net.adoptopenjdk.test.hcrAgent.agent;

/*
 * This class throttles the level of debug output we get from the agent.
 * 0 = Almost none of it.
 * 1 = Just the key bits.
 * 2 = All of it.
 */
public class AgentLogger {
	private static int debugLevel = 0;
	private static Error storedError = null;
	
	/**
	 * Set the level of debug output via this method.
	 * @param i The replacement level of output.
	 */
	public static void setDebugLevel(int i) {
		debugLevel = i;
	}
	
	/**
	 * Since we can't throw Errors from transformers, we store 
	 * them here so another class can rethrow them later.
	 * @param e The error we're storing.
	 */
	public static synchronized void logError(Error e) {
		storedError = e;
	}
	
	/**
	 * The second half of addError, this is where we throw the 
	 * Error we stored. Only to be called by classes that allow
	 * these errors to rise to the top of the stack, for debugging.
	 * @throws The error we're storing.
	 */
	public static synchronized void throwErrors() {
		if(storedError != null) {
			throw new Error(storedError);
		}
	}

	/**
	 * This method prints the message to the screen, but only if
	 * the level of desired output is equal to or greater than the
	 * level associated with this message.
	 * @param message      The message to be printed (potentially).
	 * @param messageLevel The message level. 0=vital, 2=optional.
	 */
	public static void printThis(String message, int messageLevel) {
		if (messageLevel <= debugLevel) {
			System.out.println(message);
		}
	}
}
