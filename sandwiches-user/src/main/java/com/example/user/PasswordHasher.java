package com.example.user;

public interface PasswordHasher {
    String hash(String password);
}
