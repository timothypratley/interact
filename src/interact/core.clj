(ns interact.core
  "Pendulum Mayhem"
  (:require [quil.core :refer :all]))


(def Tau (* 2 Math/PI))
(def gravity 9.8)

(defn phi [t period]
  (Math/cos (* Tau (/ t period))))

(defn length2period [length]
  (* Tau (Math/sqrt (/ length gravity))))

(defn draw-pendulum [position length]
  (let [p (phi (frame-count) (length2period length))]
    (with-translation [position]
      (with-rotation [(/ p 3)]
        (stroke-weight 5)
        (stroke 128 0 0)
        (fill 100 0 0)
        (line 0 0 0 length)
        (stroke 255)
        (fill 100)
        (ellipse 0 length 30 30)))))

(def pendulums (atom []))

(defn add-pendulum [position length]
  (swap! pendulums conj [position length]))

(defn clear []
  (reset! pendulums []))

(add-pendulum [100 50] 200)
(clear)


(defn freq2length [freq]
  (let [period (/ 700 freq)]
    (/ (* period period gravity) Tau)))

(doseq [length (map freq2length (range 46 91))]
  (add-pendulum [200 50] length))


(defn draw []
  (background-float 0)
  (doseq [[position length] @pendulums]
    (draw-pendulum position length)))


(sketch
 :title "Pendulum Mayhem"
 :draw draw
 :size [400 400])



