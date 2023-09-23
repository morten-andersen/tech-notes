### Classes

#### Access Modifiers

* `public` - default
* `private`
* `protected` - access from subclasses
* `internal` - access from any code in the module (any code compiled together)

#### Constructors (primary and secondary)

```kotlin
// primary constructor - multiple init blocks is possible
class SomeClass(val year: Int) {
  init {
    if (year < 2000) throw Exception("year must be after year 2000")
  }
}

val a = SomeClass(2000) // ok
val b = SomeClass(1999) // throws exception

// secondary constructors
class SomeClass(val year: Int) {
  // secondary constructor must call primary with `this()`
  constructor(millennium: Int, century: Int, year: Int): this(1_000 * millennium + 100 * century + year) {
    println(this.year)
  }
}

val c = SomeClass(2, 0, 1) // calling secondary constructor
```

#### Inline Classes

🔗 [Inline Classes](https://kotlinlang.org/docs/inline-classes.html)

A special construct to make it simple to wrap single properties at compile time without incurring runtime overhead

```kotlin
// the annotation is required for JVM backends
@JvmInline
value class Password(private val s: String)
```

🔗 [Avoiding Stringly-typed in Kotlin](https://blog.frankel.ch/avoid-stringly-typed-kotlin/) - a blog post on

* type aliases (don't use)
* enums
* inline classes
* sealed classes

#### Class Members (`static`)

Static functions and properties is not allowed in Kotlin. Instead a so called `companion object` is used

```kotlin
class MachineOperator(val name: String) {
  // instance functions - modifying the class level property
  fun checkin() = checkedIn++
  fun checkout() = checkedIn--

  // class level - this is in effect a singleton instance
  companion object {
    var checkedIn = 0
    fun minimumBreak() = "15 minutes every 2 hours"
  }
}

// create instance and checkin
MachineOperator("Alice").checkin()

// operation on the class
println(MachineOperator.minimumBreak()) //15 minutes every 2 hours

// property of the class
println(MachineOperator.checkedIn) //1
```

The companion object can be referenced directly as

```kotlin
val ref = MachineOperator.Companion
```

Instead of the default `Companion` it can also be explicitly named when declared

```kotlin
companion object MachineOperatorFactory {
  var checkedIn = 0
  ..
}

// thereafter it should be referenced as
val ref = MachineOperator.MachineOperatorFactory
```

#### Factory Methods

```kotlin
// primary constructor marked as private
class MachineOperator private constructor(val name: String) {
  //...
  companion object {
    // class factory method
    fun create(name: String): MachineOperator {
      val instance = MachineOperator(name)
      instance.checkin()
      return instance
    }
  }
}

// creating an instance using the factory method
val operator = MachineOperator.create("Alice")
```

#### Data Classes

*Data classes* are intended to carry mostly data instead of behavior.

Kotlin will automatically create `equals()`, `hashCode()`, `toString()` and `copy()` for a data class.

```kotlin
data class DataClass(val name: String, val number: Int)

val a = DataClass("Alice", 1)

// generated toString()
println(a) // DataClass(name=Alice, number=1)

// copy constructor - possible to set named variables
val b = a.copy(name = "Bob")
```
