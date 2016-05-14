(ns logic.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

;; P01
;; Find the last element of a list
(defn lasto [last list]
  (matche [list]
  ([[]]          fail)
  ([[last]]      succeed)
  ([[_ . ?rest]] (lasto last ?rest))))

(run* [q] (lasto q '(1 2 3 6)))

;; P02
;; Find the last but one element of a list.
(defn lastbutoneo [p list]
  (matche [list]
          ([[]]   fail)
          ([[_]] fail)
          ([[p _]] succeed)
          ([[_ . ?rest]] (lastbutoneo p ?rest))))

(run* [q] (lastbutoneo q '(1 2 9 4 6)))
 
