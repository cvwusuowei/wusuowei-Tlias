package com.project.wusuowei.entity;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 12:40
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 员工职位人数统计
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList; //职位列表
    private List dataList; //人数列表
}