# Stage 1: Build the application
FROM maven:3.9.6-amazoncorretto-21-debian AS build

WORKDIR /order

# Copy the pom.xml and the Maven wrapper to the working directory
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Resolve the project dependencies
RUN ./mvnw dependency:resolve

# Copy the source code to the working directory
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /order

# Create a non-privileged user that the app will run under.
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --uid "${UID}" \
    springrabbitmqorder
USER springrabbitmqorder

# Copy the JAR file from the build stage
COPY --from=build /order/target/*.jar order.jar

# Set default environment variable for the port
ENV PORT=8081

# Expose the port the application runs on
EXPOSE $PORT

# Run the application
ENTRYPOINT ["java", "-jar", "order.jar"]
