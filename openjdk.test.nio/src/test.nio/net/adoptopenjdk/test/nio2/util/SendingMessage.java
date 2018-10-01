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

import java.nio.ByteBuffer;

public class SendingMessage extends Message {

	private static int sequenceId;

	static {
		sequenceId = 0;
	}
	
	private static synchronized int getNextId() {
		int seq = sequenceId++;
		return (seq);
		
	}
	
	private int sequence;
	
	public SendingMessage() {
		super();
		sequence = getNextId();
		header.set("ID", String.valueOf(sequence));
	}
	
	public SendingMessage(Message message) {
		super(message);
		sequence = getNextId();
		header.set("ID", message.getHeaderValue("ID"));
	}
	
	public void setMessageType(MessageTypes type) {
		header.set("TYPE", type.toString());
	}

	// Set the contents to be the message string, and return it
	// so that it can be used by the caller to confirm successful
	// transmission  
	public synchronized byte[] setFixedMessage(String message) {
		byte[] contents = message.getBytes();
		setContents(ByteBuffer.wrap(contents));
		return contents;
	}
	
	// As per setMessage, except it will set a random message obtained
	// from a cache. It will be the closest larger power of two bytes
	// long. Content string is again returned to the caller so that it
	// can be used for later verification
	public synchronized byte[] setRandomMessage(int messageLength) {
		byte[] randomContents = RandomByteArrays.getRandomByteArray(messageLength);
		setContents(ByteBuffer.wrap(randomContents));
		return randomContents;
	}
	
	public synchronized byte[] setRandomMessage() {
		byte[] randomContents = RandomByteArrays.getRandomByteArray();
		setContents(ByteBuffer.wrap(randomContents));
		return randomContents;
	}

	// Directly set the contents, which is a ByteBuffer, and can be fed
	// from either of the setXXXMessage methods.
	public synchronized void setContents(ByteBuffer contents) {
		this.contents = contents;
		header.set("length", String.valueOf(contents.capacity()));
	}
	
	public synchronized ByteBuffer getByteBuffer() {	
		ByteBuffer headerBuffer = header.getHeaderAsByteBuffer();	
		int length = headerBuffer.capacity() + contents.capacity();	
		ByteBuffer messageBuffer = ByteBuffer.allocate(length);	
		headerBuffer.position(0);
		
		while (headerBuffer.position() < headerBuffer.limit()) {
			byte b = headerBuffer.get();
			messageBuffer.put(b);
		}
		
		contents.position(0);
		while (contents.position() < contents.capacity()) {
			byte b = contents.get();
			messageBuffer.put(b);
		}
		
		// Flip buffer ready for writing to the channel
		messageBuffer.flip();
		return messageBuffer;
	}

}
