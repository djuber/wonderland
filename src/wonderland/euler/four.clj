(ns wonderland.euler.four
  (:require [wonderland.euler.core :as core]))

"A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers."

(defn products-of-three-digits []
  (map (fn [p] (apply * p))
    (core/cross-product
      (list
      (map (fn [n] (+ n 100)) (range 900))
        (map (fn [n] (+ n 100)) (range 900))))))

(defn euler-four []
  (apply max
    (filter core/palindromic (products-of-three-digits))))
