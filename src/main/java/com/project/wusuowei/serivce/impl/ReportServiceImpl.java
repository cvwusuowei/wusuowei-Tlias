package com.project.wusuowei.serivce.impl;

import com.project.wusuowei.entity.JobOption;
import com.project.wusuowei.entity.Result;
import com.project.wusuowei.entity.Student;
import com.project.wusuowei.entity.StudentOption;
import com.project.wusuowei.mapper.EmpMapper;
import com.project.wusuowei.mapper.StudentMapper;
import com.project.wusuowei.serivce.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 12:39
 **/
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }
    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> getstudentDegreeData() {
        return studentMapper.countDegreeData();
    }




}