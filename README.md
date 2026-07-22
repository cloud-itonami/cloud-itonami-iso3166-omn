# cloud-itonami-iso3166-omn

**`:implemented`** for **OMN**. Flagship `om-entity-missing`, tax `cr-unverified`.

```
clojure -M:dev:test
```

## Market-entry / statute catalogs

- Tender Board: Projects, Tenders and Local Content Authority (PTLC) /
  General Secretariat of the Tender Board, e-tendering system "Esnad"
  (https://www.ptlc.gov.om/, https://etendering.tenderboard.gov.om/).
  Legal basis: Tender Law, Royal Decree No. 36/2008.
- Commercial Registration: Invest Easy (business.gov.om), operated
  under the Ministry of Commerce, Industry and Investment Promotion
  (MOCIIP).
- Foreign investment: Foreign Capital Investment Law, Royal Decree No.
  50/2019 (permits wholly-owned foreign investment in permitted
  activities, Article 6).
- Tax: Oman Tax Authority (taxoman.gov.om); Value Added Tax Law, Royal
  Decree No. 121/2020 (5% standard rate); VATIN/CR cross-check
  e-service at tms.taxoman.gov.om/portal/vatin-validation.
- Labor: Labour Law, Royal Decree No. 53/2023, including Omanisation
  (التعمين) workforce-nationalization requirements.

Every citation above was fetched and read directly this session (see
`src/marketentry/facts.cljc` and `src/statute/facts.cljc` docstrings
for exact URLs and verbatim confirmation). Gaps that could not be
independently confirmed (e.g. a specific "100%" foreign-ownership
figure, or per-sector Omanisation quota percentages) are disclosed in
`src/statute/facts.cljc`, not filled in with an invented number.

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Oman:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
