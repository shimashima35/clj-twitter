(ns clj-twitter.core
    (:use
      [twitter.oauth]
      [twitter.callbacks]
      [twitter.callbacks.handlers]
      [twitter.api.restful]
      [clojure.java.io])
    (:require [clojure.edn :as edn])
    (:import
      (twitter.callbacks.protocols SyncSingleCallback)))

 (def config (edn/read-string (slurp "config.edn")))
 (def my-creds (make-oauth-creds (get config  "consumer-key")
                                 (get config  "consumer-secret")
                                 (get config  "access-token")
                                 (get config  "access-token-secret")))
(defn -main [& args]
  (users-show :oauth-creds my-creds :params {:screen-name "shimashima35"}))
