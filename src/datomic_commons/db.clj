(ns datomic-commons.db
  (:require [clojure.core.async :refer (<!!)]
            [datomic.api :as d]
            [datomic.client :as client]))

(defn connect [connection-uri]
  (d/connect connection-uri))

(defn transact [conn schema]
  (d/transact conn schema))

(defn transact-async [conn schema]
  (d/transact-async conn schema))

(defn c-connect [connection]
  (<!! (client/connect connection)))

(defn c-transact [conn schema]
  (<!! (client/transact conn {:tx-data schema})))
