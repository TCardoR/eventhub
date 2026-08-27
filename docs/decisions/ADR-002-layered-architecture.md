# ADR-002 — Use a Layered Architecture

## Status

Accepted

## Context

EventHub needs a clear separation between HTTP communication, business operations, and data persistence.

Without explicit boundaries, controllers could contain business rules and database logic, making the system harder to understand, test, and maintain.

## Decision

EventHub will initially use a layered architecture with the following main flow:

Controller → Service → Repository

The Controller layer will handle HTTP communication.

The Service layer will coordinate use cases and business rules.

The Repository layer will abstract access to persistent data.

## Alternatives Considered

- Hexagonal Architecture
- Clean Architecture
- Layered Architecture

## Consequences

### Positive

- Clear separation of responsibilities.
- Easy to understand for the initial system size.
- Supports unit and integration testing.
- Keeps HTTP and persistence concerns separate from application workflows.

### Negative

- Domain logic can become overly concentrated in Service classes.
- Business code may become coupled to Spring or persistence technologies if boundaries are not respected.
- Complex use cases can make the layered model rigid over time.

### Future Evolution

The architecture may later evolve toward Hexagonal Architecture by defining
explicit application and domain ports and moving Spring, HTTP, and persistence
details behind adapters.
