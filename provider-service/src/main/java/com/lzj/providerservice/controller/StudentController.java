package com.lzj.providerservice.controller;

import com.lzj.providerservice.bean.Student;
import com.lzj.providerservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/student/findAll")
    public List<Student> findAll() {
        int i = 1 / 0;
        System.out.println("调用服务：" + port);
        List<Student> students = studentService.findAll();
        return students;
    }
}
