(ns living-clojure.day2-week1
  (:require [clojure.test :refer :all]))

(deftest day-2-tests

  (testing "Sequences: rest"
    (is (= [20 30 40] (rest [10 20 30 40]))))

  (testing "Intro to Functions"
    (is (= 8 ((fn add-five [x] (+ x 5)) 3)))
    (is (= 8 ((fn [x] (+ x 5)) 3)))
    (is (= 8 (#(+ % 5) 3)))
    (is (= 8 ((partial + 5) 3))))

  (testing "Double Down"
    (let [double #(* % 2)]
      (is (= (double 3) 6))
      (is (= (double 2) 4))
      (is (= (double 11) 22))
      (is (= (double 7) 14))))

  (testing "Hello World"
    (let [hello #(str "Hello, " % "!")]
      (is (= (hello "Dave") "Hello, Dave!"))
      (is (= (hello "Jenn") "Hello, Jenn!"))
      (is (= (hello "Rhea") "Hello, Rhea!"))))

  (testing "Sequences: Maps"
    (is (= '(6 7 8) (map #(+ % 5) '(1 2 3)))))

  (testing "Sequences: Filter"
    (is (= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))))

  (testing "Local Bindings"
    (is (= 7 (let [x 5] (+ 2 x))))
    (is (= 7 (let [x 3, y 10] (- y x))))
    (is (= 7 (let [x 21] (let [y 3] (/ x y))))))

  (testing "Let it Be"

    (is (= 10 (let [x 7 y 3 z 1] (+ x y))))
    (is (= 4 (let [x 7 y 3 z 1] (+ y z))))
    (is (= 1 (let [x 7 y 3 z 1] z)))))

