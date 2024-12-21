package com.example.service.impl;

import com.example.mapper.SCMapper;
import com.example.pojo.SC;
import com.example.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCServiceImpl implements SCService {

    @Autowired
    private SCMapper studentCourseMapper;

    /**
     * 查找符合条件的选课记录（分页）
     * @param studentNo 学号
     * @param courseNo  课程号
     * @param buyTextbook 是否购买教材
     * @param minGrade 最低成绩
     * @param maxGrade 最高成绩
     * @param page 页码
     * @param pageSize 每页记录数
     * @return 符合条件的选课记录列表
     */
    public List<SC> findStudentCourses(String studentNo, String courseNo, String buyTextbook,
                                                  Float minGrade, Float maxGrade, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return studentCourseMapper.findStudentCourses(studentNo, courseNo, buyTextbook, minGrade, maxGrade, offset, pageSize);
    }

    /**
     * 获取符合条件的选课记录总数
     * @param studentNo 学号
     * @param courseNo  课程号
     * @param buyTextbook 是否购买教材
     * @param minGrade 最低成绩
     * @param maxGrade 最高成绩
     * @return 符合条件的选课记录总数
     */
    public int getTotalCount(String studentNo, String courseNo, String buyTextbook, Float minGrade, Float maxGrade) {
        return studentCourseMapper.getTotalCount(studentNo, courseNo, buyTextbook, minGrade, maxGrade);
    }
}
