package com.luxevision.backend.dto.auth;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class UserAdminView implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private LocalDateTime signupDate;
    private Boolean enabled;


}
