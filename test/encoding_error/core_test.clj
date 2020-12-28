(ns encoding-error.core-test
  (:require [clojure.test :refer :all]
            [encoding-error.core :refer :all]))

(deftest add-1-test
  (testing "Making sure we can call src"
    (is (= (add-1 2) 3))))
