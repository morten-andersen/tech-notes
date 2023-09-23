
#### Print current settings

See [mkyong -> Find out your Java heap memory size](https://mkyong.com/java/find-out-your-java-heap-memory-size/)

```bash
java -XX:+PrintCommandLineFlags -version
```

```bash
java -XX:+PrintFlagsFinal -version | grep -iE 'HeapSize|PermSize|ThreadStackSize|Direct'
```

#### MetaSpace

[What is Metaspace?](https://stuefe.de/posts/metaspace/what-is-metaspace/)
