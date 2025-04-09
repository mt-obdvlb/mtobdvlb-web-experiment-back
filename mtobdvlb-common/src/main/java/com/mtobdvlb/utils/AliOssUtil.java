package com.mtobdvlb.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;

@Data
@Slf4j
@AllArgsConstructor
public class AliOssUtil {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public String upload(String fileName, byte[] bytes) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(bytes));
            return "https://" + bucketName + "." + endpoint + "/" + fileName;
        } catch (Exception e) {
            log.error("上传文件失败", e);
        }
        return null;
    }

}
