(ns chartkick.core-test
  (:require [clojure.test :refer :all]
            [chartkick.core :refer :all]))

(deftest test-generate-right-script-function
  (doseq [[script expected]
          [[(pie-chart []) "new Chartkick.PieChart("]
           [(column-chart []) "new Chartkick.ColumnChart("]
           [(bar-chart []) "new Chartkick.BarChart("]
           [(area-chart []) "new Chartkick.AreaChart("]
           [(combo-chart []) "new Chartkick.ComboChart("]
           [(geo-chart []) "new Chartkick.GeoChart("]
           [(scatter-chart []) "new Chartkick.ScatterChart("]
           [(timeline []) "new Chartkick.Timeline("]
           [(line-chart []) "new Chartkick.LineChart("]]]
    (is (.contains script expected))))

(deftest test-html
  (testing "it contains HTML-tag styling"
    (let [height "42px"
          script (chartkick-chart "" "{}" {:height height})
          expected "style=\"height: 42px; text-align: center; color: #999; line-height: 42px;"]
      (is (.contains script expected))))
  (testing "it set default height"
    (let [script (chartkick-chart "" {})
          expected "height: 300px"]
      (is (.contains script expected))))
  (testing "it set height"
    (let [height "400px"
          script (chartkick-chart "" {} {:height height})
          expected "height: 400px"]
      (is (.contains script expected))))
  (testing "it can render script only"
    (let [script (chartkick-chart "" {} {:only true})]
      (is (not (.contains script "<div>")))))
  (testing "it can custom id"
    (let [script (chartkick-chart "chart" {} {:id "the-chart-id"})
          expected "new Chartkick.chart('the-chart-id"]
      (is (.contains script expected))))
  (testing "it can set chart options"
    (let [script (chartkick-chart "chart" {} {:stacked true :min nil})
          expected "{\"stacked\":true,\"min\":null}"]
      (is (.contains script expected)))))
