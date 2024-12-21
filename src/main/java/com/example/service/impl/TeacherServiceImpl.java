package com.example.service.impl;

import com.example.mapper.TeacherMapper;
import com.example.pojo.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Teacher> findTeachers(String teacherNo, String teacherName, String teacherDept, String teacherPosition, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return teacherMapper.findTeachers(teacherNo, teacherName, teacherDept, teacherPosition, offset, pageSize);
    }

    /**
     * 获取符合条件的教师总数
     * @param teacherNo 工号
     * @param teacherName 姓名
     * @param teacherDept 院系名称
     * @param teacherPosition 职位
     * @return 总记录数
     */
    public int getTotalCount(String teacherNo, String teacherName, String teacherDept, String teacherPosition) {
        return teacherMapper.getTotalCount(teacherNo, teacherName, teacherDept, teacherPosition);
    }
}



