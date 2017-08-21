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


;; for problem three we needed to create factor (probably don't yet need prime)
(defn factor [n]
  (let [limit (inc (int (Math/sqrt n)))]
    (cond
      (= n 0) nil
      (= n 1) nil
      (even? n) (cons 2 (factor (/ n 2)))
      :else (loop
                [test 3]
              (cond
                (= 0 (mod n test))
                (cons test (factor (/ n test)))
                (> test limit) (list n)
                :else (recur (+ test 2)))))))

(defn prime [n]
  (let [factors (factor n)]
    (and factors (empty? (rest factors)))))


;; from problem four - get digits of a number
(defn digit-char-to-digit [c]
  (case c
    "0" 0
    "1" 1
    "2" 2
    "3" 3
    "4" 4
    "5" 5
    "6" 6
    "7" 7
    "8" 8
    "9" 9))

(defn digits
  "give the digits of n as a list"
  [n]
  (map digit-char-to-digit
    (clojure.string/split
      (print-str n)
      #"")))

(defn palindromic
  "true of palindromic base 10 numbers"
  [n]
  (let [numbers (digits n)]
    (= (reverse numbers) numbers)))

(defn cross-product
  "join the collections in colls as tuples"
  [colls]
  (if (empty? colls)
    '(())
    (for [x (first colls)
           more (cross-product (rest colls))]
      (cons x more))))
