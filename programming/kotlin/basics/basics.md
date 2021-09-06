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

Similar to raw strings with using 3 quotes. If no indentation is needed start the additional lines with `|` combined with [`String.trimMargin()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-margin.html)
