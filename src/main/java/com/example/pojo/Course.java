package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        private String course_no;

}
