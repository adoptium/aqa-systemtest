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
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;


public class Serialization
{
	
   private static AtomicLong atomicUniqueFileID = new AtomicLong();
	
   public void run() throws IOException, ClassNotFoundException, SerializationDataCheckException
   {
	   String threadName = Thread.currentThread().getName().replace('-', '_'); // replace dash
	   String currentTimeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS").format(new Date());
	   String filename = this.getClass().getSimpleName() + "_" + threadName + "-Obj_" + currentTimeStamp + "_" + atomicUniqueFileID.incrementAndGet() + ".bin";
       
       File file = new File(filename);
       
       int loopCount = 2;
       int pass;
       
       for (pass = 1; pass <= loopCount; pass++)
       {
    	   // For trace
    	   // System.out.println(threadName + " Serialization: Pass " + pass);

           /*
            * Strategy: Create a serializable object containing 2 fields.
            * Set the fields to a known value, and serialize the
            * object to a file.
            * Only the strField is marked as a serialPersistentField.
            *
            * The object is then deserialized from the file.
            * The test object utilizes the readObject() method,
            * issuing the getField() method to retrieve the
            * serialPersistentFields. The individual field strField,
            * is then extracted using getField.get().
            * Finally, once the object is reconstituted, the strField
            * is checked for String "hello".
            * Field intField, since not specified as
            * a serialPersistentField, obtains a default value, 0.
            */

           // save test class
           FileOutputStream f = new FileOutputStream(file);
           ObjectOutput objout = new ObjectOutputStream(f);

           objout.writeObject(new SerializationClassA("hello", 500));
           objout.flush();
           objout.close();

           // Pull it back again
           FileInputStream f2 = new FileInputStream(filename);
           ObjectInputStream objin = new ObjectInputStream(f2);
           SerializationClassA obj = (SerializationClassA) objin
                   .readObject();
           objin.close();
           if (!obj.strField.equals("hello"))
           {
               // System.out.println("Error! Field strField: actual: " + obj.strField
               // + " should be: hello");
               // rc = 24;
               // break;
               throw new SerializationDataCheckException(
                       "Field strField: actual: " + obj.strField
                               + " should be: hello. Pass = " + pass);
           }
           if (obj.intField != 0)
           {
               // System.out.println("Error! Field intField: actual: " + obj.intField
               // + " should be: 0");
               throw new SerializationDataCheckException(
                       "Error! Field intField: actual: " + obj.intField
                               + " should be: 0, pass = " + pass);
           }
           System.out.println(obj.toString());

       } // end of for loop

       // delete file if test passed
       file.delete();
   } // end method run()

   static class SerializationDataCheckException extends Exception
   {
	private static final long serialVersionUID = 914562141860645249L;

	public SerializationDataCheckException(String msg)
        {
           super(msg);
        }
   }
} // end class

class SerializationClassA implements Serializable
{
   private static final long serialVersionUID = -1501903649801898040L;
   String strField;
   int intField;

   /**
    * @serialField strField String null, empty string, or any String value
    */
   private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField(
           "strField", String.class), };

   public SerializationClassA(String one, int two)
   {
       strField = one;
       intField = two;
   }

   private void readObject(ObjectInputStream in) throws IOException,
           ClassNotFoundException
   {

       // Read in serial fields
       ObjectInputStream.GetField pfields = in.readFields();

       // Assign serialized values to fields
       strField = (String) pfields.get("strField", "out-of-luck");
   }

   public String toString()
   {
       return "strField: " + strField + " intField: " + intField;
   }
}

//end file
