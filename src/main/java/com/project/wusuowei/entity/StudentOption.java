package com.project.wusuowei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-24 14:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOption {
    private List clazzList; //班级列表
    private List dataList; //人数列表
}
