(ns chartkick.core
  (:require [clojure.data.json :as json]))

(defn- chartkick-tag
  [id, height]
  (format "<div id=\"%s\" style=\"height: %s; text-align: center; color: #999; line-height: %s; font-size: 14px; font-family: 'Lucida Grande', 'Lucida Sans Unicode', Verdana, Arial, Helvetica, sans-serif;\">Loading...</div>"
          id height height))

(defn- chartkick-script
  [class id data-source options-json]
  (format "<script type=\"text/javascript\">new Chartkick.%s('%s', %s, %s);</script>"
          class, id, data-source, options-json))

(defn- generate-element-id
  []
  (str (java.util.UUID/randomUUID)))

(defn chartkick-chart
  ([class data-source]
     (chartkick-chart class data-source {}))
  ([class data-source options]
     (let [id (or (:id options) (generate-element-id))
           height (or (:height options) "300px")
           only (:only options)]
       (str (if-not (= only :script)
              (chartkick-tag id, height))
            (if-not (= only :html)
              (chartkick-script class, id, (json/write-str data-source), (json/write-str options)))))))

(defn pie-chart
  [data-source & options]
  (apply chartkick-chart "PieChart" data-source options))

(defn column-chart
  [data-source & options]
  (apply chartkick-chart "ColumnChart" data-source options))

(defn bar-chart
  [data-source & options]
  (apply chartkick-chart "BarChart" data-source options))

(defn area-chart
  [data-source & options]
  (apply chartkick-chart "AreaChart" data-source options))

(defn combo-chart
  [data-source & options]
  (apply chartkick-chart "ComboChart" data-source options))

(defn geo-chart
  [data-source & options]
  (apply chartkick-chart "GeoChart" data-source options))

(defn scatter-chart
  [data-source & options]
  (apply chartkick-chart "ScatterChart" data-source options))

(defn timeline
  [data-source & options]
  (apply chartkick-chart "Timeline" data-source options))

(defn line-chart
  [data-source & options]
  (apply chartkick-chart "LineChart" data-source options))
