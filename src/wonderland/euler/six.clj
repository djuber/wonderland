(ns wonderland.euler.six)

(def comment "
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural
numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred
natural numbers and the square of the sum.
")

(defn sum-of-square [range]
  (reduce +
          (map (fn [x] (* x x )) range)))

(defn square-of-sum [range]
  (let [sum (reduce + range)]
    (* sum sum)))

(defn euler-six []
  (let [one-to-one-hundred (wonderland.euler.core/upto-natural 101)]
    (- (square-of-sum one-to-one-hundred)
       (sum-of-square one-to-one-hundred))))
