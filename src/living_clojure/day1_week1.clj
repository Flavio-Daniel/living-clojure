(ns living-clojure.day1-week1
  (:require [clojure.test :refer :all]))

(deftest day-1-tests

  (testing "Intro to Strings"
    (is (= "HELLO WORLD" (.toUpperCase "hello world"))))

  (testing "Intro to Lists"
    (is (= (list :a :b :c) '(:a :b :c))))

  (testing "Lists: conj"
    (is (= '(1 2 3 4) (conj '(2 3 4) 1)))
    (is (= '(1 2 3 4) (conj '(3 4) 2 1))))

  (testing "Intro to Vectors"
    (is
      (= [:a :b :c]
         (list :a :b :c)
         (vec '(:a :b :c))
         (vector :a :b :c))))

  (testing "Vectors: conj"
    (is (= [1 2 3 4] (conj [1 2 3] 4)))
    (is (= [1 2 3 4] (conj [1 2] 3 4))))

  (testing "Intro to Sets"
    (is (= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))))

  (testing "Sets: conj"
    (is (= #{1 2 3 4} (conj #{1 4 3} 2))))

  (testing "Intro to Maps"
    (is (= 20 ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= 20 (:b {:a 10, :b 20, :c 30}))))

  (testing "Maps: conj"
    (is (= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))))

  (testing "Intro to Sequences"
    (is (= 3 (first '(3 2 1))))
    (is (= 3 (second [2 3 4])))
    (is (= 3 (last (list 1 2 3))))))

