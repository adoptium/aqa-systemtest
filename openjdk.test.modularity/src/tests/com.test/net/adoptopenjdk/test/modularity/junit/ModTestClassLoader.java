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

package net.adoptopenjdk.test.modularity.junit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ModTestClassLoader extends ClassLoader {
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		if(!className.toLowerCase().contains("hello")
		|| !className.toLowerCase().contains("exported")
		|| !className.toLowerCase().contains("hidden")) {
			return super.loadClass(className);
		}
		
		int b = 0;
		String fullClassName = className.replace(".", "/") + ".class";
		
		InputStream inputStream = getClass().
				getClassLoader().
				getResourceAsStream(fullClassName);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		try {
			while(true) {
				b = inputStream.read();
				if (b == -1) {
					break;
				}
				outputStream.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] byteArray = outputStream.toByteArray();
		return defineClass(className, byteArray, 0, byteArray.length);
	}
}
