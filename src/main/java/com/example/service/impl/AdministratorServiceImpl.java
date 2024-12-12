package com.example.service.impl;

import com.example.mapper.AdministratorMapper;
import com.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl {

    @Autowired
    private AdministratorMapper administratorMapper;
}
