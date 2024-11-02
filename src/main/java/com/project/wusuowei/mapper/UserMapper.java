package com.project.wusuowei.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.wusuowei.entity.User;
import com.project.wusuowei.model.dto.LoginDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 23:01
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询全部
     */
   
    public  List<User> findAll();
    @Transactional(propagation = Propagation.REQUIRED)
    LoginDto selectByNameLoginDto(String userName);
}