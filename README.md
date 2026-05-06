# apex-plat-compose-mesh

`apex-plat-compose-mesh` explores platform engineering with a small Java codebase and local fixtures. The technical goal is to package a Java local lab for compose analysis with deny and allow fixtures, explainable decision traces, and documented operating limits.

## Purpose

The point is to make a small domain rule concrete enough that a reader can change it and immediately see what broke.

## Apex Plat Compose Mesh Review Notes

Start with `route drift` and `rollout width`. Those cases create the widest score spread in this repo, so they are the best quick check when the model changes.

## What Is Covered

- `fixtures/domain_review.csv` adds cases for rollout width and quota pressure.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/apex-plat-compose-walkthrough.md` walks through the case spread.
- The Java code includes a review path for `route drift` and `rollout width`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Implementation Notes

The core code exposes a scoring path and the added review layer uses `signal`, `slack`, `drag`, and `confidence`. The domain terms are `rollout width`, `quota pressure`, `route drift`, and `secret scope`.

The Java implementation avoids hidden state so fixture changes are easy to reason about.

## Command

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Audit Path

The check exercises the source code and the review fixture. `edge` is the high score at 214; `baseline` is the low score at 89.

## Limits

The fixture set is small enough to audit by hand. The next useful expansion is malformed input coverage, not extra surface area.
