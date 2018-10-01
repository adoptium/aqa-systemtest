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

/**
 * WaiterTask is a task for submission into a ForkJoinPool. The task doesn't do anything notable - it simply enters an infinite
 * loop and sits there until the unblock() method is called at which point it sets its' result to 'true' and exists
 */
public class WaiterTask extends ForkJoinTask<Boolean>
{
	private static final long serialVersionUID = 5533199693608471967L;
	
	public String AKA;
	
	public WaiterTask(String name) {
		AKA=name;
	}

	public WaiterTask() {
		this("ANON");
	}
	
	private volatile boolean result = false;
	private volatile boolean blocking = true;
	private volatile boolean wasInterrupted = false;
	private volatile boolean isWaiting = false;
	
	public boolean getWasInterrupted()
	{
		return wasInterrupted;
	}
	
	public Boolean getRawResult() 
	{
		return new Boolean(result);
	}

	protected void setRawResult(Boolean value) 
	{
		result = value.booleanValue();
	}
	
	public boolean isWaiting()
	{
		return isWaiting;
	}
	
	public void unblock()
	{
		blocking = false;
	}

	protected boolean exec()
	{	
		while(blocking && !wasInterrupted)
		{
			try 
			{
				isWaiting = true;
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				wasInterrupted = true;
			}
		}
		
		isWaiting = false;
		result = true;
		
		return result;
	}
	
}
