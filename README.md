# Overview

gRPC with Spring Boot example

# Libs

* gRPC
* Spring Boot
* [grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter)

# Usage

* Start Eureka 

`java -jar eureka-server/target/eureka-server-1.0.0-SNAPSHOT.jar`

* Start grpc-server(s)

```
java -jar grpc-server/target/grpc-springboot-server-1.0.0-SNAPSHOT.jar --server.port=6565
java -jar grpc-server/target/grpc-springboot-server-1.0.0-SNAPSHOT.jar --server.port=6566
```

* Start grpc-client

`java -jar grpc-client/target/grpc-springboot-client-1.0.0-SNAPSHOT.jar`