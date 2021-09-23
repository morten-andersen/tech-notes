### Version 10 - 2018-03

* 🔗 [Java 10 Documentation](https://docs.oracle.com/javase/10/)
* 🔗 [Java 10 Javadoc](https://docs.oracle.com/javase/10/docs/api/index.html?overview-summary.html)

#### Usage from sdkman

* `sdk install java 10.0.2-open` - install
* `sdk use java 10.0.2-open` - use in current shell

#### Local-Variable Type Inference [🔗 [JEP 286](https://openjdk.java.net/jeps/286)]

* introduces `var`
* `var list = new ArrayList<String>()`

#### 🔗 [GraalVM](https://www.graalvm.org/) - polyglot VM and Java-Based JIT Compiler [🔗 [JEP 317](https://openjdk.java.net/jeps/317)]

GraalVM is a universal virtual machine for running applications written in JavaScript, Python, Ruby, R, JVM-based languages like Java, Scala, Groovy, Kotlin, Clojure, and LLVM-based languages such as C and C++.

Can be used for compiling java code to native code.

#### Application Class-Data Sharing [🔗 [JEP 310](https://openjdk.java.net/jeps/310)]

* To improve startup and footprint, extend the existing Class-Data Sharing ("CDS") feature to allow application classes to be placed in the shared archive.

#### Thread-local handshake [🔗 [JEP 312](https://openjdk.java.net/jeps/312)]

Introduces a way to execute callback on threads without performing a global VM safepoint. Make it both possible and cheap to stop individual threads and not just all threads or none.

Helps the VM achieve lower latency by reducing the number of global safepoints.

#### Garbage Collectors

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 10 [pdf](./docs/hotspot-virtual-machine-garbage-collection-tuning-guide-v10.pdf) (🔗 [original link](https://docs.oracle.com/javase/10/gctuning/))
