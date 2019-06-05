package com.supwisdom.platform.portal.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.supwisdom.platform.portal.service.framework.config",
        "com.supwisdom.platform.portal.kafka" }, exclude = { DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class })
@EnableSwagger2
@Configuration
@EnableScheduling
public class MessageCenterKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageCenterKafkaApplication.class, args);
    }
}
