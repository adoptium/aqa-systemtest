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

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import org.junit.Test;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.support.Person;
import net.adoptopenjdk.test.lambda.support.Person.Title;

/**
 * This test verifies that lambdas can survive been serialized. 
 * Each lambda is executed after being de-serialized to verify that 
 * it still produces the expected result.
 * 
 * This test serializes lambdas which:
 *   o Reference a static method
 *   o References an instance method. eg. string-instance::trim
 *   o Reference a method on the super class. eg, super::toString
 *   o Reference a 'this' method. eg, this::toString
 *   o Reference a class method. eg. String::toUpperCase
 *   o Reference a class constructor. eg, HashMap<String, Font>::new
 *   o Are application defined, with a significant chunk of code and captured objects.
 *   
 * Also:
 *   o Adds serializable to a lambda through a runtime cast (intersection of types).
 *     For example:
 *        lambda = (Function & Serializable) String::toUpperCase; 
 */
public class TestLambdaSerialization extends TestCase implements Serializable {
	private static final long serialVersionUID = 234679322L;

	interface SerialisableHashMap {
	    HashMap<String, Font> convert();
	}
	
	// Define some functional interfaces used by the tests
	interface SerialisableFunction<T,R> extends Function<T,R>, Serializable {
	}

	interface SerialisableSupplier<T> extends Supplier<T>, Serializable {
	}

	interface SerialisableIntSupplier extends IntSupplier, Serializable {
	}
	
	public interface NameExtractor extends Serializable
	{
		String name();
	}

	// Mini class hierarchy for testing super references.
	class TestCaseSuperClass implements Serializable {
		private static final long serialVersionUID = 6526345L;
		
		String getTypeString() { 
			return "super class of TestCaseSubclass"; 
		}
	};
	class TestCaseSubclass extends TestCaseSuperClass implements Serializable {
		private static final long serialVersionUID = -23449L;

		String getTypeDetails() { 
			return "sub class of TestCaseSuperClass"; 
		}

		public NameExtractor getSuperTypeString() {
			// Run lambda which includes a 'super' reference
			return super::getTypeString;
		}
	}
	
	// Test that a lambda which references a static method works after being 
	// serialized and then deserialized.
	// i.e. Person::numAvailableTitles
	@Test public void testStaticMethodReference() throws Exception {
		for (int i=0;i<100; i++) {
			// Create a lambda and push it through the serialization and deserialization cycle
			SerialisableIntSupplier initialLambda = Person::numAvailableTitles;
			SerialisableIntSupplier recreatedLambda = (SerialisableIntSupplier) serialiseOutAndIn(initialLambda);
		
			// Used the recreated lambda
			assertEquals(9, recreatedLambda.getAsInt());
		}
	}
	
	// Test that a lambda which references an instance method works after being 
	// serialized and then deserialized.
	// i.e. string-instance::trim
	@SuppressWarnings("unchecked")
	@Test public void testInstanceMethodReference() throws Exception {
		// Create a lambda and push it through the serialization and deserialization cycle
		SerialisableSupplier<String> initialLambda1 = "  Padded String   "::trim;
		SerialisableSupplier<String> initialLambda2 = "  "::trim;
		
		// Push the lambdas through the serialization and deserialization cycle
		SerialisableSupplier<String> recreatedLambda1 = (SerialisableSupplier<String>) serialiseOutAndIn(initialLambda1);
		SerialisableSupplier<String> recreatedLambda2 = (SerialisableSupplier<String>) serialiseOutAndIn(initialLambda2);

		assertEquals("Padded String", recreatedLambda1.get());
		assertEquals("", recreatedLambda2.get());
	}
	
	// Lambda which references an instance method of one of the test classes.
	// i.e. person::getSurnameWithCounter
	@Test public void testInstanceMethodReference2() throws Exception {
		NameExtractor initialLambda;
		{
			Person.NameDetails person = new Person.NameDetails("David", "Napier");
			initialLambda = person::getSurnameWithCounter;
		}
		NameExtractor recreatedLambda = (NameExtractor) serialiseOutAndIn(initialLambda);

		// Used the recreated lambda. Called more than once to be sure that its really running
		System.gc(); // Give GC a change to get rid of the original object
		assertEquals("1:Napier", recreatedLambda.name());
		assertEquals("2:Napier", recreatedLambda.name());
		assertEquals("3:Napier", recreatedLambda.name());
	}
	
	// Test that a lambda which references a super method works after being 
	// serialized and then deserialized.
	// i.e. super::getTypeString
	@Test public void testSuperMethodReference() throws Exception {
		// Create a lambda and push it through the serialization and deserialization cycle
		NameExtractor initialLambda = new TestCaseSubclass().getSuperTypeString();
		NameExtractor recreatedLambda = (NameExtractor) serialiseOutAndIn(initialLambda);

		assertEquals("super class of TestCaseSubclass", recreatedLambda.name());
	}

	// Test that a lambda which references a 'this' method works after being 
	// serialized and then deserialized.
	// i.e. this::toString
	@Test public void testThisMethodReference() throws Exception {
		// Create a lambda and push it through the serialization and deserialization cycle
		NameExtractor initialLambda = this::toString;
		NameExtractor recreatedLambda = (NameExtractor) serialiseOutAndIn(initialLambda);

		assertEquals("TestLambdaserialization", recreatedLambda.name());
	}

	// Test that a lambda which references a class method works after being 
	// serialized and then deserialized.
	// i.e. String::toUpperCase
	@Test public void testClassMethodReference() throws Exception {
		// Create a lambda and push it through the serialization and deserialization cycle
		// Note that this code is also 
		Function<String, String> initialLambda = (Function<String, String> & Serializable) String::toUpperCase;
		@SuppressWarnings("unchecked")
		Function<String, String> recreatedLambda = (Function<String, String>) serialiseOutAndIn(initialLambda);
		
		// Used the recreated lambda
		assertEquals("SAMPLESTRING", recreatedLambda.apply("SampleString"));
		assertEquals("WAS_LOWER_CASE", recreatedLambda.apply("was_lower_case"));
	}
	
	// Test that a lambda which references a constructor works after being 
	// serialized and then deserialized.
	// i.e. HashMap::new
	@Test public void testClassConstructorReference() throws Exception {
		// Create a lambda and push it through the serialization and deserialization cycle
		SerialisableHashMap initialLambda = (SerialisableHashMap & Serializable) HashMap<String, Font>::new;
		SerialisableHashMap recreatedLambda = (SerialisableHashMap) serialiseOutAndIn(initialLambda);

    	// Used the recreated lambda to create a new hash map
        HashMap<String, Font> newHashMap = recreatedLambda.convert();
        assertEquals(HashMap.class, newHashMap.getClass());
        assertEquals(0, newHashMap.size());
    }

	// Create some objects which can be captured by a serialized lambda
	// Uses different variations of static and final make sure these work.
	Person explorer1 = new Person(Title.MR, "Ernest", "Shackleton", 23);
	Person explorer2 = new Person(Title.CAPTAIN, "James", "Cook", 43);
	static final Person explorer3 = new Person(Title.MR, "Christopher", "Columbus", 23);
	static Person explorer4 = new Person(Title.MR, "John", "Franklin", 23);
	final Person explorer5 = new Person(Title.SIR, "Ranulph", "Fiennes", 23);
	
	public interface StringCreator extends Serializable
	{
		String createString(Random random);
	}
	public interface PersonExtractor extends Serializable
	{
		Person get(int index);
	}
	public interface PersonQuery extends Serializable
	{
		String fetch(Person person);
	}

	// Serializes and runs a lambda with these features:
	//   o Significant chunk of code in the lambda body.
	//   o Lambda captures other objects.
	//   o A captured and serialized object itself contains a lambda (Person.getName())
	//   o Execution of the lambda runs nested lambdas to make things more complicated.
	//   
	// This code generates random strings based on the contents of some 'Person' objects. 
	// Because it's generating different strings each time the expected value is constructed 
	// with conventional non-lambda code.
	// The test only passes if the lambda can go through the serialization cycle and 
	// produce the same result as the normal java code.
	@Test public void testLambdaWithLogic() throws Exception {
		for (int loop=0; loop<25; loop++) { 
			long startTime = System.currentTimeMillis();
			String seedDescription = "Seed " + startTime + ":" + loop + "  ";
			long seed = startTime + loop;
			Random rand = new Random(seed);
		
			// Create a lambda which does the real work
			StringCreator initialLambda = (random) -> {
				ArrayList<Person> explorers = new ArrayList<Person>();
				explorers.add(explorer1);
				explorers.add(explorer2);
				explorers.add(explorer3);
				explorers.add(explorer4);
				explorers.add(explorer5);
				
				// Create some more lambdas. This means that:
				//   1) The serialized lambda itself contains serialized lambdas
				//   2) Uses more lambdas. Not strictly necessary but a good feature for a lambda test.
				PersonExtractor accessPerson = (i) -> { return explorers.get(i); };
				PersonQuery getFirstName = Person::getFirstName; 
				PersonQuery getSecondName = (person) -> { return person.getSurname(); }; 
				PersonQuery getFullName = (person) -> { return person.toString(); };
				
				StringBuilder result = new StringBuilder(seedDescription);
				
				int numIter = random.nextInt(1000);
				for (int iter=0; iter<numIter; iter++) {
					int victimIndex = random.nextInt(explorers.size());
					Person victim = accessPerson.get(victimIndex);
				
					switch (random.nextInt(4)) {
					case 0:
						result.append(getFirstName.fetch(victim));
						break;
					case 1:
						result.append(getSecondName.fetch(victim));
						break;
					case 2:
						result.append(getFullName.fetch(victim));
						break;
					case 3:
						result.append("...");
						break;
					}
					result.append(" - ");
				}
				
				return result.toString();
			};

			// Put the above lambda through a serialization cycle
			StringCreator recreatedLambda = (StringCreator) serialiseOutAndIn(initialLambda);
			
			// Make sure lambda calculated result matches that produced by conventional code.
			String lambdaResult = recreatedLambda.createString(rand);
			String expectedResult = buildExpectedString(seed, seedDescription);
			assertEquals(expectedResult, lambdaResult);
		}
    }

	// Uses conventional code to work out what string should be built from a seed number
	private String buildExpectedString(long seed, String seedDescription) {
		Random random = new Random(seed);
		
		// Create a lambda and push it through the serialization and deserialization cycle
		Person[] explorers = new Person[] { explorer1, explorer2, explorer3, explorer4, explorer5 };
	
		StringBuilder result = new StringBuilder(seedDescription);
		
		int numIter = random.nextInt(1000);
		for (int iter=0; iter<numIter; iter++) {
			int victimIndex = random.nextInt(explorers.length);
			Person victim = explorers[victimIndex];
		
			switch (random.nextInt(4)) {
			case 0:
				result.append(victim.getFirstName());
				break;
			case 1:
				result.append(victim.getSurname());
				break;
			case 2:
				result.append(victim.getName());
				break;
			case 3:
				result.append("...");
				break;
			}
			result.append(" - ");
		}
		
		return result.toString();
	}

	// Test class for transient case
	private static class Beaufort implements Serializable {
		private static final long serialVersionUID = 2341114432L;
		
		private int min;
		private int max;
		transient public String name;  // ** Note: transient field **
		
		public Beaufort(int min, int max, String name) {
			this.min = min;
			this.max = max;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Beaufort [min=" + min + ", max=" + max + ", name=" + name + "]";
		}
	}
	
	// Test that a lambda which references a super method works after being 
	// serialized and then deserialized.
	// i.e. super::getTypeString
	@Test public void testTransient() throws Exception {
		// Create an object with a transient field
		Beaufort force2 = new Beaufort(4, 6, "Light breeze");
		
		// Create a lambda and push it through the serialization and deserialization cycle
		Supplier<String> originalLambda = (Supplier<String> & Serializable) () -> { return force2.toString(); };
		@SuppressWarnings("unchecked")
		Supplier<String> recreatedLambda = (Supplier<String>) serialiseOutAndIn(originalLambda);

		// There should be a null for serialized transient fields
		assertEquals("Beaufort [min=4, max=6, name=Light breeze]", originalLambda.get());
		assertEquals("Beaufort [min=4, max=6, name=null]", recreatedLambda.get());
		
		// Update the transient value. 
		// Non serialized lambda should see the new value, but the serialized lambda 
		// should have only have access to its locked in null field value.
		force2.name = "LIGHT";
		assertEquals("Beaufort [min=4, max=6, name=LIGHT]", originalLambda.get());
		assertEquals("Beaufort [min=4, max=6, name=null]", recreatedLambda.get());
	}

	// Does round trip serialization. 
	// Serializes the supplied object and returns the recreated version.  
	private Object serialiseOutAndIn(Object startingObject) throws IOException, ClassNotFoundException { 
        byte[] objectData = writeObject(startingObject);
        byte[] obfuscatedData = obfuscate(objectData);
        Object recreatedObject = readObject(obfuscatedData);
		return recreatedObject;
	}
	
	// Convert an object to its serialized form
	private byte[] writeObject(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
		out.writeObject(object);
        out.close();
		return baos.toByteArray();
	}

	// Manipulate the data for a serialized object to prevent jit optimization from
	// being able to circumvent the serialization code.
	// This method actually returns the same data as supplied.
	private byte[] obfuscate(byte[] objectData) {
		byte[] output = new byte[objectData.length];
		
		// Force construction of a value which is equal to 255 (FF in hex)
		long timeMunge = System.currentTimeMillis() ^ 0b0000000000000000000000000000000111110101001010101000010011101101L;
		byte ff = (byte) (timeMunge > 1000000 ? 0b11111111 : 0b01010101);
		
		for (int i=0; i<objectData.length; i++) {
			output[i] = (byte) (objectData[i] & ff);
		}
		
		return output;
	}
	
	// Recreate an object from a byte stream
    static Object readObject(byte[] baos)  throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos));

        Object o = in.readObject();
        
        in.close();

        return o;
    }
    
    @Override
    public String toString() {
    	return "TestLambdaserialization";
    }
}
