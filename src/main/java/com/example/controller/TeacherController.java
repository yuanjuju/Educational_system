package com.example.controller;


import com.example.pojo.Result;
import com.example.pojo.StudentGrade;
import com.example.pojo.Teacher;
import com.example.service.TeacherService;
import com.example.service.impl.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @GetMapping("/admin/find_teacher")
    public Result findTeacher(
            @RequestParam(value = "teacher_no", required = false) String teacherNo,
            @RequestParam(value = "teacher_name", required = false) String teacherName,
            @RequestParam(value = "teacher_dept", required = false) String teacherDept,
            @RequestParam(value = "teacher_position", required = false) String teacherPosition,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 调用服务层方法获取教师数据
        List<Teacher> teachers = teacherService.findTeachers(teacherNo, teacherName, teacherDept, teacherPosition, page, pageSize);
        int total = teacherService.getTotalCount(teacherNo, teacherName, teacherDept, teacherPosition);

        // 判断是否有符合条件的教师
        if (teachers.isEmpty()) {
            return Result.error("没有符合条件的信息");
        } else {
            // 返回查询结果
            return Result.success(teachers);
        }
    }
    @GetMapping("/teacher/{course_id}")
    public Result getStudentsByCourse(@PathVariable("course_id") int courseId) {
        // 获取选课学生成绩信息
        List<StudentGrade> studentGrades = courseServiceImpl.getStudentsByCourseId(courseId);

        // 判断是否有学生信息
        if (studentGrades.isEmpty()) {
            return Result.error("成绩查询失败");
        } else {
            // 返回成功响应，包含学生信息和成绩
            return Result.success(studentGrades);
        }
    }
}
