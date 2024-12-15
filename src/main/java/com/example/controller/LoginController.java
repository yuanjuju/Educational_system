package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.service.LoginService;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utils.JwtUtils;


import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;

//    学生登录
    @PostMapping("/student")
    public Result LoginStudent(@RequestBody Student student){
        log.info("学生登录：{}",student);
        Student stu=studentService.LoginStudent(student);
//        登录成功，生成令牌
        if(stu!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("student_id",stu.getStudent_id());// 学生唯一标识ID
            claims.put("name",stu.getStudent_name());// 学生姓名
            claims.put("username",stu.getStudent_no());// 学生学号，作为登录用户名
            String jwt=JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

//        登录失败，报错
        return stu!=null?Result.success():Result.error("用户名或密码错误");

    }


//    修改学生密码
    @PostMapping("/updatestudent")
    public Result UpdateStudentPassword(@RequestBody Student student){
        log.info("学生密码修改：{}",student);
        studentService.UpdateStudentPassword(student);
        return Result.success();
    }




    @Autowired
    private TeacherService teacherService;
    //    老师登录
//    有bug，需要修改
    @PostMapping("/teacher")
    public Result LoginTeacher(@RequestBody Teacher teacher){
        log.info("老师登录：{}",teacher);
        Teacher tea=teacherService.LoginTeacher(teacher);
        // 输出 tea 的值来检查是否为 null
        if (tea == null) {
            log.warn("登录失败，返回的 tea 为 null");
        } else {
            log.info("登录成功，返回的 Teacher: {}", tea);
        }
//        登录成功，生成令牌
        if(tea!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("teacher_id",tea.getTeacher_id());// 老师唯一标识ID
            claims.put("name",tea.getTeacher_name());// 老师姓名
            claims.put("username",tea.getTeacher_no());// 老师工号，作为登录用户名
            String jwt=JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

//        登录失败，报错
        return tea!=null?Result.success():Result.error("用户名或密码错误");

    }


//    修改老师密码
    @PostMapping("updateteacher")
    public Result UpdateTeacherPassword(@RequestBody Teacher teacher){
        log.info("老师密码修改：{}",teacher);
        teacherService.UpdateTeacherPassword(teacher);
        return Result.success();
    }



}
