(ns interact.core-test
  (:require [clojure.test :refer :all]
            [interact.core :refer :all]
            [midje.sweet :refer :all]))

(facts "about pendulums"
       (fact (phi 0 100) => 1.0)
       (fact (phi 50 100) => -1.0)
       (fact (phi 100 100) => 1.0))

(facts "about period"
       (fact (< (period 1) (period 2)) => true))

