(ns wonderland.euler.one-test
  (:require [clojure.test :refer :all]
            [wonderland.euler.one :refer :all]))

(deftest a-test
  (testing "I pass."
    (is (=  1 1))))

(deftest one-example
  (testing "all the multiples below ten that are multiples of 3 or 5 are (3 5 6 9)"
    (is (= '(3 5 6 9) (multiples-below 10 '(3 5))))))

(deftest one-example-two
  (testing "sum of multiples below ten of 3 and 5 is 23"
    (is (= 23 (sum-of-multiples-below 10 '(5 3))))))
