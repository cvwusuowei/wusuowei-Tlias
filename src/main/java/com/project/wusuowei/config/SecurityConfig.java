package com.project.wusuowei.config;

import com.project.wusuowei.filter.JwtFilter;
import com.project.wusuowei.serivce.impl.UserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import java.util.Arrays;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 20:20
 **/
@Configuration//声明该类是一个配置类
@EnableWebSecurity//开启springsecurity配置修改
public class SecurityConfig {

    @Resource
    UserService userService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Resource
    JwtFilter jwtFilter;//后面jwt验证需要用到的过滤器，现在先不理它



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 配置 HttpSecurity
            http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                    .requestMatchers(HttpMethod.POST, "/login").permitAll() //登录放行
                    .requestMatchers("/api/**").permitAll() // 允许访问所有 API 接口
                    .anyRequest().authenticated()
            );
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        //禁用登录页面
        http.formLogin(AbstractHttpConfigurer::disable);
        //禁用登出页面
        http.logout(AbstractHttpConfigurer::disable);

        //禁用session
        http.sessionManagement(AbstractHttpConfigurer::disable);
        //禁用httpBasic
        http.httpBasic(AbstractHttpConfigurer::disable);
        //禁用csrf保护
        http.csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }




    @Bean//PasswordEncoder的实现类为BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}