(ns encoding-error.core)

;; number - preamble-number
;; (1...25) , 26 ........
;; contra-preamble = (25, 1)
;;
;;
;;

(defn all-pairs [coll]
  (let [x (first coll) xs (next coll)]
    (when xs
      (lazy-cat
       (map (fn [y] [x y]) xs)
       (all-pairs xs)))))

(defn preamble-match [preamble number]
  (let [valid-numbers (map #(reduce + %) (all-pairs preamble))]
    (not= nil (some #{number} valid-numbers))))

(defn find-invalid-xmas-number [input]
  (let [first-25 (take 25 input)]
   1000))
