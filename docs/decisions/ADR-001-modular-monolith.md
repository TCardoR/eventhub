# ADR-001 — Use a Modular Monolith

## Status

Accepted

## Context

As part of the conception of this project, part of the initial idea was to use microservices from the beginning of the project.

## Decision

Given that EventHub is initially intended to be a relatively small system, the goal is to perform a single deployment, and we want to avoid unnecessary initial complications; therefore, it has been decided that microservices will not be used initially.

## Alternatives Considered

- Traditional monolith
- Microservices
- Modular monolith

## Consequences

### Positive

This decision will make it possible to create a clean platform free of initial complications.

### Negative

The moment it's decided that microservices are a good option, a module by module extraction will be necessary.
