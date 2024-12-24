package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SC {
    private Integer course_id;
    private Integer student_id;
    private String course_name;
    private Double grade;
    private Integer buy_textbook;  // 1购买书，2不购买
    private String feedback;  //反馈

    private Integer StudentID;
    private Integer CourseID;
    private Double Grade;
    private Integer BuyBook;  // 1购买书，2不购买


}
