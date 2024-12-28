package com.example.service;

import com.example.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher LoginTeacher(Teacher teacher);

    void UpdateTeacherPassword(Teacher teacher);

    List<Teacher> findTeachers(String teacherNo, String teacherName, String teacherDept, String teacherPosition, int page, int pageSize);

    int getTotalCount(String teacherNo, String teacherName, String teacherDept, String teacherPosition);

    List<Teacher> CheckteacherInfo(String teacher_no);

    List<Teacher> findTeachersByIds(List<String> teacherIDs);
}
