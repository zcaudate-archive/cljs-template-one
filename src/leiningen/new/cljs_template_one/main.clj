(ns {{name}}.views.main
  (:require [{{name}}.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.fetch.remotes :only [defremote]]
        [hiccup.core :only [html]]
        [{{name}}.models.user :only [names]]))


(defpage "/" []
         (common/layout))

(defremote meet [n]
  (println n)
  (if (@names n) nil
    (swap! names conj n)))

(defremote forget [n]
  (swap! names disj n)
  (println names))