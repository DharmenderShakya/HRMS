# Start with a base image containing Java runtime
#FROM openjdk:17-jdk-alpine

# Set the working directory in the container
#WORKDIR /app

# Copy the packaged JAR file into the container
#COPY target/hrms.jar /app/hrms.jar

# Expose the port your application runs on
#EXPOSE 8082

# Run the JAR file
#CMD ["java", "-jar", "hrms.jar"]



# Start with a base image containing Maven and Java runtime
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

COPY pom.xml .

# Copy the entire Maven project into the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use a lighter base image for the runtime environment
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage into the runtime container
COPY --from=build /app/target/hrms.jar /app/hrms.jar

# Expose the port your application runs on
ENV PORT 8080
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "hrms.jar"]
