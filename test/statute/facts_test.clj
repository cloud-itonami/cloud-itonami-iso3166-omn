(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest omn-has-spec-basis
  (let [sb (facts/spec-basis "OMN")]
    (is (= 5 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["OMN" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["omn.royal-decree-53-2023-labour-law"]
         (mapv :statute/id (facts/by-topic "OMN" :omanisation))))
  (is (= ["omn.royal-decree-50-2019-foreign-capital-investment-law"]
         (mapv :statute/id (facts/by-topic "OMN" :foreign-investment))))
  (is (empty? (facts/by-topic "OMN" :data-protection)))
  (is (empty? (facts/by-topic "ATL" :tax))))
