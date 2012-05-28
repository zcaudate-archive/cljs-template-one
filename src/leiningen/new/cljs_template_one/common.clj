(ns {{name}}.views.common
  (:require [noir.cljs.core :as cljs])
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "{{name}}"]
               [:link {:rel "stylesheet/less" :type "text/css" :href "/less/bootstrap.less"}]
               (include-js "/js/less-1.3.0.js")
               ]
              [:body
               [:div#container
                content]
               (cljs/include-scripts :with-jquery)
               (include-js  "/js/bootstrap-transition.js")
               (include-js  "/js/bootstrap-alert.js")
               (include-js  "/js/bootstrap-modal.js")
               (include-js  "/js/bootstrap-dropdown.js")
               (include-js  "/js/bootstrap-scrollspy.js")
               (include-js  "/js/bootstrap-tab.js")
               (include-js  "/js/bootstrap-tooltip.js")
               (include-js  "/js/bootstrap-popover.js")
               (include-js  "/js/bootstrap-button.js")
               (include-js  "/js/bootstrap-collapse.js")
               (include-js  "/js/bootstrap-carousel.js")
               (include-js  "/js/bootstrap-typeahead.js")
               ]))
