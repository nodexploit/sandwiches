package com.example.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ErrorResponse {
    String code;
    String message;
}
