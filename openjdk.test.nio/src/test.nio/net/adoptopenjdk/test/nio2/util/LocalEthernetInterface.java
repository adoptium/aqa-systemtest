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

package net.adoptopenjdk.test.nio2.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LocalEthernetInterface {

	private static Random rand = null;

	// This is a static utility class
	private LocalEthernetInterface() {

	}

	private static NetworkInterface networkInterface = null;
	private static String ipAddress = null;

	static {
		rand = new Random();
	}

	public enum AddressType {
		IPV4,
		IPV6,
		RANDOM
	}
	
	public static String getBestAddress() {
		
		// Attempt to get an IPV4 address for a local ethernet device
		
		// Failing that get the loopback address (checks for existence)
		
		// ... Failing that!, put in localhost.
		
		String address = null;
		
		try {
			address = getIpAddress(AddressType.IPV4);
		} catch (NoSuchFieldException e) {
			try {
				address = getIpAddress(AddressType.IPV4, true);
			} catch (NoSuchFieldException e1) {
				address = "localhost";
			}
		}
		
		return address;
		
	}

	public static String getIpAddress() throws NoSuchFieldException {
		return getIpAddress(AddressType.RANDOM);
	}

	public static String getIpAddress(AddressType type) throws NoSuchFieldException {
		rescan(type);
		return ipAddress;
	}
	
	public static String getIpAddress(AddressType type, boolean loopback) throws NoSuchFieldException {
		rescan(type, loopback);
		return ipAddress;
	}

	public static NetworkInterface getNetworkInterface() throws NoSuchFieldException {
		rescan(AddressType.RANDOM);
		return networkInterface;
	}

	public static void rescanIfApplicable(AddressType type) throws NoSuchFieldException{
		if (networkInterface == null) {
			rescan(type);
			return;
		}

		try {
			if (!networkInterface.isUp()) {
				rescan(type);
				return;
			}
		} catch (SocketException e) {
			rescan(type);
			return;
		}
	}

	public static void rescan(AddressType type) throws NoSuchFieldException{
		rescan(type, false);
	}

	// Returns the IP address as a string if found, else throws a NoSuchFieldError
	public static void rescan(AddressType type, boolean loopback) throws NoSuchFieldException{
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				if (!ni.isUp()) {
					continue;
				}

				if (ni.isLoopback()) {
					if (loopback) {
						break;
					} else {
						continue;
					}
				}

				Enumeration<InetAddress> addresses = ni.getInetAddresses();

				List<String> ipAddresses = new LinkedList<String>();

				// If we have multiple possible addresses, depending on 
				//  what policy we have, add it to the collection
				while (addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					switch (type) {
					case RANDOM:
						ipAddresses.add(address.getHostAddress());
						break;
					case IPV4:
						if (address instanceof Inet4Address) {
							ipAddresses.add(address.getHostAddress());
						}
						break;
					case IPV6:
						if (address instanceof Inet6Address) {
							ipAddresses.add(address.getHostAddress());
						}
						break;
					default:
						break;
					}
				}

				// If there is more than one IP address available, randomly
				//  choose one of them. This means that we switch it up a
				//  bit when there are both IPv4 and IPv6 addresses available
				//  for instance
				if (ipAddresses.size() > 0) {
					networkInterface = ni;
					ipAddress = ipAddresses.get(rand.nextInt(ipAddresses.size()));
					return;
				}		
			}
		} catch (SocketException e) {
			throw new NoSuchFieldException("Errors occurred whilst locating the host address for this machine");	
		}
		throw new NoSuchFieldException("Unable to locate any availble host address for this machine");
	}

	public static boolean isLoopbackAvailable() throws NoSuchFieldException{
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				if (ni.isLoopback()) {
					return true;
				}
			}
		} catch (SocketException e) {
			throw new NoSuchFieldException("Errors occured whilst locating the loopback interface on this machine");
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			System.out.println("This machine's IP Address is: " + getIpAddress());
		} catch (NoSuchFieldException e) {
			try {
				if (isLoopbackAvailable()) {
					System.out.println("The loopback is the only available interface");
				} else {
					e.printStackTrace();
				}
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			}
		}

		Enumeration<NetworkInterface> interfaces = null;

		try {
			System.out.println("Enumerating through network interfaces:");
			interfaces = NetworkInterface.getNetworkInterfaces();
			System.out.println(interfaces);
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				System.out.println("Network Interface: " + ni);
				System.out.println("Is up:             " +ni.isUp());
				System.out.println("Is loopback:       "+ ni.isLoopback());
				Enumeration<InetAddress> addresses = ni.getInetAddresses();
				while (addresses.hasMoreElements()) {
					System.out.println("ipaddress: " + addresses.nextElement().getHostAddress());
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		boolean atLeastOneInterfaceIsUp = false;
		boolean atLeastOneInterfaceIsLoopback = false;

		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
			if (interfaces != null) {
				interfaces = NetworkInterface.getNetworkInterfaces();
				while (interfaces.hasMoreElements()) {
					NetworkInterface interfac = interfaces.nextElement();
					
					if (interfac.isLoopback()) {
						atLeastOneInterfaceIsLoopback = true;
					}
					
					if (interfac.isUp()) {
						atLeastOneInterfaceIsUp = true;
					}
					
					boolean loopback = false;
					Enumeration<InetAddress> addrs = interfac.getInetAddresses();
					while(addrs != null && addrs.hasMoreElements()){
						if(addrs.nextElement().isLoopbackAddress()){
							loopback = true;
							break;
						}
					}

					if (loopback != interfac.isLoopback()) {
						System.out.println("NetworkInterface is loopback : " + interfac.isLoopback() +
								" not equal to hasLoopbackAddress: " + loopback);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		if (atLeastOneInterfaceIsLoopback == false) {
			System.out.println("Failed to find any loopback interfaces");
		}

		if (atLeastOneInterfaceIsUp == false) {
			System.out.println("Failed to find any up network interfaces");
		}
	}
}

