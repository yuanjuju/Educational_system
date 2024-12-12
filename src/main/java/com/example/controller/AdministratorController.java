package com.example.controller;


import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/add_student")
    public Result AddStudent(Student student){
        log.info("添加学生：{}",student);
        AdministratorService.AddStudent(student);
        return Result.success();
    }
}
