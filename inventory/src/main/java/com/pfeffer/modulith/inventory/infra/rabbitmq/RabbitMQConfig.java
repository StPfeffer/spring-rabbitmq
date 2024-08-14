package com.pfeffer.modulith.inventory.infra.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.order.name}")
    private String orderQueue;

    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;

    @Value("${rabbitmq.binding.order.name}")
    private String routingKey;

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue, true);
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue())
                .to(orderExchange())
                .with(routingKey);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());

        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

}
