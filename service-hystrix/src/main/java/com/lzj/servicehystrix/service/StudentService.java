package com.lzj.servicehystrix.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String findAll() {
       return "所有学生信息";
    }
}
