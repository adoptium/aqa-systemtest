/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

/*
 * Summary: The event thread for debugging the connections and their target VMs
 */

package net.adoptopenjdk.test.jdi.debugger;

import java.util.*;
import java.io.*;

import com.sun.jdi.*;
import com.sun.jdi.connect.*;
import com.sun.jdi.event.*;
import com.sun.jdi.request.*;

import net.adoptopenjdk.test.jdi.debugger.EventT.ThreadTrace;

public class EventT extends Thread {

	public VirtualMachine vm;
	public boolean connected = true; //State of connection to VM
	//Excluded classes that we don't want events for
	private String[] exclude = {"java.*", "javax.*", "sun.*", "com.sun.*"};
	private Map<ThreadReference, ThreadTrace> traceMap = new HashMap<ThreadReference, ThreadTrace>();
	static String nextBaseIndent = ""; 
	public EventRequestManager eventRM;
	public String[] eventArray;
	public EventSet eventSet;
	public String mainClass;
	public boolean step = false;
	
	EventT(VirtualMachine vm, String[] exclude, String[] eventArray, String mainClass) {
		super("event-handler");
		this.vm = vm;
		this.exclude = exclude;
		this.eventArray = eventArray;
		this.mainClass = mainClass;
	}

	public void run(){
		//Try out poking the VM
		System.out.println("Start poking the VM");
		
		//Useful JDI debugging information returned using this
		vm.setDebugTraceMode(0);
		/*
		 *  0) None
		 *  1) JDI Sending
		 *  2) JDI Receiving
		 *  3) 1 + 2
		 *  4) JDI Event summary
		 *  5) 1 + 4
		 *  6) 2 + 4
		 */ 
		
		//Event queue of requests, send them to be handled
		EventQueue eventQ = vm.eventQueue();
		System.out.println("Created an event queue");
		//While connected take events from the event queue and send them to be handled
		while(connected){	
			try{
				eventSet = eventQ.remove();
				EventIterator eventIt = eventSet.eventIterator();
				while (eventIt.hasNext()) {
					Event x = eventIt.nextEvent();
					handleEvent(x);
				}
				eventSet.resume();
			} catch (InterruptedException exc) {
				System.out.println("Unexpected interrupt occurred when removing events from the event queue");
				exc.printStackTrace();
				
			} catch (VMDisconnectedException vmde){
				handleDisconnectedException();
				break;
					
			}
		}
	}
	
	//This is used if no events are set, so it sets up the basic events and infrastructure
	void setEventRequests(){
		//Create an event request manager
		EventRequestManager eventRM = vm.eventRequestManager();

		//Grab all exceptions
		ExceptionRequest exceptionReq = eventRM.createExceptionRequest(null, true, true); 
		//Suspend so we can step
		exceptionReq.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		exceptionReq.enable();
		
		//Add a method entry event request, notification upon method entry
		//Excluding the common in build sun classes (and IBM classes if using IBM Java) which shouldn't be that relevant and would overwhelm.
		MethodEntryRequest menthodER = eventRM.createMethodEntryRequest();
		for (int i=0; i<exclude.length; ++i) {
			menthodER.addClassExclusionFilter(exclude[i]);
		}
		menthodER.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		menthodER.enable();
		
		//Add a method exit event request, notification upon method exit
		MethodExitRequest menthodExR = eventRM.createMethodExitRequest();
		for (int i=0; i<exclude.length; ++i) {
			menthodExR.addClassExclusionFilter(exclude[i]);
		}
		menthodExR.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		menthodExR.enable();
		
		//Join up with the main upon connection/thread death
		ThreadDeathRequest threadDR = eventRM.createThreadDeathRequest();
		threadDR.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		threadDR.enable();
		
		System.out.println("Set up event requests");
	}
	
	//Split up event requests into individual event requests
	//Setup infrastructure such as event request manager, exception request and class prepare event
	public void setupEventRequestManager(VirtualMachine vm){
		//Create an event request manager
		eventRM = vm.eventRequestManager();

		//Grab all exceptions
		ExceptionRequest exceptionReq = eventRM.createExceptionRequest(null, true, true); 
		//Suspend so we can step
		exceptionReq.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		exceptionReq.enable();

		//Request a notification when class with specified name is loaded, in this case it is the main class of
		// the target VM, this is necessary so that other events may then be requested, as this many only occur
		//when a class reference exists
		ClassPrepareRequest cpr = eventRM.createClassPrepareRequest();

		//Tell the VM to stop whenever one of these events occurs
		cpr.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		cpr.addClassFilter(mainClass);
		cpr.enable();
		
		//Request notification when the class is unloaded
		ClassUnloadRequest cur = eventRM.createClassUnloadRequest();

		cur.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		cur.addClassFilter(mainClass);
		cur.enable();
		
	}
	
	public void setMethodEntryRequest(){
		MethodEntryRequest menthodER = eventRM.createMethodEntryRequest();
		for (int i=0; i<exclude.length; ++i) {
			menthodER.addClassExclusionFilter(exclude[i]);
		}
		menthodER.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		menthodER.enable();
	}
	
	public void setMethodExitRequest(){
		MethodExitRequest menthodExR = eventRM.createMethodExitRequest();
		for (int i=0; i<exclude.length; ++i) {
			menthodExR.addClassExclusionFilter(exclude[i]);
		}
		menthodExR.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		menthodExR.enable();
		
	}
	
	public void setThreadDeathRequest(){
		ThreadDeathRequest threadDR = eventRM.createThreadDeathRequest();
		// Make sure we sync on thread death
		threadDR.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		threadDR.enable();
	}
	
	private void handleEvent(Event event) {
		if (event instanceof ExceptionEvent) {
			exceptionEvent((ExceptionEvent)event);
		} else if (event instanceof MethodEntryEvent) {
			System.out.println("---- MethodEntry ----");
			methodEntryEvent((MethodEntryEvent)event);
		} else if (event instanceof MethodExitEvent) {
			System.out.println("---- MethodExit ----");
			methodExitEvent((MethodExitEvent)event);
		} else if (event instanceof VMStartEvent) {
			vmStartEvent((VMStartEvent)event);
		} else if (event instanceof StepEvent) {
			System.out.println("---- StepEvent ----");
			stepEvent((StepEvent)event);
		} else if (event instanceof VMDeathEvent) {
			vmDeathEvent((VMDeathEvent)event);
		} else if (event instanceof VMDisconnectEvent) {
			System.out.println("---- VMDisconnectEvent ----");
			vmDisconnectEvent((VMDisconnectEvent)event);
		} else if (event instanceof ThreadDeathEvent) {
			System.out.println("---- ThreadDeathEvent ----");
			threadDeathEvent((ThreadDeathEvent)event);
		} else if (event instanceof ClassPrepareEvent) {
			System.out.println("---- ClassPrepareEvent ----");
			classPrepareEvent((ClassPrepareEvent)event);
		} else if (event instanceof ClassUnloadEvent) {
			System.out.println("---- ClassUnloadEvent ----");
		} else if (event instanceof AccessWatchpointEvent) {
			System.out.println("---- AccessWatchpointEvent hit ----");
		} else if (event instanceof ModificationWatchpointEvent) {
			System.out.println("---- ModificationWatchpointEvent hit ----");
		} else if (event instanceof BreakpointEvent) {
			System.out.println("---- BreakpointEvent hit ----");
			breakpointEvent((BreakpointEvent)event);
		} else {
			System.out.println ("Unexpected event!");
		}
	}
	
	synchronized void handleDisconnectedException(){
		System.out.println("In handleDisconnectedException");
		EventQueue eventQ = vm.eventQueue();
		while(connected){
			try{
				EventSet eventSet = eventQ.remove();
				EventIterator eventIt = eventSet.eventIterator();
				while (eventIt.hasNext()) {
					Event event = eventIt.nextEvent();
					if (event instanceof VMDeathEvent) {
						System.out.println("---- VM Death Event ----");
						vmDeathEvent((VMDeathEvent)event);
					} else if (event instanceof VMDisconnectEvent) {
						System.out.println("---- VM Disconnect Event ----");
						vmDisconnectEvent((VMDisconnectEvent)event);
					} 
				}
				eventSet.resume();
			} catch (InterruptedException exc) {
				System.out.println("Unexpected interrupt occurred when removing events from the event queue");
				exc.printStackTrace();
				
			}
		}
	}
	
	void vmStartEvent(VMStartEvent event)  {
		System.out.println("VM started....");
	}
	
	void vmDeathEvent(VMDeathEvent event)  {
		connected = false;
		System.out.println("VM died.");
	}
	
	void vmDisconnectEvent(VMDisconnectEvent event)  {
		connected = false;
		System.out.println("VM disconnected.");
	}
	
	private void classPrepareEvent(ClassPrepareEvent event){
		ReferenceType ref = ((ClassPrepareEvent)event).referenceType();
		Field field = null;
		Method method = null;

		for (int i = 0; i < eventArray.length; i++){

			String[] properties = eventArray[i].split(":");
			
			if (properties[0].regionMatches(0,"accessWatchpoint",0,15)){
				System.out.println("Setting accessWatchpointRequest");
				
				field = ref.fieldByName(properties[1]);
				System.out.println("Field: " + field);
				
				AccessWatchpointRequest accessWatchpointR = eventRM.createAccessWatchpointRequest(field);
				accessWatchpointR.setSuspendPolicy(EventRequest.SUSPEND_NONE);
				accessWatchpointR.enable();
			}
			else if (properties[0].regionMatches(0,"modificationWatchpoint",0,16)){
				System.out.println("Setting modificationWatchpointRequest");
				field = ref.fieldByName(properties[1]);
				System.out.println("Field: " + field);
				
				ModificationWatchpointRequest modificationWatchpointR = eventRM.createModificationWatchpointRequest(field);
				modificationWatchpointR.setSuspendPolicy(EventRequest.SUSPEND_NONE);
				modificationWatchpointR.enable();

			}
			else if (properties[0].regionMatches(0,"breakpoint",0,10)){
				System.out.println("Setting breakpointRequest");
				
				if (properties.length == 3){
				if (properties[2].equals("step")){
					step = true;
					System.out.println("Step into breakpoint requested");
				}
				}
				
				//List allTheMethods = ref.allMethods();
				List allTheMethods = ref.methodsByName(properties[1]);
				Iterator ite = allTheMethods.iterator();
				while (ite.hasNext()) {
					method = (Method)ite.next();
					System.out.println("Methods: " + method);
				}
				Location loc = method.location();
				
				BreakpointRequest breakpointR = eventRM.createBreakpointRequest(loc);
				breakpointR.setSuspendPolicy(EventRequest.SUSPEND_ALL);
				breakpointR.enable();
				
				
			}
			else if (properties[0].regionMatches(0,"deleteBreakpoints",0,15)){
				System.out.println("Deleting breakpoints....");
				
				
				//List all breakpoints
				List allBreakpoints = eventRM.breakpointRequests();
				Iterator ite = allBreakpoints.iterator();
				while (ite.hasNext()) {
					System.out.println("Breakpoints " + ite.next());
				}
				eventRM.deleteAllBreakpoints();
				
				System.out.println(".....breakpoints deleted.");
			}
			else if (properties[0].regionMatches(0,"numOfInstances",0,10)){
				//Print out the number of instances of the main class
				if (vm.canGetInstanceInfo()){
					List listOfInstances = ref.instances(0);
					int numOfInstances = listOfInstances.size();
					System.out.println("Number of instances of main class: " + numOfInstances);
					if (numOfInstances > 0){
						Iterator ite = listOfInstances.iterator();
						while (ite.hasNext()) {
							ObjectReference objRef = (ObjectReference)ite.next();
							System.out.println("Number of instances: " + objRef);
							List referringObjList = objRef.referringObjects(3);
							Iterator it = referringObjList.iterator();
							while (it.hasNext()) {
								ObjectReference objRef2 = (ObjectReference)it.next();
								System.out.println("Referring objects" + objRef2);
							}
						}
					}
				}
				else{
					System.out.println("Can get instance info is " + vm.canGetInstanceInfo());
				}
			}
		} 
	}
	
	private void methodEntryEvent(MethodEntryEvent event)  {
		System.out.println(event.method().name() + "  -  " 
				+ event.method().declaringType().name());
	}
	
	private void methodExitEvent(MethodExitEvent event)  {
	}

	// Here is an example of using stepping with an exceptionEvent
	private void exceptionEvent(ExceptionEvent event) {
		/*ThreadTrace trace = (ThreadTrace)traceMap.get(event.thread());
		if (trace != null) {
			trace.exceptionEvent(event);
		}
		System.out.println("Exception: " + event.exception() + "  -  " 
							+ "Catch: " + event.catchLocation());

		EventRequestManager eventRM = vm.eventRequestManager();
		StepRequest stepReq = eventRM.createStepRequest(thread, StepRequest.STEP_MIN, StepRequest.STEP_INTO);
		System.out.println("Setting up step request.....");
		// suspend so we can step
		//stepReq.addCountFilter(1);  // next step only
		System.out.println("setting step counter.....");
		//stepReq.setSuspendPolicy(EventRequest.SUSPEND_ALL);
		System.out.println("continuing with step request.....");
		stepReq.enable();
		System.out.println("step request done");
		*/
	}
	
	void threadDeathEvent(ThreadDeathEvent event)  {
		ThreadTrace trace = (ThreadTrace)traceMap.get(event.thread());
		if (trace != null) {  // only want relevant threads
			trace.threadDeathEvent(event);   // Forward event
		}
		// Here is an example of using stepping with an exceptionEvent
		//System.out.println("**** Exiting " + thread.name() + " thread *****");
	}
	
	private void breakpointEvent(BreakpointEvent event) {
		
		if (step == true){
			ThreadReference thread1 = event.thread();
			thread1.suspend();
			System.out.println("Creating step event.....");
			StepRequest stepReq = eventRM.createStepRequest(event.thread(), StepRequest.STEP_MIN, StepRequest.STEP_OVER);
			stepReq.setSuspendPolicy(EventRequest.SUSPEND_ALL);
			stepReq.addCountFilter(1);
			
			try{
				stepReq.enable();
				eventSet.resume();
				System.out.println("....enabled step event");
				vm.resume();
			}
			catch (IllegalThreadStateException itse){
				System.out.println("if this is a StepRequest and the thread named in the request has died.");
				itse.printStackTrace();
				
			}
			catch (InvalidRequestStateException irse){
				System.out.println("InvalidRequestStateException");
				irse.printStackTrace();
			}
			step = false;
		}
		
		// Here is an example of using stepping with an exceptionEvent
		//threadTrace(event.thread()).breakpointEvent(event);
	}
	
	private void stepEvent(StepEvent event)  {
		System.out.println("Stepping...");
		System.out.println("Stepping into " + event.location().method().name() + "  -  " 
				+ event.location().method().declaringType().name());
	}
	
	class ThreadTrace {
		final ThreadReference thread;
		final String baseIndent;
		static final String threadDelta = "                     ";
		StringBuffer indent;
		
		ThreadTrace(ThreadReference thread) {
			this.thread = thread;
			this.baseIndent = nextBaseIndent;
			indent = new StringBuffer(baseIndent);
			nextBaseIndent += threadDelta;
			System.out.println("**** Entering " + thread.name() + " thread *****");
		}
		
		void threadDeathEvent(ThreadDeathEvent event)  {
			indent = new StringBuffer(baseIndent);
			System.out.println("**** Exiting " + thread.name() + " thread *****");
		}
		
		void exceptionEvent(ExceptionEvent event)  {
			System.out.println("Exception: " + event.exception() + "  -  " 
					+ "Catch: " + event.catchLocation());
	
			EventRequestManager eventRM = vm.eventRequestManager();
			StepRequest stepReq = eventRM.createStepRequest(thread, StepRequest.STEP_MIN, StepRequest.STEP_INTO);
			System.out.println("Setting up step request.....");
			// suspend so we can step
			System.out.println("setting step counter.....");
			System.out.println("continuing with step request.....");
			stepReq.enable();
			System.out.println("step request done");
		}
		
		void breakpointEvent(BreakpointEvent event) {
			System.out.println("Creating step event.....");
			StepRequest stepReq = eventRM.createStepRequest(thread, StepRequest.STEP_LINE, StepRequest.STEP_OVER);
			System.out.println("Created step request.....");
			stepReq.setSuspendPolicy(EventRequest.SUSPEND_ALL);
			stepReq.addCountFilter(1);
			System.out.println("Added step filter.....");
			
			List allTheSteps = eventRM.stepRequests();
			Iterator iterat = allTheSteps.iterator();
			while (iterat.hasNext()) {
				StepRequest stepRequest = (StepRequest)iterat.next();
				ThreadReference stepThread = stepRequest.thread();
				//System.out.println("Steps: size = " + stepRequest.size() + " depth = " + stepRequest.depth());
			}
			
			try{
				stepReq.enable();
				//thread1.resume();
				eventSet.resume();
				System.out.println("....enabled step event");
				//vm.resume();
			}
			catch (IllegalThreadStateException itse){
				System.out.println("if this is a StepRequest and the thread named in the request has died.");
				itse.printStackTrace();
				
			}
			catch (InvalidRequestStateException irse){
				System.out.println("InvalidRequestStateException");
				irse.printStackTrace();
			}
		}
		
		// Step to exception catch
		void stepEvent(StepEvent event)  {
			// Adjust call depth
			System.out.println("in stepEvent");
			EventRequestManager eventRM = vm.eventRequestManager();
			eventRM.deleteEventRequest(event.request());
		}
	}
	
	ThreadTrace threadTrace(ThreadReference thread) {
		ThreadTrace trace = (ThreadTrace)traceMap.get(thread);
		if (trace == null) {
			trace = new ThreadTrace(thread);
			traceMap.put(thread, trace);
		}
		return trace;
	}
}