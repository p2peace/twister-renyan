(ns twister-renyan.views.home
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

(defn home-page []
  [:div [:h2 "twister-renyan"]
   [:div [:a {:href "#/about"} "go to about page"]]
   [:nav.userMenu
    [:ul
     [:li.userMenu-home.current
      [:a {:href "#/"}
       [:span.selectable_theme.theme_original.label "Home"]
       [:span.selectable_theme.theme_nin.menu-news]]]
     [:li.userMenu-network.selectable_theme.theme_original.theme_nin
      [:a.label {:href "#/network"} "Network"]]
     [:li.userMenu-profile.selectable_theme.theme_original.theme_nin
      [:a.label {:href "#/profile"} "Profile"]]
     [:li.userMenu-config
      [:a.userMenu-config-dropdown {:href "#"}
       [:div.config-menu.dialog-modal
        [:div.mini-profile-info.selectable_theme.theme_original
         [:div.mini-profile-photo
          ;; (user-photo "mini-profile-photo")
          ]
         [:a.mini-profile-name {:href "#"} "Nobody Yet"]
         [:span.mini-profile-view "View"]]
        [:a.dropdown-menu-item {:href "#/options"} "Options"]
        [:a.dropdown-menu-item {:href "#/network"} "Network"]
        [:a.dropdown-menu-item {:href "#/profile"} "Accounts"]
        [:a.dropdown-menu-item {:href "#/following"} "Following Users"]
        [:a.dropdown-menu-item {:href "#/login"} "Change User"]
        [:a.dropdown-menu-item.promoted-posts-only.selectable_theme.theme_original.theme_calm
         {:href "#"} "Switch to Promoted Posts"]
        [:a.dropdown-menu-item.direct-messages.selectable_theme.theme_original.theme_calm
         {:href "#"} "Direct Messages"]
        [:a.dropdown-menu-item.direct-messages.selectable_theme.theme_original.theme_calm
         {:href "#"} "Group Messages"]]]]
     [:li.userMenu-connections
      [:a {:href "#"}
       [:span.messages-qtd {:style {:display "none"}} 0]]]
     [:li.userMenu-messages
      [:a {:href "#"}
       [:span.messages-qtd {:style {:display "none"}} 0]]]
     [:li.userMenu-group
      [:a {:href "#"}
       [:span.messages-qtd {:style {:display "none"}} 0]]]
     [:li.userMenu-dhtindicator.selectable_theme.theme_calm
      [:a {:href "#/network"}]]
     ;; Search
     [:li.userMenu-search
      [:input.userMenu-search-field {:type "text" :placeholder "search"}]
      [:div.search-results.dialog-modal
       [:ul.userMenu-search-sugestions {:style {:display "none"}}
        [:li [:a {:href "A Nobody"}]]
        [:li [:a {:href "Another Nobody"}]]
        [:li [:a {:href "One More Nobody"}]]]
       [:ul.userMenu-search-profiles]]]]]
   ;; Nav end
   [:div.wrapper
    [:div.dashboard.left
     [:ul.mini-profile-indicators.selectable_theme.theme_nin
      [:li.userMenu-connections
       [:a {:href "#" :title "Mentions"}
        [:span.messages-qtd {:style {:display "none"}} 0]
        [:span "Mentions"]]]
      [:li.userMenu-groupmessages
       [:a {:href "#" :title "Group Messages"}
        [:span.messages-qtd {:style {:display "none"}} 0]
        [:span "Group Messages"]]]
      [:li.userMenu-messages
       [:a {:href "#" :title "Direct Messages"}
        [:span.messages-qtd {:style {:display "none"}} 0]
        [:span "Direct Messages"]]]]
     ;; Profile widget
     [:div.module.mini-profile
      [:div.mini-profile-info
       [:div.mini-profile-photo
        (user-photo)]
       [:a.mini-profile-name.open-profile-modal {:href "#"}]
       [:span.mini-profile-view "View"]]
      [:ul.module.profile-data
       [:li
        [:a.open-profile-modal {:href "#"}
         [:span.posts-count "&nbsp;"]
         [:span.label "Posts"]]]
       [:li
        [:a.open-following-page {:href "#/following"}
         [:span.following-count "&nbsp;"]
         [:span.label "Following"]]]
       [:li
        [:a.open-followers {:href "#"}
         [:span.followers-count "&nbsp;"]
         [:span.label "Followers"]]]]
      (post-area)]
     ;; Who to follow
     [:div.module.who-to-follow {:style {:display "none"}}]
     ;; Trends
     [:div.module.toptrends {:style {:display "none"}}]
     ;; Twistday
     [:div.module.twistday-reminder {:style {:display "none"}}]]

    ;; Posts area
    [:div.postboard
     [:h2
      [:span "Postboard"]
      [:button.postboard-news.selectable_theme.theme_original.theme_calm
       {:style {:display "none"}}]]
     ;; Post type tab (normal, promoted)
     [:ul.promoted-posts-only.promoted.selectable_theme.theme_nin
      [:li.normal-posts.active [:span "Normal posts"]]
      [:li.promoted-posts.disabled [:span "Promoted posts"]]]
     ;; Top of postboard postarea
     [:div#postboard-top.selectable_theme.theme_nin (post-area)]
     ;; User pic
     [:div.profile-photo (user-photo "" "img/genericPerson.png")]]
    ;; postboard-top end

    [:ol#posts.postboard-posts
     ;; "post-template" here
     ]
    [:div.postboard-loading {:style {:display "none"}} [:div]]]
   ;; post area end
   [:div.dashboard.right]])
