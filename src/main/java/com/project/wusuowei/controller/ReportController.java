package com.project.wusuowei.controller;

import com.project.wusuowei.entity.JobOption;
import com.project.wusuowei.entity.Result;

import com.project.wusuowei.mapper.StudentMapper;
import com.project.wusuowei.serivce.ReportService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 12:38
 **/

@Slf4j
@Api(tags = "报表统计")
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/studentDegreeData")
    public Result getstudentDegreeData(){
        log.info("统计学生学历信息");
        List<Map> degreeList = reportService.getstudentDegreeData();
        return Result.success(degreeList);
    }
    
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        // 从数据库获取班级学生人数统计数据
        List<Map<String, Object>> list = studentMapper.countClazzStudentData();

        // 提取班级名称列表
        List<String> clazzList = list.stream()
                .map(dataMap -> (String) dataMap.get("clazzName"))
                .collect(Collectors.toList());

        // 提取学生人数列表
        List<Integer> dataList = list.stream()
                .map(dataMap -> ((Number) dataMap.get("studentCount")).intValue())  // 使用 Number 转换
                .collect(Collectors.toList());


        // 构建返回的数据结构
        Map<String, Object> data = new HashMap<>();
        data.put("clazzList", clazzList);
        data.put("dataList", dataList);

        // 返回结果
        return Result.success(data);
    }


}