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

#### List

Construct using the 🔗 [`listOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html) function for an immutable list. Use 🔗 [`mutableListOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html) for a mutable list.

```kotlin
val strList = listOf("Alice", "Bob", "Eve") // type List<String>
println(strList::class) // class java.util.Arrays$ArrayList
println(strList.javaClass) // class java.util.Arrays$ArrayList
```

As seen the [`kotlin.collections.List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/) is a *compile-time view* around the immutable `java.util.Arrays#ArrayList`

Since it is immutable the []`plus/+`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/plus.html) and [`minus/-`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/minus.html) operations should be used to return a copy of the list.

```kotlin
val list = listOf("Alice", "Bob")
val copy1 = list + "Eve" // list is immutable, returns a new copy [Alice, Bob, Eve]
val copy2 = copy1 - "Bob" // [Alice, Eve]
```

#### Set

Construct using the 🔗 [`setOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/set-of.html) function for an immutable set. Use 🔗 [`mutableSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-set-of.html) for a mutable set.

If a specific `Set` type is needed use one of the following

* 🔗 [`hashSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/hash-set-of.html) to get a [`kotling.collections.HashSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-set/) (view around `java.util.HashSet`)
* 🔗 [`linkedSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/linked-set-of.html) to get a [`kotling.collections.LinkedHashSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-linked-hash-set/) (view around `java.util.LinkedHashSet`)
* 🔗 [`sortedSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sorted-set-of.html) to get a `java.util.TreeSet`)

#### Map

Construct using the 🔗 [`mapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-of.html) function for an immutable map. Use 🔗 [`mutableMapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-map-of.html) for a mutable map.

If a specific `Map` type is needed use one of the following

* 🔗 [`hashMapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/hash-map-of.html) to get a [`kotling.collections.HashMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/) (view around `java.util.HashMap`)
* 🔗 [`linkedMapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/linked-map-of.html) to get a [`kotling.collections.LinkedHashMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-linked-hash-map/) (view around `java.util.LinkedHashMap`)
* 🔗 [`sortedMapOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sorted-map-of.html) to get a `java.util.SortedMap`)

```kotlin
val map = mapOf("Alice" to "Bob", "Eve" to "Boris") // varargs of Pairs
println(map.containsKey("Alice")) // true
println(map.contains("Alice")) // true
println("Alice" in map) // true
println(map.containsValue("Bob")) // true

// alicesPartner should be a nullable type - `String?`
val alicesPartner: String = map.get("Alice") // error: type mismatch: inferred type is String? but String was expected
val alicesPartner = map["Alice"] // type is `String?`
```

Operations to get a copy of an immutable map with elements added/removed

```kotlin
val copy1 = map + ("Doris" to "Hans") // {Alice=Bob, Eve=Boris, Doris=Hans}
val copy2 = copy1 - "Eve" // {Alice=Bob, Doris=Hans}
```

**Iteration**

```kotlin
for (entry in map) {
  println("${entry.key} = ${entry.value}")
}

// with destructuring of the data entry type
for ((key, value) in map) {
  println("$key = $value")
}
```
