# ADR-003 — Use PostgreSQL as Primary Database

## Status

Accepted

## Context

Because there are many different database engines, we must analyze them and decide which one is best suited to the specific needs of EventHub.

## Decision

Given that PostgreSQL offers tools that allow for relating, joining, querying, and structuring data, among other options, it has been determined that it is the most adaptable tool and the one that can be best utilized for the system

## Alternatives Considered

- MySQL
- PostgreSQL
- MongoDB
- DynamoDB

## Consequences

### Positive

Using PostgreSQL, rather than other equally capable database engines, gives EventHub a special focus on relational data.

### Negative

Working with a relational focus keeps EventHub from using other data structures that could create a different focus for the platform.
