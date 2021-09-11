### Kotlin Language Basics

#### Readonly/Immutable Variables

* `var` - mutable
* `val` - immutable

#### Equality Checks

* `==` operation compares values (*structural equality*). Similar to the `equals()` method in Java (in Kotlin this handles `null`)
* `===` operation compares references (*referential equality*). Similar to the `==` operation in Java

#### Strings

Strings are written with `"`

**Templates**

In a template string use `$variable` and `${operation()}`

Escape using backslash `\$` and `\"`

**Raw Strings**

Strings where no escaping is done - are written with 3 quotes `"""`

**Multiline Strings**

Similar to raw strings with using 3 quotes. If no indentation is needed start the additional lines with `|` combined with 🔗 [`String.trimMargin()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-margin.html)

```kotlin
val withoutMargin1 = """ABC
                        |123
                        |456""".trimMargin()
println(withoutMargin1) // ABC\n123\n456
```

#### Functions

```kotlin
fun sum(a: Int, b: Int) = a + b // one line function

fun noReturn(arg: String) = println(arg) // returns `Unit`
```

Arguments to functions are `val` by design. The can not be reassigned within the function.

For one line functions the function return type does not need to be specified.

**Default and named arguments**

```kotlin
fun greet(name: String, msg: String = "Hello"): String = "$msg $name"​ // default arguments

// calling using named arguments
greet(name = "Alice", msg = "Hi")
```

**Varargs and spread operator**

```kotlin
fun greet(msg: String, vararg names: String): String = "$msg ${names.joinToString(",")}"​ // names will be an array

greet("Hi", "Alice", "Bob")

// calling with an array using the spread operator
greet("Hi", *arrayOf("Alice", "Bob"))

// if a list instead of an array, it must be converted before being spread
greet("Hi", *listOf("Alice", "Bob").toTypedArray())
```
