package com.pfeffer.modulith.order;

import com.pfeffer.modulith.order.dto.OrderDTO;
import com.pfeffer.modulith.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@EnableRabbit
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args)
                .getBean(OrderService.class)
                .publishMessages(
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "ABC"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "DEF"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "GHI"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "JKL"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "MNO"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "PQR"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "STU"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "VWX"),
                        new OrderDTO(String.valueOf(new Random().nextInt() * 10), new Random().nextDouble() * 100, "YZ")
                );
    }

}
