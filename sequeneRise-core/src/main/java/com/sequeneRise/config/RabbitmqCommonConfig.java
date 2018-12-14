package com.sequeneRise.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitmqCommonConfig {

    @Bean
    public static CachingConnectionFactory connectionFactory(Environment env){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(env.getProperty("username"));
        connectionFactory.setPassword(env.getProperty("password"));
        connectionFactory.setHost(env.getProperty("host"));
        connectionFactory.setPort(env.getProperty("port",Integer.class));
        connectionFactory.setVirtualHost(env.getProperty("virtualHost"));
        return connectionFactory;
    }
}
