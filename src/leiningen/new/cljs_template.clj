(ns leiningen.new.cljs-template
    (:require [clojure.java.io :as io])
    (:use leiningen.new.templates))

(def render (renderer "cljs_template"))

(defn cljs-template
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["script/bootstrap.sh" (render "script/bootstrap.sh" data)]
             ["src/{{sanitized}}/client/main.cljs" (render "main.cljs" data)]
             ["src/{{sanitized}}/models/user.clj" (render "user.clj" data)]
             ["src/{{sanitized}}/views/common.clj" (render "common.clj" data)]
             ["src/{{sanitized}}/views/main.clj" (render "main.clj" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             )))
