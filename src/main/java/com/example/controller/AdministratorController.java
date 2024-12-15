package com.example.controller;


import com.example.pojo.*;
import com.example.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

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

}
