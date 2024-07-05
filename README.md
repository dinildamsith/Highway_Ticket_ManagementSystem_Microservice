# Highway Ticket Management System

## Overview
In today's dynamic transportation landscape, managing highway tickets efficiently is crucial for ensuring smooth traffic flow and compliance with regulations. Our objective is to develop a robust microservice-based backend application for a Highway Ticket Management System. This system will streamline the handling of ticket issuance, vehicle registration, user management, and payment processing without relying on external payment gateways. By leveraging Spring Boot and Spring Cloud technologies, including Eureka for service discovery, a Configuration Server for centralized configuration management, and a Spring Cloud Gateway for intelligent routing, the application will ensure scalability, resilience, and seamless integration of services. Comprehensive testing using Postman will validate the functionality and reliability of each microservice, ensuring they meet stringent business requirements and provide a seamless user experience.

## Features
- **Service Registry and Discovery**: Dynamic service registration and discovery using Eureka.
- **Configuration Management**: Centralized configuration management with Spring Cloud Config Server.
- **API Gateway**: Intelligent routing of client requests to appropriate microservices using Spring Cloud Gateway.
- **Microservices**:
    - **Ticket Service**: Manages ticket lifecycle, including creation, status updates, and retrieval of ticket information.
    - **Vehicle Service**: Handles vehicle operations such as registration, updates, and retrieval of vehicle details.
    - **User Service**: Manages user and owner information, including registration, profile updates, and credential verification.
    - **Payment Service**: Facilitates secure internal payment processing, validating payment details and updating ticket statuses upon successful payment confirmation.

## System Requirements
- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Boot 2.5.x
- Spring Cloud 2020.x
- MySQL 8.0 or higher

## Technologies Used
- **Spring Boot**
- **Spring Cloud** (Eureka, Config Server, Gateway)
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Postman** (for API testing)

## API Documentation
Postman collection JSON file is included in the main directory of the repository. This collection contains all API endpoints with detailed requests and responses.
- Postman Documentation Link -  https://documenter.getpostman.com/view/30946423/2sA3dxDWiB

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details.

















