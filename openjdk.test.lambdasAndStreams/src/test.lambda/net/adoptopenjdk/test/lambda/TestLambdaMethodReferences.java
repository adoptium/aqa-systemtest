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

package net.adoptopenjdk.test.lambda;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.TestLambdaMethodReferences.NameExtractor;
import net.adoptopenjdk.test.lambda.support.Person;
import net.adoptopenjdk.test.lambda.support.Person.NameDetails;
import net.adoptopenjdk.test.lambda.support.Person.Title;

import org.junit.Test;

/**
 * These tests are for Lambda method references.
 * They are for cases in which instead of providing a lambda body they refer 
 * to an existing method by name.
 * For example:
 *   Function<String, String> upperfier = String::toUpperCase;
 * 
 * The main method reference variations tested here are:
 *  - static method, ClassName::methodName
 *  - method on particular object, instanceRef::methodName
 *  - super method of a particular object, 'super'::methodName
 *  - method on arbitrary object, ClassName::methodName
 *  - class constructor reference, ClassName::new
 *  - Array constructor reference, TypeName[]:new
 */

// Super class for this test.
// Added so test code can call methods in its superclass.
class TestCaseSuperClass {
	String getTypeString() { 
		return "super class of LambaMethodReferenceTest"; 
	}
};

class TestCaseSubclass extends TestCaseSuperClass {
	String getTypeString() { 
		return "sub class of LambaMethodReferenceTest"; 
	}

	public String getSuperTypeString() {
		// Run lambda which includes a 'super' reference
		NameExtractor nameExtractor = super::getTypeString;
		return nameExtractor.name();
	}
}

public class TestLambdaMethodReferences extends TestCase {

	Person BillBloggs = new Person(Title.MR, "Bill", "Bloggs", 82);
	Person JohnSmith  = new Person(Title.HRH, "John", "Smith", 47);
	
	public interface LambdaCounter
	{
		int count();
	}

	public interface TitleSelector
	{
		Person.Title find();
	}

	public interface NameExtractor
	{
		String name();
	}

	public interface PersonNameExtractor
	{
		String name(Person person);
	}

	public interface NameDetailsExtractor
	{
		String name(Person.NameDetails name);
	}

	public interface GenericNameExtractor<T, R>
	{
		R name(T t1);
	}

	// Method added to verify that correct super method is being called.
	String getTypeString() { 
		return "??"; 
	}	

	static int numCoupleTitlePermutations() {
		return Person.numAvailableTitles() * Person.numAvailableTitles();
	}
	
	// Static method reference.
	// 
	// Uses a static method which belongs to the current class. 
	// Method syntax tested is: ClassName::StaticMethodName 
	@Test public void testLocalStaticMethod() {
		LambdaCounter counter = TestLambdaMethodReferences::numCoupleTitlePermutations;
		assertEquals(81, counter.count());
	}

	// Static method reference.
	// 
	// Uses a static method from another class. 
	// Method syntax tested is: ClassName::StaticMethodName 
	@Test public void testClassStaticMethod() {
		LambdaCounter counter = Person::numAvailableTitles;
		assertEquals(9, counter.count());
	}

	// Static method reference.
	// 
	// Use a static method which takes an object parameter.
	// Method syntax tested is: ClassName::StaticMethodName 
	@Test public void testClassStaticMethodWithArgs() {
		GenericNameExtractor<Person, String> extractor = Person::getNameFromPerson;
		
		assertEquals("Person name: MR Bill Bloggs", extractor.name(BillBloggs));
		assertEquals("Person name: HRH John Smith", extractor.name(JohnSmith));
	}

	// Static method reference.
	// 
	// Use a static method from an inner class.
	// Method syntax tested is: OuterClassName.InnerClass::StaticMethodName 
	@Test public void testInnerClassStaticMethod() {
		NameExtractor extractor = Person.NameDetails::getMostPopularName;
		
		assertEquals("John Smith", extractor.name());
	}
 
	// Instance method of a particular object.
	//  
	// Simplest case. Call a method on a known object.
	// Method syntax tested is: InstanceRef::MethodName 
	@Test public void testInstanceMethodReference() {
		NameExtractor firstName = BillBloggs::getName;
		assertEquals("MR Bill Bloggs", firstName.name());
	}
	
	// Instance method of a particular object.
	// 
	// As before, but this time the invoked method has a different return type.
	// Method syntax tested is: InstanceRef::MethodName 
	@Test public void testInstanceMethodReference2() {
		TitleSelector selector = JohnSmith::getTitle;
		assertEquals(Title.HRH, selector.find());
	}
	
	// Instance method of a particular object.
	// 
	// This test verifies the lambda call to a method in the superclass of an object instance. 
	// Method syntax tested is: InstanceRef::SuperMethodName 
	@Test public void testInstanceMethodSuperMethodReference() { 
		NameExtractor nameExtractor = BillBloggs::getCategory;
		assertEquals("UNKNOWN-Bloggs", nameExtractor.name());

		nameExtractor = JohnSmith::getCategory;
		assertEquals("UNKNOWN-Smith", nameExtractor.name());
	}
 
	// Instance method of a particular object.
	// 
	// Test that the lambda can call an instance method of an inner class.
	// Method syntax tested is: InstanceRef::MethodName 
	@Test public void testInnerClassInstanceMethodReference() {
		NameDetails name = new Person.NameDetails("David", "Napier");

		NameExtractor nameExtractor = name::getSurname;	
				
		assertEquals("Napier", nameExtractor.name());
	}
 
	// Instance method of a particular object.
	// 
	// Test that the lambda can call an instance method of an inner class, in which 
	// the instance object is created inline.
	// Method syntax tested is: InstanceRef::MethodName 
	@Test public void testInsitueInnerClassInstanceMethodReference() {
		NameExtractor nameExtractor = new Person.NameDetails("David", "Napier")::getSurname;	

		assertEquals("Napier", nameExtractor.name());
	}

	// Method reference to a super class.
	// 
	// In this test the lambda calls a super class method. 
	// Method syntax tested is: 'super'::SuperMethodName 
	@Test public void testSuperMethodReference() { 
		String superTypeString = new TestCaseSubclass().getSuperTypeString();
		assertEquals("super class of LambaMethodReferenceTest", superTypeString);
	}

	// Instance method of an arbitrary object.
	// 
	// Test a lambda which calls the getName() method of an arbitrary object.
	// Method syntax tested is: ClassName::MethodName 
	@Test public void testInstanceMethodOfArbitraryObject() { 
		PersonNameExtractor extractor = Person::getName;
		
		assertEquals("MR Bill Bloggs", extractor.name(BillBloggs));
		assertEquals("HRH John Smith", extractor.name(JohnSmith));
	}

	// Instance method of an arbitrary object.
	// 
	// Test a lambda which calls the getName() method of an arbitrary object.
	// Method syntax tested is: OuterClassName.InnerClassName::MethodName 
	@Test public void testInnerClassInstanceMethodOfArbitraryObject() { 
		NameDetails name1 = new Person.NameDetails("Victoria", "Drummond");
		NameDetails name2 = new Person.NameDetails("Charles", "Macintosh");

		NameDetailsExtractor nameExtractor = Person.NameDetails::getFirstName;	
				
		assertEquals("Victoria", nameExtractor.name(name1));
		assertEquals("Charles", nameExtractor.name(name2));
	}
	
	// Instance method of an arbitrary object.
	// 
	// Test a lambda which calls the getName() method of an arbitrary object.
	// Method syntax tested is: OuterClassName.InnerClassName::MethodName 
	@Test public void testInnerClassInstanceMethodOfArbitraryObjectWithGenerics() { 
		NameDetails name1 = new Person.NameDetails("John", "Dunlop");

		GenericNameExtractor<Person.NameDetails, String> nameExtractor = Person.NameDetails::getFullName;	
				
		assertEquals("John Dunlop", nameExtractor.name(name1));
	}
	
	interface PersonFactory {
		Person create();
	}
	
	// Class constructor reference.
	// 
	// Create Lambda which calls a no parameter class constructor.
	// Method syntax tested is: ClassName::new 
	@Test public void testConstructorReference() {
		PersonFactory factory = Person::new;
		
		Person person1 = factory.create();
		Person person2 = factory.create();
		assertTrue(person1 != person2);
		assertTrue(person1.getSerialNumber() + ":" + person2.getSerialNumber(), person1.getSerialNumber() != person2.getSerialNumber());
		
		assertEquals("null NoFirstName NoSecondName", person1.getName());
	}
	
	interface GenericFactory<T1, T2, T3, T4, R> {
		R create(T1 t1, T2 t2, T3 t3, T4 t4);
	}
	
	// Class constructor reference.
	// 
	// Create Lambda which calls a multi-parameter class constructor using generics.
	// Method syntax tested is: ClassName::new 
	@Test public void testConstructorReferenceUsingGenerics() {
		GenericFactory<Person.Title, String, String, Integer, Person> factory = Person::new;
		
		Person person1 = factory.create(Title.DR, "David", "Livingstone", 60);
		Person person2 = factory.create(Title.MR, "James", "Watt", 83);
		
		assertEquals("DR David Livingstone", person1.getName());
		assertEquals("MR James Watt", person2.getName());
	}

	// Class constructor reference.
	// 
	// Create Lambda whose constructor call relies on auto-boxing.
	// Method syntax tested is: ClassName::new 
	@Test public void testConstructorReferenceUsingGenericsWithBoxing() {
		GenericFactory<Person.Title, String, String, Integer, Person> factory = Person::new;
		
		Person person1 = factory.create(Title.MR, "Adam", "Smith", new Integer(67));
		
		assertEquals("MR Adam Smith", person1.getName());
		assertEquals(67, person1.getAge());
	}
	
	interface NameFactory<T1, T2> {
		NameDetails create(T1 t1, T2 t2);
	}

	// Class constructor reference.
	//	 
	// Create Lambda whose constructor call relies on auto-boxing.
	// Method syntax tested is: OuterClassName.InnerClassName::new 
	@Test public void testConstructorReferenceForInnerClass() {
		NameFactory<String, String> factory = Person.NameDetails::new;
		
		NameDetails name = factory.create("Thomas", "Telford");
		
		assertEquals("Thomas Telford", name.getFullName());
	}

	// Class constructor reference.
	// 
	// Create Lambda which calls a multi-parameter class constructor using generics.
	// Method syntax tested is: ClassName::new 
	@Test public void testInnerClassConstructorReferenceUsingGenerics() {
		GenericFactory<String, String, String, String, Person.NameDetails> factory = Person.NameDetails::new;
		
		NameDetails name1 = factory.create("Margaret", "Macintosh", "Macdonald", "Maggie");
		NameDetails name2 = factory.create("James", "Watt", null, null);
		
		assertEquals("Margaret", name1.getFirstName());
		assertEquals("James", name2.getFirstName());
	}
	
	interface PersonArrayFactory {
		Person[] create(int num);
	}
	
	// Array constructor reference.
	// 
	// Create Lambda which creates an array of objects.
	// Method syntax tested is: TypeName[]::new 
	@Test public void testArrayConstructorReference() {
		PersonArrayFactory factory = Person[]::new;

		// Create array
		// This does create an array but all of the entries are null!
		// There must surely be a way, as otherwise this doesn't seem too useful.
		Person[] people = factory.create(12);

		assertNotNull(people);
	}
}
