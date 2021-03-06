(ns wonderland.euler.five-test
  (:require [wonderland.euler.five :as sut]
    [clojure.test :refer :all]))

(deftest five-example
  (testing "2520 is the smallest number evenly divisble by 1..10"
    (is (= 2520 (wonderland.euler.core/lcm (wonderland.euler.core/upto-natural 11))))))
