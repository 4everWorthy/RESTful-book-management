

---

### **Incorporating Test Files**
Throughout the project, I made it a point to incorporate **test files** as I progressed, making sure that each class worked properly before moving on to the next. This approach kept things simple and allowed me to catch any potential issues early on. I started with testing the **Book** entity, making sure it could be created and modified as expected. From there, I added tests for the **repository** to verify that the CRUD operations worked correctly with the database.

By the time I got to the **service** and **controller**, I already had a solid foundation. I wrote tests to ensure the service layer handled the business logic and that the controller’s endpoints responded as expected. Running these tests along the way gave me confidence that everything was working properly and saved me from having to troubleshoot bigger issues later on. Plus, it felt great seeing those green checkmarks after every successful test run!

---

# RESTful Book Management API

This is a RESTful API for managing books, built with Spring Boot and containerized with Docker.

## Build the Docker Image

To build the Docker image for this application, run the following command in the root directory of the project:

```bash
docker build -t restful-book-management .
```

## Run the Application

To run the application in a Docker container, use the following command:

```bash
docker run -p 8080:8080 restful-book-management
```

## Access the Application

The API will be available at `http://localhost:8080/api/books`.

- Use this endpoint to retrieve all books, add new ones, update, or delete existing books.

## Available Endpoints
- `GET /api/books` - Retrieve all books
- `POST /api/books` - Add a new book
- `PUT /api/books/{id}` - Update a book
- `DELETE /api/books/{id}` - Delete a book
```

