(ns living-clojure.week2-day2
  (:require [clojure.test :refer :all]))

(deftest day-2-tests

  (testing "Advanced Destructuring"
    (let [response [1 2 3 4 5]]
      (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] response] [a b c d])))))

  (testing "A Half-Truth"
    (let [half-true (fn hf [& args]
                      (if (or (every? true? args) (nil? (some true? args)))
                        false
                        true))]
      (is (= false (half-true false false)))
      (is (= true (half-true true false)))
      (is (= false (half-true true)))
      (is (= true (half-true false true false)))
      (is (= false (half-true true true true)))
      (is (= true (half-true true true true false)))))

  (testing "Greatest Common Divisor"
    (let [gcd (fn


                )]
      (is (= (gcd 2 4) 2))
      (is (= (gcd 10 5) 5))
      (is (= (gcd 5 7) 1))
      (is (= (gcd 1023 858) 33)))))

