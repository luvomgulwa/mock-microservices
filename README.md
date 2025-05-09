# Mock Microservices Application

A Spring Boot-based mock implementation of microservices for testing and development purposes. This application simulates five core microservices: Products, Payments, Orders, User Profiles, and Notifications.

## Features

- **RESTful API** for all microservices
- **H2 in-memory database** with web console
- **Swagger UI** for API documentation
- **Spring Data JPA** for data access
- **Actuator endpoints** for monitoring
- **Sample data** initialization
- **Validation** and error handling
- **Transactional** operations

## Microservices Overview

| Service         | Base Path           | Description                          |
|-----------------|---------------------|--------------------------------------|
| Products        | `/api/products`     | Product catalog management           |
| Payments        | `/api/payments`     | Payment processing                   |
| Orders          | `/api/orders`       | Order management                     |
| User Profiles   | `/api/user-profiles`| User account information             |
| Notifications   | `/api/notifications`| User notification system             |

## Technologies

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- Maven

## Getting Started

### Prerequisites

- Java 17 JDK
- Maven 3.6+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/mock-microservices.git
   cd mock-microservices
   ```
2. Run the application:
  ``` bash
  ./mvnw clean spring-boot:run  
  ```
# API Documentation

The application provides interactive API documentation via Swagger UI:
- **Swagger UI**: http://localhost:8080/api/swagger-ui.html

# Database Access

The H2 database console is available at:
http://localhost:8080/api/h2-console

### Connection Details:

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

# Project Structure

    src/
    ├── main/
    │   ├── java/
    │   │   └── com/mock/microservices/
    │   │       ├── config/       # Configuration classes
    │   │       ├── controller/   # REST controllers
    │   │       ├── dto/          # Data transfer objects
    │   │       ├── exception/    # Exception handling
    │   │       ├── model/        # Entity classes
    │   │       ├── repository/   # Data repositories
    │   │       ├── service/      # Business services
    │   │       └── MockMicroservicesApplication.java
    │   └── resources/
    │       ├── application.yml   # Configuration
    │       ├── data.sql          # Initial data
    │       └── logback-spring.xml # Logging config
    └── test/                     # Test classes