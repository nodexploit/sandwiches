package com.example.user;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Value
@Builder(toBuilder = true)
public class UserCreationRequest {
    @NotBlank
    String name;
    @Email
    @NotBlank
    @Deprecated
    String email;
    String nuevoEmail;
}
