package com.ksolves.vitrual_classromm_backend.dto.user;

import com.ksolves.vitrual_classromm_backend.enums.UserType;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRequest {
    @Email
    private String email;
    private String password;
    private UserType role;
}
