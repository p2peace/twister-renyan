(ns twister-renyan.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [twister-renyan.views.home :as home :refer [home-page]]
              [twister-renyan.views.login :as login :refer [login-page]]
              [twister-renyan.views.templates :as templates
               :refer [post-area
                       loading-roller
                       refresh-button
                       user-photo
                       user-photo-link
                       search-profile-template
                       who-to-follow-template
                       toptrends-template
                       twistday-reminder-template
                       twistday-reminder-suggestion-template
                       follow-suggestion-template
                       expanded-post
                       post-preview-template
                       post-template
                       post-rt-reference-template
                       post-retransmitted-by-template
                       msg-user-link-template
                       external-page-link-template
                       hashtag-link-template
                       avatar-row-template
                       modal-wrapper
                       prompt-wrapper
                       confirm-popup-template
                       retwist-modal-template
                       reply-modal-template
                       direct-messages-template
                       dm-snippet-template
                       messages-thread-template
                       dm-chat-template
                       dm-form-template
                       group-messages-profile-modal-control-template
                       group-messages-messages-modal-control-template
                       group-profile-modal-template
                       group-profile-member-template
                       group-messages-new-group-template
                       group-messages-join-group-template
                       groups-list-item-template
                       profile-card
                       profile-modal-template
                       hashtag-modal-template
                       following-modal-template
                       following-config-modal-template]])
    (:import goog.History))


;; -------------------------
;; Views

(defn about-page []
  [:div [:h2 "About twister-renyan"]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn following-page []
  [:div [:h2 "following users page"]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn network-page []
  [:div [:h2 "Network status page"]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn options-page []
  [:div [:h2 "Options page"]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn profile-page []
  [:div [:h2 "Profile page"]
   [:div [:a {:href "#/"} "go to the home page"]]])

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :current-page #'home-page))

(secretary/defroute "/about" []
  (session/put! :current-page #'about-page))

(secretary/defroute "/following" []
  (session/put! :current-page #'following-page))

(secretary/defroute "/login" []
  (session/put! :current-page #'login-page))

(secretary/defroute "/network" []
  (session/put! :current-page #'network-page))

(secretary/defroute "/options" []
  (session/put! :current-page #'options-page))

(secretary/defroute "/profile" []
  (session/put! :current-page #'profile-page))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (hook-browser-navigation!)
  (mount-root))
