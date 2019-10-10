#*******************************************************************************
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#******************************************************************************/

# This script creates a number of FileSystemProvider Implementation classes,
#  which can be used if they appear in an appropriate file
#  (META-INF/services/java.nio.file.spi.FileSystemProvider).
# This script is called by the root build.xml file, which also compiles and
#  clears up these classes so that they do not need to checked in to clutter up
#  the repository.

use FindBin qw($Bin);
use File::Spec::Functions;
use File::Path;

# Load in the entire file into the templateContents variable in one chunk
local $/=undef;
open TEMPLATE_FILE, "<".catfile($Bin,"MemoryFileSystemProviderImplTemplate") or die "$Bin";

my $templateContents = <TEMPLATE_FILE>;

$services_dir = catfile("$Bin", "..","..","META-INF","services");
mkpath($services_dir);
$services_file = catfile($services_dir,"java.nio.file.spi.FileSystemProvider");

close(TEMPLATE_FILE);

# Make 1000
my $numberOfProvidersToCreate = 1000;

# To create the file required for the JVM to know about the SPI Providers
open SERVICES, ">:encoding(ISO-8859-1)", $services_file or die "Unable to open services file - $services_file";

for (my $counter = 0; $counter < $numberOfProvidersToCreate; $counter++) {

	open OUTPUT_FILE, ">:encoding(ISO-8859-1)",catfile("$Bin", "..","..","filesystem","MemoryFileSystemProviderImpl${counter}.java");

	# Update the file contents with the right counter value	
	my $iterationContents = $templateContents;
	$iterationContents =~ s/Template/$counter/g;
	
	print OUTPUT_FILE $iterationContents;
	
	close(OUTPUT_FILE);
	
	# Add entry to the manifest services file
	print SERVICES "net.adoptopenjdk.test.nio2.filesystem.MemoryFileSystemProviderImpl${counter}\n";
	
}

close(SERVICES);

print "Updated services file: $services_file\n";

print "Done";
