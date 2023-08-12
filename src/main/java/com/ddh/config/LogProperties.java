package com.ddh.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "log")
@Data
public class LogProperties {
    /**
     * 是否开启日志
     */
    private boolean enable;

    @Value("${spring.application.name:#{null}}")
    private String platform;


}
