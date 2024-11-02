package com.project.wusuowei.serivce.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.wusuowei.entity.*;
import com.project.wusuowei.mapper.ClazzMapper;

import com.project.wusuowei.serivce.ClazzService;
import com.project.wusuowei.strategy.context.AllStrategyContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 15:11
 **/
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private AllStrategyContent allStrategyContent;
    @Override
    public PageBean page(ClazzQueryParam param) throws Exception {
        allStrategyContent.all();
        //1. 设置分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());

        clazzMapper.updateClazzStatus();
        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(param);

        //3. 解析封装分页结果
        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageBean(p.getTotal(), p.getResult());
    }


    @Transactional
    @Override
    public void save(Clazz clazz) {
        //1.补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        //2.保存员工基本信息
        clazzMapper.insert(clazz);
        System.err.println(clazz);

    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Clazz clazz) {
        //1. 根据ID更新员工基本信息
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    @Override
    public void deleteByIds(Integer id) {
        clazzMapper.deleteByIds(id);
    }

    @Override
    public List<Clazz> queryClassList() {
        return clazzMapper.findAll();

    }
}
