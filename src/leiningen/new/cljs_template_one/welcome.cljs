(ns {{name}}.client.layouts.welcome
  (:require [crate.core :as crate])
  (:use [jayq.core :only [$ hide append fade-in]])
  (:use-macros [crate.def-macros :only [defpartial]]))

(defpartial welcome-content []
  [:div {:class "container" :id "welcome-content"}
    [:div {:class "hero-unit"}
      [:h1 "Hello, world!"]
      [:p "This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique."]
      [:p 
        [:a {:class "btn btn-primary btn-large"} "Learn more »"]]]

    ;; <!-- Example row of columns -->
    (apply vector :div {:class "row"}
     (repeat 3
      [:div {:class "span4"}
        [:h2 "Heading"]
        [:p "Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui."]
        [:p 
          [:a {:class "btn" :href "#"} "View details »"]]]))
      [:hr]
    [:footer
      [:p "© Company 2012"]]])

(defn display-content []
  (-> :#welcome-content $ fade-in))

(defn hide-content []
  (-> :#welcome-content $ hide))

(defn attach []
  (-> :#content $ (append (welcome-content)))
  (hide-content))