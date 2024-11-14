package com.luxevision.backend.dto.auth;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserUpdateRequest {

    @NotNull(message = "The field 'id' has not been defined")
    private Long id;

    @NotNull(message = "The field 'firstName' has not been defined")
    @NotBlank(message = "The field 'firstName' must contain a valid value")
    @NotEmpty(message = "The field 'firstName' must not be empty")
    private String firstName;

    @NotNull(message = "The field 'lastName' has not been defined")
    @NotBlank(message = "The field 'lastName' must contain a valid value")
    @NotEmpty(message = "The field 'lastName' must not be empty")
    private String lastName;

    @NotNull(message = "The field 'email' has not been defined")
    @NotBlank(message = "The field 'email' must contain a valid value")
    @NotEmpty(message = "The field 'email' must not be empty")
    @Email(message = "Please provide a valid email address.")
    private String email;

    private String password;

}
