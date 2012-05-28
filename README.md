# cljs-template-one

I'm doing this as more of a learning exercise to bring together a number of projects that have helped me greatly in understanding development. Having spent a great deal of time looking at the [Clojurescript One](http://http://clojurescriptone.com/) source [code](https://github.com/brentonashworth/one) as well as the excellent [tutorials](https://github.com/brentonashworth/one/wiki) that were written for the framework. I thought the application was a fantastic and expanded my imagination of what was possible.

However, as a beginner to clojurescript, I found that 'One' had too much code to look at. In the end, I gave up. There were too many things going on for my liking and I did not dare tinker with the code for fear of breaking the app completely (which I did a number of times).

This project is my attempt to remake Clojurescript One, but instead of building everything from the grounnd up, I have used [cljs-template](https://github.com/ibdknox/cljs-template) by [Chris Granger](http://www.chris-granger.com/) as a base. The leiningen template makes use of the excellent [clojurescript libraries](http://www.chris-granger.com/projects/cljs/) he has written and makes it much easier to mimic the functionality of [Clojurescript One](http://http://clojurescriptone.com/) using [crate](https://github.com/ibdknox/crate) (dom creation), [jayq](https://github.com/ibdknox/jayq) (dom selection and manipulation), [waltz](https://github.com/ibdknox/waltz) (application state management) and [fetch](https://github.com/ibdknox/fetch) (server-side calls). 

There are three advantages to using [cljs-template](https://github.com/ibdknox/cljs-template) over [one](https://github.com/brentonashworth/one) a starting point for a project

  1. Each clojurescript library is independent means that I could concentrate on learning about all the pieces seperately then try to put it all together.
  
  2. Autocompile rocks and I try to avoid using the cljs-repl unless absolutely necessary
  
  3. cljs-template has a much smaller code footprint and gives a blank slate for any clojurescript project.


## Dealing with State
Having created simple GUI interfaces in the past using Visual Studio and Swing, I had a real hard time with application state management. After countless late nights trying to mediate disagreements between buttons, checkboxes and tabs, I gave up altogether (Shudder). Even a relatively simple state example of state changes felt nauseating.

Looking at the the limited documentation on [waltz](https://github.com/ibdknox/waltz), I felt from my own experience that modelling interfaces usinng Finite State Machines were the way to go for any project with more than one screen. Doing a Google Search on 'GUI FSM', I found a couple of articles: [Visual Basic](http://www.brainbell.com/tutors/Visual_Basic/Modeling_a_GUI_with_an_FSM.htm), [Javascript](http://freshbrewedcode.com/jimcowart/2012/03/12/machina-js-finite-state-machines-in-javascript/), [Fizzim - a Tool](http://www.fizzim.com/tutorial.html) and [Stackoverflow](http://stackoverflow.com/questions/1624516/gui-as-a-finite-state-machine).

Clojurescript One did implement a [state management system](https://github.com/brentonashworth/one/blob/master/src/app/cljs/one/sample/model.cljs) but it wasn't explicit like [waltz](https://github.com/ibdknox/waltz). However, there are too few examples on waltz and the example on the github page did not work because [noir.fetch.lazy-store](https://github.com/ibdknox/fetch/blob/master/src/noir/fetch/lazy_store.clj) has not been implemented as of 28 May 2012. I hope that my code will add to the documentation of this awesome idea and provide some examples of how clear code can be when seperation of interface and state is achieved.

## Bootstrapping CSS and JS Libraries
However I have realised how incompetent I am without a css framework in place already and so have used [twitter/bootstrap](https://github.com/twitter/bootstrap) for its core set of GUI functionality. I know I've gone against the Clojuerscript principle compiling everything down to a < 1k file. However, I figure that compared to content such as Image and Video more source code won't kill the browser or anybody's internet connection - especially for small projects where development speed, not optimization should be the focus. Writing clojure is much more fun that javascript so I'm going to worry about optimazation only when it becomes necessary. I'm also betting on the fact that by then, network and browser javascript will be flying and it won't be such a big issue anymore.


## Installation

### Leiningen 1.x

You'll need both [lein-newnew](https://github.com/Raynes/lein-newnew) and cljs-template-one.

```bash
lein plugin install lein-newnew 0.2.6
lein plugin install cljs-template-one 0.1.5
```
### Leiningen 2.x

There's nothing to install: As of preview3, templates are automatically fetched
when first used.

## Usage

```bash
lein new cljs-template-one my-awesome-project
cd  my-awesome-project
chmod +x bootstrap.sh
./bootstrap.sh

lein run
```

You now have a complete ClojureScript One Wannabe :)

## License

Copyright © 2012 Chris Granger, Chris Zheng

Distributed under the Eclipse Public License, the same as Clojure.
