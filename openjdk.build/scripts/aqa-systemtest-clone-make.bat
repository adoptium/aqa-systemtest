REM Licensed under the Apache License, Version 2.0 (the "License");
REM you may not use this file except in compliance with the License.
REM You may obtain a copy of the License at
REM
REM      https://www.apache.org/licenses/LICENSE-2.0
REM
REM Unless required by applicable law or agreed to in writing, software
REM distributed under the License is distributed on an "AS IS" BASIS,
REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
REM See the License for the specific language governing permissions and
REM limitations under the License.

REM Save current directory
set currdir=%cd%
REM Clone stf
(IF NOT EXIST %USERPROFILE%\git mkdir %USERPROFILE%\git) && cd %USERPROFILE%\git && (IF EXIST stf rmdir /s /q stf) && git clone https://github.com/adoptium/stf.git stf
REM Clone aqa-systemtest
(IF NOT EXIST %USERPROFILE%\git mkdir %USERPROFILE%\git) && cd %USERPROFILE%\git && (IF EXIST aqa-systemtest rmdir /s /q aqa-systemtest) && git clone https://github.com/adoptium/aqa-systemtest.git aqa-systemtest
REM Configure (get prereqs)
cd %USERPROFILE%\git\aqa-systemtest\openjdk.build
make configure
IF ERRORLEVEL 1 cd %currdir% && exit /B 1
REM Build
cd %USERPROFILE%\git\aqa-systemtest\openjdk.build
make
IF ERRORLEVEL 1 cd %currdir% && exit /B 1
@echo aqa-systemtest repository build successful - to run the tests
@echo cd %USERPROFILE%\git\aqa-systemtest\openjdk.build && make test
REM Restore current directory
cd %currdir%
exit /B 0
