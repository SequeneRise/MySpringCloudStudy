package com.sequeneRise.light;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class LightSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightSearchApplication.class, args);
    }
}
