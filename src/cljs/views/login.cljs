(ns twister-renyan.views.login
  (:require [twister-renyan.views.templates :as templates
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
                     following-config-modal-template]]))

(defn login-page []
  [:div
   [:nav.userMenu
    [:ul
     [:li.userMenu-home
      [:a {:href "#/"}
       [:span.selectable_theme.theme_original.label "Home"]
       [:span.selectable_theme.theme_nin.menu-news]]]
     [:li.userMenu-network.selectable_theme.theme_original.theme_nin
      [:a.label {:href "#/network"} "Network"]]
     [:li.userMenu-profile.selectable_theme.theme_original.theme_nin
      [:a.label {:href "#/profile"} "Profile"]]]]
   [:div.login [:h2 "login"]
    [:div.module
     [:p [:span "Existing local users"]]
     [:div
      [:select.local-usernames.login-user]
      [:button.login-local-username "Login"]]]
    [:div.module
     [:p [:span "Create a new user"]]
     [:div
      [:input.new-username {:type "textbox"
                            :placeholder "Type nym here"
                            :cols 16
                            :rows 1}]
      [:button.check-availability "Check availability"]
      [:span.availability]]
     [:div
      [:button.create-user.disabled {:disabled "disabled"} "Create this account"]]]
    [:div.module
     [:div
      [:p [:span "Import secret key"]]
      [:input.secret-key-import {:type "textbox"
                                 :placeholder "52-character secret"
                                 :size 52
                                 :rows 1}]]
     [:div
      [:button.import-secret-key.disabled {:disabled "disabled"} "Import key"]]]]])
