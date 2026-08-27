# ADR-003 — Use PostgreSQL as Primary Database

## Status

Accepted

## Context

EventHub manages structured and strongly related information.

Companies have Contacts and Reservations. Reservations belong to Events and may contain multiple Payments. These operations require data integrity, relationships, constraints, transactions, and reporting queries.

The primary database should therefore support reliable transactional operations and relational querying.

## Decision

PostgreSQL will be used as the primary database for the initial EventHub implementation.

Its relational model, ACID transaction support, constraints, joins, indexing, and SQL capabilities fit the structure and consistency requirements of the EventHub domain.

## Alternatives Considered

### MySQL

A valid relational alternative with strong ecosystem support. PostgreSQL was preferred because of its rich SQL capabilities and strong support for complex relational and transactional workloads.

### MongoDB

Provides flexible document-oriented storage, but EventHub's core model contains many relationships and transactional rules that naturally fit a relational database.

### DynamoDB

Provides highly scalable managed NoSQL storage, but requires access patterns to be designed differently and is less convenient for the relational queries required by the initial EventHub domain.

## Consequences

### Positive

- Strong relational integrity.
- ACID transactions.
- Foreign keys and constraints.
- Powerful joins and SQL queries.
- Good support for reporting workloads.
- Mature Java and Spring integration.

### Negative

- Schema changes require controlled migrations.
- Horizontal scaling may require more planning than some distributed NoSQL systems.
- Highly unstructured data may not fit the relational model as naturally.
- PostgreSQL becomes an important infrastructure dependency for the application.
