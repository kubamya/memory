package com.urttom.tstc.passage.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class MinioConfig {

    @Value("${minio.addr}")
    private String addr;

    @Value("${minio.username}")
    private String username;

    @Value("${minio.password}")
    private String password;

    public MinioClient getMinioClient(){
        try {
            return new MinioClient(addr, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
