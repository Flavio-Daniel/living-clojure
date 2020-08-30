(ns living-clojure.week2-day4
  (:require [clojure.test :refer :all]
            [clojure.set :as set]))

(deftest day-4-tests

  (testing "Symmetric Difference"
    (let [sim-diff (fn sim-diff [set1 set2]
                     (set/union (set/difference set1 set2) (set/difference set2 set1)))]
      (is (= (sim-diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
      (is (= (sim-diff #{:a :b :c} #{}) #{:a :b :c}))
      (is (= (sim-diff #{} #{4 5 6}) #{4 5 6}))
      (is (= (sim-diff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))))

  (testing "Least Common Multiple"
    "had to look the answer of this, then found out:
    https://artofproblemsolving.com/wiki/index.php/Least_common_multiple"
    (let [lcm (fn [& args]
                (let [gcd (fn [n m] (if (= (mod n m) 0)
                              m
                              (recur m (mod n m))))]
                  (/ (reduce * args) (reduce gcd args))))]
      (is (== (lcm 2 3) 6))
      (is (== (lcm 5 3 7) 105))
      (is (== (lcm 1/3 2/5) 2))
      (is (== (lcm 3/4 1/6) 3/2))
      (is (== (lcm 7 5/7 2 3/5) 210)))))

