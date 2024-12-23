package com.example.controller;


import com.example.pojo.Course;
import com.example.pojo.Result;
import com.example.pojo.StudentGrade;
import com.example.pojo.Teacher;
import com.example.service.CourseService;
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
    private CourseService courseService;


    @GetMapping("/{course_id}")
    public Result getStudentsByCourse(@PathVariable("course_id") int courseId) {
        // 获取选课学生成绩信息
        List<StudentGrade> studentGrades = courseService.getStudentsByCourseId(courseId);

        // 判断是否有学生信息
        if (studentGrades.isEmpty()) {
            return Result.error("成绩查询失败");
        } else {
            // 返回成功响应，包含学生信息和成绩
            return Result.success(studentGrades);
        }
    }

    @GetMapping("/courseInfo/{teacher_id}")
    public Result getTeacherCourseInfo(@PathVariable("teacher_id") int teacherId) {
        // 获取该教师授的所有课程
        List<Course> courses = courseService.getCoursesByTeacherId(teacherId);

        // 判断是否有课程信息
        if (courses.isEmpty()) {
            return Result.error("课程信息查询失败");
        } else {
            // 返回成功响应，包含课程信息
            return Result.success(courses);
        }
    }
}
