(ns {{name}}.client.appstate
  (:require [waltz.state :as state])
  (:use-macros [waltz.macros :only [in out defstate defevent]]))
  
(def top (state/machine "app"))

(def one (state/machine "app-one"))