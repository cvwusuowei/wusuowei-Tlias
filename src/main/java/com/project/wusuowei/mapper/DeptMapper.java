package com.project.wusuowei.mapper;

import com.project.wusuowei.entity.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-21 23:58
 **/
@Repository
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> findAll();

    /**
     * 根据ID删除部门数据
     *
     * # 符号: 占位符，会被 ？替换为预编译的SQL(推荐); 通常用于字段值的替换.
     * $ 符号: 字符串拼接符号，会将参数直接拼接在SQL语句中(不推荐); 如果需要动态设置表名, 字段名时, 必须使用$符号.
     */
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    /**
     * 添加部门数据 - 传递多个参数时,可以把多个参数封装到一个对象中 , 然后通过 #{属性名} 来获取对象属性
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 根据ID查询部门数据
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 根据ID更新部门数据
     */
   void update(Dept dept);
}
