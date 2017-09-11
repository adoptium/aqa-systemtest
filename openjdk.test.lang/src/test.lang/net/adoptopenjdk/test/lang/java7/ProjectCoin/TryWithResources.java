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

/*
 * 
 * TryWithResources
 * ================
 * 
 * New support for automatic resource management has been built into Java70. There is a new interface called 'AutoCloseable', 
 * and classes implementing this interface override the close() method, which contains everything needed to close a given resource.
 * As part of a try/catch, you can declare resources to be used within the try block that will be automatically closed on completion,
 * removing the need for resource.close() statements within the finally block.
 * 
 * In addition, exceptions are more sensibly handled. In pre-Java70, If we throw an exception V1 during the try block whilst working
 * with the stream, and a second exception V2 whilst closing the stream in the finally block, unless extra code is written to accommodate
 * this scenario, only exception V2 will be caught - which is actually the one you care least about.
 * 
 * If this happens in Java70, the exception V1 from the block is thrown, and V2 is added to V1's list of 'SuppressedExceptions'.
 * 
 * 1. Class FakeStream: Constructor FakeStream(boolean[] whereToFail)
 * 
 * 	- A dummy stream that provides open(), close() (for AutoClosing), and doStuff() methods to simulate a real stream, and
 * also throwInitException(), throwBlockException(), and throwClosingException(), which throw InitialisationExceptions, BlockExceptions,
 * and ClosingExceptions respectively.
 * 
 * - The constructor expects a 3-element boolean array. The booleans act as switches activating the throwing of an appropriate exception
 * during stream initialisation in open(), during doStuff() which should be called in the try block body, or during stream close in close().
 * 
 * 2. Scenarios Tested:
 * -  0: Exceptions activated in stream open(), in doStuff() body, and during stream close().
 * 	  -- Expected Behaviour: See an InitialisingException thrown from the open method. No further exceptions thrown or suppressed.
 *       Stream should be NULL after try/catch exits, as it never gets initialised.
 *       
 *    1: Exceptions activated in doStuff() body only.
 *    -- Expected Behaviour: A BlockException should be thrown from the body. No further exceptions should be thrown or suppressed.
 *    	 Stream should be CLOSED after try/catch exits, due to Auto closure.
 *    
 *    2: Exceptions activated in stream close() only.
 *    -- Expected Behaviour: A ClosingException should be thrown during automatic close(). No further exceptions should be thrown
 *    	 or suppressed.
 *    	 Stream should remain OPEN after try/catch exits, as Auto closure fails.
 *    
 *    3: Exceptions activated in both doStuff() body and stream close().
 *    -- Expected Behaviour: A BlockException and a ClosingException are both thrown during the try/catch. Using the new behaviour,
 *    	 the BlockException should be the one we catch, and the ClosingException should be first in it's list of SuppressedExceptions.
 *    	 Stream should remain OPEN after try/catch exits, as Auto closure fails.
 */

public class TryWithResources extends CoinTest {
	public TryWithResources() {
		setDebug(false); //If true, debug output will get printed out to System.out, and probably fail the test!
	}
	
	private void doTryWithResources() {
		
		//definitions[n] = new boolean[]{failInOpen?,failInBlock?,failInClose?};
		boolean[][] definitions =	{	
										{true,true,true}, //0. All 3
										{false,true,false}, //1. Block Only
										{false,false,true}, //2. Close Only
										{false,true,true}, //3. Block and Close
									};
		
		//expectedBehaviour[n] = new Object[]{ThrownClass,SuppressedClass,StreamOpenAtEnd?}
		Object[][] expectedBehaviour =	{
											{"InitialisingException",null,null},
											{"BlockException",null,false},
											{"ClosingException",null,true},
											{"BlockException","ClosingException",true},
									};
		
		assertEquals("Failure - Number of definitions does not match expected behaviour array", expectedBehaviour.length, definitions.length);
				
		for (int i=0; i<definitions.length; i++) {
			FakeStream outer = null;
			
			try (FakeStream f = new FakeStream(definitions[i])){
				outer = f;
				f.doStuff();
			} catch(Exception e){
				String caught = e.toString();
				String expected = (String)expectedBehaviour[i][0];
				printMessage("Caught a: "+caught);
				printMessage(", expected a "+expected+"\n");
				assertEquals("Unexpected exception caught.",expected,caught);
				
				String suppressed = null;
				
				if(e.getSuppressed().length > 0){
					suppressed = "";
					for(Throwable t : e.getSuppressed()) {
						suppressed += "," + t.toString();
					}
					suppressed = suppressed.substring(1);
				} 
				
				String suppressedExpected = (String)expectedBehaviour[i][1];
				
				assertEquals("Unexpected exception was suppressed.",suppressedExpected,suppressed);
				printMessage("It Suppressed: ");
				printMessage(suppressed+", ");
				printMessage("expected a "+suppressedExpected+"\n");
			} 
			
			printMessage("End of run, stream is still open?: ");
			Boolean isStillOpen;
			Boolean expectedOpen = (Boolean)expectedBehaviour[i][2];
			
			if(outer != null) { 
				isStillOpen = outer.isOpen();
				printMessage(outer.isOpen()+"\n");
				assertEquals("Stream found in unexpected open/close state.", expectedOpen, isStillOpen);
				printMessage("Should have been: "+expectedOpen+"\n");
				
			} else { //outer is null
				printMessage("Null stream reference, so it probably never opened.\n");
				if(expectedOpen == null) { 
					printMessage("Null stream was expected.\n"); 
				}
				assertEquals("Null stream not expected.", expectedOpen, null);
			}
			printMessage("\n");
		}
	}
	
	public void testTryWithResources() {
		doTryWithResources();
	}
	
	public static void main(String[] args){
		(new TryWithResources()).testTryWithResources();
	}
	
}

class FakeStream extends CoinTest implements AutoCloseable {
	
	private boolean isOpen = false;
	private boolean failToOpen = false;
	private boolean failInBlock = false;
	private boolean failToClose = false;
	
	public boolean isOpen() {
		return this.isOpen;
	}
	
	public FakeStream(boolean[] whereToFail) throws InitialisingException {
		this.failToOpen = whereToFail[0];
		this.failInBlock = whereToFail[1];
		this.failToClose = whereToFail[2];
		
		if (failToOpen){
			printMessage("Throwing an Init Exception\n");
			throwInitException();
		}
		this.isOpen = true;
		printMessage("Debug: Opened fake stream\n");
	}
	
	public void throwInitException() throws InitialisingException {
		throw new InitialisingException();
	}
	
	public void throwBlockException() throws BlockException {
		throw new BlockException();
	}
	
	public void throwClosingException() throws ClosingException {
		throw new ClosingException();
	}
	
	public int doStuff() throws Exception{
		if (failInBlock){
			printMessage("Throwing a Block Exception\n");
			throwBlockException();
		}
		printMessage("Doing 'stuff'...\n");
		return 1;
	}
	
	@Override
	public void close() throws Exception {
		if (failToClose) {
			printMessage("Throwing a Close Exception\n");
			throwClosingException();
		}
		printMessage("Closing..\n");
		this.isOpen = false;		
	}
	
}