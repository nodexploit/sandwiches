package com.example.user.agreggate;

import com.example.user.PasswordHasher;
import com.example.user.command.UserCreation;
import com.example.user.event.UserCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class User {

    @AggregateIdentifier
    private String id;
    String name;
    String email;
    String password;
    PasswordHasher passwordHasher;

    public User() {
    }

    @CommandHandler
    public void handleCreation(UserCreation command) {
        AggregateLifecycle.apply(
                new UserCreated(
                        command.userId(),
                        command.name(),
                        command.email(),
                        passwordHasher.hash(command.password())
                )
        );
    }

    @Autowired
    public void setPasswordHasher(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public PasswordHasher getPasswordHasher() {
        return passwordHasher;
    }
}
