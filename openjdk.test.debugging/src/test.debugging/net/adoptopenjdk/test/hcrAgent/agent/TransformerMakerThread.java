/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.hcrAgent.agent;

import java.lang.instrument.Instrumentation;
import java.lang.InterruptedException;
import java.util.Random;

/*
 * This class extends Thread, and allows us to create, add, and remove multiple new
 * transformers in parallel. This helps to stress the retransformation mechanism.
 */
public class TransformerMakerThread extends Thread{

	Instrumentation inst;
	int percentage;
	int seed;
	int threadNumber;
	Random randomNumberGenerator;

	/**
	 * Constructor method.
	 * @param inst         We can pass instructions and transformations to the host JVM through this object.
	 * @param threadNumber The number of this thread. Used for log messages, to differentiate threads.
	 * @param percentage   The average number of String methods we want to modify per thread per execution.
	 * @param seed         The seed for our random number generator, to aid defect reproducibility.
	 */
	public TransformerMakerThread(Instrumentation inst, int threadNumber, int percentage, long seed) {
		this.inst = inst;
		this.percentage = percentage;
		randomNumberGenerator = new Random(seed);
		this.threadNumber = threadNumber;
	}

	/**
	 * This method creates, adds, and removes a new transformer from the JVM via the Instrumentation
	 * object. 
	 * 
	 * The random pauses allow other, concurrent threads to add other transformers, or remove
	 * them, before we trigger retransformation. This increases the number of code paths that this
	 * test might cover based upon its duration, as we can be testing unique combinations of transformers
	 * from the first moment of the test to the end, conceivably days from now.
	 */
	public void run() {
		StringTransformer st = new StringTransformer(randomNumberGenerator.nextLong(),percentage,threadNumber);
		//Wait up to 2 seconds before adding the transformer, for randomness.
		AgentLogger.printThis("Thread " + threadNumber + " has been started.",2);
		sleepNow(randomNumberGenerator.nextInt(2*1000));
		AgentLogger.printThis("Thread " + threadNumber + " is now adding the transformer.",2);
		inst.addTransformer(st,true);
		//Wait again before triggering the retransform.
		sleepNow(randomNumberGenerator.nextInt(2*1000));
		AgentLogger.printThis("Thread " + threadNumber + " is now triggering a retransform.",2);
		try{
			inst.retransformClasses(Class.forName("java.lang.String"));
		}catch(Exception e){
			AgentLogger.printThis("Thread " + threadNumber + " failed to retransform String.",1);
				System.out.println(e.toString());
			return;
		}
		AgentLogger.printThis("Thread " + threadNumber + " has finished triggering a retransform.",2);
		//And wait one final time before removing the transformer.
		sleepNow(randomNumberGenerator.nextInt(2*1000));
		AgentLogger.printThis("Thread " + threadNumber + " is now removing the transformer.",2);
		if(!inst.removeTransformer(st)) {
			throw new RuntimeException("Thread " + threadNumber + " was unable to remove one of the transformers it added to the Instrumentation object to transform the String class.");
		}
		AgentLogger.printThis("Thread " + threadNumber + " has finished removing the transformer.",2);
		return;
	}

	/**
	 * A method to allow us to sleep this thread without complicating the code above
	 * with the try-catch block.
	 * @param l The length of time (in milliseconds) that we want to pause this thread.
	 */
	private void sleepNow(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			//Do nothing.
		}
	}
}
