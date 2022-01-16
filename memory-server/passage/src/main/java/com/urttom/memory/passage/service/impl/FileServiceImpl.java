package com.urttom.memory.passage.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.urttom.memory.passage.config.MinioConfig;
import com.urttom.memory.passage.service.FileService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    Log log = LogFactory.get();

    @Autowired
    private MinioConfig minioConfig;

    @Value("${minio.bucket}")
    private String bucket;

    @Override
    public Object getFile(String protocol) {
        Map<String, Object> result = new HashMap<>();
        MinioClient minioClient = minioConfig.getMinioClient();
        try {
            String objectUrl = minioClient.presignedGetObject(bucket, protocol);
            result.put("success", true);
            result.put("url", objectUrl);
            return result;
        } catch (Exception e) {
            log.error(e);
            result.put("success", false);
            result.put("error", e);
            return result;
        }
    }

    @Override
    public Object uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        MinioClient minioClient = minioConfig.getMinioClient();
        String minioObjId = IdUtil.simpleUUID();
        InputStream in = new ByteArrayInputStream(file.getBytes());

        String[] fileNameArr = file.getOriginalFilename().split("\\.");

        StringBuffer sb = new StringBuffer("");
        sb.append(minioObjId)
                .append(".")
                .append(fileNameArr[fileNameArr.length - 1]);

        try {
            PutObjectOptions putObjectOptions = new PutObjectOptions(file.getSize(), PutObjectOptions.MIN_MULTIPART_SIZE);
            putObjectOptions.setContentType(file.getContentType());
            minioClient.putObject(bucket, sb.toString(), in, putObjectOptions);
            result.put("success", true);
            result.put("protocol", sb.toString());
            return result;
        } catch (Exception e) {
            log.error(e);
            result.put("success", false);
            result.put("error", e);
            return result;
        }
    }

    @Override
    public Object initBucket() {
        try {
            MinioClient minioClient = minioConfig.getMinioClient();
            boolean exists = minioClient.bucketExists(bucket);
            if (!exists) {
                minioClient.makeBucket(bucket);
                return "success";
            } else {
                return "exits";
            }
        } catch (Exception e) {
            log.error(e);
            return e;
        }
    }
}
