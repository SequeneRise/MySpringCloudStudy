package com.sequeneRise.user.config;

import com.sequeneRise.config.RabbitmqCommonConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 消息队列配置
 */
@Configuration
public class RabbitConfig {

    @Autowired
    private Environment env;

    @Bean
    public CachingConnectionFactory connectionFactory(){
        return RabbitmqCommonConfig.connectionFactory(env);
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
