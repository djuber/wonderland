(ns wonderland.euler.one)

(defn divides? [a b]
  "true when a divides b"
  (= 0 (mod b a)))

(defn divisor? [a]
  "yields a predicate for divides?"
  (fn [n] (divides? n a)))

(defn any? [pred seq]
  "pred true for any in seq?"
  (some true?
        (map pred seq)))

(defn any-divide? [a bs]
  "true when there is a divisor of a in bs"
  (any? (divisor? a) bs))

(defn upto [limit]
  "gives 0 upto limit exclusive"
  (take-while #(< %1 limit)
              (range)))

(defn upto-natural [limit]
  "gives 1 upto limit exclusive"
  (drop 1 (upto limit)))

(defn is-multiple? [a b]
  "true when a is a multiple of b"
  (= 0 (mod a b)))

(defn multiple? [b]
  (fn [a] (is-multiple? a b)))

(defn any-of? [preds x]
  "x when any of preds are true on it"
  (if (any? #(true? (%1 x)) preds) x))

(defn multiples-below [limit factors]
  (remove nil?
          (map (fn [n] (any-of? (map multiple? factors) n))
               (upto-natural limit))))

(defn sum-of-multiples-below [limit factors]
  (reduce + (multiples-below limit factors)))
