package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    // Course.java

        private int course_id;
        private String course_name;
        private double credit;
        private String teacher_id;
        private String teacher_name;   //老师的名字
        private String day_of_week;    // 新增字段：星期几
        private String time_slot;   // 新增字段：时间段

        @Column(name = "course_no")
        private String course_no;  // 显式指明数据库列名



        private int CourseID;
        private String CourseName;
        private double Credits;
        private String TeacherID;
        private String DayOfWeek;    // 新增字段：星期几
        private String TimePeriod;   // 新增字段：时间段
        private String Name;




}
