package com.project.wusuowei.aspect;

import com.project.wusuowei.model.dto.OperationLogDTO;
import com.project.wusuowei.serivce.OperationLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 19:50
 **/
@Aspect
@Component
public class ExceptionLogAspect {
    @Autowired
    private OperationLogService operationLogService;

    @Pointcut("execution(* com.project.wusuowei.controller..*.*(..))")
    public void exceptionLogPointcut() {
    }

    @AfterThrowing(value = "exceptionLogPointcut()", throwing = "e")
    private void saveOperationLog(ProceedingJoinPoint joinPoint, Exception e) throws Throwable {
        // 获取用户行为日志
        Class<?> targetClass = joinPoint.getTarget().getClass();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = targetClass.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        OperationLogDTO operationLogDTO = new OperationLogDTO();

        // 设置操作日志信息
        operationLogDTO.setOperateEmpId(6); // 示例用户ID，可以动态获取当前登录用户
        operationLogDTO.setOperateEmpName("wusuowei"); // 示例用户名
        operationLogDTO.setClassName(targetClass.getName());
        operationLogDTO.setMethodName(targetMethod.getName());
        String methodParams = Arrays.toString(joinPoint.getArgs());
        if (methodParams.length() > 255) {
            methodParams = methodParams.substring(0, 255); // 截断到 255 个字符
        }
        operationLogDTO.setMethodParams(methodParams);
        operationLogDTO.setOperateTime(new Date());
        // 保存用户行为日志
        operationLogService.saveObject(operationLogDTO);
    }
}
