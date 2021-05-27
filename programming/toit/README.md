## Toit

* [Documentation](https://docs.toit.io/)
* [Toit Language](https://docs.toit.io/language/language/)
* [SDK Reference](https://libs.toit.io/)
  * The [`core`](https://libs.toit.io/core/library-summary) module is automatically imported into every file. It contains common classes, like `int`, `string` and `List`
* [The Toit Console](https://console.toit.io/)
* [Github Repositories](https://github.com/toitware)

### CLI

* `toit`
* `toit doctor` - health check of local system
  * `toit doctor fix` - install or update the SDK
  * `toit doctor -i` - show version information
* `toit exec <file>` - execute the program without a device

The toit SDK installation is placed in `~/.cache/toit`

### [Toit Language](https://docs.toit.io/language/language/)

* [**Language comparison**](https://docs.toit.io/language/toitversus/) for Toit vs. Java, etc.

#### [Toit Terms](https://docs.toit.io/language/definitions/#terms)

**Variables**

* **locals** - a variable declared within a function or passed to a function
* **globals** - a variable declared outside the scope of a class or function
* **constants** - special case of globals defined by a `::=` assignment. By convention constants should have an ALL_CAPS_NAME

**Classes**

* **Constructor**
* **Named Constructor**
* **Factory** - a named constructor with a return
* **Static functions and fields** - marked with the keyword `static`
* **Methods and instance fields**

**Basic Types**

* [**Numbers**](https://docs.toit.io/language/math/)
* [**String**](https://docs.toit.io/language/strings/)
* [**Boolean**](https://docs.toit.io/language/booleans/)
* [**Common conversions**](https://docs.toit.io/language/typeconversion/) list conversions from numbers to strings, etc.

#### [Toit Types](https://docs.toit.io/language/definitions/#type)

Types are optional.
A variable is typed if followed by a `/type-name`.
By default types are non-nullable, which means null is not a valid value.

```python
class Coordinate:
  // An instance field that must be initialized by
  // constructors.
  // By writing `:= ?` we indicate that all constructors
  // must initialize the field.
  x /int := ?
  y /int := ?

  // We don't need to specify the type for constructor
  // arguments that are written directly to a typed field.
  constructor .x .y:

main:
  a := Coordinate 0 0

  // Error! The types of the fields (and therefore the
  // constructor arguments) are non-nullable, so null is not
  // a valid argument here:
  b := Coordinate null null  // Error!
```

Nullable types are defined using a `?` after the type name.

```python
class Foo:
  bar /Bar? := null
```

##### `any`/`none` - Two special types exists:

* [`any`](https://docs.toit.io/language/definitions/#any) - any value is accepted
* `none` - no value is accepted

##### [Return types](https://docs.toit.io/language/definitions/#return-types)

The return type is defined with `-> type`

```python
// A function that doesn't return anything.
foo -> none:
  print "not returning anything"

// A function that takes an int and returns an int.
bar x/int -> int:
  return x + 1
```

#### [Operator Precendence](https://docs.toit.io/language/syntax/#precedence)

See definition of operators on the classes for [int](https://libs.toit.io/core/numbers/class-int), [float](https://libs.toit.io/core/numbers/class-float) and [num](https://libs.toit.io/core/numbers/class-num)

#### [Functions](https://docs.toit.io/language/language/#defining-a-function)

```python
// simple function definition with 2 arguments, argumment 2 has a default value
some_fct argument1 argument2="default value":
  print "arguments: '$argument1' '$argument2'"

main:
  // showing calls to the 'some_fct' function
  some_fct "test 1"
  some_fct "test 1" "test 2"
```

#### [Classes](https://docs.toit.io/language/language/#evolving-into-a-greeter)

```python
// simple *class* definition
class SimpleAdder:
  addend1_ := null // private by convention as ending in '_'
  addend2_ := null // private by convention as ending in '_'

  // the constructor assigning addend1 and addend2, defaults to 0
  constructor .addend1_=0 .addend2_=0:

  sum:
    return addend1_ + addend2_

main:
  // creating an instance and calling 'sum'
  simple_adder := SimpleAdder 13 17
  print "the first sum is $simple_adder.sum"

  // creating an instance where addend2 is default value (0)
  simple_adder_noop := SimpleAdder 13
  print "the second sum is $simple_adder_noop.sum"
```

Toit also supports [`interfaces` and `abstract classes`](https://docs.toit.io/language/objects-constructors-inheritance-interfaces/)

The [Advanced Constructor Topics](https://docs.toit.io/language/objects-constructors-inheritance-interfaces/#advanced-constructor-topics) details how an object is constructed and how the sequence is split into an *initialization* and an *instance* part.

#### [Named Arguments](https://docs.toit.io/language/language/#named-arguments)

```python
// function with named argument
say_hi name --greeting="Hello ":
  // Greet everyone individually!
  print "$greeting $name"

main:
  // calling a function with a named argument
  say_hi "Peter"
  say_hi "Berit" --greeting="Hi"
```

#### [Loops](https://docs.toit.io/language/language/#loops) and [if..else](https://docs.toit.io/language/language/#if-statements-and-basic-expressions)

```python
// loop using number.`repeat`
print_n_numbers n:
  // using repeat on number
  n.repeat: print it // `it` is an *automatic* variable that gives the iteration count

  // traditional for loop
  for i := 0; i < n; i++: print i

  // traditional while
  i := 0
  while i < n: print i++


// define a list and loop over it, using the `do` method available on all collections
print_list:
  list := [ "Horse", "Fish", "Radish", "Baboon" ]
  list.do: print it // `it` is an *automatic* variable that gives the element
  print (list.join ",")


// if..else
print_even_or_odd n:
  if n % 2 == 0: print "$n is even"
  else: print "$n is odd"
```

#### [Maps and Sets](https://docs.toit.io/language/language/#maps-and-sets)

```python
list_of_something := []   // empty list
map_of_x_to_y     := {:}  // empty map
set_of_something  := {}   // empty set
```

Iterating a map iterates the key value pairs - see [block arguments](https://docs.toit.io/language/blocks/#block-arguments)

```python
main:
  map ::= {
    1234: "Siri",
    2345: "John",
    3456: "Sue"
    }
  map.do: | id name |
    print "$name has ID $id"
```

#### [Blocks](https://docs.toit.io/language/language/#blocks)

`do` and `repeat` looks like they are built in to the language like `if` and `for`, but they are normal methods on the `List` and `Integer` classes

```python
class List:
  // ...
  do [block]:
    size.repeat: block.call this[it]

class Integer:
  // ...
  repeat [block]:
    for i := 0; i < this; i++:
      block.call i
```

As blocks are *stack*-allocated there are some [restrictions on blocks](https://docs.toit.io/language/blocks/#restrictions).

#### Concurrency - [tasks](https://docs.toit.io/language/tasks/)

Toit uses *Cooperative scheduling* where all *tasks* / *fibers* runs on the same heap and only switch task on *yield points*.

A task is started with `task::` syntax (double `:`)

```python
import gpio

// The red LED is connected to pin 17.
LED1 ::= gpio.Pin.out 17
// The green LED is connected to pin 18.
LED2 ::= gpio.Pin.out 18

main:
  // Note the double `::` on the next two lines.
  // Start a task that runs the my_task_1 function.
  task:: my_task_1
  // Start a second task that runs my_task_2.
  task:: my_task_2

my_task_1:
  while true:
    sleep --ms=500
    LED1.set 1
    sleep --ms=500
    LED1.set 0

my_task_2:
  while true:
    sleep --ms=123
    LED2.set 1
    sleep --ms=123
    LED2.set 0
```

**Synchronization Methods**

[Synchronization](https://docs.toit.io/language/tasks/#synchronizing-between-tasks-with-monitors) between tasks is possible using the [`monitor` library](https://libs.toit.io/monitor/library-summary)

* **latch**
* **channel**
* **semaphore**
* **mutex**
* **mailbox**

#### [Exception Handling](https://docs.toit.io/language/exceptions/)

* `try .. finally`
* `catch` - implemented as a function that takes the possibly throwing code as a block.

```python
my_function:
  my_exception := catch --trace:
    code_that_might_throw 42 103
  if my_exception:
    code_to_run_when_an_exception_was_thrown "foo" "bar"
```

### Hardware - ESP32

#### [GPIO](https://docs.toit.io/firmware/gpio/) (General Purpose I/O)

GPIO pins are *globally* acquired

```
import gpio

main:
  pin := gpio.Pin 21  // Acquired system-wide.
  // ...
  pin.close           // Released, can be used by other applications now.
```

Two different modes:
* [input](https://docs.toit.io/firmware/gpio/#input-mode)
* [output](https://docs.toit.io/firmware/gpio/#output-mode)

### Running apps on the Device

[Two modes](https://docs.toit.io/deploy/runordeploy/)
* run - run once
* deploy - deploy with a `.yaml` app specification file

### Simulator Device

```bash
toit simulator start --alias TestDevice  # start a simulator device named 'TestDevice'

toit run -d TestDevice hello.toit        # run the hello program once
toit deploy -d TestDevice hello.yaml     # deploy the hello app to the device

toit device -d TestDevice ps             # list apps on the device
toit device -d TestDevice logs -f 10m    # attach to the logs from 10 minutes ago and tail
toit simulator stop TestDevice           # stop the device
```

### [Pubsub Communication](https://docs.toit.io/apis/pubsub/)

Asynchronous message communication between apps.

**topic** is a named resource which is used when messages are published.

* *Device topic*: A topic that enables [intra-communication](https://docs.toit.io/tutorials/pubsub/pubsubint/) on a device. These topics are prefixed with: `device:`
* *Cloud topic*: A topic that enables [inter-communication](https://docs.toit.io/tutorials/pubsub/pubsubext/) between devices and external systems. These topics are prefixed with: `cloud:`
