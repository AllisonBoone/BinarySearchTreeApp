# Binary Search Tree Visualizer

This project is a full-stack Spring Boot application that allows users to build, visualize, and review Binary Search Trees (BSTs) from custom input.

## Features

- enter-numbers: HTML form for submitting a list of numbers.
- process-numbers: Accepts numbers, builds a balanced BST, returns a JSON structure and visual confirmation.
- previous-trees: Lists all previously submitted trees (input + structure).
- Unit Tested: Includes 3 passing tests for tree insertion, structure, and JSON generation.
- Bonus Implemented: Automatically generates a balanced BST.

### Technologies Used

- Java 21
- Spring Boot 3
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 (in-memory DB)
- JUnit 5
- Maven

#### How to Run

```bash
# Build and run the app
./mvnw spring-boot:run
```
