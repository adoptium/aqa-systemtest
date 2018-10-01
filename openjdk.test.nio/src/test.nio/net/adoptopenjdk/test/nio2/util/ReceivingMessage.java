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

public class ReceivingMessage extends Message {

	public ReceivingMessage() {
		super();
	}
	
	public ReceivingMessage(Message message) {
		super(message);
	}
	
	public synchronized ByteBuffer getContentsBuffer() {
		if (contents == null) {
			allocateContentsBuffer();
		}
		return contents;
	}
	
	public synchronized ByteBuffer allocateContentsBuffer() {
		contents = ByteBuffer.allocate(getContentsLength());
		return contents;
	}
	
	public synchronized void parseAndSetHeader(String headerString) {
		header.parse(headerString);
	}
	
	// The contents should fill the entire ByteBuffer allocated, so just check there is space remaining
	public boolean isContentsComplete() {
		return !getContentsBuffer().hasRemaining();
	}	
	
}
