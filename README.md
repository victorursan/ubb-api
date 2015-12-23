# ubb-api

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar ubb-api-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

### Development

#### Testing
We are using [eftest](https://github.com/weavejester/eftest) test runner.

For running the test in the project repl:
```clojure
(require '[eftest.runner :refer [find-tests run-tests]])
(run-tests (find-tests "test"))
```
for a test
```clojure
(run-tests (find-tests "path/to/test/or/namespace"))
```
