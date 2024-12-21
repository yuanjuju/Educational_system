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

    /**
     * 查找符合条件的课程（分页）
     * @param courseNo 课程号
     * @param courseName 课程名称
     * @param credit 学分
     * @param dayOfWeek 上课星期
     * @param timeSlot 上课时间段
     * @param teacherName 授课教师姓名
     * @param page 分页页码
     * @param pageSize 每页记录数
     * @return 符合条件的课程列表
     */
    public List<Course> findCourses(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot,
                                    String teacherName, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return courseMapper.findCourses(courseNo, courseName, credit, dayOfWeek, timeSlot, teacherName, offset, pageSize);
    }

    /**
     * 获取符合条件的课程总数
     * @param courseNo 课程号
     * @param courseName 课程名称
     * @param credit 学分
     * @param dayOfWeek 上课星期
     * @param timeSlot 上课时间段
     * @param teacherName 授课教师姓名
     * @return 总记录数
     */
    public int getTotalCount(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot, String teacherName) {
        return courseMapper.getTotalCount(courseNo, courseName, credit, dayOfWeek, timeSlot, teacherName);
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



    public int getTotalCoursesCount(String course_no, String course_name, Float credit, String day_of_week, String time_slot, String teacher_name) {
        return courseMapper.getTotalCoursesCount(course_no, course_name, credit, day_of_week, time_slot, teacher_name);
    }
}