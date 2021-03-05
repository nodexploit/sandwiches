package com.example.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = UserMadeOrderEvent.UserMadeOrderEventBuilder.class)
public class UserMadeOrderEvent {
    String name;
    String userId;
}
