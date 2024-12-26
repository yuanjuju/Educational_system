package com.example.service.impl;

import com.example.mapper.CourseMapper;
import com.example.mapper.SCMapper;
import com.example.pojo.Course;
import com.example.pojo.StudentGrade;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private SCMapper studentCourseMapper;


    @Autowired
    private CourseMapper courseMapper;


    public List<Course> findCourses(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot,
                                    int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return courseMapper.findCourses(courseNo, courseName, credit, dayOfWeek, timeSlot,  offset, pageSize);
    }


    public int getTotalCount(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot) {
        return courseMapper.getTotalCount(courseNo, courseName, credit, dayOfWeek, timeSlot);
    }


    public List<Course> getCoursesByTeacherId(int teacherId) {
        return courseMapper.findCoursesByTeacherId(teacherId);
    }
    public List<StudentGrade> getStudentsByCourseId(int courseId) {
        return studentCourseMapper.findStudentsByCourseId(courseId);
    }
    public List<Course> getCourses(int page, int pageSize) {
        int offset = (page - 1) * pageSize;  // 计算分页偏移量
        return courseMapper.getCourses(offset, pageSize);
    }

    public int getTotalCourseCount() {
        return courseMapper.getTotalCourseCount();
    }



    public int getTotalCoursesCount(String course_no, String course_name, Float credit, String day_of_week, String time_slot) {
        return courseMapper.getTotalCoursesCount(course_no, course_name, credit, day_of_week, time_slot);
    }
}