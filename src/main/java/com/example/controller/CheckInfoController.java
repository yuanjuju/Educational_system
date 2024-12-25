package com.example.controller;



import com.example.mapper.StudentMapper;
import com.example.pojo.*;
import com.example.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/CheckInfo")
public class CheckInfoController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/studentInfo/{student_no}")
    public Result CheckstudentInfo(@PathVariable String student_no){
        log.info("查询学生：{}", student_no);
        List<Student> students =studentService.CheckstudentInfo(student_no);
        log.info("查询学生xinxi：{}", students);
        return Result.success(students);

    }

    @GetMapping("/teacherInfo/{teacher_no}")
    public Result CheckteacherInfo(@PathVariable String teacher_no){
        log.info("查询老师：{}", teacher_no);
        List<Teacher> teachers =teacherService.CheckteacherInfo(teacher_no);
        log.info("查询老师信息：{}", teachers);
        return Result.success(teachers);
    }


    @GetMapping("/adminInfo/{admin_no}")
    public Result CheckadminInfo(@PathVariable String admin_no){
        log.info("查询管理员：{}", admin_no);
        List<Admin> admins =administratorService.CheckadminInfo(admin_no);
        log.info("查管理员信息：{}", admins);
        return Result.success(admins);
    }
}
