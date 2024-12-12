package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.PageBean;
import com.example.pojo.SC;

import java.util.List;

public interface StudentService {
    PageBean page(Integer page, Integer pageSize);

    void selectCourse(SC sc);

    List<SC> selectGrade(Integer student_id);

    List<Course> selectTable(Integer student_id);

    void deleteCourse(SC sc);

    void updateBook(SC sc);

    void setFeedback(SC sc);
}
