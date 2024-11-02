package com.project.wusuowei.serivce;

import com.project.wusuowei.entity.PageBean;
import com.project.wusuowei.model.dto.OperationLogDTO;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-11-01 16:20
 **/
public interface OperationLogService {
    void saveObject(OperationLogDTO operationLogDTO);

    /**
     * 分页条件查询
     */
    PageBean page(OperationLogDTO param) throws Exception;
}
