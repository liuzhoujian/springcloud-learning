package com.lzj.consumerserviceribbon.controller;

import com.lzj.consumerserviceribbon.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/findAll")
    public List<Student> findAll() {
        String url = "http://provider-service/student/findAll";
        List<Student> students = restTemplate.getForEntity(url, List.class).getBody();
        return students;
    }
}
