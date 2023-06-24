package com.tianhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class GetwayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetwayServerApplication.class,args);
    }
}