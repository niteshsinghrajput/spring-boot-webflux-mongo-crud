
# Spring Boot WebFlux MongoDB CRUD Example

This is a simple Spring Boot project that demonstrates CRUD (Create, Read, Update, Delete) operations using WebFlux and MongoDB Database in functional programming style.

## Prerequisites

Before running this project, make sure you have the following prerequisites:

- Java 11 or higher installed

## Setup

1. Clone the repository:

   ```bash
   git clone git@github.com:niteshsinghrajput/spring-boot-webflux-mongo-crud.git

2. Navigate to the project directory:

    ```bash
    cd spring-boot-webflux-mongo-crud

3. Build the project

    ```bash
    ./gradlew clean build

4. Run the application

   ```bash
    java -jar .\build\libs\spring-boot-webflux-mongo-crud-0.0.1-SNAPSHOT.jar

## Usage
Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

#### The API supports the following endpoints:

* GET `/api/products`: Get all products
    * Sample URL: `http://localhost:8080/api/products`
* GET `/api/products/{id}`: Get a product by ID
    * Sample URL: `http://localhost:8080/api/products/1`
* POST `/api/products`: Create a new product
    * Sample URL: `http://localhost:8080/api/products`
    * Sample Request Payload:
      ```json
        {
            "name": "Hospital Management System",
            "price": 10000
        }
      ```
* PUT `/api/products/{id}`: Update an existing product
    * Sample URL: `http://localhost:8080/api/products/1`
    * Sample Request Payload:
      ```json
        {
            "name": "School Management System",
            "price": 25000
        }
      ```
* DELETE `/api/products/{id}`: Delete a product
    * Sample URL: `http://localhost:8080/api/products/1`

you can also use `curl` to perform CRUD (Create, Read, Update, Delete) operations for the `http://localhost:8080/api/products` endpoint:

1. **Create a Product** (HTTP POST):
   ```sh
   curl -X POST -H "Content-Type: application/json" -d '{"name":"Student Management System","price": 20000}' http://localhost:8080/api/products
   ```

2. **Read All Products** (HTTP GET):
   ```sh
   curl http://localhost:8080/api/products
   ```

3. **Read Single product by ID** (HTTP GET):
   Replace `1` with the desired product ID.
   ```sh
   curl http://localhost:8080/api/products/1
   ```

4. **Update a Product by ID** (HTTP PUT):
   Replace `1` with the desired product ID.
   ```sh
   curl -X PUT -H "Content-Type: application/json" -d '{"name":"Hospital Management System","price": 15000 }' http://localhost:8080/api/products/1
   ```

5. **Delete an Employee by ID** (HTTP DELETE):
   Replace `1` with the desired employee ID.
   ```sh
   curl -X DELETE http://localhost:8080/api/employees/1
   ```

Please note that the above commands is for a JSON-based API and use the `-H "Content-Type: application/json"` header for requests that include data. Adjust the commands based on the actual structure of your API and the data format it expects. Also, ensure that your Spring Boot application is running and listening on port 8080 for these commands to work as expected.


Make sure to replace {id} with the actual ID of the product when using the specific endpoints.

## Configuration
The application configuration can be found in the application.properties file. You can modify the MongoDB connection details, such as the host, port, and database name, in this file.
   