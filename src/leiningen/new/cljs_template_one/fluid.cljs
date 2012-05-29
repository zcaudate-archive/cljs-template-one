(ns {{name}}.client.layouts.fluid
  (:require [crate.core :as crate])
  (:use [jayq.core :only [$ hide append fade-in]])
  (:use-macros [crate.def-macros :only [defpartial]]))

(defpartial fluid-top-menu []
  [:div {:class "btn-group pull-right" :id "fluid-top-menu"}
    [:a {:class "btn dropdown-toggle" :data-toggle "dropdown" :href "#"}
      [:i {:class "icon-user"} "Username"
        [:span {:class "caret"}]]]
    [:ul {:class "dropdown-menu"}
      [:li
        [:a {:href "#"} "Profile"]]
      [:li {:class "divider"}]
      [:li
        [:a {:href "#"} "Sign Out"]]]])

(defpartial fluid-side-menu []
  [:div {:class "well sidebar-nav" :id "fluid-side-menu"}
    [:ul {:class "nav nav-list"}
      [:li {:class "nav-header"} "Sidebar Menu 1"]
      [:li {:class "active"}
        [:a {:href "#"} "Link 1"]]
      [:li
        [:a {:href "#"} "Link 2"]]
      [:li
        [:a {:href "#"} "Link 3"]]
      [:li
        [:a {:href "#"} "Link 4"]]
      [:li
        [:a {:href "#"} "Link 5"]]
      [:li {:class "nav-header"} "Sidebar"]
      [:li
        [:a {:href "#"} "Link 6"]]
      [:li
        [:a {:href "#"} "Link 7"]]
      [:li
        [:a {:href "#"} "Link 8"]]
      [:li
        [:a {:href "#"} "Link 9"]]]])


(defpartial fluid-content []
  [:div {:class "container-fluid" :id "fluid-content"}
    [:div {:class "row-fluid"}
      [:div {:class "span3"}
        (fluid-side-menu)]
      (apply vector :div {:class "span9"}
        [:div {:class "hero-unit"}
          [:h1 "Hello, world!"]
          [:p "This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique."]
          [:p 
            [:a {:class "btn btn-primary btn-large"} "Learn more »"]]]
        (repeat 2
          (apply vector :div {:class "row-fluid"}
          (repeat 3
           [:div {:class "span4"}
             [:h2 "Heading"]
             [:p "Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui."]
             [:p 
               [:a {:class "btn" :href "#"} "View details »"]]]))))]
    [:hr]
    [:footer
      [:p "© Company 2012"]]])

(defn display-content []
  (-> :#fluid-content $ fade-in)
  (-> :#fluid-top-menu $ fade-in))

(defn hide-content []
  (-> :#fluid-content $ hide)
  (-> :#fluid-top-menu $ hide))

(defn attach []
  (-> :#content $ (append (fluid-content)))
  (-> :#nav-content $ (append (fluid-top-menu)))
  (hide-content))