(ns wonderland.euler.three)


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
    (and factors (empty? (rest (factor n))))))

(defn euler-three []
  (apply max (factor 600851475143)))
