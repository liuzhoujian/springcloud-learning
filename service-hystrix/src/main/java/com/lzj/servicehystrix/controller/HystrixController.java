package com.lzj.servicehystrix.controller;

import bean.Student;
import com.lzj.servicehystrix.feign.ConsumerFeign;
import com.lzj.servicehystrix.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HystrixController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ConsumerFeign consumerFeign;

    @HystrixCommand(fallbackMethod = "error") //服务熔断、服务降级、服务隔离(使用新的线程池)
    @GetMapping("/hystrix/findAll")
    public String hystrixFindAll() {
        //当前线程池名称：hystrix-HystrixController-1
        System.out.println("当前线程池名称：" + Thread.currentThread().getName());
        int i = 1 / 0;
        return studentService.findAll();
    }

    @GetMapping("/findAll")
    public String findAll() {
        //当前线程池名称：http-nio-8600-exec-1
        System.out.println("当前线程池名称：" + Thread.currentThread().getName());
        int i = 1 / 0 ;
        return studentService.findAll();
    }

    private String error() {
        return "系统错误！";
    }



    //更常用的方式：feign+hystrix
    @GetMapping("/hystrix/feign/findAll")
    public List<Student> feignFindAll() {
        return consumerFeign.findAll();
    }
}
