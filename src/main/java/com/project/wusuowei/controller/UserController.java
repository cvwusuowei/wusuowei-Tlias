package com.project.wusuowei.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.project.wusuowei.entity.Result;
import com.project.wusuowei.entity.User;
import com.project.wusuowei.mapper.UserMapper;
import com.project.wusuowei.model.dto.LoginDto;
import com.project.wusuowei.model.vo.LoginReuqestVO;
import com.project.wusuowei.serivce.impl.UserService;
import com.project.wusuowei.utils.JwtUtil;
import io.swagger.annotations.Api;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 20:22
 **/
@RestController
@Slf4j
@Api(tags = "通用服务")
public class UserController {

    @Resource
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Resource
    private UserService userService;

    @Resource
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    @Transactional
    public Result doLogin(@RequestBody LoginReuqestVO request){
        try{
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            Authentication authentication = authenticationManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            LoginDto loginDto = userMapper.selectByNameLoginDto(request.getUsername());
            loginDto.setToken(jwtUtil.getToken(userDetails.getUsername()));
            return Result.success(loginDto);
        } catch (Exception e){
            log.error(e.getMessage());
            log.error("userName or password is not correct");
            return Result.error("登录失败");
        }
    }
    @PostMapping("/check")
    public Result doCheck(){
        log.info("权限验证成功");
        return Result.success("登录成功");
    }


    @PostMapping("/register")
    public Result doRegister(@RequestBody User user){
        try {
            if (user.getPassword() != null && !user.getPassword().isEmpty()){
                String password = passwordEncoder.encode(user.getPassword());
                user.setPassword(password);
                if (userService.insertUser(user) == null){
                    throw new Exception("用户名已存在");
                }
                String jwtToken = jwtUtil.getToken(user.getUserName());
                return Result.success(jwtToken);
            }else
                throw new Exception("密码为空");
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error("注册失败" + e.getMessage());
        }
    }
}