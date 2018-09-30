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

import net.adoptopenjdk.test.nio2.util.ConnectionState.ReceivingState;

public class IncomingMessageParser {

	private static IncomingMessageParser parser = null;
	
	private IncomingMessageParser() {		
	}
	
	public static synchronized IncomingMessageParser getInstance() {		
		if (parser == null) {
			parser = new IncomingMessageParser();
		}		
		return parser;		
	}
	
	public void parseBuffer(Integer readBytes, ConnectionState clientState) {		
		if (readBytes == -1) {
			// Client has disconnected
			return;
		}

		// If there are any half messages in the buffer, then they will remain
		// in the StringBuffer until the other half becomes available through
		// the ByteBuffer, at which point they will be parsed in the normal manner.
		 
		// Make sure to read all of the bytes, so that the buffer pointer
		// remains in the same place it was before the .flip() so as not to lose any data.
		int currentPosition = 0;

		// Loop through the entire incoming buffer, generating complete and partial messages
		while (currentPosition < readBytes) {
			// While we do not have two consecutive \n characters, add them to the 
			// string buffer, that is, the header.
			if (clientState.getReceivingState() == ReceivingState.COMPLETE ||
					clientState.getReceivingState() == ReceivingState.AWAITING_HEADER) {			
				// Switch to reading if we are going searching through this buffer
				ByteBuffer buffer = clientState.getIncomingByteBuffer();
				buffer.flip();
				StringBuffer stringBuffer = clientState.getIncomingHeaderStringBuffer();

				// Copy bytes from the buffer to the header StringBuffer, watching for a double
				//  newline which will indicate that we have all the header data.
				while (currentPosition < readBytes) {			
					char character = (char)buffer.get();
					currentPosition++;
					stringBuffer.append(character);
					
					// The header is up to the first occurrence of a \n\n. After this is the contents of the message
					// By parsing the header as we go, we can then create a ByteBuffer of the correct size to receive
					//  the remainder of the message, and stop processing when we receive that many bytes.
					if (stringBuffer.toString().contains("\n\n")) {
						
						// Parse the header so that we know what the contents length should be.
						clientState.getMessage().parseAndSetHeader(stringBuffer.toString());
						
						// Set our next state
						clientState.setReceivingState(ReceivingState.AWAITING_CONTENTS);
						
						// Allocate a buffer for the incoming message
						ByteBuffer newContentsBuffer = clientState.allocateContentsReceivingBuffer();
						
						// Copy the remaining data from the incoming buffer, to the contents buffer.
						if (currentPosition < readBytes) {
							while (newContentsBuffer.hasRemaining() && currentPosition < readBytes) {
								newContentsBuffer.put(buffer.get());
								currentPosition++;
							}
						} 
					}			
				}
			}
		 
			// Do some processing on the complete message
			if (clientState.getReceivingState() == ReceivingState.AWAITING_CONTENTS) {
				ReceivingMessage currentMessage = clientState.getMessage();				
				if (currentMessage.isContentsComplete()) {
					// By setting the receiving message to complete it will:
					// 	-Migrate the message to the pending messages queue
					//	-Create a new message internally so we are ready for the next one
					//	-Allocate new buffers
					clientState.setReceivingState(ConnectionState.ReceivingState.COMPLETE);					
				}
				
				// We have looked at the entire buffer, and done something as appropriate, so
				//  there is no more parsing to do.
				return;
			} else { 
				// still waiting on the header
				clientState.setReceivingState(ReceivingState.AWAITING_HEADER);
				
				// Flip the buffer to fill it up again
				clientState.allocateHeaderReceivingBuffer();				
			}			
		} // End of looping through the received buffer
	}
}
