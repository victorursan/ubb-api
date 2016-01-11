(ns ubb-api.models.schedule
  (:require [ubb-api.crawler.cs-timetable :as crawl]))

(defn- construct-url
  [year]
  (let [year (clojure.string/upper-case year)]
    (str "http://www.cs.ubbcluj.ro/files/orar/2014-2/tabelar/" year ".html")))

(defn fetch [year]
  (let [year-url (construct-url year)]
    (crawl/schedule year-url)))