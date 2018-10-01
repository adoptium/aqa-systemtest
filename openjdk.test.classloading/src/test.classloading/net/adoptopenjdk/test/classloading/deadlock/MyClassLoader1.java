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

package net.adoptopenjdk.test.classloading.deadlock;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader1 extends URLClassLoader 
{

	private static ClassLoader loader;
	
	static 
	{
		ClassLoader.registerAsParallelCapable();
	}
	
	public MyClassLoader1(URL[] urls) 
	{
		super(urls);
		loader = this;
	}
	
	public static ClassLoader getClassLoader() 
	{
		return	loader;
	}
	
	public Class<?> loadClass(String name) throws ClassNotFoundException 
	{
		// If the class name doesn't contain package1 (which this classloader (MyClassLoader1) is 
		// expecting to load) then call MyClassLoader2 which is expecting to load package2 classes
		if (name.startsWith("net.adoptopenjdk.test.classloading.deadlock.package2")) 
		{
			return MyClassLoader2.getClassLoader().loadClass(name);
		}
		else 
		{
			return this.loadClass(name, false);
		}
	}
}
