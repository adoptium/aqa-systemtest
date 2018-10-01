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

package net.adoptopenjdk.test.jlm.remote;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.Map;
import java.util.Set;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.junit.Assert;
import com.sun.management.GarbageCollectorMXBean;
import com.sun.management.GcInfo;

public class GCMXBeanTest {
	public static void main(String[] args) throws Exception {
		try {
			// Sleep sometime for Server to start
			Thread.sleep(90000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ServerURL=service:jmx:rmi:///jndi/rmi://localhost:1234/jmxrmi");

		// Form a Server URL
		JMXServiceURL urlForRemoteVM = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1234/jmxrmi");

		// Connect to remote VM using Server URL
		JMXConnector jmxCon = JMXConnectorFactory.connect(urlForRemoteVM, null);

		System.out.println("Connection established!");

		// Create a proxy to be used to get a GC MXBean instance
		MBeanServerConnection mbeanSerCon = jmxCon.getMBeanServerConnection();

		// Get object names of all MXBeans that are implemented and belong to GC domain type. These return values are different for each gc policy e.g this returns object names java.lang:type=GarbageCollector,name=global and 
	 	// java.lang:type=GarbageCollector,name=scavenge  when "gencon" gc policy is used 
		Set<?> srvGCNames = mbeanSerCon.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);

		System.out.println("Getting GC data (3 times for each GC between 5 secs time intervals):");

		for (Object srvGCName : srvGCNames) {

			ObjectName gcBeanName = (ObjectName) srvGCName;

			// newPlatformMXBeanProxy returns a proxy for a platform MXBean 
			// interface(here GarbageCollectorMXBean) of a given MXBean name that 
			// forwards its method calls through the given MBeanServerConnection. 		
			GarbageCollectorMXBean gcBean = ManagementFactory.newPlatformMXBeanProxy(mbeanSerCon, gcBeanName.toString(), GarbageCollectorMXBean.class);

			System.out.println("gcBeanName: "+ gcBean.getName());

			System.out.println("\n");

			// Methods of com.ibm.management.GcInfo are already 
			// tested in GarbageCollectionNotificationTest.java, here our 
			// goal is to test getLastGcInfo() method from 
			// com.sun.management.GarbageCollectorMXBean alone.
			for (int i=0;i<3;i++) {
				GcInfo gcInfo = gcBean.getLastGcInfo();
				System.out.println("GcId: "+ gcInfo.getId());
				System.out.println("StartTime: "+ gcInfo.getStartTime());
				System.out.println("EndTime: "+ gcInfo.getEndTime());
				System.out.println("Duration: "+ gcInfo.getDuration());
				Assert.assertTrue("StartTime("+gcInfo.getStartTime()+") should be smaller than EndTime("+gcInfo.getEndTime()+").", gcInfo.getStartTime() <= gcInfo.getEndTime());

				Map<String, MemoryUsage> beforeUsageMap = gcInfo.getMemoryUsageBeforeGc();
				Map<String, MemoryUsage> afterUsageMap = gcInfo.getMemoryUsageAfterGc();
				
				if ((beforeUsageMap instanceof Map) && (afterUsageMap instanceof Map)) {
					System.out.println("Calls to methods gcInfo.getMemoryUsageBeforeGc() "
							+ "and gcInfo.getMemoryUsageAfterGc() : SUCCESSFULL");
				} else {
					Assert.fail("Calls to methods gcInfo.getMemoryUsageBeforeGc() "
							+ "and gcInfo.getMemoryUsageAfterGc() : FAILED");		
				}

				System.out.println("\n");

				try {
					// Sleep sometime to look for next GC cycle
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
