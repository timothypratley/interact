(ns scratch
  (:require [clojure.repl :refer :all]
            [clojure.test :refer :all]
            [interact.core :refer :all]))

(start)
(add-pendulum [100 50] 200)
(clear)
(create-harmonics)

(doc inc)
(run-tests)
