package com.posco.mes3.m00.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MaterialApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(MaterialApp.class, args);
    }
}
