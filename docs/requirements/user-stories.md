# User Stories

## US-COM-001 — Register a company

**As an** administrator  
**I want to** register a company  
**So that** contacts and reservations can be associated with it.

### Acceptance Criteria

- The company name is required.
- The external identification must be unique when provided.
- A newly created company is active by default.

---

## US-CON-001 Register a contact

**As an** administrator  
**I want to** register a contact  
**So that** companies can have points of main contact.

### Acceptance Criteria

- Company must be created
- Contact name and communication method (email, phone, or other) are required
- All companies should have at least one contact

---

## US-EVT-001 Create an event

**As an** organicer  
**I want to** create an event with a date, capacity, and price  
**So that** I can offer it to the clients.

### Acceptance Criteria

- Name is mandatory
- Capacity should be over 0
- Price cannot be negative
- End Date must be later than Start Date
- Event is created initially as a draft

---

## US-EVT-002 Publish an event

**As an** organicer  
**I want to** publish an event so companies can make room in it  
**So that** events make the most earnings.

### Acceptance Criteria

- Event capacity should be established
- Companies should be able to have the ability to make reservations
- Companies must be aware of the moment it reaches the Publish status

---

## US-RES-001 Create a reservation

**As an** organicer  
**I want to** register a new reserve for an event  
**So that** I can offer room for a related company.

### Acceptance Criteria

- Company and contact should be active
- Event should accept reservations
- Quantity should be positive
- There should be enough capacity
- Reservation is created at the beginning with the pending status

---

## US-RES-002 Confirm a reservation

**As an** organicer  
**I want to** confirm a new reservation   
**So that** I can manage the capacity and audit the event.

### Acceptance Criteria

- A reservation should be paid for so it's confirmed
- An empty Reservation cannot be confirmed

---

## US-RES-003 Cancel a reservation

**As an** organicer  
**I want to** cancel a reservation   
**So that** more room is avalible for the event.

### Acceptance Criteria

- A reservation that was already paid cannot be cancelled in normal circumstances; only the administrator can analyze the case and decide
- Only the owner of the reservation can cancel his own reservation
- A reservation that has already passed the event date cannot be cancelled

---

## US-PAY-001 Register a payment

**As an** organicer  
**I want to** register a new payment for a reserve  
**So that** I can control the outstanding balance.

### Acceptance Criteria

- Reserve should exist
- Reserve value should be positive
- The date must be registered
- The balance is recalculated after the payment

---

## US-PAY-002 Void a payment

**As an** administrator  
**I want to** annul a payment that could be the total of a reservation or only a partial payment
**So that** reservation balace can be adjusted to the real final event balace.

### Acceptance Criteria

- A payment cannot be cancelled, only voided
- Even though the organizers can register a new payment, they cannot void one
- The correct process of action in a case of voiding a payment is decided in every case by the administrator.

---

## US-AUD-001 Consult audit history

**As an** administrator  
**I want to** consult audit history of past, present and future event
**So that** I can decide the correct decisions, manage process and find holes in the process.

### Acceptance Criteria

- Only administrators can have the option to consult an audit
- Audit history could contain information about the entire platform (reservations, events, companies, payments, etc)
