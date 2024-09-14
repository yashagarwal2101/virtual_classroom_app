package com.ksolves.vitrual_classromm_backend.service;

import com.ksolves.vitrual_classromm_backend.dto.user.UserRequest;
import com.ksolves.vitrual_classromm_backend.dto.user.UserResponse;
import com.ksolves.vitrual_classromm_backend.dto.user.UserSignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface UserService {
    UserResponse userLogin(UserRequest userRequest);

    UserResponse userSignup(UserSignupRequest userRequest);
}
