(ns wonderland.euler.two-test
  (:require [wonderland.euler.two :refer :all]
            [wonderland.euler.core :refer :all]
            [clojure.test :refer :all]))

(deftest first-ten-fibonacci
  (testing "first ten terms"
    (is (= (fibonacci-terms 10) [1 2 3 5 8 13 21 34 55 89]))))

(deftest test-fibonacci-upto
  (testing "stops at limit"
    (is (not (any? (fn [n] (> n 100)) (fibonacci-upto 100)))))
  (testing "only fibonacci sequence terms"
    (is (= (fibonacci-upto 25) [1 2 3 5 8 13 21]))))
