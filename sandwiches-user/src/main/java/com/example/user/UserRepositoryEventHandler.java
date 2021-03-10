package com.example.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@AllArgsConstructor
@RepositoryEventHandler
public class UserRepositoryEventHandler {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @HandleAfterDelete
    public void handleUserAfterDelete(User user) {
        log.info("Inside User After Delete...");
        kafkaTemplate.send("users-deleted", UserDeletedEvent.of(user.getId()));
    }
}
