package com.urttom.tstc.passage.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    /**
     * 获取文件的预览链接
     * @param protocol
     * @return
     */
    Object getFile(String protocol);

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    Object uploadFile(MultipartFile file) throws IOException;

    /**
     * 初始化文件桶
     * @return
     */
    Object initBucket();
}
