package com.example.service;

import com.example.pojo.Course;
import com.example.pojo.StudentGrade;

import java.util.List;

public interface CourseService {
    List<Course> findCourses(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot, int page, int pageSize);

    int getTotalCount(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot);
    List<Course> getCoursesByTeacherId(int teacherId);

    List<StudentGrade> getStudentsByCourseId(int courseId);

    List<Course> getCourses(int page, int pageSize);

    int getTotalCourseCount();

    int getTotalCoursesCount(String courseNo, String courseName, Float credit, String dayOfWeek, String timeSlot);
}
