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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;

/**
 * ArrayMaximumTask is a ForkJoinTask for submission into a ForkJoinPool. Similar to ArraySummationTask but this task simply finds and records the largest value contained in
 * the array portion being scanned. A single result is obtained by comparing the result of two subtasks whenever these are spawned.
 */
public class ArrayMaximumTask extends ForkJoinTask<Integer>
{
	private static final long serialVersionUID = -4777883690926970804L;
	
	private final int MAX_ELEMENTS_TO_PROCESS = 100;
	private Integer result = new Integer(0);
	
	int[] arrayToProcess;
	int startElement = -1;
	int endElement = -1;
	
	public ArrayMaximumTask(int[] intArrayIn, int startElementIn, int endElementIn)
	{
		arrayToProcess = intArrayIn;
		startElement = startElementIn;
		endElement = endElementIn;
	}
	
	protected boolean exec() 
	{
		int halfwayElement = -1;
		
		if(endElement - startElement > MAX_ELEMENTS_TO_PROCESS)
		{
			halfwayElement = (int)((endElement + startElement) / 2);											// If there are more elements to process than allowed by the maximum split the task into two smaller tasks
			ArrayMaximumTask part1Task = new ArrayMaximumTask(arrayToProcess, startElement, halfwayElement);	// Task 1 processes the first half of the array ...
			ArrayMaximumTask part2Task = new ArrayMaximumTask(arrayToProcess, halfwayElement, endElement);		// Task 2 processes the second half
			invokeAll(part1Task, part2Task);																	// Run the two subtasks
			try {
				result = (part1Task.get() > part2Task.get() ? part1Task.get() : part2Task.get());				// The final result is the larger of the two results
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			} catch (ExecutionException e) {
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			for(int i = startElement; i < endElement; i++)			// Find and record the largest value in the array
			{
				if(arrayToProcess[i] > result)
				{
					result = arrayToProcess[i];
				}
			}
		}
		
		return true;
	}
	
	public Integer getRawResult() 
	{
		// not required but must be overridden to satisfy abstract class requirements
		return result;
	}

	protected void setRawResult(Integer value) 
	{
		// not required but must be overridden to satisfy abstract class requirements			
	}
}
