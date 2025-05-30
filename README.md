# Microservices Project: rest-book and rest-number

## Overview

This project contains two microservices built with **Java Quarkus** and packaged as **Docker images**:

- **rest-number**: A microservice responsible for generating ISBN numbers.
- **rest-book**: A microservice for managing books that consumes the `rest-number` service to obtain ISBN numbers.

---

## Architecture

- **rest-number** exposes a REST API endpoint to generate ISBN numbers.
- **rest-book** exposes REST endpoints for book-related operations and internally calls the `rest-number` service to assign ISBNs when creating new books.
- Both services are containerized using Docker for easy deployment.