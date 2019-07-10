package com.lzj.Feign;

import com.lzj.bean.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "provider-service")
public interface ConsumerFeign {

    @GetMapping("/student/findAll")
    public List<Student> findAll();
}
