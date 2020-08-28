(ns living-clojure.day5-week1
  (:require [clojure.test :refer :all]))

(deftest day-5-tests

  (testing "Compress a Sequence"
    (let [compress
          (fn cmp
            ([col] (cmp col '()))
            ([col acc]
             (if (empty? col)
               acc
               (recur (butlast col)
                      (if (not= (first acc) (last col)) (conj acc (last col)) acc)))))]
      (is (= (apply str (compress "Leeeeeerrroyyy")) "Leroy"))
      (is (= (compress [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
      (is (= (compress [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

  (testing "Pack a Sequence"
    (let [pack #(partition-by identity %)]
      (is (= (pack [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
      (is (= (pack [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
      (is (= (pack [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))))

  (testing "Drop Every Nth Item"
    (let [drop-nth
          (fn drp [coll n]
            (->> coll
                 (map-indexed list)
                 (filter #(not= 0 (mod (inc (nth % 0)) n)))
                 (map #(nth % 1))))]
      (is (= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
      (is (= (drop-nth [:a :b :c :d :e :f] 2) [:a :c :e]))
      (is (= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6]))))

  (testing "Intro to Iterate"
    (let [response '(1 4 7 10 13)]
      (is (= response (take 5 (iterate #(+ 3 %) 1))))))

  (testing "Replicate a Sequence"
    (let [replicate-function
          (fn [col n]
            (reduce
              (fn [x y]
                (println x y)
                (concat x (repeat n y)))
              [] col))]
      (is (= (replicate-function [1 2 3] 2) '(1 1 2 2 3 3)))
      (is (= (replicate-function [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
      (is (= (replicate-function [4 5 6] 1) '(4 5 6)))
      (is (= (replicate-function [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))))))

