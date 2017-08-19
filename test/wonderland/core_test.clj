(ns wonderland.core-test
  (:require [clojure.test :refer :all]
            [wonderland.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest shop-for-jams-returns-a-set
  (testing "shop for jams answers with a set"
    (is (map? (shop-for-jams "red" "blue")))))
