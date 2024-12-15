package com.example.service.impl;


import com.example.mapper.StudentMapper;
import com.example.pojo.Course;
import com.example.pojo.PageBean;
import com.example.pojo.SC;
import com.example.pojo.Student;
import com.example.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;



    //    分页查询课程
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 使用 PageHelper 自动处理分页
        PageHelper.startPage(page, pageSize);

        // 查询总记录数
        Long total = studentMapper.countCourses();

        // 查询当前页的数据
        List<Course> courseList = studentMapper.findCourses();

        // 返回分页数据
        return new PageBean<Course>(total, courseList);

    }

//    选课系统选课
    @Override
    public void selectCourse(SC sc) {
        studentMapper.selectCourse(sc);

    }

    @Override
    public List<SC> selectGrade(Integer student_id) {
        List<SC> sc=studentMapper.selectGrade(student_id);
        return sc;
    }

    @Override
    public List<Course> selectTable(Integer student_id) {
        return studentMapper.selectTable(student_id);
    }

    @Override
    public void deleteCourse(SC sc) {
        studentMapper.deleteCourse(sc);
    }

    @Override
    public void updateBook(SC sc) {
        studentMapper.updateBook(sc);
    }

    @Override
    public void setFeedback(SC sc) {
        studentMapper.setFeedback(sc);
    }

    @Override
    public Student LoginStudent(Student student) {
        return studentMapper.LoginStudent(student);
    }

    @Override
    public void UpdateStudentPassword(Student student) {
        studentMapper.UpdateStudentPassword(student);
    }
}
