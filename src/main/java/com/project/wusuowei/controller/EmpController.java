package com.project.wusuowei.controller;

import com.project.wusuowei.annotation.OptLog;
import com.project.wusuowei.entity.*;
import com.project.wusuowei.serivce.EmpService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.wusuowei.constant.OptTypeConstant.*;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:32
 **/
@Slf4j
@RequestMapping("/emps")
@Api(tags = "员工管理")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;


    /**
     * 条件分页查询
     */
    @GetMapping("")
    public Result page(EmpQueryParam param) throws Exception {
        log.info("请求参数： {}", param);
        PageBean pageBean = empService.page(param);
        return Result.success(pageBean);
    }
    /**
     * 添加员工
     */
    @OptLog(optType = SAVE)
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 批量删除员工
     */
    @OptLog(optType = DELETE)
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除部门: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }
    /**
     * 更新员工信息
     */
    @OptLog(optType = SAVE_OR_UPDATE)
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }


    @GetMapping("/list")
    public Result list(){
        //1. 调用empService
        List<Emp> empsList = empService.queryEmpList();
        //2. 响应数据
        return Result.success(empsList);
    }
}