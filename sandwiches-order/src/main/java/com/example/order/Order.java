package com.example.order;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Document("orders")
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
public class Order {
    @Id
    String id;
    String name;
    String userId;
}
