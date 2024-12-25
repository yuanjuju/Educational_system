package com.example.service;

import com.example.pojo.*;

import java.util.List;


public interface AdministratorService {




    void AddStudent(Student student);

    void AddTeacher(Teacher teacher);

    void AddCourse(Course course);

    void AddSC(SC sc);

    void DeleteStudent(Integer student_id);

    void DeleteTeacher(Integer teacher_id);

    void DeleteCourse(Integer courseId);

    void DeleteSC(Integer studentId, Integer courseId);

    void UpdateStudent(Student student);

    void UpdateTeacher(Teacher teacher);

    void UpdateCourse(Course course);

    void UpdateSC(SC sc);

    List<Admin> CheckadminInfo(String admin_no);
}
