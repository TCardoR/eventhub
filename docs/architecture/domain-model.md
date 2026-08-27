## User

### Responsibility

Represents an user that will be using the platform.

### Main Attributes

- id
- name
- email
- password
- active
- role
- createdAt
- updatedAt

### Relationships

- Has many AditLogs.

### Important Rules

- email and password are mandatory.

---

## Role

### Responsibility

Represents a role in the system.

### Main Attributes

- id
- name

### Relationships

- Has many Users.

### Important Rules

- Name can't be empty.

---

## Company

### Responsibility

Represents a company in the platform.

### Main Attributes

- id
- name
- externalIdentification
- active
- createdAt
- updatedAt

### Relationships

- Has many Conctacts.
- Has many Reservations

### Important Rules

- An inactive Company cannot create new Reservations.
- A Company can have multiple Contacts.
- A Company can have multiple Reservations.

---

## Contact

### Responsibility

Represents a contact of a company in the platform.

### Main Attributes

- id
- company
- name
- email
- phone
- active
- createdAt
- updatedAt

### Relationships

- Belongs to one Company.
- Can be associated with multiple Reservations.

### Important Rules

- A Contact belongs to one Company in the MVP.
- An inactive Contact cannot create new Reservations.
- Contact communication information must be valid when provided.

---

## Event

### Responsibility

Represents an event managed by the platform.

### Main Attributes

- id
- name
- description
- location
- startDateTime
- endDateTime
- capacity
- price
- status
- createdAt
- updatedAt

### Relationships

- Has many Reservations.

### Important Rules

- Capacity must be greater than zero.
- End date must be after start date.

---

## Reservation

### Responsibility

Represents a reservation for an event in the platform.

### Main Attributes

- id
- company
- contact
- event
- attendeeQuantity
- status
- totalAmount
- createdAt
- updatedAt

### Relationships

- Has many Payments.

### Important Rules

- Attendee quantity must be greater than zero.
- A Reservation cannot exceed the Event's available capacity.
- The associated Company and Contact must be active when the Reservation is created.
- The Event must accept new Reservations.
- Cancelling a Reservation releases its occupied capacity.
- Reservations are not physically deleted; they are cancelled.

---

## Payment

### Responsibility

Represents a payment of a reservation in the platform.

### Main Attributes

- id
- reservation
- amount
- paymentDate
- reference
- status
- createdAt

### Relationships

- Belongs to one Reservation.

### Important Rules

- Payment amount must be greater than zero.
- A Reservation can have multiple Payments.
- Valid Payments should not exceed the Reservation total unless credit balance handling is explicitly supported.
- Registered Payments are not physically deleted; they can be voided.

---

## AuditLog

### Responsibility

Represents a Audit in the platform.

### Main Attributes

- id
- user
- entityType
- entityId
- action
- details
- createdAt

### Relationships

- Belongs to one User.
- References an affected entity through `entityType` and `entityId`.

### Important Rules

- Important business actions must generate an audit record.
- Audit records represent actions that have already occurred.
- Audit records should preserve the acting User, action, affected entity, and timestamp.
