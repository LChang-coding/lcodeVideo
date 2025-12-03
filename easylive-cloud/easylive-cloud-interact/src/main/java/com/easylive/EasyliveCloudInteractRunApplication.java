package com.easylive;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.easylive")
@MapperScan(basePackages = {"com.easylive.mappers"})
@EnableFeignClients
@EnableTransactionManagement
public class EasyliveCloudInteractRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyliveCloudInteractRunApplication.class, args);
    }
}
