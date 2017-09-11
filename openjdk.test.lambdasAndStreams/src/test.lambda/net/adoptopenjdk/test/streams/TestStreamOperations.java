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

package net.adoptopenjdk.test.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.TestCase;
import net.adoptopenjdk.test.streams.support.Harbour;
import net.adoptopenjdk.test.streams.support.KeelBoat;

/**
 * Intermediate stream operations unit tests
 * 
 * The testcases provided here are designed to test some of the most common intermediate operations that 
 * can be done in a stream. For each of the intermediate operations listed below a simple testcase is provided.  
 * o distinct() returns a stream in which only the unique elements in the stream are returned.
 * o filter() returns a stream where only elements that match the condition of the filter are returned.
 * o map() returns a stream that is the result of applying a function to all elements in the stream.
 * o flatMap() applies a one-to-many transformation to the elements of the stream, and then flattens the 
 *   resulting elements into a new stream. 
 * o limit() returns a stream with all elements in the original stream but stops after [n]
 * o skip() is used to ignore the first two and only the third is returned.
 * o sorted() returns the elements of a stream but sorted. This can be specified according to a provided
 *   Comparator.
 */
public class TestStreamOperations extends TestCase {
	
	// Two ArrayLists will be input as streams in the following testcases.
	// One stream will contain KeelBoat objects and the other stream will contain 
	// Harbour objects, all KeelBoats will belong to a harbour..

	ArrayList<KeelBoat> boats = new ArrayList<KeelBoat>();
	ArrayList<Harbour> harbours = new ArrayList<Harbour>();
	
	Harbour hamble   = new Harbour("Hamble",   "HB", 350, 1.5,  true,  4.0, true);
	Harbour itchen   = new Harbour("Itchen",   "IT", 200, 1.25, false, 3.5, true);
	Harbour cowes    = new Harbour("Cowes",    "CW", 350, 1.8,  true,  4.6, true);
	Harbour newTown  = new Harbour("NewTown",  "NT",  30, 0.8,  false, 3.4, false);
	Harbour plymouth = new Harbour("Plymouth", "PL", 750, 1.0,  true,  6.1, true);
	
	// Sets up all the boats and harbours for the test.
	// The below setUp() will run before each test is executed.
	public void setUp() throws Exception {
				
		hamble.addRegisteredBoat(new KeelBoat("Polly",             "Impala",         28, 1.8,  "DavidThomas",     1979, 5.8));
		hamble.addRegisteredBoat(new KeelBoat("FestinaLente",      "Sigma38",        38, 2.0,  "DavidThomas",     1985, 6.7));
		hamble.addRegisteredBoat(new KeelBoat("Vela",              "Sigma38",        33, 1.75, "DavidThomas",     1978, 6.2));
		hamble.addRegisteredBoat(new KeelBoat("Alan",              "J80",            26, 1.5,  "RodJohnstone",    1992, 5.8));
		hamble.addRegisteredBoat(new KeelBoat("FlyingFish",        "Laser28",        28, 1.52, "BruceFarr",       1984, 6  ));
		hamble.addRegisteredBoat(new KeelBoat("Merry",             "707",            23, 1.5,  "DavidThomas",     1995, 5.4));
		hamble.addRegisteredBoat(new KeelBoat("WeeBear",           "Projection920",  30, 2.5,  "StephenThomas",   1997, 5.7));
		
		itchen.addRegisteredBoat(new KeelBoat("Sigmagician",       "Sigma38",        38, 2.0,  "DavidThomas",     1985, 6.7));
		itchen.addRegisteredBoat(new KeelBoat("RedDragon",         "Contessa32",     32, 1.7,  "JeremyRogers",    1971, 5  ));
		itchen.addRegisteredBoat(new KeelBoat("Jeckle",            "Dehler34",       34, 2.01, "E.G.VanDerStadt", 1983, 5.5));
		itchen.addRegisteredBoat(new KeelBoat("Snappy",            "Snapdragon23",   23, 1.5,  "ThamesMarine",    1962, 4.7));
		itchen.addRegisteredBoat(new KeelBoat("Athena",            "Athena38",       38, 1.07, "Flahault",        1994, 5 ));
		itchen.addRegisteredBoat(new KeelBoat("Glen",              "HalbergRassy94", 28, 1.2,  "Halberg",         1995, 4.9));
		itchen.addRegisteredBoat(new KeelBoat("WithAlacrity",      "Sigma38",        38, 2.0,  "DavidThomas",     1985, 6.7));		
		
		cowes.addRegisteredBoat(new KeelBoat("Imptish",            "Impala",         28, 1.8,  "DavidThomas",     1979, 5.7));
		cowes.addRegisteredBoat(new KeelBoat("Dave",               "J80",            26, 1.5,  "RodJohnstone",    1992, 5.8));
		cowes.addRegisteredBoat(new KeelBoat("FlyingSquid",        "Laser28",        28, 1.52, "BruceFarr",       1984, 6  ));
		cowes.addRegisteredBoat(new KeelBoat("Christmas",          "707",            23, 1.5,  "DavidThomas",     1995, 5.4));		
		cowes.addRegisteredBoat(new KeelBoat("WeePiggy",           "Projection920",  30, 2.5,  "StephenThomas",   1997, 5.2));
		cowes.addRegisteredBoat(new KeelBoat("Croc",               "Snapdragon23",   23, 1.5,  "ThamesMarine",    1968, 4.6));
		
		newTown.addRegisteredBoat(new KeelBoat("Hide",             "Dehler34",       34, 2.0,  "E.G.VanDerStadt", 1984, 5.6));
		newTown.addRegisteredBoat(new KeelBoat("Ampress",          "Elan38",         38, 1.7,  "RobHumphreys",    1996, 4.9));
		newTown.addRegisteredBoat(new KeelBoat("Eternal",          "Elan38",         38, 1.7,  "RobHumphreys",    1996, 4.9));
		newTown.addRegisteredBoat(new KeelBoat("Snapper",          "Snapdragon28",   28, 1.7,  "ThamesMarine",    1982, 4.8));
		newTown.addRegisteredBoat(new KeelBoat("ACoupleOfWellies", "Athena38",       38, 1.0,  "Flahault",        1998, 5.7));
		
		plymouth.addRegisteredBoat(new KeelBoat("Duncan",          "HalbergRassy94", 28, 1.2,  "Halberg",         1997, 4.9));
		plymouth.addRegisteredBoat(new KeelBoat("Bear",            "Sigma33",        33, 2.0,  "DavidThomas",     1979, 5.5));
		plymouth.addRegisteredBoat(new KeelBoat("2Frank",          "Impala",         28, 1.8,  "DavidThomas",     1982, 5.2));
		plymouth.addRegisteredBoat(new KeelBoat("Bob",             "J80",            26, 1.5,  "RodJohnstone",    1995, 5.8));

		boats.addAll(hamble.getRegisteredBoats());
		boats.addAll(itchen.getRegisteredBoats());
		boats.addAll(cowes.getRegisteredBoats());
		boats.addAll(newTown.getRegisteredBoats());
		boats.addAll(plymouth.getRegisteredBoats());
		
		harbours.add(hamble);
		harbours.add(itchen);
		harbours.add(cowes);
		harbours.add(newTown);
		harbours.add(plymouth);
	}
	
	// Distinct intermediate operation
	// 
	// distinct() returns a stream in which only the unique elements in the stream are returned. 
	// Two streams used to extract boats with length 28, one in which .distinct() is used and therefore
	//  all non-unique elements are excluded and a single value is returned.
	public void testStreamDistinct() {
		// Initial run with no distinct
		List<Integer> boatsWithNoDistinct = boats.stream()
				.filter(b -> b.getLength() == 28)
				.map(KeelBoat::getLength)
				.collect(Collectors.toList());
		checkListInteger(new Integer[]{28,28,28,28,28,28,28,28}, boatsWithNoDistinct);
		
		// Redo but now with a distinct
		List<Integer> distinctBoat =  boats.stream()
				.filter(b -> b.getLength() == 28)
				.map(KeelBoat::getLength)
				.distinct()
				.collect(Collectors.toList());
		checkListInteger(new Integer[]{28}, distinctBoat);
	}
	
	private void checkListInteger(Integer[] expected, List<Integer> actual) {
		assertEquals(actual.toString(), expected.length, actual.size());
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual.get(i));
		}
	}
	
	// Filter intermediate operation
	// 
	// filter() returns a stream where only elements that match the condition of the filter are 
	// returned.
	// Boats are filtered according to three fields
	public void testStreamsFilter() {
		List<String> findBoatsByDT = (List<String>) boats.stream()
				.filter(b -> b.getDraft() >= 2.0)
				.filter(b -> b.getDesigner().equals("DavidThomas"))
				.filter(b -> b.getLength() <= 40)
				.map(KeelBoat::getName)
				.collect(Collectors.toList());
		checkList(new String[]{"FestinaLente", "Sigmagician", "WithAlacrity", "Bear"}, findBoatsByDT);
	}
		
	// Map intermediate operation
	// 
	// map() returns a stream that is the result of applying a function to all elements in the stream.
	// map is used below to extract the value of the HarbourDues field from all of the harbour objects.
	public void testStreamsMap() {
		List<Double> harbourDuesList = (List<Double>) harbours.stream()
			.map(Harbour::getHarbourRates)
			.collect(Collectors.toList());
		checkList(new Double[]{1.5, 1.25, 1.8, 0.8, 1.0}, harbourDuesList);
	}
	
	// FlatMap intermediate operation
	// 
	// flatMap() applies a one-to-many transformation to the elements of the stream, and then flattens 
	// the resulting elements into a new stream. 
	// Streams of each harbour were combined and flattened to produce a new stream.
	public void testStreamsFlatMap() {
		Stream<List<KeelBoat>> harboursListStream = Stream.of(
				hamble.getRegisteredBoats(),
				itchen.getRegisteredBoats(),
				cowes.getRegisteredBoats()
				);
		
		List<String> harbourStream = harboursListStream
				.flatMap((harbourList) -> harbourList.stream())
				.filter(h -> h.getLength() == 28)
				.map(KeelBoat::getName)
				.collect(Collectors.toList());
		checkList(new String[]{"Polly", "FlyingFish", "Glen", "Imptish", "FlyingSquid"}, harbourStream);
	}
	
	// Limit intermediate operation
	// 
	// limit() returns a stream with all elements in the original stream but stops after [n]
	// Two streams are used to get harbours where harbourMaster is true, in the second this number of 
	// harbours returned is limited to two.
	//
	// Initial run with no limit
	public void testStreamsLimit() {
		List<String> harboursWithHarbourMasters = (List<String>) harbours.stream()
				.filter(h -> h.getHarbourMaster() == true)
				.map(Harbour::getName)
				.collect(Collectors.toList());
		checkList(new String[]{"Hamble", "Cowes", "Plymouth"}, harboursWithHarbourMasters);
		// Redo but now with a limit of 2
		List<String> harboursWithHarbourMastersLimit = (List<String>) harbours.stream()
				.filter(h -> h.getHarbourMaster() == true)
				.map(Harbour::getName)
				.limit(2)
				.collect(Collectors.toList());
		checkList(new String[]{"Hamble", "Cowes"}, harboursWithHarbourMastersLimit);
	}
	
	// Skip intermediate operation
	// 
	// skip() returns a stream with all the elements in the original stream but with the first [n] removed.
	// Two streams are used to find the names of boats by a certain designer, the second stream .skip() 
	// is used to ignore the first two and only the third is returned.
	//
	// Initial run with no skip
	public void testStreamsSkip() {
		List<String> firstTwoBoats = (List<String>) boats.stream()
				.filter(b -> b.getDesigner().equals("RodJohnstone"))
				.map(KeelBoat::getName)
				.collect(Collectors.toList());
		checkList(new String[]{"Alan", "Dave", "Bob"}, firstTwoBoats);
		// Redo but now with the first 2 skipped
		List<String> skipFirstTwoBoats = (List<String>) boats.stream()
				.filter(b -> b.getDesigner().equals("RodJohnstone"))
				.skip(2)
				.map(KeelBoat::getName)
				.collect(Collectors.toList());
		checkList(new String[]{"Bob"}, skipFirstTwoBoats);
	}
	
	// Sorted intermediate operation
	// 
	// sorted() returns the elements of a stream but sorted. This can be specified according to a provided
	// Comparator.
	// Two streams are used to get the names of boats in the stream, the second steam is sorted (alphabetically).	
	//
	// Initial run with no sorting
	public void testStreamsSort() {
		List<String> noSortBoatsLimit5 = (List<String>) boats.stream()
				.map(KeelBoat::getName)
				.limit(3)
				.collect(Collectors.toList());
		checkList(new String[]{"Polly", "FestinaLente", "Vela"}, noSortBoatsLimit5);
		// Redo but now with sorting	
		List<String> sortBoatsLimit5 = (List<String>) boats.stream()
				.map(KeelBoat::getName)
				.sorted()
				.limit(3)
				.collect(Collectors.toList());
		checkList(new String[]{"2Frank", "ACoupleOfWellies", "Alan"}, sortBoatsLimit5);
	}
	
	// Terminal Streams operations unit tests
	// 
	// o reduce()- reduce all the elements in a stream to a single value. e.g. the sum of all elements
	// o collect()- put all the elements of this stream into a new collection
	// o findFirst()- return the first element in a stream that matches some condition
	// o count()- counts all the elements in the stream 
		 
	// Reduce terminal operation
	// 
	// reduce()- reduce all the elements in a stream to a single value. e.g. the sum of all elements
	//  A stream of harbours is input and the sum of all the berths from all harbours is returned
	public void testStreamsReduce() {
		int totalBerthsAllHarbours = harbours.stream()
				.map(Harbour::getBerths)
				.reduce(0, Integer::sum);
		assertEquals(1680, totalBerthsAllHarbours);
	}
	
	// Collect terminal operation
	// 
	// collect()- put all the elements of this stream into a new collection
	// The initials from all harbours in a harbour stream are returned into a collections list.
	//
	public void testStreamsCollect() {
		List<String> getHarbourInitials = harbours.stream()
				.map(Harbour::getInitials)
				.collect(Collectors.toList());
		checkList(new String[]{"HB", "IT", "CW", "NT", "PL"}, getHarbourInitials);
	}
	
	// FindFirst terminal operation
	// 
	// findFirst()- return the first element in a stream that matches some condition
	// A stream of boats is input and filtered according to type Impala, the stream is then mapped to the
	// boat name and terminated by findFirst. Only the first impala will be returned.
	public void testStreamsFindFirst() {
		Optional<String> findFirstImpalaName = boats.stream()
					.filter(b -> b.getType().equals("Impala"))
					.map(KeelBoat::getName)
					.findFirst();
		assertEquals("Polly", findFirstImpalaName.get());
	}

	// Count terminal operation
	// 
	// count()- counts all the elements in the stream 
	// A stream of boats is input and a count of all boats beginning with "A" is returned as a long
	public void testStreamsCount() {
		long countAllBoatsStartA = boats.stream()
				.filter(b -> b.getName().startsWith("A"))
				.count();
		assertEquals(4, countAllBoatsStartA);
	}
				
	// More complex example- lots of intermediate operations are combined to creating one unit test
	// 
	// Return harbour dues for harbours with > 300 berths with a depth of >= 3.5, while skipping the first 
	// two and limiting to the first 5.
	public void testStreamsCalc() {
		List<Double> returnDues = (List<Double>) harbours.stream()
				.filter(h -> h.getBerths() > 300)
				.filter(h -> h.getDepth() >= 3.5)
				.map(Harbour::getRegisteredBoats)
				.flatMap(boats -> boats.stream())
				.skip(2)
				.map(b -> b.getHarbour().calcHarbourDues(b))
				.limit(5)
				.collect(Collectors.toList());
		checkList(new Double[]{49.5, 39.0, 42.0, 34.5, 45.0}, returnDues);
	}

	// More complex example- lots of intermediate operations are combined to creating one unit test
	// 
	// Return the combined harbour dues of all the boats in the Itchen.
	public void testStreamsSum() {
		Double sumHarbourDuesItchen = boats.stream()
				.filter(b -> b.getHarbour().equals(itchen))
				.map(b -> b.getHarbour().calcHarbourDues(b))
				.reduce((double) 0, Double::sum);
		assertEquals(288.75, sumHarbourDuesItchen);
	}

	// More complex example- lots of intermediate operations are combined to creating one unit test
	// 
	// Sort boats according to name alphabetically skip, limit and then skip, filter with endsWith an "n"
	// and then reduce to all one long String.
	public void testStreamsSortReduce() {
		String boatNamesSorted = boats.stream()
				.map(KeelBoat::getName)
				.sorted()
				.skip(1)
				.limit(30)
				.skip(2)
				.filter(b -> b.endsWith("n"))
				.reduce("", (a, b) -> a + b);
		assertEquals("DuncanGlenRedDragonSigmagician", boatNamesSorted);
	}

	// More complex example- lots of intermediate operations are combined to creating one unit test
	// 
	// Boats stream is filtered repeatedly until no boat object is left within the stream. The stream is then 
	// mapped to the boat name and reduced. An empty string is returned.
	public void testStreamsEmpty() {
		String emptyStringResult = boats.stream()
				.filter(b -> b.getBuildYear() >= 1971)
				.filter(b -> b.getHarbour().equals(newTown))
				.filter(b -> b.getTopSpeed() >= 6.0)
				.filter(b -> b.getLength() == 33)
				.map(KeelBoat::getName)
				.reduce("", (a, b) -> a + b);
		assertEquals("", emptyStringResult);
	}
	
	private void checkList(Object[] expected, List<?> actual) {
		assertEquals(actual.toString(), expected.length, actual.size());
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual.get(i));
		}
	}
}
