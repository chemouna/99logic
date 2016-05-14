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
    (is (empty? (run* [q] (lastbutoneo q [2])))))
  (testing "gets before last for a list of length"
    (is (= [1] (run* [q] (lastbutoneo q [1 2])))))
  (testing "gets before last for a list of length > 2"
    (is (= [2] (run* [q] (lastbutoneo q [1 2 3]))))))








