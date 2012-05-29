(ns {{name}}.views.common
  (:require [noir.cljs.core :as cljs])
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(defpartial include-navigation []
  [:div {:class "navbar navbar-fixed-top"}
    [:div {:class "navbar-inner"}
      [:a {:class "btn btn-navbar" :data-toggle "collapse" :data-target ".nav-collapse"}
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}]]
      [:a {:class "brand" :href "#"}
        "&nbsp;" (name :{{name}})]
      [:div {:class "nav-collapse"}
        [:ul {:class "nav"}
          [:li 
            [:a {:href "#" :id "one-link"} "One Clone Demo"]]
          [:li {:class "dropdown" :id "templates"}
            [:a {:class "dropdown-toggle" :data-toggle "dropdown" :href "#templates"}
              "Bootstrap Templates"
              [:b {:class "caret"}]]
            [:ul {:class "dropdown-menu"}
              [:li 
                [:a {:id "blank-link"} "Blank"]]
              [:li 
                [:a {:id "welcome-link"} "Welcome"]]
              [:li 
                [:a {:id "fluid-link"} "Fluid"]]]]]]]])

(defpartial layout [& content]
  (html5
    [:head
      [:meta {:charset "utf-8"}]
      [:title (name :{{name}})]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
      [:meta {:name "description" :content ""}]
      [:meta {:name "author" :content ""}]
      [:link {:rel "stylesheet/less" :type "text/css" :href "/less/bootstrap.less"}]
      [:link {:rel "stylesheet/less" :type "text/css" :href "/less/responsive.less"}]
      [:style "body {padding-top: 60px;}"]
      (include-js "/js/less-1.3.0.js")
      (include-css "/css/one.css")]
    [:body
     (include-navigation)
     [:div#content content]
     (include-js  "/js/jquery.js")
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
     (cljs/include-scripts)
     ]))


