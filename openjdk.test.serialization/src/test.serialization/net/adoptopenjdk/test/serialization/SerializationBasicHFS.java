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

package net.adoptopenjdk.test.serialization;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicLong;


public class SerializationBasicHFS {
	
   private static AtomicLong atomicUniqueFileID = new AtomicLong();
	
   public void run() throws IOException, ClassNotFoundException, SerializationBasicHFSDataCheckException {
	   String threadName = Thread.currentThread().getName().replace('-', '_'); // replace dash
	   String currentTimeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS").format(new Date());
	   String filename = this.getClass().getSimpleName() + "_" + threadName + "-Obj_" + currentTimeStamp +  "_" + atomicUniqueFileID.incrementAndGet() + ".bin";
       
       File file = new File(filename);
	   
	   int loopCount = 2;  // Same as in the test driver
	   int pass;
   
	   for (pass = 1; pass <= loopCount; pass++) {
		   // For trace
		   // System.out.println(threadName + " SerializationBasicHFS: Pass " + pass);

		   /*
		    * Strategy: Create a serializable object containing 2 fields.
		    * Set the fields to a known value, and serialize the
		    * object to a file.
		    *
		    * The object is then deserialized from the file.
		    * Once the object is reconstituted, the strField
		    * is checked for String "hello" & the intField is checked
		    * for a value of (unique), different for each
		    * thread instance.
		    */

		   // save test class
		   FileOutputStream f = new FileOutputStream(file);
		   ObjectOutput objout = new ObjectOutputStream(f);

		   GregorianCalendar date = new GregorianCalendar();
		   int unique = date.get(Calendar.HOUR_OF_DAY) 
				   + date.get(Calendar.MINUTE) 
				   + date.get(Calendar.SECOND) 
				   + date.get(Calendar.MILLISECOND);
		   
		   objout.writeObject(new SerializationBasicHFSClassA("hello", unique));
   
		   objout.flush();
		   objout.close();

		   // Pull it back
		   FileInputStream f2 = new FileInputStream(filename);
		   ObjectInputStream objin = new ObjectInputStream(f2);
		   SerializationBasicHFSClassA obj = (SerializationBasicHFSClassA) objin
				   .readObject();
   
		   objin.close();
   
  
		   if (!obj.strField.equals("hello")) {
			   //System.out.println("Error! Field strField: actual: " + obj.strField
			   //	   + " should be: hello");
			   //rc = 24;
			   //break;
			   
			   throw new SerializationBasicHFSDataCheckException("Error! Field strField: actual: " + obj.strField
					   + " should be: hello, pass = " + pass);
		   }

		   if (obj.intField != unique) {
			   //System.out.println("Error! Field intField: actual: " + obj.intField
			   //		+ " should be: " + unique);
			   //rc = 36;
			   //break;
   
			   throw new SerializationBasicHFSDataCheckException("Error! Field intField: actual: " + obj.intField
					   + " should be: " + unique + " pass = " + pass);
		   }
       
		   System.out.println(obj.toString());
	   } // end of for loop
	   // delete file if test passed
	   file.delete();
   } // end method run()

   static class SerializationBasicHFSDataCheckException extends Exception {
	private static final long serialVersionUID = -8173903870846103618L;

	public SerializationBasicHFSDataCheckException(String msg) {
           super(msg);
       }
   }
} // end class

class SerializationBasicHFSClassA implements Serializable {
   private static final long serialVersionUID = -803076878351952718L;
   String strField;
   int intField;

   /**
    * @serialField strField String null, empty string, or any String value
    */
   public SerializationBasicHFSClassA(String one, int two) {
       strField = one;
       intField = two;
   }

   public String toString() {
       return "strField: " + strField + " intField: " + intField;
   }
}
//end file
