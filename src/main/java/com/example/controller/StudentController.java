package com.example.controller;


import com.example.pojo.*;
import com.example.service.AdministratorService;
import com.example.service.CourseService;
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

    @Autowired
    private CourseService courseService;

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



    @GetMapping("/get_courses")
    public Result getCourses(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        // 获取分页数据

        List<Course> courses = courseService.getCourses(page, pageSize);
        // 获取总数
        int total = courseService.getTotalCourseCount();

        if (courses.isEmpty()) {
            return Result.error("课程查询失败");
        } else {
            return Result.success(new Object[]{total, courses});
        }
    }

    @GetMapping("/find_course")
    public Result findCourses(@RequestParam(value = "course_no", required = false) String course_no,
                              @RequestParam(value = "course_name", required = false) String course_name,
                              @RequestParam(value = "credit", required = false) Float credit,
                              @RequestParam(value = "day_of_week", required = false) String day_of_week,
                              @RequestParam(value = "time_slot", required = false) String time_slot,
                              @RequestParam(value = "teacher_name", required = false) String teacher_name,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 获取符合条件的课程
        List<Course> courses = courseService.findCourses(course_no, course_name, credit, day_of_week, time_slot, teacher_name, page, pageSize);
        int total = courseService.getTotalCoursesCount(course_no, course_name, credit, day_of_week, time_slot, teacher_name);

        if (courses.isEmpty()) {
            return Result.error("查找课程失败");
        } else {
            return Result.success(new Object[]{total, courses});
        }
    }





}
