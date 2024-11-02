package com.project.wusuowei.serivce;

import com.project.wusuowei.entity.JobOption;
import com.project.wusuowei.entity.StudentOption;

import java.util.List;
import java.util.Map;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-23 12:39
 **/
public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    List<Map> getstudentDegreeData();

//    StudentOption getStudentCountData();
}
