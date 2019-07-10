package com.lzj.servicehystrix.feign;

import bean.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "provider-service", fallback = FallBackClass.class)
public interface ConsumerFeign {

    @GetMapping("/student/findAll")
    public List<Student> findAll();
}
