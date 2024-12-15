package com.example.service.impl;

import com.example.mapper.AdministratorMapper;
import com.example.pojo.Course;
import com.example.pojo.SC;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.AdministratorService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    @Override
    public void AddStudent(Student student) {
        administratorMapper.AddStudent(student);
    }

    @Override
    public void AddTeacher(Teacher teacher) {
        administratorMapper.AddTeacher(teacher);
    }

    @Override
    public void AddCourse(Course course) {
        administratorMapper.AddCourse(course);
    }

    @Override
    public void AddSC(SC sc) {
        administratorMapper.AddSC(sc);
    }

    @Override
    public void DeleteStudent(Integer student_id) {
        administratorMapper.DeleteStudent(student_id);
    }

    @Override
    public void DeleteTeacher(Integer teacher_id) {
        administratorMapper.DeleteTeacher(teacher_id);
    }

    @Override
    public void DeleteCourse(Integer courseId) {
        administratorMapper.DeleteCourse(courseId);
    }

    @Override
    public void DeleteSC(Integer studentId, Integer courseId) {
        administratorMapper.DeleteSC(studentId,courseId);
    }

    @Override
    public void UpdateStudent(Student student) {
        administratorMapper.UpdateStudent(student);
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        administratorMapper.UpdateTeacher(teacher);
    }

    @Override
    public void UpdateCourse(Course course) {
        administratorMapper.UpdateCourse(course);
    }

    @Override
    public void UpdateSC(SC sc) {
        administratorMapper.UpdateSC(sc);
    }
}
