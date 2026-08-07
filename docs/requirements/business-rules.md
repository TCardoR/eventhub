# Business Rules

## Companies and Contacts

- BR-CCC-001 - Multiple Contacts
A Company can have multiple Contacts

- BR-CCC-002 - Single Conctact
A Contact can only have one Company in the MVP

- BR-CCC-003 - Inactive Companies
An inactive Company cannot generate new Reservations

- BR-CCC-004 - Inactive Contacts
An inactive Contact cannot create new Reservations

## Events

- BR-EVT-001 - Event Capability
Event capability should always be over 0

- BR-EVT-002 - Event Price
Event price cannot be negative

- BR-EVT-003 - Event Dates
The Event end date should never be past the Event start date

- BR-EVT-004 - Event Canceled
An Event that was cancelled could not accept new Reservations

- BR-EVT-005 - Events Published
An Event that was published could not be deleted 

- BR-EVT-006 - Events Canceled History
An Event that was cancelled should remain in history

- BR-EVT-007 - Events Reservations
The reservations could never be deleted, only cancelled

## Reservations

- BR-RES-001 - Reservations Assistence
The quantity of assistants needs to be over 0

- BR-RES-002 - Reservations Capacity
A Reservation could not exceed the available capacity

- BR-RES-003 - Reservations Cancelled
A cancelled Reservation frees capacity

- BR-RES-004 - Confimed Reservations
A confirmed Reservation could not be modified freely

- BR-RES-005 - Reservations History
All cancellations need to remain in the history

- BR-RES-006 - Reservations Delatiom
Reservation could not be deleted, only cancelled

## Payments

- BR-PAY-001 - Payments Value
A Payment should always be over 0

- BR-PAY-002 - Payments Balance
The Payments total should not exceed the Reservation Value, unless it is explicit as a credit balance

- BR-PAY-003 - Payments Deletion
A registered Payment should never be deleted, only withdrawn

- BR-PAY-004 - Reservation Payments
A Reservation could have multiple Payments

- BR-PAY-005 - Reservation Payments Complete
A Reservation is only considered "Paid" when the sum of all Payments covers the total value

## Audit

- BR-ADT-001 - Types of Audit
At least, the following actions should be audited:
    * Creation and modification of Events
    * Confirmation and Cancellation of Reservations
    * Registration and Withdrawal of Payments
    * Activation and Deactivation of Users and Companies
    * Role changes
