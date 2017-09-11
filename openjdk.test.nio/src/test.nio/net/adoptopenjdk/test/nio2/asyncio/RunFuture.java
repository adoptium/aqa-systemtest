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

package net.adoptopenjdk.test.nio2.asyncio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A utility class to call the get method of a future task,
 * either blocking indefinitely or not, depending on system properties.
 * Created to help investigate timeout issues.
 */
public class RunFuture {
	
	public static final boolean block;
	static {
		block = Boolean.getBoolean("net.adoptopenjdk.nio2.asyncio.block");
	}
	
	public static final int GET_TIMEOUT_SECONDS = 10 * 60;
	
	public static void get(Future<?> task) throws ExecutionException, InterruptedException, TimeoutException {
		if (block) {
			while(!task.isDone()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// do nothing
				}
			}
			task.get();
		} else {
			task.get(GET_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		}
	}
}
