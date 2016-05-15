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

;; P03
;; Find the K'th element of a list.

                                        ; Presumably there's a less lame way to do this.
(defn successoro
  "Helper to get the successor of a number"
  [v v+1]
  (matche [v]
          ([-1] (== v+1 0))
          ([0]  (== v+1 1))
          ([1]  (== v+1 2))
          ([2]  (== v+1 3))
          ([3]  (== v+1 4))
          ([4]  (== v+1 5))
          ([5]  (== v+1 6))
          ; this should be plenty.
          ([6]  (== v+1 7))))

(defn ktho [value list k]
  (fresh [f r k-1]
    (conde
     [(== k -1) fail]
     [(== 0 k)  (conso value r list)]
     [(conso f r list) (successoro k-1 k) (ktho value r k-1)])))

(defn ktho2 [value list k]
  (conde
   [(< k 0)  fail]
   [(== 0 k) fail]
   [(matche [list]
            ([[]] fail)
            ([[_|value|_]] )
            )]))

