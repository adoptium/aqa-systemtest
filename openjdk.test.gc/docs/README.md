#Annotations Package

The ForceGC test has been designed to run alongside a workload. 
ForceGC forces the Garbage Collector to clear soft 
references when the heap memory is nearly exhausted. 

The main goal of forceGC is to stress the annotation caching 
implementation within the JVM. Java Annotations use soft references 
for the cache implementation and when the GC clears soft references
 the annotation cache will be cleared, so when the annotation tests
within the workload call the annotation API the cache will have
to be re-populated appropriately. The forceGC test allocates a soft 
reference which contains an array of objects totaling 200MB of heap
memory. The test then continuously allocates hard references on the 
heap until the GC detects that all memory is nearly exhausted and 
therefore clears the necessary soft references to increase the heap memory.
The forceGC test exits when the 200MB of soft references have been 
cleared by the GC. The test is then run again by the workload so that the 
memory is constantly being used up and freed.

Note:The max amount of heap memory should be set to around 400MB for this test. 

#DirectByteBuffer Package

The DirectMemoryTest class has been designed to run alongside a workload 
performing I/O operations and allocate direct memory ByteBuffers
and dereference them. The aim of this test was to reproduce a
problem experienced in the past which was causing out of native
memory when using direct byte buffers while testing ChannelFramework.
The memory used by the direct byte buffers can not be freed until the
objects representing the buffers are garbage collected. As very
little of the heap is used by the buffers GC was not being triggered
and so the native memory was not being freed.

#Heap Hog Package

This package contains 2 classes (ObjectTree and ObjectTree2) designed to run 
alongside a workload and fill up the memory over time based on some 
thread weighting so that the workload is forced to run in the remaining heap.
The aim was to reproduce a problem of the GC eventually crashing.
