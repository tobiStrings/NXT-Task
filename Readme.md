# NXT Java Backend Task
## Overview 
This project is a task from NXT to implement a flexible coupon system for an e-commerce website

## Table of Contents

- [Project Name](#project-name)
    - [Overview](#overview)
    - [Table of Contents](#table-of-contents)
    - [Installation](#installation)
    - [Usage](#usage)
    - [Features](#features)
    - [Technologies Used](#technologies-used)
    - [Contributing](#contributing)
    - [License](#license)
    - [Acknowledgements](#acknowledgements)

## Installations
To install and run this project locally, follow these steps:
1. Clone the repository:    
    git clone

## Usage
Once the project is installed and running, you can perform the following actions:

####  Access Endpoints

* Once the application is running, you can access the API endpoints using tools like cURL, Postman, or any web browser.
* Example endpoints:
  * Fetch Cart:  `GET http://localhost:8080/api/v1/cart/`
  * Add to Cart `PUT http://localhost:8080/api/v1/cart/add/`
  * Apply Coupon  `GET http://localhost:8080/api/v1/coupon/`
  * Add coupon `POST http://localhost:8080/api/v1/coupon/add`


## Features

## Technologies Used
#### Programming language
* Java 17
#### Frameworks and library 
* Spring Boot 3.2.4
  * spring-boot-starter-data-jdbc
  * spring-boot-starter-data-jpa
  * spring-boot-starter-web
#####

* Lombok (for reducing boilerplate code)
#####

* Flyway (for database migrations)
  * flyway-core 10.11.0
  * flyway-database-postgresql 10.11.0

#####

* Jakarta Validation API
  * jakarta.validation-api 3.0.2

#####
* Hibernate Validator
  * hibernate-validator 6.2.0.Final

#####
* Database
  * PostgreSQL (as the database management system)

#####

* Testing
  * JUnit 5 (for unit testing)
  * Spring Boot Test Starter (for integration testing)
  
####
* Build and Dependency Management
  * Gradle 7.x


## Contributing
To contribute to this project, follow these steps:
1. Fork the repository
2. Create a new branch (git checkout -b feature/your-feature)
3. Make your changes
4. Commit your changes (git commit -am 'Add new feature')
5. Push to the branch (git push origin feature/your-feature)
6. Create a new Pull Request# NXT-Task
