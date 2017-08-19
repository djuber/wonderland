(ns wonderland.euler.one-test
  (:require [clojure.test :refer :all]
            [wonderland.euler.one :refer :all]))

(deftest a-test
  (testing "I pass."
    (is (=  1 1))))

(deftest divides-test
  (testing "true when divides"
    (is (true? (divides? 2 10)))
    (is (true? (divides? 4 16)))
    (is (true? (divides? 1 1)))
    (is (true? (divides? 17 0))))
  (testing "false when does not divide"
    (is (false? (divides? 10 2)))
    (is (false? (divides? 16 4)))
    (is (false? (divides? 2 1)))
    (is (false? (divides? 3 5)))))

(deftest any-divide-test
  (testing "true when there is a divisor"
    (is (any-divide? 10 '(1)))
    (is (any-divide? 60 '(7 9 11 13 17 30))))
  (testing "false for empty set"
    (is (not (any-divide? 10 nil))))
  (testing "false for no divisors"
    (is (not (any-divide? 17 [2 3 4 5 6 7 8 9 10])))))


(deftest one-example
  (testing "all the multiples below ten that are multiples of 3 or 5 are (3 5 6 9)"
    (is (= '(3 5 6 9) (multiples-below 10 '(3 5))))))

(deftest one-example-two
  (testing "sum of multiples below ten of 3 and 5 is 23"
    (is (= 23 (sum-of-multiples-below 10 '(5 3))))))
