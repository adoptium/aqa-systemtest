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

/**
 * KeelBoat class is intended to create test objects for the TestStreamOperations tests for Java 8
 */
public class KeelBoat {
	
	private String name;
	private String type;
	private int length;
	private double draft;
	private String designer;
	private int buildYear;
	private double topSpeed;
	private Harbour harbour;
	
	public KeelBoat(String name, String type, int length, double draft, String designer, int buildYear, double topSpeed) {
		super();
		this.name = name;
		this.type = type;
		this.length = length;
		this.draft = draft;
		this.designer = designer;
		this.buildYear = buildYear;
		this.topSpeed = topSpeed;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public double getDraft() {
		return draft;
	}

	public String getDesigner() {
		return designer;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public Harbour getHarbour() {
		return harbour;
	}

	public void setHarbour(Harbour harbour) {
		this.harbour = harbour;
	}
}
