# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Oman

## Classification

- Repository: `cloud-itonami-iso3166-omn`
- ISO 3166: `OMN` (Oman)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:omani-sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on an Omani
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Oman for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation and
  now needs public-sector market access

## Offer

- registration walkthrough for Esnad, the e-tendering platform of the
  Projects, Tenders and Local Content Authority (PTLC) / General
  Secretariat of the Tender Board (https://www.ptlc.gov.om/,
  https://etendering.tenderboard.gov.om/)
- business/tax registration checklist: Commercial Registration (CR) via
  Invest Easy (business.gov.om) under the Ministry of Commerce,
  Industry and Investment Promotion (MOCIIP); VAT registration with
  the Oman Tax Authority where the taxable-turnover threshold is met
  (Value Added Tax Law, Royal Decree No. 121/2020)
- foreign-ownership navigation under the Foreign Capital Investment Law
  (Royal Decree No. 50/2019), which permits wholly-owned foreign
  investment in permitted activities (Article 6) — the client's actual
  permitted-activity classification and any implementing-regulation
  detail beyond the law's own text is NOT asserted here and routes to
  Omani-licensed counsel
- Omanisation (التعمين) workforce-nationalization navigation under the
  Labour Law (Royal Decree No. 53/2023) for qualifying contracts
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Omani-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented — see `src/marketentry/facts.cljc` and
  `src/statute/facts.cljc` for the exact URLs fetched and read this
  session, and their docstrings for gaps disclosed rather than filled
  in with an invented figure (e.g. no bare "100%" foreign-ownership
  number is asserted, only the law's own "wholly or by participation"
  text; no per-sector Omanisation quota percentages are asserted)

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Oman).
