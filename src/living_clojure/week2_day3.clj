(ns living-clojure.week2-day3
  (:require [clojure.test :refer :all]))

(deftest day-3-tests

  (testing "Simple closures"
    (let [exp (fn exp-maker [n]
                (fn [x] (reduce * (repeat n x))))]
      (is (= 256 ((exp 2) 16) ((exp 8) 2)))
      (is (= [1 8 27 64] (map (exp 3) [1 2 3 4])))
      (is (= [1 2 4 8 16] (map #((exp %) 2) [0 1 2 3 4])))))

  (testing "Cartesian Product"
    (let [cartesian-product (fn cartesian-product [n m]
                              (set (for [i n
                                         j m]
                                     [i j])))]
      (is (= (cartesian-product #{"ace" "king" "queen"} #{"spade" "heart" "diamond" "club"})
             #{["ace" "spade"] ["ace" "heart"] ["ace" "diamond"] ["ace" "club"]
               ["king" "spade"] ["king" "heart"] ["king" "diamond"] ["king" "club"]
               ["queen" "spade"] ["queen" "heart"] ["queen" "diamond"] ["queen" "club"]}))
      (is (= (cartesian-product #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
      (is (= 300 (count (cartesian-product (into #{} (range 10))
                                           (into #{} (range 30)))))))))

