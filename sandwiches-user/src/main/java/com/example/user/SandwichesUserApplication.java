package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SandwichesUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SandwichesUserApplication.class, args);
    }

    @Bean
    public PasswordHasher passwordHasher() {
        return new DummyPasswordHasher();
    }
}
