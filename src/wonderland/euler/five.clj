(ns wonderland.euler.five)

"
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
"

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn two-arg-lcm
  "this two-arg and lcm combination comes from sbcl's source code."
  [a b]
  (if (or (zero? a) (zero? b))
    0
    (let [a (Math/abs a)
           b (Math/abs b)]
      (let [m (max a b)
             n (min a b)]
        (* (quot m (gcd a b)) n)))))

(defn lcm
  "give the least common multiple of arguments"
  [numbers]
  (reduce two-arg-lcm numbers))

(defn euler-five []
  (lcm (wonderland.euler.core/upto-natural 20)))
