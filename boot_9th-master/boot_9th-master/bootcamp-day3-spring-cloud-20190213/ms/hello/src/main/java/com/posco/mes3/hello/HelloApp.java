package com.posco.mes3.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages="com.posco.mes3")
public class HelloApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(HelloApp.class, args);
    }
}
