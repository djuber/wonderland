(ns wonderland.euler.one)

;; just trying to build up enough vocabulary to do this when I don't know clojure yet.

(defn multiples-below
  "collect multiples of factors from 1 below limit"
  [limit factors]
  (remove nil?
          (map (fn [n] (any-of? (map multiple? factors) n))
               (upto-natural limit))))

(defn sum-of-multiples-below
  "add the multiples below limit of factors"
  [limit factors]
  (reduce +
          (multiples-below limit factors)))

(defn euler-one
  "https://projecteuler.net/problem=1"
  []
  (sum-of-multiples-below 1000 [3 5]))
