package com.project.wusuowei.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 20:07
 **/
@Component
@Slf4j
public class JwtUtil {
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥

    //生成token字符串的方法
    public String getToken(String userName){
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("user")
                .setIssuedAt(new Date())
                .claim("userName", userName)//设置token主体部分 ，存储用户信息
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    //验证token字符串是否是有效的  包括验证是否过期
    public boolean checkToken(String jwtToken) {
        if(jwtToken == null || jwtToken.isEmpty()){
            log.error("Jwt is empty");
            return false;
        }
       return  true;
    }

    public Claims getTokenBody(String jwtToken){
        if(jwtToken == null || jwtToken.isEmpty()){
            log.error("Jwt is empty");
            return null;
        }
        try {
            return Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken).getBody();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}