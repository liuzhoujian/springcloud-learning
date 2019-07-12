package com.lzj.configclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 对应git上面的配置文件
 */
@Data
@Component
@ConfigurationProperties(prefix = "boy")
@RefreshScope
public class BoyConfig {
    private String name;
    private String sex;
    private Integer age;
}
