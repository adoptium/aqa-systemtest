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

package net.adoptopenjdk.test.nio2.filesystem;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

public abstract class AMemoryFileSystemProvider extends FileSystemProvider {

	private MemoryFileSystem memoryFileSystem = null;
	private Object memoryFileSystemLock = new Object();
	
	public AMemoryFileSystemProvider() {
	}
	
	@Override
	public FileSystem getFileSystem(URI uri) {
		return getSingletonFileSystem();
	}

	@Override
	public Path getPath(URI uri) {
		return null;
	}
	
	

	@Override
	public FileSystem newFileSystem(URI uri, Map<String, ?> env)
			throws IOException {
		return getSingletonFileSystem();
	}
	
	
	
	private FileSystem getSingletonFileSystem() {
		
		if (memoryFileSystem != null) {
			return memoryFileSystem;
		} else {
			
			// Lock here to avoid needless locking
			synchronized (memoryFileSystemLock) {
				
				if (memoryFileSystem != null) {
					return memoryFileSystem;
				}
				
				memoryFileSystem = new MemoryFileSystem();
				return memoryFileSystem;
			
			}
			
		}
		
	}

	@Override
	public void checkAccess(Path path, AccessMode... modes) throws IOException {
	}

	@Override
	public void copy(Path source, Path target, CopyOption... options)
			throws IOException {
	}

	@Override
	public void createDirectory(Path dir, FileAttribute<?>... attrs)
			throws IOException {
	}

	@Override
	public void delete(Path path) throws IOException {
	}

	@Override
	public <V extends FileAttributeView> V getFileAttributeView(Path path,
			Class<V> type, LinkOption... options) {
		return null;
	}

	@Override
	public FileStore getFileStore(Path path) throws IOException {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public boolean isHidden(Path path) throws IOException {
		return false;
	}

	@Override
	public boolean isSameFile(Path path, Path path2) throws IOException {
		return false;
	}

	@Override
	public void move(Path source, Path target, CopyOption... options)
			throws IOException {
	}

	@Override
	public SeekableByteChannel newByteChannel(Path path,
			Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IOException {
		return null;
	}

	@Override
	public DirectoryStream<Path> newDirectoryStream(Path dir,
			Filter<? super Path> filter) throws IOException {
		return null;
	}

	@Override
	public <A extends BasicFileAttributes> A readAttributes(Path path,
			Class<A> type, LinkOption... options) throws IOException {
		return null;
	}

	@Override
	public Map<String, Object> readAttributes(Path path, String attributes,
			LinkOption... options) throws IOException {
		return null;
	}

	@Override
	public void setAttribute(Path path, String attribute, Object value,
			LinkOption... options) throws IOException {
	}
	
}
