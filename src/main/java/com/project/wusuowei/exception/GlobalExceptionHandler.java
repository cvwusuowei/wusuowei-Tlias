package com.project.wusuowei.exception;


import com.project.wusuowei.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理异常

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序运行出错啦 .... ", e);
        return Result.error("对不起, 系统访问异常, 请联系管理员 ~");
    }

    @ExceptionHandler
    public Result handleBussinessException(BizException e){
        log.error("程序运行出错啦 .... ", e);
        return Result.error(e.getMessage());
    }

}
