package com.project.wusuowei.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.wusuowei.entity.PageBean;
import com.project.wusuowei.entity.Student;
import com.project.wusuowei.entity.StudentQueryParam;
import com.project.wusuowei.model.vo.StudentVO;

import java.util.List;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 17:56
 **/
public interface StudentService extends IService<Student> {

    PageBean page(StudentQueryParam param) throws Exception;

    boolean save(Student student);

    StudentVO getInfo(Integer id);

    void update(Student student);

    boolean  updateViolation(Integer id, Integer score);
}
