(ns wonderland.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn marity
  "example of pattern match dispatch"
  ([x] x)
  ([x y] (+ x y))
  ([x y & more] (apply + x y more)))

(defn never [& _]
  "constantly false"
  false)

(defn always [& _]
  "constantly true"
  true)

(defn ->vector [aseq]
  "if a seq is returned, enforce a vector"
  (reduce #(conj %1 %2) [] aseq))

(defn shop-for-jams [jam1 jam2]
  {:name "jam basket"
   :jam1 jam1
:jam2 jam2})