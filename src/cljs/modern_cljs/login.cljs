;; Create the main project namespace
(ns modern-cljs.login)

;; enables cljs to print to the JS console of the browser
(enable-console-print!)

(.log js/console "hello from login")

(defn filled-field-thread?
  [id]
  (->>
   id
   (.getElementById js/document)
   (.-value)
   (count)
   (< 0)))

(defn filled-field?
  [id]
  (< 0 (count (.-value (.getElementById js/document id)))))

(defn validate-form []
  (if (every? filled-field-thread? ["email" "password"])
    true
    (do (js/alert "Please, complete the form!")
        false)))

(defn init []
  ;; verify that js/document exists and has a getElementById property
  (if (and js/document
           (.-getElementById js/document))
    ;; get loginForm by element id and set its onsubmit property to
    ;; our validate-form function (a bad idea -- use events!)
    (let [login-form (.getElementById js/document "loginForm")]
      (.log js/console "inside init")
      (set! (.-onsubmit login-form) validate-form))))

(set! (.-onload js/window) init)
