package com.yr.wechat;

import com.yr.wechat.common.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling//开启定时任务
@SpringBootApplication
@MapperScan(basePackages = "com.yr.wechat.mybatis.mapper")
public class WechatApplication {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    public static void main(String[] args){
        ApplicationContext app = SpringApplication.run(WechatApplication.class, args);
        SpringUtil.setApplicationContext(app);
    }

}
