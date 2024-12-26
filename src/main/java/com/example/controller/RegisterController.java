package com.example.controller;


import com.example.pojo.Admin;
import com.example.pojo.Result;
import com.example.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/admin")
    public Result RegisterAdmin(@RequestBody Admin admin){
        log.info("注册管理员：{}",admin);
        administratorService.RegisterAdmin(admin);
        return Result.success();
    }
}
