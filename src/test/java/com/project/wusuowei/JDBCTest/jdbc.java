package com.project.wusuowei.JDBCTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 22:49
 **/
@SpringBootTest
public class jdbc {
    @Test
    public void testUpdate() throws Exception {
        //1.准备工作
        //1.1 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //1.2 获取连接
        String url = "jdbc:mysql://localhost:3306/web";
        Connection connection = DriverManager.getConnection(url, "root", "211317wt");

        //1.3 获取SQL语句执行对象
        Statement statement = connection.createStatement();

        //2.执行SQL
        statement.executeUpdate("update user set password = '1234567890' where id = 1");

        //3.释放资源
        statement.close();
        connection.close();
    }
}
