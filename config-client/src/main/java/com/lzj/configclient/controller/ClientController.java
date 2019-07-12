package com.lzj.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String name() {
        return this.name;
    }

    /**
     * 不推荐这种方式：配置文件分散
     *
     * Post请求手动刷新
     * http://127.0.0.1:9091/actuator/refresh  启动刷新器 从config server读取
     */
}
