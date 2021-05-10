package com.posco.mes3.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class EchoApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(EchoApp.class, args);
    }
}
