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

/*
 * Summary: This class creates a connection between a target vm and a debugger, either launching the target vm 
 * from this class, listening on a specific port or attaching to a already waiting process. Each of these is
 * kicked off by a different thread so that the whole process is not halted due to waiting on attaching target 
 * VMs.
 * Then tracing can start using the Event thread, events can be placed in an event manager so that the debugger
 * is notified when such a event occurs. 
 * To allow an adaptable interface the connection and event information is taken from a properties file.
 */

package net.adoptopenjdk.test.jdi.debugger;

import java.util.*;
import java.io.*;
import com.sun.jdi.*;
import com.sun.jdi.connect.*;
import com.sun.jdi.connect.Connector.Argument;
import com.sun.jdi.event.*;
import com.sun.jdi.request.*;
import java.util.Date;
import java.text.DateFormat;


public class Connectors
{
	public Properties props;
	
	 // Thread transferring remote error stream to our error stream
	private Thread errorThread = null;
	// Thread transferring remote output stream to our output stream
	private Thread outputThread = null;

	private Process process = null;
	private boolean launchedVM = false;
	public VirtualMachine vm;
	public Connector connector;
	public Map defaults;
	public ArrayList<Map<String, Argument>> connectionSettings;
	public Map<String, Argument>[] mappins;
	public boolean connected = false; //State of connection to VM
	//Classes that we don't want events for
	private String[] exclude = {"java.*", "javax.*", "sun.*", "com.sun.*", "com.ibm.*"};
	
	//Loaded event properties
	public int numOfEvents;
	public String[] eventArray;
	public String[][] eventArrayPerVM;
	public int numOfConnections;
	public String[] connectionsArray;
	public VirtualMachine[] vmArray;
	public boolean loadedEvents = false;
	public String transportType;
	
	public static String targetvmPath;
	public static String mainClass;
	public static String additionalOptions;
	private static final String MAIN_CLASS = "";
	private static String ADD_OPTIONS = "-classpath .";
	
	private static Object orderSynch = new Object();
	private static int lowestListener = 10000;
	
	public static void main(String[] args)
	{
		System.out.println("Connectors starting up @" + DateFormat.getDateTimeInstance().format(new Date())   );

		System.out.println("classpath: " + System.getProperty("java.class.path"));
		
		new Connectors(args);

		System.out.println("\nConnectors closing @" + DateFormat.getDateTimeInstance().format(new Date())  );
	}
	
	/**
	 *  Different way of connecting to a VM
	 *  
	 * 1)Launching a VM from the debugger
	 * 2)Debugger connects to a previously running VM
	 * 3)VM attaches to a previously running debugger
	 * 4)VM launches the debugger
	 * 
	 * Useful explanations for the VirtualMachineManager class can be found online.
	 */
	Connectors(String[] args){
		if (args.length < 1){
			System.out.println("Unrecognised property file provided.");			
			System.exit(1);
		}
		String connectionType = args[0];
		transportType = args[1];
		targetvmPath = args[2];
		mainClass = MAIN_CLASS;
		additionalOptions = "-classpath \"" + targetvmPath + "\"" +
							" -Djava.net.preferIPv4Stack=true ";

		System.out.println("Connection file is " + connectionType);
		System.out.println("Transport type is " + transportType);
		//Load the properties file in to find out how many connections are required and what type they are
		if (loadProperties(args[0])){
			String numOfConnectionsString = props.getProperty("numOfConnections");
			Integer numOfConnectionsInteger = new Integer(numOfConnectionsString);
			numOfConnections = numOfConnectionsInteger.intValue();
			System.out.println("Number of connections = " + numOfConnections);
			
			//Put all the different connections into an array so we can iterate through all the connections/VMs
			connectionsArray = new String [numOfConnections];
			vmArray = new VirtualMachine [numOfConnections];
			for (int i = 0; i < numOfConnections; i++){
				connectionsArray[i] = props.getProperty("connection" + i);
				System.out.printf("Connection[%d] = %s\n", i, connectionsArray[i]);
			}
				
			//Now find out how many and what events there are for each VM
			eventArrayPerVM = new String[numOfConnections][];
			System.out.println("Loading properties....");
			for (int i = 0; i < numOfConnections; i++){
				String numOfEventsString = props.getProperty("vm" + i + "." + "numOfEvents");
				Integer numOfEventsInteger = new Integer(numOfEventsString);
				numOfEvents = numOfEventsInteger.intValue();
				System.out.println("vm" + i + ".number of events loaded = " + numOfEvents);
				eventArrayPerVM[i] = new String[numOfEvents];
				for (int j = 0; j < numOfEvents; j++){
					eventArrayPerVM[i][j] = props.getProperty("vm" + i + "." + "event" + j);
					System.out.println("vm" + i + "." + "event" + j + " loaded = " + eventArrayPerVM[i][j]);
				}
				System.out.println();
			}

			loadedEvents = true;
				
				
			//Create an array of Maps to hold the connection settings for each connection so the correct
			// attaching and listening is done.
			connectionSettings = new ArrayList<Map<String, Argument>>();
			for (int i = 0 ; i < connectionsArray.length ; i++) {
				connectionSettings.add(null);
			}
			
				
			//Need to kick off each of the new connections; they should be threaded so they all start at 
			// a similar time and there is no waiting for attaching to occur
			Thread[] connectingThread = new Thread[connectionsArray.length];
			for (int i = 0; i < connectionsArray.length; i++){
				connectingThread[i] = new CreateConnectionThread(i);	
			}
			for (int i = 0; i < connectionsArray.length; i++){
				connectingThread[i].start();
			}
			//Wait till all the connecting has occurred
			for (int i = 0; i < connectionsArray.length; i++){
				try
				{
					connectingThread[i].join();
				} 
				catch (InterruptedException ie)
				{
					System.out.println("Unexpected interrupt occurred when the connecting Thread was joined");
				}
			}
				
			System.out.println("***** Finished connecting ******");
				
			//Now start tracing the VMs	
			for (int i = 0; i < connectionsArray.length; i++){
				System.out.println();
				if (vmArray[i] != null)
				{
					System.out.println("***** Starting trace for vm" + vmArray[i] + " ******");				
					generateTrace(vmArray[i],i);
					System.out.println("***** Finished trace for vm" + vmArray[i] + " ******");

				}
				else
				{	
					System.out.println("***** ERROR: vm" + i + " was null ******");	
					System.exit(1);
				}	
			}
				
		}
		else {
			System.out.println("Unrecognised connection type or properties file. Choose one of: launch, attach or listen or provide a .prop file.");
			System.exit(1);
		}
		
	}
	
	public boolean loadProperties(String propertiesFile){
		System.out.println("Trying to load property file....");
		props = new Properties();
		try{
			FileInputStream PropertiesFile = new FileInputStream(propertiesFile);
			props.load(PropertiesFile);
			
			PropertiesFile.close();
			return true;
		} catch (FileNotFoundException fe){
			System.out.println("Unable to find the properties file (" + propertiesFile + ")");
			fe.printStackTrace();
		} catch (IOException ie){
			System.out.println("Problem either loading or closing the properties file (" + propertiesFile + ")");
			ie.printStackTrace();			
		}
		
		return false;		
	}
	
	public Connector listConnectors(){
		//Create a list of connectors and return them
		List currentConnectors = Bootstrap.virtualMachineManager().allConnectors();
		Object[] connectors = currentConnectors.toArray();

		for (int i=0; i < connectors.length; i++)
		{
			Connector connectorItem = (Connector)connectors[i];
			System.out.println(connectorItem);
		}
		
		return null;
		
	}
	public Connector listConnectors(String connectionType){
		//Create a list of connectors to find a match to the type we are looking for, and return the matching 
		//connector types
		List currentConnectors = Bootstrap.virtualMachineManager().allConnectors();
		Object[] connectors = currentConnectors.toArray();
		Connector connector = null;
		System.out.println("Listing connectors:");
		for (int i=0; i < connectors.length; i++)
		{
			Connector connectorItem = (Connector)connectors[i];
			if (connectorItem.name().equals(connectionType) && connector == null) {
				connector = connectorItem;
				System.out.println("Matched: " + connector.name());
			}
			else
			{
				System.out.println(connectorItem.name());
			}
		}
		
		return connector;
		
	}

	//Kick off the event thread
	void generateTrace(VirtualMachine vm1, int vmNumber) {
		
		if (vm1 == null)
		{
			System.out.println("Return Virtual Machiene passed to the generateTrace() function was null");
			return;
		}
		
		List<ReferenceType>  refs = vm1.allClasses();
		eventArray = eventArrayPerVM[vmNumber];
		
		System.out.println("Starting trace thread.....");
		mainClass = props.getProperty("mainClass" + vmNumber);
		
		EventT eventThread = new EventT(vm1, exclude, eventArray, mainClass); 
		System.out.println("LoadedEvents " + loadedEvents);
		
		//If events have not been loaded properly just load up the defaults
		if (loadedEvents == false){
			eventThread.setEventRequests();
		}
		//If events have been loaded, then create the event manager, and then set the appropriate events
		else {
			System.out.println("Setting setupEventRequestManager");
			//Set up the event request manager and other infrastructure stuff
			eventThread.setupEventRequestManager(vm1);
			for (int i = 0; i < eventArray.length; i++){
				//Count the number of instances of objects, useful for heap checking
				if (eventArrayPerVM[vmNumber][i] == null){
					System.out.println("ERROR: Mismatching number of events with numOfEvents in property file!!!");
					System.exit(1);
				}
				else if (eventArrayPerVM[vmNumber][i].equals("countInstances")){
					System.out.println("Counting instances");
					
					System.out.print("NumOfInstances: ");
					long[] instanceCount = vm1.instanceCounts(refs);
					for(int j = 0; j < instanceCount.length; j++){
						System.out.print(" " + instanceCount[j]);   
					}
					System.out.println();
				}
				else if (eventArrayPerVM[vmNumber][i].equals("vmName")){
					System.out.println("VM name: " + vm1.name());
				}
				else if (eventArrayPerVM[vmNumber][i].equals("methodEntry")){
					System.out.println("Setting MethodEntryRequest");
					eventThread.setMethodEntryRequest();
				}
				else if (eventArrayPerVM[vmNumber][i].equals("methodExit")){
					System.out.println("Setting MethodExitRequest");
					eventThread.setMethodExitRequest();
				}//The other events need to be set upon the class prepare event
			}
			
		}
		eventThread.start();
		//Only run this if it is a launched VM....
		//Since the launched VM does not have it's own std.out/err, we need to capture and pipe the output-
		
		if (connectionsArray[vmNumber].equals("launch")){
			System.out.println("Debugger launched VM so piping error/output to debuggers error/output");
			pipeTargetVMOutput(vm1);
		}
		vm1.resume();
		
		// Shutdown begins when the event thread terminates
		try {
			eventThread.join();
			if (connectionsArray[vmNumber].equals("launch")){//We may need to wait for confirmation of join of 
				//output and error threads, but this breaks in perl and doesn't seem necessary.
				
			}
		} catch (InterruptedException exc) {
			// we don't interrupt??
			System.out.println("Unexpected interrupt when joining event thread");
		}
	}
	
	//Launch the target VM from within the debugger
	public VirtualMachine createLaunchingVM(VirtualMachine vm, int i)
	{
		/* Simple connection the debugger launches the VM */
		Connector launchConnector = listConnectors("com.sun.jdi.CommandLineLaunch");
		
		System.out.println("Connection type = " + launchConnector.name());
		connectionSettings.set(i, launchConnector.defaultArguments());
		
		System.out.println("progress...defaultArguments obtained.");
		mainClass = props.getProperty("mainClass" + i);
		setMapArguments("main", mainClass, i);
		setMapArguments("options", additionalOptions, i);
		dumpMap(connectionSettings.get(i),"vm"+i);

		LaunchingConnector lc = (LaunchingConnector)launchConnector;
		
		try {
			vm = lc.launch(connectionSettings.get(i));
			launchedVM = true;
			System.out.println("progress...VirtualMachine obtained. VM is " + vm);
		} 

		catch (IOException ie) { // GPV: For a launch this means "unable to launch", and it's not worth retrying
			System.out.println("IOException, Unable to launch VM in createLaunchingVM()" + DateFormat.getDateTimeInstance().format(new Date()) + ".");
			System.out.println(ie.getMessage());
			ie.printStackTrace();
			return null;
		}
		
		catch (IllegalConnectorArgumentsException icae)	{
			System.out.println("IllegalConnectorArgumentsException in createLaunchingVM()");
			System.out.println(icae.getMessage());
			icae.printStackTrace();
			return null;
		}
		catch (VMStartException vmse) {
			System.out.println("VMStartException in createLaunchingVM()");
			System.out.println(vmse.getMessage());
			vmse.printStackTrace();
			return null;
		}
		catch (Throwable t) {
			System.out.println("Unexpected Throwable in createLaunchingVM()");
			System.out.println("Throwable is of type : " + t.getClass().getName());
			System.out.println("Throwable getMessage=>" + t.getMessage());
			t.printStackTrace();
			return null;
		}
		return vm;
	}
	
	public VirtualMachine createAttachingVM(VirtualMachine vm, int i){
		/*
		 * Attaching to a VM already started with:
		 * java -Xrunjdwp:transport=dt_socket,address=800,server=y -Xdebug -Xnoagent -Djava.compiler=NONE Simple
		 * Not sure what advantages -Xdebug -Xnoagent -Djava.compiler=NONE have....
		 * TODO: Should we also try SharedMemory attaching?
		 */
		
		String transportName;
		System.out.println("Transport name is " + transportType);
		if (transportType.equals("dt_shmem"))
		{
			transportName = "com.sun.jdi.SharedMemoryAttach";
		}
		else
		{
			transportName = "com.sun.jdi.SocketAttach";
		}
		System.out.println("Transport type is " + transportName);
		Connector attachConnector = listConnectors(transportName);
		if (attachConnector == null){
			System.out.println("Connector null!");
		}
		
		System.out.println("Connection type = " + attachConnector.name());
		connectionSettings.set(i, attachConnector.defaultArguments());
		System.out.println("progress...defaultArguments obtained.");
		
		String socketOrShared;
		if(transportType.equals("dt_shmem")) //Sharedmemory transport
		{
			String sharedmemoryLoc = props.getProperty("sharedmemory" + i);
			setMapArguments("name", sharedmemoryLoc, i);
			socketOrShared = "shared memory location " + sharedmemoryLoc;
		}
		else //Socket transport
		{
			String port = props.getProperty("port" + i);
			setMapArguments("port", port, i);
			socketOrShared = "port " + port;
			
		}
		dumpMap(connectionSettings.get(i),"vm"+i);
		
		AttachingConnector ac = (AttachingConnector)attachConnector;		
		int attempts = 0;
		while (connected == false && attempts < 30) {
			try {
				vm = ac.attach(connectionSettings.get(i));
				connected = true;
				System.out.println("progress...VirtualMachine obtained.");
			} catch (IOException ie) {
				// If we didn't connect keep trying - the jvm being monitored might not be 
				// ready to accept connections yet
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("The sleeping profiler was interrupted");
					e.printStackTrace();
				}
				
				System.out.println("Monitored VM not ready at " + DateFormat.getDateTimeInstance().format(new Date()) +" (attempt " + attempts + ").");
				System.out.println("Wait 5 secs and trying again...");	
				
				attempts++;
				connected = false;
				
				if (attempts == 30) {
					System.out.println("Failed to connect to Monitored VM after 30 attempts - giving up.  IOException received is below:");	 
					ie.printStackTrace();
				}
		}
		catch (IllegalConnectorArgumentsException icae)
		{
			System.out.println("IllegalConnectorArgumentsException in createVM()");
			System.out.println(icae.getMessage());
			icae.printStackTrace();
			return null;
		}
		catch (Throwable t)
		{
			System.out.println("Unexpected Throwable in createVM()");
			System.out.println("Throwable is of type : " + t.getClass().getName());
			System.out.println("Throwable getMessage=>" + t.getMessage());
			t.printStackTrace();
			return null;
		}
	}
		
	System.out.println("No errors in attaching on " + socketOrShared);
		
		return vm;
	}
	
	/**
	 * Here we will LISTEN(2) from connections coming from an externally started JVM 
	 * So WE are the debugger, we will listen and things wanting to be debugged will CONNECT(2) to us.
	 * 
	 * @param vm = OUT The vm who connected to us
	 * @param i  = The index in callers array, e.g. 0 or 1 ... in case we are debugging 2 JVMs at the same time.
	 *             Used for various obscure things in this code but also as a connectionSettings index.
	 * @return	   the vm which is passed in (which should be initialised prior to the method call)
	 */
	
	public VirtualMachine createListeningVM(VirtualMachine vm, int i){		 
		/*
		 * Listening for a VM attaching to debugger:
		 * java -Xrunjdwp:transport=dt_socket,address=800 Simple
		 * or if setting localAddress too then use:
		 * java -Xrunjdwp:transport=dt_socket,address=L3LPD99:800 Simple
		 * TODO: Should we also try SharedMemory attaching?
		 */

		System.out.println("createListeningVM:"+i);

		String transportName;
		if (transportType.equals("dt_shmem"))//Sharedmemory transport
		{
			transportName = "com.sun.jdi.SharedMemoryListen";
		}
		else //Socket transport
		{
			transportName = "com.sun.jdi.SocketListen";
		}
		
		System.out.println("Transport type is " + transportName);
		Connector listenConnector = listConnectors(transportName);

		if (listenConnector == null)
		{
			System.out.println("Connector null!");
		}
		
		System.out.println("Connection type = " + listenConnector.name());
		connectionSettings.set(i, listenConnector.defaultArguments());
		System.out.println("progress...defaultArguments obtained.");
		String socketOrShared;
		
		if(transportType.equals("dt_shmem")) //Sharedmemory transport
		{
			String sharedmemoryLoc = props.getProperty("sharedmemory" + i);
			setMapArguments("name", sharedmemoryLoc, i);
			socketOrShared = "shared memory location " + sharedmemoryLoc;
		}
		else //Socket transport
		{
			String port = props.getProperty("port" + i);
			setMapArguments("port", port, i);
			socketOrShared = "port " + port;
		}
		
		// Here is an example of a different way to change the host - useful for future development of test    
		//setMapArguments("localAddress", "L3LPD99"); 
		
		//Adding extra timeout so listening continues enough for connection to be created
		//Note: starting a JVM on z/OS can take over a minute, so wait for 10 mins 
		setMapArguments("timeout", "600000", i);
		
		dumpMap(connectionSettings.get(i),"vm"+i);
		
		ListeningConnector lc = (ListeningConnector)listenConnector;
		
		boolean error = false;
		
		// This is now unsynchronised , this means we have (2?) threads here listening on different ports
		try {
			System.out.println("VM:" + i +" is Starting to listen at " + DateFormat.getDateTimeInstance().format(new Date()));
			System.out.println("Listen address["+i+"] = "+ lc.startListening(connectionSettings.get(i)) + " listening on " + socketOrShared + ":...... at " + DateFormat.getDateTimeInstance().format(new Date()));
			vm = lc.accept(connectionSettings.get(i));
			connected = true;
			System.out.println("...... VirtualMachine obtained on " + socketOrShared + " at " + DateFormat.getDateTimeInstance().format(new Date()));
		
		} 	
		catch (TransportTimeoutException ie) {
			// We listen for a maximum time ...
			error = true;
			System.out.println("TransportTimeoutException from Listening VM (Connectors.java) on " + socketOrShared + 
					" Nobody tried to connect to us before we timed out timeout=" + getMapArguments("timeout", i) +
					" @" + DateFormat.getDateTimeInstance().format(new Date())
					); 
			ie.printStackTrace();
		}
		catch (IOException ie) {
			// If we didn't connect keep trying - the jvm being monitored might not be 
			// ready to accept connections yet
			error = true;
			System.out.println("IO Exception from Listening VM (Connectors.java) on " + socketOrShared + 
					" @" + DateFormat.getDateTimeInstance().format(new Date())
					);
			ie.printStackTrace();
		}
		catch (IllegalConnectorArgumentsException icae)
		{
			error = true;
			System.out.println("IllegalConnectorArgumentsException in createVM()");
			System.out.println(icae.getMessage());
			icae.printStackTrace();
			return null;
		}
		catch (Throwable t)
		{
			error = true;
			System.out.println("Unexpected Throwable in createVM()");
			System.out.println("Throwable is of type : " + t.getClass().getName());
			System.out.println("Throwable getMessage=>" + t.getMessage());
			t.printStackTrace();
			return null;
		}
		
		if(error == false)
		{
			System.out.println("No errors in accepting connection on " + socketOrShared );
		}
		else 
		{
			System.out.println("Errors in accepting connection on " + socketOrShared );
		}
		if(vm == null)
		{
			System.out.println("Errors vm object is null using these connection settings " + socketOrShared );
		}
		
		return vm;
	}

	//Print out the current connection settings
	public synchronized void dumpMap(Map m,String index){
		System.out.println(index+"---> Dumping arguments map contents");
		Set keys = m.keySet();
		Iterator it = keys.iterator();

		Object key, value;
		while (it.hasNext()){
			key = it.next();
			value = m.get(key);
			System.out.println(index+"----> " + value);
		}
	}
	
	//get one of the connection settings
	public String getMapArguments(String arg, int i){
		
		Connector.Argument argument = (Connector.Argument)connectionSettings.get(i).get(arg);
		
		String result;
		
		if (argument == null) {
			result = "NULL";
		}
		result = argument.value();
		
		return result;
	}
	
	//Change the connection settings
	public boolean setMapArguments(String arg, String value, int i){
		
		Connector.Argument argument = (Connector.Argument)connectionSettings.get(i).get(arg);
		if (argument == null) {
			return false;
		}
		argument.setValue(value);
		return true;
	}
	
	//Test the connection to the VM using the in build debugging of JDI
	public boolean checkConnection(){
		//Choose a debugging level
		vm.setDebugTraceMode(0);
		vm.resume();
		return true;
	}
	 
	void pipeTargetVMOutput(VirtualMachine vm) {
		Process process = vm.process();
		errorThread = new StreamReader(process.getErrorStream(), System.out);
		outputThread = new StreamReader(process.getInputStream(), System.out);
		errorThread.start();
		outputThread.start();
		
		System.out.println("Kicked off error reader");
		
	}
	
	//Kick off the different connections 
	class CreateConnectionThread extends Thread{
		int i;
		
		// Constructor: 
		CreateConnectionThread(int i){
				this.i = i;
				this.setName("CreateConnectionThread["+i+"]");
				}
		
		public void run(){
			System.out.println("Connecting vm" + i + "....");
			if (connectionsArray[i].equals("launch")){
				//First get the class name to launch
				mainClass = props.getProperty("mainClass" + i);
				vmArray[i] = createLaunchingVM(vmArray[i], i);
					
				List currentConnectedVMs = Bootstrap.virtualMachineManager().connectedVirtualMachines();
				Object[] connectedVMs = currentConnectedVMs.toArray();
				
				for (int i=0; i < connectedVMs.length; i++)
				{
					System.out.println(connectedVMs[i]);
				}
				
				System.out.println("VM name: " + vmArray[i].name());
			}
			else if (connectionsArray[i].equals("attach")){
				String port = props.getProperty("port" + i);
				if (port == null){
					//set default as 800
					port = "800";
				}
				vmArray[i] = createAttachingVM(vmArray[i],i);
			}
			else if (connectionsArray[i].equals("listen")){
				String port = props.getProperty("port" + i);
				if (port == null){
					//set default as 800
					port = "800";
				}
				vmArray[i] = createListeningVM(vmArray[i],i);
			}
			else{
				System.out.println("Unrecognised connection properties. Choose one of: launch, attach or listen.");
				System.exit(1);
			}
		}
	}
	private static class StreamReader extends Thread
	{
		private BufferedReader bRead = null;
		private PrintStream dump = null;
		StreamReader(InputStream src, PrintStream sink)
		{
			bRead = new BufferedReader(new InputStreamReader(src));
			dump = sink;
		}
		public void run()
		{
			try
			{
				String line = null;
				while ((line = bRead.readLine()) != null)
				{
					System.out.print("**** Target VM output: ");
					dump.print(line);
					System.out.println(" ****");
				}
			
			} catch (IOException e)
			{
				//Error reading... 
				System.out.println("Error will reading from BufferedReader");
				e.printStackTrace();
			} finally
			{
				try
				{
					bRead.close();
				} catch (IOException e)
				{
					System.out.println("Error will closing BufferedReader");
					e.printStackTrace();
				}
			}
		}
	} //StreamReader
}
