# Chartkick

![Chartkick example](https://user-images.githubusercontent.com/3775525/26999689-645cdad8-4dd2-11e7-9cfa-cc971633c454.png)

Create beautiful Javascript charts with one line of Clojure. No more fighting with charting libraries!

[See it in action](http://chartkick.com/).

Any feedback, suggestions, comments or PRs are welcome.

## Charts

```clojure
(require '[chartkick.core :as chartkick])

(def data [[175 60] [190 80] [180 75]])

```

Line chart

```clojure
(chartkick/line-chart data)
```

Pie chart

```clojure
(chartkick/pie-chart data)
```

Column chart

```clojure
(chartkick/column-chart data)
```

Bar chart

```clojure
(chartkick/bar-chart data)
```

Area chart

```clojure
(chartkick/area-chart data)
```

Scatter chart

```clojure
(chartkick/scatter-chart data)
```

Geo chart

```clojure
(chartkick/geo-chart [["United States" 44] ["Germany"] 23])
```

Timeline

```clojure
(chartkick/timeline [["Washington" "1789-04-29" "1797-03-03"]
                     ["Adams" "1797-03-03" "1801-03-03"]
                     ["Jefferson" "1801-03-03" "1809-03-03"]])
```

### Options

Id and height

```clojure
(chartkick/line-chart data {:id "the-chart-id" :height "500px"})
```

Min and max values

```clojure
(chartkick/line-chart data {:min 1000 :max 5000})

```

`min` defaults to 0 for charts with non-negative values. Use `nil` to let the charting library decide.

Colors

```clojure
(chartkick/line-chart data {:colors ["pink" "#999"]})
```

Stacked columns or bars

```clojure
(chartkick/column-chart data {:stacked true})
```

Discrete axis

```clojure
(chartkick/line-chart data {:discrete true})
```

Axis titles

```clojure
(chartkick/line-chart data {:xtitle "Time" :ytitle "Population"})
```

The current implementation does unfortunately not allow you to pass options directly to the charting library yet.. PRs are welcome!

See the documentation for [Google Charts](https://developers.google.com/chart/interactive/docs/gallery) and [Highcharts](http://api.highcharts.com/highcharts) for more info.

### Data

Pass data as a Map or Array

```clojure
(chartkick/pie-chart {:Football 10 :Basketball 5})
(chartkick/pie-chart [["Football" 10] ["Basketball" 5]])
```

For multiple series, use the format

```clojure
(chartkick/line-chart
  [{:name "Series A" :data [["Football" 10] ["Basketball" 5]] }
   {:name "Series B", :data [["Baseball" 2] ["Pingpong" 3]]}])
```

Times can be a time, a timestamp, or a string (strings are parsed)

```clojure
(chartkick/line-chart
  {1368174456 4,
   "2013-05-07 00:00:00 UTC" 7
   (new java.util.Date) 10})
```

## Installation

Add the following to your project :deps list:

```clojure
[chartkick "0.1.0"]
```

By default when you render a chart it will return both the HTML-element and JS that initializes the chart.
This will only work if you load Chartkick in the `<head>` tag.
You can chose to render the JS & HTML separately using the `only: :html` or `only: :script` option.
Note that if you use those options you need to pass `id` otherwise it wont work.

```clojure
(chartkick/line-chart [] {:id "my-line-chart" :only :html})
(chartkick/line-chart [] {:id "my-line-chart" :only :script})
```

For Google Charts, use:

```html
<script src="//www.google.com/jsapi"></script>
<script src="/path/to/chartkick.js"></script>
```

If you prefer Highcharts, download highcharts.js and use:

```html
<script src="/path/to/highcharts.js"></script>
<script src="/path/to/chartkick.js"></script>
```

### Localization

To specify a language for Google Charts, add:

```html
<script>
  Chartkick.configure({language: "de"});
</script>
```

after the JavaScript files and before your charts.


## JavaScript API

Access a chart with:

```javascript
var chart = Chartkick.charts["chart-id"];
```

Get the underlying chart object with:

```javascript
chart.getChartObject();
```

You can also use:

```javascript
chart.getElement();
chart.getData();
chart.getOptions();
```

## No Clojure? No Problem

Check out

* JS [chartkick.js](https://github.com/ankane/chartkick.js)
* Ruby [chartkick](https://github.com/ankane/chartkick)
* Python [chartkick.py](https://github.com/mher/chartkick.py)

## History

View the [changelog](https://github.com/yfractal/chartkick/blob/master/CHANGELOG.md)

Chartkick follows [Semantic Versioning](http://semver.org/)

## Contributing

Everyone is encouraged to help improve this project. Here are a few ways you can help:

- [Report bugs](https://github.com/yfractal/chartkick/issues)
- Fix bugs and [submit pull requests](https://github.com/yfractal/chartkick/pulls)
- Write, clarify, or fix documentation
- Suggest or add new features
