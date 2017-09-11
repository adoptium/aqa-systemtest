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

package net.adoptopenjdk.test.concurrent.support.jsr166y;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;

/**
 * ArraySummationTask is a ForkJoinTask for submission into a ForkJoinPool. The task takes an array and a start and end position in. If the number of elements between
 * the start and end position is less than MAX_ELEMENTS_TO_PROCESS, the exec() method sums the selected elements and sets the result variable. If the number of elements
 * is greater than MAX_ELEMENTS_TO_PROCESS the task is split into two smaller ArraySummationTasks which are then invoked using invokeAll(). The result
 * of the parent task is then the result of the two subtasks added together.
 */

public class ArraySummationTask extends ForkJoinTask<Integer>
{
	private static final long serialVersionUID = 7702782131060649816L;

	private final int MAX_ELEMENTS_TO_PROCESS = 100;
	private Integer result = new Integer(0);
	
	int[] arrayToProcess;
	int startElement = -1;
	int endElement = -1;
	
	public ArraySummationTask(int[] intArrayIn, int startElementIn, int endElementIn)
	{
		arrayToProcess = intArrayIn;
		startElement = startElementIn;
		endElement = endElementIn;
	}
	
	protected boolean exec()
	{
		int halfwayElement = -1;
		
		if(endElement - startElement > MAX_ELEMENTS_TO_PROCESS)														// If there are more elements to process than allowed by the maximum split the task into two smaller tasks
		{
			halfwayElement = (int)((endElement + startElement) / 2); 	
			ArraySummationTask part1Task = new ArraySummationTask(arrayToProcess, startElement, halfwayElement);	// Task 1 processes the first half of the array ...
			ArraySummationTask part2Task = new ArraySummationTask(arrayToProcess, halfwayElement, endElement);		// Task 2 processes the second half
			
			invokeAll(part1Task, part2Task);	// Run the two subtasks
			
			try
			{
				result = part1Task.get() + part2Task.get();		// The final result is the sum of the results of the subtasks
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
				return false;
			}
			catch (ExecutionException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		else	// The task was small enough that it didn't need to be subdivided	
		{
			for(int i = startElement; i < endElement; i++)		// A simply iterative loop to sum the elements in the array
			{
				result = result + arrayToProcess[i];
			}
		}
		
		return true;	// Execution finished
	}
	
	public Integer getRawResult() 
	{
		// not required but must be overridden to satisfy abstract class requirements
		return result;
	}

	protected void setRawResult(Integer value) 
	{
		// not required but must be overridden to satisfy abstract class requirements
		result = value;
	}

}
