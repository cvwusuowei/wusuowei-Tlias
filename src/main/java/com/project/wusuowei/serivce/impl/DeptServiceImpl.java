package com.project.wusuowei.serivce.impl;

import com.project.wusuowei.config.KeyConfig;
import com.project.wusuowei.entity.Dept;
import com.project.wusuowei.mapper.DeptMapper;
import com.project.wusuowei.serivce.DeptService;
import com.project.wusuowei.strategy.context.AllStrategyContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:00
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private AllStrategyContent allStrategyContent;

    @Override
    public List<Dept> queryDeptList() throws Exception {
        allStrategyContent.all();
        return deptMapper.findAll();
    }
    
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.getById(id);
    }
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}