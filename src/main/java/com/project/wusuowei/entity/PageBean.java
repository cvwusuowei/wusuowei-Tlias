package com.project.wusuowei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; //总记录数
    private List rows; //当前页数据列表
}