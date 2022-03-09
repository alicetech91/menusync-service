# menusync-service
Develop a Food MenuSync System using Microservices architecture and Spring Cloud
This is a system designed in Spring Boot/Data/Cloud to provide Microservice for food menu system.

## Development environment
**Postgres DB** is running on docker, image specified in docker-compose.yml file, and started by docker-compose.  
**Spring Data Jpa** is used for quick DB access and verification.  
**Spring Boot** is used for fast Microservice development and independant deployment.  
**Spring Boot Actuator** is used to provide monitoring information. (/health, /metrics... etc.)  
**Lombok** is used to eliminate constructors and getter/setter implementation for cleaner coding style.  
**Spring Cloud Gateway** is used to provide API Gateway.  
**Eureka Client** is used for microservices registration and discovery.  
**Junit** is used to integrate with Mockito for unit testing.  
**Docker Plugin** to build the docker image of the Microservice.  

## Features
- Microservice should be able to handle product stock updates
- Microservice should be able to sync a complete menu(category→product→size)
- Microservice should be able to get a complete menu from your data source
- Service is capable to handle shared menu where we need to update at once.
- Microservice is horizontally scalable with the use of Netflix Eureka, Spring Cloud Gateway and Docker(Auto Scale up and down)
- The code has tests
- The code has logging using Slf4j and custom config in app.prop



