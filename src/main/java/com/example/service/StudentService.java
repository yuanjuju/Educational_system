package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.PageBean;
import com.example.pojo.SC;

import java.util.List;

public interface StudentService {
    PageBean page(Integer page, Integer pageSize);

    void selectCourse(SC sc);

    List<SC> selectGrade(Integer StudentID);

    List<Course> selectTable(Integer studentID);

    void deleteCourse(SC sc);

    void updateBook(SC sc);

    void setFeedback(SC sc);
}
