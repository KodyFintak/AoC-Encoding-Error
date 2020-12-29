(ns encoding-error.core-test
  (:require [clojure.test :refer :all]
            [encoding-error.core :refer :all]))

(def one-through-25 (range 1 26))

(def input (concat one-through-25 `(1000)))

(def input-2 (concat one-through-25 `(26 537)))

(deftest preamble-match-test
  (testing "number given is invalid"
    (is (= true (preamble-match one-through-25 1000)))))

(deftest find-invalid-xmas-number-test
  (testing "26th number is invalid"
    (is (= 1000 (find-invalid-xmas-number input))))
  (testing "27th number is invalid"
    (is (= 537 (find-invalid-xmas-number input-2)))))
