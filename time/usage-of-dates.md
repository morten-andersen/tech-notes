### Usage of Dates and Times in Networked Applications

#### Standards

* [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)

#### Terms and Expressions

##### Date

* **date** a specific date without time part
* ISO-8601 format: `YYYY-MM-DD`
* example: `2020-03-01` (March 1., 2020)

##### Time

* **time** a time without a specific date. E.g. `19:00:00`
  * ISO-8601 format: `hh:mm:ss[.sss]` (24 hour clock)
* **zone** a time zone for a specific time. E.g. `+01:00` (Central European Standard Time), where `+/-` is the offset from [UTC](https://en.wikipedia.org/wiki/UTC).
  * ISO-8601 format: `<time>+hh:mm`
  * ISO-8601 format for an UTC time: `<time>Z`

##### Datetime

* **datetime** a time on a specific date. E.g. `2020-03-01T19:00:00+01:00`

#### Scenario / Problem

**Scenario: Often networked applications have requirements such as:**

* select a *date* in a given date range. Examples:
  * when to start a contract: First date *tomorrow*
  * when to receive a delivery: First date *tomorrow*, last date *one week from now*
* register the *datetime* for a transaction

#### Instant

A precise *instant* in time. E.g. the launch of Apollo 11.

#### Local Date

A date without zone information. E.g. this does not correspond to a specific *instant* in time.

E.g. your birthday. This contains no zone information even though at the *instant* when you were born, the date was not the same all over the globe (unlesss born at the exact time UTC 12:00:00).

E.g. if born in Denmark on February 7., 2020 at 21:00:00 (2020-02-07T21:00:00+01:00) the time in Australia is February 8., 2020 06:00:00 (2020-02-08T06:00:00+10:00). But nonetheless your birthday is February 7.
