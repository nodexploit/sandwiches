package com.example.user;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserMadeOrderEvent {
    String name;
    String userId;
}
