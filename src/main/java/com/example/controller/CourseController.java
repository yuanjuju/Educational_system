package com.example.controller;

import com.example.pojo.Course;
import com.example.pojo.Result;
import com.example.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    /**
     * 查找课程信息接口
     * @param courseNo 课程号
     * @param courseName 课程名称
     * @param credit 学分
     * @param dayOfWeek 上课星期
     * @param timeSlot 上课时间段
     * @param teacherName 授课教师姓名
     * @param page 分页页码
     * @param pageSize 每页记录数
     * @return 响应数据
     */
    @GetMapping("/admin/find_course")
    public Result findCourse(
            @RequestParam(value = "course_no", required = false) String courseNo,
            @RequestParam(value = "course_name", required = false) String courseName,
            @RequestParam(value = "credit", required = false) Float credit,
            @RequestParam(value = "day_of_week", required = false) String dayOfWeek,
            @RequestParam(value = "time_slot", required = false) String timeSlot,
            @RequestParam(value = "teacher_name", required = false) String teacherName,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 调用服务层方法获取课程数据
        List<Course> courses = courseServiceImpl.findCourses(courseNo, courseName, credit, dayOfWeek, timeSlot, teacherName, page, pageSize);
        int total = courseServiceImpl.getTotalCount(courseNo, courseName, credit, dayOfWeek, timeSlot, teacherName);

        // 判断是否有符合条件的课程
        if (courses.isEmpty()) {
            return Result.error("没有符合条件的信息");
        } else {
            // 返回查询结果
            return Result.success(courses);
        }
    }
    @GetMapping("/teacher/courseInfo/{teacher_id}")
    public Result getTeacherCourseInfo(@PathVariable("teacher_id") int teacherId) {
        // 获取该教师授的所有课程
        List<Course> courses = courseServiceImpl.getCoursesByTeacherId(teacherId);

        // 判断是否有课程信息
        if (courses.isEmpty()) {
            return Result.error("课程信息查询失败");
        } else {
            // 返回成功响应，包含课程信息
            return Result.success(courses);
        }
    }
    @GetMapping("/student/get_courses")
    public Result getCourses(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        // 获取分页数据
        List<Course> courses = courseServiceImpl.getCourses(page, pageSize);
        // 获取总数
        int total = courseServiceImpl.getTotalCourseCount();

        if (courses.isEmpty()) {
            return Result.error("课程查询失败");
        } else {
            return Result.success(new Object[]{total, courses});
        }
    }
    /**
     * 根据条件查询课程信息（分页）
     * @param course_no 课程号
     * @param course_name 课程名称
     * @param credit 学分
     * @param day_of_week 上课时间（星期x）
     * @param time_slot 上课时间（xx:xx-xx:xx）
     * @param teacher_name 授课教师
     * @param page 页码
     * @param pageSize 每页记录数
     * @return 课程信息
     */
    @GetMapping("/student/find_course")
    public Result findCourses(@RequestParam(value = "course_no", required = false) String course_no,
                              @RequestParam(value = "course_name", required = false) String course_name,
                              @RequestParam(value = "credit", required = false) Float credit,
                              @RequestParam(value = "day_of_week", required = false) String day_of_week,
                              @RequestParam(value = "time_slot", required = false) String time_slot,
                              @RequestParam(value = "teacher_name", required = false) String teacher_name,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 获取符合条件的课程
        List<Course> courses = courseServiceImpl.findCourses(course_no, course_name, credit, day_of_week, time_slot, teacher_name, page, pageSize);
        int total = courseServiceImpl.getTotalCoursesCount(course_no, course_name, credit, day_of_week, time_slot, teacher_name);

        if (courses.isEmpty()) {
            return Result.error("查找课程失败");
        } else {
            return Result.success(new Object[]{total, courses});
        }
    }
}
