package com.example.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserResponse {
    String id;
}
