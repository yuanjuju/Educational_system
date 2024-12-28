package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.pojo.*;
import java.util.List;

@Data
@NoArgsConstructor
public class TeacherAndCourseResponse {
    private String DayOfWeek;
    private Integer TeacherID;
    private String CourseName;
    private int CourseID;
    private String TimePeriod;
    private double Credits;
    private String Name;
    private String Title;
    private String teacher_no;
    public TeacherAndCourseResponse(Course course,Teacher teacher) {

        this.DayOfWeek = course.getDayOfWeek();
        this.TeacherID = teacher.getTeacherID();
        this.CourseID = course.getCourseID();
        this.CourseName = course.getCourseName();
        this.TimePeriod = course.getTimePeriod();
        this.Credits = course.getCredits();
        this.Name = teacher.getName();
        this.Title = teacher.getTitle();
        this.teacher_no = teacher.getTeacher_no();


    }
    // 构造方法、getter、setter


}
