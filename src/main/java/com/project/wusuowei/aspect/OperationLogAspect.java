package com.project.wusuowei.aspect;


import cn.hutool.core.date.StopWatch;
import com.project.wusuowei.model.dto.OperationLogDTO;
import com.project.wusuowei.serivce.OperationLogService;
import com.project.wusuowei.utils.UserUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.sound.midi.Transmitter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect      //添加此注解的类，用来定义切面
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    @Pointcut("@annotation(com.project.wusuowei.annotation.OptLog)")        //定义一个切点
    public void operationLogPointCut() {
    }
    /**
     * @param joinPoint 封装了目标方法信息的一个对象(连接点对象)
     * @return 目标方法的执行结果
     * @throws Throwable
     * @Around 注解描述的方法可以在目标方法执行之前和之后做功能扩展
     */

    @Around("operationLogPointCut()")   //环绕，可以在切入点前后织入代码，并且可以自由的控制何时执行切点；
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();

        // 执行目标方法并获取返回值，仅执行一次
        Object result = joinPoint.proceed();

        long t2 = System.currentTimeMillis();
        System.err.println("time: " + (t2 - t1));

        // 将日志写入数据库
        saveOperationLog(joinPoint, (t2 - t1), result);

        return result;
    }
     //JointPoint连接点
     private void saveOperationLog(ProceedingJoinPoint joinPoint, long time, Object result) throws Throwable {
        // 获取用户行为日志
        Class<?> targetClass = joinPoint.getTarget().getClass();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = targetClass.getDeclaredMethod(ms.getName(), ms.getParameterTypes());

        OperationLogDTO operationLogDTO = new OperationLogDTO();

         String methodParams = Arrays.toString(joinPoint.getArgs());
         if (methodParams.length() > 255) {
             methodParams = methodParams.substring(0, 255); // 截断到 255 个字符
         }
        // 设置操作日志信息
        operationLogDTO.setOperateEmpId(UserUtil.getUserDetailsDTO().getId()); // 示例用户ID，可以动态获取当前登录用户
        operationLogDTO.setOperateEmpName(UserUtil.getUserDetailsDTO().getUserName()); // 示例用户名
        operationLogDTO.setClassName(targetClass.getName());
        operationLogDTO.setMethodName(targetMethod.getName());

        operationLogDTO.setMethodParams(methodParams);
        operationLogDTO.setCostTime(time);
        operationLogDTO.setOperateTime(new Date());

//         使用传入的 result 作为返回值
        operationLogDTO.setReturnValue(result != null ? result.toString() : "null");

        // 保存用户行为日志
        operationLogService.saveObject(operationLogDTO);
    }


}
