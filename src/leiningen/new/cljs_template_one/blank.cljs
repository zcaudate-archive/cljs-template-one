(ns {{name}}.client.layouts.blank
  (:require [crate.core :as crate])
  (:use [jayq.core :only [$ append hide fade-in]])
  (:use-macros [crate.def-macros :only [defpartial]]))

(defpartial blank-content []
  [:div {:class "container" :id "blank-content"}
    [:h1 "Blank Starter Template"]
    [:p "Use this document as a way to quick start any new project."
        [:br]
        " All you get is this message and a barebones HTML document."]])

(defn display-content []
  (-> :#blank-content $ fade-in))

(defn hide-content []
  (-> :#blank-content $ hide))

(defn attach []
  (-> :#content $ (append (blank-content)))
  (hide-content))