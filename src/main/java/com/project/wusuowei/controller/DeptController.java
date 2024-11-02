package com.project.wusuowei.controller;

import com.project.wusuowei.annotation.OptLog;
import com.project.wusuowei.entity.Dept;
import com.project.wusuowei.entity.Result;
import com.project.wusuowei.serivce.DeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.wusuowei.constant.OptTypeConstant.*;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 20:47
 **/
@RestController
@Api(tags = "部门管理")
public class DeptController {
    @Qualifier("deptServiceImpl")
    @Autowired
    private DeptService deptService ;


    @GetMapping("/depts")
    public Result list() throws Exception {
        //1. 调用deptService
        List<Dept> deptList = deptService.queryDeptList();
        //2. 响应数据
        return Result.success(deptList);
    }
    @OptLog(optType = DELETE)
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据ID删除部门: " + id);
        deptService.delete(id);
        return Result.success();
    }
    /**
     * 添加部门 - json格式参数接收
     */
    @OptLog(optType = SAVE)
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门: " + dept);
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据ID查询部门数据
     */
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据ID查询部门数据: " + id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }
    /**
     * 修改部门数据
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门数据: " + dept);
        deptService.update(dept);
        return Result.success();
    }
}