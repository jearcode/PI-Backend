package com.luxevision.backend.dto;

import lombok.Data;

@Data
public class SaveUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatedPassword;

}
