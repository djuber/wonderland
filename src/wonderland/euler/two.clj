(ns wonderland.euler.two)

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
      (butlast collection)
      (recur (conj collection (+ cur last))
             (+ cur last)
             cur))))

(defn fibonacci-upto [limit]
  (fibonacci-until (fn [n] (< limit n))))

(defn euler-two []
  (reduce +
          (filter even?
                  (fibonacci-upto 4000000))))
