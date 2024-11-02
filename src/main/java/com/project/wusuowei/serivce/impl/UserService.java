package com.project.wusuowei.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.project.wusuowei.entity.User;
import com.project.wusuowei.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserDetailsService {
 
    @Resource
    UserMapper userMapper;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        try {
            User user = userMapper.selectOne(wrapper);//这里要确保userName是唯一的
            return  user;
        }catch (Exception e){
            log.error("user is not find");
            return null;
        }
    }
    public User insertUser(User user){
        try {
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUserName, user.getUserName());
            if (userMapper.selectList(wrapper).size() == 0){
                userMapper.insert(user);
                return user;
            }else {
                log.error("userName already exists");
                return null;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}