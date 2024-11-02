package com.project.wusuowei.mapper;

import com.project.wusuowei.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 10:48
 **/
@Repository
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);
    /**
     * 根据员工的ID批量删除工作经历信息
     */
    void deleteByEmpIds(List<Integer> empIds);
}