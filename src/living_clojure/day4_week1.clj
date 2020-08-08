(ns living-clojure.day4-week1
  (:require [clojure.test :refer :all]))

(deftest day-4-tests

  (testing "Penultimate Element"
    (let [second-to-last
          (fn [col]
            (let [len (count col)]
              (when (> len 0)
                (nth col (- len 2)))))]
      (is (= (second-to-last (list 1 2 3 4 5)) 4))
      (is (= (second-to-last ["a" "b" "c"]) "b"))
      (is (= (second-to-last [[1 2] [3 4]]) [1 2]))
      (is (= (second-to-last []) nil))))

  (testing "Sum It All Up"
    (let [sum-function #(reduce + %)]
      (is (= (sum-function [1 2 3]) 6))
      (is (= (sum-function (list 0 -2 5 5)) 8))
      (is (= (sum-function #{4 2 1}) 7))
      (is (= (sum-function '(0 0 -1)) -1))
      (is (= (sum-function '(1 10 3)) 14))))

  (testing "Find the odd numbers"
    (let [filter-odd #(filter odd? %)]
      (is (= (filter-odd #{1 2 3 4 5}) '(1 3 5)))
      (is (= (filter-odd [4 2 1 6]) '(1)))
      (is (= (filter-odd [2 2 4 6]) '()))
      (is (= (filter-odd [1 1 1 3]) '(1 1 1 3)))))

  (testing "Rearranging Code: -> thread-first"
    (let [response last]
      (is (= (response (sort (rest (reverse [2 5 4 1 3 6]))))
             (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (response))
             5))))

  (testing "Palindrome Detector"
    (let [is-palindrome? (fn [col]
                           (= (seq col) (reverse col)))]
      (is (false? (is-palindrome? '(1 2 3 4 5))))
      (is (true? (is-palindrome? "racecar")))
      (is (true? (is-palindrome? [:foo :bar :foo])))
      (is (true? (is-palindrome? '(1 1 3 3 1 1))))
      (is (false? (is-palindrome? '(:a :b :c))))))

  (testing "Duplicate a Sequence"
    (let [duplicate (fn dup
                      ([col] (dup col '()))
                      ([col acc]
                       (if (empty? col)
                         acc
                         (recur (butlast col) (conj acc (last col) (last col))))))]
      (is (= (duplicate [1 2 3]) '(1 1 2 2 3 3)))
      (is (= (duplicate [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
      (is (= (duplicate [[12] [34]]) '([12] [12] [34] [34])))
      (is (= (duplicate [[12] [34]]) '([12] [12] [34] [34]))))))

