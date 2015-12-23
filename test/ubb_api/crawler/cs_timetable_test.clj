(ns ubb-api.crawler.cs-timetable-test
  (:require [clojure.test :refer :all]
            [ubb-api.crawler.cs-timetable :as timetable]
            [clojure.java.io :refer [as-url]])
  (:import (java.io File)))


(deftest test-ie-timetable-crawl
  (testing "data-parsing"
    (let [ie2-page (File. "test/ubb_api/fixtures/ie2_timetable.html")
          ie2-schedule (timetable/schedule ie2-page)]
      (is (= (first ie2-schedule) {:week-day "Luni"
                                   :time "8-10"
                                   :frequency " "
                                   :location "2/I"
                                   :group "IE2"
                                   :type "Curs"
                                   :subject "Baze de date"
                                   :professor "Lect. SUCIU Dan Mircea"})))))
