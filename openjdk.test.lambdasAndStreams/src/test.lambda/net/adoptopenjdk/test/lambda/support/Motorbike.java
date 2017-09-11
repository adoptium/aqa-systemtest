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

package net.adoptopenjdk.test.lambda.support;

/**
 * The Motorbike class has three fields (candence, speed and gear), one constructor and four methods 
 * (setCandence, setGear, applyBrake and speedUp).
 */

public class Motorbike {
	public int cadence;
	public int speed;
	public int gear;
		
	public Motorbike(int startCadence, int startSpeed, int startGear) {
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
	}
	
	public void setCandence(int newValue) {
		cadence = newValue;
	}
	
	public void setSpeed(int newValue) {
		speed = newValue;
	}
	
	public void setGear(int newValue) {
		gear = newValue;
	}
	
	public void applyBrake(int decrement) {
		speed -= decrement;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
}
