# ADR-001 — Use a Modular Monolith

## Status

Accepted

## Context

EventHub initially contains a limited number of closely related business capabilities, including companies, contacts, events, reservations, payments, and audit records.

These capabilities frequently interact with each other and require consistent business operations. At the current scale, deploying and operating several independent services would introduce additional infrastructure and distributed system complexity without providing a clear product benefit.

## Decision

EventHub will initially be implemented as a modular monolith.

The application will be deployed as a single unit while keeping business capabilities separated into explicit modules such as users, companies, events, reservations, and payments.

Modules should communicate through clear boundaries so that internal coupling remains controlled.

## Alternatives Considered

- Traditional monolith
- Microservices
- Modular monolith

## Consequences

### Positive

- Simpler deployment and operation.
- Easier transactional consistency between related modules.
- Lower infrastructure and observability complexity.
- Business capabilities can still remain explicitly separated.
- Well-defined modules can make future service extraction easier if required.

### Negative

- All modules share the same deployment lifecycle.
- Poorly enforced module boundaries could cause excessive coupling.
- Scaling one specific capability independently is harder than with separate services.
- Future extraction of a module may require additional refactoring.
