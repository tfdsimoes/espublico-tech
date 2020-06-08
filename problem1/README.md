# Problem1

## Requirements

To run these program there is the need to have installed:
* Java 8 or higher;
* Docker;
* Docker-Compose.

## Frameworks

| Lib | Usage |
| --- | --- |
| spring-boot-starter | It is used for core starter, including auto-configuration support, logging, and YAML. |
| spring-boot-starter-data-jpa | Lib for access and manipulate databases using hibernate |
| postgresql | PostgreSQL JDBC Driver Postgresql |
| spring-boot-starter-webflux | Starter for building WebFlux applications using Spring Framework's Reactive Web support |
| reactor-spring | Reactor Spring components (needed for webclient) |
| lombok | Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, ... |
| mapstruct | Code generator that greatly simplifies the implementation of mappings between Java bean types based |
| spring-boot-starter-test | Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito |	
| junit | Unit testing framework |

## To build and run

To build just need to run the following command
```bash
$ ./mvnw clean package
```

To run the problem is need a database, so there is the need to run the docker-compose in the root
```bash
$ docker-compose -f docker-compose.yml up

```

Now to run the program
```bash
$ java -jar target/problem1-0.0.1-SNAPSHOT.jar
```

## Tests

There is some Unit tests implemented and other started. To run them.
```bash
$ ./mvnw test
```
