package com.pfeffer.modulith.order.infra.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.order.name}")
    private String orderExchange;

    @Value("${rabbitmq.binding.order.name}")
    private String orderRoutingKey;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessage(Object obj) {
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey, obj);
    }

}
