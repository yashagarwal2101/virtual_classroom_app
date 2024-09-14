package com.ksolves.vitrual_classromm_backend.dto.user;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String name;
    private String email;
    private String password;
}
