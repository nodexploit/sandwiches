package com.example.invoice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrderDeletionConsumer {

    @KafkaListener(topics = "users-deleted", groupId = "order-group")
    public void handleMessage(UserDeletedEvent event) {
        log.info("Event {}", event);
    }
}
