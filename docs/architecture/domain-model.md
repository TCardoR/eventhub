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

- 

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

Belongs to one Company.
Can be associated with multiple Reservations.

### Important Rules

- Contact phoneNumber and email should be valid

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

- attendeeQuantity must be greater than zero.
- It should not be over de event quatity.
- company and contact should be active
- The event should be valid
- Cancel a reservation open event capacity
- totalAmount must be greater than zero.

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

Belongs to one Reservation.

### Important Rules

- 

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

Belongs to one User.
References an affected entity through entityType and entityId.

### Important Rules

- 
