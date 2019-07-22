package com.gaohwangh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: GH
 * @Date: 2019/7/15 19:47
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEurekaService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaService.class, args);
    }
}
