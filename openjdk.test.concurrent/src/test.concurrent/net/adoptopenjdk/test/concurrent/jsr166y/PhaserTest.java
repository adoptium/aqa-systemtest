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
/**
 * File:    PhaserTest
 * Package: net.adoptopenjdk.test.concurrent
 */

package net.adoptopenjdk.test.concurrent.jsr166y;

import java.io.IOException;
import java.util.concurrent.Phaser;

import net.adoptopenjdk.test.concurrent.ConcurrentTest;

/**
 * PhaserTest
 * ==========
 * 
 * Attempts to verify the correct function of the Phaser class in a simple test scenario. 
 * 
 * Split into two sections :
 * 
 * 		testAPI()		-	call as many of the API functions as possible using an instance of Phaser
 * 						-	API calls checked with assertions where possible
 * 						-   exercise the API using multiple threads and checking for correct concurrent behaviour
 * 						-	multiple threads are able to run testAPI concurrently
 * 
 * 		testStress()	-	call as many of the API calls as possible using a shared i.e. class instance of Phaser
 * 							NOTE : This shared instance is separate to the instance used in testAPI()
 * 						-	API calls are not checked
 * 						-   Aims to test multiple threads accessing the same instance of the class under test
 * 						-	Attempting to provoke a JIT response through repeated calls of the various API calls
 * 
 * This testcase makes use of class variables i.e. variables declared as 'static'. Usually this is a definite no-no
 * when it comes to tests run under a multithreaded stress testing engine. However, testing of many of the classes
 * in the java.util.concurrent package necessarily involves multiple threads accessing and modifying the same single data source.
 * This testcase was therefore designed to be run multiple times concurrently in such a way that threads do not interfere with
 * each other and cause incorrect results.
 *  
 * This test was written to test JSR166y.
 */

public class PhaserTest extends ConcurrentTest
{

	private static Phaser stressPhaser = new Phaser();
		
	public void testAPI()
	{
		Phaser localPhaser = null;
		
		// =================================================================================
		// Constructor Tests
		
		// no argument constructor
		localPhaser = new Phaser();
		assertEquals("1 : getRegisteredParties()", 0, localPhaser.getRegisteredParties());
		assertEquals("2 : getParent()", null, localPhaser.getParent());
		assertEquals("3 : getPhase()", 0, localPhaser.getPhase());
		
		// int constructor for initial number of registered parties
		localPhaser = new Phaser(0);
		assertEquals("4 : getRegisteredParties()", 0, localPhaser.getRegisteredParties());
		assertEquals("5 : getParent()", null, localPhaser.getParent());
		assertEquals("6 : getPhase()", 0, localPhaser.getPhase());
		
		localPhaser = new Phaser(1);
		assertEquals("7 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());

		localPhaser = new Phaser(45);
		assertEquals("8 : getRegisteredParties()", 45, localPhaser.getRegisteredParties());
		
		try
		{
			localPhaser = new Phaser(-1);
			fail("9 : Phaser(int) should thrown IllegalArgumentException for -ve number of parties");
		}
		catch(IllegalArgumentException iae)
		{
			// expected
		}
	  
		// Phaser constructor to specify a parent Phaser and establish a parent->child relationship
		localPhaser = new Phaser(null);
		assertEquals("10 : getParent()", null, localPhaser.getParent());
		
		Phaser parentPhaser = new Phaser(4);
		localPhaser = new Phaser(parentPhaser);
		assertEquals("11 : getParent()", parentPhaser, localPhaser.getParent());
		assertEquals("12 : getRegisteredParties()", 0, localPhaser.getRegisteredParties());
		assertEquals("13 : getPhase()", 0, localPhaser.getPhase());
		assertEquals("14 : getParent().getRegisteredParties()", 4, localPhaser.getParent().getRegisteredParties());
		
		Phaser grandparentPhaser = new Phaser(8);
		parentPhaser = new Phaser(grandparentPhaser, 4);
		localPhaser = new Phaser(parentPhaser, 1);
		assertEquals("15 : getParent()", parentPhaser, localPhaser.getParent());
		assertEquals("16 : getParent()", grandparentPhaser, localPhaser.getParent().getParent());
		assertEquals("17 : getRoot()", grandparentPhaser, localPhaser.getRoot());
		assertEquals("18 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());
		assertEquals("19 : getRegisteredParties()", 5, localPhaser.getParent().getRegisteredParties());
		assertEquals("20 : getRegisteredParties()", 9, localPhaser.getRoot().getRegisteredParties());
		
		// Overriding onAdvance()
		localPhaser = new Phaser(){
			// If onAdvance() returns true the Phaser is marked as being terminated.
			// Override onAdvance() to mark this phaser as terminated when the phase advances beyond 1
			protected boolean onAdvance(int phase, int registeredParties)
			{
				// Phase is the phase that is about to be advanced out of
				if(phase == 1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		};
		
		localPhaser.register();
		assertEquals("21 : ", 0, localPhaser.getPhase());
		
		localPhaser.arrive();	// Advance to phase 1
		assertEquals("22 : ", 1, localPhaser.getPhase());
		assertEquals("23 : ", false, localPhaser.isTerminated());
		
		localPhaser.arrive();	// Advance to phase 2
		assertEquals("24 : ", true, localPhaser.isTerminated());
		assertEquals("25 : getPhase()", localPhaser.getPhase(), localPhaser.arrive());  // Arrival shouldn't increment the phase of a terminated Phaser
		assertEquals("26 : arrive()", localPhaser.arrive(), localPhaser.arrive());
		
		// =================================================================================
	
		// API Tests around arriving and phase change
		// These basic tests can be run from the current thread
		
		// An uninitialised, unused Phaser
		localPhaser = new Phaser();
		assertEquals("27 : getRegisteredParties()", 0, localPhaser.getRegisteredParties());
		assertEquals("28 : getUnarrivedParties()", 0, localPhaser.getUnarrivedParties());
		assertEquals("29 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		assertEquals("30 : getPhase()", 0, localPhaser.getPhase());	
		
		// Register once with the Phaser
		localPhaser.register();
		assertEquals("31 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());
		assertEquals("32 : getUnarrivedParties()", 1, localPhaser.getUnarrivedParties());
		assertEquals("33 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		assertEquals("34 : getPhase()", 0, localPhaser.getPhase());
	
		// Arrive at the Phaser
		localPhaser.arrive();
		assertEquals("35 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());
		assertEquals("36 : getUnarrivedParties()", 1, localPhaser.getUnarrivedParties());	// This is 1 because we have moved to the next phase and the thread hasn't arrived again yet
		assertEquals("37 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		assertEquals("38 : getPhase()", 1, localPhaser.getPhase());

		// Register a second time with the Phaser
		localPhaser.register();
		assertEquals("39 : getRegisteredParties()", 2, localPhaser.getRegisteredParties());
		
		// Arrive once with the Phaser
		localPhaser.arrive();
		assertEquals("40 : getRegisteredParties()", 2, localPhaser.getRegisteredParties());
		assertEquals("41 : getUnarrivedParties()", 1, localPhaser.getUnarrivedParties());
		assertEquals("42 : getArrivedParties()", 1, localPhaser.getArrivedParties());
		assertEquals("43 : getPhase()", 1, localPhaser.getPhase());

		// Arrive a second time with the Phaser
		localPhaser.arrive();																// 2nd arrival pushes the Phaser into the next phase ...
		assertEquals("44 : getUnarrivedParties()", 2, localPhaser.getUnarrivedParties());	// ... so there are 2 unarrived parties again ...
		assertEquals("45 : getArrivedParties()", 0, localPhaser.getArrivedParties());       // ... and no arrived parties ...
		assertEquals("46 : getPhase()", 2, localPhaser.getPhase());							// ... and the phase has changed
		
		// These tests require secondary threads to work effectively so we'll make use of a PhaserHelperThread or two
		localPhaser = new Phaser();
		localPhaser.register();
		
		PhaserHelperThread phaserHelper1 = new PhaserHelperThread(localPhaser, false, -1, false, false, false);
		Thread helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1a");
		
		assertEquals("47 : getRegisteredParties()", 2, localPhaser.getRegisteredParties());
		assertEquals("48 : getUnarrivedParties()", 2, localPhaser.getUnarrivedParties());
		assertEquals("49 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		// At this stage we have a Phaser with 2 registered parties - i) The helper thread and ii) the current thread
		// Starting the helper thread causes it to call arrive()
		helper1.start();
		while(localPhaser.getArrivedParties() != 1)
		{
			sleep(1000);
		}
	
		assertEquals("50 : getUnarrivedParties()", 1, localPhaser.getUnarrivedParties());
		
		// And now arrive on the current thread which causes the phase to change
		localPhaser.arrive();
				
		assertEquals("51 : getRegisteredParties()", 2, localPhaser.getRegisteredParties());
		assertEquals("52 : getUnarrivedParties()", 2, localPhaser.getUnarrivedParties());		// Recall that the phase changes once both threads have arrive()d
		assertEquals("53 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		try
		{
			helper1.join();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
		assertEquals("54 : getPhase()", 1, localPhaser.getPhase());
		assertEquals("55 : arrive()", true, phaserHelper1.isExecutionFinished());				// Ensures that the thread ended and isn't blocked waiting at the Phaser
	
		// More of the same but this time with two helper threads
		localPhaser = new Phaser();
		localPhaser.register();
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, false, -1, false, false, false);
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1b");
		
		PhaserHelperThread phaserHelper2 = new PhaserHelperThread(localPhaser, false, -1, false, false, false);
		Thread helper2 = new Thread(phaserHelper2, "PhaserHelperThread-2b");
		
		assertEquals("56 : getRegisteredParties()", 3, localPhaser.getRegisteredParties());
		assertEquals("57 : getUnarrivedParties()", 3, localPhaser.getUnarrivedParties());
		assertEquals("58 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		// So this time we have 3 threads waiting on the phaser
		helper1.start();
		helper2.start();
		
		while(localPhaser.getUnarrivedParties() != 1)
		{
			sleep(1000);
		}
		
		assertEquals("59 : getArrivedParties()", 2, localPhaser.getArrivedParties());
		assertEquals("60 : getPhase()", 0, localPhaser.getPhase());
		
		localPhaser.arrive();
		assertEquals("61 : getUnarrivedParties()", 3, localPhaser.getUnarrivedParties());
		assertEquals("62 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		assertEquals("63 : getPhase()", 1, localPhaser.getPhase());
		
		try 
		{
			helper1.join();		// Join both in a single try...catch block
			helper2.join();		// If the first one fails the testcase will report as failed so it doesn't matter what happens with the second thread
		}
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
		// Testing of other arrive methods
		// First up, have one of the helpers thread use arriveAndAwaitAdvance()
		localPhaser = new Phaser();
		localPhaser.register();
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, true, -1, false, false, false); // This thread will call arriveAndAwaitAdvance()
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1c");
		phaserHelper2 = new PhaserHelperThread(localPhaser, false, -1, false, false, false);
		helper2 = new Thread(phaserHelper2, "PhaserHelperThread-2c");
		
		// PhaserHelperThread(Phaser phaserIn, boolean awaitOthersIn, int phaseToWaitForIn, boolean allowInterruptIn, boolean expectInterruptIn, boolean deregisterTestIn)
		
		helper1.start();
		helper2.start();
		
		while(localPhaser.getUnarrivedParties() != 1 || !phaserHelper2.isExecutionFinished())
		{
			sleep(1000);
		}
		
		assertEquals("64 : getArrivedParties()", 2, localPhaser.getArrivedParties());
		assertEquals("65 : arriveAndAwaitAdvance()", false, phaserHelper1.isExecutionFinished());	// This helper thread is waiting on the Phase to advance
		assertEquals("66 : arrive()", true, phaserHelper2.isExecutionFinished());
		
		localPhaser.arrive();	// The last thread to arrive - the phase should now advance
		assertEquals("67 : getPhase()", 1, localPhaser.getPhase());
		
		while(!phaserHelper1.isExecutionFinished())
		{
			sleep(1000);
		}
		
		assertEquals("68 : arriveAndAwaitAdvance()", true, phaserHelper1.isExecutionFinished());
		
		try 
		{
			helper1.join();
			helper2.join();
		}
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
		// Next - arriveAndDeregister
		localPhaser = new Phaser();
		localPhaser.register();
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, false, -1, false, false, true);		// This thread will call arriveAndDeregister()
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1d");
		phaserHelper2 = new PhaserHelperThread(localPhaser, false, -1, false, false, false);	// This thread calls only arrive()
		helper2 = new Thread(phaserHelper2, "PhaserHelperThread-2d");
		
		assertEquals("69 : getRegisteredParties()", 3, localPhaser.getRegisteredParties());
		assertEquals("70 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		helper1.start();
		helper2.start();
		
		try 
		{
			helper1.join();
			helper2.join();
		}
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
		while(!phaserHelper1.isExecutionFinished() || !phaserHelper2.isExecutionFinished())		// Let the threads finish 
		{
			sleep(1000);
		}
		
		if(localPhaser.getArrivedParties() != 1)
		{
			try
			{
				throw new SVTException();
			}
			catch(SVTException e)
			{
				
			}
		}

		assertEquals("71 : getRegisteredParties()", 2, localPhaser.getRegisteredParties());		// 2 because one of the threads deregistered itself
		assertEquals("72 : getArrivedParties()", 1, localPhaser.getArrivedParties());			// 1 because one of the threads deregistered itself and 1 hasn't arrived
		
		localPhaser.bulkRegister(1);
		assertEquals("73 : bulkRegister()", 3, localPhaser.getRegisteredParties());
		
		localPhaser.bulkRegister(54);
		assertEquals("74 : bulkRegister()", 57, localPhaser.getRegisteredParties());
		assertEquals("75 : bulkRegister()", 56, localPhaser.getUnarrivedParties());
		
		while(localPhaser.getPhase() == 0)
		{
			localPhaser.arriveAndDeregister();
		}
		
		assertEquals("76 : arriveAndDeregister()", 1, localPhaser.getRegisteredParties());
		
		// Next is awaitAdvance()
		localPhaser = new Phaser();
		localPhaser.register();
		
		while(localPhaser.getPhase() != 52)
		{
			localPhaser.arrive();
		}
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, false, 52, false, false, false);		// This thread will call awaitAdvance() and won't leave until the phase changes from 52 to 53
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1e");
		helper1.start();
		
		assertEquals("77 : getPhase()", 52, localPhaser.getPhase());
		
		while(!phaserHelper1.isWaiting())	// Give the helper thread time to reach the awaitAdvance() call as this can take a while in multithreaded environments
		{
			sleep(1000);
		}
		
		localPhaser.arrive();				// Cause the phase to advance to 53.		
		
		while(!phaserHelper1.isExecutionFinished())
		{
			sleep(1000);
		}

		assertEquals("78 : getPhase()", 53, localPhaser.getPhase());
		
		// And now awaitAdvancedInterruptibly
		localPhaser = new Phaser();
		localPhaser.register();
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, false, 0, true, false, false);	// This thread awaits advance interruptibly and doesn't expect to be interrupted. Waiting to leave phase 0.
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1f");
		
		phaserHelper2 = new PhaserHelperThread(localPhaser, false, 0, true, true, false);	// This thread awaits advance interruptibly and permits being interrupted. Waiting to leave phase 0.
		helper2 = new Thread(phaserHelper2, "PhaserHelperThread-2f");
		
		assertEquals("79 : getPhase()", 0, localPhaser.getPhase());									// Should be in phase 0 to start ...
		assertEquals("80 : getRegisteredParties()", 3, localPhaser.getRegisteredParties());			// ... three registered threads ...
		assertEquals("81 : getUnarrivedParties()", 3, localPhaser.getUnarrivedParties());			// ... and none of them have yet arrived
				
		helper1.start();
		helper2.start();
				
		while(!phaserHelper2.isWaiting())				// The thread may well have started but it probably hasn't reached the point where it is waiting on the phase change.
		{
			sleep(1000);
		}
		
		helper2.interrupt();							// Now what we know that thread 2 is waiting for the phase to change, send it an interrupt
		
		while(!phaserHelper2.isExecutionFinished())		// Wait for thread 2 to stop running
		{
			sleep(1000);
		}

		assertEquals("82 : awaitAdvanceInterruptibly()", true, phaserHelper2.isExecutionFinished());	// Thread 2 should have stopped running ...
		assertEquals("83 : awaitAdvanceInterruptibly()", true, phaserHelper2.wasInterrupted());			// ... and was hopefully interrupted
		assertEquals("84 : awaitAdvanceInterruptibly()", false, phaserHelper1.isExecutionFinished()); 	// Thread 1 should still be running ...
		assertEquals("85 : awaitAdvanceInterruptibly()", false, phaserHelper1.wasInterrupted());		// ... and should not have been interrupted
				
		localPhaser.arrive();  // By here the two spawned threads have both arrived at the Phaser already. Arriving on the current thread causes the Phase to change to 1
		
		while(!phaserHelper1.isExecutionFinished())		// Wait for thread 1 to complete
		{
			sleep(1000);
		}
		
		assertEquals("86 : getPhase()", 1, localPhaser.getPhase());										// Should be in phase 1 now ...
		assertEquals("87 : awaitAdvanceInterruptibly()", true, phaserHelper1.isExecutionFinished());	// ... execution should have completed ...
		assertEquals("88 : awaitAdvanceInterruptibly()", false, phaserHelper1.wasInterrupted());		// ... and thread 1 wasn't interrupted
		
		// Testing of force termination
		
		localPhaser = new Phaser();
		localPhaser.register();
		
		phaserHelper1 = new PhaserHelperThread(localPhaser, false, 0, true, false, false);	// This thread awaits advance interruptibly and doesn't expect to be interrupted. Waiting to leave phase 0.
		helper1 = new Thread(phaserHelper1, "PhaserHelperThread-1g");
		
		helper1.start();
		
		while(!phaserHelper1.isWaiting())		// Let the helper thread get into the state where it is waiting for the Phase to advance
		{
			sleep(1000);
		}
		
		assertEquals("89 : getPhase()", 0, localPhaser.getPhase());
		assertEquals("90 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());	
		assertEquals("91 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		localPhaser.forceTermination();
		
		assertEquals("92 : isTerminated()", true, localPhaser.isTerminated());
		assertEquals("93 : getRegisteredParties()", 1, localPhaser.getRegisteredParties());	
		assertEquals("94 : getArrivedParties()", 0, localPhaser.getArrivedParties());
		
		assertEquals("95 : getPhase()", localPhaser.getPhase(), localPhaser.arrive());  // Arrival shouldn't increment the phase of a terminated Phaser
		assertEquals("96 : arrive()", localPhaser.arrive(), localPhaser.arrive());		
	}
	
	public void testStress()
	{
		stressPhaser.register();				// Need to register before we do anything else
		
		// The following is a list of around 200 randomly generated API calls
		// Only those methods which are non-blocking are called because testStress is intended to be called by multiple threads in parallel and one thread could easily prevent all others from running
		// and hang the test indefinitely.

		// The purpose of this block is not to test the API but to provoke multiple threads running under load to execute the function calls against the same Phaser instance
		// and perhaps increase the chance of the JIT choosing to compile some of the methods.
		stressPhaser.isTerminated();
		stressPhaser.getRegisteredParties();
		stressPhaser.getParent();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.toString();
		stressPhaser.isTerminated();
		stressPhaser.arrive();
		stressPhaser.getArrivedParties();
		stressPhaser.getArrivedParties();
		stressPhaser.isTerminated();
		stressPhaser.isTerminated();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.toString();
		stressPhaser.toString();
		stressPhaser.isTerminated();
		stressPhaser.isTerminated();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.arrive();
		stressPhaser.isTerminated();
		stressPhaser.getRoot();
		stressPhaser.arrive();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.getParent();
		stressPhaser.getRoot();
		stressPhaser.getRegisteredParties();
		stressPhaser.arrive();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.getPhase();
		stressPhaser.arrive();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.getRoot();
		stressPhaser.getParent();
		stressPhaser.getPhase();
		stressPhaser.getPhase();
		stressPhaser.arrive();
		stressPhaser.getParent();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.isTerminated();
		stressPhaser.getArrivedParties();
		stressPhaser.getRoot();
		stressPhaser.toString();
		stressPhaser.getRegisteredParties();
		stressPhaser.getArrivedParties();
		stressPhaser.getRoot();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.isTerminated();
		stressPhaser.getPhase();
		stressPhaser.getRegisteredParties();
		stressPhaser.getRegisteredParties();
		stressPhaser.getPhase();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.getArrivedParties();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.getArrivedParties();
		stressPhaser.arrive();
		stressPhaser.isTerminated();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.toString();
		stressPhaser.getArrivedParties();
		stressPhaser.getRegisteredParties();
		stressPhaser.getPhase();
		stressPhaser.toString();
		stressPhaser.getArrivedParties();
		stressPhaser.toString();
		stressPhaser.isTerminated();
		stressPhaser.isTerminated();
		stressPhaser.getParent();
		stressPhaser.getParent();
		stressPhaser.getRoot();
		stressPhaser.getPhase();
		stressPhaser.arrive();
		stressPhaser.getPhase();
		stressPhaser.getArrivedParties();
		stressPhaser.getParent();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.isTerminated();
		stressPhaser.isTerminated();
		stressPhaser.isTerminated();
		stressPhaser.getArrivedParties();
		stressPhaser.toString();
		stressPhaser.getRegisteredParties();
		stressPhaser.getArrivedParties();
		stressPhaser.arrive();
		stressPhaser.getArrivedParties();
		stressPhaser.toString();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.getArrivedParties();
		stressPhaser.toString();
		stressPhaser.isTerminated();
		stressPhaser.getParent();
		stressPhaser.getRoot();
		stressPhaser.arrive();
		stressPhaser.getPhase();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.toString();
		stressPhaser.getParent();
		stressPhaser.isTerminated();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.getArrivedParties();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.isTerminated();
		stressPhaser.getRegisteredParties();
		stressPhaser.getRegisteredParties();
		stressPhaser.arrive();
		stressPhaser.getRoot();
		stressPhaser.isTerminated();
		stressPhaser.getArrivedParties();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getArrivedParties();
		stressPhaser.getRegisteredParties();
		stressPhaser.getRoot();
		stressPhaser.getArrivedParties();
		stressPhaser.getArrivedParties();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.toString();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.toString();
		stressPhaser.getParent();
		stressPhaser.getRoot();
		stressPhaser.getRegisteredParties();
		stressPhaser.getRoot();
		stressPhaser.getRoot();
		stressPhaser.arrive();
		stressPhaser.getRegisteredParties();
		stressPhaser.getParent();
		stressPhaser.getParent();
		stressPhaser.getParent();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.getParent();
		stressPhaser.getRegisteredParties();
		stressPhaser.toString();
		stressPhaser.toString();
		stressPhaser.getParent();
		stressPhaser.arrive();
		stressPhaser.isTerminated();
		stressPhaser.arrive();
		stressPhaser.getRegisteredParties();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getRoot();
		stressPhaser.getRegisteredParties();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.toString();
		stressPhaser.isTerminated();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getRegisteredParties();
		stressPhaser.isTerminated();
		stressPhaser.getArrivedParties();
		stressPhaser.getRegisteredParties();
		stressPhaser.arrive();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.arrive();
		stressPhaser.arrive();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.toString();
		stressPhaser.getRoot();
		stressPhaser.arrive();
		stressPhaser.arrive();
		stressPhaser.getParent();
		stressPhaser.getParent();
		stressPhaser.getRoot();
		stressPhaser.arrive();
		stressPhaser.getPhase();
		stressPhaser.getPhase();
		stressPhaser.getArrivedParties();
		stressPhaser.getPhase();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.isTerminated();
		stressPhaser.arriveAndDeregister();
		stressPhaser.register();
		stressPhaser.getParent();
		stressPhaser.getRegisteredParties();
		stressPhaser.isTerminated();
		stressPhaser.toString();
		stressPhaser.getParent();
		stressPhaser.toString();
		stressPhaser.getRoot();
		stressPhaser.getParent();
		stressPhaser.getParent();
		
		stressPhaser.arriveAndDeregister();		// Deregister once we are done
	}
	
	private class PhaserHelperThread implements Runnable
	{
		private Phaser phaser = null;
		private int phaseToWaitFor = -1;
		private boolean allowInterrupt = false;
		private boolean expectInterrupt = false;
		private boolean awaitOthers = false;
		private boolean deregisterTest = false;
		
		private boolean executionFinished = false;
		private boolean interrupted = false;
		private boolean waiting = false;
						
		public PhaserHelperThread(Phaser phaserIn, boolean awaitOthersIn, int phaseToWaitForIn, boolean allowInterruptIn, boolean expectInterruptIn, boolean deregisterTestIn)
		{
			phaser = phaserIn;
			awaitOthers = awaitOthersIn;
			phaseToWaitFor = phaseToWaitForIn;
			allowInterrupt = allowInterruptIn;
			expectInterrupt = expectInterruptIn;
			deregisterTest = deregisterTestIn;
			
			// Register with the Phaser
			phaser.register();
		}		
				
		public boolean isExecutionFinished()
		{
			return executionFinished;
		}
		
		
		public boolean wasInterrupted()
		{
			return interrupted;
		}
		
		public synchronized boolean isWaiting()
		{
			return waiting;
		}
		
		public void run() 
		{
			// There are multiple possible testcases to run depending on the options passed in
			//
			// 1) This thread arrives at the Phaser and then deregisters itself
			if(deregisterTest)
			{
				phaser.arriveAndDeregister();
			}
			// 2) This thread waits for the phase of the Phaser to change from phaseToWaitFor to phaseTowaitFor + 1
			else if(!awaitOthers && phaseToWaitFor != -1 && !allowInterrupt)
			{
				phaser.arriveAndDeregister();
				synchronized (this)
				{
					waiting = true;
				}
				phaser.awaitAdvance(phaseToWaitFor);
			}
			// 3) The thread awaits for the phase change as above but can be interrupted
			else if(!awaitOthers && phaseToWaitFor != -1 && allowInterrupt)
			{
				try 
				{
					phaser.arriveAndDeregister();
					synchronized (this)
					{
						waiting = true;
					}
					phaser.awaitAdvanceInterruptibly(phaseToWaitFor);
				}
				catch (InterruptedException e) 
				{
					interrupted = true;
					if(!expectInterrupt)
					{
						e.printStackTrace();
					}
				}
			}
			// 4) The thread arrives at the Phaser and then blocks until all other registered parties have also arrived
			else if(awaitOthers)
			{
				phaser.arriveAndAwaitAdvance();
			}
			// 5) The thread simply arrives and terminates
			else
			{
				phaser.arrive();
			}				
			waiting = false;
			executionFinished = true;
		}		
	}
	
	@SuppressWarnings("serial")
	private class SVTException extends IOException
	{
		
	}
}
