# ubb-api

## API

```
GET /api/v1/csubb/:year
```

will return an array of objects, e.g.

```
GET /api/v1/csubb/ie2


[{"week-day":"Marti","time":"14-16","frequency":" ","location":"2/I","group":"IE2","type":"Curs","subject":"Ingineria sistemelor soft","professor":"Conf. CHIOREAN Dan"},
{"week-day":"Marti","time":"16-18","frequency":" ","location":"2/I","group":"IE2","type":"Curs","subject":"Inteligenta artificiala","professor":"Conf. OLTEAN Mihai"},
{"week-day":"Marti","time":"18-20","frequency":" ","location":"2/I","group":"IE2","type":"Curs","subject":"Sisteme de gestiune a bazelor de date","professor":"Lect. SUCIU Dan Mircea"},
{"week-day":"Miercuri","time":"8-10","frequency":" ","location":"5/I","group":"IE2","type":"Curs","subject":"Retele de calculatoare","professor":"Lect. DARABANT Sergiu"},
{"week-day":"Miercuri","time":"14-16","frequency":"sapt. 1","location":"L321","group":"921/2","type":"Laborator","subject":"Inteligenta artificiala","professor":"Drd. BOTA Florentin"},
{"week-day":"Miercuri","time":"14-16","frequency":"sapt. 2","location":"L321","group":"921/2","type":"Laborator","subject":"Ingineria sistemelor soft","professor":"Conf. CHIOREAN Dan"}]
```

## Development

#### Testing

We are using [eftest](https://github.com/weavejester/eftest) test runner.
For running the test in the project repl:

```
lein repl
```

```clojure
  (require '[eftest.runner :refer [find-tests run-tests]])
  (run-tests (find-tests "test"))
```

for one test

```clojure
 (run-tests (find-tests "path/to/test/or/namespace"))
```

#### Run the App

```
lein run
```
