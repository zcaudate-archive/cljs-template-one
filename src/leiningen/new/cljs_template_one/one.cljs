(ns {{name}}.client.layouts.one
  (:require [crate.core :as crate]
            [fetch.remotes :as remotes])
  (:use [jayq.core :only [$ hide show append fade-in text val css]])
  (:use-macros [crate.def-macros :only [defpartial]]
               [fetch.macros :only [remote letrem]]))

(defpartial oneapp-top-level []
  [:div {:id "oneapp-top-level"}])

(defpartial oneapp-form []
  [:div {:class "row-fluid" :id "oneapp-form"}
    [:div {:class "span4"}]
    [:div {:class "span4" :id "form-contents"}
      [:h1 {:id "header"} "My form"]
      [:div {:class "input"}
        [:label {:id "name-input-label"}
          [:span "Enter your name"]
          [:input {:id "name-input" :size "30" :type "text"}]]
        [:div {:id "name-input-error" :class "small error"} " "]]
      [:input {:id "greet-button" :type "button" :value "Meet"}]]
    [:div {:class "span4"}]])

(defpartial oneapp-greeting []
  [:div {:id "oneapp-greeting"}
    [:div {:id "greeting-contents"}
      [:h2 "Hello"]
      [:div {:class "break"}]
    [:h3
      [:span {:class "again"} "again"] 
      " "
      [:span {:class "name"} "Person"]]]
    [:input {:id "back-button" :type "button" :value "Back"}]  
    [:input {:id "forget-button" :type "button" :value "Forget Me"}]])

;; DOM Manipulation
(defn display-content []
  (-> :#oneapp-top-level $ fade-in))

(defn hide-content []
  (-> :#oneapp-top-level $ hide))

(defn display-form []
  (-> :#oneapp-form $ fade-in))

(defn hide-form []
  (-> :#oneapp-form $ hide))

(defn clear-input []
  (-> :#name-input $ (val "")))

(defn display-greeting []
  (-> :#oneapp-greeting $ fade-in))

(defn hide-greeting []
  (-> :#oneapp-greeting $ hide))

(defn hide-again-label []
  (-> :span.again $ hide))  

(defn show-again-label []
  (-> :span.again $ show)) 

(defn is-input-valid? []
  (->> :#name-input $ val (re-find #"^[a-zA-Z]+$") nil? not))

(defn is-input-long-enough? []
  (->> :#name-input $ val count (< 2)))

(defn set-error-message [msg]
  (-> :#name-input-error $ (text msg)))
  
(defn change-background-to-blue []
  (-> :body $ (. (css "background-image" "url(/img/main-background-noise.png)"))))

(defn change-background-to-normal []
  (-> :body $ (. (css "background-image" "none"))))
  
;;; Remotes
(defn meet-name []
  (let [name-val (-> :#name-input $ val)]
    (remote (meet name-val) [result]
      (if result 
        (hide-again-label)
       (show-again-label))
      (-> :span.name $ (text name-val)))))

(defn forget-name []
  (let [name-val (-> :span.name $ text)]
    (remote (forget name-val))))


;;; Display 
(defn attach []
  (-> :#content $ (append (oneapp-top-level)))
  (hide-content)
  (-> :#oneapp-top-level $ (append (oneapp-form)))
  (hide-form)
  (-> :#oneapp-top-level $ (append (oneapp-greeting)))
  (hide-greeting))
