# System Overview

## Purpose

EventHub is a backend platform designed to manage companies, contacts, events, reservations, payments, and audit records through a REST API.

## Architectural Style

EventHub will start out as a modular monolith with a layered architecture. It won’t jump straight into Hexagonal or full Clean Architecture, instend, it will start with a focus in:
    * responsibilities;
    * dependencies;
    * domain;
    * services;
    * persistence;
    * REST API.
Later on, it’ll be refactored  toward Clean Architecture and Hexagonal.

## Main Components

- **User Management:** manages users, roles, authentication-related data, and account status.
- **Company and Contact Management:** manages client companies and their associated contacts.
- **Event Management:** manages event creation, publication, scheduling, capacity, pricing, and status.
- **Reservation Management:** manages reservations, attendee quantities, confirmation, cancellation, and capacity checks.
- **Payment Management:** records payments associated with reservations and calculates outstanding balances.
- **Audit:** records important actions performed in the platform.
- **Dashboard:** provides aggregated information and operational indicators.

## Request Flow

Client
    → REST Controller
        → Service
            → Repository
                → PostgreSQL

## Persistence

PostgreSQL will be the primary data store for EventHub.

The platform contains highly related information such as companies, contacts, events, reservations, and payments. These relationships require reliable transactions, constraints, joins, and consistent data management.

PostgreSQL provides the relational and transactional capabilities required by the initial EventHub domain.

## Security

EventHub will initially use JWT-based authentication and role-based authorization.

Users will authenticate before accessing protected resources, and permissions will depend on their assigned role, such as Administrator, Organizer, or Customer.

## Future Evolution

The initial architecture is intentionally simple but modular.

If the platform grows in complexity, selected modules could later be separated behind clearer interfaces or extracted into independent services when there is a concrete operational or scalability reason.

The layered structure may also evolve toward Hexagonal Architecture by introducing ports and adapters around domain and application logic.
