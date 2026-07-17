(ns culture.facts
  "Country-level regional-culture catalog for Oman (OMN) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"OMN"
   [{:culture/id "omn.dish.mashuai"
     :culture/name "Mashuai"
     :culture/country "OMN"
     :culture/kind :dish
     :culture/summary "Whole spit-roasted kingfish dish in Omani cuisine, served with a side of lemon rice."
     :culture/url "https://en.wikipedia.org/wiki/Omani_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.dish.shuwaa"
     :culture/name "Shuwaa"
     :culture/country "OMN"
     :culture/kind :dish
     :culture/summary "Omani dish of chunks of goat, sheep, cow, or camel meat marinated in a spicy date paste and roasted."
     :culture/url "https://en.wikipedia.org/wiki/Omani_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.dish.machboos"
     :culture/name "Machboos"
     :culture/country "OMN"
     :culture/kind :dish
     :culture/summary "Rice dish in Omani cuisine, sometimes flavored with saffron and cooked in the same water the chicken or meat was cooked in."
     :culture/url "https://en.wikipedia.org/wiki/Omani_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.dish.omani-halwa"
     :culture/name "Omani Halwa"
     :culture/country "OMN"
     :culture/kind :dish
     :culture/summary "Sweet traditionally served alongside Omani coffee (kahwa) and dates in Oman."
     :culture/url "https://en.wikipedia.org/wiki/Omani_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.beverage.kahwa"
     :culture/name "Kahwa"
     :culture/country "OMN"
     :culture/kind :beverage
     :culture/summary "Omani coffee mixed with cardamom powder, often served as a symbol of hospitality, typically with dates and Omani halwa."
     :culture/url "https://en.wikipedia.org/wiki/Omani_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.product.frankincense"
     :culture/name "Frankincense"
     :culture/country "OMN"
     :culture/kind :product
     :culture/summary "Aromatic resin from Boswellia trees; grows in Dhofar, Oman, north of Salalah, and was traded through the ancient ports of Sumhuram (Khor Rori) and Al-Baleed."
     :culture/url "https://en.wikipedia.org/wiki/Frankincense"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.craft.khanjar"
     :culture/name "Khanjar"
     :culture/country "OMN"
     :culture/kind :craft
     :culture/summary "Traditional dagger originating from the Sultanate of Oman; a national symbol featured on Oman's national emblem and on the Omani rial."
     :culture/url "https://en.wikipedia.org/wiki/Khanjar"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "omn.heritage.bahla-fort"
     :culture/name "Bahla Fort"
     :culture/country "OMN"
     :culture/kind :heritage
     :culture/summary "One of four historic fortresses at the foot of the Jebel Akhdar highlands in Oman; Oman's first UNESCO World Heritage-listed fort, added in 1987."
     :culture/url "https://en.wikipedia.org/wiki/Bahla_Fort"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-omn culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "OMN"))
                 " OMN entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
