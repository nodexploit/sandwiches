package com.example.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrderDeletionConsumer {

    private final OrderRepository orderRepository;

    @KafkaListener(topics = "users-deleted", groupId = "order-group", concurrency = "1")
    public void handleMessage(UserDeletedEvent event) {
        log.info("Event {}", event);
        orderRepository.deleteAll(orderRepository.findAllByUserId(event.getUserId()));
    }
}
