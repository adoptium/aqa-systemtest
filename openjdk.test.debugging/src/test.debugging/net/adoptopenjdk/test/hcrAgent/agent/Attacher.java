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

package net.adoptopenjdk.test.hcrAgent.agent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import com.sun.tools.attach.spi.AttachProvider;

/*
 * This class is designed to attach to an existing Java process and attach a java agent.
 */
public class Attacher {

	static SimpleDateFormat outFormatter = new SimpleDateFormat("H:mm:ss > ");

	public static void main(String[] args) throws Exception {
		
		if (args.length < 2)
		{
			logOut("Not enough arguments given. This code requires, in this order:");
			logOut("1) The PID of JVM to attach to.");
			logOut("1) The absolute location of the agent jar to be attached.");
			logOut("3) (optional) Any arguments to be passed to the java agent.");
			System.exit(1);
		}
		String vmPidArg = args[0];
		Integer.parseInt(vmPidArg); //Just to make sure it's a number.
		logOut("Will attempt to attach to JVM with pid " + vmPidArg);

		String agentPathString = args[1];

		logOut("Attach will be done using agent jar file: " + agentPathString);
		
		// This may cause a compiler error in eclipse, as it is not a java.* class
		// It can be fixed by editing the access rules for the JRE system library
		// attach to target VM
		
		//First we wait for the target VM to become available
		boolean foundTarget = false;
		while (!foundTarget) {
			List<VirtualMachineDescriptor> allVMs = VirtualMachine.list();
			for (VirtualMachineDescriptor oneVM : allVMs) {
				if (oneVM.id().equals(vmPidArg)) {
					foundTarget = true;
				}
			}
			if (!foundTarget) {
				Thread.sleep(1000);
			}
		}
		
		//Then we attach to it.
		VirtualMachine vm = VirtualMachine.attach(vmPidArg);
		
		// load agent into target VM
		try {
			if (args.length > 2) {
				vm.loadAgent(agentPathString, args[2]);
			} else {
				vm.loadAgent(agentPathString);
			}
		} catch (java.io.IOException e) {
			//This exception is thrown if the test process terminates before the agent does. 
			//We don't mind if this happens.
		}
		
		// detach
		vm.detach();
	}

	/**
	 * Log a message to System.out with a time stamp
	 */
	public static void logOut(String message)
	{
		String time = outFormatter.format(new Date());
		System.out.println(time + message);
	}
}
