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

package net.adoptopenjdk.test.nio2.filesystem;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;

import java.nio.file.LinkOption;  // Now needed in toRealPath

public class MemoryPath implements Path {
	
	String path = null;
	
	MemoryPath() {
	}
	
	MemoryPath(String path) {
		this.path = path;
	}
	
	@Override
	public int compareTo(Path other) {
		return 0;
	}

	@Override
	public boolean endsWith(Path other) {
		return false;
	}

	@Override
	public boolean equals(Object other) {
		return false;
	}

	@Override
	public FileSystem getFileSystem() {
		return null;
	}


	@Override
	public Path getName(int index) {
		return null;
	}

	@Override
	public int getNameCount() {
		return 0;
	}

	@Override
	public Path getParent() {
		return null;
	}

	@Override
	public Path getRoot() {
		return null;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean isAbsolute() {
		return false;
	}

	@Override
	public Iterator<Path> iterator() {
		return null;
	}

	@Override
	public Path normalize() {
		return null;
	}

	@Override
	public WatchKey register(WatchService watcher, Kind<?>... events)
			throws IOException {
		return null;
	}

	@Override
	public WatchKey register(WatchService watcher, Kind<?>[] events,
			Modifier... modifiers) throws IOException {
		return null;
	}

	@Override
	public Path relativize(Path other) {
		return null;
	}

	@Override
	public Path resolve(Path other) {
		return null;
	}

	@Override
	public Path resolve(String other) {
		return null;
	}

	@Override
	public boolean startsWith(Path other) {
		return false;
	}

	@Override
	public Path subpath(int beginIndex, int endIndex) {
		return null;
	}

	@Override
	public Path toAbsolutePath() {
		return null;
	}

	@Override
	public Path toRealPath(LinkOption...  options) throws IOException {
		return null;
	}

	@Override
	public String toString() {
		return "/memory/" + path;
	}

	@Override
	public URI toUri() {
		return null;
	}

	@Override
	public boolean endsWith(String other) {
		return false;
	}

	@Override
	public Path getFileName() {
		return null;
	}

	@Override
	public Path resolveSibling(Path other) {
		return null;
	}

	@Override
	public Path resolveSibling(String other) {
		return null;
	}

	@Override
	public boolean startsWith(String other) {
		return false;
	}

	@Override
	public File toFile() {
		return null;
	}

}
