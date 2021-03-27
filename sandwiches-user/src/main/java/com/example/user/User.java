package com.example.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
public class User extends AbstractAggregateRoot<User> {
    @Id
    private String id;
    private String name;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String email;

    public User makeOrder(String orderName) {
        return andEvent((UserMadeOrderEvent.of(orderName, getId())));
    }
}
