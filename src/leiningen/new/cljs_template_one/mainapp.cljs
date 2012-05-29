(ns {{name}}.client.mainapp
  (:require [noir.cljs.client.watcher :as watcher]
            [clojure.browser.repl :as repl]
            [waltz.state :as state]
            [{{name}}.client.appstate :as app]
            [{{name}}.client.layouts.blank :as blank]
            [{{name}}.client.layouts.welcome :as welcome]
            [{{name}}.client.layouts.fluid :as fluid]
            [{{name}}.client.oneapp :as oneapp])
  (:use [jayq.core :only [$ delegate]])
  (:use-macros [waltz.macros :only [in out defstate defevent]]))

;;************************************************
;; Dev stuff
;;************************************************

(watcher/init)
(repl/connect "http://localhost:9000/repl")
;;************************************************
;; State
;;************************************************
(defn top-state []
  (state/current app/top))

(defstate app/top :blank
  (in [] (blank/display-content))
  (out [] (blank/hide-content)))
  
(defstate app/top :welcome
  (in [] (welcome/display-content))
  (out [] (welcome/hide-content)))
  
(defstate app/top :fluid
  (in [] (fluid/display-content))
  (out [] (fluid/hide-content)))
  
(defstate app/top :one
  (in [] (oneapp/display-content))
  (out [] (oneapp/hide-content)))

(defevent app/top :to-blank []
  (state/unset app/top (top-state))
  (state/set app/top :blank))

(defevent app/top :to-welcome []
  (state/unset app/top (top-state))
  (state/set app/top :welcome))

(defevent app/top :to-fluid []
  (state/unset app/top (top-state))
  (state/set app/top :fluid))

(defevent app/top :to-one []
  (state/unset app/top (top-state))
  (state/set app/top :one))

;; State Initiation for all elements
(defn attach []
  ;;; Add all necessary elements
  (blank/attach)
  (welcome/attach)
  (fluid/attach)
  (oneapp/attach)
  
  ;;; Bindings to Menus
  (delegate ($ :#blank-link) [] :click
    #(state/trigger app/top :to-blank))

  (delegate ($ :#welcome-link) [] :click
    #(state/trigger app/top :to-welcome))

  (delegate ($ :#fluid-link) [] :click
    #(state/trigger app/top :to-fluid))

  (delegate ($ :#one-link) [] :click
    #(state/trigger app/top :to-one)))




;;************************************************
;; Program Start
;;************************************************

;; Call attach to start
(attach)

;;Setup first state
(state/trigger app/top :to-one)

