package com.project.wusuowei.controller;


import com.project.wusuowei.entity.Result;
import com.project.wusuowei.enums.FilePathEnum;
import com.project.wusuowei.strategy.context.UploadStrategyContext;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@Api(tags = "通用服务")
public class UploadController {

    @Autowired
    private UploadStrategyContext uploadStrategyContext;


    @PostMapping("/upload")
    public Result upload(MultipartFile file)  {
        log.info("文件上传: {}", file.getOriginalFilename());
        return Result.success(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.PHOTO.getPath()));
    }

}