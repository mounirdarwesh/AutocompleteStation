# Use a base image with JDK 17
FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

# Copy the project files and build the application
COPY . .
RUN ./mvnw clean package

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY src/main/resources/D_Bahnhof_2016_01_alle.csv src/main/resources/D_Bahnhof_2016_01_alle.csv

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set the entry point command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
