(ns datomic-commons.builder
  (:require [datomic-commons.schema :as sch]))

(defn- vals! [mapalike] ;; [[k v] [k v] ...]
  (map second mapalike))

(defn make-data-fn
  "Make a function out of a schema; called with a single argument - a datomic schema map - this function produces the corresponding data builder function:
* with arguments same as identities found with :db/ident in the schema maps
* which outputs a vector of maps each consisting of the identity keyword as key and the passed argument as value
Called with two argumetns - a key and a schema - it does the same thing as above only it looks up elements in the schema based on the supply key; the arguments will then be the corresponding values for the supplied key."
  ([schema]
   (make-data-fn :db/ident schema))
  
  ([k schema]
   (let [identities (sch/identify k schema)
         args (-> identities vals! vec str)
         body (-> (reduce #(apply assoc %1 %2) {} identities) vector str)
         ;_ (println body)
         result-str (str "(fn " args " " body ")")]
     (-> result-str read-string eval))))
