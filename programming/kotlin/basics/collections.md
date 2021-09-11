### Collections

Kotlin offers view interfaces over the standard Java collections in the 🔗 [`kotlin.collections`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/) package

* `Pair` - an immutable tuple of two values
* `Triple` - an immutable tuple of three values
* `Array` - fixed size array - read/writeable
* `List` - readonly / immutable list. Use `MutableList` if a mutable version is required.
* `Set` and `MutableSet`
* `Map` and `MutableMap`

#### Pair

```kotlin
val pair1 = Pair("Alice", "Bob")
val pair2 = "Alice" to "Bob" // infix for "Alice".to("Bob")
```

#### Array

Construct using the 🔗 [`arrayOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/array-of.html) function.

```kotlin
val arr1 = arrayOf("Alice", "Bob", "Eve")
val arr2 = Array(3) { i -> i * 2 } // construct an array of size 3 with an initialization function
println(arr2.joinToString()) // 0, 2, 4
println(arr2::class) // class kotlin.Array
println(arr2.javaClass) // class [Ljava.lang.Integer;
```

For arrays of native types (non-boxed) use the specific functions like `intArrayOf()`
