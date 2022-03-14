### Version 14 - 2020-03

* 🔗 [Java 14 Documentation](https://docs.oracle.com/javase/14/)
* 🔗 [Java 14 Javadoc](https://docs.oracle.com/en/java/javase/14/docs/api/index.html)

#### Garbage Collectors

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 14 [pdf](./docs/hotspot-virtual-machine-garbage-collection-tuning-guide-v14.pdf) (🔗 [original link](https://docs.oracle.com/en/java/javase/14/gctuning/))

**Changes to GC algorithms:**

* *ZGC* available on Windows and Mac.
* *Concurrent Mark and Sweep (CMS) Garbage Collector* has been removed 🔗 [JEP 363](https://openjdk.java.net/jeps/363).
* *ParallelScavenge + SerialOld garbage collector combination* has been deprecated. That is the `UseParallelOldGC` command line option 🔗 [JEP 366](https://openjdk.java.net/jeps/366)
