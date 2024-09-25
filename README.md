

---

### **Incorporating Test Files**
Throughout the project, I made it a point to incorporate **test files** as I progressed, making sure that each class worked properly before moving on to the next. This approach kept things simple and allowed me to catch any potential issues early on. I started with testing the **Book** entity, making sure it could be created and modified as expected. From there, I added tests for the **repository** to verify that the CRUD operations worked correctly with the database.

By the time I got to the **service** and **controller**, I already had a solid foundation. I wrote tests to ensure the service layer handled the business logic and that the controller’s endpoints responded as expected. Running these tests along the way gave me confidence that everything was working properly and saved me from having to troubleshoot bigger issues later on. Plus, it felt great seeing those green checkmarks after every successful test run!

---

# RESTful Book Management API

This is a RESTful API for managing books, built with Spring Boot and containerized with Docker.

## Build the Docker Image

```bash
docker build -t restful-book-management .
