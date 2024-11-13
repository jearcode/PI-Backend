package com.luxevision.backend.dto.auth;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class UserViewProfileResponse implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

}
