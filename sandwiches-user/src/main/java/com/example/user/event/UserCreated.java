package com.example.user.event;

import com.example.user.agreggate.User;

public record UserCreated(String userId,
                          String name,
                          String email,
                          String hashedPassword) {
    public UserCreated(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
