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
    private Integer student_id; //ID
    private String Username; //用户名
    private String password; //密码
    private String student_name; //姓名
    private Short student_sex; //性别 , 1 男, 2 女
    private Integer student_dept_id; //学院ID
    private LocalDate student_DOB; //创建时间
    private  String student_no;
    private String new_password; //准备修改的新密码

    private Integer studentID; //ID
    private String Password; //密码
    private String Name; //姓名
    private Short Gender; //性别 , 1 男, 2 女
    private Integer DeptID; //学院ID
    private LocalDate DOB; //创建时间

}
