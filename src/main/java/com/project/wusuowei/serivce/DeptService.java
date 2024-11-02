package com.project.wusuowei.serivce;

import com.project.wusuowei.entity.Dept;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 22:28
 **/
public interface DeptService {
    //查询所有的部门数据
     List<Dept> queryDeptList() throws Exception;


    void delete(Integer id);

    void add(Dept dept);

    Dept getInfo(Integer id);

    void update(Dept dept);
}
