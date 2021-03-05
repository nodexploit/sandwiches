package com.example.order;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrderConsumer {

    private final OrderRepository orderRepository;

    @SneakyThrows
    @KafkaListener(topics = "user-made-orders", groupId = "order-group")
    public void handleMessage(UserMadeOrderEvent event) {
        log.info("A user made an order {}", event);
        orderRepository.save(Order.builder()
                .name(event.getName())
                .userId(event.getUserId())
                .build()
        );
    }
}
