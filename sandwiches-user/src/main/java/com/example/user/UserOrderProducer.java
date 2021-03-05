package com.example.user;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserOrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @SneakyThrows
    @EventListener
    public void produceMakeOrder(UserMadeOrderEvent event) {
        log.info("Produce {}", event);
        kafkaTemplate.send("user-made-orders", event);
    }
}
