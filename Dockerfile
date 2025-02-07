# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR into the container
COPY target/order-service-0.0.1-SNAPSHOT.jar /app/order-service.jar

# Expose the port the service runs on
EXPOSE 9090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "order-service.jar"]
