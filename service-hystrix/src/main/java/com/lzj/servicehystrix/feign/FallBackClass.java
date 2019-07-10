package com.lzj.servicehystrix.feign;

import bean.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FallBackClass implements ConsumerFeign{

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(0L, "ERROR", -1, "错误"));
        return studentList;
    }
}
