package com.project.wusuowei.dao.impl;

import com.project.wusuowei.dao.DeptDao;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 22:27
 **/

@Repository
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<String> queryDeptList(){
        //1. 加载文件 ,  获取原始数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        try {
            return IOUtils.readLines(in, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}