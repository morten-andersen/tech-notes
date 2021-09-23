### Version 12 - 2019-03

* 🔗 [Java 12 Documentation](https://docs.oracle.com/javase/12/)
* 🔗 [Java 12 Javadoc](https://docs.oracle.com/en/java/javase/12/docs/api/index.html)

#### Usage from sdkman

* `sdk install java 12.0.2.hs-adpt` - install
* `sdk use java 12.0.2.hs-adpt` - use in current shell

#### Garbage Collectors

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 12 [pdf](./docs/hotspot-virtual-machine-garbage-collection-tuning-guide-v12.pdf) (🔗 [original link](https://docs.oracle.com/en/java/javase/12/gctuning/))

##### Shenandoah [[JEP 189](https://openjdk.java.net/jeps/189)]

🔗 [Shenandoah Garbage Collector](https://wiki.openjdk.java.net/display/shenandoah) - experimental in java 12.

Work from Red Hat, described in the paper [Shenandoah - An open-source concurrent compacting garbage collector for OpenJDK](./docs/PPPJ2016.pdf) (🔗 [original link](https://www.researchgate.net/publication/306112816_Shenandoah_An_open-source_concurrent_compacting_garbage_collector_for_OpenJDK))

Collector that does concurrent compacting by adding a forwarding pointer to each object. When an object is moved by GC, the forwarding pointer is updated.

Explained at 🔗 [Java Magazine -> Understanding the JDK’s New Superfast Garbage Collectors](https://blogs.oracle.com/javamagazine/understanding-the-jdks-new-superfast-garbage-collectors)

> Shenandoah can relocate objects concurrently with the application. To achieve the concurrent relocation, it uses what’s known as a Brooks pointer. This pointer is an additional field that each object in the Shenandoah heap has and which points back to the object itself.

> Shenandoah does this because when it moves an object, it also needs to fix up all the objects in the heap that have references to that object. When Shenandoah moves an object to a new location, it leaves the old Brooks pointer in place, forwarding references to the new location of the object. When an object is referenced, the application follows the forwarding pointer to the new location.

Enable with `-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC`
