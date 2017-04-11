(ns datomic-commons.db
  (:require [clojure.core.async :refer (<!!)] 
            [datomic.client :as client]))

(defn connect [connection]
  (<!! (client/connect connection)))

(defn transact [conn schema]
  (<!! (client/transact conn {:tx-data schema})))
