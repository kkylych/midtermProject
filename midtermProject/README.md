# Notes App

Video: https://youtu.be/JWgnrlvGetM

This is a sample application for managing notes. It allows users to create, view, update, and delete notes.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for development)
- MySQL (for production)
- MapStruct (for mapping between entities and DTOs)
- Mockito and MockMVC (for unit testing)
- JUnit (testing framework)
- Swagger UI (for API documentation)
- Hibernate Validator (for data validation)

## Getting Started

1. Make sure you have Java and Maven installed.
2. Clone the repository to your machine.
3. Navigate to the root directory of the project and run `mvn spring-boot:run`.
4. The application will be accessible at `http://localhost:8080`.

## Usage

- API documentation is available at `http://localhost:8080/swagger-ui.html`.
- You can use any HTTP client (e.g., Postman) to interact with the API.
- For accessing the database in development mode, use the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`, Username: `sa`, Password: empty).

## Development

- Before submitting requests for adding new features or fixing bugs, ensure that all tests pass successfully.
- To run unit tests, execute `mvn test`.
- To run integration tests, execute `mvn integration-test`.
