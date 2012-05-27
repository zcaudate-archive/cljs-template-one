(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://exampl.com/FIXME"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [noir-cljs "0.3.2"]
                 [jayq "0.1.0-alpha4"]
                 [waltz "0.1.0-alpha1"]
                 [fetch "0.1.0-alpha2"]
                 [crate "0.2.0-alpha2"]
                 [noir "1.3.0-beta7"]]
  :plugins [[lein-git-deps "0.0.1-SNAPSHOT"]]
  :git-dependencies [["https://github.com/twitter/bootstrap.git"]]
  :cljsbuild {:builds [{}]}
  :main ^{:skip-aot true} {{name}}.server)
