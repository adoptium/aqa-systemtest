Stress Nio Testcase Documentation 
=================================

Summary of the Nio Tests
--------------------------

The stress nio testsuite was written to test the new functionality contained in java.nio which was introduced in sdk140. The following sections contain details about the individual tests.

NioServer/NioClient
-------------------

The aim of these tests is to test selectors and use them for readiness selection and multiplexed io. NioServer creates a selector and has one thread to monitor the incoming io requests. When a client is ready for reading it gets an idle thread from a worker thread pool and it is that thread which does the work for the client, before returning itself to the idle thread pool. There are no command line arguments for these, as the number of worker threads is set to be 100 within the code. NioClient is the client program to run to connect to the server. This sets off a number of clients, each having its own SocketChannel, and loops until it connects to the server. Once the connection is made, a few messages are sent back and forth between the server and client. This work is repeated a set number of times, with the client sleeping between each execution of the work, before the client terminates by closing it's SocketChannel.  

### Parameters which can be passed to NioServer ###
1. The way in which the selector calls select,  i.e.. selection:timeout, selection:select, selection:selectNow.  The default is a random combination of these.
2. The timeout value for selection:timeout, i.e. timeout:5 (in milli seconds).  The default is 2000.
3. The port on which the server waits for clients,  i.e.. port:1590.  The default is 9000.
4. The hostname of the machine on which the server is run, i.e., host:hostname.  The default is localhost.

### Parameters which can be passed to NioClient ###
1. The number of client threads to be set off,  i.e.. clients:200.  The default is 1.
2. The number of times each client executes the work with the server,  i.e.. work:200.  The default is 100.
3. The port on which the client looks for the server,  i.e.. port:1590.  The default is 9000.
4. The hostname of the machine on which the clients are set off,  i.e.. host:hostname.  The default is localhost.

This testcase should be run with two different numbers of clients, one with 1024 clients and one with 2048 clients.

NioBuffers
----------

This testcase was written to test the different buffer types, the different ways of creating buffers, creating buffers of different sizes, reading and writing to a file using gathering/scattering and viewing bytebuffers as different primitive type buffers. The idea is the following:
1. Starts n number of threads.
2. Each thread:
   
	a)  Creates a buffer of random type t, of random size, by either allocating or wrapping.
    b)  For a random number of times, generates a random number and writes it to the buffer and to a list.
    c)  If the buffer created is not a ByteBuffer, then it writes the contents of the buffer into a ByteBuffer.
3. When all threads have finished, it reads (gathers) the contents of the ByteBuffers into a file.
4. It then creates n ByteBuffers and writes (scatters) the contents of the file into these ByteBuffers.
5. The ByteBuffers which correspond to buffers of different primitive types, are then viewed as these primitive types
6. The contents of these view buffers are then written to a list.
7. The original list (created by the thread) and this list are then compared.  If they are the same then the test passes, otherwise it fails.
 
There are command line arguments for this test. They are:
1. threads:x - where x is the number of threads (buffers) you want to create. The default is 1.
2. megs:x - where x is the maximum number of megs you want the buffer sizes to be. The default is 1.
3. type:t - where t is the type of buffer you want to create. This is for if you want to always create a buffer of a give primitive type. The choices are byte,char,double,float,int,long,short and the default is random.

NioApp
------

This program is a small application designed to stress test the Java NIO API by applying random updates and appends to a file down multiple threads.

Within the program each thread generates a random number and checks a file to see if the random number is there. If it is then the thread increases the count of this random number by one, if it isn't then the thread appends the random number to the end of the file with count one. There are several options available for this program. Firstly, you can choose to synchronize the threads reading and writing to the file. Secondly, there is the option to check the file's content with that of a hashtable, whose entries we assume to be correct. Moreover, if you wish to check the new locking functions available in Java 1.4.0, you can set off multiple concurrent versions of this program, each of which writes to its own individual file with the option of also writing to a common file. If you choose to write to a common file then you further have the option to tell each version of the program to lock the file when its accessing it. In this case, each individual version of the program automatically checks its own file contents against that of a hashtable. The differences are recorded and if need be, the file is corrected to mirror the hashtable. There is then a program which checks the entries in the common file against the entries in the combined contents of the individual files.

### How do I run NioApp? ###
Following options can be passed to the program using the 'paramlist' variable in NioApp.java:   
1. threads: The number of threads you wish to set off, the default is 1. 
2. times: The number of times you wish each thread to generate a random number and amend the file appropriately (ie. carry out the processing), the default is 1.
3. output: The name of the file you wish to update, the default is File-timestamp, the default is File-X, where X = time stamp taken at the beginning of the program. 
4. milisecs: The number of milliseconds you wish the threads to wait before generating another random number and amending the file, the default is 0.
5. sync: Whether you want to make amending the file thread safe, the default is yes.
6. check: Whether you want to check the final version of the file with a hashtable, the default is yes.
7. digits: The random number will lie between 1 and (digits - 1), the default is 10.
8. common: If you're setting off multiple concurrent versions of this program this is the option if you want them to write to a common file even if you don't want each version to lock the file, the default is no.

Note that in this example the runtime of the testcase has been set to 5 minutes, all messages are being sent to the results file, only one testcase object has been set off and the loop count has been set to '9999999' (this is large so that the program will end after 5 minutes as the runtime parameter overrides the loop count.)

### How does NioApp work? ###

1. The program receives as arguments the number of threads to be set off, the number of times each thread goes through the processing, the name of the output file specific to each version of the program, the number of milliseconds the threads sleep between processing, whether the file output will be checked with that of a hashtable, the upper limit on the random number and whether the threads all access the file using the same file channel.
1. The program sends the arguments to the threads.
1. Each new thread generates a random number.
1. The thread either uses the already opened file channel to read the file or it opens the file using a newly created file channel.
1. The file has the structure:
Number key (8 bytes) | Occurrence Count (12 bytes)

1. The file is searched for a match on the number key (at this point the thread may lock the file to prevent other threads accessing the file at the same time - this is the option 'sync:yes').
1. If a match is found, the Occurrence Count is incremented and the appropriate bytes rewritten to the file.
1. If a match is not found, the new Number Key is appended to the file with an Occurrence Count of 1.
1. If you have chosen to check the file ('check:yes') then the file updates are mirrored to a hashtable.
1. The processing is repeated until the number of threads passed to the program as an argument has been reached.
1. If the option of checking the file is chosen then the file contents are compared with that of the hashtable and any anomalies are reported.


Wordcount
---------

This testcase reads a file and counts the number of times each letter occurs in the file.  It uses FileChannel, MappedByteBuffer, Charset, CharsetDecoder,CharBuffer,Pattern and Matcher.

NioBuffers
----------

This testcase also tests the different buffer types.
