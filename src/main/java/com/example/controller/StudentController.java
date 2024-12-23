package com.example.controller;


import com.example.pojo.*;
import com.example.service.AdministratorService;
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

    //分页查看选课
//    @GetMapping("/get_courses")
//    @ResponseBody
//    public Result page(@RequestParam(defaultValue ="1") Integer page,
//                       @RequestParam(defaultValue ="10") Integer pageSize
//){
//        log.info("分页查询，参数：{}，{}",page,pageSize);
////        调用Service
//        PageBean<Course> pageBean = studentService.page(page, pageSize);
//        return Result.success(pageBean);
//    }




//    选课功能
    @PostMapping("/select_course")

    public  Result selectCourse(@RequestBody SC sc){
        log.info("查询选课：{}",sc);
        studentService.selectCourse(sc);
        return Result.success();

    }




//    查询成绩功能
    @GetMapping("/get_grades/{student_id}")
    public Result selectGrade(@PathVariable Integer student_id){
        log.info("查询学生成绩：{}",student_id);
        List<SC> sc=studentService.selectGrade(student_id);
        return Result.success(sc);
    }



//    查询课表功能
    @GetMapping("/get_timetable/{student_id}")
    public Result selectTable(@PathVariable Integer student_id){
        log.info("查询学生课表：{}",student_id);
        List<Course> course=studentService.selectTable(student_id);
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

    /**
     * 查找学生信息接口
     * @param studentNo 学号
     * @param studentName 姓名
     * @param studentDept 院系名称
     * @param studentDOB 生日
     * @param studentSex 性别
     * @param page 分页页码
     * @param pageSize 每页记录数
     * @return 响应数据
     */
    @GetMapping("/admin/find_student")
    public Result findStudent(
            @RequestParam(value = "student_no", required = false) String studentNo,
            @RequestParam(value = "student_name", required = false) String studentName,
            @RequestParam(value = "student_dept", required = false) String studentDept,
            @RequestParam(value = "student_DOB", required = false) String studentDOB,
            @RequestParam(value = "student_sex", required = false) String studentSex,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {


        // 调用服务层方法获取学生数据
        List<Student> students = studentService.findStudents(studentNo, studentName, studentDept, studentDOB, studentSex, page, pageSize);
        int total = studentService.getTotalCount(studentNo, studentName, studentDept, studentDOB, studentSex);

        // 判断是否有符合条件的学生
        if (students.isEmpty()) {
            return Result.error("没有符合条件的信息");
        } else {
            // 包装数据为分页结果
            return Result.success(students); // 返回查询结果
        }
    }









}
