(ns living-clojure.week2-day5
  (:require [clojure.test :refer :all]))

(deftest day-5-tests

  (testing "Pascal’s Triangle"
    (let [p-triangle (fn p-triangle
                       ([rows]
                        (p-triangle rows 1 [1]))
                       ([rows counter acc]
                        (let [gen-next-row (fn gen-next-row [row]
                                             (loop [[a & rest] row
                                                    result []]
                                               (if (empty? rest)
                                                 (vec (concat [1] result [1]))
                                                 (recur rest (conj result (+ a (first rest)))))))]
                          (if (= rows counter)
                            acc
                            (recur rows (inc counter) (gen-next-row acc))))))]
      (is (= (p-triangle 1) [1]))
      (is (= (map p-triangle (range 1 6))
             [[1]
              [1 1]
              [1 2 1]
              [1 3 3 1]
              [1 4 6 4 1]]))
      (is (= (p-triangle 11)
             [1 10 45 120 210 252 210 120 45 10 1])))))

