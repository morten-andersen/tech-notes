#### Lambda Expressions and the stream API [[JEP 126](https://openjdk.java.net/jeps/126)]

##### Lambda Expressions

```java
// lambda expression
iterable.forEach((final String name) -> System.out.println(name));

// with infered types
iterable.forEach((name) -> System.out.println(name));

// single-parameter expressions do not need the parenthesis
iterable.forEach(name -> System.out.println(name));

// method reference
iterable.forEach(System.out::println);
```
