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
 * File:    TreeMapKeyComparator.java
 * Package: net.adoptopenjdk.test.util.treemap
 */
   
package net.adoptopenjdk.test.util.treemap;

import java.util.Comparator;

public class TreeMapKeyComparator implements Comparator<Object> {
	
	private int reverse_factor = 1;

	public int compare(Object t1, Object t2) {
		/*
		 * Cast both objects to TreeMapKeys, get the values
		 * and use default Integer comparator
		 */
		return reverse_factor * (new Integer(((TreeMapKey)t1).getValue()).compareTo(
				new Integer(((TreeMapKey)t2).getValue())));
	}

	public void reverse() {
		reverse_factor = -1;
	}
}
