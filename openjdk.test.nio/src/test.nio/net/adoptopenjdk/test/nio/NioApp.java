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

package net.adoptopenjdk.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.StringTokenizer;

/** 
 * This program can take up to eight arguments:
 * 
 * threads:   = The number of threads you wish to set off (int) 
 * times:     = The number of times you want each thread to read and write to the file (int) 
 * output:    = The name of the file you want to read and write to (string) 
 * millisecs: = The number of millisecs you wish the thread to sleep before accessing the 
 * 				file again (int) 
 * sync:      = Whether you want to synchronise the reading or writing to the file (yes or no) 
 * check:     = Whether you want to check the file output with a hashtable (yes or no) 
 * digits:    = Your random number will run between 0 and (this number - 1) (int) 
 * common:    = Whether or not you want the threads to access the file through the same 
 * 				FileChannel (if using many threads then it is advisable to leave this 
 * 				as the default - 'yes', otherwise you may get errors saying 'too many 
 * 				files open' or 'out of memory') (yes or no).
 * 
 * The arguments you pass to the program do not have to be in this order, also
 * if you fail to specify one then the default setting for that argument is
 * automatically used.
 * 
 * **********************************************************************************************
 * 
 * What this program does:
 * 
 * It sets off a specified number of threads. Each thread generates a random
 * number and checks the file to see if the random number is there. It then
 * either increments the counter of the random number or appends the random
 * number to the end of the file with counter equal to one. Each thread has its
 * own FileChannel and ByteBuffer associated with the file so more than one
 * thread can read/write to the file at once. If you choose to synchronise
 * reading/writing to this file (this is the default) and wish to check the
 * results in the file with those in a hashtable then as well as writing to a
 * file, the thread writes its random number to a hashtable. When all threads
 * have finished, the hashtable and file are then compared and the results of
 * this comparison are sent to the results file.
 * 
 * **********************************************************************************************
 * 
 * Key to return codes:
 * 
 * RC = 0 - Test passed RC = 99 - Test failed (contents of the file was
 * different to the contents of the hashtable) RC = 93 - An exception occurred
 * when checking that all threads were dead before comparing the file and
 * hashtable. RC = 96 - An exception occurred when closing the file channel and
 * RandomAccessFile.
 * 
 * **********************************************************************************************
 */

public class NioApp {
	public void run() throws IOException {
		// Initializing them with their default values.
		int nNumberOfThreads = 1;
		int nThreadExecutesAmendFile = 1;
		int nThreadSleepInMillisecs = 0;
		int nDigits = 10;
		String strNameOfOutputFile;
		String strCheck;
		String strCommon;
		String strThreadName = Thread.currentThread().getName();
		boolean blnThreadSleep = false;
		boolean blnSync = true;
		boolean blnCheck = true;
		boolean blnCommonFileChannel = true;

		Hashtable<Object, Integer> htHash = new Hashtable<Object, Integer>();
		File fFile = null;
		RandomAccessFile rafRandom = null;
		FileChannel fcFileChannel = null;

		GregorianCalendar day = new GregorianCalendar();
		String strDay = Integer.toString(day.get(Calendar.DAY_OF_MONTH));
		String strHour = Integer.toString(day.get(Calendar.HOUR_OF_DAY));
		String strMinute = Integer.toString(day.get(Calendar.MINUTE));
		String strSecond = Integer.toString(day.get(Calendar.SECOND));
		String strMillisecond = Integer.toString(day.get(Calendar.MILLISECOND));

		strNameOfOutputFile = "File-".concat(strDay).concat("-")
				.concat(strHour).concat("-").concat(strMinute).concat("-")
				.concat(strSecond).concat("-").concat(strMillisecond);;

		int rc = 0;
		int loopCount = 1;
		String parmlist = "threads:10 times:4 millisecs:20 digits:100";
		
		int nIndexOfThreads 	= parmlist.toLowerCase().indexOf("threads:");	// 10
		int nIndexOfTimes 		= parmlist.toLowerCase().indexOf("times:");		// 4
		int nIndexOfOutput 		= parmlist.toLowerCase().indexOf("output:");	// Default
		int nIndexOfMillisecs 	= parmlist.toLowerCase().indexOf("millisecs:");	// 20 (to sleep)
		int nIndexOfSync 		= parmlist.toLowerCase().indexOf("sync:");		// Default
		int nIndexOfCheck 		= parmlist.toLowerCase().indexOf("check:");		// Default
		int nIndexOfDigits		= parmlist.toLowerCase().indexOf("digits:");	// 100
		int nIndexOfCommon		= parmlist.toLowerCase().indexOf("common:");	// Default
 
		if (nIndexOfThreads != -1) {
			String strThreads = parmlist
					.substring(nIndexOfThreads + 8);
			StringTokenizer stThreads = new StringTokenizer(strThreads, " ");
			nNumberOfThreads = Integer.parseInt(stThreads.nextToken());
		}

		if (nIndexOfTimes != -1) {
			String strTimes = parmlist
					.substring(nIndexOfTimes + 6);
			StringTokenizer stTimes = new StringTokenizer(strTimes, " ");
			nThreadExecutesAmendFile = Integer.parseInt(stTimes.nextToken());
		}

		if (nIndexOfOutput != -1) {
			String strOutput = parmlist
					.substring(nIndexOfOutput + 7);
			StringTokenizer stOutput = new StringTokenizer(strOutput, " ");
			strNameOfOutputFile = stOutput.nextToken();
		}

		if (nIndexOfMillisecs != -1) {
			String strMillisecs = parmlist
					.substring(nIndexOfMillisecs + 10);
			StringTokenizer stMillisecs = new StringTokenizer(strMillisecs, " ");
			nThreadSleepInMillisecs = Integer.parseInt(stMillisecs.nextToken());

			if (nThreadSleepInMillisecs != 0) {
				blnThreadSleep = true;
			}
		}

		if (nIndexOfSync != -1) {
			String strSyncTemp = parmlist
					.substring(nIndexOfSync + 5);
			StringTokenizer stSync = new StringTokenizer(strSyncTemp, " ");
			stSync.nextToken();
		}

		if (nIndexOfCheck != -1) {
			String strCheckTemp = parmlist
					.substring(nIndexOfCheck + 6);
			StringTokenizer stCheck = new StringTokenizer(strCheckTemp, " ");
			strCheck = stCheck.nextToken();

			if ((strCheck.compareTo("no")) == 0) {
				htHash = null;
				blnCheck = false;
			}
		}

		if (nIndexOfDigits != -1) {
			String strDigits = parmlist.substring(nIndexOfDigits + 7);
			StringTokenizer stDigits = new StringTokenizer(strDigits, " ");
			nDigits = Integer.parseInt(stDigits.nextToken());
		}

		if (nIndexOfCommon != -1) {
			String strCommonTemp = parmlist.substring(nIndexOfCommon + 7);
			StringTokenizer stCommon = new StringTokenizer(strCommonTemp, " ");
			strCommon = stCommon.nextToken();

			if ((strCommon.compareTo("no")) == 0) {
				blnCommonFileChannel = false;
			}
		}

		System.out.println(" Number of threads = " + nNumberOfThreads);
		System.out.println(" Are reading and writing to the file named "
				+ strNameOfOutputFile);
		System.out.println(" Each thread is reading and writing to the file "
				+ nThreadExecutesAmendFile + " times");

		if (nThreadExecutesAmendFile != 1) {
			System.out.println(" The thread is sleeping for " + nThreadSleepInMillisecs
					+ " millisecs between accessing file");
		}

		System.out.println(" All threads are accessing the file through the same file channel: "
				+ blnCommonFileChannel);
		System.out.println(" Are syncronising reading and writing to the file: "
				+ blnSync);
		System.out.println(" Are checking contents of the file against the contents of a hashtable: "
				+ blnCheck);
		System.out.println(" Your random number lies between 0 and " + (nDigits - 1));

		if (blnCommonFileChannel) {
			try {
				fFile = new File(strNameOfOutputFile);
				rafRandom = new RandomAccessFile(fFile, "rw");
				fcFileChannel = rafRandom.getChannel();
			} catch (IOException e) {
				System.out.println("Error occured in main class - when creating common file channel: " + e);
			}
		}

		for (int nLoopCount = 0; nLoopCount < loopCount; nLoopCount++) {
			System.out.println(strThreadName + " Convert: Loop Count =  " + nLoopCount);
			
			// Creating a runnable and thread array, each with size the
			// number that was written on the command line.
			Runnable tcArray[] = new Runnable[nNumberOfThreads];
			Thread thArray[] = new Thread[nNumberOfThreads];

			// Setting off each thread in turn
			for (int i = 0; i < tcArray.length; i++) {
				// Making each element of the Runnable array an instance
				// of the ThreadWork class and making each element of
				// the thread array a thread associated with an instance
				// of the ThreadClass. First it is checked whether or
				// not you want to check the contents of the file with
				// the contents of a hashtable.
				if (blnCommonFileChannel) {
					if (blnCheck) {
						tcArray[i] = new ThreadWork(fFile, fcFileChannel,
								nThreadExecutesAmendFile, blnThreadSleep,
								nThreadSleepInMillisecs, blnSync, nDigits,
								htHash);
					} else {
						tcArray[i] = new ThreadWork(fFile, fcFileChannel,
								nThreadExecutesAmendFile, blnThreadSleep,
								nThreadSleepInMillisecs, blnSync, nDigits);
					}
				} else {
					if (blnCheck) {
						tcArray[i] = new ThreadWork(
								nThreadExecutesAmendFile,
								strNameOfOutputFile, blnThreadSleep,
								nThreadSleepInMillisecs, blnSync, nDigits,
								htHash);
					} else {
						tcArray[i] = new ThreadWork(
								nThreadExecutesAmendFile,
								strNameOfOutputFile, blnThreadSleep,
								nThreadSleepInMillisecs, blnSync, nDigits);
					}
				}

				thArray[i] = new Thread(tcArray[i]);

				// Starting the thread.
				thArray[i].start();
			}

			// Making sure all threads are dead before reading the file
			for (int i = 0; i < tcArray.length; i++) {
				while (thArray[i].isAlive()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) { }
				}
			}
		}  // end for loop (executing this loop_ct number of times)

		if (blnCommonFileChannel) {
				// closing RandomAccessFile, which will in turn close the
				// file channel
				rafRandom.close();
		}

		// Reading the file - all the output goes to the screen
		// (have commented this out since are not reading the file
		// to check the numbers - uncomment it if you want to check
		// the numbers)
		ReadingFile rf = new ReadingFile();
		rf.Reading(strNameOfOutputFile);
		System.out.println(" ============================================================== ");
		System.out.println(" Total number of times the file has been written to = "
				+ rf.TotalFileEntries());
		System.out.println(" ============================================================== ");

		// Comparing file and hash table if have opted to do this
		if (blnCheck) {
			ComparingFileHashTable cfht = new ComparingFileHashTable();
			int nNumberOfRandomNumbers = cfht.NumberOfRandomNumbers(htHash);
			cfht.Compare(strNameOfOutputFile, htHash);
			System.out.println("                                                     ");
			System.out.println(" =========== Results from the comparison =========== ");
			System.out.println(" Number of different random numbers generated = "
					+ nNumberOfRandomNumbers + " ");
			System.out.println(" Number of matches = " + cfht.Matches() + " ");

			if (cfht.TotalDiffs() == 0) {
				System.out.println(" Total Number of Differences = 0 ");
				System.out.println(" =============================== ");
				System.out.println("                                 ");
				System.out.println(" THE TEST HAS PASSED ");
				rc = 0;
			} else {
				System.out.println(" Total number of differences = "
						+ cfht.TotalDiffs() + " ");
				System.out.println(" Total number of times a random number appeared in both the file and hashtable but with different occurences = "
						+ cfht.OccurenceDiffs() + " ");
				System.out.println(" Total number of random numbers that occured in the file and not in the hashtable = "
						+ cfht.NotInHashTable() + " ");
				System.out.println(" Total number of random numbers that occured in the hashtable and not in the file = "
						+ cfht.NotInFile() + " ");
				System.out.println(" =================== ");
				System.out.println("                     ");
				System.out.println(" THE TEST HAS FAILED ");
				rc = 99;
			}
			System.out.println(" =================================================== ");
		}

		System.out.println(strThreadName + " Convert Final return code: " + rc);

		// Delete buffer file if test passed
        if (rc == 0) {
        	fFile.delete();
        }
		// end run()
	}
} // end class

/*******************************************************************************
 * 
 * Class ThreadWork - The class which contains the work that the thread does. It
 * generates a random number (integer = 4 bytes) and creates a new instance of
 * the AmendFile class. If the you have specified you want the file output to be
 * checked (this is done in the main program) then an instance of the HashTables
 * class is also created. The thread then calls the Amend method which
 * manipulates the file and the AmendHashTable method which maniputlates the
 * hashtable.
 * 
 * Constructor method 1:
 * ThreadWork(File,FileChannel,int,String,boolean,int,boolean,int,hashtable)
 * 
 * File = file object associated with the file you are reading/writing to
 * FileChannel = FileChannel associated with the file you are reading/writing to
 * int = number of times will call AmendFile class String = name of file wish to
 * manipulate boolean = whether thread sleeps between calling AmendFile class
 * int = how long thread sleeps boolean = whether you want to synchronise
 * reading/ writing to the file int = your random number will lie between 0 and
 * (int - 1) hashtable = the hashtable you want to use as a check
 * 
 * Constructor method 2:
 * ThreadWork(File,FileChannel,int,String,boolean,int,boolean,int)
 * 
 * File = file object associated with the file you are reading/writing to
 * FileChannel = FileChannel associated with the file you are reading/writing to
 * int = number of times will call AmendFile class String = name of file wish to
 * manipulate boolean = whether thread sleeps between calling AmendFile class
 * int = how long thread sleeps boolean = whether you want to synchronise
 * reading/ writing to the file int = your random number will lie between 0 and
 * (int - 1)
 * 
 * Constructor method 3:
 * ThreadWork(int,String,boolean,int,boolean,int,hashtable)
 * 
 * int = number of times will call AmendFile class String = name of file wish to
 * manipulate boolean = whether thread sleeps between calling AmendFile class
 * int = how long thread sleeps boolean = whether you want to synchronise
 * reading/ writing to the file int = your random number will lie between 0 and
 * (int - 1) hashtable = the hashtable you want to use as a check
 * 
 * Constructor method 4: ThreadWork(int,String,boolean,int,boolean,int)
 * 
 * int = number of times will call AmendFile class String = name of file wish to
 * manipulate boolean = whether thread sleeps between calling AmendFile class
 * int = how long thread sleeps boolean = whether you want to synchronise
 * reading/ writing to the file int = your random number will lie between 0 and
 * (int - 1)
 * 
 * Method: run()
 *  
 ******************************************************************************/

class ThreadWork implements Runnable {
	int TW_nThreadExecutesAmendFile;
	int TW_nMillisecs;
	int TW_nDigits;
	String TW_strFilename;
	boolean TW_blnSleep;
	boolean TW_blnSync;
	boolean TW_blnCommonFileChannel;
	Hashtable<?, Integer> TW_htHash = null;
	File TW_f = null;
	FileChannel TW_fc = null;

	// A constructor for the method.
	ThreadWork(File p_TW_f, FileChannel p_TW_fc,
			int p_TW_nThreadExecutesAmendFile, boolean p_TW_blnSleep,
			int p_TW_nMillisecs, boolean p_TW_blnSync, int p_TW_nDigits,
			Hashtable<?, Integer> p_TW_htHash) {
		TW_f = p_TW_f;
		TW_fc = p_TW_fc;
		TW_nThreadExecutesAmendFile = p_TW_nThreadExecutesAmendFile;
		TW_nMillisecs = p_TW_nMillisecs;
		TW_blnSleep = p_TW_blnSleep;
		TW_blnSync = p_TW_blnSync;
		TW_nDigits = p_TW_nDigits;
		TW_htHash = p_TW_htHash;
		TW_blnCommonFileChannel = true;
	}

	// A constructor for the method.
	ThreadWork(File p_TW_f, FileChannel p_TW_fc,
			int p_TW_nThreadExecutesAmendFile, boolean p_TW_blnSleep,
			int p_TW_nMillisecs, boolean p_TW_blnSync, int p_TW_nDigits) {
		TW_f = p_TW_f;
		TW_fc = p_TW_fc;
		TW_nThreadExecutesAmendFile = p_TW_nThreadExecutesAmendFile;
		TW_nMillisecs = p_TW_nMillisecs;
		TW_blnSleep = p_TW_blnSleep;
		TW_blnSync = p_TW_blnSync;
		TW_nDigits = p_TW_nDigits;
		TW_blnCommonFileChannel = true;
	}
	
	// A constructor for the method.
	ThreadWork(int p_TW_nThreadExecutesAmendFile, String p_TW_strFilename,
			boolean p_TW_blnSleep, int p_TW_nMillisecs, boolean p_TW_blnSync,
			int p_TW_nDigits, Hashtable<?, Integer> p_TW_htHash) {
		TW_nThreadExecutesAmendFile = p_TW_nThreadExecutesAmendFile;
		TW_nMillisecs = p_TW_nMillisecs;
		TW_strFilename = p_TW_strFilename;
		TW_blnSleep = p_TW_blnSleep;
		TW_blnSync = p_TW_blnSync;
		TW_nDigits = p_TW_nDigits;
		TW_htHash = p_TW_htHash;
		TW_blnCommonFileChannel = false;
	}

	// A constructor for the method.
	ThreadWork(int p_TW_nThreadExecutesAmendFile, String p_TW_strFilename,
			boolean p_TW_blnSleep, int p_TW_nMillisecs, boolean p_TW_blnSync,
			int p_TW_nDigits) {
		TW_nThreadExecutesAmendFile = p_TW_nThreadExecutesAmendFile;
		TW_nMillisecs = p_TW_nMillisecs;
		TW_strFilename = p_TW_strFilename;
		TW_blnSleep = p_TW_blnSleep;
		TW_blnSync = p_TW_blnSync;
		TW_nDigits = p_TW_nDigits;
		TW_blnCommonFileChannel = false;
	}

	// The method where the work of the thread is contained.
	public void run() {
		int nRandomNumber = 0;
		AmendFile af = new AmendFile();
		HashTables hts = new HashTables();

		for (int i = 0; i < TW_nThreadExecutesAmendFile; i++) {
			nRandomNumber = (int) (Math.random() * (TW_nDigits));
			if (TW_blnCommonFileChannel) {
				af.AmendWithCommonFileChannel(TW_f, TW_fc, nRandomNumber, TW_blnSync);
			} else {
				af.Amend(TW_strFilename, nRandomNumber, TW_blnSync);
			}
			if (TW_htHash != null) {
				hts.AmendHashTable(nRandomNumber, TW_htHash);
			}

			// The following sleep() is added to simulate the thread
			// returning and spawning a new thread. Whether it is
			// executed is passed as an argument
			if (TW_blnSleep) {
				try {
					Thread.sleep(TW_nMillisecs);
				} catch (InterruptedException e) {}
			}
		}
	}
} // end class

/*******************************************************************************
 * 
 * Class AmendFile - where all the file amending is done
 * 
 * Constructor method: AmendFile()
 * 
 * Method 1: Amend(String,int,boolean)
 * 
 * String = name of file you wish to manipuate int = number you want to check
 * the file for boolean = whether you want to synchronise reading/writing to the
 * file
 * 
 * This reads/writes to a file and each time you access this method a file
 * object is created associated with this file.
 * 
 * Method 2: AmendWithCommonFileChannel(File,FileChannel,int,boolean)
 * 
 * File = the file object associated with the file you want to manipulate
 * FileChannel = the FileChannel associated with the file you want to manipulate
 * int = the number you want to check the file for boolean = whether you want to
 * synchronise reading/ writing to the file
 * 
 * This reads/writes to a file using an existing file object and FileChannel.
 *  
 ******************************************************************************/

class AmendFile {

	AmendFile() {
	};

	public void Amend(String p_AF_strFilename, int p_AF_nRandomNumber,
			boolean p_AF_blnSync) {
		try {
			int nNumberOfBytes = 0;
			boolean blnAppendNumber = false;
			boolean blnContinue = true;
			long lCount;
			int nNumber;
			int nRecordNumber = 0;
			int nBufferLength = 12;

			// open file in read-write mode
			File f = new File(p_AF_strFilename);
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			// get a channel for the file and provide a place in
			// memory to put the file with a buffer
			FileChannel fc = raf.getChannel();
			ByteBuffer bb = java.nio.ByteBuffer.allocate(nBufferLength);

			// If we have chosen to synchonise reading/writing to the file
			// we do so, if not then we execute the same commands just
			// without the synchronisation.
			if (p_AF_blnSync) {
				synchronized (NioApp.class) {
					// while we wish to continue
					while (blnContinue) {
						// Starting at byte number (nRecordNumber*nBufferLength)
						// we read in the next nBufferLength bytes into the
						// buffer (this is due to the fact that we've allocated
						// nBufferLength bytes for ByteBuffer).
						nNumberOfBytes = fc.read(bb, nRecordNumber
								* nBufferLength);

						// If we've reached the end of the file or the file is
						// empty we are going to append to the file. Therefore
						// we drop out of the while loop.
						if (nNumberOfBytes == -1 || nNumberOfBytes == 0) {
							blnContinue = false;
							blnAppendNumber = true;
						} else {
							// On the other hand, if we are not at the end of the
							// file or the file is not empty, we rewind to the
							// beginning of the buffer and read in the next 4 bytes (integer).
							bb.rewind();
							nNumber = bb.getInt();

							// If the integer we've read from the file is equal
							// to the number we've generated then we read in the
							// next 8 bytes (long). This is the counter (lCount)
							// for the number of times the integer has been
							// generated. We then increment this counter, move
							// back 8 bytes in the buffer and put the new value
							// of lCount into the buffer. blnContinue is set to
							// false and we fall out of the while loop.
							if (nNumber == p_AF_nRandomNumber) {
								lCount = bb.getLong();
								lCount++;
								bb.position(bb.position() - 8);
								bb.putLong(lCount);
								blnContinue = false;
							} else {
								// On the other hand, if the integer we've read
								// from the file is not equal to the one we
								// have generated then we increment
								// nRecordNumber
								// and clear the buffer. The while loop is then
								// repeated for the next nRecordNumber bytes in
								// the file.
								nRecordNumber++;
								bb.clear();
							}
						}
					}

					// If in the previous while loop we have found that we
					// are at the end of the file and have not seen the number
					// we have generated then we need to append to the file.
					// This is what we do here.
					if (blnAppendNumber) {
						// We create a new ByteBuffer of length nBufferLength
						// bytes and put the random number we have generated
						// into the first 4 bytes and the value (counter) 1 in
						// the next 8 bytes. We then rewind to the beginning
						// of the buffer and write the buffer back to the end of
						// the file through the channel.
						ByteBuffer bbAppend = java.nio.ByteBuffer
								.allocate(nBufferLength);
						bbAppend.putInt(p_AF_nRandomNumber);
						bbAppend.putLong(1L);
						bbAppend.rewind();

						int nLength = (int) f.length();
						nNumberOfBytes = fc.write(bbAppend, nLength);
					} else {
						// On the other hand, if we have found our random number
						// already in the file and have incremented the counter,
						// we rewind to the beginning of that buffer and write
						// it back to the file through the channel.
						bb.rewind();
						fc.write(bb, nRecordNumber * nBufferLength);
					}

					// We then force the changes to be made to the file and
					// close the file channel.
					fc.force(true);
					fc.close();
				}

				// If we have chosen not to synchronise reading and writing to
				// the file then we execute the same commands as above, just
				// without synchronisation.
			} else {
				while (blnContinue) {
					nNumberOfBytes = fc.read(bb, nRecordNumber * nBufferLength);
					if (nNumberOfBytes == -1 || nNumberOfBytes == 0) {
						blnContinue = false;
						blnAppendNumber = true;
					} else {
						bb.rewind();
						nNumber = bb.getInt();
						if (nNumber == p_AF_nRandomNumber) {
							lCount = bb.getLong();
							lCount++;
							bb.position(bb.position() - 8);
							bb.putLong(lCount);
							blnContinue = false;
						} else {
							nRecordNumber++;
							bb.clear();
						}
					}
				}

				if (blnAppendNumber) {
					ByteBuffer bbAppend = java.nio.ByteBuffer
							.allocate(nBufferLength);
					bbAppend.putInt(p_AF_nRandomNumber);
					bbAppend.putLong(1L);
					bbAppend.rewind();

					int nLength = (int) f.length();
					nNumberOfBytes = fc.write(bbAppend, nLength);
				} else {
					bb.rewind();
					fc.write(bb, nRecordNumber * nBufferLength);
				}
				fc.force(true);
				fc.close();
			}

			// closing the RandomAccessFile
			raf.close();
		} catch (IOException e) {
			System.out.println("Error occured in AppendFile class - Append method: " + e);
		}
		// end Amend method
	}

	public void AmendWithCommonFileChannel(File p_f, FileChannel p_fc,
			int p_nRandomNumber, boolean p_blnSync) {
		try {
			int nNumberOfBytes = 0;
			boolean blnAppendNumber = false;
			boolean blnContinue = true;
			long lCount;
			int nNumber;
			int nRecordNumber = 0;
			int nBufferLength = 12;

			// get a channel for the file and provide a place in
			// memory to put the file with a buffer
			FileChannel fc = p_fc;
			ByteBuffer bb = java.nio.ByteBuffer.allocate(nBufferLength);

			// If we have chosen to synchonise reading/writing to the file
			// we do so, if not then we execute the same commands just
			// without the synchronisation.
			if (p_blnSync) {
				synchronized (NioApp.class) {
					// while we wish to continue
					while (blnContinue) {
						// starting at byte number (nRecordNumber*nBufferLength)
						// we read in the next nBufferLength bytes into the
						// buffer (this is due to the fact that we've allocated
						// nBufferLength bytes for ByteBuffer).
						nNumberOfBytes = fc.read(bb, nRecordNumber
								* nBufferLength);

						// If we've reached the end of the file or the file is
						// empty we are going to append to the file. Therefore
						// we drop out of the while loop.
						if (nNumberOfBytes == -1 || nNumberOfBytes == 0) {
							blnContinue = false;
							blnAppendNumber = true;
						} else {
							// On the other hand, if we are not at the end of the
							// file or the file is not empty, we rewind to the
							// beginning of the buffer and read in the next 4
							// bytes (integer).
							bb.rewind();
							nNumber = bb.getInt();

							// If the integer we've read from the file is equal
							// to the number we've generated then we read in the
							// next 8 bytes (long). This is the counter (lCount)
							// for the number of times the integer has been
							// generated. We then increment this counter, move
							// back 8 bytes in the buffer and put the new value
							// of lCount into the buffer. blnContinue is set to
							// false and we fall out of the while loop.
							if (nNumber == p_nRandomNumber) {
								lCount = bb.getLong();
								lCount++;
								bb.position(bb.position() - 8);
								bb.putLong(lCount);
								blnContinue = false;
							} else {
								// On the other hand, if the integer we've read
								// from the file is not equal to the one we
								// have generated then we increment
								// nRecordNumber
								// and clear the buffer. The while loop is then
								// repeated for the next nRecordNumber bytes in
								// the file.
								nRecordNumber++;
								bb.clear();
							}
						}
					}

					// If in the previous while loop we have found that we
					// are at the end of the file and have not seen the number
					// we have generated then we need to append to the file.
					// This is what we do here.
					if (blnAppendNumber) {
						// We create a new ByteBuffer of length nBufferLength
						// bytes and put the random number we have generated
						// into the first 4 bytes and the value (counter) 1 in
						// the next 8 bytes. We then rewind to the beginning
						// of the buffer and write the buffer back to the end of
						// the file through the channel.
						ByteBuffer bbAppend = java.nio.ByteBuffer
								.allocate(nBufferLength);
						bbAppend.putInt(p_nRandomNumber);
						bbAppend.putLong(1L);
						bbAppend.rewind();

						int nLength = (int) p_f.length();
						nNumberOfBytes = fc.write(bbAppend, nLength);
					} else {
						// On the other hand, if we have found our random number
						// already in the file and have incremented the counter,
						// we rewind to the beginning of that buffer and write
						// it back to the file through the channel.
						bb.rewind();
						fc.write(bb, nRecordNumber * nBufferLength);
					}

					// We then force the changes to be made to the file
					fc.force(true);
				}

				// If we have chosen not to synchronise reading and writing to
				// the file then we execute the same commands as above, just
				// without synchronisation.
			} else {
				while (blnContinue) {
					nNumberOfBytes = fc.read(bb, nRecordNumber * nBufferLength);
					if (nNumberOfBytes == -1 || nNumberOfBytes == 0) {
						blnContinue = false;
						blnAppendNumber = true;
					} else {
						bb.rewind();
						nNumber = bb.getInt();
						if (nNumber == p_nRandomNumber) {
							lCount = bb.getLong();
							lCount++;
							bb.position(bb.position() - 8);
							bb.putLong(lCount);
							blnContinue = false;
						} else {
							nRecordNumber++;
							bb.clear();
						}
					}
				}
				if (blnAppendNumber) {
					ByteBuffer bbAppend = java.nio.ByteBuffer
							.allocate(nBufferLength);
					bbAppend.putInt(p_nRandomNumber);
					bbAppend.putLong(1L);
					bbAppend.rewind();
					int nLength = (int) p_f.length();
					nNumberOfBytes = fc.write(bbAppend, nLength);
				} else {
					bb.rewind();
					fc.write(bb, nRecordNumber * nBufferLength);
				}
				fc.force(true);
			}
		} catch (IOException e) {
			System.out.println("Error occured in AmendFile class - AppendWithCommonFileChannel method: " + e);
		}
		// end AmendWithOneFileChannel method
	}
	// end class
}

/*******************************************************************************
 * 
 * Class ReadingFile - reads a file in 12 byte chunks and prints the contents to
 * the screen
 * 
 * Constructor method: ReadingFile()
 * 
 * Method 1: Reading(String)
 * 
 * String = name of file you wish to read
 * 
 * Method 2: TotalFileEntries() - returns the total number of file entries
 * 
 * Method 3: TotalNumbers() - returns the number of different random numbers in
 * the file
 *  
 ******************************************************************************/

class ReadingFile {

	ReadingFile() {
	};

	long lTotalFileEntries = 0;
	int nTotalNumbers = 0;

	// This method reads the file sFilename and prints out it's contents.
	public void Reading(String p_strFilename) {
		try {
			int nRecordNumber = 0;
			int nCount = 1;
			long lCount;
			int nBufferLength = 12;
			System.out.println("I'm reading the file after making all the changes");
			
			// Get a channel for the file and provide a place
			// in memory to put the bytes with a buffer
			File f = new File(p_strFilename);
			FileInputStream fis = new FileInputStream(f);
			FileChannel fc = fis.getChannel();
			ByteBuffer bb = java.nio.ByteBuffer.allocate(nBufferLength);

			// while we are not at the end of the file
			while (nCount != 0 && nCount != -1) {
				// Starting at byte number (nRecordNumber*nBufferLength)
				// read the next nBufferLength bytes from the file into
				// buffer bb and rewind to the beginning of the buffer
				nCount = fc.read(bb, nRecordNumber * nBufferLength);
				bb.rewind();

				// if we are not at the end of the file
				if (nCount != -1 && nCount != 0) {
					lCount = bb.getLong();
					lTotalFileEntries = lTotalFileEntries + lCount;
					nTotalNumbers++;
				}

				// clear the buffer and increment the nRecordNumber (this will
				// ensure the next 12 bytes are read into the buffer.
				bb.clear();
				nRecordNumber++;
			}

			// closing the FileInputStream (are not closing the filechannel
			// since closing the
			// FileInputStream should do this).
			fis.close();
		} catch (IOException e) {
			System.out.println("Error occured in ReadingFile class: " + e);
		}
	}

	public long TotalFileEntries() {
		return lTotalFileEntries;
	}

	public int TotalNumbers() {
		return nTotalNumbers;
	}
	// end class ReadingFile
}

/*******************************************************************************
 * 
 * Class HashTables - creates a hashtable whose keys are random numbers and
 * whose values are the number of times that random number has appeared.
 * 
 * Constructor: HashTables()
 * 
 * Method: AmendHashTable(int, Hashtable)
 * 
 * int = number you which to check the hashtable for Hashtable = hashtable you
 * wish to use
 *  
 ******************************************************************************/

class HashTables {

	HashTables() {
	};

	@SuppressWarnings("unchecked")
	public void AmendHashTable(int p_HT_nRandomNumber, @SuppressWarnings("rawtypes") Hashtable p_HT_htHash) {
		int nKey;
		boolean blnKeyIsThere;
		Object objGetValue;

		// renaming the Random number passed to the method
		nKey = p_HT_nRandomNumber;

		// Making reading and writing to the hashtable thread safe (this is
		// not an option since I'm using the hashtable as a check
		synchronized (NioApp.class) {
			// checking the Hashtable to see if the random number is there
			blnKeyIsThere = p_HT_htHash.containsKey(" " + nKey);

			// If the random number is there then get the value associated with this
			// key, increase it by one, remove the key (and hence the value)
			// from the hashtable (this ensures that each random number only has one
			// entry in the hashtable) and then put the random number back into
			// the hashtable (as a key) with the new value. If the random number
			// is not there then add it to the hashtable as a key with value one.
			if (blnKeyIsThere) {
				objGetValue = p_HT_htHash.get(" " + nKey);
				String strGetValue = objGetValue.toString();
				int nGetValue = Integer.parseInt(strGetValue);
				int nNewValue = nGetValue + 1;
				p_HT_htHash.remove(" " + nKey);
				p_HT_htHash.put(" " + nKey, new Integer(nNewValue));
				p_HT_htHash.get(" " + nKey);
			} else {
				p_HT_htHash.put(" " + nKey, new Integer(1));
				objGetValue = p_HT_htHash.get(" " + nKey);
			}
			// end synchronized
		}
		// end method AmendHashTable
	}
	// end class HashTables
}

/*******************************************************************************
 * 
 * Class ComparingFileHashTable - compares a file and hashtable to see if they
 * contain the same elements
 * 
 * Constructor: ComparingFileHashTable()
 * 
 * Method 1: Compare(String, Hashtable)
 * 
 * String = name of file which to compare Hashtable = the Hashtable you wish to
 * compare with the file
 * 
 * Method 2: Matches - returns the number of matches between the entries in the
 * file and hashtable
 * 
 * Method 3: OccurenceDiffs() - returns the number of times the same number was
 * in the file and hashtable but with different occurence values
 * 
 * Method 4: NotInHashTable() - returns the number of times a number was in the
 * file and not the hashtable
 * 
 * Method 5: NotInFile() - returns the number of times a number was in the
 * hashtable and not the file
 * 
 * Method 6: TotalDiffs() - returns the total number of differences between the
 * file and hashtable
 * 
 * Method 7: NumberOfRandomNumbers(hashtable)
 * 
 * Hashtable = the hashtable you are comparing the file with - returns the
 * number of different random numbers in the hashtable
 *  
 ******************************************************************************/
class ComparingFileHashTable {
	int nMatches = 0;
	int nTotalDiffs = 0;
	int nNotInFile = 0;
	int nNotInHashTable = 0;
	int nOccurenceDiffs = 0;

	// This method reads the file sFilename and prints out it's contents.
	public void Compare(String p_CFHT_strFilename, Hashtable<Object, Integer> p_CFHT_htHashTable) {
		try {
			int nRecordNumber = 0;
			int nCount = 1;
			int nBufferLength = 12;
			int nKey;
			long lGetValue;
			long lCount;
			boolean blnKeyIsThere;
			Object objGetValue;
			Hashtable<Object, Integer> htHashTable = p_CFHT_htHashTable;

			System.out.println("I am comparing the file with the hashtable");
			// Get a channel for the file and provide a place
			// in memory to put the bytes with a buffer
			File f = new File(p_CFHT_strFilename);
			FileInputStream fis = new FileInputStream(f);
			FileChannel fc = fis.getChannel();
			ByteBuffer bb = java.nio.ByteBuffer.allocate(nBufferLength);

			// while we are not at the end of the file
			while (nCount != 0 && nCount != -1) {

				// Starting at byte number (nRecordNumber*nBufferLength)
				// read the next nBufferLength bytes from the file into
				// buffer bb and rewind to the beginning of the buffer
				nCount = fc.read(bb, nRecordNumber * nBufferLength);
				bb.rewind();

				// If we are not at the end of the file
				if (nCount != -1 && nCount != 0) {
					// Read the first 4 bytes and then the next 8 bytes and
					// print the results to the screen.
					nKey = bb.getInt();
					lCount = bb.getLong();

					// Checking the Hashtable to see if the random number is there
					blnKeyIsThere = htHashTable.containsKey(" " + nKey);

					// If the random number is there then get the value
					// associated with this
					// key. Compare this value with the occurences value in the
					// file. If they are
					// the same then increase the nMatches count, if they are
					// different print their
					// values to the screen and increase the differences count.
					// In each case
					// remove the key from the hashtable. If the random number
					// is not there
					// then print this to the screen also.
					if (blnKeyIsThere) {
						objGetValue = htHashTable.get(" " + nKey);
						lGetValue = Long.parseLong(objGetValue.toString());
						if (lCount == lGetValue) {
							nMatches++;
							htHashTable.remove(" " + nKey);
						} else {
							nOccurenceDiffs++;
							htHashTable.remove(" " + nKey);
						}
					} else {
						nNotInHashTable++;
					}
				}

				// clear the buffer and increment the nRecordNumber (this will
				// ensure the next 12 bytes are read into the buffer.
				bb.clear();
				nRecordNumber++;

			}

			// close the FileInputStream (this consequently closes the
			// FileChannel
			fis.close();

			// Check to see if there are any keys left in the hashtable. If
			// there aren't
			// then print all the results to the screen, if there are then
			// calculate how
			// many keys are left in the hashtable and print all the results to
			// the screen.
			if (htHashTable.isEmpty()) {
				nTotalDiffs = nOccurenceDiffs + nNotInHashTable;
			} else {
				nNotInFile = htHashTable.size();
				nTotalDiffs = nOccurenceDiffs + nNotInHashTable + nNotInFile;
			}
		} catch (IOException e) {
			System.out.println("Error occured in ComparingFileHashTable class: " + e);
		}
	}

	public int Matches() {
		return nMatches;
	}

	public int OccurenceDiffs() {
		return nOccurenceDiffs;
	}

	public int NotInHashTable() {
		return nNotInHashTable;
	}

	public int NotInFile() {
		return nNotInFile;
	}

	public int TotalDiffs() {
		return nTotalDiffs;
	}

	public int NumberOfRandomNumbers(Hashtable<Object, Integer> p_htHash) {
		return p_htHash.size();
	}
	// end class ComparingFileHashTable
}