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

public abstract class Message {

	protected MessageHeader header;
	protected ByteBuffer contents;
	
	public Message() {
		header = new MessageHeader();	
	}
	
	public Message(Message originalMessage) {		
		header = new MessageHeader();		
		for (String key :originalMessage.header.map.keySet()) {
			header.set(key, originalMessage.header.get(key));
		}
		
		ByteBuffer newContents = ByteBuffer.allocate(originalMessage.contents.capacity());
		originalMessage.contents.position(0);
		newContents.put(originalMessage.contents);
		newContents.position(0);
		this.contents = newContents;		
	}
	
	// Don't provide direct access to the Header object
	// so that we can control modification of it so that
	// the contents length key/value doesn't get out of sync	
	public synchronized String getHeaderValue(String key) {
		return header.get(key);
	}
	
	public String getHeaderString() {
		return header.toString();
	}
	
	public synchronized int getContentsLength() {	
		String length = header.get("length");		
		int iLength;
		
		try {
			iLength = Integer.parseInt(header.get("length"));
			return iLength;
		} catch (NumberFormatException nfe) {
			System.err.println(length);
			nfe.printStackTrace();
		}
		
		return 0;	
	}
	
	public MessageTypes getMessageType() {		
		String messageType = getHeaderValue("TYPE");		

		if (messageType == null) {
			return MessageTypes.UNKNOWN;
		}
	
		for(MessageTypes type: MessageTypes.values()) {
			if (messageType.equalsIgnoreCase(type.toString())) {
				return type;
			}
		}		
		
		return MessageTypes.UNKNOWN;		
	}
	
	public enum MessageTypes {
		PING,
		NAME,
		ECHO,
		TEXT_MESSAGE,
		UNKNOWN		
	}

	@Override
	public String toString() {
		String string = "ReceivingMessage\n";
		string += "Header:\n";
		string += header.toString();
		string += "\n";
		string += "Contents ByteBuffer:\n";
		string += contents.toString();		
		return string;
	}
	
	protected String contentsAsString() {	
		StringBuilder string = new StringBuilder();	
		contents.position(0);
		int position = 0;
		while (position < contents.limit()) {
			string.append((char)contents.get());
			position++;
		}
		
		return string.toString();	
	}	
}
