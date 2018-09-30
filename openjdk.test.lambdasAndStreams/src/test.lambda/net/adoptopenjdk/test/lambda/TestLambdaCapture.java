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

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.support.CountryData;

/**
 * These tests run with different variations of object capture.
 * (This is when the lambda references an effectively final object for use during the lambda execution).
 * 
 * The general structure of each test is:
 *   o Create an effectively final object.
 *   o Define a lambda to capture the object.
 *   o Lose all other references to the object (where possible).
 *   o Run System.GC, to give GC the chance to remove the object.
 *   o Run the lambda, which will use the captured object.
 */
public class TestLambdaCapture extends TestCase {

	// Table of data for the test cases to use.
	private static String rawCityData = 
			  "China, Beijing, 20693000\n"
			+ "India, New Delhi, 17838842\n"
			+ "Japan, Tokyo, 13189000\n"
			+ "Russia, Moscow, 11541000\n"
			+ "South Korea, Seoul, 10528774\n"
			+ "Indonesia, Jakarta, 10187595\n"
			+ "Iran, Tehran, 9110347\n"
			+ "Mexico, Mexico City, 8851080\n"
			+ "Peru, Lima, 8481415\n"
			+ "Thailand, Bangkok, 8249117\n"
			+ "United Kingdom, London, 8174100\n"
			+ "Colombia, Bogota, 7613303\n"
			+ "Egypt, Cairo, 7438376\n"
			+ "Iraq, Baghdad, 7216040\n"
			+ "Bangladesh, Dhaka, 6080671\n"
			+ "Chile, Santiago, 5084038\n"
			+ "Ethiopia, Addis Ababa, 3040740";

	private static ArrayList<CountryData> staticCities;
	static { 
		String data = optimisationBarrier(rawCityData);
		staticCities = CountryData.parseCityData(data);
	}
	
	private static Function<String, String> staticFunction = (String type) -> staticCities.get(10).get(type);   
	
	// Runs a lambda which has captured a static object.
	@Test public void testCaptureStatic() {
		Predicate<Integer> predicate = (Integer x) -> staticCities.size() == x;
		
		System.gc();
		
		assertFalse(predicate.test(16));
		assertTrue(predicate.test(17));
		assertFalse(predicate.test(18));
	}

	// Runs a static lambda which has captured a static object.
	@Test public void testCaptureStaticLambda() {
		System.gc();
		
		assertEquals("United Kingdom", staticFunction.apply("Country"));
		assertEquals("London", staticFunction.apply("Capital"));
		assertEquals("8174100", staticFunction.apply("x"));
	}

	// Runs a lambda which has captured a complex object that was in scope at the time 
	// of lambda creation, but not when the lambda was executed.
	@Test public void testCaptureArrayList() {
		BiPredicate<Integer, Integer> biPredicate;
		if (System.currentTimeMillis() > 5) {
			// Always uses this branch
			String data2 = optimisationBarrier(rawCityData);
			ArrayList<CountryData> cities = CountryData.parseCityData(data2);
			biPredicate = (i, e) -> cities.get(i).getPopulation() == e;
		} else {
			biPredicate = (i, e) -> i == e;
		}
		
		System.gc();
		
		assertTrue(biPredicate.test(0, 20693000));  // China
		assertTrue(biPredicate.test(16, 3040740));  // Ethiopia
		assertFalse(biPredicate.test(3, 24));       // Japan
	}
	
	// Runs a lambda which has captured a field from an out of scope object.
	@Test public void testCaptureInstanceField() {
		// Create a lambda which captures the string holding the capital of Japan.
		Predicate<String> predicate;
		if (System.currentTimeMillis() > 5) {
			// Always uses this branch
			String data2 = optimisationBarrier(rawCityData);
			ArrayList<CountryData> cities = CountryData.parseCityData(data2);
			predicate = (x) -> cities.get(2).getCapital().equals(x);
		} else {
			predicate = (x) -> x != null;
		}
		
		System.gc();
		
		assertTrue(predicate.test("Tokyo"));
		assertFalse(predicate.test("Cairo"));
	}
	
	// Runs a lambda which has has been returned from a method call, which is capturing an object
	// that has itself been returned from another method call. 
	@Test public void testCaptureReturnedLambda() {
		// Create several lambdas, each of which capture a country object.
		Function<String, String> chile = createCountryFunction("Chile");
		Function<String, String> peru = createCountryFunction("Peru");
		Function<String, String> bangladesh = createCountryFunction("Bangladesh");
		
		System.gc();
		
		assertEquals("Chile", chile.apply("Country"));
		assertEquals("Santiago", chile.apply("Capital"));
		assertEquals("5084038", chile.apply("Population"));
		assertEquals(rawCityData, chile.apply("x"));
		
		assertEquals("Lima", peru.apply("Capital"));
		
		assertEquals("6080671", bangladesh.apply("Population"));
	}
	
	// Create a lambda which uses a captured object
	private Function<String, String> createCountryFunction(String forCountry) {
		// The return value from this method call is going to be captured 
		CountryData targetCountry = loadSpecificCountry(forCountry);

		return (String op) ->
			{
				if (op.equals("Country")) {
					return targetCountry.getCountry();
				} else if (op.equals("Capital")) {
					return targetCountry.getCapital();
				} else if (op.equals("Population")) { 
					return Long.toString(targetCountry.getPopulation());
				}
				return loadFixedData();
			};
	}

	private CountryData loadSpecificCountry(String targetCountry) {
		String loadedData = optimisationBarrier(rawCityData);
		ArrayList<CountryData> cities = CountryData.parseCityData(loadedData);
		
		// Find data for supplied country name
		for (CountryData city : cities) { 
			if (city.getCountry().equals(targetCountry)) { 
				return city;
			}
		}
		
		return null;
	}

	private String loadFixedData() { 
		return optimisationBarrier(rawCityData);
	}

	// Returns the supplied string. Implemented to prevent compile time optimizations.
	// This relies on the fact that the JVM has to allow the code to execute because it 
	// cannot know the time that the machine has been set to. 
	static private String optimisationBarrier(String startingString) {
		// Binary or the timestamp to make things a bit more complex
		long mungedTime = System.currentTimeMillis() | 0x0000006c98ba12efL;
		// Evaluates to 0 (until August 144683)
	 	long rotationQty = mungedTime & 0xfffff00000000000L;  

	 	// Bitshift every character in the starting string.
	 	// Will actually end up shifting 0 places, so nothing will be changed.
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<startingString.length(); i++) {
			char c = startingString.charAt(i);
			sb.append(Character.toChars(c >>> rotationQty));
		}
		
		return sb.toString();
	}
}
