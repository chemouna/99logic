(ns logic.core-test
  (:use logic.core)
  (:require [clojure.test :refer :all]
            [clojure.core.logic :refer [run* run fresh]]))

(deftest test-lasto
  (testing "fails for empty list"
    (is (empty? (run* [q] (lasto q [])))))
  (testing "gets last"
    (is (= [3] (run* [q] (lasto q [1 2 3]))))))

(deftest test-lastbutoneo
  (testing "fails for empty list"
    (is (empty? (run* [q] (lastbutoneo q [])))))
  (testing "fails for a one element list"
    (is (empty? (run* [q] (lastbutoneo q ['x])))))
  (testing "gets before last for a list of length 2"
    (is (= ['x] (run* [q] (lastbutoneo q ['x 'y])))))
  (testing "gets before last for a list of length > 2"
    (is (= ['z] (run* [q] (lastbutoneo q ['x 'y 'z 'w]))))))

(deftest test-ktho
  (testing "fails for a negative k"
    (is (empty? (run* [q] (ktho q '(1 2 3 4) -1)))))
  (testing "0 for an empty list"
    (is (empty? (run* [q] (ktho q [] 2)))))
  (testing "kth when k < list length"
    (is (= ['z] (run* [q] (ktho q '[x y z w] 2))))))







