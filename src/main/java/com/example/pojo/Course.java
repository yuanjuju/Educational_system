package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    // Course.java

        private int courseID;
        private String courseName;
        private double credits;
        private String teacherID;
        private String Name;   //老师的名字
        private String dayOfWeek;    // 新增字段：星期几
        private String timePeriod;   // 新增字段：时间段


}
