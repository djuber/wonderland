(ns wonderland.euler.two)

(defn fib-iter [remaining cur last]
  (if (= 0 remaining)
    cur
    (fib-iter (dec remaining) (+ cur last) cur)))

(defn fibonacci-terms
  "take limit terms from the fibonacci sequence"
  [limit]
  (loop [collection []
         count 0
         cur 1
         last 0]
    (if (= count limit)
      collection
      (recur (conj collection (+ cur last))
             (inc count)
             (+ cur last)
             cur))))

(defn fibonacci-until [break]
  (loop [collection []
         cur 1
         last 0]
    (if (break cur)
      (clojure.core/butlast collection)
      (recur (conj collection (+ cur last))
             (+ cur last)
             cur))))


(defn fibonacci-upto [limit]
  (fibonacci-until (fn [n] (< limit n))))

(defn euler-two []
  (reduce +
          (filter even?
                  (fibonacci-upto 4000000))))
