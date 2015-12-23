(defproject ubb-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/victorursan/ubb-api"
  :license {:name "The BSD 2-Clause License"
            :url "http://opensource.org/licenses/BSD-2-Clause"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-mock "0.3.0"]
                 [compojure "1.4.0"]
                 [environ "1.0.1"]
                 [eftest "0.1.0"]
                 [enlive "1.1.6"]]

  :plugins [[lein-environ "1.0.1"]]

  :main ^:skip-aot ubb-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
