;; Create the main project namespace
(ns modern-cljs.core)

;; enables cljs to print to the JS console of the browser
(enable-console-print!)

(.log js/console "hello world")
