/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

/*
 * Summary: A simple java class with getters and setters
 */

package net.adoptopenjdk.test.jdi.targetvm;

import java.util.Date;
import java.text.DateFormat;

public class Simple
{
	String name;
	
	public static void main(String[] args) 
	{
		System.out.println("Simple, starting up @" + DateFormat.getDateTimeInstance().format(new Date())  );
		
		Simple message = new Simple();
		message.setName();
		System.out.println(message.getName());
		
		System.out.println("Counting to 100");
		for(int i = 0; i < 100; i++)
		{
			System.out.print(i + " ");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("The sleeping thread was interrupted");
				e.printStackTrace();
			}
		}
		
		System.out.println("\nSimple, closing down @" + DateFormat.getDateTimeInstance().format(new Date())  );   
	}
	public void setName(){
		this.name = "Been Changed";	
	}
	public String getName(){
		return this.name;
	}
}
