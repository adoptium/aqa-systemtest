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

package net.adoptopenjdk.test.nio2.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.spi.FileTypeDetector;

import net.adoptopenjdk.test.nio2.util.TestCaseWithTempDirectory;

public class FileTypeDetectorTest extends TestCaseWithTempDirectory {
	public void testFileExtension() throws IOException{
		new FileTypeDetector() {
			@Override
			public String probeContentType(Path file) throws IOException {
				String type;				
				// Basic check on the type using the filename
				if (file.toString().lastIndexOf('.') != -1) {
					type = file.toString().substring( file.toString().lastIndexOf('.') );
				} else {
					type = null;
				}
				return type;				
			}			
		};		
	}
	
	public void testFileAttributes() throws IOException{
		new FileTypeDetector() {
			@Override
			public String probeContentType(Path file) throws IOException {
				String type = null;
				Files.readAttributes(file, BasicFileAttributes.class);
				return type;			
			}			
		};		
	}
}

