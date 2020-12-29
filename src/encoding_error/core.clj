(ns encoding-error.core)

(defn all-pairs [coll]
  (let [x (first coll) xs (next coll)]
    (when xs
      (lazy-cat
       (map (fn [y] [x y]) xs)
       (all-pairs xs)))))

(defn in? [number coll]
  (not= nil (some #{number} coll)))

(defn valid-with-preamble? [preamble number]
  (let [valid-numbers (map #(reduce + %) (all-pairs preamble))]
    (in? number valid-numbers)))

(defn find-invalid-xmas-number [input]
  (let [first-25 (take 25 input) next-number (nth input 25)]
   (if (valid-with-preamble? first-25 next-number) nil next-number)))
