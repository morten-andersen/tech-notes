### Asynchronous Coding

https://javascript.info/async

#### Callbacks

##### [*error-first*](https://javascript.info/callbacks#handling-errors) callback style

```javascript
// callback where err will be null if successful
callback(err, result);

// used like
loadScript('/my/script.js', function(error, result) {
  if (error) {
    // handle error
  } else {
    // script loaded successfully - result has a value
  }
});
```

##### *Callback hell* or [*pyramid of doom*](https://javascript.info/callbacks#pyramid-of-doom)

The style with callbacks in callbacks, leads to deeply nested structures.

It can be *unwrapped* by making each level into its own function.

#### Promises

* [javascript.info -> Promise](https://javascript.info/promise-basics)
* [MDN -> JS -> Promise](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise)
* [Promise - States & Fates](https://github.com/domenic/promises-unwrapping/blob/master/docs/states-and-fates.md)

```javascript
let promise = new Promise(function(resolve, reject) {
  // executor (the producing code)
  // if it succeeds it should call
  resolve(data);
  // if it fails it should call
  reject(new Error(..));
});
```

The `promise` object returned by the `new Promise` constructor has these internal properties:

* `state` — initially `pending`, then changes to either `fulfilled` when `resolve` is called or `rejected` when `reject` is called.
* `result` — initially `undefined`, then changes to `value` when `resolve(value)` is called or `error` when `reject(error)` is called.

A `promise` that is either `fulfilled` or `rejected` is called `settled`, as opposed to an initially `pending` promise.

##### The `state` and `result` are internal

The properties `state` and `result` of the `Promise` object are internal. They can not be accessed, but the `promise` methods `.then` / `.catch` / `.finally` are used for that.

##### [`Promise.all(iterable)`, etc.](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise#Static_methods)

* `Promise.all(iterable)`
* `Promise.allSettled(iterable)`
* `Promise.race(iterable)`
* `Promise.reject(reason)`
* `Promise.resolve(value)`
