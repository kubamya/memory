package com.urttom.memory.xtpz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.urttom.memory.xtpz.mapper")
public class XtpzApplication {

    public static void main(String[] args) {
        SpringApplication.run(XtpzApplication.class, args);
    }
}
