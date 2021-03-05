package com.example.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = UserDeletedEvent.UserDeletedEventBuilder.class)
public class UserDeletedEvent {
    String userId;
}
