(ns logic.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

;;P01
;; Find the last element of a list
(defn lasto [last list]
  (matche [list])
  ([[]] fail)
  ([[last]] succeed)
  ([[_ . ?rest]] lasto last ?rest)
  
  ;;(([])))
