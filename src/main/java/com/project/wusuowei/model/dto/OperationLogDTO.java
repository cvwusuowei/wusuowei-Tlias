package com.project.wusuowei.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationLogDTO {
    private Integer page = 1; //页码

    private Integer pageSize = 10; //每页展示记录数

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
