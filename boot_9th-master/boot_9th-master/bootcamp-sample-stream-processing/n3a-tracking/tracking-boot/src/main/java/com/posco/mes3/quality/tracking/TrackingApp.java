package com.posco.mes3.quality.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrackingApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(TrackingApp.class, args);
    }
}
