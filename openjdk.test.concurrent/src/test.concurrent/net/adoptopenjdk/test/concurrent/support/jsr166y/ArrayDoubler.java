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

package net.adoptopenjdk.test.concurrent.support.jsr166y;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ArrayDoubler extends RecursiveAction
{
	private static final long serialVersionUID = 9834L;

	private final int MAX_ELEMENTS_TO_PROCESS = 10;
	
	private int[] array = null;
	private int startValue = -1;
	private int endValue = -1;		

	public ArrayDoubler(int[] arrayIn, int startValueIn, int endValueIn)
	{
		array = arrayIn;
		startValue = startValueIn;
		endValue = endValueIn;
	}
	
	protected void compute() 
	{
		if(endValue - startValue > MAX_ELEMENTS_TO_PROCESS)			// If there are too many elements to process in one operation...
		{
			if(ForkJoinTask.inForkJoinPool())						// ... and if we are in a ForkJoinPool ...
			{
				int halfWay = (endValue + startValue) / 2;
				invokeAll(new ArrayDoubler(array, startValue, halfWay), new ArrayDoubler(array, halfWay, endValue));
				return;
			}
		}
		
		for(int i = startValue; i < endValue; i++)					// If we aren't in a ForkJoinPool or if there are not a large number of elements to be processed
		{
			array[i] = array[i] * 2;
		}
	}		
}
