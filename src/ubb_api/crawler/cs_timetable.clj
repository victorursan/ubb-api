(ns ubb-api.crawler.cs-timetable
  (:require [net.cgrand.enlive-html :as html]
            [clojure.java.io :refer [as-url]]
            [ring.adapter.jetty :as jetty]))

(def row-size 8)

(defn to-schedule-entry
  [data-row]
  (let [[week-day time frequency location group type subject professor] data-row]
    {:week-day  week-day
     :time      time
     :frequency frequency
     :location  location
     :group     group
     :type      type
     :subject   subject
     :professor professor}))

(defn build-schedule-structure
  [table-cells]
  (let [all-rows (partition row-size table-cells)
        rows (distinct all-rows)]
    (map to-schedule-entry rows)))

(defn schedule
  [url]
  (let [html-page (html/html-resource (as-url url))
        table-cells (html/select html-page [:td html/text-node])]
    (build-schedule-structure table-cells)))
