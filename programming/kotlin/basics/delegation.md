### Delegation over Inheritance

Delegation is built into the language using the `by` keyword.

This seems a little bit similar to a Java dynamic proxy.

```kotlin
// an interface with two implementations
interface Itf {
  fun something(): String
  fun otherthing(): String
}

class SimpleImpl: Itf {
  override fun something() = "simple something"
  override fun otherthing() = "simple other thing"
}

class ComplexImpl: Itf {
  override fun something() = "complex something"
  override fun otherthing() = "complex other thing"
}

// Delegation - Caller is an instance of Itf
// which delegates to a target
class Caller(val target: Itf): Itf by target {
  fun printTarget() = println("${target}")

  // overridden version of otherthing - stops delegation call for this operation
  override fun otherthing() = "local impl in Caller (hides ${target.otherthing()})"
}

// delegation - caller -> SimpleImpl
var caller = Caller(SimpleImpl())
println(caller.something()) // delegation - "simple something"
println(caller.otherthing()) // "local impl in Caller (hides simple other thing)""
caller.printTarget() // SimpleImpl@705ea294

// delegation - caller -> ComplexImpl
caller = Caller(ComplexImpl())
println(caller.something()) // delegation - "complex something"
caller.printTarget() // ComplexImpl@ef11f12

// chaining - caller -> caller -> ComplexImpl
caller = Caller(caller)
println(caller.something()) // delegation - "complex something"
caller.printTarget() // Caller@6939ce9c
```

#### Built-in Standard Delegates

🔗 [Delegated properties﻿](https://kotlinlang.org/docs/delegated-properties.html)

##### [`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/) Properties

A property with lazy initialization. Should be created using the [`lazy()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/lazy.html#kotlin$lazy(kotlin.Function0((kotlin.lazy.T)))) function

```kotlin
// the expensive operation will not be called until the lazyInitialized variable is read/needed
// lazy takes a lambda function as argument
val lazyInitialized by lazy { expensiveOperation() }
```

By default `lazy()` synchronizes the execution of the lambda function

##### [observable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/observable.html)

A property delegate that calls a callback function every time the property is changed

```kotlin
import kotlin.properties.Delegates.observable

// the observable function takes a lambda function that takes 3 arguments
var count by observable(0) { property, oldValue, newValue ->
  println("Property: $property old: $oldValue: new: $newValue")
}

println("The value of count is: $count")
count++ // Property: var Line_359.count: kotlin.Int old: 0: new: 1

println("The value of count is: $count")
count-- // Property: var Line_359.count: kotlin.Int old: 1: new: 0

println("The value of count is: $count")
```

##### [vetoable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/vetoable.html)

Similar to `observable` (called on all changes), but the lambda function should return a boolean value to potentially reject changes to a property
