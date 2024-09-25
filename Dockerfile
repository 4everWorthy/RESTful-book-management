# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build files (pom.xml)
COPY pom.xml ./

# Copy the application source code
COPY src ./src

# Install Maven and build the application
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean install -DskipTests

# Copy the JAR file to the container
COPY target/RESTful-book-management-0.0.1-SNAPSHOT.jar /app/RESTful-book-management.jar

# Expose the port that the application runs on (8080)
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/app/RESTful-book-management.jar"]
