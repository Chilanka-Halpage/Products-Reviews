# Products-Reviews Microservices

# Overview

Products-Reviews is a microservices-based application designed to manage products and their associated reviews. The system is composed of two independent services — Product Service and Review Service—that communicate asynchronously using a message broker. This architecture promotes loose coupling, scalability, and resilience.

## Microservices Architecture
## Product Service

* Manages product-related operations such as creating and retrieving products.

* Consumes review messages from RabbitMQ.

* Associates incoming reviews with the corresponding products.

* Persists product and review data in MongoDB Atlas.

## Review Service

* Handles creation and management of product reviews.

* Publishes review messages to a RabbitMQ queue.

* Operates independently from the Product Service to ensure asynchronous processing.

# Technologies Used
## RabbitMQ

* Acts as the message broker for asynchronous communication between services.

* Review Service publishes review events to a queue.

* Product Service consumes messages from the queue to process and store reviews.

* Ensures reliable message delivery and decoupled service interaction.

## Swagger (OpenAPI)

* Swagger UI is integrated into both services.

* Provides interactive API documentation.

* Enables easy testing and exploration of REST endpoints.

## MongoDB Atlas

* Cloud-based MongoDB service used as the primary database.

* Stores product and review data securely and reliably.

* Offers scalability and high availability without manual database management.

## Docker

* Docker is used to containerize infrastructure components.

* RabbitMQ is run inside a Docker container.

* Simplifies setup and environment configuration.

# Key Features

* Microservices-based, loosely coupled architecture

* Asynchronous communication using RabbitMQ

* Centralized and interactive API documentation with Swagger

* Cloud-hosted NoSQL database using MongoDB Atlas

* Containerized infrastructure for easier deployment
