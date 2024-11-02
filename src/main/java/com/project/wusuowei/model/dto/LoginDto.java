package com.project.wusuowei.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 23:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private Integer  id; //ID
    private String userName; //用户名
    private String name; //姓名
    private String token;
}
