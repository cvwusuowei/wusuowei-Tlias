package com.project.wusuowei.entity;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:26
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 工作经历
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位
}
