(ns ubb-api.core-test
  (:require [clojure.test :refer :all]
            [ubb-api.core :refer :all]
            [ring.mock.request :refer :all]
            [clojure.data.json :refer [read-str]]))

(deftest test-app-endpoints
  (testing "[GET] /api/health"
    (let [application (app app-routes)
         response (application (request :get "/api/health"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8"))
      (is (= (-> response :body read-str) {"up" true})))))
