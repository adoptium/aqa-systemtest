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
/**
 * File:    AtomicTestObject
 * Package: net.adoptopenjdk.test.concurrent.support
 */

package net.adoptopenjdk.test.concurrent.support;

/**
 * A simple test object wrapping ints, longs and Strings for manipulation by
 * testcases in the java.util.concurrent.atomic area.
 */

public class AtomicTestObject 
{

	public volatile int volatileInt = 42;
	public volatile long volatileLong = 42L;
	public volatile String volatileString = "the answer";
	
	private int nonVolatileInt = 42;
	private long nonVolatileLong = 42L;
	private volatile String nonVolatileString = "THE ANSWER";
	
	public AtomicTestObject(){}
	
	public void setVolatileInt(int newValue)
	{
		volatileInt = newValue;
	}
	
	public void setVolatileLong(long newValue)
	{
		volatileLong = newValue;
	}
	
	public int getVolatileInt()
	{
		return volatileInt;
	}
	
	public long getVolatileLong()
	{
		return volatileLong;
	}

	public String getNonVolatileString() 
	{
		return nonVolatileString;
	}
	
	public void setNonVolatileInt(int newValue)
	{
		nonVolatileInt = newValue;
	}
	
	public void setNonVolatileLong(long newValue)
	{
		nonVolatileLong = newValue;
	}
	
	public int getNonVolatileInt()
	{
		return nonVolatileInt;
	}
	
	public long getNonVolatileLong()
	{
		return nonVolatileLong;
	}
	
	public void setNonVolatileString(String newValue)
	{
		nonVolatileString = newValue;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof AtomicTestObject)
		{
			AtomicTestObject ato = (AtomicTestObject)o;
			return(volatileInt == ato.getVolatileInt() && volatileLong == ato.getVolatileLong()
						&& nonVolatileInt == ato.getNonVolatileInt() && nonVolatileLong == ato.getNonVolatileLong());
		}
		
		return false;		
	}
	
	public String toString()
	{
		return "AtomicTestObject[" + volatileInt + "|" + nonVolatileInt + "|" + volatileLong + "|" + nonVolatileLong + "]";
	}
}
