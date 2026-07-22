(ns statute.facts
  "General-law compliance catalog for Oman (OMN) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation), sibling namespace to
  `marketentry.facts` / `culture.facts`.

  Every entry below was confirmed this session by directly fetching
  https://qanoon.om/p/<year>/rd<year><number>/ (Oman's official
  Ministry of Legal Affairs legislation portal, resolvable at
  qanoon.om) and reading the decree's own title line and opening
  promulgation clause. Five decrees, in the order verified:

    - Tender Law: Royal Decree No. 36/2008 (مرسوم سلطاني رقم ٣٦ / ٢٠٠٨
      بإصدار قانون المناقصات), issued 16 Rabi al-Awwal 1429 AH / 24
      March 2008. Article 1 (as read): 'يعمل في شأن المناقصات بأحكام
      القانون المرافق' -- procurement governed by the attached law.
      This is the Tender Board's (PTLC / GSTB, see marketentry.facts)
      own founding statute.
    - Commercial Companies Law: Royal Decree No. 18/2019 (مرسوم سلطاني
      رقم ١٨ / ٢٠١٩ بإصدار قانون الشركات التجارية), issued 8 Jumada
      al-Thani 1440 AH / 13 February 2019, replacing the prior Royal
      Decree No. 4/74.
    - Foreign Capital Investment Law: Royal Decree No. 50/2019 (مرسوم
      سلطاني رقم ٥٠ / ٢٠١٩ بإصدار قانون استثمار رأس المال الأجنبي),
      issued 27 Shawwal 1440 AH / 1 July 2019. Article 1 (as read):
      foreign investment in a permitted activity may be conducted
      'من خلال تملك رأس المال الأجنبي المستثمر بالكامل أو المساهمة
      فيه' -- by owning the invested foreign capital WHOLLY or by
      participating in it. This is the textual basis for citing
      'permits wholly-owned foreign investment in permitted
      activities' below; the law does NOT itself state a bare '100%'
      figure -- that headline number (widely reported in secondary
      commentary on this 2019 reform) is NOT independently confirmed
      in the decree text read this session, so it is deliberately
      NOT asserted as a catalog fact. Sector-by-sector permitted/
      restricted-activity detail is left to the law's own
      implementing regulations (اللائحة التنفيذية, Article 2),
      which were not separately fetched this session -- a disclosed
      gap, not a fabricated one.
    - Value Added Tax Law: Royal Decree No. 121/2020 (مرسوم سلطاني رقم
      ١٢١ / ٢٠٢٠ بإصدار قانون ضريبة القيمة المضافة), issued 24 Safar
      1442 AH / 12 October 2020, introducing a 5% standard VAT rate.
    - Labour Law: Royal Decree No. 53/2023 (مرسوم سلطاني رقم ٥٣ / ٢٠٢٣
      بإصدار قانون العمل), issued 7 Muharram 1445 AH / 25 July 2023,
      replacing the prior labour law. Establishes Omanisation
      (التعمين) employment-ratio requirements for Omani nationals in
      specified occupations/sectors -- the citable Omanisation
      mechanism this catalog names; the specific per-sector quota
      percentages (Nitaqat-style tables) are set by ministerial
      decision under this law and were NOT separately fetched this
      session, so are NOT asserted here -- a disclosed gap.

  Separately confirmed (not itself a `catalog` statute entry, cited
  only in `marketentry.facts`): the Oman Tax Authority's VAT/CR
  cross-check e-service at
  https://tms.taxoman.gov.om/portal/vatin-validation uses the term
  'VATIN' (not 'TIN') for its VAT identification number, and its
  taxoman.gov.om portal states registration with the Tax Authority is
  required 'within (60) days from the beginning of the enterprise or
  the start of the activity, whichever is earlier'.

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"OMN"
   [{:statute/id "omn.royal-decree-36-2008-tender-law"
     :statute/title "Tender Law"
     :statute/jurisdiction "OMN"
     :statute/kind :law
     :statute/law-number "Royal Decree No. 36/2008"
     :statute/url "https://qanoon.om/p/2008/rd2008036/"
     :statute/url-provenance :qanoon-om-official-legislation-portal
     :statute/enacted-date "2008-03-24"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:public-procurement :market-entry}}
    {:statute/id "omn.royal-decree-18-2019-commercial-companies-law"
     :statute/title "Commercial Companies Law"
     :statute/jurisdiction "OMN"
     :statute/kind :law
     :statute/law-number "Royal Decree No. 18/2019"
     :statute/url "https://qanoon.om/p/2019/rd2019018/"
     :statute/url-provenance :qanoon-om-official-legislation-portal
     :statute/enacted-date "2019-02-13"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "omn.royal-decree-50-2019-foreign-capital-investment-law"
     :statute/title "Foreign Capital Investment Law"
     :statute/jurisdiction "OMN"
     :statute/kind :law
     :statute/law-number "Royal Decree No. 50/2019"
     :statute/url "https://qanoon.om/p/2019/rd2019050/"
     :statute/url-provenance :qanoon-om-official-legislation-portal
     :statute/enacted-date "2019-07-01"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:foreign-investment :market-entry}}
    {:statute/id "omn.royal-decree-121-2020-vat-law"
     :statute/title "Value Added Tax Law"
     :statute/jurisdiction "OMN"
     :statute/kind :law
     :statute/law-number "Royal Decree No. 121/2020"
     :statute/url "https://qanoon.om/p/2020/rd2020121/"
     :statute/url-provenance :qanoon-om-official-legislation-portal
     :statute/enacted-date "2020-10-12"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax :vat}}
    {:statute/id "omn.royal-decree-53-2023-labour-law"
     :statute/title "Labour Law"
     :statute/jurisdiction "OMN"
     :statute/kind :law
     :statute/law-number "Royal Decree No. 53/2023"
     :statute/url "https://qanoon.om/p/2023/rd2023053/"
     :statute/url-provenance :qanoon-om-official-legislation-portal
     :statute/enacted-date "2023-07-25"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :omanisation}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-omn statute.facts (ADR-2607141700): "
                 (count (get catalog "OMN")) " Oman entries seeded "
                 "with qanoon.om (Oman Ministry of Legal Affairs) citations. "
                 "Extend `statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
