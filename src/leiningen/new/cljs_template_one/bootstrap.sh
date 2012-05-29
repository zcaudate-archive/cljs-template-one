#!/bin/bash
lein deps
lein git-deps

mkdir -p resources/public/js
mkdir -p resources/public/img

#from bootstrap
cp .lein-git-deps/bootstrap/js/bootstrap*.js resources/public/js/
cp .lein-git-deps/bootstrap/docs/assets/js/jquery.js resources/public/js/

#from less
cp -r .lein-git-deps/bootstrap/less resources/public
cp .lein-git-deps/less.js/dist/less-1.3.0.js resources/public/js/

#from one
cp .lein-git-deps/one/public/images/*.png resources/public/img/
cp .lein-git-deps/one/public/css/fonts resources/css/