# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/hrms.jar /app/hrms.jar

# Expose the port your application runs on
EXPOSE 8082

# Run the JAR file
CMD ["java", "-jar", "hrms.jar"]
