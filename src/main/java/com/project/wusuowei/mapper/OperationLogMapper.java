package com.project.wusuowei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.wusuowei.entity.OperationLog;
import com.project.wusuowei.model.dto.OperationLogDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 16:22
 **/
@Repository
public interface OperationLogMapper extends BaseMapper<OperationLogDTO> {

    void insertOperation(OperationLogDTO operationLogDTO);

    List<OperationLog> list(OperationLogDTO param);
}
