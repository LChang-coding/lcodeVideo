package com.easylive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.easylive", exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class EasyliveCloudResourceRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyliveCloudResourceRunApplication.class, args);
    }
}
