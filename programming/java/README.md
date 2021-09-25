### What JVM (2020)

* 🔗 [*Which Java SDK Should You Use?*](https://developer.okta.com/blog/2019/01/16/which-java-sdk)
  * 🔗 [OpenJDK](https://openjdk.java.net/) - java.net in sdkman.
  * 🔗 [AdoptOpenJDK](https://adoptopenjdk.net/) - binaries build from openjdk.
    * 🔗 [OpenJDK Hotspot](https://openjdk.java.net/groups/hotspot/)
    * 🔗 [OpenJ9 VM](https://www.eclipse.org/openj9/) - eclipse VM for low memory usage and fast start-up time.
  * 🔗 [Amazon Corretto](https://aws.amazon.com/corretto/) - only LTS versions. The versions that are used on AWS.
  * 🔗 [Azul Zulu](https://www.azul.com/downloads/zulu/) - versions from version 6 and forward. Used on MS Azure.
  * 🔗 [BellSoft Liberica](https://bell-sw.com/java) - versions with JavaFX, normal and embedded.

* Java editions:
  * 🔗 [JavaFX](https://openjfx.io/) - versions with client UI libraries (`javafx.*` packages). Not included in the standard JDK from version 11.

* Specialized virtual machines
  * 🔗 [GraalVM](https://www.graalvm.org/)
  * 🔗 [TornadoVM](https://www.tornadovm.org/)

### Versions

* LTS version every 3 years.
* non-LTS version every 6 months. In March and September.

### Documentation

* 🔗 [Java SE Documentation](https://docs.oracle.com/en/java/javase/index.html)
* 🔗 [Java Language and Virtual Machine Specifications](https://docs.oracle.com/javase/specs/)

#### Version 8 (LTS) - 2014-03

[Java 8](./java8/)

* lambda expressions
* `java.stream`- stream API
* `java.time`- date & time API
* `java.util.Base64` encoder and decoder
* nashorn javascript runtime

#### Version 9 - 2017-09

[Java 9](./java9/)

* module system
* `jlink` for building custom runtime image
* `jshell` REPL

#### Version 10 - 2018-03

[Java 10](./java10/)

* `var` - local-variable type inference
* graalvm

#### Version 11 (LTS) - 2018-09

[Java 11](./java11/)

* HTTP client
* TLS 1.3
* `jfr` and `jmc` - for production profiling and monitoring
* new GC algorithms:
  * zgc
  * epsilon

#### Version 12 - 2019-03

[Java 12](./java12/)

* new GC algorithms:
  * shenandoah

#### Version 13 - 2019-09

[Java 13](./java13/)

#### Version 14 - 2020-03

[Java 14](./java14/)
