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

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.*;
import java.util.regex.*;

public class WordCount {
    public void run() throws IOException {
    	// Created loopCount, threadName and rc variables to make this test class compatible with STF.
        String thread_name = Thread.currentThread().getName().replace('-','_'); // replace dash
        int loopCount = 2;
        int rc = 1;  // Assume a failure unless told otherwise
        int pass = 1;
        
        while (pass++ <= loopCount)
        {
            System.out.println(thread_name + " Sum: Pass " + (pass - 1));
        	ClassLoader classLoader = getClass().getClassLoader();
        	File f = new File(classLoader.getResource("net/adoptopenjdk/test/nio/wordcount.txt").getFile());

            FileInputStream input = new FileInputStream(f);
            FileChannel channel = input.getChannel();

            int fileLength = (int) channel.size();
            System.out.println("FileLength=" + fileLength);

            MappedByteBuffer buffer = channel.map(
                    FileChannel.MapMode.READ_ONLY, 0, fileLength);

            Charset charset = Charset.forName("ISO-8859-1");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);

            Pattern linePattern = Pattern.compile(".*$", Pattern.MULTILINE);
            Pattern wordBreakPattern = Pattern.compile("[ \t\n\f\r]");

            Matcher lineMatcher = linePattern.matcher(charBuffer);

            Map<String, Integer> map = new TreeMap<String, Integer>();
            Integer ONE = new Integer(1);
            while (lineMatcher.find())
            {
                CharSequence line = lineMatcher.group();
                String words[] = wordBreakPattern.split(line);

                int n = words.length;
                for (int i = 0; i < n; i++)
                {
                    if (words[i].length() > 0)
                    {
                        Integer frequency = (Integer) map.get(words[i]);

                        if (frequency == null)
                        {
                            frequency = ONE;
                        } // end if
                        else
                        {
                            int value = frequency.intValue();
                            frequency = new Integer(value + 1);
                        }// end else
                        map.put(words[i], frequency);
                    }// end if

                }// end for
            } // end 2nd while
            System.out.println("WordCount is: " + map);
            channel.close();
            input.close();

            rc = 0;
        }// end 1st while
        System.out.println(thread_name + " WordCount Final RC = " + rc);
    }// end run
} // end WordCount

