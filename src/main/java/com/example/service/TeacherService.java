package com.example.service;

import com.example.pojo.Teacher;

public interface TeacherService {
    Teacher LoginTeacher(Teacher teacher);

    void UpdateTeacherPassword(Teacher teacher);
}
