package com.example.service;

import com.example.pojo.SC;

import java.util.List;

public interface SCService {
   List<SC> findStudentCourses(String studentNo, String courseNo, int buyTextbook,
                                       Float minGrade, Float maxGrade, int page, int pageSize);


   int getTotalCount(String studentNo, String courseNo, int buyTextbook, Float minGrade, Float maxGrade);
}
