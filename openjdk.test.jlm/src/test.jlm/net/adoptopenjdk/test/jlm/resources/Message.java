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

package net.adoptopenjdk.test.jlm.resources;

import java.util.GregorianCalendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Message {
	private static String logFile = "";
	private static String prefix = "j>";
	private static boolean timestamp = true;
	private static boolean echo = false;
	
	/**
	 * Sets the parameters for use of the logMsg method
	 * 
	 * @param log String, the path to the log file in which to output messages
	 * @param prefix String, a small prefix to add to each line (suggested >j)
	 * @param timestamp boolean if true, timestamp will be added to front of each line (after prefix)
	 * @param echo boolean if true, each line will be echoed to std err
	 */
	public static void setLogPrefs(String log, String prefix, 
			boolean timestamp, boolean echo) {
		Message.logFile = log;
		Message.prefix = prefix;
		Message.timestamp = timestamp;
		Message.echo = echo;
	}
	
	public static void setLogPrefs(String prefix, boolean timestamp) {
		Message.prefix = prefix;
		Message.timestamp = timestamp;
	}
	
	public static void logOut() {
		String message = "" + prefix + " ";
		if (timestamp == true) {
			message += getTimeStampString(System.currentTimeMillis());
		}
		System.out.println(message);
	}
	
	public static void logOut(String str) {
		String message = "";
		String newlines = "";
		
		while (str.startsWith("\n", 0)) {
			newlines += "\n";
			str = str.substring(1);
		}
		
		message += newlines + prefix + " ";
		
		if (timestamp == true) {
			message += getTimeStampString(System.currentTimeMillis()) + " ";
		}
		message += str;
		System.out.println(message);
	}
	
	public static void logErr() {
		String message = "" + prefix + " ";
		if (timestamp == true) {
			message += getTimeStampString(System.currentTimeMillis());
		}
		System.err.println(message);
	}
	
	public static void logErr(String str) {
		String message = "";
		String newlines = "";
		
		while (str.startsWith("\n", 0)) {
			newlines += "\n";
			str = str.substring(1);
		}
		
		message += newlines + prefix + " ";
		
		if (timestamp == true) {
			message += getTimeStampString(System.currentTimeMillis()) + " ";
		}
		
		message += str;
		System.err.println(message);
	}
	
	/**
	 * Writes a string to a logfile. Use setLogPrefs method to set options for the format.
	 * 
	 * @param str String, the string to output to the logfile
	 */
	public static void logMsg(String str) {
		String message = "";
		String newlines = "";
		
		while (str.startsWith("\n", 0)) {
			newlines += "\n";
			str = str.substring(1);
		}
		
		message += newlines + prefix + " ";
		
		if (timestamp == true) {
			message += getTimeStampString(System.currentTimeMillis()) + " ";
		}
		
		message += str;
		
		if (logFile != "") {
			if (!new File(logFile).isFile()) {
				System.err.println("Warning: Logfile " + logFile + " does not point to a valid file. Creating a logfile.");
			}
			
			try {
				BufferedWriter output = new BufferedWriter(new FileWriter(logFile, true));
				output.write(message);
				output.close();
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
			
			if (echo == true) {
				System.err.println(message);
			}
		}
	}

    /**
     * Converts a time in milliseconds into a timestamp.
     * 
     * @param time long, the time in milliseconds as from System.currentTimeMillis().
     * @return String - the timestamp in the format yyyy/mm/dd hh:mm:ss.xxx (Where xxx is milliseconds).
     */
    public static String getTimeStampString(long time) {
        GregorianCalendar myTime = new GregorianCalendar();
        myTime.setTimeInMillis(time);
        String ts = "" + formatPrepend("" + myTime.get(GregorianCalendar.YEAR), ' ', 4) + "/" + formatPrepend("" + (myTime.get(GregorianCalendar.MONTH) + 1), '0', 2) + "/" + formatPrepend("" + myTime.get(GregorianCalendar.DAY_OF_MONTH), '0', 2) + " " + formatPrepend("" + myTime.get(GregorianCalendar.HOUR_OF_DAY), '0', 2) + ":" + formatPrepend("" + myTime.get(GregorianCalendar.MINUTE), '0', 2) + ":" + formatPrepend("" + myTime.get(GregorianCalendar.SECOND), '0', 2) + "." + formatPrepend("" + myTime.get(GregorianCalendar.MILLISECOND), '0', 3);
        return ts;
    }
    
    /**
     * Pads the length of a string prepended.
     * 
     * @param value String, the value to pad.
     * @param add char, the character to use as the padding.
     * @param length int, the length of the string.
     * @return String - the newly padded string.
     */
    public static String formatPrepend(String value, char add, int length) {
        StringBuffer tmp = new StringBuffer(length);
        tmp.append(value);
        while (tmp.length() < length) {
            tmp.insert(0, add);
        }
        return tmp.toString();
    }
}
