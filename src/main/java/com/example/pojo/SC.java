package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SC {
    private Integer courseID;
    private Integer StudentID;
    private String courseName;
    private Double grade;
    private Integer BuyBook;  // 1购买书，2不购买
    private String feedback;  //反馈

}
