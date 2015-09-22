(ns twister-renyan.prod
  (:require [twister-renyan.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
