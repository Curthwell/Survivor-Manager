Survivors-app

Project name : Robot apocalypse

Purpose of the project : The project is a REST API designed to manage survivors and resources during a robot apocalypse. The purpose of the API is to store information about survivors and their resources, allow survivors to update their locations, flag survivors as infected under specific conditions, connect to the robot CPU system to retrieve robot information, and provide reports on the percentage of infected and non-infected survivors, as well as lists of infected survivors, non-infected survivors, and robots.

Table of Contents :

Introduction Prerequisites Installation Configuration Usage Endpoints Testing Contributing License Introduction : The project is a REST API designed to manage survivors and resources during a robot apocalypse. Its purpose is to store information about survivors and their resources, allow survivors to update their locations, flag survivors as infected under specific conditions, connect to the robot CPU system to retrieve robot information, and provide reports on the status of survivors and robots. The main features of the API include: • Adding survivors to the database with details such as name, age, gender, ID, last location (latitude, longitude), and inventory of resources (Water, Food, Medication, Ammunition). • Allowing survivors to update their last location by storing the new latitude/longitude pair in the database. • Flagging survivors as infected when at least three other survivors report their contamination. • Connecting to the robot CPU system to retrieve a list of all robots and their known locations, and sorting this information for human understanding. • Providing reports on the percentage of infected and non-infected survivors, as well as lists of infected survivors, non-infected survivors, and robots. Overall, the API serves as a critical tool for managing survivor information, tracking resources, interfacing with the robot CPU system, and providing essential reports in the midst of a chaotic robot apocalypse.

Prerequisites : List the prerequisites needed to run your Gradle Spring Boot application. This may include: • Java Development Kit (JDK) Version • Gradle Build • Dependencies :  Spring webflux starter  Core Spring Starter  Project Reactor ::reactor-test  PostgresSQL  Spring Data JPA  Project Reactor ::reactor-test

Installation: git clone https://github.com/your-username/your-project.git cd your-project ./gradlew build

Configuration: To configure database with spring boot application , here are the configuration settings to include :

PostgresSQL configuration spring.datasource.url=jdbc:postgresql://localhost:5432/your-database spring.datasource.username=postgres spring.datasource.password=your password

##JPA configuration spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true spring.jpa.properties.hibernate.format_sql=true

Usage: with intellij , it is easy since the run button is provided at the center top of the IDE when the project is loaded or you can follow this directory pattern C:\Users\Admin\Pictures\robot\robot\src\main\java\com\example\robot that will guide you through to the application . Once you have opened the application you will see two options on the left of your application that to help you run the application.

Endpoints :

Endpoint URL | Request Method | requirement | http://localhost:8080/api/survivors/add | 
POST | add the survivor to the DB | http://localhost:8080/api/survivors/{id}/location | 
PUT | update location pairs | http://localhost:8080/api/survivors/{id}/flag-infected | 
POST | Flag survivor as infected | http://localhost:8080/api/survivors/non-infected | 
GET | List of non-infected survivors | http://localhost:8080/api/survivors/infected | 
GET | List of infeacted survivors | /non-infected-percentage | 
GET | percentage of non-infected | /infected-percentage | GET | percentage of infected |

Testing :

Contributing :

License:

Not licensed yet
