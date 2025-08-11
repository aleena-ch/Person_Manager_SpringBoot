# Person Manager Application

A simple Spring Boot web application to manage persons — create, list, and delete persons via a web UI built with Thymeleaf and a REST API backend.

---

## Features

- Add persons with first name, last name, and optional email
- View all added persons in a table
- Delete persons from the list
- Thymeleaf-based server-rendered UI
- REST API endpoints for CRUD operations
- Data persistence using Spring Data JPA and h2 in memory database

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Hibernate
- Maven/Gradle
- H2 

---

## Getting Started

### Prerequisites

- Java JDK 17
- Maven

### Running the Application

1. Download the zip file ,unzip it or clone from git repository
   
   ```git clone url```

2. Build and run the application using Maven:
  ```mvn spring-boot:run```

3. To access the web UI - open browser and navigate to:
```http://localhost:8080/persons```

### API Reference

| Method | Endpoint             | Description                  |
| ------ | -------------------- | ---------------------------- |
| POST   | `/api/person/create` | Create a new person (JSON)   |
| GET    | `/api/person/list`   | Retrieve list of all persons |
| DELETE | `/api/person/{id}`   | Delete a person by ID        |

### Project Structure Overview

- PersonManagerController — REST API endpoints
- PersonWebController — Web UI controller (Thymeleaf)
- PersonDto — Data Transfer Object used in UI and API
- Person — JPA entity mapping to database
- PersonRepository — Spring Data repository interface
- resources/templates/persons.html — Thymeleaf HTML templates for UI

### Postman Collection(REST Endpoints)

Person Manager.postman_collection.json is added in this project.
Export the file into Postman and we can access the endpoints.