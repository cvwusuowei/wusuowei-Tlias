package com.project.wusuowei.controller;

import com.project.wusuowei.entity.PageBean;
import com.project.wusuowei.entity.Result;
import com.project.wusuowei.model.dto.OperationLogDTO;
import com.project.wusuowei.serivce.OperationLogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 16:54
 **/
@RestController
@Slf4j
@Api(tags = "报表统计")
@RequestMapping("/log")
public class OperationController {
    @Autowired
    private OperationLogService operationLogService;
    /**
     * 条件分页查询
     */
    @GetMapping("/page")
    public Result page(OperationLogDTO param) throws Exception {
        log.info("请求参数： {}", param);
        PageBean pageBean = operationLogService.page(param);
        return Result.success(pageBean);
    }
}
