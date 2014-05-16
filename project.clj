(defproject bitcljoin "0.4.3-tuddman-SNAPSHOT"
  :description "BitCoin library for Clojure"
  :dependencies [
    [org.clojure/clojure "1.6.0"]
    [org.clojure/tools.logging "0.2.6"]
    [com.google/bitcoinj "0.11.2"]
    [com.h2database/h2 "1.3.170"]
    [lamina "0.5.2"]
    [bux "0.2.1"]]
  ;; :jvm-opts ["-Xmx1g"]
  :profiles { :dev { :dependencies [[postgresql "9.1-901.jdbc4"]
                                    [ch.qos.logback/logback-classic "1.0.7"]]}}
  :aot [bitcoin.walletappkit]
 )

