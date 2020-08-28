(ns living-clojure.week2-day1
  (:require [clojure.test :refer :all]))

(deftest day-1-tests

  (testing "Fibonacci Sequence"
    (let [fibonacci (fn fibo
                      ([n]
                       (fibo n [1 1]))
                      ([n acc]
                       (if (< n 3)
                         (apply list acc)
                         (recur (dec n) (conj acc (+ (last acc) (last (butlast acc))))))))]
      (is (= (fibonacci 3) '(1 1 2)))
      (is (= (fibonacci 6) '(1 1 2 3 5 8)))
      (is (= (fibonacci 8) '(1 1 2 3 5 8 13 21)))))

  (testing "Get the Caps"
    (let [capital #(apply str (re-seq #"[A-Z]" %))]
      (is (= (capital "HeLlO, WoRlD!") "HLOWRD"))
      (is (empty? (capital "nothing")))
      (is (= (capital "$#A(*&987Zf") "AZ"))))

  (testing "Intro to some"
    (is (= 6 (some #{2 7 6} [5 6 7 8])))
    (is (= 6 (some #(when (even? %) %) [5 6 7 8]))))

  (testing "Fibonacci Sequence"
    (let [factorial (fn fac
                      ([n]
                       (fac n 1))
                      ([n acc]
                       (if (<= n 1)
                         acc
                         (recur (dec n) (* acc n)))))]
      (is (= (factorial 1) 1))
      (is (= (factorial 3) 6))
      (is (= (factorial 5) 120))
      (is (= (factorial 8) 40320))))

  (testing "Intro to Destructuring"
    (is (= [2 4] (let [[a b c d e f g] (range)] [c e])))))

