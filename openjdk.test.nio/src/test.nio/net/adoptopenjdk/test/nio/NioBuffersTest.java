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

package net.adoptopenjdk.test.nio;

import java.io.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;

/** 
 * NioBuffersTest is a multithreaded program which tests the different buffers in java.nio.
 *
 * The program does the following:
 * 
 * (1) Sets of x threads (passed as a command line argument)
 * (2) Each thread 
 *     - creates a buffer of type t (the type, size and how it is created is all random)
 *     - generates n random numbers, casts them to type t and writes them to the buffer
 *       and a list (the number of times this happens is also random ie. how full the
 *       buffer is is random)
 *     - if the buffer created is not a byte buffer, then creates a byte buffer and writes
 *       contents of the created buffer into the byte buffer
 * (3) When all threads have finished, all info from the byte buffers is gathered and 
 *     the contents is written to a file.
 * (4) An array of byte buffers is then created (with sizes corresponding to how full 
 *     the original buffers were)
 * (5) The contents of the file is then scattered to these byte buffers.
 * (6) The byte buffers are then viewed as the type they were originally and the contents
 *     is written to a list
 * (7) The two lists (for each buffer) are then compared.  If they are the same then the
 *     test passes, otherwise it fails.
 **/

public class NioBuffersTest {
    public void run() throws IOException {
        
        int nNumberOfThreads = 1;
        int nMaxNumberOfMegs = 1;
        int nIterations = 0;

        String strThreadName = null;
        String strTypeOfBuffer = "random";

		int loopCount = 1;
		String parmlist = "threads:10 iterations:10";

        int nIndexOfThreads 	= parmlist.toLowerCase().indexOf("threads:");	 // 10
        int nIndexOfMegs 		= parmlist.toLowerCase().indexOf("megs:");		 // Default
        int nIndexOfType 		= parmlist.toLowerCase().indexOf("type:");		 // Default
        int nIndexOfIterations	= parmlist.toLowerCase().indexOf("iterations:"); // 10

        // Setting variables to the values passed to the program by the driver file
        if (nIndexOfThreads != -1)
        {
            String strThreads = parmlist
                    .substring(nIndexOfThreads + 8);
            StringTokenizer stThreads = new StringTokenizer(strThreads, " ");
            nNumberOfThreads = Integer.parseInt(stThreads.nextToken());
        }

        if (nIndexOfMegs != -1)
        {
        	String strMegs = parmlist.substring(nIndexOfMegs + 5);
            StringTokenizer stMegs = new StringTokenizer(strMegs, " ");
            nMaxNumberOfMegs = Integer.parseInt(stMegs.nextToken());
        }

        if (nIndexOfType != -1)
        {
            String strType = parmlist.substring(nIndexOfType + 5);
            StringTokenizer stType = new StringTokenizer(strType, " ");
            strTypeOfBuffer = stType.nextToken();
        }

        if (nIndexOfIterations != -1)
        {
            String strIterations = parmlist
                    .substring(nIndexOfIterations + 11);
            StringTokenizer stIterations = new StringTokenizer(strIterations,
                    " ");
            nIterations = Integer.parseInt(stIterations.nextToken());
        }

        // This loop runs the test loop_ct times
        for (int nLoopCount = 0; nLoopCount < loopCount; nLoopCount++)
        {
            System.out.println(strThreadName + " Convert: Loop Count =  "
                    + nLoopCount);

            Buffers nioBuff = new Buffers(this);
            nioBuff.work(nNumberOfThreads, nMaxNumberOfMegs, strTypeOfBuffer,
                    nIterations);

        } // end for loop count

    } // end run()

    class Buffers
    {
    	NioBuffersTest bufferTest;

        Buffers()
        {
        };

        Buffers(NioBuffersTest nioBuffersTest)
        {
            bufferTest = nioBuffersTest;
        }

        File BufferFile = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        FileChannel readIntoFileFromBuffers = null;
        FileChannel readFromFileIntoBuffers = null;

        // Will tell you that thread i created a buffer of type typeOfBuffer[i]
        int[] typeOfBuffer;

        // Will tell you the number of bytes corresponding to the primitive type in typeOfBuffer[i]
        int[] numberOfBytes;

        // Will tell you that thread i created a buffer of size sizeOfBufferInBytes[i]
        int[] sizeOfBufferInBytes;

        // Will tell you that thread i added numberOfRandomNumbers[i] to its buffer
        int[] numberOfRandomNumbers;

        // ReadIntoFile[i] is a byteBuffer corresponding to thread i's type buffer (same size)
        ByteBuffer[] readIntoFile;

        // ReadFromFile[i] is a byteBuffer of corresponding to readIntoFile[i] but of
        // size typeOfBuffer[i]*numberOfRandomNumbers[i]
        ByteBuffer[] readFromFile;

        // inputArrayOfLinkedLists[i] = linked list which was created by thread
		@SuppressWarnings("rawtypes")
		List[] inputArrayOfLinkedLists;

        // outputArrayOfLinkedLists[i] = linked list which was read from file
		@SuppressWarnings("rawtypes")
		List[] outputArrayOfLinkedLists;

        @SuppressWarnings("unchecked")
		public void work(int nNumberOfThreads, int nMaxNumberOfMegs,
                String strTypeOfBuffer, int nIterations) throws IOException
        {
        	String strFileName = null;
            String strThreadName = Thread.currentThread().getName();

             GregorianCalendar day = new GregorianCalendar();
             String strDay       = Integer.toString(day.get(Calendar.DAY_OF_MONTH));
             String strHour      = Integer.toString(day.get(Calendar.HOUR_OF_DAY));
             String strMinute    = Integer.toString(day.get(Calendar.MINUTE));
             String strSecond    = Integer.toString(day.get(Calendar.SECOND));
             String strMillisecs = Integer.toString(day.get(Calendar.MILLISECOND));

             strFileName = "BufferFile-".concat(strDay)
            		 .concat("-").concat(strHour)
            		 .concat("-").concat(strMinute)
            		 .concat("-").concat(strSecond)
            		 .concat("-").concat(strMillisecs)
            		 .concat("-").concat(strThreadName);
            try
            {
                // open file with an associated input and output stream. Get
                // a channel for each of these streams.
                BufferFile = new File(strFileName);
                fos = new FileOutputStream(BufferFile);
                fis = new FileInputStream(BufferFile);
                readIntoFileFromBuffers = fos.getChannel();
                readFromFileIntoBuffers = fis.getChannel();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
                throw new IOException("an exception occured setting up channels " + e1);
           }

            typeOfBuffer = new int[nNumberOfThreads];
            numberOfBytes = new int[nNumberOfThreads];
            sizeOfBufferInBytes = new int[nNumberOfThreads];
            numberOfRandomNumbers = new int[nNumberOfThreads];
            readIntoFile = new ByteBuffer[nNumberOfThreads];
            readFromFile = new ByteBuffer[nNumberOfThreads];
            inputArrayOfLinkedLists = new List[nNumberOfThreads];
            outputArrayOfLinkedLists = new List[nNumberOfThreads];

            // create and start threads (nNumberOfThreads of them)
            Runnable tcArray[] = new Runnable[nNumberOfThreads];
            Thread thArray[] = new Thread[nNumberOfThreads];

            for (int i = 0; i < tcArray.length; i++)
            {
                System.out.println("starting thread " + i + ".............");
                tcArray[i] = new BufferThread(i, nMaxNumberOfMegs,
                        strTypeOfBuffer, nIterations);
                thArray[i] = new Thread(tcArray[i]);
                thArray[i].start();

            } // finish setting off threads in turn

            // when all threads have finished.............
            for (int i = 0; i < tcArray.length; i++)
            {
                while (thArray[i].isAlive())
                {
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
            }
            
            // Get rid of the references to the threads, otherwise we keep all
            // the buffers alive on the heap, and potentially OOM (especially on Z/OS
            // with a 512MB heap).
            thArray = null;
            tcArray = null;

            System.out.println("All threads have now died..............................................");

            for (int i = 0; i < nNumberOfThreads; i++)
            {
            	System.out.println("typeOfBuffer[" + i + "] = " + typeOfBuffer[i]);
                System.out.println("numberOfBytes[" + i + "] = " + numberOfBytes[i]);
                System.out.println("sizeOfBufferInBytes[" + i + "] = "
                        + sizeOfBufferInBytes[i]);
                System.out.println("numberOfRandomNumbers[" + i + "] = "
                        + numberOfRandomNumbers[i]);
                System.out.println("inputArrayOfLinkedLists[i].size() = "
                        + inputArrayOfLinkedLists[i].size());
            }

            // Keep track of I/O
            long bytesEXP = 0;
            long bytesPUT = 0;
            long bytesGOT = 0;

            try
            {
            	for (int i = 0; i < readIntoFile.length; i++)
                {
            		if(readIntoFile[i]!=null){
						readIntoFile[i].limit(numberOfRandomNumbers[i]* numberOfBytes[i]);
					}
                }

                for (int i = 0; i < readIntoFile.length; i++)
                {
                    // calculate how much we expect to write
					if(readIntoFile[i]!=null){
						bytesEXP += readIntoFile[i].remaining();
					}
                }

                // Write contents of readIntoFile array (all ByteBuffers) into file (gather)
                for (int i = 0; i < readIntoFile.length; i++)
                {
                	// loop while there's something to write
					if(readIntoFile[i]!=null){
						while (readIntoFile[i].hasRemaining())
						{
							bytesPUT += readIntoFileFromBuffers.write(readIntoFile);
						}
					}
                }

                if (bytesPUT != bytesEXP)
                {
                    System.err.println("!!!! Put: " + bytesPUT + " Expected: "
                            + bytesEXP);
                }

                // force changes to be made to file
                readIntoFileFromBuffers.force(true);
            }
            catch (IOException e2)
            {
                e2.printStackTrace();
                throw new IOException("an exception occured which writing contents of all buffers into the file (gathering) " + e2);
            }

            // Initialize each entry of readFromFile, first getting number of bytes
            // typeOfBuffer[i] represents (say x), then
            // readFromFile[i] has size (x * numberOfRandomNumbers[i])
            int tempCounter = 0;
            try
            {
            	for (int i = 0; i < typeOfBuffer.length; i++)
                {
            		readFromFile[i] = ByteBuffer.allocate(numberOfBytes[i]
                            * numberOfRandomNumbers[i]);
                    System.out.println("Thread " + i
                            + " - corresponding bytebuffer is of size "
                            + (numberOfBytes[i] * numberOfRandomNumbers[i])
                            + " bytes");

                    tempCounter = tempCounter
                            + (numberOfBytes[i] * numberOfRandomNumbers[i]);
                }

                // read contents of readFromFile array (all ByteBuffers) from
                // file (scatter)
                for (int i = 0; i < readFromFile.length; i++)
                {
                	// loop while there's something to read
                    while (readFromFile[i].hasRemaining())
                    {
                        long rc = readFromFileIntoBuffers.read(readFromFile);
                        if (rc >= 0)
                        {
                            bytesGOT += rc;
                        }
                        else
                        {
                            break;
                        }
                    }
                }

                if (bytesGOT != bytesEXP)
                {
                    System.err.println("!!!! Got: " + bytesGOT + " Expected: "
                            + bytesEXP);
                }

                // view readFromFile[i] as type typeOfBuffer[i]
                // get each entry of this new type buffer and print to a list
                for (int i = 0; i < typeOfBuffer.length; i++)
                {
                	// make each bytebuffer ready for draining (reading)
                    readFromFile[i].flip();

                    if (typeOfBuffer[i] == 0)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                    	while (readFromFile[i].hasRemaining())
                        {
                    		Byte byteFromBuffer = new Byte(readFromFile[i].get());
                            outputArrayOfLinkedLists[i].add(byteFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 1)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        CharBuffer charBuff = readFromFile[i].asCharBuffer();
                        while (charBuff.hasRemaining())
                        {
                        	Character charFromBuffer = new Character(charBuff.get());
                            outputArrayOfLinkedLists[i].add(charFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 2)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        DoubleBuffer doubleBuff = readFromFile[i]
                                .asDoubleBuffer();
                        while (doubleBuff.hasRemaining())
                        {
                        	Double doubleFromBuffer = new Double(doubleBuff.get());
                            outputArrayOfLinkedLists[i].add(doubleFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 3)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        FloatBuffer floatBuff = readFromFile[i].asFloatBuffer();
                        while (floatBuff.hasRemaining())
                        {
                        	Float floatFromBuffer = new Float(floatBuff.get());
                            outputArrayOfLinkedLists[i].add(floatFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 4)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        IntBuffer intBuff = readFromFile[i].asIntBuffer();
                        while (intBuff.hasRemaining())
                        {
                        	Integer intFromBuffer = new Integer(intBuff.get());
                            outputArrayOfLinkedLists[i].add(intFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 5)
                    {
                    	outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        LongBuffer longBuff = readFromFile[i].asLongBuffer();
                        while (longBuff.hasRemaining())
                        {
                        	Long longFromBuffer = new Long(longBuff.get());
                            outputArrayOfLinkedLists[i].add(longFromBuffer);
                        }
                    }
                    else if (typeOfBuffer[i] == 6)
                    {
                        outputArrayOfLinkedLists[i] = new LinkedList<Object>();
                        ShortBuffer shortBuff = readFromFile[i].asShortBuffer();
                        while (shortBuff.hasRemaining())
                        {
                            Short shortFromBuffer = new Short(shortBuff.get());
                            outputArrayOfLinkedLists[i].add(shortFromBuffer);
                        }
                    }
                }
            }
            catch (IOException e3)
            {
                e3.printStackTrace();
                throw new IOException("An exception occured in last part of program " + e3);
            }

            // compare this list with the one created at the beginning
            // the lists are the same ==> pass
            // the lists are different ==> fail
            int nPassed = 0;
            int nFailed = 0;

            try
            {
                for (int i = 0; i < nNumberOfThreads; i++)
                {
                    for (int j = 0; j < inputArrayOfLinkedLists[i].size(); j++)
                    {
                        System.out.println("outputArrayOfLinkedLists[" + i + "][" + j
                                + "] = " + outputArrayOfLinkedLists[i].get(j));
                        System.out.println("inputArrayOfLinkedLists[" + i + "][" + j
                                + "] = " + inputArrayOfLinkedLists[i].get(j));
                        if ((outputArrayOfLinkedLists[i].get(j))
                                .equals(inputArrayOfLinkedLists[i].get(j)))
                        {
                            nPassed++;
                        }
                        else
                        {
                            nFailed++;
                        }
                    } // finished going through each element in list in turn
                } // finished going through each linked list in turn
            }
            catch (Exception e4)
            {
                e4.printStackTrace();
                throw new IOException("an exception occured while checking the lists " + e4);
            }

            System.out.println("PASSED = " + nPassed);
            System.out.println("FAILED = " + nFailed);

            if (nFailed == 0)
            {
                System.out.println("All comparisons were the same");
            }
            else
            {
                System.out.println("Some comparisons were different");
            }

            // closing the streams, and file channels etc.
            try
            {
                readIntoFileFromBuffers.close();
                readFromFileIntoBuffers.close();
                fis.close();
                fos.close();
            }
            catch (IOException e5)
            {
                e5.printStackTrace();
                throw new IOException("An exception occured while closing the fis and fos " + e5);
            }

            BufferFile.delete();
        } // end of Work()

        
        // BufferThread class
      
        // Contains the work for each thread (creates byffer of certain type,
        // writes random numbers to this buffer and also to a list, then writes
        // contents of non-byte buffers to a byte buffer).
        class BufferThread implements Runnable
        {
            int nMaxNumberOfMegs;
            int nNumberOfRandomNumbers;
            int nSizeOfBufferInBytes;
            int nThreadName;
            int nTypeOfBuffer;
            double dRandomNumber1;
            double dRandomNumber2;
            double dRandomNumber3;
            double dRandomNumber4;
            String strTypeOfBuffer;
            boolean blnAllocate = true;
            ByteBuffer byteBuff;
            CharBuffer charBuff;
            DoubleBuffer doubleBuff;
            FloatBuffer floatBuff;
            IntBuffer intBuff;
            LongBuffer longBuff;
            ShortBuffer shortBuff;
            byte[] byteArray;
            char[] charArray;
            double[] doubleArray;
            float[] floatArray;
            int[] intArray;
            long[] longArray;
            short[] shortArray;
		    String vmBits;			
			boolean is32bitJVM = false;
			
            BufferThread(int i, int megs, String type, int iterations)
            {
                // thread knows that it's thread i and the max number of Megs
                nThreadName = i;
                nMaxNumberOfMegs = megs;
                strTypeOfBuffer = type;
                nNumberOfRandomNumbers = iterations;
                
                // Set up a variable 'is32bitVM' so that when we define the buffers in bytes we
                // can create smaller buffers on 32 and 31 bit JVMs than we do on 64 bit JVMs 
                // (to avoid OutOfMemory problems which have been observed on some 32 bit systems).
				vmBits = System.getProperty("com.ibm.vm.bitmode");
				if (vmBits != null && vmBits.equals("32")) {
					is32bitJVM = true;				
				}
				
				vmBits = System.getProperty("sun.arch.data.model");
				if (vmBits != null && vmBits.equals("32")) {
					is32bitJVM = true;				
				}
            }

            // what thread does...............................

            public void run()
            {
                System.out.println("------------------------------------------ my name is thread "
                        + nThreadName);
                // generate a random number n1 ==> type of buffer (as an
                // integer)
                //
                // 0 <= n1 < 0.1 ==> byte == 0
                // 0.1 <= n1 < 0.25 ==> char == 1
                // 0.25 <= n1 < 0.4 ==> double == 2
                // 0.4 <= n1 < 0.55 ==> float == 3
                // 0.55 <= n1 < 0.7 ==> int == 4
                // 0.7 <= n1 < 0.85 ==> long == 5
                // 0.85 <= n1 <= 1 ==> short == 6
                //
                // add this integer to typeOfBuffer[i]
                // nRandomNumber1 = (int)(Math.random());
                if (strTypeOfBuffer.compareTo("random") == 0)
                {
                    dRandomNumber1 = Math.random();
                    if (0 <= dRandomNumber1 && dRandomNumber1 < 0.1)
                    {
                        nTypeOfBuffer = 0;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = byte");
                    }
                    else if (0.1 <= dRandomNumber1 && dRandomNumber1 < 0.25)
                    {
                        nTypeOfBuffer = 1;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = char");
                    }
                    else if (0.25 <= dRandomNumber1 && dRandomNumber1 < 0.4)
                    {
                        nTypeOfBuffer = 2;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = double");
                    }
                    else if (0.4 <= dRandomNumber1 && dRandomNumber1 < 0.55)
                    {
                        nTypeOfBuffer = 3;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = float");
                    }
                    else if (0.55 <= dRandomNumber1 && dRandomNumber1 < 0.7)
                    {
                        nTypeOfBuffer = 4;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = int");
                    }
                    else if (0.7 <= dRandomNumber1 && dRandomNumber1 < 0.85)
                    {
                        nTypeOfBuffer = 5;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = long");
                    }
                    else
                    {
                        nTypeOfBuffer = 6;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = short");
                    } // finished setting type of buffer if want random type
                }
                else
                {
                    if (strTypeOfBuffer.compareTo("byte") == 0)
                    {
                        nTypeOfBuffer = 0;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = byte");
                    }
                    else if (strTypeOfBuffer.compareTo("char") == 0)
                    {
                        nTypeOfBuffer = 1;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = char");
                    }
                    else if (strTypeOfBuffer.compareTo("double") == 0)
                    {
                        nTypeOfBuffer = 2;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = double");
                    }
                    else if (strTypeOfBuffer.compareTo("float") == 0)
                    {
                        nTypeOfBuffer = 3;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = float");
                    }
                    else if (strTypeOfBuffer.compareTo("int") == 0)
                    {
                        nTypeOfBuffer = 4;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = int");
                    }
                    else if (strTypeOfBuffer.compareTo("long") == 0)
                    {
                        nTypeOfBuffer = 5;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = long");
                    }
                    else
                    {
                        nTypeOfBuffer = 6;
                        System.out.println("Thread " + nThreadName
                                + " - nTypeOfBuffer = short");
                    } // finnished setting type of buffer if want random type
                } // finished setting type of buffer for type you want

                synchronized (typeOfBuffer)
                {
                    typeOfBuffer[nThreadName] = nTypeOfBuffer;
                }

                // generate a random number n2 ==> size of buffer (as an
                // integer)
                // size (number of bytes) = nMaxNumberOfMegs*(1024)^{2}
                // add this integer to sizeOfBufferInBytes[i]
                dRandomNumber2 = Math.random();
                if(is32bitJVM){
					nSizeOfBufferInBytes = (int) (dRandomNumber2 * nMaxNumberOfMegs* 1024);
				} else {
					nSizeOfBufferInBytes = (int) (dRandomNumber2 * nMaxNumberOfMegs* 1024 * 1024);
				}

                System.out.println("Thread " + nThreadName + " - dRandomNumber2 = "
                        + dRandomNumber2);
                System.out.println("Thread " + nThreadName + " - creating a buffer of size "
                        + nSizeOfBufferInBytes + " bytes");

                synchronized (sizeOfBufferInBytes)
                {
                    sizeOfBufferInBytes[nThreadName] = nSizeOfBufferInBytes;
                }

                // generate a random number n3 ==> how buffer is created
                // 0 <= n3 < 0.5 ==> created through allocation
                // 0.5 < n3 <= 1 ==> created through wrapping (in which case
                // need to create array as well
                dRandomNumber3 = Math.random();
                
                if (0.5 < dRandomNumber3 && dRandomNumber3 <= 1)
                {
                    blnAllocate = false;
                }

                // trace("Thread " + nThreadName + " - blnAllocate = " +
                // blnAllocate);

                // generate a random number n4 ==> how many times write a random
                // number to buffer
                //
                // byte = 1 byte
                // char = 2 bytes
                // short = 2 bytes
                // int = 4 bytes
                // long = 8 bytes
                // float = 4 bytes
                // double = 8 bytes
                //
                // cast to an integer, the result from dividing the size of the
                // buffer (number of bytes)
                // by the number by the number of bytes the primative type takes
                // up and multiplying by the
                // random number n4 (know this to be between 0 and 1)
                //
                // add this integer to numberOfRandomNumbers[i]
                dRandomNumber4 = Math.random();
                
                int nNumberOfBytes = 0;

                if (nTypeOfBuffer == 0)
                {
                    nNumberOfBytes = 1;
                }
                else if (nTypeOfBuffer == 1 || nTypeOfBuffer == 6)
                {
                    nNumberOfBytes = 2;
                }
                else if (nTypeOfBuffer == 3 || nTypeOfBuffer == 4)
                {
                    nNumberOfBytes = 4;
                }
                else if (nTypeOfBuffer == 2 || nTypeOfBuffer == 5)
                {
                    nNumberOfBytes = 8;
                }

                synchronized (numberOfBytes)
                {
                    numberOfBytes[nThreadName] = nNumberOfBytes;
                }

                System.out.println("Thread " + nThreadName + " - nNumberOfBytes per type = "
                        + nNumberOfBytes);

                // have commented out the following line to cap the number of
                // times the buffer is written to by 100
                // this is because otherwise it was taking too long.
                // nNumberOfRandomNumbers =
                // (int)(dRandomNumber4*(nSizeOfBufferInBytes/nNumberOfBytes));
                // if have said want to randomly generate number of random
                // numbers....
                if (nNumberOfRandomNumbers == 0)
                {
                   if(is32bitJVM){
						nNumberOfRandomNumbers = (int) (dRandomNumber4 * 100);
					} else {
						nNumberOfRandomNumbers = (int) (dRandomNumber4 * 10000);
					}
                    System.out.println("Thread " + nThreadName
                            + " - nNumberOfRandomNumbers = "
                            + nNumberOfRandomNumbers);
                }

                // cap the number of random numbers written to the
                // file............
                // if nNumberOfRandomNumbers is less than
                // (nSizeOfBufferInBytes/nNumberOfBytes) then
                // Ok ie. have capped the number of random numbers written to
                // the file by the
                // size of the file, else set nNumberOfRandomNumbers =
                // (nSizeOfBufferInBytes/nNumberOfBytes)
                // ie. fill the buffer up.
                nNumberOfRandomNumbers = nNumberOfRandomNumbers < (nSizeOfBufferInBytes / nNumberOfBytes) ? nNumberOfRandomNumbers
                        : (int) (nSizeOfBufferInBytes / nNumberOfBytes);

                System.out.println("Thread " + nThreadName
                        + " - after capping - nNumberOfRandomNumbers = "
                        + nNumberOfRandomNumbers);

                synchronized (numberOfRandomNumbers)
                {
                    // trace("have written to numberOfRandomNumbers array");
                    numberOfRandomNumbers[nThreadName] = nNumberOfRandomNumbers;
                }

                if (nTypeOfBuffer == 0)
				{
				    if (blnAllocate)
				    {
				        byteBuff = ByteBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created byte buffer by allocating space for "
				                + nSizeOfBufferInBytes + " bytes");
				    }
				    else
				    {
				        byteArray = new byte[nSizeOfBufferInBytes];
				        byteBuff = ByteBuffer.wrap(byteArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created byte buffer by wrapping an array with space for "
				                + nSizeOfBufferInBytes + " bytes");
				    }
				}
				else if (nTypeOfBuffer == 1)
				{
				    if (blnAllocate)
				    {
				        charBuff = CharBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " chars ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        charArray = new char[nNumberOfElementsInArray];
				        charBuff = CharBuffer.wrap(charArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " chars");
				    }
				}
				else if (nTypeOfBuffer == 2)
				{
    			    if (blnAllocate)
				    {
				        doubleBuff = DoubleBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created double buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " doubles ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        doubleArray = new double[nNumberOfElementsInArray];
				        doubleBuff = DoubleBuffer.wrap(doubleArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " doubles");
				    }
				}
				else if (nTypeOfBuffer == 3)
				{
				    if (blnAllocate)
				    {
				        floatBuff = FloatBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created float buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " floats ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        floatArray = new float[nNumberOfElementsInArray];
				        floatBuff = FloatBuffer.wrap(floatArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " floats");
				    }
				}
				else if (nTypeOfBuffer == 4)
				{
				    if (blnAllocate)
				    {
				        intBuff = IntBuffer.allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created int buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " ints ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        intArray = new int[nNumberOfElementsInArray];
				        intBuff = IntBuffer.wrap(intArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " integers");
				    }
				}
				else if (nTypeOfBuffer == 5)
				{
				    if (blnAllocate)
				    {
				        longBuff = LongBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created long buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " longs ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        longArray = new long[nNumberOfElementsInArray];
				        longBuff = LongBuffer.wrap(longArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " longs");
				    }
				}
				else if (nTypeOfBuffer == 6)
				{
				    if (blnAllocate)
				    {
				        shortBuff = ShortBuffer
				                .allocate(nSizeOfBufferInBytes);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created short buffer by allocating space for "
				                + (int) (nSizeOfBufferInBytes / nNumberOfBytes)
				                + " shorts ( = "
				                + ((int) (nSizeOfBufferInBytes / nNumberOfBytes))
				                * nNumberOfBytes + " bytes)");
				    }
				    else
				    {
				        int nNumberOfElementsInArray = (int) (nSizeOfBufferInBytes / nNumberOfBytes);
				        shortArray = new short[nNumberOfElementsInArray];
				        shortBuff = ShortBuffer.wrap(shortArray);
				        System.out.println("Thread "
				                + nThreadName
				                + " - have created char buffer by wrapping an array with space for "
				                + nNumberOfElementsInArray + " shorts");
				    }
				}
				else
				{
				    System.out.println("Thread "
				            + nThreadName
				            + " - there has been a mistake creating buffers");
				}

                // create a LinkedList object
                @SuppressWarnings("rawtypes")
				List<Comparable> threadInputList = new LinkedList<Comparable>();

                // enter loop (execute loop nNumberOfRandomNumbers[i] times)
                // within loop.......
                // generate random number
                // cast random number to type
                // write random number to buffer
                // create type Object for this random number
                // add this object to the LinkedList
                // exit loop
                if (nTypeOfBuffer == 0)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        byte randomNumber = (byte) 1;
				        Byte objRandomNumber = new Byte(randomNumber);
				        threadInputList.add(objRandomNumber);
				        byteBuff.put(randomNumber);
				    }
				}
				else if (nTypeOfBuffer == 1)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        char randomNumber = (char) (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (char) (Math.random() * 10);
						}
						charBuff.put(randomNumber);
				        Character objRandomNumber = new Character(
				                randomNumber);
				        threadInputList.add(objRandomNumber);
				    }
				}
				else if (nTypeOfBuffer == 2)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        double randomNumber = (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (Math.random() * 10);
						}
				        Double objRandomNumber = new Double(randomNumber);
				        threadInputList.add(objRandomNumber);
				        doubleBuff.put(randomNumber);
				    }
				}
				else if (nTypeOfBuffer == 3)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        float randomNumber = (float) (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (float) (Math.random() * 10);
						}
						Float objRandomNumber = new Float(randomNumber);
				        threadInputList.add(objRandomNumber);
				        floatBuff.put(randomNumber);
				    }
				}
				else if (nTypeOfBuffer == 4)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        int randomNumber = (int) (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (int) (Math.random() * 10);
						}
				        Integer objRandomNumber = new Integer(randomNumber);
				        threadInputList.add(objRandomNumber);
				        intBuff.put(randomNumber);
				    }
				}
				else if (nTypeOfBuffer == 5)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        long randomNumber = (long) (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (long) (Math.random() * 10);
						}
				        Long objRandomNumber = new Long(randomNumber);
				        threadInputList.add(objRandomNumber);
				        longBuff.put(randomNumber);
				    }
				}
				else if (nTypeOfBuffer == 6)
				{
				    for (int i = 0; i < nNumberOfRandomNumbers; i++)
				    {
				        short randomNumber = (short) (Math.random() * 100);
						if(is32bitJVM){
							randomNumber = (short) (Math.random() * 10);
						}
				        Short objRandomNumber = new Short(randomNumber);
				        threadInputList.add(objRandomNumber);
				        shortBuff.put(randomNumber);
				    }
				}
				else
				{
				    System.out.println("There has been a mistake");
				}

                // assign arrayOfLinkedLists[i] = LinkedList just finished
                // creating
                synchronized (inputArrayOfLinkedLists)
                {
                	inputArrayOfLinkedLists[nThreadName] = threadInputList;
                }

                // If buffer type = byte then assign readIntoFile[i] = buffer
                // this thread created,
                // otherwise, create new bytebuffer of size
                // sizeOfBufferInBytes[i] and write contents of
                // buffer this thread created into this newly created ByteBuffer
                // and set the
                // ByteBuffer to be ready for draining (ie. flip it)
                if (nTypeOfBuffer != 0)
				{
				    byteBuff = ByteBuffer.allocate(nSizeOfBufferInBytes);
				    System.out.println("Thread " + nThreadName
				            + " has now created a ByteBuffer of size "
				            + nSizeOfBufferInBytes + " bytes");

				    if (nTypeOfBuffer == 1)
				    {
				        // make the charbuffer ready for draining
				        charBuff.flip();

				        while (charBuff.hasRemaining())
				        {
				            char number = charBuff.get();
				            byteBuff.putChar(number);
				        }
				    }
				    else if (nTypeOfBuffer == 2)
				    {
				        doubleBuff.flip();
				        while (doubleBuff.hasRemaining())
				        {
				            double number = doubleBuff.get();
				            byteBuff.putDouble(number);
				        }
				    }
				    else if (nTypeOfBuffer == 3)
				    {
				        floatBuff.flip();

				        while (floatBuff.hasRemaining())
				        {
				            float number = floatBuff.get();
				            byteBuff.putFloat(number);
				        }
				    }
				    else if (nTypeOfBuffer == 4)
				    {
				        intBuff.flip();
			        
				        while (intBuff.hasRemaining())
				        {
				            int number = intBuff.get();
				            byteBuff.putInt(number);
				        }
				    }
				    else if (nTypeOfBuffer == 5)
				    {
				        longBuff.flip();
				        while (longBuff.hasRemaining())
				        {
				            long number = longBuff.get();
				            byteBuff.putLong(number);
				        }
				    }
				    else if (nTypeOfBuffer == 6)
				    {
				        shortBuff.flip();
				        while (shortBuff.hasRemaining())
				        {
				            short number = shortBuff.get();
				            byteBuff.putShort(number);
				        }
				    }
				} // end if (nTypeOfBuffer != 0)

				// set byteBuffer ready for draining
				// trace("Thread " + nThreadName + " - before flip
				// (byteBuff) - capacity() " + byteBuff.capacity());
				// trace("Thread " + nThreadName + " - before flip
				// (byteBuff) - position() " + byteBuff.position());
				// trace("Thread " + nThreadName + " - before flip
				// (byteBuff) - limit() " + byteBuff.limit());

				byteBuff.flip();
				
                synchronized (readIntoFile)
                {
                    readIntoFile[nThreadName] = byteBuff;
                    readIntoFile[nThreadName].limit(nNumberOfRandomNumbers
                            * nNumberOfBytes);
                }

                // clear the buffers
                byteBuff.clear();

				if (nTypeOfBuffer == 1)
				{
				    charBuff.clear();
				}
				else if (nTypeOfBuffer == 2)
				{
				    doubleBuff.clear();
				}
				else if (nTypeOfBuffer == 3)
				{
				    floatBuff.clear();
				}
				else if (nTypeOfBuffer == 4)
				{
				    intBuff.clear();
				}
				else if (nTypeOfBuffer == 5)
				{
				    longBuff.clear();
				}
				else if (nTypeOfBuffer == 6)
				{
				    shortBuff.clear();
				}

            } // end of run()

        } // end of class BufferThread

    } // end of class Buffers

} // end of public class NioBuffersTest
