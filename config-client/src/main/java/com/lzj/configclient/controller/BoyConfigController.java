package com.lzj.configclient.controller;

import com.lzj.configclient.config.BoyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoyConfigController {

    @Autowired
    private BoyConfig boyConfig;

    @GetMapping("/boy")
    public String boy() {
        return "姓名：" + boyConfig.getName() + "，性别：" + boyConfig.getSex()
                + "，年龄:" + boyConfig.getAge();
    }

    /**
     * 推荐这种方式，将配置文件对应为一个实体类，统一管理
     */
}
