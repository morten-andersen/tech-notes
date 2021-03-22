### Version 9 - 2017-09

* [Java 9 Documentation](https://docs.oracle.com/javase/9/)
* [Java 9 Javadoc](https://docs.oracle.com/javase/9/docs/api/index.html?overview-summary.html)

#### Usage from sdkman

* `sdk install java 9.0.4-open` - install
* `sdk use java 9.0.4-open` - use in current shell

#### Java Modules

* Java 9 Modularity book

#### `jlink` [[JEP 282](https://openjdk.java.net/jeps/282)]

Assembles and optimizes a set of modules and their dependencies into a custom runtime image

#### Ahead of time compilation - `jaotc` - [[JEP 295](https://openjdk.java.net/jeps/295)]

* based on the `graal` compiler

#### REPL - `jshell` [[JEP 222](https://openjdk.java.net/jeps/222)]

* [javaspecialists newsletter 250 - Learning Java with jshell](https://www.javaspecialists.eu/archive/Issue250.html)
* `jshell < echoserver.jsh` ([echoserver.jsh](./echoserver.jsh))- demo which starts an echo telnet server. After being started it can be tested by `telnet 8080` where it will echo any character back.

#### Concurrency updates - support for reactive streams [[JEP 266](https://openjdk.java.net/jeps/266)]

* https://www.reactive-streams.org/

#### `java.io` API changes

* `InputStream.transferTo(OutputStream)` - transfer everything directly from an `InputStream` to an `OutputStream`.

#### XML Catalog [[JEP 268](https://openjdk.java.net/jeps/268)]

* TODO

#### Compact strings [[JEP 254](https://openjdk.java.net/jeps/254)]

* TODO

#### Milling project coin [[JEP 213](https://openjdk.java.net/jeps/213)]

* Support for private methods in interfaces

#### Garbage Collectors

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 9 [pdf](./docs/hotspot-virtual-machine-garbage-collection-tuning-guide-v9.pdf) ([original link](https://docs.oracle.com/javase/9/gctuning/))

The G1 (Garbage-First Garbage Collector) set as default
