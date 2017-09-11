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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger {

	static Path rootLogDir = null;
	
	static boolean useLog = false;
	
	public static boolean useLog() {
		return useLog();
	}
	
	static {
		
		String useLogString = System.getProperty("net.adoptopenjdk.nio2.log", "false");
		useLog = Boolean.valueOf(useLogString);
		
		if (useLog) {
		
		    String dir = 
		        String.format("logs-0x%08x", System.identityHashCode(Logger.class));
		    
			Path logDir = Paths.get("logs");
			if (Files.exists(logDir)) {
				try {
					DirectoryTools.deleteDirectory(logDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			rootLogDir = logDir.resolve(dir);
			
			try {
				Files.createDirectories(rootLogDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Logger(String logFileName) {
		if (useLog) {
			setupLog(logFileName);
		}
	}
	
	protected void setupLog(String logFileName) {
		if (useLog) {
			try {
	
				logFile = rootLogDir.resolve(logFileName);
				
				OutputStream os = Files.newOutputStream(logFile, 
						StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
				logWriter = new PrintStream(os);
				logStartTime = System.currentTimeMillis();
				logMessage("Started at " +  System.currentTimeMillis());
			} catch (IOException e) {
				System.err.println("Unable to create log file " + logFile);
				e.printStackTrace();
			}
		}
		
	}
	
	protected long logStartTime = 0;
	protected Path logFile = null;
	protected PrintStream logWriter = null;
	protected OutputStream os = null;

	public void logMessage(String message) {
		if (useLog) {
			if (logWriter != null) {
				String date = (new Date()).toString();
				long elapsed = (System.currentTimeMillis() - logStartTime);
				
	            final long s = (elapsed / 1000) % 60;
	            final long m = (elapsed / 1000 / 60) % 60;
	            final long h = (elapsed / 1000 / 60 / 60);
				
				String deltaTime = String.format("%02d:%02d:%02d", h,m,s);
				logWriter.println(date + " (start +"+deltaTime + ")\t " + message);	
			}
		}
	}
	public void logMessage() {
		if (useLog) {
			if (logWriter != null) {
				logWriter.println();	
			}
		}
	}
	
	public void close() {
		if (useLog) {
			logMessage("Closing Logger");
			if (logWriter != null) {
				try {
					logWriter.close();
				} catch (Exception e) {}
			}
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {}
			}
		}
	}
	
	public void delete() {
		if (useLog) {
			close();
			if (logFile != null) {
				try {
					Files.deleteIfExists(logFile);
				} catch (IOException e) {}
			}
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		if (useLog) {
			close();
		}
	}
}
