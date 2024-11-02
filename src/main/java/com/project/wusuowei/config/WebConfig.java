package com.project.wusuowei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-02 0:36
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")          // 添加路径规则
                .allowCredentials(true)                // 是否允许在跨域的情况下传递Cookie
                .allowedHeaders("*")                   // 允许所有的请求头
                .allowedOrigins("http://localhost:8999", "http://localhost:8080") // 明确列出允许的域
                .allowedMethods("*");
    }

}
