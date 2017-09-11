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
 * MultiCatchPreciseRethrow
 * ========================
 * 
 * Java70 allows you to catch multiple exceptions in a single catch block, by using the | operator. In addition, if you set up
 * a generic 'catch-all' at the end of a catch block to catch "Exception ex" and rethrow it using throw(ex), Java70 will now
 * consider what exceptions can possibly be thrown from the try block and rethrow with the most specific class possible (lud).
 * It will exclude those that are explicitly caught.
 * 
 * 1. multiCatch() / testMultiCatch():
 * -  Sets up one single catch block to catch 'ThirdOnes', and a multi-catch block to catch 'FirstOnes or SecondOnes'. Verifies 
 * that we end up in the right catch block after throwing each exception type.
 * 
 * 2. preciseRethrow() / testPreciseRethrow():
 * -  Situated in preciseRethrow(), the try block of the inner try/catch contains an if statement that throws a "FirstOne" if true, 
 * and a "SecondOne" if false. The first inner catch block explicitly catches a "FirstOne", whilst the second inner catch block does a
 * blanket catch-all for "Exception", and immediately rethrows it. 
 * 
 * -  Situated in testPreciseRethrow(), the outer try/catch block catches ALL throwables rethrown from the inner block, and determines
 * their type. 
 * 
 * -  Before Java70, this type would always be "Exception" for this code. In fact - this file would fail to compile, as we state that 
 * "preciseRethrow(boolean selector) throws SecondOne", and pre-Java70 compilers would actually throw the wider "Exception".
 * 
 * -  Java70 determines that our try block has the ability to throw either FirstOnes, which are already explicitly caught and handled,
 * or SecondOnes, which are not. It deduces that instead of rethrowing an Exception, the most precise exception it can rethrow is in
 * fact a "SecondOne".
 * 
 * 3. multiAndPrecise() / testMultiAndPrecise():
 * -  Combination of 1 and 2. We make sure rethrow logic correctly works when there are multi-catch statements within the catch block.
 */

public class MultiCatchPreciseRethrow extends CoinTest {
	public MultiCatchPreciseRethrow() {
		setDebug(false); //If true, debug output will get printed out to System.out, and probably fail the test!
	}
	
	private void multiCatch(int selector) {
		boolean firstOrSecondSet = false;
		boolean thirdSet = false;
		boolean foundFirstTwo = false;
		boolean foundThird = false;
		
		try {
			if(selector == 0){
				firstOrSecondSet = true;
				throw new FirstOne();
			}
			else if(selector == 1){
				firstOrSecondSet = true;
				throw new SecondOne();
			}
			else if(selector == 2){
				thirdSet = true;
				throw new ThirdOne();
			}
		} catch (FirstOne|SecondOne e) {			
			if ((e instanceof FirstOne)^(e instanceof SecondOne)){
				foundFirstTwo = true;
				printMessage("Found a "+e.toString()+" in multi catch.\n");
			}
		} catch (ThirdOne e) {
			foundThird = true;
			printMessage("Found a "+e.toString()+" in single catch.\n");
		}
		
		if(firstOrSecondSet == true){
			assertTrue("Throw FirstOne or SecondOne and multicatch: ",foundFirstTwo);
		}
		if(thirdSet == true){
			assertTrue("Throw ThirdOne and singlecatch: ", foundThird);
		}
	}
	
	public void testMultiCatch() {
		multiCatch(0);
		multiCatch(1);
		multiCatch(2);
	}
	
	private void preciseRethrow(boolean selector) throws SecondOne {	
		try {
			if(selector == true){
				throw new FirstOne();
			}
			else if(selector == false) {
				throw new SecondOne();
			}

		} catch (FirstOne e) {
			printMessage("Caught "+e.toString());
		} catch (Exception ex){ //Blanket Catch-All For Anything that isnt a "FirstOne"
			printMessage("Caught a plain old exception, "+ex.toString()+"\n");
			printMessage("Rethrowing it.\n");
			throw ex;
		}
		catch (Throwable t) {}
	}
	
	public void testPreciseRethrow() {
		try {preciseRethrow(false);}
		catch (Throwable e) { 
			assertTrue("Rethrow Exception as a SecondOne:",(e instanceof SecondOne));
			printMessage("Caught rethrown exception as a SecondOne.\n");
		}
	}
	
	private void multiAndPrecise(int selector) throws ThirdOne{
		try {
			if(selector == 0){
				throw new FirstOne();
			}
			else if(selector == 1) {
				throw new SecondOne();
			}
			else if(selector == 2) {
				throw new ThirdOne();
			}

		} catch (FirstOne|SecondOne e) {
			printMessage("Caught "+e.toString());
		} catch (Exception ex){ //Blanket Catch-All For Anything that isnt a "FirstOne" or a "Secondone".
			printMessage("Caught a plain old exception, "+ex.toString()+"\n");
			printMessage("Rethrowing it.\n");
			throw ex;
		}
		catch (Throwable t) {}
	}
	
	public void testMultiAndPrecise() {
		try {multiAndPrecise(2);}
		catch (Throwable e) { 
			assertTrue("Rethrow Exception as a ThirdOne:",(e instanceof ThirdOne));
			printMessage("Caught rethrown exception as a ThirdOne.\n");
		}
	}
	
	public static void main(String[] args) {
		MultiCatchPreciseRethrow mcpr = new MultiCatchPreciseRethrow();
		mcpr.testMultiAndPrecise();
		mcpr.testMultiCatch();
		mcpr.testPreciseRethrow();
	}
}
