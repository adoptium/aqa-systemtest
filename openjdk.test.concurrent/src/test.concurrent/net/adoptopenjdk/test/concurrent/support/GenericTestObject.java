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
/**
 * File:    GenericTestObject
 * Package: net.adoptopenjdk.test.concurrent.support
 */

package net.adoptopenjdk.test.concurrent.support;

/**
 * A simple test object for use in testcases that test the behaviour of collections.
 * The object wraps a number of datatypes, is comparable and implements an equals method.
 */

public class GenericTestObject implements Comparable<GenericTestObject>
{
	
	String 		stringData 		= "";
	Integer 	integerData		= 0;
	double		doubleData		= 0.0;
	boolean		booleanData		= false;
	Long		longData		= System.nanoTime();
	
	public GenericTestObject(String stringIn, Integer integerIn, double doubleIn, long longIn, boolean booleanIn)
	{
		stringData = stringIn;
		integerData = integerIn;
		doubleData = doubleIn;
		longData = longIn;
		booleanData = booleanIn;
	}
	
	public String getStringData() {
		return stringData;
	}

	public void setStringData(String stringDataIn) {
		stringData = stringDataIn;
	}

	public Integer getIntegerData() {
		return integerData;
	}

	public void setIntegerData(Integer integerDataIn) {
		integerData = integerDataIn;
	}

	public double getDoubleData() {
		return doubleData;
	}

	public void setLongData(long longDataIn) {
		longData = longDataIn;
	}

	public Long getLongData() {
		return longData;
	}
	
	public void setDoubleData(double doubleDataIn) {
		doubleData = doubleDataIn;
	}

	public boolean isBooleanData() {
		return booleanData;
	}

	public void setBooleanData(boolean booleanDataIn) {
		booleanData = booleanDataIn;
	}
	
	public int compareTo(GenericTestObject o) {
		if(stringData.compareTo(o.getStringData()) != 0)
		{
			return stringData.compareTo(o.getStringData());
		}
		else if(integerData.compareTo(o.getIntegerData()) != 0)
		{
			return integerData.compareTo(o.getIntegerData());
		}
		else
		{
			return longData.compareTo(o.getLongData());
		}
			
	}
		
	@Override
	public boolean equals(Object other)
	{
		if(! (other instanceof GenericTestObject))
			return false;
		
		GenericTestObject otherObject = (GenericTestObject) other;
		
		if(!otherObject.getStringData().equals(this.getStringData()))
			return false;
		
		if(otherObject.getDoubleData() != this.getDoubleData())
			return false;
		
		if(otherObject.getIntegerData().intValue() != this.getIntegerData().intValue())
			return false;
		
		if(otherObject.isBooleanData() != this.isBooleanData())
			return false;
		
		if(otherObject.getLongData() != this.getLongData())
			return false;
			
		return true;
	}

}
