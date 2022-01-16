package com.urttom.memory.passage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.urttom.memory.passage.mapper")
public class PassageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassageApplication.class, args);
    }
}
