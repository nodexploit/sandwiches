package com.example.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Document("users")
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
public class User extends AbstractAggregateRoot<User> {
    @Id
    //@JsonIgnore
    String id;
    String name;
    @JsonIgnore
    String email;

    public User makeOrder(String orderName) {
        return andEvent((UserMadeOrderEvent.of(orderName, getId())));
    }
}
