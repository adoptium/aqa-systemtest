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

package net.adoptopenjdk.test.lambda.support;

public class Animal {

	private String id;
	
	public Animal() {
	}
	
	public Animal(String id) {
		this.id = id;
	}
	
	public String getCategory() { 
		return "UNKNOWN-" + id;
	}

	public String getId() {
		return id;
	}
}
