(ns datomic-commons.schema)

(defn extract [k schema-entry]
  "Based on a key and an input schema-entry map produce a vector pair 
having the 
* key - associated value for key
* value - the extracted value turned to a symbol 

Calls to this fn will fail if value is not clojure.lang.Named"
  (let [v (k schema-entry)]
    [v (-> v name symbol)]))

(defn filter-schema [k v schema]
  "Filter out all elements in the schema when k exists and schema value for k is not v"
  (filter #(if-let [value (k %)]
             (not (= value v)))
          schema))

(defn identify [k schema]
  "Produce a map data structure with keys values associated with k and values the values corresponding to k turned to symbols"
  (reduce #(apply assoc %1 (extract k %2))
          {} schema))
