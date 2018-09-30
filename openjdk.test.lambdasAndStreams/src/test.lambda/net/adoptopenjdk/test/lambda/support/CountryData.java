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

package net.adoptopenjdk.test.lambda.support;

import java.util.ArrayList;

/**
 * This class is used for Lambda testing. 
 * It holds key statistics for a country.
 */
public class CountryData {
	private String country;
	private String capital;
	private long population;
	
	public CountryData(String country, String capital, String population) {
		super();
		this.country = country.trim();
		this.capital = capital.trim();
		this.population = Long.parseLong(population.trim());
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	public long getPopulation() {
		return population;
	}
	
	public String get(String type) {
		if (type.equals("Country")) { 
			return country;
		} else if (type.equals("Capital")) { 
			return capital;
		} else {
			return Long.toString(population);
		}
	}
	
	@Override
	public String toString() {
		return country + " " + capital + " " + population;
	}
	
	// Create 'CityData' objects from a string.
	// Input : cityData is a String containing one line for each city.
	// The method returns an ArrayList of CityData objects.
	public static ArrayList<CountryData> parseCityData(String cityData) {
		ArrayList<CountryData> cities = new ArrayList<CountryData>();
		
		String[] lines = cityData.split("\n");
		for (String l : lines) {
			String[] fields = l.split(",");
			CountryData newCity = new CountryData(fields[0], fields[1], fields[2]);
			cities.add(newCity);
		}
		
		return cities;
	}
}
