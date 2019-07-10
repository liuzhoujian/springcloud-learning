package com.lzj.controller;


import com.lzj.Feign.ConsumerFeign;
import com.lzj.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerFeignController {

    @Autowired
    private ConsumerFeign feign;


    @GetMapping("/feign/findAll")
    public List<Student> findAll() {
        return feign.findAll();
    }
}
