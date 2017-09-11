#!/bin/sh
#-------------------------------------------------------------------------
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#-------------------------------------------------------------------------

# Clone stf
mkdir -p $HOME/git && cd $HOME/git && rm -rf stf && mkdir stf && git clone https://github.com/AdoptOpenJDK/stf.git stf
if [ "$?" != "0" ]; then
        echo "Error cloning stf" 1>&2
        exit 1
fi
# Clone openjdk-systemtest
mkdir -p $HOME/git && cd $HOME/git && rm -rf openjdk-systemtest && mkdir openjdk-systemtest && git clone https://github.com/AdoptOpenJDK/openjdk-systemtest.git openjdk-systemtest
if [ "$?" != "0" ]; then
        echo "Error cloning openjdk-systemtest" 1>&2
        exit 1
fi
# Configure (get prereqs)
cd $HOME/git/openjdk-systemtest/openjdk.build/ && make configure
if [ "$?" != "0" ]; then
        echo "Error configuring openjdk-systemtest - see build output" 1>&2
        exit 1
fi
# Build
cd $HOME/git/openjdk-systemtest/openjdk.build/ && make
if [ "$?" != "0" ]; then
        echo "Error building openjdk-systemtest - see build output" 1>&2
        exit 1
fi
echo "openjdk-systemtest repository build successful - to run the tests"
echo "make -f $HOME/git/openjdk-systemtest/openjdk.build/makefile test"
exit 0
