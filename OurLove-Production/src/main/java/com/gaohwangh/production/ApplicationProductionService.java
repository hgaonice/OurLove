package com.gaohwangh.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: GH
 * @Date: 2019/7/15 19:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gaohwangh.production.dao")
@EnableTransactionManagement//开启事务
public class ApplicationProductionService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationProductionService.class, args);
    }
}
