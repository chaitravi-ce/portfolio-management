# Financial Application REST API

This repository contains a RESTful API for managing trade and user information in a financial application.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Features

- CRUD operations for trades and users
- Associating trades and stocks with users
- Partial updates for trades and users

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- MySQL server
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Spnetic-5/portfolio-management.git
   cd portfolio-management/backend
   ```
 
2. Configure the database settings in src/main/resources/application.properties.


    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/"db_name"
    spring.datasource.username="username"
    spring.datasource.password="password"
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=create
    ```

3. Build and run the application:

The application will be accessible at http://localhost:8080

### API Endpoints

#### Trades

* `GET /trades:` Get a list of all trades.
* `POST /trades:` Add a new trade.
* `PUT /trades/{id}:` Update a trade by ID.
* `PATCH /trades/{id}:` Partially update a trade by ID.

#### Users

* `GET /users:` Get a list of all users.
* `GET /users/{id}/trades:` Get trades associated with a user.
* `POST /users:` Add a new user.
* `POST /users/add-trades/{id}:` Add a trade to a user's history.
* `PUT /users/{id}:` Update a user by ID.
* `PATCH /users/{id}:` Partially update a user by ID.
* `DELETE /users/{id}:` Delete a user by ID.