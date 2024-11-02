package com.project.wusuowei.mapper;

import com.github.pagehelper.Page;
import com.project.wusuowei.entity.Dept;
import com.project.wusuowei.entity.Emp;
import com.project.wusuowei.entity.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-22 0:27
 **/
@Repository
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    public Long count();

    /**
     * 查询所有的员工及其对应的部门名称
     */
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
     List<Emp> list(Integer start , Integer pageSize);

    /**
     * 查询所有的员工及其对应的部门名称
     */
    @Select("select t1.*,t2.name deptName from emp as t1 left join dept as t2 on t1.dept_id = t2.id")
    Page<Emp> list();

    List<Emp> list(EmpQueryParam param);

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 批量删除员工信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据ID查询员工详细信息
     */
    Emp getById(Integer id);

    void updateById(Emp emp);
    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    List<Map> countEmpGenderData();

    @Select("select * from emp")
    List<Emp> findAll();
}
