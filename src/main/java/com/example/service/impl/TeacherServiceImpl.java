package com.example.service.impl;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher LoginTeacher(Teacher teacher) {
        return teacherMapper.LoginTeacher(teacher);
    }

    @Override
    public void UpdateTeacherPassword(Teacher teacher) {
        teacherMapper.UpdateTeacherPassword(teacher);
    }
}



