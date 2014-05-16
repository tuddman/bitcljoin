(ns bitcoin.walletappkit
  (:import  (com.google.bitcoin.kits WalletAppKit))
  (:require  [clojure.java.io :as io]
             [bitcoin.core :as btc]))
(:gen-class
   :name com.google.bitcoin.kits.WalletAppKit
   :exposes-methods { startUp exposedStartUp })



;; WalletAppKit provides a wrapper for much of the lower level functionality to use bitcoinj,
;; notably, the BlockChain, BlockStore, a PeerGroup and a Wallet.
;; be aware that when this starts up it syncs the block-chain, which can take ... awhile.

;; NOTE:  This wrapper is NOT fully implemented as of May 2014.


;; Ref:
;; https://github.com/bitcoinj/bitcoinj/blob/master/core/src/main/java/com/google/bitcoin/kits/WalletAppKit.java


(defn kit
  ([] (WalletAppKit. (com.google.bitcoin.core.NetworkParameters/testNet) (io/file ".")  "wallet-appkit-testnet"))
  ([networkParams directory filePrexix] (WalletAppKit. networkParams directory filePrexix)))

(defn regtest-kit []
  (WalletAppKit. (com.google.bitcoin.core.NetworkParameters/regTests) (io/file ".")  "wallet-appkit-regtest"))




(defn -startUp
  [aKit]
  (.exposedStartUp aKit))


#_(defn -shutDown
  [aKit]
  (.exposedShutDown aKit))



;; Set startup to be "complete" when network is up, peer connections established, and block chain synch-ed.
;; accepts a boolean as the argument.


(defn setBlockingStartup
  [aKit bool]
  (.setBlockingStartup aKit bool))


(defn connectToLocalHost
  [aKit]
  (.connectToLocalHost aKit))



;; set version msg: e.g. "My Wallet" "1.0-Beta"

(defn setUserAgent
  [aKit userAgent version]
  (.setUserAgent aKit userAgent version))




;; Implement the various functions avaialble to a WalletAppKit:


(defn createPeerGroup
  [aKit]
  (.createPeerGroup aKit))


(defn setDownloadListener
  [aKit listener]
  (.setDownloadListener aKit listener))




;; Get the various parts of a functioning WalletAppKit:


(defn params
  [aKit]
  (.params aKit))

(defn chain
  [aKit]
  (.chain aKit))


(defn store
  [aKit]
  (.store aKit))


(defn wallet
  [aKit]
  (.wallet aKit))


(defn peerGroup
  [aKit]
  (.peerGroup aKit))


(defn directory
  [aKit]
  (.directory aKit))

