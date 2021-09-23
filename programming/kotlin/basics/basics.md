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

#### Nullable Types

* `?` - safe call operator - `maybeNull?.operation()` - returns null or the result of `operation()`
* `?:` - elvis operator - `maybeNull?.operation() ?: 'other value'` - returns the value on the right if left hand side is null
* `!!` - unsafe operation (**do not use**) - `maybeNull!!.operation()`

#### Types

🔗 [`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/) is the root of the class hierarchy. Defines `equals()`, `hashCode()`, `toString()`. The property `javaClass` returns the runtime Java class of an object.

`println(someObj.javaClass)`

**Type Check**

* `is` is used for type checking
* `!is` is used for "negation" of the type checking

```kotlin
class Test {
  override operator fun equals(other: Any?) = other is Test
}
```

**Explicit Cast**

In general this is not necessary if a type check with `is` is performed

* `as` - explicit cast
* `as?` - safe explicit cast

```kotlin
val msg1: String = fetchMessage() as String
val msg2: String? = fetchMessage() as? String
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
fun greet(name: String, msg: String = "Hello"): String = "$msg $name" // default arguments

// calling using named arguments
greet(name = "Alice", msg = "Hi")
```

**Varargs and spread operator**

```kotlin
fun greet(msg: String, vararg names: String): String = "$msg ${names.joinToString(",")}" // names will be an array

greet("Hi", "Alice", "Bob")

// calling with an array using the spread operator
greet("Hi", *arrayOf("Alice", "Bob"))

// if a list instead of an array, it must be converted before being spread
greet("Hi", *listOf("Alice", "Bob").toTypedArray())
```

#### External Iteration

The default imported package 🔗 [`kotlin.ranges`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/) gives us range classes. Both for the native types like `IntRange` and `CharRange` and for all `Comparable` types with `ClosedRange<T: Comparable<T>>`.

```kotlin
val oneToFive: IntRange = 1..5 // both 1 and 5 are included
val aToE: CharRange = 'a'..'e'
val stringRange: ClosedRange<String> = "helo".."helz"

// iteration
for (i in 1..5) println("$i")
for (i in 5 downTo 1) println("$i") // actually 5.downTo(1) written with infix notation (skipping parenthesis)
for (i in 0 until 5) println("$i") // excluding the end
```

**Iteration over Arrays and Lists**

```kotlin
val integerArray = arrayOf(1, 2, 3)
println(integerArray.javaClass) // class [Ljava.lang.Integer;
val nativeIntArray = intArrayOf(1, 2, 3)
println(nativeIntArray.javaClass) // class [I
val integerList = listOf(1, 2, 3)
println(integerList.javaClass) // class java.util.Arrays$ArrayList

for (i in integerArray) println("$i")
for (i in integerList) println("$i")
```

**Index based Iteration**

```kotlin
// index based
for (ix in integerArray.indices) println("elem at [$ix] is ${integerArray[ix]}")

// index and elem
for ((ix, elem) in integerArray.withIndex()) println("elem at [$ix] is $elem")
```

#### `when` instead of `switch`

The syntax for [`when`](https://kotlinlang.org/docs/control-flow.html#when-expression) is examplified in the below function

```kotlin
// simple function to show different match types in when
fun whatToDo(dayOfWeek: Any): String = when (dayOfWeek) {
  "Saturday", "Sunday" -> "Relax" // comma separated list
  in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard" // list check
  in 2..4 -> "Work hard" // range check
  "Friday" -> "Party" // simple match
  is String -> "What?" // type check
  else -> "No clue" // the default if no match
}
```

**local scope variable in `when`**

```kotlin
fun systemInfo(): String = when (val coreCount = Runtime.getRuntime().availableProcessors()) {
  1 -> "1 core"
  in 2..4 -> "desktop with $coreCount cores"
  else -> "server with $coreCount cores"
}
```

```kotlin
:load WhenTests.kt
println(whatToDo(2))
println(whatToDo(true))
println(whatToDo("unknown"))
println(whatToDo("Friday"))

println(systemInfo())
```
([WhenTests.kt](./WhenTests.kt))
