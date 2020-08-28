(ns living-clojure.day3-week1
  (:require [clojure.test :refer :all]))

(deftest day-3-tests

  (testing "Regular Expressions"
    (is (= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))
    (is (= "13" (apply str (re-seq #"[0-9]+" "bA1B3Ce "))))
    (is (= "be" (apply str (re-seq #"[a-z]+" "bA1B3Ce "))))
    (is (= "bABCe" (apply str (re-seq #"[a-zA-Z]+" "bA1B3Ce ")))))

  (testing "Simple Recursion"
    (let [recursion-function (fn foo [x]
                               (when (> x 0)
                                 (conj (foo (dec x)) x)))]
      (is (= '(5 4 3 2 1) (recursion-function 5)))))

  (testing "Recurring Theme"
    (is (= [7 6 5 4 3]
           (loop [x 5
                  result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result)))))

  (testing "Rearranging Code: -> thread-first"
    (let [response last]
      (is (= (response (sort (rest (reverse [2 5 4 1 3 6]))))
             (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (response))
             5))))

  (testing "Rearranging Code: ->> thread-last"
    (let [response #(reduce + %)]
      (is (= (response (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
             (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (response))
             11))))

  (testing "For the win"
    (let [response '(1 5 9 13 17 21 25 29 33 37)]

      (is (= response
             (for [x (range 40)
                   :when (= 1 (rem x 4))]
               x)))

      (is (= response
             (for [x (iterate #(+ 4 %) 0)
                   :let [z (inc x)]
                   :while (< z 40)]
               z)))

      (is (= response
             (for [[x y] (partition 2 (range 20))]
               (+ x y)))))))

