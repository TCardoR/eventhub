# ADR-002 — Use a Layered Architecture

## Status

Accepted

## Context

As part of constructing the project's Architecture, various options emerged that were entirely valid.

## Decision

Thinking about the different options available, it's decided that it will use a Layered Architecture, which means that the architecture flow would be something like: Controller → Service → Repository.

## Alternatives Considered

- Hexagonal Architecture
- Clean Architecture
- Layered Architecture

## Consequences

### Positive

Working with a simple, clear architecture from the beginning of the project has made the workflow easier.

### Negative

In the future, the work architecture will change, so its gonna be a difficult transition from one architecture to another.
