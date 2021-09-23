### Generics

* *type invariance* - strict type
* *covariance* - permit a derived class of a parametric type
  * in java `<? extends T>`
  * in kotlin `Array<out SuperClass>` - allows *reading*
* *contravariance* - permit a super class of a parametric type
  * in java `<? super T>`
  * in kotlin `Array<in SuperClass>` - allows *writing*
* *star projection* - permit only reads
  * `Array<*>`

Kotlin allows both *use-site* variance and *declaration-site* variance.

#### Parametric Type Constraints - `where`

```kotlin
fun <T: AutoCloseable> useAndClose(input: T) = input.close() // T should confirm to one type

// T confirm to multiple types
fun <T> useAndClose(input: T) where T: AutoCloseable, T: Appendable {
  input.append("something")
  input.close()
}
```

### Inline Functions and Reified Types

🔗 [Inline functions﻿](https://kotlinlang.org/docs/inline-functions.html)
