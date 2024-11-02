package com.project.wusuowei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.wusuowei.entity.Clazz;
import com.project.wusuowei.entity.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 15:13
 **/
@Repository
public interface ClazzMapper extends BaseMapper<Clazz> {

    List<Clazz> list(ClazzQueryParam param);

    void updateClazzStatus();


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "VALUES (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    int insert(Clazz clazz);
    /**
     * 根据ID查询员工详细信息
     */
    Clazz getById(Integer id);

    int updateById(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void deleteByIds(Integer ids);

    @Select("select * from clazz")
    List<Clazz> findAll();
}
