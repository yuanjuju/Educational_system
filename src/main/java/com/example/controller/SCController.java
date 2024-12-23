package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.SC;
import com.example.service.impl.SCServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SCController {

    @Autowired
    private SCServiceImpl studentCourseService;



}
