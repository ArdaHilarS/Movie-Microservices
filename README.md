 Movie Microservices

This is a work-in-progress microservices project built with Spring Boot.
The goal is to understand how small services can stay independent while still working together as one system.
The project is actively evolving structure, communication, and features are being improved step by step.

  What’s built so far

The system currently has three separate services, each running on its own and doing one clear job.

  Movie Info Service

Handles movie data only.
Given a movie ID, it returns basic information like the movie name.

  Movie Ratings Service

Handles ratings only.
Given a user ID, it returns the movies they rated and the scores.

  Movie Catalog Service

Acts as the connector.
It calls the Info and Ratings services, merges the data, and returns a combined response.
No shared logic, no shortcuts — everything talks over HTTP.

  How it works technically

Each service is a standalone Spring Boot app
Each one has:
its own pom.xml
its own application.properties
its own REST endpoints
Communication is done using REST calls between services
No database yet — focus is on architecture and flow

Client
  ↓
Movie Catalog Service
  ↓           ↓
Movie Info   Movie Ratings

  Tech used (for now)

Java 17
Spring Boot
Spring Web (REST)
Maven

  Running the project

Each service is started separately:
mvn spring-boot:run
They run on different ports, so they can communicate without conflicts.

  What’s next

This project is not finished. Planned improvements include:

better error handling
cleaner DTOs
service discovery
API gateway
persistence
containerization

The idea is to grow it naturally while learning how real microservice systems behave.

Built and maintained by Arda Hilar
