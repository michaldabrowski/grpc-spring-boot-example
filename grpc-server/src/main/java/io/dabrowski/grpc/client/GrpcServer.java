package io.dabrowski.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GrpcServer {
    public static void main(String[] args) {
        SpringApplication.run(GrpcServer.class, args);
    }
}
