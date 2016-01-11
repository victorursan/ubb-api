(ns ubb-api.handlers.v1.csubb
  (:require [ubb-api.models.schedule :as schedule]
            [ring.util.response :refer [response]]))

(defn schedule [year]
    (schedule/fetch year))