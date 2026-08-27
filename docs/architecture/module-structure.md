
user/ -> Responsible for user creation, modification, disable, audit and role managment
├── controller/
├── service/
├── repository/
├── model/
└── dto/

company/ -> Responsible for company creation, modification and disable
├── controller/
├── service/
├── repository/
├── model/
└── dto/

contact/ -> Responsible for managing company contacts, contact information, activation status, and contact-company relationships.
├── controller/
├── service/
├── repository/
├── model/
└── dto/

event/ -> Responsible for event creation, modification, publication, cancellation, capacity, scheduling, pricing, and status management.
├── controller/
├── service/
├── repository/
├── model/
└── dto/

reservation/ -> Responsible for reservation creation, confirmation, cancellation and capacity validation.
├── controller/
├── service/
├── repository/
├── model/
└── dto/

payment/ -> Responsible for registering and voiding payments, associating payments with reservations, and calculating payment-related balances.
├── controller/
├── service/
├── repository/
├── model/
└── dto/

audit/ -> Responsible for recording and retrieving relevant platform activity.
├── controller/
├── service/
├── repository/
├── model/
└── dto/

dashboard/ -> Responsible for aggregating information from other modules to provide operational indicators and summaries.
├── controller/
├── service/
├── repository/
├── model/
└── dto/


## Layer Responsibilities

### controller

Receives HTTP requests, validates request format, delegates operations to services, and builds HTTP responses.

Controllers should not contain business rules or direct database access.

### service

Coordinates application use cases and business rules.

Services may communicate with repositories and other services when required, but should not contain HTTP-specific logic.

### repository

Provides access to persistent data.

Repositories should not contain HTTP logic or business workflows.

### model

Represents the core data and domain concepts used by the module.

### dto

Defines data exchanged through application boundaries, especially API requests and responses.

DTOs should not be used as persistent domain objects.
