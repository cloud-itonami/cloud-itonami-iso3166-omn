(ns marketentry.facts
  "Oman market-entry catalog.

  Owner authority, e-tendering platform and legal basis confirmed this
  session by directly fetching and reading:
    - https://www.gov.om/entities -> `/general-secretariat-of-the-tender-board`
      resolves to https://www.ptlc.gov.om/ (SharePoint webparts titled
      'Tender_Board_Branding'), i.e. the Tender Board's secretariat is the
      Projects, Tenders and Local Content Authority (PTLC) / General
      Secretariat of the Tender Board (GSTB).
    - https://www.ptlc.gov.om/en/Pages/default.aspx -> names the e-tendering
      system 'Esnad' at https://etendering.tenderboard.gov.om/product/publicDash
      (confirmed reachable, HTTP 200).
    - https://qanoon.om/p/2008/rd2008036/ -> Royal Decree No. 36/2008
      'promulgating the Tender Law' (مرسوم سلطاني رقم ٣٦ / ٢٠٠٨ بإصدار قانون
      المناقصات), Article 1: procurement is governed by the attached law.
    - https://www.business.gov.om/ -> redirects (5 hops) to
      '.../ieasy/wp/en/', <title>Oman Business Platform – e-Services</title>,
      body text 'See your CR notifications which were sent from Invest Easy' --
      Invest Easy is the Commercial Registration (CR) e-service, operated
      under the Ministry of Commerce, Industry and Investment Promotion
      (MOCIIP, وزارة التجارة والصناعة وترويج الاستثمار per
      https://www.gov.om/ministry-of-commerce-industry-and-investment-promotion).
    - https://tms.taxoman.gov.om/portal/vatin-validation -> an independent
      CR/tax-number verification e-service ('Choose Verification Method
      VATIN | TAX CARD | CR_NUMBER'), the honest basis for the
      `corporate-number` check below.

  `tenderboard.gov.om` and `www.tenderboard.gov.om` (bare/www) do NOT
  resolve (DNS NXDOMAIN, checked directly) -- only the `etendering.`
  subdomain is live. Do not cite the bare domain."
  )

(def catalog
  {"OMN" {:name "Sultanate of Oman"
          :owner-authority "Projects, Tenders and Local Content Authority (PTLC) / General Secretariat of the Tender Board"
          :legal-basis "Tender Law (Royal Decree No. 36/2008)"
          :national-spec "Esnad e-tendering + Invest Easy Commercial Registration (CR)"
          :provenance "https://www.ptlc.gov.om/"
          :required-evidence ["CR number record" "Invest Easy CR registration record" "CR extract" "Authorized-representative record"]
          :rep-owner-authority "Ministry of Commerce, Industry and Investment Promotion (MOCIIP) / Invest Easy"
          :rep-legal-basis "Omani Commercial Registration (CR) via Invest Easy typically required for Esnad supplier/tenderer registration"
          :rep-provenance "https://www.business.gov.om/"
          :corporate-number-owner-authority "MOCIIP / Oman Tax Authority"
          :corporate-number-legal-basis "Commercial Registration (CR) number, independently checkable via the Tax Authority's VATIN/CR verification e-service"
          :corporate-number-provenance "https://tms.taxoman.gov.om/portal/vatin-validation"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR" :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "ARE" {:name "UAE" :owner-authority "Federal e-procurement" :legal-basis "Federal procurement" :national-spec "e-procurement" :provenance "https://www.mof.gov.ae/"
          :required-evidence ["Trade license" "e-procurement registration" "License extract" "Authorized-representative record"]}
   "SAU" {:name "Saudi Arabia" :owner-authority "Etimad" :legal-basis "GTPL" :national-spec "Etimad" :provenance "https://tenders.etimad.sa/"
          :required-evidence ["CR number" "Etimad registration" "CR extract" "Authorized-representative record"]}
   "QAT" {:name "Qatar" :owner-authority "Ministry of Finance / Government Procurement Portal" :legal-basis "Tenders and Auctions Law" :national-spec "e-procurement + commercial registration" :provenance "https://www.mof.gov.qa/"
          :required-evidence ["CR number record" "e-procurement registration record" "CR extract" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
