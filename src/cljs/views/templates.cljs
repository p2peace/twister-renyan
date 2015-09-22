(ns twister-renyan.views.templates)

;; -------------------------
;; Components/Templates

;; Home

(defn post-area []
  [:div.post-area
   [:form.post-area-new
    [:textarea {:placeholder "New Post..."}]
    [:div.post-area-extras
     [:span.post-area-remaining 140]
     [:button.undo-unicode.disabled {:disabled "disabled"} "undo"]
     [:button.post-submit.disabled {:disabled "disabled"} "post"]]]])

(defn loading-roller []
  [:div.loading-roller [:div]])

(defn refresh-button
  ([] [:a.refresh.label "Refresh"])
  ;; optional argument: string of extra classes to append
  ([class-string] [:a.refresh.label {:class class-string }"Refresh"]))

(defn user-photo
  ([] [:img.twister-user-photo
        {:src "img/grayed_avatar_placeholder_24.png" :alt "user-photo"}])
  ([extra-img-classes-string] [:img.twister-user-photo
                               {:src "img/grayed_avatar_placeholder_24.png"
                                :alt "user-photo"
                                :class extra-img-classes-string}])
  ([extra-img-classes-string photo-url] [:img.twister-user-photo
                                         {:src photo-url :alt "user-photo"
                                          :class extra-img-classes-string}]))

(defn user-photo-link
  ;; default case--no photo url
  ([] [:a.twister-user-name.open-profile-modal
       {:href "#"} (user-photo)])
  ;; extra classes for img element
  ([extra-img-classes-string] [:a.twister-user-name.open-profile-modal
                               {:href "#"}
                               (user-photo extra-img-classes-string)])
  ;; photo url and extra classes
  ([extra-img-classes-string photo-url] [:a.twister-user-name.open-profile-modal
                                         {:href "#"}
                                         (user-photo extra-img-classes-string
                                                     photo-url)]))

(defn search-profile-template []
  [:div#search-profile-template
   [:li
    [:div.mini-profile.info
     (user-photo-link "mini-profile-photo")
      [:span.mini-screen-name "@"]
      [:span.mini-profile-name]]
     [:button.follow "Follow"]]])

(defn who-to-follow-template []
  [:div#who-to-follow-template
   [:div
    [:h3.label "Who to Follow"]
    [:small "."]
    (refresh-button "refresh-user")
    [:small "."]
    [:a.view-all-users {:href "#whotofollow"} "View All"]
    [:ol.follow-suggestions
     ;; follow-suggestion-template here
     ]]
   (loading-roller)])

(defn toptrends-template []
  [:div#toptrends-template
   [:div
    [:h3.label "Top Trends"]
    [:small "."]
    (refresh-button "refresh-toptrends")
    [:ol.toptrends-list]]
   (loading-roller)])

(defn twistday-reminder-template []
  [:div#twistday-reminder-template
   [:div
    [:h3.label "Who's celebrating their Twistday?"]
    [:small "."]
    (refresh-button)
    [:div.current
     [:h4.label "Today's luckies: "]
     [:ol.list
      ;; twistday-reminder-suggestion-template here
      ]]
    [:div.upcoming
     [:h4.label "Upcoming ones: "]
     [:ol.list
      ;; twistday-reminder-suggestion-template here
      ]]]
   (loading-roller)])

(defn twistday-reminder-suggestion-template []
  [:li#twistday-reminder-suggestion-template.twister-user
   [:div.twister-user-photo (user-photo-link)]
   [:div.twister-user-info {:data-screen-name ""}
    [:a.twister-user-name.open-profile-modal {:href "#"}
     [:div.twister-user-full]
     [:div.twister-user-tag]]]
   [:div
    [:span.twisterday]]])

(defn follow-suggestion-template []
  [:li#follow-suggestion-template.twister-user
   [:div (user-photo-link)]
   [:div.twister-user-info {:data-screen-name ""}
    [:a.twister-user-name.open-profile-modal {:href "#"}
     [:span.twister-user-full]
     [:span.twister-user-tag]]
    [:div.bio]
    [:div.followers
     [:span.label "Followed by"]
     [:a.twister-by-user-name.open-profile-modal
      [:span.followed-by]]]
    [:a.twister-user-remove "&times;"]
    [:button.follow "Follow"]]])

(defn expanded-post []
  [:ol.expanded-post])

(defn post-preview-template []
  [:div#post-preview-template
   [:div#post-preview.post-text]])

(defn post-template []
  [:li#post-template.module.post {:data-time ""}
   [:div.post-data {:data-userpost ""
                    :data-content_to_rt ""
                    :data-content_to_sigrt ""
                    :data-screen-name ""
                    :data-id ""
                    :data-text ""
                    :data-text-mentions ""}
    [:div.post-photo(user-photo)]
    [:div.post-info
     [:a.post-info-name.open-profile-modal {:href "#"}]
     [:span.post-info-tag]
     [:a.post-info-time [:span.post-info-sent] [:span]]]
    [:p.post-text]
    [:div.post-context {:style {:display "none"}}]
    [:span.post-expand "Expand"]
    [:div.post-interactions
     [:span.post-reply "Reply"]
     [:span.post-propagate "Retransmit"]
     ;; [:span.post-favorite "Favorite"] one day...
     ]
    [:div.expanded-content {:style {:display "none"}}
     [:ul.post-stats {:style {:display "none"}}
      [:li.stat-count
       [:span.stat-count-value]
       [:span "Retransmits"]]
      [:li.avatar-row
       ;; avatar-row-template here
       ]]
     [:div.preview-container]
     [:div.post-reply-content {:style {:display "block"}}
      (post-area)]
     [:span.show-more.label "Show more in this conversation..."]]]])

(defn post-rt-reference-template []
  [:div.post-rt-reference
   [:div.post-photo (user-photo "avatar")]
   [:div.post-info
    [:a.post-info-name.open-profile-modal {:href "#"}]
    [:span.post-info-tag]
    [:a.post-info-time [:span]]]
   [:p.post-text]])

(defn post-retransmitted-by-template []
  [:div#post-retransmitted-by-template
   [:i.post-retransmited-icon]
   [:span "twisted again by"] [:span]
   [:a.post-re-transmited-by.open-profile-modal {:href ""}]])

(defn msg-user-link-template []
  [:a#msg-user-link-template.open-profile-modal])

(defn external-page-link-template []
  [:a#external-page-link-template {:rel "nofollow" :target "_blank"}])

(defn hashtag-link-template []
  [:a#hashtag-link-template.open-hashtag-modal])

(defn avatar-row-template []
  [:a#avatar-row-template.open-profile-modal {:href ""}
   (user-photo)
   [:span.user-name-tooltip]])

(defn modal-wrapper [modal-content]
  [:div.modal-wrapper
   [:div.modal-header
    [:h3]
    [:span#closeModal.modal-close "&times;"]
    [:span.modal-back "&lt;"]
    [:span.mark-all-as-read]]
   [:div.modal-content modal-content]
   [:div.modal-blackout]])

(defn prompt-wrapper [prompt-content]
  [:div.prompt-wrapper
   [:div.modal-header
    [:h3]
    [:span.modal-close.prompt-close "&times;"]]
   [:div.modal-content prompt-content]])

(defn confirm-popup-template [template-content]
  [:div#confirm-popup-template
   [:div.message template-content]
   [:div.modal-buttons
    [:button.confirm]
    [:button.cancel]]])

(defn retwist-modal-template []
  [:div#retwist-modal-template
   (post-area)
   [:div.modal-buttons
    [:span.switch-mode "Switch to Reply"]]])

(defn reply-modal-template []
  [:div#reply-modal-template
   (post-area)
   [:div.modal-buttons
    [:span.switch-mode "Switch to Retransmit"]]])

(defn direct-messages-template []
  [:div.direct-messages-template
   [:ol.direct-messages-list
    ;; dm-snippet-template here
    ]])

(defn dm-snippet-template []
  [:li#dm-snippet-template.module.post.message
   [:div.post-photo (user-photo)]
   [:div.post-info
    [:a.post-info-name.open-profile-modal {:href "#"}]
    [:span.post-info-tag "@"]
    [:a.post-info-time {:href "#" :title ""}] [:span]]
   [:pp.post-text]])

(defn messages-thread-template []
  [:div.messages-thread-template
   :ol.direct-messages-thread
   ;; dm-chat-template here
   ])

(defn dm-chat-template []
  [:li#dm-chat-template.module.post.message
   (user-photo)
   [:div.post-info
    [:a.post-info-name.open-profile.modal]
    [:a.post-info-time [:span.post-info-sent] [:span]]]
   [:p.post-text]])

(defn dm-form-template []
  [:div.dm-form-template
   [:form.post-area-new.open
    [:textarea {:placeholder "New direct message..."}]
    [:div.post-area.extras
     [:span.post-area-remaining 140]
     [:button.undo-unicode.disabled {:disabled "disabled"} "undo"]
     [:button.dm-submit.disabled
      {:disabled "disabled"
       :title "Direct messages are encrypted; only you and the recipient can read them."}]]]])

(defn group-messages-profile-modal-control-template []
  [:div.group-messages-control.b-buttons
   [:button.new "New group"]
   [:button.join "Join group"]])

(defn group-messages-messages-modal-control-template []
  [:div.group-messages-control.b-buttons
   [:button.profile "Profile"]
   [:button.invite "Invite peers"]
   [:button.leave "Leave group"]
   [:div.invite-form
    [:textarea]
    [:button.disabled {:disabled "disabled"} "Invite"]]])

(defn group-profile-modal-template []
  [:div#group-profile-modal-template
   [:div.profile-card {:data-screen-name ""}
    [:div.profile-card-main
     [:div.profile-bio]]]
   [:div.profile-card-buttons.group-messages.control.b-buttons
    [:button.direct-messages-with-user {:disabled "disabled"} "Messages"]
    [:button.invite {:disabled "disabled"} "Invite peers"]
    [:button.invite {:disabled "disabled"} "Secret Key"]
    [:button.invite {:disabled "disabled"} "Leave group"]
    [:div.invite-form
     [:textarea]
     [:button {:disabled "disabled"} "Invite"]]
    [:div.secret-key]]
   [:div.members]])

(defn group-profile-member-template []
  [:div#group-profile-member-template
   [:div.twister-user
    (user-photo-link)
    [:div.twister-user-info {:data-screen-name ""}
     [:a.twister-user-name.open-profile-modal
      [:span.twister-user-full]
      [:span.twister-user-tag]]
     [:div.bio]]]])

(defn group-messages-new-group-template []
  [:div#group-messages-new-group-template
   [:div.module
    [:div
     [:p.label "Group description"]
     [:textarea.description {:placeholder "Describe group"}]]
    [:div
     [:p.label "Peers to invite"]
     [:textarea.description {:placeholder "Invite someone"}]]
    [:div
     [:button.create {:disabled "disabled"} "Create"]]]])

(defn group-messages-join-group-template []
  [:div#group-messages-join-group-template
   [:div.module
    [:div
     [:p.label "Select group(s)"]
     [:ul.groups-list]]
    [:div [:button.join {:disabled "disabled"} "Join"]]]
   [:div.module
    [:div
     [:p.label "Import secret key"]
     [:input.secret-key-import {:type "textbox"
                                :placeholder "52-character secret"
                                :size 52
                                :rows 1}]]
    [:p.label "With group alias"]
    [:input.username-import {:type "textbox"
                             :placeholder "Type group alias here"
                             :size 16
                             :rows 1}]
    [:button.import-secret-key {:disabled "disabled"} "Import key"]]])

(defn groups-list-item-template []
  [:div#groups-list-item-template
   [:li
    [:input {:type "checkbox"}]
    [:a.twister-user-name.open-profile-modal]
    [:span.description]]])

(defn profile-card []
  [:div.profile-card {:data-screen-name ""}
   [:div.profile-card-main
    (user-photo)
    [:h1.profile-name]
    [:h2.profile-screen-name [:strong "@"]]
    [:div
     [:span.profile-location]
     [:a.profile-url {:rel "nofollow" :target "_blank"}]]
    [:div.profile-bio]
    [:div#msngersw
     [:div#toxbtnwr.profile-extra-contact
      [:a.profile-tox
       [:span.selectable_theme.theme_nin "TOX"]]]
     [:div#bmbtnwr.profile-extra-contact
      [:a.profile-bitmessage
       [:span.selectable_theme.theme_nin "BitMessage"]]]]]
   [:div.twister-user-info
    [:div.clearfix
     [:ul.module.profile-data
      [:li [:a {:href "#"}
            [:span.posts-count "&nbsp;"]
            [:span.label "Posts"]]]
      [:li [:a.open-following-modal {:href "#"}
            [:span.following-count "&nbsp;"]
            [:span.label "Following"]]]
      [:li [:a {:href "#"}
            [:span.followers-count "&nbsp;"]
            [:span.label "Followers"]]]]]
    [:div.profile-card-buttons.b-buttons
     [:button.follow {:href "#"} "Follow"]
     [:button.direct-messages-with-user {:href "#"} "Direct Messages"]
     [:button.mentions-from-user {:href "#"} "Mentions"]]]
   [:div.who-follow]])

(defn profile-modal-template []
  [:div#profile-modal-template
   (profile-card)
   [:div.postboard
    [:h2
     [:span "Posts"]
     [:button.postboard-news {:style {:display "none"}}]]
    [:ol#profile-posts.postboard-posts]]])

(defn hashtag-modal-template []
  [:div#hashtag-modal-template
   [:div.postbaord
    [:h2
     [:span.selectable_theme.theme_original.theme_calm "Posts"]
     [:button.postboard-news {:style {:display "none"}}]]
    [:ol#profile-posts.postboard-posts]
    [:div.postboard-loading {:style {:display "none"}}
     [:div]]]])
  
(defn following-modal-template []
  [:div#following-modal-template
   [:h2 "All users publicly followed by "
    [:span.following-screen-name [:strong "@"]]]
   [:ol
    [:li#following-by-user-template {:style {:display "none"}}
     [:div.mini-following-info {:data-screen-name ""}
      [:a.open-profile-modal {:href "#"}
       (user-photo "mini-profile-photo")
       [:span.mini-following-name "Nobody Yet"]
       [:span.mini-screen-name [:strong.following-screen-name "@"]]]]]]])

(defn following-config-modal-template []
  [:div#following-config-modal-template
   [:div.following-config-modal-content {:data-screen-name ""}
    [:h2
     [:span.following-config-method-message "Which way do you want to follow "]
     [:span.following-screen-name [:strong "@"]]
     ":"]
    [:div.following-config-method-buttons
     [:button.public-following "Public"]
     [:button.public-following.private "Private"]]]])

;; Login

(defn new-user-modal-template []
  [:div#new-user-modal-template
   [:div.warning
    [:div.text
     "A new user was created and it is being propagated to the network."
     "Please do not close this window, this might take a few minutes."]
    [:div.text.emphasis
     "Your secret key is: "
     [:span.secret-key]]
    [:div.text
     "It is highly recommended that you take this time to save your secret key."
     "Print it, do a screenshot, use the camera in your phone or write it down "
     "to a piece of paper."]
    [:div.text
     "The secret key will be needed to use this account from different computers."
     "If you ever lose your secret key (remember: this is alpha software and it may "
     "crash, causing loss of data) your nickname will be locked forever."
     "There is no way to recover a lost key for twister accounts."]
    [:div.text
     "Please wait. The 'OK' button will be shown when process completes."]
    [:div.text
     [:button.login-created-user {:style {:display "none"}} "OK"]]]])
