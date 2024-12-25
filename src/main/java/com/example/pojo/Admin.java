package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer admin_no;
    private String username; //用户名
    private String password; //密码
    private String new_password; //准备修改的新密码
}
