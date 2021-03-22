### Version 11 (LTS) - 2018-09

* [Java 11 Documentation](https://docs.oracle.com/javase/11/)
* [Java 11 Javadoc](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)

#### Usage from sdkman

* `sdk install java 11.0.6.hs-adpt` - install
* `sdk use java 11.0.6.hs-adpt` - use in current shell

#### HTTP client [[JEP 321](https://openjdk.java.net/jeps/321)]

* HTTP Client
  * asynchronous and synchronous mode. HTTP 2.

#### TLS 1.3 [[JEP 332](https://openjdk.java.net/jeps/332)]

* TLS 1.3 full support

#### Removal of deprecated methods

```java
java.lang.Runtime.runFinalizersOnExit(boolean)
java.lang.System.runFinalizersOnExit(boolean)
java.lang.Thread.destroy()
java.lang.Thread.stop(java.lang.Throwable)
```

#### EE and Corba modules removed [[JEP 320](http://openjdk.java.net/jeps/320)]

**Removed packages**

* `java.xml.ws` - JAX-WS
* `java.xml.bind` - JAXB
* `java.corba` - Corba

#### Java Flight recorder (`jfr`) [[JEP 328](https://openjdk.java.net/jeps/328)] and Java Mission Control (`jmc`)

[Java Flight Recorder](https://wiki.openjdk.java.net/display/jmc/Overview) is a production time profiling and diagnostics engine built into the JVM.

[Java Mission Control]((https://wiki.openjdk.java.net/display/jmc/Main)) is, among other things, the client tool used to look at recordings produced by the Java Flight Recorder.

* [DZone -> Using Java Flight Recorder With OpenJDK 11](https://dzone.com/articles/using-java-flight-recorder-with-openjdk-11-2)

#### Garbage Collectors

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 11 [pdf](./docs/hotspot-virtual-machine-garbage-collection-tuning-guide-v11.pdf) ([original link](https://docs.oracle.com/en/java/javase/11/gctuning/))

[Java Magazine -> Understanding Garbage Collectors](https://blogs.oracle.com/javamagazine/understanding-garbage-collectors)

##### Z Garbage Collector (ZGC) [[JEP 333](http://openjdk.java.net/jeps/333)]

[The Z Garbage Collector](https://wiki.openjdk.java.net/display/zgc) - experimental in java 11.

Low latency garbage collector striving for pause times < 10 ms.

Explained at [Java Magazine -> Understanding the JDK’s New Superfast Garbage Collectors](https://blogs.oracle.com/javamagazine/understanding-the-jdks-new-superfast-garbage-collectors)

Enable with `-XX:+UnlockExperimentalVMOptions -XX:+UseZGC`

##### Epsilon no-op Garbage Collector [[JEP 318](https://openjdk.java.net/jeps/318)]

Explained at [Java Magazine -> Epsilon: The JDK’s Do-Nothing Garbage Collector](https://blogs.oracle.com/javamagazine/epsilon-the-jdks-do-nothing-garbage-collector)

Enable with `-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC`
