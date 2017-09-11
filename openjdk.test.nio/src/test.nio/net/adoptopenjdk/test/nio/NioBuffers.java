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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Random;

public class NioBuffers {
    public void run() throws IOException {
    	// Created loopCount and threadName variables to make this test class compatible with STF.
    	int loopCount = 2;
        String threadName = Thread.currentThread().getName().replace('-','_'); // replace dash
        
        int pass = 1;

        while (pass++ <= loopCount)
        {

            System.out.println(threadName + " nioBuffers: Pass "
                    + (pass - 1));

            StringBuffer str = new StringBuffer();
            int strlength;

            IntBuffer ib = IntBuffer.allocate(48);
            DoubleBuffer db = DoubleBuffer.allocate(48);
            LongBuffer lb = LongBuffer.allocate(48);
            ShortBuffer sb = ShortBuffer.allocate(48);
            // FloatBuffer fb = FloatBuffer.allocate(48);

            float[] floats = { 6.612297E-39F, 9.918385E-39F,
                    1.0193785E-38F, 1.092858E-38F, 1.0469398E-38F,
                    9.183596E-39F };

            ByteBuffer byteBuff = ByteBuffer.allocate(floats.length * 4);

            FloatBuffer flBuff = byteBuff.asFloatBuffer();
            flBuff.put(floats);
            flBuff.flip();

            System.out.println("Float buffer:");
            while (flBuff.hasRemaining())
            {
                float fbout = flBuff.get();
                str.append(fbout + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);

            CharBuffer charBuff = byteBuff.asCharBuffer();
            System.out.println(charBuff.toString());

            // ********************************************************

            // for IntBuffer

            Random Rin = new Random();
            System.out.println("Integer written to the buffer:");
            for (int i = 0; i < ib.limit(); i++)
            {
                int Rinput = 1 + Math.abs(Rin.nextInt()) % 9999;
                str.append(Rinput + " , ");
                ib.put(Rinput);
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);

            ib.flip();

            System.out.println("Int buffer output:");
            while (ib.hasRemaining())
            {
                int Intout = ib.get();
                str.append(Intout + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);

            ib.clear();
            // *********************************************

            // for Short Buffer

            System.out.println("Short written to the buffer:");
            for (int i = 0; i < sb.limit(); i++)
            {
                int Rinput = 1 + Math.abs(Rin.nextInt()) % 100;
                str.append(Rinput + " , ");
                sb.put((short) Rinput);
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            sb.flip();

            while (sb.hasRemaining())
            {
                int sbout = sb.get();
                str.append(sbout + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            sb.clear();

            // **************************************
            System.out.println("Double written to the buffer:");
            for (int i = 0; i < db.limit(); i++)
            {

                double Rinput = Rin.nextDouble();
                db.put(Rinput);
                str.append(Rinput + " , ");
                sb.put((short) Rinput);
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            db.flip();

            System.out.println("Double buffer output:");
            while (db.hasRemaining())
            {
                double dbout = db.get();
                str.append(dbout + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            db.clear();
            // ******************************************

            System.out.println("Long written to the buffer:");
            for (int i = 0; i < lb.limit(); i++)
            {

                long Rinput = Rin.nextLong();
                lb.put(Rinput);
                str.append(Rinput + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            lb.flip();
            System.out.println("Long buffer output:");
            while (lb.hasRemaining())
            {
                long lbout = lb.get();
                str.append(lbout + " , ");
            }
            System.out.println(str + "DONE");
            strlength = str.length();
            str.delete(0, strlength);
            lb.clear();
            // ******************************************

            // *******************************************

        }// end while
    }// end run()
}// end nioBuffers
