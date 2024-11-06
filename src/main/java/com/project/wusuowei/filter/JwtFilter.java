package com.project.wusuowei.filter;

import com.project.wusuowei.model.dto.LoginDto;
import com.project.wusuowei.serivce.impl.UserService;
import com.project.wusuowei.utils.JwtUtil;
import com.project.wusuowei.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.project.wusuowei.constant.AuthConstant.EXPIRE_TIME;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Resource
    JwtUtil jwtUtil;

    @Resource
    UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader("Token");//从请求头中获取token
        //检查token是否可以
        if (jwtToken != null && !jwtToken.isEmpty() && jwtUtil.checkToken(jwtToken)){
            try {//token可用
                System.out.println(jwtToken);
                Claims claims = jwtUtil.getTokenBody(jwtToken);
                String username = (String) claims.get("userName");
                //获取用户信息,查询数据库
                UserDetails user = userService.loadUserByUsername(username);
//                redisUtil.hSet("tlias",username,user,EXPIRE_TIME);
                if (user != null){
                    /*
                      1.UsernamePasswordAuthenticationToken封装认证对象
                      2.调用.getAuthorities()方法进行方法认证,获取认证权限
                      3.获取UserDetails对象,loadUserByUsername获取账号密码
                     */
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    //存入 Security上下文中
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (Exception e){
                log.error(e.getMessage());
            }
        }else {
            log.warn("token is null or empty or out of time, probably user is not log in !");
        }
        filterChain.doFilter(request, response);//继续过滤
    }
}