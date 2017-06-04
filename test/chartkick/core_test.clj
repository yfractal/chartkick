(ns chartkick.core-test
  (:require [clojure.test :refer :all]
            [chartkick.core :refer :all]))

(deftest test-generate-right-script-function
  (doseq [[script expected] [[(pie-chart {}) "new Chartkick.PieChart("]
                             [(column-chart {}) "new Chartkick.ColumnChart("]
                             [(bar-chart {}) "new Chartkick.BarChart("]
                             [(area-chart {}) "new Chartkick.AreaChart("]
                             [(combo-chart {}) "new Chartkick.ComboChart("]
                             [(geo-chart {}) "new Chartkick.GeoChart("]
                             [(scatter-chart {}) "new Chartkick.ScatterChart("]
                             [(timeline {}) "new Chartkick.Timeline("]
                             [(line-chart {}) "new Chartkick.LineChart("]]]
    (is (.contains script expected))))
