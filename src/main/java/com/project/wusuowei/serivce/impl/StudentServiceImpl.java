package com.project.wusuowei.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.wusuowei.entity.PageBean;
import com.project.wusuowei.entity.Student;
import com.project.wusuowei.entity.StudentQueryParam;
import com.project.wusuowei.mapper.StudentMapper;
import com.project.wusuowei.model.vo.StudentVO;
import com.project.wusuowei.serivce.StudentService;
//import com.project.wusuowei.strategy.context.AllStrategyContent;
import com.project.wusuowei.strategy.context.AllStrategyContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 18:02
 **/
@Service
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AllStrategyContent allStrategyContent;
    @Override
    public PageBean page(StudentQueryParam param) throws Exception {
        allStrategyContent.all();
        //1. 设置分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());

        //2. 执行查询
        List<Student> studentList = studentMapper.list(param);

        //3. 解析封装分页结果
        Page<Student> p = (Page<Student>) studentList;

        return new PageBean(p.getTotal(), p.getResult());
    }


    @Transactional
    @Override
    public boolean save(StudentVO studentVO) {
        //1.补全基础属性
        studentVO.setCreateTime(LocalDateTime.now());
        studentVO.setUpdateTime(LocalDateTime.now());
        //2.保存员工基本信息
        studentMapper.insertStudent(studentVO);
        System.err.println(studentVO);
        return false;
    }

    @Override
    public StudentVO getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Student student) {
        //1. 根据ID更新员工基本信息
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Override
    public boolean  updateViolation(Integer id, Integer score) {
        LambdaUpdateWrapper<Student> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Student::getId,id)
                .set(Student::getUpdateTime,LocalDateTime.now())
                .set(Student::getViolationScore,score);

        return this.update(updateWrapper);
    }
}
