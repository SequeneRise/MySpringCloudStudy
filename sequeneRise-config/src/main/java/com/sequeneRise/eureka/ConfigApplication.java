package com.sequeneRise.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
@RefreshScope
@EnableEurekaClient
public class ConfigApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
    @Bean
    public String ac(){
        System.out.println(env.getProperty("mysql.driverClassName"));
        return "";
    }
}
