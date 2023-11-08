# GroceryDataProvider
Provides the grocery data

This is one micro service project designed to read the excel file provided and return the groceries as list. 
This project has been developed using Java 17, Spring-boot 3.1.4 and Maven.

All the entities for the grocery are mapped using the JPA.

Instructions run this api:

Build : mvn clean install

Run: Run the application

Health check using Spring actuator url : http://localhost:8084/actuator/health

Swagger-ui url : http://localhost:8084/swagger-ui/index.html

Using the swagger uri mentioned above we can test the service created

Note: We have to start service registry project first before starting this project then only this service will be registered.
