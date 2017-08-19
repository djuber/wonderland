(ns wonderland.euler.four-test
  (:require  [clojure.test :refer :all]
    [wonderland.euler.four :as sut]))

(deftest products-of-three-digits
  (let [prods (sut/products-of-three-digits)]
    (testing "correct ranges"
      (is (= (* 100 100) (apply min prods)))
      (is (= (* 999 999) (apply max prods))))
    (testing "fully crossed"
      (is (some #{ (* 123 321) } prods)))))
