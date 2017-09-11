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
 * File:    CustomValue.java
 * Package: net.adoptopenjdk.test.util.hashtable
 */
   
package net.adoptopenjdk.test.util.hashtable;

import java.io.Serializable;

public class CustomValue implements Serializable {
	
	private static final long serialVersionUID = 255876091377590187L;
	public Object key;

	public CustomValue(Object key)
	{
		this.key = key;
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof CustomValue))
		{
			return false;
		}
		if (!(key.getClass().equals(((CustomValue)o).key.getClass())))
		{
			return false;
		}
		return key.equals(((CustomValue)o).key);
	}
	
	public String toString()
	{
		return "CustomValue wrapping " + key;
	}
}
