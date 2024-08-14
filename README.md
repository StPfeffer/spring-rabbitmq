# Spring RabbitMQ

This project demonstrates how to integrate RabbitMQ with Spring Framework applications.

## Features

- **Basic Configuration:** Simple setup to get RabbitMQ working with Spring Boot.
- **Producer and Consumer Examples:** Examples to show how to send and receive messages.
- **Asynchronous Messaging:** Configuration for handling asynchronous message processing.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- RabbitMQ Server (You can use Docker to quickly set up a RabbitMQ instance)

### Clone the Repository

```bash
git clone https://github.com/StPfeffer/spring-rabbitmq.git
cd spring-rabbitmq
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

To start the Spring Boot application, use:

```bash
mvn spring-boot:run
```

Ensure that RabbitMQ is running on its default port (`5672`) or configure the connection details in the `application.properties` file.

### Configuration

Configuration details for RabbitMQ can be found in the `src/main/resources/application.properties` file of each module. You can adjust the connection settings, queues, exchanges, and other RabbitMQ parameters as needed.

## Running with Docker

Alternatively, you can use Docker Compose to set up the application:

```bash
docker-compose up --build
```

## Documentation

For more details on RabbitMQ and Spring Boot integration, refer to the [Spring AMQP Documentation](https://docs.spring.io/spring-amqp/docs/current/reference/html/) and [RabbitMQ Documentation](https://www.rabbitmq.com/documentation.html).
