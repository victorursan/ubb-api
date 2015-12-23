(defproject ubb-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-mock "0.3.0"]
                 [compojure "1.4.0"]
                 [environ "1.0.1"]]

  :plugins [[lein-environ "1.0.1"]]

  :main ^:skip-aot ubb-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
