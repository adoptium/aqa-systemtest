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

package net.adoptopenjdk.test.nio2.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class written for the sole purpose of detecting the presence of reiserfs.
 */
public class ReiserSpotter {
	
	private static final boolean isReiser;

	static{
		boolean temp = false;
		try{
			if(System.getProperty("os.name").toLowerCase().contains("linux")){
				Runtime rt = Runtime.getRuntime();
				Process pr = rt.exec("df -T ."); 
				BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	 
				String line="";
				String tempxx=input.readLine();
				
				while(tempxx != null) {
					line += tempxx;
					tempxx=input.readLine();
				}
	 
				pr.waitFor();

				temp = line.contains("reiserfs");
			}
		}
		catch(Exception e){
			System.out.println("ReiserSpotter.java failed with this Exception message: " + e.getMessage());
		}
		isReiser = temp;
	}

	public static boolean getIsReiser() {
		return isReiser;
	}
}