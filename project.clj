(defproject datomic-commons "0.1.7"
  :description "A place for common utilities in practical projects using Datomic"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.442"]
                 [com.datomic/datomic-pro "0.9.5561" :exclusions [org.slf4j/slf4j-nop org.slf4j/slf4j-log4j12]]
                 [com.datomic/clj-client "0.8.606"]]
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :creds :gpg}})
