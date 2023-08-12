package com.ddh.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnProperty：作用是可以指定prefix.name 配置文件中的属性值来判定configuration是否被注入到Spring,
 * 就拿上面代码的来说，会根据配置文件中是否配置jd.enable 来判断是否需要加载JdLogAutoConfiguration 类，
 * 如果配置文件中不存在或者配置的是等于false 都不会进行加载，如果配置成true 则会加载；指定了havingValue，
 * 要把配置项的值与havingValue对比，一致则加载Bean;配置文件缺少配置，但配置了matchIfMissing = true，加载Bean，否则不加载。
 *

 */
@Configuration
@ComponentScan("com.ddh")
@ConditionalOnProperty(prefix = "log", name = "enable", havingValue = "true", matchIfMissing = false)
@EnableConfigurationProperties({LogProperties.class})
public class LogAutoConfiguration {
}
