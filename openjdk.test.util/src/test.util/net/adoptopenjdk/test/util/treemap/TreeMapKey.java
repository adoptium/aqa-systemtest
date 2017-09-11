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
 * File:    TreeMapKey.java
 * Package: net.adoptopenjdk.test.util.treemap
 */
   
package net.adoptopenjdk.test.util.treemap;

public class TreeMapKey implements Comparable<Object> {

	private TreeMapKeyComparator comparator;
	private int value;
	
	public TreeMapKey(int value)
	{
		this.value = value;
		comparator = new TreeMapKeyComparator();
	}

	public void reverseComparison()
	{
		comparator.reverse();
	}
	
	public int compareTo(Object o) {
		return comparator.compare(this, o);
	}
	
	public int getValue() {
		return value;
	}
}
