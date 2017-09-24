(ns wonderland.euler.six-test
  (:require [wonderland.euler.six :as sut]
            [clojure.test :as t]))

(t/deftest sum-sq-first-ten-numbers
  (let [one-to-ten (wonderland.euler.core/upto-natural 11)]
    (t/testing
        "example six sums"
      (t/is (= (sut/sum-of-square one-to-ten) 385)))))

(t/deftest sq-sum-first-ten-numbers
  (let [one-to-ten (wonderland.euler.core/upto-natural 11)]
    (t/testing "example six squares"
      (t/is (= (sut/square-of-sum one-to-ten) 3025)))))

(t/deftest difference-between-the-sqsum-and-sumsq
  (let [one-to-ten (wonderland.euler.core/upto-natural 11)]
    (let [sumsq (sut/sum-of-square one-to-ten)
          sqsum (sut/square-of-sum one-to-ten)]
      (t/testing "example six difference"
        (t/is (= (- sqsum sumsq) 2640))))))
