/*
*******************************************************************************
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
*******************************************************************************
*/

#include "adoptopenjdk_test_modularity_jlink_JniTest.h"

/*
 * Class:     JniTest
 * Method:    pass
 * Signature: (Z)Z
 * Descrip:   Returns the same value that was input.
 */
JNIEXPORT jboolean JNICALL Java_adoptopenjdk_test_modularity_jlink_JniTest_pass
  (JNIEnv * e, jclass c, jboolean b)
{
	int i;
	i = b;
	return i;
}

/*
 * Class:     JniTest
 * Method:    turn
 * Signature: (Z)Z
 * Descrip:   Returns the oposite value to the input.
 */
JNIEXPORT jboolean JNICALL Java_adoptopenjdk_test_modularity_jlink_JniTest_turn
  (JNIEnv * e, jclass c, jboolean b)
{
	int i;
	i = b;
	i = !i;
	return i;
}
