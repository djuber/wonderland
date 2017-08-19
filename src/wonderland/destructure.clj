(ns wonderland.destructure)

(defn n-rand [n]
  (repeatedly n #(rand-int 10)))

(defn die-roll [dice sides]
  (reduce + (repeatedly dice #(+ 1 (rand-int sides)))))

(defn generate-character []
  (let [[str dex con intel wis cha] (repeatedly 6 #(die-roll 3 6))]
    {:strength str
     :dexterity dex
     :constitution con
     :intelligence intel
     :wisdom wis
     :charisma cha}))
