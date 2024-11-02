package com.project.wusuowei.controller;

import com.project.wusuowei.annotation.OptLog;
import com.project.wusuowei.entity.*;
import com.project.wusuowei.model.vo.StudentVO;
import com.project.wusuowei.serivce.StudentService;
import com.project.wusuowei.strategy.context.AllStrategyContent;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.wusuowei.constant.OptTypeConstant.*;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 15:03
 **/
@Slf4j
@Api(tags = "学生管理")
@RequestMapping("/students")
@RestController
     
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AllStrategyContent allStrategyContent;
    @GetMapping("")
    public Result page(StudentQueryParam param) throws Exception {
        log.info("请求参数： {}", param);
        allStrategyContent.all();
        PageBean pageBean = studentService.page(param);
        return Result.success(pageBean);
    }


    /**
     * 添加学员
     */
    @OptLog(optType = SAVE)
    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("请求参数emp: {}", student);
        studentService.save(student);
        return Result.success();
    }


    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询学生的详细信息");
        StudentVO studentVO  = studentService.getInfo(id);
        return Result.success(studentVO);
    }

    /**
     * 更新班级信息
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生信息, {}", student);
        studentService.update(student);
        return Result.success();
    }
    @OptLog(optType = DELETE)
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids){
        System.out.println("根据ID删除学生: " + ids);
        studentService.removeBatchByIds(ids);
        return Result.success();
    }
    /**
     * 更新班级信息
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable("id") Integer id,@PathVariable("score") Integer score){
        log.info("更新学生违纪信息, {}", id,score);
        studentService.updateViolation(id,score);
        return Result.success();
    }


}
