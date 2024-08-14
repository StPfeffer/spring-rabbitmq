package com.pfeffer.modulith.order.service;

import com.pfeffer.modulith.order.dto.OrderDTO;
import com.pfeffer.modulith.order.infra.rabbitmq.RabbitMQProducer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final RabbitMQProducer producer;

    public OrderService(RabbitMQProducer producer) {
        this.producer = producer;
    }

    public void publishMessages(OrderDTO... orders) {
        for (OrderDTO order : orders) {
            producer.publishMessage(order);
        }
    }

}
