package com.example.user;

import com.example.user.command.UserCreation;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CommandGateway commandGateway;

    public UserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public Mono<String> create(@RequestBody UserCreation userCreation) {
        var userCreationWithId = new UserCreation(
                UUID.randomUUID().toString(),
                userCreation.name(),
                userCreation.email(),
                userCreation.password()
        );
        return Mono.fromFuture(commandGateway.send(userCreationWithId))
                .map(id -> {
                    if (id instanceof String userId) {
                        return userId;
                    } else {
                        return "ERROR";
                    }
                });
    }
}
