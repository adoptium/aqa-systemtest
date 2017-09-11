Summary: The java.debugging project contains two main test sets:

## Hot Code Replace (HCR) - Late Attach
This test set runs number of tests randomly, repeatedly, and concurrently to put the 
VM and JIT under load for five minutes. We then late-attach a java agent which performs
HCR on the String class for the duration of the workload.

The full HCR test readme can be found [here](./docs/HCR_README.md).

## Java Debugging Interface (JDI)

JDI is an api which allows connection via a debugger to low level debugging tools, such as 
breakpoints and field watching. The debugger creates a connection to the target VM allowing 
user-created trace and debugging to be set and trigger user code.

This test set is broken down into multiple sub-tests, each of which can be run separately
or together (serially). Each sub-test tests a different aspect of the JDI.

The full JDI test readme can be found [here](./docs/JDI_README.md)

