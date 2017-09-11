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

package net.adoptopenjdk.test.nio2.util;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.UnsupportedEncodingException;

public class MessageHeader {

	SortedMap<String, String> map;

	MessageHeader() {
		map = Collections.synchronizedSortedMap(new TreeMap<String, String>());
	}

	public void parse(String headerString) {
		// A well formed header has lines delimited by '\n'
		String[] parts = headerString.split("\n");
		synchronized (map) {
			map.clear();
			for (int index = 0; index < parts.length; index++) {
				// Key value are delimited by ':'
				String[] keyValue = parts[index].split(":", 2);
				if (keyValue.length != 2) {
					System.err.println("Malformed header line - '" + parts[index] + "'");
				}
				map.put(keyValue[0], keyValue[1]);
			}
		}
	}

	public String get(String key) {
		String value = map.get(key);
		return value;
	}

	public void set(String key, String value) {
		map.put(key, value);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		boolean needsTwoNewlines = true;

		for (String key: map.keySet()) {
			stringBuilder.append(key + ":" + map.get(key) + "\n");
			needsTwoNewlines = false;
		}

		if (needsTwoNewlines) {
			stringBuilder.append("\n\n");
		} else {
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

	public ByteBuffer getHeaderAsByteBuffer() {
		try {
			return ByteBuffer.wrap(toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return ByteBuffer.wrap(toString().getBytes());
		}
	}
}
