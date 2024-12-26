package com.example.controller;


import com.example.mapper.StudentMapper;
import com.example.pojo.*;
import com.example.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SCService scService;
    @Autowired
    private TeacherService teacherService;
    //    添加学生功能
    @PostMapping("/add_student")
    public Result AddStudent(@RequestBody Student student) {
        log.info("添加学生：{}", student);
        administratorService.AddStudent(student);
        return Result.success();
    }



//        增加教师功能
    @PostMapping("/add_teacher")
    public Result AddTeacher(@RequestBody Teacher teacher){
        log.info("添加老师：{}",teacher);
        administratorService.AddTeacher(teacher);
        return Result.success();
    }

//    增加课程
    @PostMapping("/add_course")
    public Result AddCourse(@RequestBody Course course){
        log.info("添加课程：{}",course);
        administratorService.AddCourse(course);
        return Result.success();
    }

//    增加选课
    @PostMapping("/add_SC")
    public Result AddSC(@RequestBody SC sc){
        log.info("添加选课：{}",sc);
        administratorService.AddSC(sc);
        return Result.success();
    }




//   删除学生
    @DeleteMapping("/delete_student/{student_id}")
    public  Result DeleteStudent(@PathVariable Integer student_id){
        log.info("删除学生：{}",student_id);
        administratorService.DeleteStudent(student_id);
        return Result.success();

    }


    //删除老师
    @DeleteMapping("/delete_teacher/{teacher_id}")
    public  Result DeleteTeacher(@PathVariable Integer teacher_id){
        log.info("删除老师：{}",teacher_id);
        administratorService.DeleteTeacher(teacher_id);
        return Result.success();
}


//  删除课程
    @DeleteMapping("/delete_course/{course_id}")
    public Result DeleteCourse(@PathVariable Integer course_id){

        log.info("删除课程：{}",course_id);
        administratorService.DeleteCourse(course_id);
        return Result.success();
    }


//    删除选课
//    这里有点bug，需要改
    @DeleteMapping("/delete_SC/{student_id}/{course_id}")
    public Result DeleteSC(@PathVariable Integer student_id,@PathVariable Integer course_id){
        log.info("删除选课：{},{}",student_id,course_id);
        administratorService.DeleteSC(student_id,course_id);
        return Result.success();
    }




//    修改学生
    @PutMapping("/update_student")
    public  Result UpdateStudent(@RequestBody Student student){
        log.info("修改学生:{}",student);
        administratorService.UpdateStudent(student);
        return Result.success();
    }


//    修改教师
    @PutMapping("/update_teacher")
    public Result UpdateTeacher(@RequestBody Teacher teacher){
        log.info("修改老师:{}",teacher);
        administratorService.UpdateTeacher(teacher);
        return Result.success();
    }

//    修改课程
    @PutMapping("/update_course")
    public Result UpdateCourse(@RequestBody Course course)
    {
        log.info("更新选课：{}",course);
        administratorService.UpdateCourse(course);
        return Result.success();
    }

//    修改选课
    @PutMapping("/update_SC")
    public Result UpdateSC(@RequestBody SC sc){
        log.info("修改选课：{}",sc);
        administratorService.UpdateSC(sc);
        return Result.success();
    }

    @GetMapping("/find_student")
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

        System.out.print(students);
        // 判断是否有符合条件的学生
        if (students.isEmpty()) {
            return Result.error("没有符合条件的信息");
        } else {
            // 包装数据为分页结果
            return Result.success(students); // 返回查询结果
        }
    }

    @GetMapping("/find_course")
    public Result findCourse(
            @RequestParam(value = "course_no", required = false) String courseNo,
            @RequestParam(value = "course_name", required = false) String courseName,
            @RequestParam(value = "credit", required = false) Float credit,
            @RequestParam(value = "day_of_week", required = false) String dayOfWeek,
            @RequestParam(value = "time_slot", required = false) String timeSlot,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 调用服务层方法获取课程数据

        System.out.print(courseNo);
        System.out.print(courseNo);
        System.out.print(courseNo);
        List<Course> courses = courseService.findCourses(courseNo, courseName, credit, dayOfWeek, timeSlot, page, pageSize);
        int total = courseService.getTotalCount(courseNo, courseName, credit, dayOfWeek, timeSlot);


        System.out.print(courses);
        // 判断是否有符合条件的课程
        if (courses.isEmpty()) {
            return Result.error("没有符合条件的信息");
        } else {
            // 返回查询结果
            return Result.success(courses);
        }
    }

    @GetMapping("/find_SC")
    public Result findStudentCourse(
            @RequestParam(value = "student_no", required = false) String studentNo,
            @RequestParam(value = "course_no", required = false) String courseNo,
            @RequestParam(value = "buy_textbook", required = false) String buyTextbook,
            @RequestParam(value = "min_grade", required = false) Float minGrade,
            @RequestParam(value = "max_grade", required = false) Float maxGrade,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        System.out.print(buyTextbook);
        List<SC> studentCourses;
        // 调用服务层方法获取选课记录
        if(buyTextbook.isEmpty())
        {

            studentCourses = scService.findStudentCourses(studentNo, courseNo, 1, minGrade, maxGrade, page, pageSize);
            int total = scService.getTotalCount(studentNo, courseNo, 1, minGrade, maxGrade);
        }
        if(Objects.equals(buyTextbook, "是"))
        {
            studentCourses = scService.findStudentCourses(studentNo, courseNo, 1, minGrade, maxGrade, page, pageSize);
            int total = scService.getTotalCount(studentNo, courseNo, 1, minGrade, maxGrade);

        }
        else
        {
            studentCourses = scService.findStudentCourses(studentNo, courseNo, 0, minGrade, maxGrade, page, pageSize);
            int total = scService.getTotalCount(studentNo, courseNo, 0, minGrade, maxGrade);
        }


        // 判断是否有符合条件的选课记录
        if (studentCourses.isEmpty()) {
            return Result.error("没有符合条件的选课记录");
        } else {
            // 返回查询结果
            return Result.success(studentCourses);
        }
    }

    @GetMapping("/find_teacher")
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
}
