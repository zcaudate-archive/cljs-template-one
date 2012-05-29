(ns {{name}}.client.oneapp
  (:require [crate.core :as crate]
            [waltz.state :as state]
            [{{name}}.client.appstate :as app]
            [{{name}}.client.layouts.one :as one])
  (:use [jayq.core :only [$ delegate]])
  (:use-macros [waltz.macros :only [in out defstate defevent]]))

;; Top Level Transitions
(defstate app/one :one-form
  (in [& params] 
    (if (some #(= :reset %) params)
      (one/clear-input))
    (one/display-form))
  (out [] (one/hide-form)))
  
(defstate app/one :one-greet
  (in [] (one/display-greeting))
  (out [] (one/hide-greeting)))

;; Textfield States
;;(defstate app/one :form-blank)
;;(defstate app/one :form-text)


;; Error States
(defstate app/one :error
  (in [msg] (one/set-error-message msg))
  (out [] (one/set-error-message "")))

(defevent app/one :form-submit []
  (cond (-> (one/is-input-long-enough?) not)
          (state/set app/one :error "Your name is not long enough")
        (-> (one/is-input-valid?) not)
          (state/set app/one :error "Your name should only contain letters of the alphabet")
      :else
        (do
          (one/meet-name)
          (state/unset app/one [:one-form :error])
          (state/set app/one :one-greet))))
          
(defevent app/one :form-esc []
  (state/unset app/one [:one-greet :error])
  (state/set app/one [:one-form]) )

(defevent app/one :form-reset []
  (state/unset app/one [:one-greet :error])
  (state/set app/one [:one-form] :reset) )

(defevent app/one :form-forget []
  (one/forget-name)
  (state/trigger app/one :form-reset))

;;TODOs
;;(defevent app/one :form-focused [])
;;(defevent app/one :form-changed [])

(defn submit-form []
  (state/trigger app/one :form-submit))

;; DOM Manipulation Methods
(defn attach []
  (one/attach)
  
  (delegate ($ :#greet-button) [] :click
    #(state/trigger app/one :form-submit))
  
  (delegate ($ :#back-button) [] :click
    #(state/trigger app/one :form-reset))

  (delegate ($ :#forget-button) [] :click
    #(state/trigger app/one :form-forget))

  (delegate ($ :#name-input) [] :keyup
    (fn [e]
      (. js/console (log e))
      (if (= 13 (. e -which)) 
        (state/trigger app/one :form-submit))))
    
  ;;Global binding for ESC
  (delegate ($ js/window) [] :keyup
    (fn [e]
      (if (= 27 (. e -which)) ;;Bindings for Escape
        (let [st-top (state/current app/top)
              st-one (state/current app/one)]
          (if (and (= st-top #{:one}) (= st-one #{:one-greet}))
             (state/trigger app/one :form-esc))))))
  
  (state/trigger app/one :form-reset))
  
  
(defn display-content []
  (one/change-background-to-blue)
  (one/display-content))

(defn hide-content [] 
  (one/change-background-to-normal)
  (one/hide-content))
