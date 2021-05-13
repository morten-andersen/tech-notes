### Go notes

next step in *tour of go*: [Exercise: Fibonacci closure](https://tour.golang.org/moretypes/26)

#### Install on Ubuntu

`sudo snap install go`

editor: Atom - [go-plus](https://github.com/joefitzgerald/go-plus)

### Go Syntax

#### *[Documentation](https://golang.org/pkg/)*

Package [`builtin`](https://golang.org/pkg/builtin/) documents the builtin functions and identifiers

#### *[imports](https://tour.golang.org/basics/2)*

two formats:
```go
import "package1"
import "package2"
```
```go
// the "factored" import statement - use this
import (
  "package1"
  "package2"
)
```

#### *[exported names](https://tour.golang.org/basics/3)*

a name is exported if it begins with a capital letter

#### *[multiple results](https://tour.golang.org/basics/6)*

a function can return any number of results:
```go
func swap(x, y string) (string, string) {
	return y, x
}
```

#### *[named return values](https://tour.golang.org/basics/7)*

return values may be named. If so, they are treated as variables defined at the top of the function. These names should be used to document the meaning of the return values.
```go
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return // a naked return -> returns the named return values. Don't use unless in short functions.
}
```

#### *[variables](https://tour.golang.org/basics/8)*

declare variables with the `var` keyword. A var statement can be at package or function level:
```go
var isOk, isError bool
```

#### *[variables with initializers](https://tour.golang.org/basics/9)*

if an initializer is present the type can be omitted:
```go
var c, python, java = true, false, "no!"
```

#### *[short variable declarations :=](https://tour.golang.org/basics/10)*

inside a function, the `:=` short assignment statement can be used in place of a var declaration with implicit type.
```go
c := true
```

#### *[basic types](https://tour.golang.org/basics/11)*

* `bool`
* `string`
* `int  int8  int16  int32  int64`
* `uint uint8 uint16 uint32 uint64 uintptr`
* `byte` // alias for uint8
* `rune` // alias for int32 - represents a Unicode code point
* `float32 float64`
* `complex64 complex128`

example with "factored" format (similar to import) and exported names
```go
var (
	ToBe   bool       = false
	MaxInt uint64     = 1<<64 - 1
	z      complex128 = cmplx.Sqrt(-5 + 12i)
)
```

#### *[Zero values](https://tour.golang.org/basics/12)*

Variables declared without an explicit initial value are given their zero value.

The zero value is:
* 0 for numeric types,
* false for the boolean type,
* "" (the empty string) for strings.

#### *[Type conversions](https://tour.golang.org/basics/13)*

The expression `T(v)` converts the value v to the type T.
```go
var i int = 42
var f float64 = float64(i)
var u uint = uint(f)
```

#### *[Type inference](https://tour.golang.org/basics/14)*

Print the type of a variable:
```go
func main() {
	v := 42.0 // change me!
	fmt.Printf("v is of type %T\n", v)
}
```

#### *[Constants](https://tour.golang.org/basics/15)*

Declared with the `const` keyword.

#### *[Loop - for](https://tour.golang.org/flowcontrol/1)*

Without parenthesis. Note usage of `:=` (short assignment statement).
```go
for i := 0; i < 10; i++ {
	sum += i
}
```
#### *[Loop - for is while](https://tour.golang.org/flowcontrol/3)*

C's `while` is spelled `for` in Go. Basically a `for` loop without initializer and post statement.
```go
sum := 1
for sum < 1000 {
	sum += sum
}
```

#### *[Loop - forever](https://tour.golang.org/flowcontrol/4)*

Infinite loop.
```go
for {
  // do something
}
```

#### *[If - with a short statement](https://tour.golang.org/flowcontrol/6)*

The parentheses in `if` are optional.

Like `for`, the `if` statement can start with a short statement to execute before the condition. Variables declared by the statement are only in scope until the end of the `if` and any `else`.
```go
if v := math.Pow(x, n); v < lim {
	return v
}
```

#### *[Switch](https://tour.golang.org/flowcontrol/9)*

Go only runs the selected case, not all the cases that follow. In effect, the `break` statement that is needed at the end of each case in those languages is provided automatically in Go.

Switch cases evaluate cases from top to bottom, stopping when a case succeeds.

```go
switch i {
  case 0:
  case f():
}
```
does not call `f if i == 0`.

Another important difference is that Go's `switch` cases need not be constants, and the values involved need not be integers.

#### *[Switch with no condition](https://tour.golang.org/flowcontrol/11)*

Switch without a condition is the same as switch true. This construct can be a clean way to write long if-then-else chains.
```go
switch {
case t.Hour() < 12:
	fmt.Println("Good morning!")
case t.Hour() < 17:
	fmt.Println("Good afternoon.")
default:
	fmt.Println("Good evening.")
}
```

#### *[Defer](https://tour.golang.org/flowcontrol/12)*

A `defer` statement defers the execution of a function until the surrounding function returns. The deferred call's arguments are evaluated immediately, but the function call is not executed until the surrounding function returns.
```go
func main() {
	defer fmt.Println("world")
	fmt.Println("hello")
}
```
Deferred function calls are pushed onto a stack. When a function returns, its deferred calls are executed in *last-in-first-out* order.

`Defer` can be used for closing resources, e.g. filehandles.

See more [Defer, Panic and Recover](https://blog.golang.org/defer-panic-and-recover).

#### *[Pointers](https://tour.golang.org/moretypes/1)*

* The type `*T` is a pointer to a `T` value. Its zero value is nil.
  ```go
  var p *int
  ```
*  The `&` operator generates a pointer to its operand.
  ```go
  i := 42
  p = &i
  ```
*  The `*` operator denotes the pointer's underlying value ("dereferencing" or "indirecting").
  ```go
  fmt.Println(*p) // read i through the pointer p
  *p = 21         // set i through the pointer p
  ```

#### *[Structs](https://tour.golang.org/moretypes/2)*

```go
type Vertex struct {
	X int
	Y int
}

func main() {
	fmt.Println(Vertex{1, 2})
}
```
Struct fields are accessed using a dot.

#### *[Struct Pointers](https://tour.golang.org/moretypes/4)*

To access the field X of a struct when we have the struct pointer `p` we could write `(*p).X`. However, that notation is cumbersome, so the language permits us instead to write just `p.X`, without the explicit dereference.

#### *[Struct Literals](https://tour.golang.org/moretypes/5)*

A struct literal denotes a newly allocated struct value by listing the values of its fields. You can list just a subset of fields by using the `Name:` syntax. (And the order of named fields is irrelevant.)
```go
var (
	v1 = Vertex{1, 2}  // has type Vertex
	v2 = Vertex{X: 1}  // Y:0 is implicit
	v3 = Vertex{}      // X:0 and Y:0
	p  = &Vertex{1, 2} // has type *Vertex
)
```

#### *[Arrays](https://tour.golang.org/moretypes/6)*

The type `[n]T` is an array of `n` values of type `T`.

Declare a variable `a` as an array of ten integers.
```go
var a [10]int
primes := [6]int{2, 3, 5, 7, 11, 13}
```

#### *[Slices](https://tour.golang.org/moretypes/7)*

An array has a fixed size. A slice, on the other hand, is a dynamically-sized, flexible view into the elements of an array. In practice, slices are much more common than arrays.

The type `[]T` is a slice with elements of type `T`.

A slice is formed by specifying two indices, a low and high bound, separated by a colon: `a[low : high]`. This selects a half-open range which includes the first element, but excludes the last one.
```go
primes := [6]int{2, 3, 5, 7, 11, 13}
var s []int = primes[1:4] // -> 3, 5, 7
```
When slicing, you may omit the high or low bounds to use their defaults instead.The default is zero for the low bound and the length of the slice for the high bound.

Changing the elements of a slice modifies the corresponding elements of its underlying array. Other slices that share the same underlying array will see those changes.

#### *[Slice Literals](https://tour.golang.org/moretypes/9)*

A slice literal is like an array literal without the length. This is an array literal:
```go
[3]bool{true, true, false}
```
And this creates the same array as above, then builds a slice that references it:
```go
[]bool{true, true, false}
```

#### *[Slice Length and Capacity](https://tour.golang.org/moretypes/11)*

A slice has both a length and a capacity.
The length of a slice is the number of elements it contains.

The capacity of a slice is the number of elements in the underlying array, counting from the first element in the slice.

The length and capacity of a slice s can be obtained using the expressions `len(s)` and `cap(s)`.

You can extend a slice's length by re-slicing it, provided it has sufficient capacity.
```go
s := []int{2, 3, 5, 7, 11, 13}
// Slice the slice to give it zero length.
s = s[:0] // len = 0, cap = 6
// Extend its length.
s = s[:4] // len = 4, cap = 6
// Drop its first two values.
s = s[2:] // len = 2, cap = 4
```

#### *[Creating a slice with make](https://tour.golang.org/moretypes/13)*

Slices can be created with the built-in `make` function; this is how you create dynamically-sized arrays.

The `make` function allocates a zeroed array and returns a slice that refers to that array:
```go
a := make([]int, 5)  // len = 5, cap = 5
```
To specify a capacity, pass a third argument to make:
```go
b := make([]int, 0, 5) // len = 0, cap = 5
```

#### *[Appending to a slice](https://tour.golang.org/moretypes/15)*

`append` appends to a slice, allocating a new if necessary.
```go
s = append(s, 2, 3, 4)
```

#### *[Range - loop over a slice](https://tour.golang.org/moretypes/16)*

The `range` form of the `for` loop iterates over a `slice` or `map`.
Two values are returned for each iteration - the index, and a *copy* of the element.

```go
for i, v := range slice {
  fmt.Printf("2**%d = %d\n", i, v)
}
```

The index or value can be skipped by assigning to `_`

```go
for i, _ := range pow
for _, value := range pow
```

#### *[Map](https://tour.golang.org/moretypes/19)*

A map maps keys to values.

```go
m = make(map[string]Vertex)
m["Bell Labs"] = Vertex{
	40.68433, -74.39967,
}
```

Map literals:

```go
var m = map[string]Vertex{
	"Bell Labs": Vertex{
		40.68433, -74.39967,
	},
	"Google": Vertex{
		37.42202, -122.08408,
	},
}
```

or in short with the type name omitted:

```go
var m = map[string]Vertex{
	"Bell Labs": {40.68433, -74.39967},
	"Google":    {37.42202, -122.08408},
}
```

#### *[Mutating maps](https://tour.golang.org/moretypes/22)*

* insert/update:      `m[key] = elem`
* get:                `elem = m[key]`
* delete:             `delete(m, key)`
* test for presence:  `elem, ok := m[key]`
  If `key` is in `m`, `ok` is true. If not, `ok` is false.
  If `key` is not in the map, then `elem` is the zero value for the map's element type.

#### *[Function values](https://tour.golang.org/moretypes/24)*

Functions are values too. They can be passed around just like other values.

#### *[Function closures](https://tour.golang.org/moretypes/25)*

Go functions may be closures. A closure is a function value that references variables from outside its body. The function may access and assign to the referenced variables; in this sense the function is "bound" to the variables.

For example, the adder function returns a closure. Each closure is bound to its own sum variable.

```go
func adder() func(int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}

func main() {
	pos, neg := adder(), adder()
	for i := 0; i < 10; i++ {
		fmt.Println(
			pos(i),
			neg(-2*i),
		)
	}
}
```

### Hardware

[Go hardware](https://github.com/rakyll/go-hardware)

#### Cross compilation

set the relevant target os + arch: [Optional environment variables](https://golang.org/doc/install/source#environment)

e.g. Windows 64 bit:
```bash
export GOOS=windows
export GOARCH=amd64
go install github.com/user/hello
# output goes to $GOPATH/bin/windows_amd64

```
