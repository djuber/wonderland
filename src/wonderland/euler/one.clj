(ns wonderland.euler.one)

;; just trying to build up enough vocabulary to do this when I don't know clojure yet.

(defn divides?
  "true when a divides b"
  [a b]
  (= 0 (mod b a)))

(defn divisor?
  "yields a predicate for divides?"
  [a]
  (fn [n] (divides? n a)))

(defn any?
  "pred true for any in seq?"
  [pred seq]
  (some true?
        (map pred seq)))

(defn any-divide?
  "true when there is a divisor of a in bs"
  [a bs]
  (any? (divisor? a) bs))

(defn upto
  "gives 0 upto limit exclusive"
  [limit]
  (take-while #(< %1 limit)
              (range)))

(defn upto-natural
  "gives 1 upto limit exclusive"
  [limit]
  (drop 1 (upto limit)))

(defn is-multiple?
  "true when a is a multiple of b"
  [a b]
  (= 0 (mod a b)))

(defn multiple?
  "yields a predicate to test for multiple of input"
  [b]
  (fn [a] (is-multiple? a b)))

(defn any-of?
  "x when any of preds are true on it"
  [preds x]
  (if (any? #(true? (%1 x)) preds) x))

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
