(ns wonderland.favorite-foods
  (:require [clojure.set :as s]))

(defn common-fav-foods [foods1 foods2]
  (let [food-set-1 (set foods1)
        food-set-2 (set foods2)
        common-foods (s/intersection food-set-1 food-set-2)]
    (str "Common Foods " common-foods)))

(common-fav-foods
 [:jam :brownies :toast]
 [:lettuce :carrots :jam])                 
        
