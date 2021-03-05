package com.example.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/{id}/orders")
    public ResponseEntity<String> makeOrder(@PathVariable String id) {
        return userRepository.findById(id)
                .map(u -> u.makeOrder(UUID.randomUUID().toString()))
                .map(userRepository::save)
                .map(u -> ResponseEntity.ok("asd"))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
