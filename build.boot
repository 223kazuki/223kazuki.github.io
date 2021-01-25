(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :target-path #{"./public"}
 :dependencies '[[perun "0.5.0-SNAPSHOT"]
                 [hiccup "1.0.5"]
                 [pandeiro/boot-http "0.8.3"]
                 [clj-time "0.15.2"]])

(require '[clojure.string :as str]
         '[io.perun :as perun]
         '[pandeiro.boot-http :refer [serve]])

(task-options!
 perun/markdown   {:out-dir ""}
 perun/render     {:out-dir ""}
 perun/collection {:out-dir ""}
 perun/static     {:out-dir ""}
 perun/tags       {:out-dir "tags"}
 perun/paginate   {:out-dir "pages"}
 perun/assortment {:out-dir "assorts"}
 serve            {:resource-root ""})

(deftask build
  []
  (comp (perun/global-metadata)
        (perun/markdown :md-exts {:tables true})
        (perun/draft)
        (perun/print-meta)
        (perun/slug)
        (perun/ttr)
        (perun/word-count)
        (perun/build-date)
        (perun/gravatar :source-key :author-email :target-key :author-gravatar)
        (perun/render :renderer 'io.github.223kazuki.post/render)
        (perun/collection :renderer 'io.github.223kazuki.index/render :page "index.html")
        (perun/collection :renderer 'io.github.223kazuki.posts/render :page "posts.html")
        (perun/tags :renderer 'io.github.223kazuki.tags/render)
        (perun/paginate :renderer 'io.github.223kazuki.paginate/render)
        (perun/assortment :renderer 'io.github.223kazuki.assortment/render
                          :grouper (fn [entries]
                                     (->> entries
                                          (mapcat (fn [entry]
                                                    (if-let [kws (:keywords entry)]
                                                      (map #(-> [% entry]) (str/split kws #"\s*,\s*"))
                                                      [])))
                                          (reduce (fn [result [kw entry]]
                                                    (let [path (str kw ".html")]
                                                      (-> result
                                                          (update-in [path :entries] conj entry)
                                                          (assoc-in [path :entry :keyword] kw))))
                                                  {}))))
        (perun/static :renderer 'io.github.223kazuki.about/render :page "about.html")
        (perun/inject-scripts :scripts #{"start.js"})
        (perun/sitemap :out-dir "./")
        (perun/rss :description "223 Log" :out-dir "./")
        (perun/atom-feed :filterer :original :out-dir "./")
        (perun/print-meta)
        (target :dir #{"./public"} :no-clean true)
        (notify)))

(deftask dev
  []
  (comp (watch)
        (build)
        (serve)))
