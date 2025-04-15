package com.mtobdvlb.controller;

import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.entity.City;
import com.mtobdvlb.entity.Province;
import com.mtobdvlb.result.Result;
import com.mtobdvlb.service.CommonService;
import com.mtobdvlb.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @Autowired
    private CommonService commonService;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传", file);
        try {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            String filePath = aliOssUtil.upload(fileName, file.getBytes());
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败", e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

    @GetMapping("/provinces")
    public Result<List<Province>> getProvinces() {
        log.info("获取省份信息");
        List<Province> provinces = commonService.getProvinces();
        return Result.success(provinces);
    }

    @GetMapping("/cities/{provinceId}")
    public Result<List<City>> getCities(@PathVariable Long provinceId) {
        log.info("获取城市信息", provinceId);
        List<City> cities = commonService.getCities(provinceId);
        return Result.success(cities);
    }

}
