package com.sequeneRise.es.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("cc");
        connectionFactory.setPassword("123456");
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/myHost");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate myExchangeTemlate() {
        RabbitTemplate r = new RabbitTemplate(connectionFactory());
        r.setExchange("sequenExchange");
        r.setRoutingKey("routeKey");
        return r;
    }

    @Bean
    public DirectExchange myExchange() {
        return new DirectExchange("sequenExchange", true, false);
    }

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", true);
    }

    @Bean
    public Binding myExchangeBinding(@Qualifier("myExchange") DirectExchange directExchange,
                                     @Qualifier("myQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with("routeKey");
    }

}
