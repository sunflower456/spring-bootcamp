package com.posco.mes3.quality.tracking.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrackingStreamApp {
    //
    public static void main(String[] args) {
        //
        SpringApplication.run(TrackingStreamApp.class, args);
    }
}
