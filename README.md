# cljs-template-one

This hijacks 'cljs-template' by Chris Granger, and makes use of the
excellent clojurescript libraries he has written.

I spent a great deal of time looking at the Clojurescript One source code
as well as the excellent tutorials that were written for the code. I thought
the application was a fantastic. However, whilst the application inspired
my imagination to think of the new ways applications could be built
the only problem I found looking at the code was that there was way too 
much of it for a beginner. In the end, I gave up because it was just too hard. 
There were too many things going on for my liking and I did not dare tinker with 
the code for fear of breaking the app completely (which I did a number of times)

I never really understood why Chris Granger broke up his clojurescript library, pinot
into a bunch of what I thought was a random collection of names. However, after
using the cljs-template, I was super impressed with how all the libraries fit together.

This project tries to mimic the functions of Clojurescript One using
jayq, waltz, crate and fetch


A Leiningen template for Noir + ClojureScript projects.

## Installation

### Leiningen 1.x

You'll need both [lein-newnew](https://github.com/Raynes/lein-newnew) and cljs-template.

```bash
lein plugin install lein-newnew 0.2.6
lein plugin install cljs-template-one 0.1.6
```
### Leiningen 2.x

There's nothing to install: As of preview3, templates are automatically fetched
when first used.

## Usage

```bash
lein new cljs-template my-awesome-project
```
You now have a complete ClojureScript app, nothing more needed :)

## License

Copyright © 2012 Chris Granger, Chris Zheng

Distributed under the Eclipse Public License, the same as Clojure.
