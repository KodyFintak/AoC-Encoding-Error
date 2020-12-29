(ns encoding-error.core)

;; number - preamble-number

(defn preamble-match [preamble number]
  (let [contra-preamble (map #(Math/abs (- % number)) preamble)]
    (print contra-preamble)))

(defn find-invalid-xmas-number [input]
  (let [first-25 (take 25 input)]
   1000))
