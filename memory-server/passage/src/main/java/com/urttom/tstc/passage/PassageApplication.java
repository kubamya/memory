package com.urttom.tstc.passage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PassageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassageApplication.class, args);
    }
}
