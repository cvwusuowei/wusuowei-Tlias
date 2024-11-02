package com.project.wusuowei.JDBCTest;

import cn.hutool.core.net.NetUtil;
import com.project.wusuowei.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.wusuowei.entity.User;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 23:05
 **/
@SpringBootTest
public class MybatisTest {

    @Autowired
    public UserMapper userMapper;

    @Test
    public void testFindAll() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        String localMacAddress2 = NetUtil.getMacAddress(inetAddress);
        System.out.println(localMacAddress2);
    }

}