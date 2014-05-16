(ns bitcoin.micropayment
  (:require [bitcoin.core :as btc]))

; temp sanity check to see if file is loaded..
(defn micro-hi []
  (str "hello from micro"))


(def client-state (atom nil))
(def server-state (atom nil))

(def payment-amt (atom nil))



  ;; API design #1


;;  CLIENT SIDE:
;; =======================

;; https://github.com/bitcoinj/bitcoinj/blob/master/core/src/main/java/com/google/bitcoin/protocols/channels/PaymentChannelClientState.java

#_(defn create-client []
  (reset! client-state (com.google.bitcoin.protocols.channels.PaymentChannelClientState )))







;;  SERVER SIDE:
;; =======================



#_(defn create-server []
  (reset! server-state (com.google.bitcoin.protocols.channels.PaymentChannelServerState. )))



  ;; API design #2
;  PaymentChannelClient
;  PaymentChannelServer


  ;; wallet extension
  ;; API design #3
;  StoredPaymentChannelClientStates
;  StoredPaymentChannelServerStates


  ;;  API design #4
;  PaymentChannelClientConnection
;  PaymentChannelServerListener




#_(defn incrementPaymentBy []
  ())


;; Notes:

;; 1. client decides to pay server X amt (max amt). Sends intent msg.
;; 2. client & server agree on multisig, timelocked tx (1 day) that spends 100% back to client. ("refund tx")
;; 3. both client & server sign refund tx.
;; 3. once client has signed refund tx, sends (contract) tx to server, who signs and broadcasts.
;; 4. client prepares new copy of refund tx (minus 'micro' amt) and sends signature to server.
;; 5. server verifies signature and stores it.
;;  repeat steps 4 & 5 as necessary.
;; 6. client says to server, "I'm done; close the channel".
;; 7. Server closes channel, signs latest refund tx and broadcasts to the chain.


;; References:

;;  https://en.bitcoin.it/wiki/Contracts#Example_7:_Rapidly-adjusted_.28micro.29payments_to_a_pre-determined_party
;;  https://bitcoinj.github.io/working-with-micropayments
