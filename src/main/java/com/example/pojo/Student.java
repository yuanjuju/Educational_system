package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer StudentID; //ID
    private String Username; //用户名
    private String Password; //密码
    private String Name; //姓名
    private Short gender; //性别 , 1 男, 2 女
    private Integer DeptID; //学院ID
    private LocalDateTime DOB; //创建时间
}
