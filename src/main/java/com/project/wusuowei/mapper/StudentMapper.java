package com.project.wusuowei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.wusuowei.entity.Student;
import com.project.wusuowei.entity.StudentQueryParam;
import com.project.wusuowei.model.vo.StudentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 18:04
 **/
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    List<StudentVO> list(StudentQueryParam param);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id,create_time,update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    int insertStudent(StudentVO studentVO);

    StudentVO getById(Integer id);

    List<Map> countDegreeData();

    List<Map<String,Object>> countClazzStudentData();
}
