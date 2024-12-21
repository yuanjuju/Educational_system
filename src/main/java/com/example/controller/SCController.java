package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.SC;
import com.example.service.impl.SCServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SCController {

    @Autowired
    private SCServiceImpl studentCourseService;

    /**
     * 查找选课记录接口
     * @param studentNo 学号
     * @param courseNo  课程号
     * @param buyTextbook 是否购买教材
     * @param minGrade 最低成绩
     * @param maxGrade 最高成绩
     * @param page 页码
     * @param pageSize 每页记录数
     * @return 响应数据
     */
    @GetMapping("/admin/find_SC")
    public Result findStudentCourse(
            @RequestParam(value = "student_no", required = false) String studentNo,
            @RequestParam(value = "course_no", required = false) String courseNo,
            @RequestParam(value = "buy_textbook", required = false) String buyTextbook,
            @RequestParam(value = "min_grade", required = false) Float minGrade,
            @RequestParam(value = "max_grade", required = false) Float maxGrade,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        // 调用服务层方法获取选课记录
        List<SC> studentCourses = studentCourseService.findStudentCourses(studentNo, courseNo, buyTextbook, minGrade, maxGrade, page, pageSize);
        int total = studentCourseService.getTotalCount(studentNo, courseNo, buyTextbook, minGrade, maxGrade);

        // 判断是否有符合条件的选课记录
        if (studentCourses.isEmpty()) {
            return Result.error("没有符合条件的选课记录");
        } else {
            // 返回查询结果
            return Result.success(studentCourses);
        }
    }
}
