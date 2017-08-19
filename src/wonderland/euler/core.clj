(ns wonderland.euler.core)


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
