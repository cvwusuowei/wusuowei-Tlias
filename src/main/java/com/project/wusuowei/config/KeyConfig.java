package com.project.wusuowei.config;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-25 17:57
 **/
import cn.hutool.core.net.NetUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Configuration
public class KeyConfig {

    @Value("${use.all.path}")
    private String useAllPath;

    @Value("${usr.all.path}")
    private String usrAllPath;



}
