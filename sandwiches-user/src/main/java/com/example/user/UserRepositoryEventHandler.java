package com.example.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@RepositoryEventHandler
public class UserRepositoryEventHandler {

    private final MongoTemplate mongoTemplate;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @HandleAfterCreate
    public void handleUserAfterCreate(User user) {
        log.info("Created user {}", user.getId());
        UserCreatedEvent event = UserCreatedEvent.from(user);
        mongoTemplate.save(event);
    }

    @HandleAfterSave
    public void handleUserAfterSave(User user) {
        log.info("Updated user {}", user.getId());
        UserUpdatedEvent event = UserUpdatedEvent.from(user);
        mongoTemplate.save(event);
    }

    @HandleAfterDelete
    public void handleUserAfterDelete(User user) {
        log.info("Deleted user {}", user.getId());
        UserDeletedEvent event = UserDeletedEvent.from(user);
        mongoTemplate.save(event);
        kafkaTemplate.send("users-deleted", event);
    }
}
