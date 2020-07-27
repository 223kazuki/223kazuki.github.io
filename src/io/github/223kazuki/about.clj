(ns io.github.223kazuki.about
  (:require [io.github.223kazuki.common :refer [layout]]))

(defn render [{global-meta :meta posts :entries :as config}]
  (layout config
          [:div.about.fit
           [:p.h1 "About"]
           [:div.clearfix
            [:div.sm-col.sm-col-12.md-col-3
             [:img {:width "100%" :src "/images/me.jpg"}]]
            [:div.sm-col.sm-col-12.md-col-9
             [:ul
              [:li "Kazuki Tsutsumi / 堤 一樹"]
              [:li "Clojure Programmer"]]]]
           [:p.h2 "Career"]
           [:table.col-12
            [:tr
             [:td "Jun / 2019 - Now"]
             [:td "Senior Software Engineer @ Parkside Technologies in San Francisco, CA"]]
            [:tr
             [:td "May / 2017 - Jun / 2019"]
             [:td "Senior System Engineer @ TIS R&D Center Inc. in San Jose, CA"]]
            [:tr
             [:td "Apr / 2012 - May / 2017"]
             [:td "System Engineer @ TIS Inc. in Tokyo, Japan"]]
            [:tr
             [:td "Apr / 2012 - May / 2017"]
             [:td (str "Manager @ Kokugakuin University Sumo Club"
                       " / 國學院大學相撲部監督")]]
            [:tr
             [:td "Apr / 2010 - Mar / 2012"]
             [:td "Tokyo Institute of Technology (Astrophysics)"]]
            [:tr
             [:td.col-3 "Apr / 2006 - Mar / 2010"]
             [:td "Nagoya University (Astronomy)"]]]
           [:p.h2 "SNS"]
           [:ul
            [:li "Twitter: " [:a {:href "//twitter.com/goronao"} "@goronao"]]
            [:li "GitHub: " [:a {:href "//github.com/223kazuki"} "223kazuki"]]
            [:li "Slide Share: " [:a {:href "//www.slideshare.net/ssuser8b0ea4"}
                                  "Kazuki Tsutsumi"]]]
           [:p.h2 "Skills / Interests"]
           [:ul
            [:li "Web Development"]
            [:li "Clojure / ClojureScript"]
            [:li "integrant / duct"]
            [:li "reagent / re-frame"]
            [:li "GraphQL / lacinia"]
            [:li "Datomic"]
            [:li "Metabase / Presto Server"]
            [:li "Java / Kotlin"]
            [:li "JavaScript / TypeScript / React.js"]
            [:li "CI/CD / Drone CI / CircleCI / Github Actions"]
            [:li "Kafka / Kafka Streams Application"]
            [:li "AWS / Terraform"]
            [:li "k8s / kustomize / EKS"]
            [:li "Rust"]
            [:li "Blockchain (Ethereum / Solidity / Web3 / ipfs)"]
            [:li "VR / Unity"]
            [:li "Mobile App Development / Dart / Flutter"]]
           [:p.h2 "Portfolio"]
           [:ul
            [:li [:a {:href "https://meidai-sumo.club/"} "名古屋大学相撲部 Web"]
             " written by ClojureScript / React.js / Terraform"]
            [:li [:a {:href "https://kokugakuinsumo.github.io/"} "國學院大學相撲部 Web"]
             " written by ClojureScript / React.js"]
            [:li [:a {:href "https://ipfs.infura.io/ipfs/QmQEwZsE6qeLjHeTtrcZKiaWiRkHdh5ALssuh6TF3kvNFP"} "ScoopMarket"]
             " : Ethereum Dapp written by ClojureScript / Solidity / Web3.js hosted by ipfs"]]]))
