
# Hotel Rating System

## Overview
The Hotel Rating System is a Spring Boot microservices-based application that allows users to rate hotels and retrieve ratings. The system is composed of multiple microservices that manage users, hotels, and ratings, offering a scalable solution for hotel rating management.

## Features
- **CRUD Operations**: Manage users, hotels, and ratings with Create, Read, Update, and Delete functionalities.
- **Service Discovery**: Use Eureka Server for service registration and discovery.
- **Fault Tolerance**: Implemented with Resilience4j for Circuit Breaker, Rate Limiter, and Retry mechanisms.
- **API Gateway**: Centralized gateway for routing requests to respective services.

## Prerequisites
- **Java 17**: Required for building and running the application.
- **Maven**: Used for building the project.

## Getting Started

### Cloning the Repository
Clone the repository:

```bash
  git clone https://https://github.com/AnushkaHere/HotelRatingSystem.git
```
```bash
  cd HotelRatingSystem
```
### Running the Application
Run each microservice in separate terminals using:

```bash
  mvn spring-boot:run
```
Ensure the Config Server and Service Registry are up and running before starting the other services.

### Accessing the Application
- **Eureka Dashboard**: `http://localhost:8761`
- **Config Server**: `http://localhost:8088`
- **API Gateway**: `http://localhost:9191`
- **User Service**: `http://localhost:8080/v1/users`
- **Hotel Service**: `http://localhost:8081/v1/hotels`
- **Rating Service**: `http://localhost:8082/v1/ratings`

## Directory Structure

```
  C:.
├───api-gateway
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───hotel
│   │   │   │           └───rating
│   │   │   └───resources
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───hotel
│   │                   └───rating
│   └───target
│       ├───classes
│       │   └───com
│       │       └───hotel
│       │           └───rating
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───hotel
│                   └───rating
├───config-server
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───hotel
│   │   │   │           └───rating
│   │   │   └───resources
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───hotel
│   │                   └───rating
│   └───target
│       ├───classes
│       │   └───com
│       │       └───hotel
│       │           └───rating
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───hotel
│                   └───rating
├───hotel-service
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───hotel
│   │   │   │           └───rating
│   │   │   │               ├───config
│   │   │   │               ├───controller
│   │   │   │               ├───entity
│   │   │   │               ├───exception
│   │   │   │               ├───payload
│   │   │   │               ├───repository
│   │   │   │               └───service
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───hotel
│   │                   └───rating
│   └───target
│       ├───classes
│       │   └───com
│       │       └───hotel
│       │           └───rating
│       │               ├───config
│       │               ├───controller
│       │               ├───entity
│       │               ├───exception
│       │               ├───payload
│       │               ├───repository
│       │               └───service
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───hotel
│                   └───rating
├───rating-service
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───hotel
│   │   │   │           └───rating
│   │   │   │               ├───config
│   │   │   │               ├───controller
│   │   │   │               ├───entity
│   │   │   │               ├───exception
│   │   │   │               ├───payload
│   │   │   │               ├───repository
│   │   │   │               └───service
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───hotel
│   │                   └───rating
│   └───target
│       ├───classes
│       │   └───com
│       │       └───hotel
│       │           └───rating
│       │               ├───config
│       │               ├───controller
│       │               ├───entity
│       │               ├───exception
│       │               ├───payload
│       │               ├───repository
│       │               └───service
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───hotel
│                   └───rating
├───service-registry
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───hotel
│   │   │   │           └───rating
│   │   │   └───resources
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───hotel
│   │                   └───rating
│   └───target
│       ├───classes
│       │   └───com
│       │       └───hotel
│       │           └───rating
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───hotel
│                   └───rating
└───user-service
    ├───.idea
    ├───.mvn
    │   └───wrapper
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───hotel
    │   │   │           └───rating
    │   │   │               ├───controller
    │   │   │               ├───entity
    │   │   │               ├───exception
    │   │   │               ├───payload
    │   │   │               ├───repository
    │   │   │               └───service
    │   │   └───resources
    │   │       ├───static
    │   │       └───templates
    │   └───test
    │       └───java
    │           └───com
    │               └───hotel
    │                   └───rating
    └───target
        ├───classes
        │   └───com
        │       └───hotel
        │           └───rating
        │               ├───controller
        │               ├───entity
        │               ├───exception
        │               ├───payload
        │               ├───repository
        │               └───service
        ├───generated-sources
        │   └───annotations
        ├───generated-test-sources
        │   └───test-annotations
        └───test-classes
            └───com
                └───hotel
                    └───rating

```

## Microservices
The project includes the following microservices:

### API Gateway
Routes requests to appropriate microservices.

- **Main Class**: `ApiGatewayApplication.java`
- **Port**: `9191`

### Config Server
Manages configuration properties for all microservices.

- **Main Class**: `ConfigServerApplication.java`
- **Port**: `8088`

### Service Registry
Eureka Server for service discovery.

- **Main Class**: `ServiceRegistryApplication.java`
- **Port**: `8761`

### User Service
Manages users and fetches associated ratings and hotels.

- **Main Class**: `UserServiceApplication.java`
- **Port**: `8080`

### Hotel Service
Manages hotel information.

- **Main Class**: `HotelServiceApplication.java`
- **Port**: `8081`

### Rating Service
Manages ratings provided by users for hotels.

- **Main Class**: `RatingServiceApplication.java`
- **Port**: `8082`

## Service Implementations

### Hotel Service Implementation
The `HotelServiceImpl` class provides methods to manage hotel information:

- **Create Hotel**: Saves a new hotel to the database.
- **Get All Hotels**: Retrieves all hotels.
- **Get Hotel by ID**: Retrieves a specific hotel by its ID.
- **Delete Hotel**: Deletes a hotel by its ID.

### Rating Service Implementation
The `RatingServiceImpl` class provides methods to manage ratings:

- **Create Rating**: Saves a new rating, allowing MongoDB to generate the `ratingId`.
- **Get All Ratings**: Retrieves all ratings.
- **Get Rating by ID**: Retrieves a specific rating by its ID.
- **Get Ratings by User ID**: Retrieves all ratings given by a specific user.
- **Get Ratings by Hotel ID**: Retrieves all ratings for a specific hotel.
- **Delete Rating**: Deletes a rating by its ID.

### User Service Implementation
The `UserServiceImpl` class manages users and integrates hotel and rating data:

- **Create User**: Saves a new user to the database.
- **Get All Users**: Retrieves all users, including their associated ratings and hotel information fetched via Feign Clients.
- **Get User by ID**: Retrieves a specific user by their ID, including associated ratings and hotels.
- **Delete User**: Deletes a user by their ID.

## API Documentation

### User Controller

- **Get All Users**
  - **Endpoint**: `GET /v1/users`
  - **Description**: Fetch all users with their ratings and associated hotels.

- **Get User by ID**
  - **Endpoint**: `GET /v1/users/{user_id}`
  - **Description**: Fetch a user by ID with their ratings and associated hotels.

- **Create User**
  - **Endpoint**: `POST /v1/users`
  - **Description**: Create a new user.

- **Delete User**
  - **Endpoint**: `DELETE /v1/users/{user_id}`
  - **Description**: Delete a user by ID.

### Hotel Controller

- **Get All Hotels**
  - **Endpoint**: `GET /v1/hotels`
  - **Description**: Fetch all hotels.

- **Get Hotel by ID**
  - **Endpoint**: `GET /v1/hotels/{hotel_id}`
  - **Description**: Fetch a hotel by ID.

- **Create Hotel**
  - **Endpoint**: `POST /v1/hotels`
  - **Description**: Create a new hotel.

- **Delete Hotel**
  - **Endpoint**: `DELETE /v1/hotels/{hotel_id}`
  - **Description**: Delete a hotel by ID.

### Rating Controller

- **Create Rating**
  - **Endpoint**: `POST /v1/ratings`
  - **Description**: Create a new rating.

- **Get All Ratings**
  - **Endpoint**: `GET /v1/ratings`
  - **Description**: Fetch all ratings.

- **Get Rating by ID**
  - **Endpoint**: `GET /v1/ratings/{rating_id}`
  - **Description**: Fetch a rating by ID.

- **Get Ratings by User ID**
  - **Endpoint**: `GET /v1/ratings/users/{user_id}`
  - **Description**: Fetch all ratings given by a specific user.

- **Get Ratings by Hotel ID**
  - **Endpoint**: `GET /v1/ratings/hotels/{hotel_id}`
  - **Description**: Fetch all ratings for a specific hotel.

- **Delete Rating**
  - **Endpoint**: `DELETE /v1/ratings/{rating_id}`
  - **Description**: Delete a rating by ID.

### Data Format Support

This application supports both JSON and XML data formats. The `jackson-dataformat-xml` dependency is included to handle XML data. You can request and receive data in either format by specifying the appropriate `Content-Type` and `Accept` headers in your HTTP requests.
  ```bash
    localhost:8080/v1/users?media=xml
  ```
  ```bash
    localhost:8080/v1/users?media=json
  ```

## Troubleshooting
- **Service Not Registered**: Ensure the Service Registry (Eureka) is running and the services are correctly configured to register with Eureka.
- **Configuration Not Loaded**: Verify that the Config Server is up and running and the microservices are correctly pointed to the Config Server.
