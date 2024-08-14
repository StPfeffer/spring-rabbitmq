package com.pfeffer.modulith.inventory.infra.rabbitmq;

import com.pfeffer.modulith.inventory.dto.OrderDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.order.name}"})
    public void handleMessage(OrderDTO message) {
        System.out.println("Received message: " + message);
    }

}
