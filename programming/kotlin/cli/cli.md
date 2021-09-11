### [Kotlin CLI](https://kotlinlang.org/docs/command-line.html)

#### `kotlinc-jvm`

Compiler targeting the JVM

Compiling Hello.kt into a jar (will include manifest)

`kotlinc-jvm Hello.kt -d Hello.jar`

#### `kotlin`

Run a kotlin program.

Run a compiled jar on the JVM

`kotlin Hello.jar`

#### REPL - `kotlinc-jvm`

When the compiler is called without any arguments it opens the REPL.

In the REPL an external file can be loaded using `:load <filename>`
```kotlin
:load TestLoad.kt
main(arrayOf("elem1", "elem2")) // res1: kotlin.Int = 2
println("length of array is ${main(arrayOf("elem1", "elem2"))}")
```
([TestLoad.kt](./TestLoad.kt))
