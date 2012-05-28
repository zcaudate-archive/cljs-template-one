#!/bin/bash
lein deps
lein git-deps

mkdir -p resources/public/js
cp .lein-git-deps/bootstrap/bootstrap-*.js resources/public/js/
cp .lein-git-deps/bootstrap/less resources/public
cp .lein-git-deps/less.js/dist/less-1.3.0.js resources/public/js/

