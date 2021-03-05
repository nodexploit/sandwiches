package com.example.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@AllArgsConstructor
@RepositoryEventHandler
public class UserRepositoryEventHandler {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @HandleAfterDelete
    public void handleUserAfterDelete(User user) {
        log.info("Inside User After Delete...");
        kafkaTemplate.send("", objectMapper.writeValueAsString(UserDeletedEvent.of(user.getId())));
    }
}
