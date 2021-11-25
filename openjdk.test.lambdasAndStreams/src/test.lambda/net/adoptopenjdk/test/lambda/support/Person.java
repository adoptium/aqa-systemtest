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

import java.io.Serializable;

public class Person extends Animal implements Serializable {
	private static final long serialVersionUID = -56918181L;

	public enum Title { MR, MS, MRS, MISS, DR, PROFESSOR, HRH, CAPTAIN, SIR };
	
	private Title title;
	private NameDetails name;
	private int age;
	private int serialNumber;
	
	private static int nextSerialNumber = 1;
	
	public interface NameExtractor extends Serializable
	{
		String name();
	}
	
	public static class NameDetails implements Serializable {
		private static final long serialVersionUID = 234235699L;
		
		private String firstName;
		private String surname;
		private String maidenName;
		private String nickName;
		private int requestCount = 1;

		public NameDetails(String firstName, String surname) {
			this.firstName = firstName;
			this.surname = surname;
		}
		
		public NameDetails(String firstName, String surname, String maidenName, String nickName) {
			this(firstName, surname);
			this.maidenName = maidenName;
			this.nickName = nickName;
		}
		
		public String getFullName() {
			return firstName + " " + surname;
		}
		
		public String getFirstName() { return firstName; }
		public String getSurname() { return surname; }
		public String getSurnameWithCounter() { return requestCount++ + ":" + surname; }
		public String getMaidenName() { return maidenName; }
		public String getNickName() { return nickName; }
		
		public static String getMostPopularName() { 
			return "John Smith"; 
		}
	}
	
	private NameExtractor nameLambda = () -> { return title + " " + name.getFirstName() + " " + name.getSurname(); };
	
	public Person() {
		this(null, "NoFirstName", "NoSecondName", -1);
	}
	
	public Person(int x) {
		this(null, "NoFirstName", "NoSecondName", -1);
	}
	
	
	public Person(Title title, String firstName, String surname, int age) {
		super(surname);
		
		this.title = title;
		this.name = new NameDetails(firstName, surname);
		this.age = age;
		
		synchronized (Person.class) {
			this.serialNumber = nextSerialNumber++;
		}
	}
	
	public Title getTitle() {
		return title;
	}

	public String getFirstName() { 
		return name.firstName;
	}
	
	public String getSurname() { 
		return name.surname;
	}
	
	public String getName() { 
		return nameLambda.name();
	}
	
	public static String getNameFromPerson(Person person) {
		return "Person name: " + person.getName();
	}
	
	//Returns number of titles in the enumerated title type.
	public static int numAvailableTitles() { 
		return Title.values().length;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
