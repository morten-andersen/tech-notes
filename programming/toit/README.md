## Toit

* [Documentation](https://docs.toit.io/)
* [Toit Language](https://docs.toit.io/language/language/)
* [SDK Reference](https://libs.toit.io/)
* [Github Repositories](https://github.com/toitware)

### CLI

* `toit`
* `toit doctor` - health check of local system
  * `toit doctor fix` - install or update the SDK
  * `toit doctor -i` - show version information

The toit SDK installation is placed in `~/.cache/toit`

### [Toit Language](https://docs.toit.io/language/language/)

#### [Functions](https://docs.toit.io/language/language/#defining-a-function)

```
// simple function definition with 2 arguments, argumment 2 has a default value
some_fct argument1 argument2="default value":
  print "arguments: '$argument1' '$argument2'"

main:
  // showing calls to the 'some_fct' function
  some_fct "test 1"
  some_fct "test 1" "test 2"
```

#### [Classes](https://docs.toit.io/language/language/#evolving-into-a-greeter)

```toit
// simple *class* definition
class SimpleAdder:
  addend1_ := null // private by convention as ending in '_'
  addend2_ := null // private by convention as ending in '_'

  // the constructor assigning addend1 and addend2
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

#### [Named Arguments](https://docs.toit.io/language/language/#named-arguments)

```toit
// function with named argument
say_hi name --greeting="Hello ":
  // Greet everyone individually!
  print "$greeting $name"

main:
  // calling a function with a named argument
  say_hi "Peter"
  say_hi "Berit" --greeting="Hi"
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
toit simulator start --alias TestDevice # start a simulator device named 'TestDevice'
toit run -d TestDevice hello.toit # run the hello program once
toit deploy -d TestDevice hello.yaml # deploy the hello app to the device
toit device -d TestDevice ps # list apps on the device
toit device -d TestDevice logs -f 10m # attach to the logs from 10 minutes ago and tail
toit simulator stop TestDevice # stop the device
```

### [Pubsub Communication](https://docs.toit.io/apis/pubsub/)

Asynchronous message communication between apps.

**topic** is a named resource which is used when messages are published.

* *Device topic*: A topic that enables [intra-communication]((https://docs.toit.io/tutorials/pubsub/pubsubint/) on a device. These topics are prefixed with: `device:``
* *Cloud topic*: A topic that enables inter-communication between devices and external systems. These topics are prefixed with: `cloud:``

#### [Communication between Apps on a Device]
