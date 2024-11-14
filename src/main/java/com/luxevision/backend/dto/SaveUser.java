package com.luxevision.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveUser {

    @NotNull(message = "First name cannot be null.")
    @NotBlank(message = "First name cannot be empty.")
    private String firstName;

    @NotNull(message = "Last name cannot be null.")
    @NotBlank(message = "Last name cannot be empty.")
    private String lastName;

    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    @NotNull(message = "Repeated password cannot be null.")
    @NotBlank(message = "Repeated password cannot be empty.")
    private String repeatedPassword;
}
