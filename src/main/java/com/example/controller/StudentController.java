package com.example.controller;


import com.example.pojo.*;
import com.example.service.StudentService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    private Integer studentID;

    //分页查看选课
    @GetMapping("/get_courses")
    @ResponseBody
    public Result page(@RequestParam(defaultValue ="1") Integer page,
                       @RequestParam(defaultValue ="10") Integer pageSize
){
        log.info("分页查询，参数：{}，{}",page,pageSize);
//        调用Service
        PageBean<Course> pageBean = studentService.page(page, pageSize);
        return Result.success(pageBean);
    }




//    选课功能
    @PostMapping("/select_course")

    public  Result selectCourse(@RequestBody SC sc){
        log.info("查询选课：{}",sc);
        studentService.selectCourse(sc);
        return Result.success();

    }




//    查询成绩功能
    @GetMapping("/get_grades/{StudentID}")
    public Result selectGrade(@PathVariable Integer StudentID){
        log.info("查询学生成绩：{}",StudentID);
        List<SC> sc=studentService.selectGrade(StudentID);
        return Result.success(sc);
    }



//    查询课表功能
    @GetMapping("/get_timetable/{StudentID}")
    public Result selectTable(@PathVariable Integer StudentID){
        log.info("查询学生课表：{}",StudentID);
        List<Course> course=studentService.selectTable(StudentID);
        return Result.success(course);
    }




//    删除选课功能
    @PostMapping("/deselect_course")
    public Result deleteCourse(@RequestBody SC sc){
        log.info("删除选课：{}",sc);
        studentService.deleteCourse(sc);
        return Result.success();
    }


//    修改选课信息
//    有bug需要改
    @PostMapping("/update_course_selection")
    public Result updateBook(@RequestBody SC sc){
        log.info("更新选课信息：{}",sc);
        studentService.updateBook(sc);
        return Result.success();
    }




//    教学反馈
    @PostMapping("/submit_feedback")
    public Result setFeedback(@RequestBody SC sc){
        log.info("教学反馈：{}",sc);
        studentService.setFeedback(sc);
        return Result.success();
    }







}
