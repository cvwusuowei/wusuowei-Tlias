package com.project.wusuowei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 17:51
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {


    private Integer id;

    private Integer operateEmpId;
    private String operateEmpName;

    private String className;

    private String methodName;

    private String methodParams;

    private String returnValue;

    private Long costTime;

    private Date operateTime;
}
