package com.project.wusuowei.controller;

import com.project.wusuowei.annotation.OptLog;
import com.project.wusuowei.entity.*;

import com.project.wusuowei.serivce.ClazzService;
import com.project.wusuowei.strategy.context.AllStrategyContent;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.wusuowei.constant.OptTypeConstant.*;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 15:03
 **/
@Slf4j
@Api(tags = "班级管理")
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService ;
    @Autowired
    private AllStrategyContent allStrategyContent;
    @GetMapping("")
    public Result page(ClazzQueryParam param) throws Exception {
        log.info("请求参数： {}", param);
        allStrategyContent.all();
        PageBean pageBean = clazzService.page(param);
        return Result.success(pageBean);
    }

    /**
     * 添加班级
     */
    @OptLog(optType = SAVE)
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("请求参数emp: {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }


    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Clazz clazz  = clazzService.getInfo(id);
        return Result.success(clazz);
    }


    /**
     * 更新班级信息
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级信息, {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @OptLog(optType = DELETE)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        System.out.println("根据ID删除班级: " + id);
        clazzService.deleteByIds(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        //1. 调用empService
        List<Clazz> clazzeList = clazzService.queryClassList();
        //2. 响应数据
        return Result.success(clazzeList);
    }
}
