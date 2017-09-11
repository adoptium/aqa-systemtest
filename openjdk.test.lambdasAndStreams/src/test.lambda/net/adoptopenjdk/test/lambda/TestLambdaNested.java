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

package net.adoptopenjdk.test.lambda;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This test verifies that a nested lambda works correctly.
 * 
 * It has the characteristics of:
 *   1) Using nested lambdas, in which an executing lambda runs another lambda.
 *   2) Using an unusually large and complex lambda.
 */
public class TestLambdaNested extends TestCase {
	private boolean debug = false;

	// Run the algorithm multiple times. Once for each entry in the table.
	// This table contains the correct result and the corresponding seed value.
	String[][] runs = {
		{ "=F$", "0" },
		{ "@*=", "1" },
		{ "JW@", "2" },
		{ "IZ(", "3" },
		{ "@UA", "4" },
		{ "#N%", "2323948" },
		{ "=#=", "34" },
		{ "@WA", "9834" },
		{ "(EX", "-232322" },
		{ "&S#", "9888" },
		{ "(I*", "234982348" },
		{ "&^=", "985448" },
		{ "Z$E", "-323423" },
		{ "LG@", "1111" },
		{ "WMA", "2120929292" },
		{ "VGT", "938388" },
		{ "XEA", "34767" },
		{ "(Q=", "388910" },
		{ "R*I", "500047" },
		{ "SE(", "254355" },
		{ "KET", "3426" },
		{ "VXQ", "2192832" },
		{ "(=I", "-3242" },
		{ "K$#", "-25906324" },
		{ "H*W", "-3453453454444" },
		{ "$C%", "32459930602" },
		{ "#D!", "385456" },
		{ "N=#", "98568893" },
		{ "R@D", "-92385" },
		{ "A=B", "-345855" },
		{ "@ES", "-79435985" },
		{ "SMZ", "-2343442" },
		{ "!=X", "-685271900" },
		{ "S@B", "-23432" },
		{ "NMU", "546456" },
		{ "=RD", "98200892" },
		{ "ZPI", "964020026" },
		{ "YVI", "43599393" },
		{ "WJ(", "45728766" },
		{ "$H%", "9927837" },
		{ "*MM", "345674" },
		{ "IQP", "3568" },
		{ "L!%", "994567" },
		{ "SV^", "54699" },
		{ "Y=T", "76575675671" },
		{ "WJ&", "5633839899937" },
		{ "JLL", "345983450984598" },
		{ "W^B", "554546677898" },
		{ "=(O", "454553005686" },
		{ "OIM", "65767547" },
		{ "=NA", "657676757" },
		{ "^FV", "722766" },
		{ "@M=", "8567837" },
		{ "BX=", "-3454354" },
		{ "#%L", "-435111365" },
		{ "$EL", "-943568" },
		{ "ZJ^", "-499" },
		{ "#^A", "-32476575675671" },
		{ "WDT", "-546566548937" },
		{ "NG#", "2354784554598" },
		{ "BVM", "555467898" },
		{ "RH=", "987889953005686" },
		{ "@@R", "27767587" },
		{ "*ZR", "988446773433" }
	};
	
	// Define the characters which the lambda treats as 'special'.
	// Note that this HashSet gets captured by the lambda.
	public static LinkedHashSet<Character> specials = new LinkedHashSet<>();
	static {
		specials.add('!');
		specials.add('@');
		specials.add('#');
		specials.add('$');
		specials.add('%');
		specials.add('^');
		specials.add('&');
		specials.add('*');
		specials.add('(');
		specials.add(')');
	}

	// Create some static predicates, so that multiple threads will access them
	static Predicate<Character> isLower = (c) -> c >= 'a' && c <= 'z';
	static Predicate<Character> isUpper = (c) -> c >= 'A' && c <= 'Z';
	static Predicate<Character> isDigit = (c) -> c >= '0' && c <= '9';

	// Most lambdas are very small so this test uses a large chunk of code for its lambda.
	// This includes:
	//   o definition and use of inner lambdas
	//   o variable capture of class level fields
	//   o for loops
	//   o if statements
	//   o Some use of standard class libraries - HashSet and Random.
	//      
	// The lambda processes a string, replacing each pair of characters with a 
	// single output character. The 2 for 1 replacement uses a series of verbose steps
	// to decide what output character to create. 
	//
	@Test public void testNestedLamba() {
		// Run through the standard list of seeds, and verify that the expected 
		// result is produced.
		for (String[] runData : runs) {
			String expected = runData[0];
			long seed = Long.parseLong(runData[1]);
			assertEquals(expected, runNestedLambda(seed));
		}
		
		// The fixed list of seeds will create a fixed set of paths through the code, so
		// make sure the jit can't remove any paths by running with a random seed.
		// We can't know the expected result in advance but run it twice to make sure the 
		// result is at least consistent.
		long randomSeed = System.currentTimeMillis();
		String result1 = runNestedLambda(randomSeed);
		String result2 = runNestedLambda(randomSeed);
		assertEquals(result1, result2);
	}

	// Functional interface. 
	// To accept a string and return a smaller one.
	interface Condenser {
		String squash(String input);
	}
	
	// Real logic for test.
	// Runs in a big lambda.
	private String runNestedLambda(final long seed) {
		Condenser condenser = (String input) -> {
			Random r = new Random(seed * -1);
			StringBuffer buff = new StringBuffer();
			
			for (int i = 0; i< input.length()-1; ) {
				// Pull out the next 2 characters 
				Character c1 = input.charAt(i);
				Character c2 = input.charAt(i+1);
				
				// Categorize the next 2 characters
				boolean c1IsLower = isLower.test(c1);
				boolean c2IsLower = isLower.test(c2);
				boolean c1IsUpper = isUpper.test(c1);
				boolean c2IsUpper = isUpper.test(c2);
				boolean c1IsDigit = isDigit.test(c1);
				boolean c2IsDigit = isDigit.test(c2);
				
				// Create and use predicate for special characters ( '!' to ')')
				// Captures content of static hash set
				Predicate<Character> isSpecial = (c) -> specials.contains(c) & !isLower.test(c) & !isUpper.test(c) & !isDigit.test(c);
				boolean c1IsSpecial = isSpecial.test(c1);
				boolean c2IsSpecial = isSpecial.test(c2);

				// Build operators to squash 2 characters down to 1
				BinaryOperator<Character> minOp = (a,b) -> { if (a<b) return a; else return b; };
				BinaryOperator<Character> maxOp = (a,b) -> { if (a>b) return a; else return b; };
				BinaryOperator<Character> first = (a,b) -> { return a; };
				BinaryOperator<Character> second = (a,b) -> { return b; };
				BinaryOperator<Character> average = (a,b) -> { return (char) ((a+b) / 2); };
				BinaryOperator<Character> random = (a,b) -> { if (r.nextInt(100) < 50) return a; else return b; };

				// Magical combinations convert to a special character
				String combined = new StringBuffer().append(c1).append(c2).toString();
				Character output = ' ';
				switch (combined) {
				case "AA": output = '!'; break;
				case "BB": output = '@'; break;
				case "CC": output = '#'; break;
				case "DD": output = '$'; break;
				case "EE": output = '%'; break;
				case "FF": output = '^'; break;
				case "GG": output = '&'; break;
				case "HH": output = '*'; break;
				case "II": output = '('; break;
				}
				
				// Convert some more combinations using bulkier(?) if statements
				if (c1.equals('A') && c2.equals('B')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('A') && c2.equals('C')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('A') && c2.equals('I')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('A') && c2.equals('H')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('A') && c2.equals('D')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('A') && c2.equals('Q')) {
					output = ' '; 
				} else if (c1.equals('B') && c2.equals('F')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('B') && c2.equals('U')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('B') && c2.equals('T')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('B') && c2.equals('E')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('B') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('B') && c2.equals('G')) {
					output = ' '; 
				} else if (c1.equals('C') && c2.equals('B')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('C') && c2.equals('E')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('C') && c2.equals('X')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('C') && c2.equals('O')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('C') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('C') && c2.equals('H')) {
					output = ' '; 
				} else if (c1.equals('D') && c2.equals('P')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('D') && c2.equals('N')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('D') && c2.equals('I')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('D') && c2.equals('C')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('D') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('D') && c2.equals('P')) {
					output = ' '; 
				} else if (c1.equals('E') && c2.equals('Y')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('E') && c2.equals('G')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('E') && c2.equals('C')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('E') && c2.equals('R')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('E') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('E') && c2.equals('L')) {
					output = ' '; 
				} else if (c1.equals('F') && c2.equals('N')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('F') && c2.equals('E')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('F') && c2.equals('U')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('F') && c2.equals('I')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('F') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('F') && c2.equals('D')) {
					output = ' '; 
				} else if (c1.equals('G') && c2.equals('H')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('G') && c2.equals('T')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('G') && c2.equals('K')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('G') && c2.equals('X')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('G') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('G') && c2.equals('B')) {
					output = ' '; 
				} else if (c1.equals('H') && c2.equals('M')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('H') && c2.equals('W')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('H') && c2.equals('V')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('H') && c2.equals('P')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('H') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('H') && c2.equals('E')) {
					output = ' '; 
				} else if (c1.equals('I') && c2.equals('T')) {
					output = minOp.apply(c1, c2);  
				} else if (c1.equals('I') && c2.equals('A')) {
					output = maxOp.apply(c1, c2);  
				} else if (c1.equals('I') && c2.equals('J')) {
					output = first.apply(c1, c2);  
				} else if (c1.equals('I') && c2.equals('B')) {
					output = second.apply(c1, c2);  
				} else if (c1.equals('I') && c2.equals('Q')) {
					output = random.apply(c1, c2); 
				} else if (c1.equals('I') && c2.equals('X')) {
					output = ' '; 
				}
				
				if (debug) System.out.print(c1 + c2 + ": ");

				// If the character 1 & 2 did not match a magical combination then apply 
				// a lambda to squash them down to a single character.
				// The lambda used depends on the types of c1 and c2.
				if (output == ' ') {
					if (c1IsLower && c2IsLower) {
						output = minOp.apply(c1, c2);  
						if (debug) System.out.println("Lower Lower");
	 				} else if (c1IsLower && c2IsUpper) {
						output = second.apply(c1, c2);  
						if (debug) System.out.println("Lower Upper");
	 				} else if (c1IsLower && c2IsDigit) { 
						output = first.apply(c1, c2);  
						if (debug) System.out.println("Lower Digit");
	 				} else if (c1IsUpper && c2IsLower) { 
						output = first.apply(c1, c2);  
						if (debug) System.out.println("Upper Lower");
	 				} else if (c1IsUpper && c2IsUpper) { 
						output = random.apply(c1, c2);  
						if (debug) System.out.println("Upper Upper");
	 				} else if (c1IsUpper && c2IsDigit) { 
						output = first.apply(c1, c2);  
						if (debug) System.out.println("Upper Digit");
	 				} else if (c1IsDigit && c2IsLower) { 
						output = second.apply(c1, c2);  
						if (debug) System.out.println("Digit Lower");
	 				} else if (c1IsDigit && c2IsUpper) { 
						output = second.apply(c1, c2);  
						if (debug) System.out.println("Digit Upper");
	 				} else if (c1IsDigit && c2IsDigit) { 
						output = average.apply(c1, c2);  
						if (debug) System.out.println("Digit Digit");
	 				} else if (c1 == '=' || c2 == '=') {
	 					output = '=';
	 					if (debug) System.out.println("==");
	 				} else if (c1IsSpecial && !c2IsSpecial) {
	 					output = first.apply(c1, c2);
	 					if (debug) System.out.println("Special non");
	 				} else if (!c1IsSpecial && c2IsSpecial) {
	 					output = second.apply(c1, c2);
	 					if (debug) System.out.println("non Special");
	 				} else if (c1IsSpecial && c2IsSpecial) {
	 					output = '=';
	 					if (debug) System.out.println("Special Special");
	 				} else { 
	 					throw new IllegalStateException("Failed to match any pairing for: " + c1 + "," + c2);
	 				}
				}
 
				if (debug) {
					System.out.print(" => " + output);
					System.out.println();
				}
				
				buff.append(output);
				
				i += 2;
			}
			
			return buff.toString();
		}; // end lambda

		// Create a random starting string
		String randomString = createRandomString(400, seed);

		if (debug) System.out.println("RandomSeed: " + seed);
		
		// Repeatedly squash the random string until it can no longer be halved
		if (debug) System.out.println(randomString);
		while (randomString.length() > 3) {
			randomString = condenser.squash(randomString);
			if (debug) System.out.println(randomString);
		}

		return randomString;
	}

	private String createRandomString(int length, long seed) {
		Random rnd = new Random(seed);
		StringBuffer buff = new StringBuffer();
		for (int j=0; j<length; j++) {
			char c = ' ';
			switch (rnd.nextInt(3)) {
			case 0: c = Character.toChars(48 + rnd.nextInt(10))[0]; break;  // output a digit
			case 1: c = Character.toChars(65 + rnd.nextInt(26))[0]; break;  // output upper case character
			case 2: c = Character.toChars(97 + rnd.nextInt(26))[0]; break;  // output lower case character
			}
			buff.append(c);
		}
		
		return buff.toString();
	}
}
   