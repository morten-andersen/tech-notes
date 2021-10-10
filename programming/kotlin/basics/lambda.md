### Functional Style in Kotlin

In general a function has 4 parts

* name
* return type
* parameter list
* body

A lambda function only contains the last two.

general syntax for a lambda function in Kotlin

```kotlin
{ parameter -> body }
```

#### General Syntax

The [range.none](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/none.html)

```kotlin
// signature - one argument - a lambda function
none(predicate: (Int) -> Boolean): Boolean

// call to check if any equal numbers is in a range
2..10.none({ i: Int -> i % 2 == 0})

// the parameter type can be dropped
2..10.none({ i -> i % 2 == 0})

// the parenthesis can be dropped as well when the function only takes the lambda function as argument
2..10.none { i -> i % 2 == 0}

// for lambdas that only has one parameter it is explicitly named 'it'
2..10.none { it % 2 == 0}
```

#### Function References

When passing through parameters function references can be used

```kotlin
({ x -> someMethod(x) })
// can be written with a function reference
(::someMethod)

// if the pass-through is to another lambda, :: is not needed
1..5.forEach { action(it) }
// can be simplified
1..5.forEach { action }
```

#### Internal Iterators

Standard functional operations defined on [`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/)

* `filter` - picks specific items from the collection
* `map` - map all items to another type of items
* `reduce` - takes two arguments `accumulated` and `item` - the general cumulative function - special functions also exists
  * `sum`
  * `average`
  * `joinToString`
* `first` - picks the first element that matches
* `last` - picks the last element that matches
* `flatten` - flatten a list of lists, into one combined list
* `flatMap` - `map` and `flatten`
* `sortedBy` and `sortedByDescending` - return the sorted collection
* `groupBy` - group into multiple collections

#### Sequences

The [`Sequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/) is a *lazy evaluated* iterator. This should be preferred when doing iteration on large collections.

A normal array and `Iterable` can easily be wrapped in a `Sequence` by using [`asSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/as-sequence.html)
