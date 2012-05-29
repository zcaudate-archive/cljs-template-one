(ns leiningen.new.cljs-template-one
    (:require [clojure.java.io :as io])
    (:use leiningen.new.templates))

(def render (renderer "cljs_template_one"))

(defn cljs-template-one
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["bootstrap.sh" (render "bootstrap.sh" data)]
             ["resources/public/css/one.css" (render "one.css" data)]
             ["src/{{sanitized}}/client/appstate.cljs" (render "appstate.cljs" data)]
             ["src/{{sanitized}}/client/mainapp.cljs" (render "mainapp.cljs" data)]
             ["src/{{sanitized}}/client/oneapp.cljs" (render "oneapp.cljs" data)]
             ["src/{{sanitized}}/client/layouts/blank.cljs" (render "blank.cljs" data)]
             ["src/{{sanitized}}/client/layouts/fluid.cljs" (render "fluid.cljs" data)]             
             ["src/{{sanitized}}/client/layouts/one.cljs" (render "one.cljs" data)]
             ["src/{{sanitized}}/client/layouts/welcome.cljs" (render "welcome.cljs" data)]             
             ["src/{{sanitized}}/models/user.clj" (render "user.clj" data)]
             ["src/{{sanitized}}/views/common.clj" (render "common.clj" data)]
             ["src/{{sanitized}}/views/main.clj" (render "main.clj" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             )))
