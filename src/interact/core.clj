(ns interact.core
  (:require [quil.core :refer :all]))

(def Tau (* 2 Math/PI))
(def g 9.8)

(defn phi [t T]
  (Math/cos (* Tau (/ t T))))

(phi 0 100)
(phi 10 100)
(phi 50 100)
(phi 75 100)
(phi 100 100)
(phi 150 100)

(defn period [length]
  (* Tau (Math/sqrt (/ length g))))

(period 100)
(period 200)


(def ct (atom 0))
(def pendulums (atom []))

(defn draw-pendulum [{position :position
                      length :length}]
  (with-translation [position]
    (with-rotation [(/ (phi @ct (period length)) 2)]
      (stroke 255)
      (stroke-weight 5)
      (fill 100)
      (ellipse 0 length 30 30)
      (stroke 128 0 0)
      (fill 100 0 0)
      (line 0 0 0 length))))

(defn add-pendulum [position length]
  (swap! pendulums conj {:position position
                         :length length}))

;(add-pendulum [300 50] 300)


(dotimes [i 12]
  (add-pendulum [200 50] (+ 200 (* i 10))))


(defn draw []
  (swap! ct #(+ % 0.25))
  (background-float 0)
  (doseq [p @pendulums]
    (draw-pendulum p)))

(sketch
 :title "Pendulum Mayhem"
 :draw draw
 :size [400 400])


