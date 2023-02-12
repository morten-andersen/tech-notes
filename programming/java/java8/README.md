### Version 8 (LTS) -2014-03

* 🔗 [Java 8 Documentation](https://docs.oracle.com/javase/8/docs/)
* 🔗 [Java 8 Javadoc](https://docs.oracle.com/javase/8/docs/api/index.html?overview-summary.html)

#### Usage from sdkman

* `sdk install java 8.0.302-open` - install
* `sdk use java 8.0.302-open` - use in current shell

#### Compact Profiles [[JEP 161](https://openjdk.java.net/jeps/161)]

* EJDK - Embedded JDK
  * 🔗 [Introducing the EJDK](https://blogs.oracle.com/jtc/introducing-the-ejdk)
  * 🔗 [Exploring jrecreate](https://www.baeldung.com/jrecreate)
  * `jrecreate` - can create different JVM profiles.
* `javac -profile <profile>` - compiles for a specific profile.

#### Lambda Expressions and the stream API [[JEP 126](https://openjdk.java.net/jeps/126)]

* [Lambda Details](./lambda/lambda)

#### Date & Time API - 🔗 [`java.time`](https://docs.oracle.com/javase/8/docs/api/index.html?java/time/package-summary.html) [[JEP 150](https://openjdk.java.net/jeps/150)]

Described in [*Java SE 8 for the really impatient*] chapter 5.

All objects are immutable.

A few notes on date and datetime used in programming is found in [Usage of Dates and Times in Networked Applications](../../../time/usage-of-dates.md)

* `Instant` - a point in time.
* `Duration` - a *time* based amount of time. The difference between two `Instant`'s. See [DurationTest](./time/DurationTest.java) for an example of measuring the duration of an operation.
* `Period` - a *date* based amount of time. Use this when working with calendar days.
* Types without time zone:
  * `LocalDate` - a date without a time. This stores a date like '2010-12-03' and could be used to store a birthday.
    ```java
    LocalDate today = LocalDate.now();
    LocalDate someday = LocalDate.of(1969, Month.JULY, 16);
    ```
  * `LocalTime` - a time without a date. This stores a time like '11:30' and could be used to store an opening or closing time.
  * `LocalDateTime` - stores a date and time. This stores a date-time like '2010-12-03T11:30'.
* `ZonedDateTime` - date time with time zones. Use this if you need to account for daylight changes.
* `java.time.temporal.TemporalAdjusters` - static methods for returning different adjusters of dates. E.g. `next(TUESDAY)` or `lastDayOfMonth`. See examples in [TemporalTest](./time/TemporalTest.java).
* `java.time.format.DateTimeFormatter` - static formatters for formatting date and time. E.g. `ISO_LOCAL_DATE`. Specific instances can be created by using `DateTimeFormatter.ofPattern("yyyy-MM-dd")`. All DateTime objects has a `format()` and a `parse()` method that takes a `DateTimeFormatter` as argument.
* `java.time.chrono`-package - calendar systems for other systems than the Gregorian calendar. Supported systems:
  * Hijrah calendar - the Islamic calendar
  * Japanese calendar
  * Minguo calendar - the calendar in Taiwan
  * Thai Buddhist calendar - the calendar in Thailand

  See [ChronologyTest](./time/ChronologyTest.java) for an example of the current date in these calendars.

#### `java.util.Base64` encoder and decoder

Base64 encoders and decoders for:
* basic format (RFC 2045)
* URL encoding (RFC 4648)
* MIME encoding (line break every 76'th character)

See examples in [Base64Test](./util/Base64Test.java).

#### JNI - Statically linked libraries [[JEP 178](https://openjdk.java.net/jeps/178)]

* TODO

#### Project Nashorn - javascript runtime [[JEP 174](https://openjdk.java.net/jeps/174)]

* replaces Rhino
* 🔗 [`javax.script`](https://docs.oracle.com/javase/8/docs/api/index.html?javax/script/package-summary.html)
* 🔗 [`jrunscript`](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/jrunscript.html) - command line script shell that supports multiple scripting languages
  * `jrunscript -q` - lists the supported script engines
  * supports both REPL mode and running of script files
* deprecated in java 11

#### Garbage Collectors

* removal of the Permanent Generation [[JEP 122](https://openjdk.java.net/jeps/122)]

HotSpot Virtual Machine Garbage Collection Tuning Guide, release 8 (🔗 [original link](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/index.html))
