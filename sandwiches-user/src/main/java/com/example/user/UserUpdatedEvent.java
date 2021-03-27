package com.example.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Value
@Builder(toBuilder = true)
@Document("users-updated")
@EqualsAndHashCode(of = "id")
@JsonDeserialize(builder = UserUpdatedEvent.UserUpdatedEventBuilder.class)
public class UserUpdatedEvent {
    @Id
    String id;
    String userId;
    String username;
    String email;
    Instant timestamp;

    public static UserUpdatedEvent from(User user) {
        return new UserUpdatedEvent(
                new ObjectId().toString(),
                user.getId(),
                user.getName(),
                user.getEmail(),
                Instant.now()
        );
    }
}
