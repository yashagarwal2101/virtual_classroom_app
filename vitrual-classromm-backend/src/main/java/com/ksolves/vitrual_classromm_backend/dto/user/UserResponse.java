package com.ksolves.vitrual_classromm_backend.dto.user;

import com.ksolves.vitrual_classromm_backend.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String email;
    private UserType role;
}
