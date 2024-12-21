package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrade {
    private Integer student_id;  // 学生ID
    private String student_name; // 学生姓名
    private Float grade;         // 学生成绩
}
