package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer teacher_id; //ID
    private String teacher_position; //职位
    private String teacher_name; //姓名
    private Short teacher_sex; //性别 , 1 男, 2 女
    private Integer teacher_dept_id; //学院ID
    private String teacher_no;
    private String teacher_password;
    private String new_password; //准备修改的新密码

}
