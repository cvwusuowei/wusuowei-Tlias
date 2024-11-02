package com.project.wusuowei.serivce;

import com.project.wusuowei.entity.Clazz;
import com.project.wusuowei.entity.ClazzQueryParam;
import com.project.wusuowei.entity.Emp;
import com.project.wusuowei.entity.PageBean;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 15:04
 **/
public interface ClazzService {
    /**
     * 分页条件查询
     */
    PageBean page(ClazzQueryParam param) throws Exception;

    void save(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

    void deleteByIds(Integer ids);

    List<Clazz> queryClassList();
}
