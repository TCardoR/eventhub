
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

contact/ ->
├── controller/
├── service/
├── repository/
├── model/
└── dto/

event/ ->
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

payment/ ->
├── controller/
├── service/
├── repository/
├── model/
└── dto/

audit/ ->
├── controller/
├── service/
├── repository/
├── model/
└── dto/

dashboard/ ->
├── controller/
├── service/
├── repository/
├── model/
└── dto/


## Module Definition

* controller:
Receives HTTP requests and returns HTTP responses.

* service:
Coordinates use cases and business rules.

* repository:
Provides access to persistent data.

* model:
Contains domain-related data structures.

* dto:
Defines input and output structures used by the API.
