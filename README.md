## Spring Boot Cassandra Data Management Application

This project demonstrates a Spring Boot application designed to interact with a Cassandra database. It facilitates functionalities for:

- Data ingestion from CSV files
- CRUD operations (Create, Read, Update, Delete) on items within the Cassandra database

**Prerequisites**

- Java 17
- Maven
- Docker

**Technologies Used**

- Spring Boot 3.2.3
- Apache Cassandra
- Spring Data Cassandra
- Lombok (Optional)
- Apache Commons CSV

**Setup Instructions**

1. Clone this repository.
2. Navigate to the project directory in your terminal.
3. Run `mvn install` to install project dependencies.

**Running the Application**

1. **Start Cassandra:**
   - Ensure Docker is installed and running.
   - Run `docker-compose up` to start the Cassandra container.
2. **Run the application:**
   - Run `mvn spring-boot:run` to start the Spring Boot application.

**Connecting to Cassandra (Optional)**

1. Run `docker ps` to identify the Cassandra container ID.
2. Run `docker exec -it <container_id> bash` to enter the container's bash shell.
3. Run `cqlsh` to connect to the Cassandra instance.
4. Follow the steps in the `application.yml` file (section "Key Takeaways" below) to create the keyspace and table if they don't already exist.

**REST API Endpoints**

The application exposes the following REST API endpoints:

- **POST /api/items:** Add a new item
- **GET /api/items/{id}:** Retrieve an item by ID
- **GET /api/items:** Retrieve all items
- **PUT /api/items/{id}:** Update an existing item
- **DELETE /api/items/{id}:** Delete an item

**Key Takeaways**

- Refer to the `application.yml` file for Cassandra connection configurations.
- The `CsvLoader` class (in the `util` directory) handles data loading from CSV during application startup.
- Error handling mechanisms can be further implemented to improve robustness.
- Security considerations are essential for production environments.

**Further Enhancements**

- Implement unit and integration tests for the application.
- Improve documentation for the REST API endpoints.
- Add functionalities for searching or filtering items based on specific criteria.

**License**

This project is licensed under the Apache License 2.0. See the LICENSE file for details.
