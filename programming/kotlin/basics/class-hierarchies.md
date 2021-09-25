### Class Hierarchies

**Final Classes**

Classes are `final` by default.

**Open Classes**

Classes designed for inheritance have to marked with `open`

* *methods* that can be overridden also has to be marked `open`
* *properties* can be overridden - also using `open`

**Sealed Classes**

A `sealed` class is open for extension by other classes defined in the same file

#### Interfaces

Interfaces in Kotlin supports

* method signatures
* default methods
* static methods via `companion` objects

```kotlin
interface Itf {
  fun methodSignature()

  fun methodImplementation() {
    println("default method implementation")
    return methodSignature()
  }

  companion object {
    fun staticMethod(itf: Itf) = itf.methodSignature()
  }
}
```

Implementing an interface

```kotlin
class Impl: Itf {
  // explicit overrride
  override fun methodSignature() {
    println("method signature implementation")
  }
}

val instance = Impl()
instance.methodSignature()
instance.methodImplementation()
Itf.staticMethod(instance)
```

#### Abstract Classes

Can have state

```kotlin
abstract class AbstractType(var count: Int) {
  abstract fun abstractMethod()
}

class Impl(count: Int): AbstractType(count) {
  override fun abstractMethod() {
    println(count++)
  }
}
```

#### Nested and Inner Classes

* *nested* class - a class placed inside another class. Unable to access the private members in the outer class
* *innner* clas - a class placed inside another class, marked with `inner`. Can access private members in the outer class

```kotlin
class Outer(val count: Int) {
  val newInner: Inner
    get() = Inner()

  inner class Inner {
    // this is the Inner instance. this@Outer is the outer instance
    fun info() = "Inner $this - Outer ${this@Outer} - count ${this@Outer.count}"
  }
}

val o = Outer(42)
println(o)

val i = o.newInner
println(i)
println(i.info())
```
