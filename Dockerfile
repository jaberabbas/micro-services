# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container
COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

# Expose the port the service runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "user-service.jar"]
