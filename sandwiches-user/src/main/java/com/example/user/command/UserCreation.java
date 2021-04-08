package com.example.user.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record UserCreation(
        @JsonProperty("userId") @TargetAggregateIdentifier String userId,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password
) {
}
