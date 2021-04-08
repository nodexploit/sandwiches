package com.example.user;

import java.util.UUID;

public class DummyPasswordHasher implements PasswordHasher {
    @Override
    public String hash(String password) {
        return UUID.randomUUID().toString();
    }
}
