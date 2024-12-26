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


    public List<SC> findStudentCourses(String studentNo, String courseNo, int buyTextbook,
                                                  Float minGrade, Float maxGrade, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return studentCourseMapper.findStudentCourses(studentNo, courseNo, buyTextbook, minGrade, maxGrade, offset, pageSize);
    }


    public int getTotalCount(String studentNo, String courseNo, int buyTextbook, Float minGrade, Float maxGrade) {
        return studentCourseMapper.getTotalCount(studentNo, courseNo, buyTextbook, minGrade, maxGrade);
    }
}
