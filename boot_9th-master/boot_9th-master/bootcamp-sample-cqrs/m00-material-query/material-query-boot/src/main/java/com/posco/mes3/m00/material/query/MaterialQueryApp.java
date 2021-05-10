package com.posco.mes3.m00.material.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MaterialQueryApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(MaterialQueryApp.class, args);
    }
}
