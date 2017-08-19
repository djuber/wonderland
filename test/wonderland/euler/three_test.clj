(ns wonderland.euler.three-test
  (:require [wonderland.euler.three :as sut]
            [clojure.test :refer :all]))

(deftest factors-example-test
  (testing "factors of 13195"
    (is (= (sut/factor 13195) '(5 7 13 29)))))
