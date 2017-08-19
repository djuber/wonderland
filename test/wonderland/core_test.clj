(ns wonderland.core-test
  (:require [clojure.test :refer :all]
            [wonderland.core :refer :all]))

(deftest a-test
  (testing "I pass."
    (is (=  1 1))))

(deftest never-is-always-false
  (testing "never is always false"
    (is (false? (never)))
    (is (false? (never 1)))
    (is (false? (never 1 2 3)))
    (is (false? (never true)))
    (is (false? (never (never))))))

(deftest always-is-always-true
  (testing "always is always true"
    (is (true? (always)))
    (is (true? (always nil)))
    (is (true? (always true)))
    (is (true? (always 1 2 3 4)))
    (is (true? (always (never))))))

(deftest ->vector-makes-vectors
  (testing "->vector yields a new vector"
    (is (= [] (->vector [])))
    (is (contains? (->vector #{1 2 3}) 2))
    (is (= [1 2 3] (->vector [1 2 3])))
    (is (= [1 2 3] (->vector (list 1 2 3))))
    (is (= [1 2 '(1 2)] (->vector (list 1 2 (list 1 2)))))))

(deftest shop-for-jams-returns-a-set
  (testing "shop for jams answers with a set"
(is (map? (shop-for-jams "red" "blue")))))
