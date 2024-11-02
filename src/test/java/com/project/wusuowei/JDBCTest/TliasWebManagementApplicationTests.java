package com.project.wusuowei.JDBCTest;

import com.project.wusuowei.entity.Emp;
import com.project.wusuowei.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:28
 **/
@SpringBootTest
public class TliasWebManagementApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testListEmp(){
        List<Emp> empList = empMapper.list();
        empList.forEach(emp -> System.out.println(emp));
    }

}