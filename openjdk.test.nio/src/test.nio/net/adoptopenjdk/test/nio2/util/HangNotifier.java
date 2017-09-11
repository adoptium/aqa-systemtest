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

package net.adoptopenjdk.test.nio2.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

public class HangNotifier {

	private static TimerTask timerTask;
	private static Timer timer;
	private static final boolean DEFAULT = false;
	
	static {	
		String on = System.getProperty("com.ibm.jtc.nio2.util.hangmonitor", null);
		boolean isOn = DEFAULT;
		if (on != null) {
			isOn = Boolean.parseBoolean(on);
		}
		
		if (isOn) {		
			timerTask = new TimerTask() {			
				@Override
				public void run() {
					System.out.print("Checking for a long pause...");
					if (pingCounter == previousPingCounter) {
						System.out.println("Pause Detected!");
						// Generate system dump if we are using IBM SDK
						String jvmVendor = System.getProperty("java.vm.vendor");
						if (jvmVendor != null && jvmVendor.contains("IBM")) {
							try {
								// Get a reference to the IBM only dump methods.
								Class<?> dumpClass = Class.forName("com.ibm.jvm.Dump");
								Method sysDumpMethod = dumpClass.getDeclaredMethod("SystemDump"); 
								Method javaDumpMethod = dumpClass.getDeclaredMethod("JavaDump"); 
								System.out.println("Generating SystemDump");
								sysDumpMethod.invoke(null); 
								System.out.println("Generating JavaDump");
								javaDumpMethod.invoke(null);
							} catch (ClassNotFoundException e) {
						 		System.out.println("Failed to access IBM Dump class");
						 		e.printStackTrace();
						 	} catch (NoSuchMethodException e) {
						 		System.out.println("Failed to access IBM Dump method");
						 		e.printStackTrace();
						 	} catch (InvocationTargetException e) {
						 		e.printStackTrace();
						 	} catch (IllegalAccessException e) {
						 		e.printStackTrace();
						 	}
						}
					} else {
						System.out.println("None Found");
					}
					
					System.out.println("Ping counter = " + pingCounter);
					previousPingCounter = pingCounter;
				}
			};
			
			timer = new Timer();
			int minutes = 5;
			System.out.println("Scheduling hang monitor timer for " +minutes+ " minutes");
			long interval = minutes * 60 * 1000;
			timer.schedule(timerTask, interval, interval);			
		}	
	}
	
	private static long pingCounter = 0;
	private static long previousPingCounter = 0;
	
	public static void ping() {
		pingCounter++;
	}
}
