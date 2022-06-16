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

package net.adoptopenjdk.test.streams.support;

import java.util.ArrayList;

/**
 * Harbour class is intended to create test objects for the TestStreamOperations tests for Java 8
 */
public class Harbour {

	private String name;
	private String initials;
	private int berths;
	private double harbourRates;
	private boolean harbourOperator;
	private double depth;
	private boolean marinas;
	private ArrayList<KeelBoat> registeredBoats = new ArrayList<KeelBoat>();

	public Harbour(String name, String initials, int berths, double harbourRates, boolean harbourOperator, double depth, boolean marinas) {
		super();
		this.name = name;
		this.initials = initials;
		this.berths = berths;
		this.harbourRates = harbourRates;
		this.harbourOperator = harbourOperator;
		this.depth = depth;
		this.marinas = marinas;
	}

	public String getName() {
		return name;
	}
	
	public String getInitials() {
		return initials;
	}

	public int getBerths() {
		return berths;
	}

	public double getHarbourRates() {
		return harbourRates;
	}

	public boolean getHarbourOperator() {
		return harbourOperator;
	}

	public double getDepth() {
		return depth;
	}

	public boolean getMarinas() {
		return marinas;
	}

	public ArrayList<KeelBoat> getRegisteredBoats() {
		return registeredBoats;
	}
	
	public void addRegisteredBoat(KeelBoat newBoat) {
		 registeredBoats.add(newBoat);
		 newBoat.setHarbour(this);
	}
	
	public double calcHarbourDues(KeelBoat newBoat) {
		int length = newBoat.getLength();		
		double dues = harbourRates * length;
		return dues;
	}
}
