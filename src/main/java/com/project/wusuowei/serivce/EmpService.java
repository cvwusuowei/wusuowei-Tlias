package com.project.wusuowei.serivce;

import com.project.wusuowei.entity.Emp;
import com.project.wusuowei.entity.EmpQueryParam;
import com.project.wusuowei.entity.PageBean;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:32
 **/
public interface EmpService {

    /**
     * 分页条件查询
     */
    PageBean page(EmpQueryParam param) throws Exception;
    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 批量删除员工
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工的详细信息
     */
    Emp getInfo(Integer id);
    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    List<Emp> queryEmpList();
}
