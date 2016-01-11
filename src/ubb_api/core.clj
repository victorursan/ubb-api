(ns ubb-api.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ubb-api.handlers.v1.csubb :as v1.csubb]
            [environ.core :refer [env]]
            [compojure.core :refer [defroutes wrap-routes GET ANY]]
            [cemerick.drawbridge :refer [ring-handler]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.nested-params :refer [wrap-nested-params]]))

(def drawbridge-handler
  (-> (ring-handler)
      (wrap-keyword-params)
      (wrap-nested-params)
      (wrap-params)
      (wrap-session)))

(defroutes app-routes
  (GET "/api/health" [] (response {"up" true}))
  (GET "/api/v1/csubb/:year" [year] (v1.csubb/schedule year))
  (let [nrepl-handler (ring-handler)]
    (ANY "/repl" request (drawbridge-handler request)
                         (nrepl-handler request))))

(defn app
  [routes]
  (-> routes
      wrap-keyword-params
      wrap-params
      json/wrap-json-params
      json/wrap-json-response))

(defn -main
  "Starting Jetty"
  [& args]
  (let [port        (Integer. (or (env :port) 8000))
        max-threads (Integer. (or (env :max-threads) 100))
        min-threads (Integer. (or (env :min-threads) 50))
        middleware-stack (app app-routes)
        config      {:port port :join? false :max-threads max-threads :min-threads min-threads}]
    (jetty/run-jetty middleware-stack config)))
