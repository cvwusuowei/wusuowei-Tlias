package com.project.wusuowei.serivce.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.project.wusuowei.entity.OperationLog;
import com.project.wusuowei.entity.PageBean;
import com.project.wusuowei.mapper.OperationLogMapper;
import com.project.wusuowei.model.dto.OperationLogDTO;
import com.project.wusuowei.serivce.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 16:21
 **/
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;
    @Override
    public void saveObject(OperationLogDTO operationLogDTO) {
        operationLogMapper.insertOperation(operationLogDTO);
    }

    @Override
    public PageBean page(OperationLogDTO param) throws Exception {
        PageHelper.startPage(param.getPage(), param.getPageSize());

        //2. 执行查询
        List<OperationLog> operationList = operationLogMapper.list(param);

        //3. 解析封装分页结果
        Page<OperationLog> p = (Page<OperationLog>) operationList;

        return new PageBean(p.getTotal(), p.getResult());
    }
}
