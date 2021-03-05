package com.example.user;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserDeletedEvent {
    String userId;
}
